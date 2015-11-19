package main;

import telegramBot.*;
import java.sql.*;

public class Session {
	private int state;
	private TelegramChat user;
	private Connection db;
	
	public Session(TelegramChat user, Connection db){
		state = 0;
		this.user = user;
		this.db = db;
		if(!userExistsInDb()){
			dbExecute("INSERT INTO mineral (user_id) VALUES ("+ user.getId() +");");
		}
	}
	
	public void process(TelegramMsg msg){
		// According to the msg and/or state, commit the appropriate actions
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
