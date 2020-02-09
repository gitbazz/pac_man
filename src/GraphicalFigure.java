/**
 * Represents a graphical figure.
 * 
 * @author Bazillah Zargar
 */
public class GraphicalFigure implements GraphicalFigureADT {

	private int id; // identifier of this figure
	private int width; // width of the enclosing rectangle for this figure
	private int height; // height of the enclosing rectangle for this figure
	private String type; // type of this figure. can be "fixed" (fixed figure), "user" (moved by the
							// user), "computer" (moved by the computer, or "target" (target figure)
	private Location pos; // the offset of the figure
	private BinarySearchTree bst; // the binary search tree which stores the pixels of this figure

	/**
	 * Constructor that creates an empty Binary search tree where the pixels of the
	 * figure will be stored
	 * 
	 * @param id     is the figure id
	 * @param width  is the figure width
	 * @param height is the figure height
	 * @param type   is the figure type
	 * @param pos    is the offset of the figure
	 */
	public GraphicalFigure(int id, int width, int height, String type, Location pos) {
		this.id = id;
		this.width = width;
		this.height = height;
		this.type = type;
		this.pos = pos;
		this.bst = new BinarySearchTree();
	}

	/**
	 * Sets the type of this figure to the specified value.
	 * 
	 * @param type is the specified type of this figure.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Returns the width of the enclosing rectangle for this figure.
	 * 
	 * @param width of the enclosing rectangle.
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Returns the height of the enclosing rectangle for this figure.
	 * 
	 * @param height of the enclosing rectangle.
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * Returns the type of this figure.
	 * 
	 * @param type of figure.
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Returns the id of this figure.
	 * 
	 * @param id of figure.
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Returns the offset of this figure.
	 * 
	 * @param offset of figure.
	 */
	public Location getOffset() {
		return this.pos;
	}

	/**
	 * Changes the offset of this figure to the specified value.
	 * 
	 * @param value is the new offset the figure.
	 */
	public void setOffset(Location value) {
		this.pos = value;
	}

	/**
	 * Inserts a pixel into the binary search tree that is associated with this
	 * figure. Throws a DuplicatedKeyException if an error occurs when inserting the
	 * Pixel into the tree.
	 * 
	 * @param pix is the Pixel to be inserted into the tree.
	 */
	public void addPixel(Pixel pix) throws DuplicatedKeyException {
		try {
			bst.put(bst.getRoot(), pix);
		} catch (Exception e) {
			throw new DuplicatedKeyException("A node in the BST for this figure already stores the same key");
		}
	}

	/**
	 * Helper method. Returns true if the figure has a pixel in the specified
	 * location and returns false otherwise.
	 * 
	 * @param p is the specified location.
	 * @return true if the figure has a pixel in the specified location and false
	 *         otherwise.
	 */
	private boolean findPixel(Location p) {
		Pixel found = bst.get(bst.getRoot(), p);
		if (found != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns true if this figure intersects the one specified in the parameter and
	 * returns false otherwise.
	 * 
	 * @param obj is the figure being tested for intersection
	 * @return true if this figure intersects the one specified and false otherwise.
	 */
	public boolean intersects(GraphicalFigure obj) {
		if (intersectsHelper(obj)) {
			try {
				Location largest = bst.largest(bst.getRoot()).getLocation();

				for (Location smallest = bst.smallest(bst.getRoot()).getLocation(); smallest
						.compareTo(largest) == -1; smallest = bst.successor(bst.getRoot(), smallest).getLocation()) {
					int xValue = smallest.xCoord();
					int yValue = smallest.yCoord();
					int xFig = this.getOffset().xCoord();
					int yFig = this.getOffset().yCoord();
					int xObj = obj.getOffset().xCoord();
					int yObj = obj.getOffset().yCoord();
					Location pixelCoord = new Location(xValue + xFig - xObj, yValue + yFig - yObj);
					if (obj.findPixel(pixelCoord) == true) {
						return true;
					}
				}
			} catch (EmptyTreeException e) {
				return false;
			}
		}
		return false;
	}

	/**
	 * Helper method. Returns true if the enclosing rectangle of the figure
	 * specified intersects with the enclosing rectangle of this figure and returns
	 * false otherwise.
	 * 
	 * @param obj is the figure being tested for intersection
	 * @return true if this figure intersects the enclosing rectangle of the object
	 *         specified and false otherwise.
	 */
	private boolean intersectsHelper(GraphicalFigure obj) {
		Location topLeftObj = obj.getOffset();
		Location bottomRightObj = new Location(topLeftObj.xCoord() + obj.getWidth(),
				topLeftObj.yCoord() + obj.getHeight());
		Location topLeftFig = this.getOffset();
		Location bottomRightFig = new Location(topLeftFig.xCoord() + this.getWidth(),
				topLeftFig.yCoord() + this.getHeight());

		if (topLeftFig.xCoord() > bottomRightObj.xCoord()) {
			return false;
		} else if (bottomRightFig.xCoord() < topLeftObj.xCoord()) {
			return false;
		} else if (topLeftFig.yCoord() > bottomRightObj.yCoord()) {
			return false;
		} else if (bottomRightFig.yCoord() < topLeftObj.yCoord()) {
			return false;
		} else {
			return true;
		}

	}

}
