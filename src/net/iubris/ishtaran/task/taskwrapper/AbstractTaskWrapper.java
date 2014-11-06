package net.iubris.ishtaran.task.taskwrapper;

import java.lang.Thread.State;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.inject.Inject;

import net.iubris.ishtaran.task.phasable.CallState;
import net.iubris.ishtaran.task.phasable.Phasable;
import net.iubris.ishtaran.utils.printer.Printer;

public abstract class AbstractTaskWrapper<R> implements TaskWrapper {

	protected final Phasable<R> callable;
	
	@Inject
	protected Printer printer;
	
	public static int TaskWrapperThreads = 8;
	
	private ExecutorService executorService = Executors.newFixedThreadPool(TaskWrapperThreads);
	
	public AbstractTaskWrapper(Phasable<R> callable/*, Printer printer*/) {
		this.callable = callable;
//		this.printer = printer;
	}
	
	public Printer getPrinter() {
		return printer;
	}

	private void checkExecutorService() {
		if (executorService.isShutdown()) // if was previously shutdown with forceStop
			executorService = Executors.newSingleThreadExecutor();
	}
	
	@Override
	public Future<CallState> start() throws InterruptedException, ExecutionException  {
		checkExecutorService();
		Future<CallState> submitted = executorService.submit(callable);
//System.out.println(this.getClass().getSimpleName()+": submitted = "+submitted);
		return submitted;
	}
	
	@Override
	public void postStart() throws Exception {
//		callable.persist();
	}
	
	@Override
	public CallState stop() {
		callable.stop();
		executorService.shutdown();
		/*try {
			executorService.awaitTermination(500, TimeUnit.MILLISECONDS);
			executorService.shutdownNow();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		while(!executorService.isTerminated()) {
			new Runnable() {
				@Override
				public void run() {
					printer.print("\r");
				}
			}.run();
		}
		printer.println("");
		
		if (executorService.isTerminated()) {
			List<Runnable> shutdownNowList = executorService.shutdownNow();
			while(shutdownNowList.size()!=0) {
				shutdownNowList = executorService.shutdownNow();
				try {
					checkStillAliveThreads();
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
//		callable.persist();
		return CallState.INTERRUPTED;
	}
	
	@Override
	public void postStop() throws Exception {
//		callable.partialCommit();
//		callable.persist();
//		printer.println("post-stop");
	}
	
	
	private void checkStillAliveThreads() {
		Set<Thread> allThreads = Thread.getAllStackTraces().keySet();
		Iterator<Thread> iterator = allThreads.iterator();
		int howManyLiving = allThreads.size();
		while (iterator.hasNext()) {
			Thread thread = iterator.next();
			if (!thread.getName().contains("ForkJoinPool")) {
				howManyLiving--;
//				printer.println("not forkjoin, decrementing to:" +howManyLiving);
				continue;
			}

			if (thread.getState().equals(State.RUNNABLE)) {
//				printer.println(thread + "" + thread.getState());
				thread.interrupt();
			}
			// again lives?! I hope no
//			if (!thread.getState().equals(State.RUNNABLE)) {
			if (thread.isInterrupted()) {
//				printer.println(thread + "" + thread.getState());
				howManyLiving--;
//				printer.println("interrupted, decrementing to: "+howManyLiving);
			}

			if (!iterator.hasNext() && howManyLiving > 0) {
//				printer.println("again " + howManyLiving);
				iterator = allThreads.iterator();
			}
		}
	}	
}
