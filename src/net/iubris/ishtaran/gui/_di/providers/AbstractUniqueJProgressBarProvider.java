package net.iubris.ishtaran.gui._di.providers;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.swing.JProgressBar;


public abstract class AbstractUniqueJProgressBarProvider implements Provider<JProgressBar> {
	
	private final JProgressBar jProgressBar;

	@Inject
	public AbstractUniqueJProgressBarProvider(JProgressBar jProgressBar) {
		jProgressBar.setMinimum(0);
		jProgressBar.setStringPainted(true);
		
		this.jProgressBar = jProgressBar;
	}

	@Override
	public JProgressBar get() {
		return jProgressBar;
	}
}
