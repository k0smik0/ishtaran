package net.iubris.ishtaran.gui._di.providers;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.swing.JTextArea;

@Singleton
public class UniqueJTextAreaProvider implements Provider<JTextArea> {
	
	private final JTextArea jTextArea;

	@Inject
	public UniqueJTextAreaProvider(JTextArea jTextArea) {
		this.jTextArea = jTextArea;
		this.jTextArea.setAutoscrolls(true);
		
		this.jTextArea.setLineWrap(true);
		this.jTextArea.setWrapStyleWord(true);
		
//		RXTextUtilities.centerLineInScrollPane(jTextArea);
	}

	@Override
	public JTextArea get() {
		return jTextArea;
	}

}
