package net.iubris.ishtaran.gui._di.providers;

import javax.inject.Provider;

import net.iubris.ishtaran.gui.actionevents.handler.CommandActionEventsHandler;

public interface CommandActionEventsHandlerProvider extends Provider<CommandActionEventsHandler> {

//	private final CommandActionEventsHandler commandActionEventsHandler;

//	@Inject
//	public CommandActionEventsHandlerProvider(StemButtonCommandActionEvent stemButtonCommandActionEvent, 
//			MultigraphsButtonCommandActionEvent multigraphsButtonCommandActionEvent,
//			MiningButtonCommandActionEvent miningButtonCommandActionEvent 
//			) {
//		commandActionEventsHandler = new CommandActionEventsHandler(
//				stemButtonCommandActionEvent, 
//				multigraphsButtonCommandActionEvent,
//				miningButtonCommandActionEvent
//				);
//	}
//	
//	@Override
//	public CommandActionEventsHandler get() {
//		return commandActionEventsHandler;
//	}
}
