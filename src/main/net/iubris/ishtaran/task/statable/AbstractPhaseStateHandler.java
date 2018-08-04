package net.iubris.ishtaran.task.statable;

public abstract class AbstractPhaseStateHandler implements PhaseStateHandler {

	protected PhaseStateMemento phaseStateMemento;
	protected boolean completedOrFirstRun;
	
	protected final void initMemento(PhaseStateMemento phaseStateMemento) {
		this.phaseStateMemento = phaseStateMemento;
	}

	@Override
	public boolean isExistant(String value) {
		return phaseStateMemento.contains(value);
	}

	@Override
	public PhaseStateMemento getMemento() {
		return phaseStateMemento;
	}

	@Override
	public void save(String fileName) {
System.out.print("saving "+fileName);
		phaseStateMemento.getValues().add(fileName);
		saveMemento(phaseStateMemento);
	}
	
	protected abstract void saveMemento(PhaseStateMemento phaseStateMemento);
	
	protected void setCompleted(boolean completed) {
		completedOrFirstRun = completed;
	}

	@Override
	public boolean isCompletedOrFirstRun() {
		return completedOrFirstRun;
	}


}
