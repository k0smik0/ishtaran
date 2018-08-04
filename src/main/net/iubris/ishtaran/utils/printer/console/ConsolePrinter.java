/*******************************************************************************
 * Copyleft (c) 2014, "Massimiliano Leone - <maximilianus@gmail.com> - https://plus.google.com/+MassimilianoLeone"
 * This file (ConsolePrinter.java) is part of WordsRelatorByBabelnet.
 * 
 *     ConsolePrinter.java is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     ConsolePrinter.java is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 * 
 *     You should have received a copy of the GNU General Public License
 *     along with .  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package net.iubris.ishtaran.utils.printer.console;

import net.iubris.ishtaran.utils.printer.Printer;

public class ConsolePrinter implements Printer {
	
	@Override
	public void print(Object string) {
		System.out.print(""+string);
	}
	
	@Override
	public void println(Object string) {
		System.out.println(""+string);
	}

}
