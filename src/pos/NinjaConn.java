package pos;

import java.sql.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class NinjaConn {

    private Connection conn;
    protected Statement stmt;
    private String sqlText;
    private ResultSet rSet;
    
    //generic constructor
    public NinjaConn() {
    	
    	try {
    	    	
    		conn = DriverManager.getConnection("jdbc:sqlite:NinjaDB.db");
    	   	stmt = conn.createStatement();
    	   	sqlText = "";
    	
    	} catch (Exception ex) {
    		
    		System.out.println("Fail!");
    		conn = null;
    		stmt = null;
    		sqlText = null;
    	}
    	
    } //end generic constructor
    
    public ResultSet quID(int id, String table) {
    	try {
    		
    		sqlText = "SELECT * FROM " + table + " WHERE ID=" + id;
    		return stmt.executeQuery(sqlText);
    	
    	} catch (Exception ex) {
    		
    		System.out.println("Fetch fail!  " + ex.getLocalizedMessage() );
    		return null;
    		
    	}
    }
    
    public ResultSet quName(String name, String table) {
    	try {
  
    		sqlText = "SELECT * FROM " + table + " WHERE NAME=\"" + name + "\"";
    		return stmt.executeQuery(sqlText);
    	
    	} catch (Exception ex) {
    		
    		System.out.println("Fetch fail!  " + ex.getLocalizedMessage() );
    		return null;
    		
    	}
    }
    
    public ResultSet quUname(String uname, String table) {
    	try {
                sqlText = "SELECT * FROM " + table + " WHERE USERNAME=\"" + uname + "\"";
                return stmt.executeQuery(sqlText);
                
    	} catch (Exception exc) {
    		System.out.println("quUname fail: " + exc.toString() );
    		return null;
    	}
    }
    
    public ResultSet quGetAll(String table) {
    	try {
    	
    		sqlText = "SELECT * FROM " + table;
    		return stmt.executeQuery(sqlText);
    	
    	} catch (Exception ex) {
    		
    		System.out.println("Get All fail!");
    		return null;
    		
    	}
    }
    
    public void updateDBDouble(String table, String field, double newVal, int IDnum) {
    	try {
    		sqlText = "UPDATE " + table + " SET " + field + "=" + newVal + " WHERE ID=" + IDnum;
    		stmt.executeUpdate(sqlText);
    		
    	} catch (Exception ex) {
    		System.out.println("Update fail!  " + ex.getLocalizedMessage() );
    	}
    }
    
    public void updateDBInt(String table, String field, int newVal, int IDnum) {
    	try {
    		sqlText = "UPDATE " + table + " SET " + field + "=" + newVal + " WHERE ID=" + IDnum;
    		stmt.executeUpdate(sqlText);
    		
    	} catch (Exception ex) {
    		System.out.println("Update fail!  " + ex.getLocalizedMessage() );
    	}
    }
    
    public void updateDBString(String table, String field, String newVal, int IDnum) {
    	try {
    		sqlText = "UPDATE " + table + " SET " + field + "=\"" + newVal + "\" WHERE ID=" + IDnum;
    		stmt.executeUpdate(sqlText);
    		
    	} catch (Exception ex) {
    		System.out.println("Update fail!  " + ex.getLocalizedMessage() );
    	}
    }
    
    public void addRowInventory(String name, int quantity, double price, String description, int discount, String imgFile) {
    	try {
    		sqlText = "INSERT INTO tbINVENTORY VALUES(NULL, \"" + name + "\", " + quantity + ", " + price +  ", \"" + description +  "\", " + discount +  ", \"" + imgFile + "\")";
    		stmt.executeUpdate(sqlText);
    	} catch (Exception ex) {
    		System.out.println("Insert new row fail! " + ex.toString() );
    	}
    }
    
    public void addRowCustomers(String name, int quantity, double price, String description, int discount, String imgFile) {
    	try {
    		sqlText = "INSERT INTO tbCUSTOMERS VALUES(NULL, \"" + name + "\", " + price + ", \"" + description +  "\", " + discount +  ", \"" + imgFile + "\")";
    		stmt.executeUpdate(sqlText);
    	} catch (Exception ex) {
    		System.out.println("Insert new row fail! " + ex.toString() );
    	}
    }
    
    public void addRowSales(Double amount, String items, String customer) {
        try {
    		sqlText = "INSERT INTO tbSALES VALUES(NULL, " + amount + ", \"" + items +  "\", " + customer + "\")";
    		stmt.executeUpdate(sqlText);
    	} catch (Exception ex) {
    		System.out.println("Insert new row fail! " + ex.toString() );
    	}
    }
    
    public void addRowUsers(String input) {
        sqlText = "INSERT INTO tbUSERS VALUES(NULL," + input + ")";
    }
    
    
    public void rmRowInventory(int IDnum) {
    	try {
    		sqlText = "DELETE FROM tbINVENTORY WHERE ID=" + IDnum;
    		stmt.executeUpdate(sqlText);
    	} catch (Exception ex) {
    		System.out.println("Remove inventory row fail! " + ex.toString() );
    	}
    }
    
    public void rmRowCustomers(int IDnum) {
    	try {
    		sqlText = "DELETE FROM tbCUSTOMERS WHERE ID=" + IDnum;
    		stmt.executeUpdate(sqlText);
    	} catch (Exception ex) {
    		System.out.println("Remove customers row fail! " + ex.toString() );
    	}
    }
    
    public void rmRowSales(int IDnum) {
        try {
    		sqlText = "DELETE FROM tbSALES WHERE ID=" + IDnum;
    		stmt.executeUpdate(sqlText);
    	} catch (Exception ex) {
    		System.out.println("Remove sales row fail! " + ex.toString() );
    	}
    }
    
    /*DO NOT USE THE BELOW METHOD!!!!!!!
    * IT IS STIL EXPERIMENTAL!!
    */ 
    public String getDPW(String name) {
    	
    	//AES with GCM: much stronger encryption but DOES NOT WORK YET
    	rSet = quName(name, "tbUsers");
    	
    	try {
    	
    		Cipher ciph = Cipher.getInstance("AES/GCM/PKCS5Padding");
    		System.out.println("Got ciph.");
    		byte[] keyBytes = hexToByteArr(rSet.getString("P1") );
    		System.out.println("Got the key_string: " + rSet.getString("P1") + "\n" + Arrays.toString(keyBytes) );
    		SecretKey sKeySpec = new SecretKeySpec(keyBytes, "AES");
    		System.out.println("Got the SK.");
    		ciph.init(Cipher.DECRYPT_MODE, sKeySpec, ciph.getParameters() );
    		System.out.println("Cipher init OK.");
    			
    		byte[] dpwi = hexToByteArr(rSet.getString("P2") );
    		System.out.println("Got the ciphertext_string: " + rSet.getString("P2") + "\n" + Arrays.toString(dpwi) );
    		ciph.update(dpwi);
    		System.out.println("Passed dpwi_bytes to ciph.");
    		byte[] dpw = ciph.doFinal();
    		System.out.println("DC OK.");
			String dePW = new String(dpw);
			System.out.println("String OK.");
			
			System.out.print("Decrypted pw= ");
			System.out.println(dePW);
			
			return dePW;
			
    	} catch (Exception exc) {
    		System.out.println("Decryption Error!! " + exc.toString() );
    		return null;
    	}
    	
    }
    
    public byte[] hexToByteArr(String hex) {
		
		byte[] result = new byte[hex.length()/2];
		int pos;
		int intermed;
		
		for (int i=0; i < result.length; i++) {
			pos = i*2;
			intermed = Integer.parseInt(hex.substring(pos, pos+2), 16);
			result[i] = (byte)intermed;
		}
		
		return result;
		
	}
    
    public String getAndD(String uname) {
    	
    	//get user info
    	rSet = quUname(uname, "tbUsers");
    	
    	try {
    		
    		Key dk = new SecretKeySpec(hexToByteArr(rSet.getString("P1")), "DESede");
    		byte[] dkb = dk.getEncoded();
    		//check dkb
    		//System.out.println("retrieved dkb= " + Arrays.toString(dkb) );
    		
    		Cipher ciph = Cipher.getInstance("DESede");
    		ciph.init(Cipher.DECRYPT_MODE, dk);
    		
    		byte[] eBytes = hexToByteArr(rSet.getString("P2") );
    		//check eBytes
    		//System.out.println("retrieved ebytes= " + Arrays.toString(eBytes) );
    		
    		byte[] dBytes = ciph.doFinal(eBytes);
    		
    		//return the decrypted string
    		return new String(dBytes);
    		
    	} catch (Exception exc) {
    		System.out.println("getAndD fail: " + exc.toString() );
    		//it didn't work: return nothing
    		return null;
    	}
    	
    }
    
    public Boolean eAndStore(String name, String inp) {
    	
    	//get the user info
    	rSet = quName(name, "tbUsers");
    	
    	//here we go
    	try {
    		
    		Key dk = KeyGenerator.getInstance("DESede").generateKey();
    		byte[] dkb = dk.getEncoded();
    		
    		//check dkb
    		//System.out.println("generated dkb= " + Arrays.toString(dkb) );
    		
    		Cipher ciph = Cipher.getInstance("DESede");
			ciph.init(Cipher.ENCRYPT_MODE, dk);
			byte[] eBytes = ciph.doFinal(inp.getBytes() );
			
			//check eBytes
			//System.out.println("generated ebytes= " + Arrays.toString(eBytes) );
    		
			
    		sqlText = "UPDATE tbUsers SET P1=\'" + bytesToHex(dkb) + "\', P2=\'" + bytesToHex(eBytes) + "\' WHERE ID=" + rSet.getString("ID");
    		//check the sqlText
    		//System.out.println("sqlText= " + sqlText);
    		//do the sql
    		stmt.executeUpdate(sqlText);
    		
    		//it worked
    		return true;
    		
    	} catch (Exception exc) {
    		System.out.println("eAndStore Error: " + exc.toString() );
    		//it didn't work
    		return false;
    	}
    	
    }
    
    public String bytesToHex(byte[] bytes) {
    		
    		int hex=0;
    		StringBuffer sBuff = new StringBuffer(bytes.length * 2);
    		for (int i=0; i<bytes.length; i++) {
    			hex = bytes[i] & 0xff;
    			if (hex < 16) {
    				sBuff.append(0);
    			}
    			sBuff.append(Integer.toHexString(hex));
    			
    		}
    		
    		return sBuff.toString();
    		
    }
    
    //returns true if checked password is equal to decrypted password
    public Boolean checkAccess(String pw, String uname) {
    	if (pw.equals(getAndD(uname)) ) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public void close() {
        
        try {
            
            conn.close();
            
        } catch (Exception exc) {
            
            System.out.println("Close fail! " + exc.toString() );
            
        }
        
        
    }
    
    
} //end class