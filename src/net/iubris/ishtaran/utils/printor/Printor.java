package net.iubris.ishtaran.utils.printor;

import javax.inject.Inject;

import net.iubris.ishtaran.gui.printer.jtextarea.JTextAreaPrinter;
import net.iubris.ishtaran.utils.printer.console.ConsolePrinter;


public interface Printor {
	
	public void print(String string);
	public void println(String string);
	
	public static class Gui implements Printor {
		@Inject JTextAreaPrinter printer;

		@Override
		public void print(String string) {
			printer.print(string);
		}
		@Override
		public void println(String string) {
			printer.println(string);
		}
		
	}	
	public static class Console implements Printor {
		@Inject ConsolePrinter printer;

		@Override
		public void print(String string) {
			printer.print(string);
		}
		@Override
		public void println(String string) {
			printer.println(string);
		}
	}
}
