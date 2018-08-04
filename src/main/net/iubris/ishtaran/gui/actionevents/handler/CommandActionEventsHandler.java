package net.iubris.ishtaran.gui.actionevents.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.inject.Singleton;
import javax.swing.JButton;

import net.iubris.ishtaran.gui.actionevents.base.ActionCommand;
import net.iubris.ishtaran.gui.actionevents.base.ButtonCommandActionEvent;

public class CommandActionEventsHandler {
	
	// flyweight - gof uses static field way
	@Singleton
	private final Map<JButton,ActionCommand> actioncommandMap = new LinkedHashMap<>();
	
	
	private final ActionListener clickListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				actioncommandMap.get( actionEvent.getSource() ).execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};
	
	public CommandActionEventsHandler(ButtonCommandActionEvent... commandActionEvents) {
		for (ButtonCommandActionEvent commandActionEvent: commandActionEvents) {
			bindButtonToCommand(commandActionEvent);
		}
	}
	
	private void bindButtonToCommand(ButtonCommandActionEvent commandActionEvent) {
		JButton button = commandActionEvent.getButton();
		button.addActionListener(clickListener);
		actioncommandMap.put(button, commandActionEvent);
		commandActionEvent.setAllButtons( getButtons() );
	}
	
	public Set<JButton> getButtons() {
		return actioncommandMap.keySet();
	}
}
