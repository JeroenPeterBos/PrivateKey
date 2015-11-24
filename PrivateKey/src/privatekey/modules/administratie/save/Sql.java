package privatekey.modules.administratie.save;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import privatekey.modules.administratie.elements.Account;
import privatekey.modules.administratie.elements.Group;
import privatekey.modules.administratie.elements.Service;

public class Sql {
	private static final String CLASS = Sql.class.getSimpleName();

	// ------------------------------- Enumerations ------------------------------------ //
	
	// ------------------------------- Instance Variables ------------------------------ //
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private String sql;
	
	// ------------------------------- Constructors ------------------------------------ //
	
	public Sql(){
		conn = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      conn = DriverManager.getConnection("jdbc:sqlite:res\\keys.db");
	      conn.setAutoCommit(true);
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	}

	// ------------------------------- Commands ---------------------------------------- //

	public void add(Group group){
		try {
			stmt = conn.createStatement();
			
			sql = "INSERT INTO Groups (name, no_services) "
					+ "VALUES ('" + group.getName() + "', " + group.getNoServices() + ");";
			
			stmt.executeUpdate(sql);
			
			sql = "SELECT group_id FROM Groups WHERE name='" + group.getName() + "'";
			rs = stmt.executeQuery( sql );
			
			group.setId(rs.getInt("group_id"));
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
		}
		
		System.out.println(CLASS + ".add(): added group to database");
	}

	public void add(Service service){
		try {
			stmt = conn.createStatement();
			
			sql = "INSERT INTO Services (group_id, name, no_accounts) "
					+ "VALUES (" + service.getGroup().getId() + ", '" + service.getName() + "', " + service.getNoAccounts() + ");";
			
			stmt.executeUpdate(sql);
			
			sql = "SELECT service_id FROM Services WHERE group_id = " + service.getGroup().getId() + " AND name='" + service.getName() + "'";
			
			rs = stmt.executeQuery( sql );
			service.setId(rs.getInt("service_id"));
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
		}
		
		System.out.println(CLASS + ".add(): added service to database");
	}

	public void add(Account account){
		try {
			stmt = conn.createStatement();
			
			sql = "INSERT INTO Accounts (service_id, username, passCipher) "
					+ "VALUES (" + account.getService().getId() + ", '" + account.getName() + "', " + account.getPassCipher() + ");";
			
			stmt.executeUpdate(sql);
			
			sql = "SELECT account_id FROM Accounts WHERE service_id = " + account.getService().getId() + " AND username='" + account.getName() + "'";
			
			rs = stmt.executeQuery( sql );
			account.setId(rs.getInt("account_id"));
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
		}
		
		System.out.println(CLASS + ".add(): added account to database");
	}

	public void edit(Group oldGroup, Group newGroup){
		
	}
	
	public void edit(Service oldService, Service newService){
		
	}
	
	public void edit(Account oldAccount, Account newAccount){
		
	}
	
	public void remove(Group group){
		
	}
	
	public void remove(Service service){
		
	}
	
	public void remove(Account account){
		
	}
	
	public void close(){
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	// ------------------------------- Queries ----------------------------------------- //
	
	public ArrayList<Group> getGroups(){
		ArrayList<Group> result = new ArrayList<Group>();
		
		try {
			stmt = conn.createStatement();
			
			sql = "SELECT * FROM Groups;";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				result.add(new Group(rs.getInt("group_id"), rs.getString("name"), rs.getInt("no_services")));
			}
			
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
		}
		System.out.println(CLASS + ".getGroups(): received groups from database");
		
		return result;
	}
	
	public Service[] getServices(Group group){
		return null;
	}
	
	public Account[] getAccounts(Service service){
		return null;
	}
	
	// -------------------------------- Dev Methods ------------------------------------ //
	
	public static void main(String[] args){		
		Sql s = new Sql();
		s.clear();
		
		Group g = new Group("email", 0);
		s.add(g);
		
		Service ser = new Service(g, "protonmail", 0);
		s.add(ser);
		
		Account acc = new Account(ser, "JeroenProton", 2385677);
		s.add(acc);
		
		Group gr = new Group("webwinkel", 0);
		s.add(gr);

		
		Service serv = new Service(g, "bol.com", 0);
		s.add(serv);
		
		Account acco = new Account(ser, "JeroenBos", 2385677);
		s.add(acco);
		
		ArrayList<Group> groups = s.getGroups();
		
		for(int i = 0; i < groups.size(); i++){
			System.out.println(groups.get(i).getName() + groups.get(i).getId() + groups.get(i).getNoServices());
		}
		
		s.close();
	}
	
	public void clear(){
		try {
			stmt = conn.createStatement();
			
			sql = "DROP TABLE IF EXISTS 'Accounts';";
			stmt.executeUpdate(sql);
			sql = "DROP TABLE IF EXISTS 'Groups';";
			stmt.executeUpdate(sql);
			sql = "DROP TABLE IF EXISTS 'Services';";
			stmt.executeUpdate(sql);
			
			sql = "CREATE TABLE Accounts (account_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, service_id INTEGER NOT NULL, username TEXT NOT NULL, passCipher INTEGER NOT NULL);";
			stmt.executeUpdate(sql);
			sql = "CREATE TABLE Groups ( group_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, name TEXT NOT NULL, no_services INTEGER NOT NULL);";
			stmt.executeUpdate(sql);
			sql = "CREATE TABLE Services ( service_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, group_id INTEGER NOT NULL, name INTEGER NOT NULL, no_accounts INTEGER);";
			stmt.executeUpdate(sql);
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
