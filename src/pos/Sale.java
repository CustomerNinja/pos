/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import java.sql.ResultSet;
import java.util.Date;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author JTS
 */
public class Sale {

    private int id;
    private String date;
    private Double value;
    private String customerName;
    private final String table = "tbSALES";
    private NinjaConn njc;
    private ResultSet rset;
    
    private SimpleStringProperty idP;
    private SimpleStringProperty dateP;
    private SimpleStringProperty valueP;
    private SimpleStringProperty customerNameP;
    
    public Sale(int id) {
		
		this.id = id;
		this.njc = new NinjaConn();
		rset = null;
                
		try {
		
		rset = njc.quID(this.id, this.table);
		date = rset.getString("date");
		value = rset.getDouble("value");		
		customerName = rset.getString("customer");
		
                idP = new SimpleStringProperty(Integer.toString(this.id));
                dateP = new SimpleStringProperty(date);
                valueP = new SimpleStringProperty(Double.toString(value));
                customerNameP = new SimpleStringProperty(customerName);
                
		} catch (Exception ex) {
			System.out.println("Sale Construct Fail!  " + ex.getLocalizedMessage() );
		} finally {
                    njc.close();
                }
		
	}

    public String getIdP() {
        return idP.get();
    }
    
    public String getDateP() {
        return dateP.get();
    }
    
    public String getValueP() {
        return valueP.get();
    }

    public String getCustomerNameP() {
        return customerNameP.get();
    }



    
}
