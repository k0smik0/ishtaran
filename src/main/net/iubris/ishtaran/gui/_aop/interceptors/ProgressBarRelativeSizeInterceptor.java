package net.iubris.ishtaran.gui._aop.interceptors;

import javax.swing.JProgressBar;

import net.iubris.ishtaran.gui._di.annotations.ProgressBarRelative;

public class ProgressBarRelativeSizeInterceptor extends AbstractProgressBarSizeInterceptor {

//	@ProgressBarGlobal JProgressBar jProgressBar;
	
//	@Inject
	public ProgressBarRelativeSizeInterceptor(@ProgressBarRelative JProgressBar jProgressBar) {
		super(jProgressBar);
	}
}
