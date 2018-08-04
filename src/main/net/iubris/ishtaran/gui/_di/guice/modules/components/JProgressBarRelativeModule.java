package net.iubris.ishtaran.gui._di.guice.modules.components;

import javax.swing.JProgressBar;

import net.iubris.ishtaran.gui._di.annotations.ProgressBarRelative;
import net.iubris.ishtaran.gui._di.providers.UniqueJProgressBarRelativeProvider;

import com.google.inject.AbstractModule;

public class JProgressBarRelativeModule extends AbstractModule {
	
	@Override
	protected void configure() {
		bind(JProgressBar.class).annotatedWith(ProgressBarRelative.class).toProvider(UniqueJProgressBarRelativeProvider.class);
	}
}
