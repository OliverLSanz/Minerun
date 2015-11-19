package main;


import java.util.HashMap;
import telegramBot.*;

public class Minerun {
	
	
	public static void main(String[] args){
		final String BOTID = "";
		TelegramBot bot = new TelegramBot(BOTID);
		HashMap<Integer, Session> currentSessions = new HashMap<Integer, Session>();
		TelegramMsg msg;
		
		while(true){
			while((msg = bot.nextMsg(0)) == null);
			if(!currentSessions.containsKey(msg.getChat().getId())){
				currentSessions.put(msg.getChat().getId(), new Session(msg.getChat()));
			}
			currentSessions.get(msg.getChat().getId()).process(msg);
		}
	}
}
