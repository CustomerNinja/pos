package pos;

import java.sql.ResultSet;

public class Customer {

	private int id;
	private String name;
	private String address;
	private int salesNum;
	private double salesVal;
	private NinjaConn njc;
	private ResultSet rset;
	private final String table = "tbCustomers";
	
	public Customer(int id, NinjaConn njc) {
		
		this.id = id;
		this.njc = njc;
		rset = null;
		//get the other data
		
		try {
		
		rset = njc.quID(this.id, "tbCustomers");
		name = rset.getString("name");
		address = rset.getString("address");
		salesNum = rset.getInt("sales");		
		salesVal = rset.getDouble("sales_val");
		
		} catch (Exception ex) {
			System.out.println("Customer Construct Fail!  " + ex.getLocalizedMessage() );
		}
		
	}
	
	public Customer(String name, NinjaConn njc) {
		
		this.name = name;
		this.njc = njc;
		
		//get the other data
		try {
		
		rset = njc.quName(this.name, "tbCustomers");
		id = rset.getInt("id");
		address = rset.getString("address");
		salesNum = rset.getInt("sales");		
		salesVal = rset.getDouble("sales_val");
		
		} catch (Exception ex) {
			System.out.println("Customer Construct Fail!  " + ex.getLocalizedMessage() );
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
	
}