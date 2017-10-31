package pos;
import java.sql.ResultSet;

public class Item {

	private int id;
	private String name;
	private int quantity;
	private double price;
	private String description;
	private int onSale;
	private NinjaConn njc;
	private ResultSet rset;
	private final String table = "tbInventory";
	
public Item(int id, NinjaConn njc) {
		
		this.id = id;
		this.njc = njc;
		rset = null;
		//get the other data
		
		try {
		
		rset = njc.quID(this.id, this.table);
		name = rset.getString("name");
		quantity = rset.getInt("quantity");
		price = rset.getDouble("price");
		description = rset.getString("description");

		
		} catch (Exception ex) {
			System.out.println("Item Construct Fail!  " + ex.getLocalizedMessage() );
		}
		
	}
	
	public Item(String name, NinjaConn njc) {
		
		this.name = name;
		this.njc = njc;
		
		//get the other data
		try {
		
		rset = njc.quName(this.name, this.table);
		id = rset.getInt("id");
		quantity = rset.getInt("quantity");
		price = rset.getDouble("price");
		description = rset.getString("description");

		
		} catch (Exception ex) {
			System.out.println("Item Construct Fail!  " + ex.getLocalizedMessage() );
		}
		
	}
	
	
	protected int getID() {
		
		return id;
		
	}
	
	protected String getName() {
		
		return name;
		
	}
	
	protected int getQuantity() {
		
		return quantity;
		
	}
	
	protected double getPrice() {
		
		return price;
		
	}
	
	protected String getDescription() {
		
		return description;
		
	}
	
	protected int getOnSale() {
		
		return onSale;
		
	}

	protected void setName(String newName) {
		
		name = newName;
		njc.updateDBString(this.table, "name", newName, this.id);
		
	}

	protected void setQuantity(int newQuantity) {
		
		quantity = newQuantity;
		njc.updateDBInt(this.table, "quantity", newQuantity, this.id);
		
	}

	protected void setPrice(double newPrice) {
		
		price = newPrice;
		njc.updateDBDouble(this.table, "price", newPrice, this.id);
		
	}
	
	protected void setOnSale(int newOnSale) {
		
		onSale = newOnSale;
		njc.updateDBInt(this.table, "sale_item", newOnSale, this.id);
		
	}
	
	protected void setDescription(String newDescription) {
		
		description = newDescription;
		njc.updateDBString(this.table, "description", newDescription, this.id);
		
	}
	
} //end Item class