package net.iubris.ishtaran.gui._di.guice.modules;

import net.iubris.ishtaran.gui.actionevents.handler.CommandActionEventsHandler;

public class IshtaranModuleTest extends AbstractIshtaranModule {

	@Override
	protected void bindCommandActionEventsHandlerToProvider() {
		bind(CommandActionEventsHandler.class).toProvider(CommandActionEventsHandlerProviderTest.class);
	}

	/*@Override
	protected void configure() {
		install( new JTextAreaPrinterModule() );

		install( new JLabelRelativeModule() );
		install( new JProgressBarRelativeModule() );
		
		install( new JLabelGlobalModule() );
		install( new JProgressBarGlobalModule() );
	}*/

}
