package main;

import telegramBotApi.*;
import java.util.HashMap;

public class Minerun {
	final String BOTID = "";
	
	public static void main(String[] args){
		TelegramBot bot = new TelegramBot(BOTID);
		HashMap currentSessions = new HashMap();
		TelegramMsg msg;
		
		while(true){
			while( !(msg = bot.nextMsg(0)) );
			if(!currentSessions.containsKey(msg.getChat().getId())){
				// Crear la sesion y añadirla al mapa
			}
			// Enviar el mensaje a la sesion.
		}
	}
}
