package net.iubris.ishtaran.gui.printer.jtextarea;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JTextArea;

import net.iubris.ishtaran.gui._di.annotations.UniqueJTextArea;
import net.iubris.ishtaran.utils.printer.Printer;

@Singleton
public class JTextAreaPrinter implements Printer {
	
	private final JTextArea jTextArea;
	
//	Stack<String> queue = new Stack<>();

	@Inject
	public JTextAreaPrinter(@UniqueJTextArea JTextArea jTextArea) {
		this.jTextArea = jTextArea;
		this.jTextArea.setAutoscrolls(true);
	}

	@Override
	public void print(Object string) {
//		printViaQueue(""+string);
		jTextArea.append(""+string);
	}
	

	@Override
	public void println(Object string) {
		jTextArea.append(""+string+"\n");
//		printViaQueue(string+"\n");
	}
	
	
	/*private void printViaQueue(Object string) {
		if (queue.size()==0)
			jTextArea.append(""+string);
		else 
			queue.push(""+string);
		
		if(queue.size()==5) {
			System.out.println("5!!!");
			jTextArea.append( queue.pop() );
		}
			
	}*/
}
