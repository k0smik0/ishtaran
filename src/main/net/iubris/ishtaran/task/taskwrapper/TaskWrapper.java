package net.iubris.ishtaran.task.taskwrapper;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import net.iubris.ishtaran.task.phasable.CallState;


public interface TaskWrapper {
	Future<CallState> start() throws InterruptedException, ExecutionException;
	void postStart() throws Exception;
	CallState stop();
	void postStop() throws Exception;
}
