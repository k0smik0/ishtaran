package net.iubris.ishtaran.utils.printer.console._di.guice.module;

import net.iubris.ishtaran.utils.printer.Printer;
import net.iubris.ishtaran.utils.printer.console.ConsolePrinter;

import com.google.inject.AbstractModule;

public class ConsolePrinterModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Printer.class).to(ConsolePrinter.class);
	}
}
