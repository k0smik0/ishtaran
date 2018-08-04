package net.iubris.ishtaran.gui._di.providers;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JLabel;

@Singleton
public class UniqueJLabelRelativeProvider extends AbstractUniqueJLabelProvider {
	
	@Inject
	public UniqueJLabelRelativeProvider(JLabel jLabel) {
		super(jLabel);
	}

}
