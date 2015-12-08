package privatekey.modules.administratie.sql;

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
	    System.out.println(CLASS + ".constructor(): Opened database successfully");
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

	public void edit(int id, Group newGroup){
		try {
			stmt = conn.createStatement();
			
			sql = "UPDATE Groups SET name = '" + newGroup.getName() + "', no_services = " + newGroup.getNoServices() + " WHERE group_id = " + id + ";";
			
			stmt.executeUpdate(sql);
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
		}
		
		System.out.println(CLASS + ".edit(): edited group in database");
	}
	
	public void edit(int id, Service newService){
		try {
			stmt = conn.createStatement();
			
			sql = "UPDATE Services SET group_id = " + newService.getGroup().getId() + " name = '" + newService.getName() + "', no_accounts = " + newService.getNoAccounts() + " WHERE service_id = " + id + ";";
			
			stmt.executeUpdate(sql);
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
		}
		
		System.out.println(CLASS + ".edit(): edited service in database");
	}
	
	public void edit(int id, Account newAccount){
		try {
			stmt = conn.createStatement();
			
			sql = "UPDATE Accounts SET service_id = " + newAccount.getService().getId() + ", username = '" + newAccount.getName() + "', passCipher = " + newAccount.getPassCipher() + " WHERE account_id = " + id + ";";
			
			stmt.executeUpdate(sql);
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
		}
		
		System.out.println(CLASS + ".edit(): edited account in database");
	}
	
	public void remove(Group group){
		try {
			stmt = conn.createStatement();
			
			sql = "DELETE FROM Groups WHERE group_id == " + group.getId() + ";";
			
			stmt.executeUpdate(sql);
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
		}
		
		System.out.println(CLASS + ".remove(): removed group from database");
	}
	
	public void remove(Service service){
		try {
			stmt = conn.createStatement();
			
			sql = "DELETE FROM Services WHERE service_id == " + service.getId() + ";";
			
			stmt.executeUpdate(sql);
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
		}
		
		System.out.println(CLASS + ".remove(): removed service from database");
	}
	
	public void remove(Account account){
		try {
			stmt = conn.createStatement();
			
			sql = "DELETE FROM Accounts WHERE account_id == " + account.getId() + ";";
			
			stmt.executeUpdate(sql);
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
		}
		
		System.out.println(CLASS + ".remove(): removed account from database");
	}
	
	public void close(){
		try {
			stmt.close();
			conn.close();
			
			System.out.println(CLASS + ".close(): Closed sql Connection");
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
			rs.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
		}
		System.out.println(CLASS + ".getGroups(): received groups from database");
		return result;
	}
	
	public ArrayList<Service> getServices(Group group){
		ArrayList<Service> result = new ArrayList<Service>();
		
		try {
			stmt = conn.createStatement();
			
			sql = "SELECT * FROM Services WHERE group_id == " + group.getId() + ";";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				result.add(new Service(rs.getInt("service_id"), group, rs.getString("name"), rs.getInt("no_accounts")));
			}
			rs.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
		}
		System.out.println(CLASS + ".getServices(): received services from database");
		
		return result;
	}
	
	public ArrayList<Account> getAccounts(Service service){
		ArrayList<Account> result = new ArrayList<Account>();
		
		try {
			stmt = conn.createStatement();
			
			sql = "SELECT * FROM Accounts WHERE service_id == " + service.getId() + ";";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				result.add(new Account(rs.getInt("account_id"), service, rs.getString("username"), rs.getInt("passCipher")));
			}
			rs.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
		}
		System.out.println(CLASS + ".getAccounts(): received accounts from database");
		
		return result;
	}
	
	// -------------------------------- Dev Methods ------------------------------------ //
	
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
