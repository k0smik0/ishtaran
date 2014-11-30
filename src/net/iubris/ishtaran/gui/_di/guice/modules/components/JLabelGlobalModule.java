package net.iubris.ishtaran.gui._di.guice.modules.components;

import javax.swing.JLabel;

import net.iubris.ishtaran.gui._di.annotations.JLabelGlobal;
import net.iubris.ishtaran.gui._di.providers.UniqueJLabelGlobalProvider;

import com.google.inject.AbstractModule;

public class JLabelGlobalModule extends AbstractModule {
	
	@Override
	protected void configure() {
		bind(JLabel.class).annotatedWith(JLabelGlobal.class).toProvider(UniqueJLabelGlobalProvider.class);
	}
}
