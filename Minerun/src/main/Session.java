package main;

import telegramBot.*;

public class Session {
	private int state;
	private TelegramChat user;
	
	public Session(TelegramChat user){
		state = 0;
		this.user = user;
	}
	
	public void process(TelegramMsg msg){
		// According to the msg and/or state, commit the appropriate actions
	}

}
