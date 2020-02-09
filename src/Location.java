/**
 * Represents the position (x, y) of a pixel.
 * 
 * @author Bazillah Zargar
 */

public class Location {

	private int xCoord; // x coordinate of pixel
	private int yCoord; // y coordinate of pixel

	/**
	 * Constructor that initializes this location object with the specified
	 * coordinates.
	 * 
	 * @param x is the x coordinate
	 * @param y is the y coordinate
	 */
	public Location(int x, int y) {
		this.xCoord = x;
		this.yCoord = y;
	}

	/**
	 * Returns the x coordinate of this location.
	 * 
	 * @return x coordinate
	 */
	public int xCoord() {
		return this.xCoord;
	}

	/**
	 * Returns the y coordinate of this location.
	 * 
	 * @return y coordinate
	 */
	public int yCoord() {
		return this.yCoord;
	}

	/**
	 * Compares this location with p using column order
	 * 
	 * @param p is the location that this location is being compared with
	 * @return if this > p, this = p, or this < p return 1, 0 or -1 respectively
	 */
	public int compareTo(Location p) {
		int result = 0;
		if (this.xCoord > p.xCoord()) {
			result = 1;
		} else if (this.xCoord < p.xCoord()) {
			result = -1;
		} else if (this.xCoord == p.xCoord()) {
			if (this.yCoord > p.yCoord()) {
				result = 1;
			} else if (this.yCoord < p.yCoord()) {
				result = -1;
			} else if (this.yCoord == p.yCoord()) {
				result = 0;
			}
		}
		return result;
	}
}
