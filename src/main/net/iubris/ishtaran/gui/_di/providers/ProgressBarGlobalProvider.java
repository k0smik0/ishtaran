package net.iubris.ishtaran.gui._di.providers;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JProgressBar;

@Singleton
public class ProgressBarGlobalProvider extends AbstractUniqueJProgressBarProvider {
	
	@Inject
	public ProgressBarGlobalProvider(JProgressBar jProgressBar) {
		super(jProgressBar);
	}

}
