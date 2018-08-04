package net.iubris.ishtaran.task.partialable;

public interface Partialable<R> {
//	void partialCommit() throws Exception;
	/**
	 * return business model instance after manipulation - it could be a partial result 
	 * @return
	 */
	R getResult();
}
