
public class Items
{
	private String itemName;
	private int dmg;
	/**
	 * @return the itemName
	 */
	public String getItemName( )
	{
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName( String itemName )
	{
		this.itemName = itemName;
	}
	/**
	 * @return the dmg
	 */
	public int getDmg( )
	{
		return dmg;
	}
	/**
	 * @param dmg the dmg to set
	 */
	public void setDmg( int dmg )
	{
		this.dmg = dmg;
	}
	public Items(String itemName, int dmg)
	{
		super ( );
		this.itemName = itemName;
		this.dmg = dmg;
	}
	
	public Items()
	{
		super ( );
		this.itemName = null;
		this.dmg = -1;
	}
	
	

}
