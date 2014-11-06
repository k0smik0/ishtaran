package net.iubris.ishtaran.gui._aop.interceptors;

import javax.swing.JProgressBar;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public abstract class AbstractProgressBarSizeInterceptor implements MethodInterceptor {
	
	protected final JProgressBar jProgressBar;
	
	public AbstractProgressBarSizeInterceptor(JProgressBar jProgressBar) {
		this.jProgressBar = jProgressBar;
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
      Object result = invocation.proceed();
      
      jProgressBar.setMaximum((int) result);
      
      return result;
	}

}
