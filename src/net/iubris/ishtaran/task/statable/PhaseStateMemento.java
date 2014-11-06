package net.iubris.ishtaran.task.statable;

import java.util.Set;

public interface PhaseStateMemento {

	public Set<String> getValues();
	
	public boolean contains(String value);
	
}
