package main;

import telegramBotApi.*;
import java.sql.*;
import java.util.ArrayList;

import contexts.*;

public class Session {
	private TelegramBot bot;
	private TelegramChat user;
	private Connection db;
	private Context context;
	
	public Session(TelegramBot bot, TelegramChat user, Connection db){
		this.bot = bot;
		this.user = user;
		this.db = db;
		if(!userExistsInDb()){
			dbExecute("INSERT INTO mineral (user_id) VALUES ("+ user.getId() +");");
		}
		context = new BaseStation();
	}
	
	public void process(TelegramMsg msg){
		ArrayList<TelegramSMsg> smsgs;
		
		context.process(msg);
		if((smsgs = context.messagesToSend()) != null)
			bot.sendMessages(smsgs);
	}
	
	private void dbExecute(String querry){
		try {
			db.createStatement().execute(querry);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private ResultSet dbExecuteQuerry(String querry){
		try {
			return db.createStatement().executeQuery(querry);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	private boolean userExistsInDb(){
		try {
			return dbExecuteQuerry("SELECT " + user.getId() + " FROM mineral;").next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
