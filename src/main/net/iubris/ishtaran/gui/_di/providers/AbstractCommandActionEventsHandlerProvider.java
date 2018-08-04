package net.iubris.ishtaran.gui._di.providers;

import net.iubris.ishtaran.gui.actionevents.base.ButtonCommandActionEvent;
import net.iubris.ishtaran.gui.actionevents.handler.CommandActionEventsHandler;

public abstract class AbstractCommandActionEventsHandlerProvider implements CommandActionEventsHandlerProvider {

	private final CommandActionEventsHandler commandActionEventsHandler;
	
	public AbstractCommandActionEventsHandlerProvider(ButtonCommandActionEvent... buttonCommandActionEvents) {
		this.commandActionEventsHandler = new CommandActionEventsHandler(buttonCommandActionEvents);
	}
	
	@Override
	public CommandActionEventsHandler get() {
		return commandActionEventsHandler;
	}
}
