package net.iubris.ishtaran.gui._di.guice.modules;


import java.util.Set;

import javax.swing.JButton;

import net.iubris.ishtaran.gui._di.annotations.GUIButtons;
import net.iubris.ishtaran.gui._di.guice.modules.components.JLabelGlobalModule;
import net.iubris.ishtaran.gui._di.guice.modules.components.JLabelRelativeModule;
import net.iubris.ishtaran.gui._di.guice.modules.components.JProgressBarGlobalModule;
import net.iubris.ishtaran.gui._di.guice.modules.components.JProgressBarRelativeModule;
import net.iubris.ishtaran.gui._di.guice.modules.components.JTextAreaPrinterModule;
import net.iubris.ishtaran.gui._di.providers.GUIButtonsProvider;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

public abstract class AbstractIshtaranModule extends AbstractModule {

	@Override
	protected void configure() {
		
		bindCommandActionEventsHandlerToProvider();

		install( new JTextAreaPrinterModule() );

		install( new JLabelRelativeModule() );
		install( new JProgressBarRelativeModule() );
		
		install( new JLabelGlobalModule() );
		install( new JProgressBarGlobalModule() );
		
//		install( new InterceptorModule() );
		
		// bind GuiButtons
		bind(new TypeLiteral<Set<JButton>>() {}).annotatedWith(GUIButtons.class).toProvider(GUIButtonsProvider.class);
	}
	
	protected abstract void bindCommandActionEventsHandlerToProvider();
}
