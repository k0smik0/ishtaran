package net.iubris.ishtaran.gui.actionevents.base;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.swing.SwingWorker;

import net.iubris.ishtaran.task.phasable.CallState;
import net.iubris.ishtaran.task.taskwrapper.TaskWrapper;
import net.iubris.ishtaran.utils.printer.Printer;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

public class StartbuttonSwingworker extends SwingWorker<Void, Void> {
	
//	@Inject
	private final Printer printer;
	private final TaskWrapper taskWrapper;
	private final ButtonCommandActionEvent buttonCommandActionEvent;

	
	@AssistedInject
//	@Inject
	public StartbuttonSwingworker(
			@Assisted
			TaskWrapper taskWrapper, 
			@Assisted
			ButtonCommandActionEvent buttonCommandActionEvent
			, Printer printer
			) {
		this.taskWrapper = taskWrapper;
		this.buttonCommandActionEvent = buttonCommandActionEvent;
		this.printer = printer;
	}

	@Override
	protected Void doInBackground() throws Exception {
		try {
			Future<CallState> future = taskWrapper.start();
			CallState callState = future.get();
			// we arrive here if task ends fine
			switch (callState) {
			case COMPLETED:
				buttonCommandActionEvent.actPostStart();
				break;
			case INTERRUPTED:
				buttonCommandActionEvent.resetButtons();
				break;
			case INTERNAL_ERROR:
				printer.println(callState);
				break;
			default:
				break;
			}

		} catch (InterruptedException | ExecutionException e) {
			// e.printStackTrace();
		}
		return null;
	}
	
	public static interface Factory {
		public StartbuttonSwingworker create(TaskWrapper taskWrapper, 
				ButtonCommandActionEvent buttonCommandActionEvent);
	}
}
