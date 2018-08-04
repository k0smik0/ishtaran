package net.iubris.ishtaran.gui._di.guice.modules.components;

import javax.swing.JProgressBar;

import net.iubris.ishtaran.gui._di.annotations.ProgressBarGlobal;
import net.iubris.ishtaran.gui._di.providers.ProgressBarGlobalProvider;

import com.google.inject.AbstractModule;

public class JProgressBarGlobalModule extends AbstractModule {
	
	@Override
	protected void configure() {
		bind(JProgressBar.class).annotatedWith(ProgressBarGlobal.class).toProvider(ProgressBarGlobalProvider.class);
	}
}
