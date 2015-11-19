package main;

import java.util.HashMap;
import telegramBot.*;
import java.sql.*;

public class Minerun {

	public static void main(String[] args) {
		try {
			final String URL = "", USER = "", PASS = "";
			Connection connection = DriverManager.getConnection(URL, USER, PASS);

			final String BOTID = "";
			TelegramBot bot = new TelegramBot(BOTID);
			HashMap<Integer, Session> currentSessions = new HashMap<Integer, Session>();
			TelegramMsg msg;

			while (true) {
				while ((msg = bot.nextMsg(0)) == null)
					;
				if (!currentSessions.containsKey(msg.getChat().getId())) {
					currentSessions.put(msg.getChat().getId(), new Session(msg.getChat(), connection));
				}
				currentSessions.get(msg.getChat().getId()).process(msg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
