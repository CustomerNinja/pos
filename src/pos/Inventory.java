package pos;

import java.sql.*;
import java.util.LinkedList;

public class Inventory {
	
    private final String table = "tbInventory";
    //private NinjaConn njc;
    private ResultSet rSet;
    protected LinkedList<Item> itemList;
    private int[] idList;
    private int rows;
    
        protected NinjaConn getNinjaConn(){
            NinjaConn njc = new NinjaConn();
            return njc;
        }
    
	protected Inventory(NinjaConn njc) {
		//this.njc = njc;
		itemList = new LinkedList<Item>();
		rows = 0;
		try {
			rSet = njc.quGetAll(this.table);
            	while (rSet.next() ) {
            		rows++;
                }
            	System.out.println("rows= " + rows);
            	idList = new int[rows];
            	rSet = njc.quGetAll(this.table);
            	rSet.next();
            	for (int i=0; i<rows; i++) {
            		idList[i] = rSet.getInt("id");
            		rSet.next();
            		
            	}
            	//System.out.println(Arrays.toString(idList) );
            	for (int i=0; i<rows; i++) {
            		itemList.add(new Item(idList[i]) );
            	}

		} catch (Exception exc) {
			System.out.println("Inventory Construct fail! " + exc.toString() );
		}
                njc.close();

	}
	
        public void print(){
            
        }
        
	protected void addNewItem(String item_title, int item_quantity, double price, String description, int discount, String image_filename) {
            NinjaConn njc = this.getNinjaConn();
            njc.addRowInventory(item_title, item_quantity, price, description, discount, image_filename);
            refreshInventory();
	}
	
        protected void rmItem(int id) {
            NinjaConn njc = this.getNinjaConn();
            njc.rmRowInventory(id);
            refreshInventory();
            njc.close();

        }
        
	protected LinkedList<Item> getItemList() {
		return itemList;
	}
	
        protected void refreshInventory() {
                NinjaConn njc = this.getNinjaConn();
                itemList = new LinkedList<Item>();
		rows = 0;
		//System.out.println("got njc");
		try {
			rSet = njc.quGetAll(this.table);
			//System.out.println("got rSet");
            	while (rSet.next() ) {
            		rows++;
                }
            	System.out.println("rows= " + rows);
            	idList = new int[rows];
            	rSet = njc.quGetAll(this.table);
            	rSet.next();
            	for (int i=0; i<rows; i++) {
            		idList[i] = rSet.getInt("id");
            		rSet.next();
            		
            	}
            	//System.out.println(Arrays.toString(idList) );
            	for (int i=0; i<rows; i++) {
            		itemList.add(new Item(idList[i]) );
            	}

		} catch (Exception exc) {
			System.out.println("Inventory Refresh fail! " + exc.toString() );
		}
                njc.close();

        }
	
}