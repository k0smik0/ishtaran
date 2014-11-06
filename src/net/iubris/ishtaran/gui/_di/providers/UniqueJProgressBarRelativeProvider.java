package net.iubris.ishtaran.gui._di.providers;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JProgressBar;

@Singleton
public class UniqueJProgressBarRelativeProvider extends AbstractUniqueJProgressBarProvider {
	
//	private final JProgressBar jProgressBar;

	@Inject
	public UniqueJProgressBarRelativeProvider(JProgressBar jProgressBar) {
		/*		jProgressBar.setMinimum(0);
		jProgressBar.setStringPainted(true);
		
		this.jProgressBar = jProgressBar;*/
		super(jProgressBar);
	}

//	@Override
//	public JProgressBar get() {
//		return jProgressBar;
//	}
}
