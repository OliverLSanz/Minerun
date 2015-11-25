package contexts;

public interface SpaceSector extends Context {
	/**
	 * When the sector is scanned, some mineral can be made visible.
	 * It returns the quantity of minerals apparently made visible.
	 * 
	 * @return the minerals made visible by scanning the sector.
	 */
	int scan();

	/**
	 * The sector is tried to be mined, and it returns the amount of
	 * minerals successfully mined.
	 * 
	 * @return the minerals successfully mined.
	 */
	int mine();
	
	/**
	 * Returns true if the sector can be mined, false otherwise.
	 * 
	 * @return 	{@code true} if the sector can be mined.
	 * 			{@code false} otherwise.
	 */
	boolean isMinable();
}
