package net.iubris.ishtaran.gui.frame;

import javax.inject.Inject;

import net.iubris.ishtaran.gui._di.guice.modules.IshtaranModuleTest;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiFrameTest {
	
	private GUIFrame guiFrame;



//	JTextArea textArea;
//	JLabel jLabelGlobal;
//	JLabel jLabelRelative;
//	JProgressBar progressbarGlobal;
//	JProgressBar progressbarRelative;

	@Inject
	public GuiFrameTest(
//			@JTextAreaGlobal JTextArea textArea,
//	@JLabelGlobal JLabel jLabelGlobal,
//	@JLabelRelative JLabel jLabelRelative,
//	@ProgressBarGlobal JProgressBar progressbarGlobal,
//	@ProgressBarRelative JProgressBar progressbarRelative
			GUIFrame guiFrame
	) {
		this.guiFrame = guiFrame;
//		this.textArea = textArea;
//		this.jLabelGlobal = jLabelGlobal;
//		this.jLabelRelative = jLabelRelative;
//		this.progressbarGlobal = progressbarGlobal;
//		this.progressbarRelative = progressbarRelative;
		
//		new GUIFrame(null, textArea, jLabelRelative, progressbarRelative, jLabelGlobal, progressbarGlobal);
	}

	public static void main(String[] args) {
		Injector injector = Guice.createInjector( new IshtaranModuleTest() );
		
//		new GUIFrame(null, 
//				injector.getInstance(arg0)
//				null , null, null, null, null);
		
		GuiFrameTest guiFrameTest = injector.getInstance(GuiFrameTest.class);
		guiFrameTest.guiFrame.show();
	}
}
