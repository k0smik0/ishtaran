package net.iubris.ishtaran.gui._aop.interceptors;

import javax.swing.JProgressBar;

import net.iubris.ishtaran.gui._di.annotations.ProgressBarGlobal;

public class ProgressBarGlobalSizeInterceptor extends AbstractProgressBarSizeInterceptor {

	public ProgressBarGlobalSizeInterceptor(@ProgressBarGlobal JProgressBar jProgressBar) {
		super(jProgressBar);
	}
	
}
