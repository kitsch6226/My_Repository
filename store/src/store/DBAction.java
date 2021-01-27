package store;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBAction {
	private static DBAction instance = new DBAction();
	private Connection conn;
	private DataSource ds;
	
	public DBAction() {
		try {
			InitialContext initctx = new InitialContext();
			ds = (DataSource)initctx.lookup("java:/comp/env/jdbc/mysql");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		try {
			conn = ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static DBAction getInstance() {
		if(instance==null)
			instance = new DBAction();
		return instance;
	}
}
