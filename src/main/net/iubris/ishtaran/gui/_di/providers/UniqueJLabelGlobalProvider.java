package net.iubris.ishtaran.gui._di.providers;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JLabel;

@Singleton
public class UniqueJLabelGlobalProvider extends AbstractUniqueJLabelProvider {

	@Inject
	public UniqueJLabelGlobalProvider(JLabel jLabel) {
		super(jLabel);
	}
}
