package pos;

import java.sql.ResultSet;
import javafx.beans.property.SimpleStringProperty;

public class Customer {

	private int id;
	private String name;
	private String address;
	private int salesNum;
	private double salesVal;
	private NinjaConn njc;
	private ResultSet rset;
	private final String table = "tbCustomers";
        
        private SimpleStringProperty idP;
        private SimpleStringProperty nameP;
        private SimpleStringProperty addressP;
        private SimpleStringProperty salesNumP;
        private SimpleStringProperty salesValP;
        
	
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
		
                idP = new SimpleStringProperty(Integer.toString(this.id));
                nameP = new SimpleStringProperty(name);
                addressP = new SimpleStringProperty(address);
                salesNumP = new SimpleStringProperty(Integer.toString(salesNum));
                salesValP = new SimpleStringProperty(Double.toString(salesVal));
                
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
                
                idP = new SimpleStringProperty(Integer.toString(id));
                nameP = new SimpleStringProperty(this.name);
                addressP = new SimpleStringProperty(address);
                salesNumP = new SimpleStringProperty(Integer.toString(salesNum));
                salesValP = new SimpleStringProperty(Double.toString(salesVal));
                
		
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
        
        public String getIdP() {
            return idP.get();
        }
        
        public String getNameP() {
            return nameP.get();
        }
	
        public String getAddressP() {
            return addressP.get();
        }
        
        public String getSalesNumP() {
            return salesNumP.get();
        }
        
        public String getSalesValP() {
            return salesValP.get();
        }
        
}//end Customer class