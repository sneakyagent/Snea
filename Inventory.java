import java.util.ArrayList;

public class Inventory extends Items
{
	private ArrayList<Items> items = new ArrayList<Items>();

	/**
	 * @return the items
	 */
	public ArrayList<Items> getItems( )
	{
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems( ArrayList<Items> items )
	{
		this.items = items;
	}
	
	public void addItem(Items itemName)
	{
	items.add ( itemName );
	}
	
	
	
}
