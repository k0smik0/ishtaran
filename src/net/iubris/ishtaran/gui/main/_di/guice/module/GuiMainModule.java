package net.iubris.ishtaran.gui.main._di.guice.module;

import net.iubris.ishtaran.gui._di.guice.modules.AbstractGUIModule;

import com.google.inject.AbstractModule;

public class GuiMainModule extends AbstractModule {

	@Override
	protected void configure() {
//		install( new ConfigModule() );
//		
//		install( new CoresModule() );
//
//		install( new PersisterModuleByBerkeleyDB() );
		
		install( new AbstractGUIModule() );
	}

}
