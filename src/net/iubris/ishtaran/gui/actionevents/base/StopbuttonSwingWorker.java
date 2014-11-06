package net.iubris.ishtaran.gui.actionevents.base;

import javax.swing.SwingWorker;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

import net.iubris.ishtaran.task.taskwrapper.TaskWrapper;
import net.iubris.ishtaran.utils.printer.Printer;

public class StopbuttonSwingWorker extends SwingWorker<Void, Void> {
	
	private final TaskWrapper taskWrapper;
	private final Printer printer;
	
	@AssistedInject
	public StopbuttonSwingWorker(@Assisted TaskWrapper taskWrapper, Printer printer) {
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
		public StopbuttonSwingWorker create(TaskWrapper taskWrapper);
	}
}
