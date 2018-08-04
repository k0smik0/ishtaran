package net.iubris.ishtaran.task.statable;

import java.util.Set;

//@Entity
public class PhaseStateMementoConcrete implements PhaseStateMemento {

//	@PrimaryKey
	/*(sequence="id")*/
	protected long id;
	protected Set<String> values;
	
	public PhaseStateMementoConcrete() {}
	
	public PhaseStateMementoConcrete(long id, Set<String> values) {
		this.values = values;
		this.id = id;
System.out.println(id);
	}

	public Set<String> getValues() {
		return values;
	}
	
//	public long getId() {
//		return id;
//	}
	
	public boolean contains(String value) {
		return values.contains(value);
	}
	
	@Override
	public String toString() {
		return ""+id;
	}
}
