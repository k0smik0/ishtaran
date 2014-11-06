package net.iubris.ishtaran.task.phasable;

import java.util.concurrent.Callable;

import net.iubris.ishtaran.task.partialable.Partialable;
import net.iubris.ishtaran.task.stoppable.Stoppable;

public interface Phasable<R> extends Callable<CallState>, 
	Stoppable, 
	Partialable<R> 
//	, Persistable 
{
	CallState getCallState();
}
