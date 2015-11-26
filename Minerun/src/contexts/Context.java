package contexts;

import java.util.ArrayList;
import telegramBotApi.*;

public abstract class Context {
	/**
	 * Returns a descriptive name for the context.
	 * 
	 * @return the name of the context.
	 */
	public String getName(){
		return null;
	}
	
	/**
	 * If there are messages that must be sent to the user when it
	 * reaches the context, such as a description, {@code description}
	 * will return them as a list. If there is none, it returns {@code null}.
	 * 
	 * @return the messages that describe the context, or null.
	 */
	public ArrayList<TelegramMsg> description(){
		return null;
	}
	
	/**
	 * Notifies the context that a message from the user has been recieved, 
	 * so that it can change its state (i.e., producing some messagesToSend).
	 * 
	 * @param msg the message recieved from the user.
	 */
	public abstract void process(TelegramMsg msg);
	
	/**
	 * The context may want some message to be sent by the session.
	 * The message may be fetched using this method.
	 * 
	 * @return 	the lists of messages that the context want to send, or
	 * 			{@code null} if there is none.
	 */
	public ArrayList<TelegramSMsg> messagesToSend(){
		return null;
	}
}
