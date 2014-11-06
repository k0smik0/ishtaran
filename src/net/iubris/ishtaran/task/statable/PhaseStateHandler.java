package net.iubris.ishtaran.task.statable;

public interface PhaseStateHandler {

	boolean isExistant(String value);

	PhaseStateMemento getMemento();

	void save(String value);

	void completed();

	boolean isCompletedOrFirstRun();

	void end();

//	boolean isFirstRunning();

}
