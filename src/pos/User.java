package pos;

import java.sql.ResultSet;
import java.sql.*;

public class User {
        
        private int id;
	private String name;
	private String address;
	private int salesNum;
	private double salesVal;
	private int permissions;
	private String username;
	private NinjaConn njc;
	private ResultSet rSet;
	private final String table = "tbUSERS";
	
	public User(int id, NinjaConn njc) {
			
			this.id = id;
			this.njc = njc;
			//rSet = null;
			try {
			
			rSet = njc.quID(this.id, this.table);
			name = rSet.getString("name");
			address = rSet.getString("address");
			salesNum = rSet.getInt("sales");		
			salesVal = rSet.getDouble("sales_val");
			username = rSet.getString("username");
			permissions = rSet.getInt("permissions");
			
			} catch (Exception ex) {
				System.out.println("User Construct Fail!  " + ex.toString() );
			}
			
	}
	
	public User(String uname, NinjaConn njc) {
		
		this.username = uname;
		this.njc = njc;
                //rSet = null;
		try {
			rSet = njc.quUname(this.username, this.table);
                        id = rSet.getInt("id");
                        name = rSet.getString("name");
			address = rSet.getString("address");
			salesNum = rSet.getInt("sales");		
			salesVal = rSet.getDouble("sales_val");
			username = rSet.getString("username");
			permissions = rSet.getInt("permissions");
			
			} catch (Exception ex) {
				System.out.println("User Construct Fail!  " + ex.toString() );
			}
	}
	
	protected int getID() {
		
		return id;
		
	}
	
	protected String getName() {
		
		return name;
		
	}
	
	protected String getAddress() {
		
		return address;
		
	}
	
	protected int getSalesNum() {
		
		return salesNum;
		
	}

	protected double getSalesVal() {
		
		return salesVal;
		
	}
	
	protected int getPermissions() {
		
		return permissions;
		
	}
	
	protected String getUsername() {
		
		return username;
		
	}
	
	protected void setName(String newName) {
		
		name = newName;
		njc.updateDBString(this.table, "name", newName, this.id);
		
	}

	protected void setAddress(String newAddr) {
		
		address = newAddr;
		njc.updateDBString(this.table, "address", newAddr, this.id);
		
	}

	protected void setSalesNum(int newSalesNum) {
		
		salesNum = newSalesNum;
		njc.updateDBInt(this.table, "sales", newSalesNum, this.id);
		
	}
	
	protected void setSalesVal(double newSalesVal) {
		
		salesVal = newSalesVal;
		njc.updateDBDouble(this.table, "sales_val", this.salesVal, this.id);
		
	}
	
	protected void setPermissions(int newPermissions) {
		
                if (this.permissions == 1) {
                    permissions = newPermissions;
                    njc.updateDBInt(this.table, "permissions", newPermissions, this.id);
                }
		
	}
	
	protected void setUsername(String newUsername) {
		
                if (this.permissions == 1) {
                    username = newUsername;
                    njc.updateDBString(this.table, "username", newUsername, this.id);
                }
	}
	
} //end User