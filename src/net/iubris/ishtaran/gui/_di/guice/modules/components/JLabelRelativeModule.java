package net.iubris.ishtaran.gui._di.guice.modules.components;

import javax.swing.JLabel;

import net.iubris.ishtaran.gui._di.annotations.UniqueJLabelRelative;
import net.iubris.ishtaran.gui._di.providers.UniqueJLabelRelativeProvider;

import com.google.inject.AbstractModule;

public class JLabelRelativeModule extends AbstractModule {
	
	@Override
	protected void configure() {
		bind(JLabel.class).annotatedWith(UniqueJLabelRelative.class).toProvider(UniqueJLabelRelativeProvider.class);
	}
}
