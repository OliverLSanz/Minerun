package contexts;

public abstract class SpaceSector extends Context {
	/**
	 * When the sector is scanned, some mineral can be made visible.
	 * It returns the quantity of minerals apparently made visible.
	 * 
	 * @return the minerals made visible by scanning the sector.
	 */
	abstract int scan();

	/**
	 * The sector is tried to be mined, and it returns the amount of
	 * minerals successfully mined.
	 * 
	 * @return the minerals successfully mined.
	 */
	abstract int mine();
	
	/**
	 * Returns true if the sector can be mined, false otherwise.
	 * 
	 * @return 	{@code true} if the sector can be mined.
	 * 			{@code false} otherwise.
	 */
	abstract boolean isMinable();
}
