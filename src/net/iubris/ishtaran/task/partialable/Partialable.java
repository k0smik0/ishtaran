package net.iubris.ishtaran.task.partialable;

public interface Partialable<R> {
//	void partialCommit() throws Exception;
	R getPartialResult();
}
