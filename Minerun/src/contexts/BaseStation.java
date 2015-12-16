package contexts;

import telegramBotApi.*;

public class BaseStation extends Dockable {
	@Override
	public void process(TelegramMsg msg) {
		if(msg.hasText() && msg.getText() == "dock")
			messagesToSend.add(
					new TelegramSMsg(msg.getChat(), "You have docked :)")
			);
		else{
			messagesToSend.add(
					new TelegramSMsg(msg.getChat(),
							"You have written: "+msg.getText())
					);
			messagesToSend.add(
					new TelegramSMsg(msg.getChat(),
							"I only understand the command: \"dock\"")
					);
		}
	}
}
