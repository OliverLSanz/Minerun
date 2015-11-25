package contexts;

public interface Context {
	/**
	 * Returns a descriptive name for the context.
	 * 
	 * @return the name of the context.
	 */
	String getName();
	
	/**
	 * The context may want some message to be sent by the session.
	 * The message may be fetched using this method.
	 * 
	 * @return 	the message that the context want to send, or 
	 * 			{@code null} if there is none.
	 */
	TelegramMsg getMessageToSend();
}
