package net.iubris.ishtaran.gui._di.providers;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.swing.JLabel;

@Singleton
public class AbstractUniqueJLabelProvider implements Provider<JLabel> {
	
	private final JLabel jLabel;

	@Inject
	public AbstractUniqueJLabelProvider(JLabel jLabel) {
		jLabel.setHorizontalTextPosition(JLabel.CENTER);
		jLabel.setHorizontalAlignment(JLabel.CENTER);
		jLabel.setText("-");
		this.jLabel = jLabel;
	}

	@Override
	public JLabel get() {
		return jLabel;
	}
}
