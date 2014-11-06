package net.iubris.ishtaran.gui._di.providers;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.swing.JButton;

import net.iubris.ishtaran.gui.actionevents.handler.CommandActionEventsHandler;

public class GUIButtonsProvider implements Provider<Set<JButton>> {

	private final Set<JButton> buttons;

	@Inject
	public GUIButtonsProvider(CommandActionEventsHandler commandActionEventsHandler) {
		buttons = commandActionEventsHandler.getButtons();
	}
	
	@Override
	public Set<JButton> get() {
		return buttons;
	}

}
