package net.iubris.ishtaran.task.phasable;


public abstract class AbstractPhasable<R> implements Phasable<R> {
	
//	protected final Printer printer;
	
	protected CallState callState;

//	public AbstractPhasable(Printer printer) {
//		this.printer = printer;
//	}
	
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
