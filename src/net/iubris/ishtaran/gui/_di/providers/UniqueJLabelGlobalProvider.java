package net.iubris.ishtaran.gui._di.providers;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JLabel;

@Singleton
public class UniqueJLabelGlobalProvider extends AbstractUniqueJLabelProvider {
	
//	private final JLabel jLabel;

	@Inject
	public UniqueJLabelGlobalProvider(JLabel jLabel) {
		/*jLabel.setHorizontalTextPosition(JLabel.CENTER);
		jLabel.setHorizontalAlignment(JLabel.CENTER);
		jLabel.setText("");
		this.jLabel = jLabel;*/
		super(jLabel);
	}

//	@Override
//	public JLabel get() {
//		return jLabel;
//	}
}
