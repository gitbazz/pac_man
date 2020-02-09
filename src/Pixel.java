/**
 * Represents the data items to be stored in the binary search tree. Each item
 * consists of two parts: a location and a color
 * 
 * @author Bazillah Zargar
 */
public class Pixel {

	private Location location; // position of the pixel location
	private int color; // color of the pixel

	/**
	 * Constructor that initializes the new pixel with the specified coordinates and
	 * color
	 * 
	 * @param p     is the key for the pixel
	 * @param color is the color of the pixel
	 */
	public Pixel(Location p, int color) {
		this.location = p;
		this.color = color;
	}

	/**
	 * Returns the location of the pixel.
	 * 
	 * @return location
	 */
	public Location getLocation() {
		return this.location;
	}

	/**
	 * Returns the color of the pixel.
	 * 
	 * @return color
	 */
	public int getColor() {
		return this.color;
	}

}
