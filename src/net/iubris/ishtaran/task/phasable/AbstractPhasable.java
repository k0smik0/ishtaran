package net.iubris.ishtaran.task.phasable;


public abstract class AbstractPhasable<R> implements Phasable<R> {
	
	protected CallState callState;

	@Override
	public void stop() {
		callState = CallState.INTERRUPTED;
	}

	protected void setCallState(CallState callState) {
		this.callState = callState;		
	}
	
	@Override
	public CallState getCallState() {
		return callState;
	}
}
