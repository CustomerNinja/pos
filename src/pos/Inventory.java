package pos;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
//import java.util.Arrays;

public class Inventory {
	
    private final String table = "tbInventory";
    private NinjaConn njc;
    private ResultSet rSet;
    protected LinkedList<Item> itemList;
    private int[] idList;
    private int rows;
    
	public Inventory(NinjaConn njc) {
		this.njc = njc;
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
            		itemList.add(new Item(idList[i], njc) );
            	}

		} catch (Exception exc) {
			System.out.println("Inventory Consstruct fail! " + exc.toString() );
		}
	}
	
	public void addNewItem(String name, int quantity, double price, String description, int discount, String imgFile) {
            njc.addRowInventory(name, quantity, price, description, discount, imgFile);
            refreshInventory();
	}
	
        public void rmItem(int id) {
            njc.rmRowInventory(id);
            refreshInventory();
        }
        
	public LinkedList<Item> getItemList() {
		return itemList;
	}
	
        protected void refreshInventory() {
                
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
            		itemList.add(new Item(idList[i], njc) );
            	}

		} catch (Exception exc) {
			System.out.println("Inventory Refresh fail! " + exc.toString() );
		}
        }
	
}