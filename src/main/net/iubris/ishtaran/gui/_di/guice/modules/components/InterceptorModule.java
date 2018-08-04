package net.iubris.ishtaran.gui._di.guice.modules.components;

import javax.swing.JProgressBar;

import net.iubris.ishtaran.gui._aop.interceptors.ProgressBarGlobalSizeInterceptor;
import net.iubris.ishtaran.gui._aop.interceptors.ProgressBarRelativeSizeInterceptor;
import net.iubris.ishtaran.gui._di.annotations.ProgressBarGlobal;
import net.iubris.ishtaran.gui._di.annotations.ProgressBarGlobalSize;
import net.iubris.ishtaran.gui._di.annotations.ProgressBarRelative;
import net.iubris.ishtaran.gui._di.annotations.ProgressBarRelativeSize;

import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.matcher.Matchers;

public class InterceptorModule extends AbstractModule {

	@Override
	protected void configure() {

		bindInterceptor(Matchers.any(), Matchers.annotatedWith(ProgressBarGlobalSize.class), 
				new ProgressBarGlobalSizeInterceptor( getProvider(Key.get(JProgressBar.class, ProgressBarGlobal.class)).get() )
		);
		bindInterceptor(Matchers.any(), Matchers.annotatedWith(ProgressBarRelativeSize.class), 
				new ProgressBarRelativeSizeInterceptor( getProvider(Key.get(JProgressBar.class, ProgressBarRelative.class)).get() )
		);
	}

}
