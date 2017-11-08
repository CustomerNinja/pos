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
        private String imgPath;
	
public Item(int id) {
		NinjaConn njc = new NinjaConn();
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
                imgPath = rset.getString("image_file");

		
		} catch (Exception ex) {
			System.out.println("Item Construct Fail!  " + ex.getLocalizedMessage() );
		}
		njc.close();
	}
	
	public Item(String name) {
		
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
		njc.close();
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
		NinjaConn njc = new NinjaConn();	
		name = newName;
		njc.updateDBString(this.table, "name", newName, this.id);
		njc.close();	
	}

	protected void setQuantity(int newQuantity) {
		NinjaConn njc = new NinjaConn();	
		quantity = newQuantity;
		njc.updateDBInt(this.table, "quantity", newQuantity, this.id);
		njc.close();	
	}

	protected void setPrice(double newPrice) {
		
		price = newPrice;
		njc.updateDBDouble(this.table, "price", newPrice, this.id);
		njc.close();	
	}
	
	protected void setOnSale(int newOnSale) {
		NinjaConn njc = new NinjaConn();
		onSale = newOnSale;
		njc.updateDBInt(this.table, "sale_item", newOnSale, this.id);
		njc.close();

	}
	
	protected void setDescription(String newDescription) {
		NinjaConn njc = new NinjaConn();	
		description = newDescription;
		njc.updateDBString(this.table, "description", newDescription, this.id);
		njc.close();	
	}
        
        protected String getImagePath(){
            return imgPath;
        }
	
} //end Item class