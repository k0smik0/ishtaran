package net.iubris.ishtaran.gui._di.providers;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JLabel;

@Singleton
public class UniqueJLabelRelativeProvider extends AbstractUniqueJLabelProvider {
	
//	private final JLabel jLabel;

	@Inject
	public UniqueJLabelRelativeProvider(JLabel jLabel) {
		super(jLabel);
	}

//	@Override
//	public JLabel get() {
//		return jLabel;
//	}
}
