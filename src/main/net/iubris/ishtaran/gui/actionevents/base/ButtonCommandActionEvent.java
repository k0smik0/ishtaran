package net.iubris.ishtaran.gui.actionevents.base;

import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.Random;
import java.util.Set;

import javax.inject.Inject;
import javax.swing.JButton;

import com.google.inject.Guice;
import com.google.inject.Injector;

import net.iubris.ishtaran.gui._di.guice.modules.components.ButtonSwingworkerModule;
import net.iubris.ishtaran.task.phasable.CallState;
import net.iubris.ishtaran.task.taskwrapper.TaskWrapper;
import net.iubris.ishtaran.utils.printer.Printer;

public class ButtonCommandActionEvent extends ActionEvent implements ActionCommand {
	
	private static final long serialVersionUID = 7885252769771315893L;

	protected final JButton button;
	protected final String buttonText;
	
	private Collection<JButton> allFlyweightButtons;
	
	private boolean wasPressed = false;
	
	private final TaskWrapper taskWrapper;
	private final StartbuttonSwingworker startbuttonSwingWorker;
	private final StopbuttonSwingworker stopbuttonSwingWorker;
	
	protected final Printer printer;
	
	protected CallState callState;
	
	
	@Inject
	public ButtonCommandActionEvent(String buttonTextPrefix, TaskWrapper taskWrapper) {
		super(new JButton(), new Random().nextInt(), "");

		Injector buttonsInjector = Guice.createInjector( new ButtonSwingworkerModule() );
		this.startbuttonSwingWorker = buttonsInjector.getInstance(StartbuttonSwingworker.Factory.class).create(taskWrapper, this);
		this.stopbuttonSwingWorker = buttonsInjector.getInstance(StopbuttonSwingworker.Factory.class).create(taskWrapper);
		this.printer = buttonsInjector.getInstance(Printer.class);

		this.button = (JButton)super.source;
		this.buttonText = buttonTextPrefix;
		this.button.setText(buttonTextPrefix);
		this.taskWrapper = taskWrapper;
	}
	
	public JButton getButton() {
		return button;
	}
	
	@Override
	public void execute() throws Exception {
		// it was working
		if (wasPressed) {
			button.setText(buttonText);
			wasPressed = false;

			// here stop some action
			enableAllButtons();
			actWhenPressStop();			
		}
		// it was stopped
		else if (!wasPressed) {
			button.setText(buttonText+": running - press again to stop");
			wasPressed = true;
			
			// here start some action
			disableAllButtons();
			button.setEnabled(true);
			actWhenPressStart();
		}
	}

	protected void actWhenPressStart() {
		startbuttonSwingWorker.execute();
	}
	
	protected void actPostStart() throws Exception {
		taskWrapper.postStart();
		resetButtons();
	}
	
	protected void resetButtons() {
		button.setText(buttonText);
		wasPressed = false;
		enableAllButtons();
	}

	protected void actWhenPressStop() {
		stopbuttonSwingWorker.execute();
	}
	
	protected void actPostStop() throws Exception {
		
	}
	
	protected void disableAllButtons() {
		for (JButton button : allFlyweightButtons) {
			button.setEnabled(false);
		}
	}
	protected void enableAllButtons() {
		for (JButton button : allFlyweightButtons) {
			button.setEnabled(true);
		}
	}

	public void setAllButtons(Set<JButton> buttons) {
		this.allFlyweightButtons = buttons;		
	}
}
