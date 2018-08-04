package net.iubris.ishtaran.gui._di.guice.modules.components;

import net.iubris.ishtaran.gui.actionevents.base.StartbuttonSwingworker;
import net.iubris.ishtaran.gui.actionevents.base.StopbuttonSwingworker;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class ButtonSwingworkerModule extends AbstractModule {

	@Override
	protected void configure() {
		install( new JTextAreaPrinterModule() );
		
		install(new FactoryModuleBuilder().build(StartbuttonSwingworker.Factory.class));
		install(new FactoryModuleBuilder().build(StopbuttonSwingworker.Factory.class));
	}

}
