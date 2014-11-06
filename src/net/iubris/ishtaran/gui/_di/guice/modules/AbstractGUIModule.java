package net.iubris.ishtaran.gui._di.guice.modules;


import java.util.Set;

import javax.swing.JButton;

import net.iubris.ishtaran.gui._di.annotations.GUIButtons;
import net.iubris.ishtaran.gui._di.guice.modules.components.InterceptorModule;
import net.iubris.ishtaran.gui._di.guice.modules.components.JLabelGlobalModule;
import net.iubris.ishtaran.gui._di.guice.modules.components.JLabelRelativeModule;
import net.iubris.ishtaran.gui._di.guice.modules.components.JProgressBarGlobalModule;
import net.iubris.ishtaran.gui._di.guice.modules.components.JProgressBarRelativeModule;
import net.iubris.ishtaran.gui._di.guice.modules.components.JTextAreaPrinterModule;
import net.iubris.ishtaran.gui._di.providers.CommandActionEventsHandlerProvider;
import net.iubris.ishtaran.gui._di.providers.GUIButtonsProvider;
import net.iubris.ishtaran.gui.actionevents.base.StartbuttonSwingWorker;
import net.iubris.ishtaran.gui.actionevents.base.StopbuttonSwingWorker;
import net.iubris.ishtaran.gui.actionevents.handler.CommandActionEventsHandler;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public abstract class AbstractGUIModule extends AbstractModule {

	@Override
	protected void configure() {

		// TODO: restore for GUIMain
		install( new JTextAreaPrinterModule() );

		install( new JLabelRelativeModule() );
		install( new JProgressBarRelativeModule() );
		
		install( new JLabelGlobalModule() );
		install( new JProgressBarGlobalModule() );
		
		install( new InterceptorModule() );
		
//		bindGuiButtons();
		bind(CommandActionEventsHandler.class).toProvider(
//				CommandActionEventsHandlerProvider.class
				providesCommandActionEventsHandlerProviderType()
				);
		
//		bindCommandActionEventsHandler();
		bind(new TypeLiteral<Set<JButton>>() {}).annotatedWith(GUIButtons.class).toProvider(GUIButtonsProvider.class);
		
		install(new FactoryModuleBuilder()
//	     .implement(Payment.class, RealPayment.class)
	     .build(StartbuttonSwingWorker.Factory.class));
		install(new FactoryModuleBuilder()
	     .build(StopbuttonSwingWorker.Factory.class));
	}
	
	
	
	protected abstract Class<CommandActionEventsHandlerProvider> providesCommandActionEventsHandlerProviderType();
	
}
