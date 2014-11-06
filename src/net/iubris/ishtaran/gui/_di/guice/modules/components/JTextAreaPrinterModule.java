package net.iubris.ishtaran.gui._di.guice.modules.components;

import javax.swing.JTextArea;

import net.iubris.ishtaran.gui._di.annotations.UniqueJTextArea;
import net.iubris.ishtaran.gui._di.providers.UniqueJTextAreaProvider;
import net.iubris.ishtaran.gui.printer.jtextarea.JTextAreaPrinter;
import net.iubris.ishtaran.utils.printer.Printer;

import com.google.inject.AbstractModule;

public class JTextAreaPrinterModule extends AbstractModule {
	
	@Override
	protected void configure() {
		bind(JTextArea.class).annotatedWith(UniqueJTextArea.class).toProvider(UniqueJTextAreaProvider.class);
		
		// TODO restore
		bind(Printer.class).to(JTextAreaPrinter.class);
	}
}
