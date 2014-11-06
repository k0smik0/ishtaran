package net.iubris.ishtaran.gui.actionevents.base;

import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.Random;
import java.util.Set;

import javax.swing.JButton;

import net.iubris.ishtaran.task.phasable.CallState;
import net.iubris.ishtaran.task.taskwrapper.TaskWrapper;
import net.iubris.ishtaran.utils.printer.Printer;

public abstract class ButtonCommandActionEvent extends ActionEvent implements ActionCommand {
	
	private static final long serialVersionUID = 7885252769771315893L;

	private final JButton ownButton;
	private final String buttonTextPrefix;
	private Collection<JButton> allFlyweightButtons;
	
	private boolean wasPressed = false;
	
	private final TaskWrapper taskWrapper;
	private final StopbuttonSwingWorker stopbuttonSwingWorker;
	private final StartbuttonSwingWorker startbuttonSwingWorker;
	
	//no
//	protected final Printer printer;
	
	protected CallState callState;
	
	
	public ButtonCommandActionEvent(String buttonTextPrefix, TaskWrapper taskWrapper, 
			StartbuttonSwingWorker.Factory startbuttonSwingworkerFactory,
			StopbuttonSwingWorker.Factory stopbuttonSwingworkerFactory,
			Printer printer) {
		super(new JButton(), new Random().nextInt(), "");
		this.startbuttonSwingWorker = 
//				new StartbuttonSwingworker(StartbuttonSwingworker.Factory. taskWrapper, this, printer);
				startbuttonSwingworkerFactory.create(taskWrapper, this);
		this.stopbuttonSwingWorker = 
//				new StopbuttonSwingWorker(taskWrapper, printer);
				stopbuttonSwingworkerFactory.create(taskWrapper);
			
//		this.printer = printer;
		this.ownButton = (JButton)super.source;
		this.buttonTextPrefix = buttonTextPrefix;
		this.ownButton.setText(buttonTextPrefix);
		this.taskWrapper = taskWrapper;
	}
	
	public JButton getButton() {
		return ownButton;
	}
	
	@Override
	public void execute() throws Exception {
		if (wasPressed) {
			ownButton.setText(buttonTextPrefix);
			wasPressed = false;

			// here stop some action and commit
			enableAllButtons();
			actWhenPressStop();			
		} else if (!wasPressed) {
			ownButton.setText(buttonTextPrefix+": running - press again to stop");
			wasPressed = true;
			
			// here start some action
			disableAllButtons();
			ownButton.setEnabled(true);
			actWhenPressStart();
		}
	}

	protected void actWhenPressStart() {
		startbuttonSwingWorker.execute();
	}
	
	void actPostStart() throws Exception {
		taskWrapper.postStart();
		resetButtons();
	}
	
	void resetButtons() {
		ownButton.setText(buttonTextPrefix);
		wasPressed = false;
		enableAllButtons();
	}

	protected void actWhenPressStop() {
		stopbuttonSwingWorker.execute();
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
