package net.iubris.ishtaran.gui.actionevents.base;

import javax.swing.SwingWorker;

import net.iubris.ishtaran.task.taskwrapper.TaskWrapper;
import net.iubris.ishtaran.utils.printer.Printer;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

public class StopbuttonSwingworker extends SwingWorker<Void, Void> {
	
	private final TaskWrapper taskWrapper;
	
//	@Inject
	private final Printer printer;
	
	@AssistedInject
//	@Inject
	public StopbuttonSwingworker(
			@Assisted 
			TaskWrapper taskWrapper
			, Printer printer
			) {
		this.taskWrapper = taskWrapper;
		this.printer = printer;
	}

	@Override
	protected Void doInBackground() throws Exception {
		taskWrapper.stop();
		return null;
	}
	protected void done() {
		printer.println(".");
	}
	
	public static interface Factory {
		public StopbuttonSwingworker create(TaskWrapper taskWrapper);
	}
}
