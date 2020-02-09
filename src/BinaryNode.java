/**
 * Represents the nodes of a binary search tree. Each node stores an object of
 * the class Pixel and has references to its left child, right child and parent.
 * 
 * @author Bazillah Zargar
 */
public class BinaryNode {

	private Pixel data; // Pixel object
	private BinaryNode left; // left child
	private BinaryNode right; // right child
	private BinaryNode parent; // parent node

	/**
	 * Constructor that stores the pixel in the node and sets left child, right
	 * child, and parent to the specified values.
	 * 
	 * @param value  is the pixel object
	 * @param left   is the left node
	 * @param right  is the right node
	 * @param parent is the parent node
	 */
	public BinaryNode(Pixel value, BinaryNode left, BinaryNode right, BinaryNode parent) {
		this.data = value;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}

	/**
	 * Constructor that initializes a leaf node. The data, children and parent are
	 * set to null.
	 * 
	 */
	public BinaryNode() {
		this.data = null;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

	/**
	 * Returns the parent of this node.
	 * 
	 * @return location
	 */
	public BinaryNode getParent() {
		return this.parent;
	}

	/**
	 * Sets the parent of this node to the specified value.
	 * 
	 * @param parent is the specified value of the parent.
	 */
	public void setParent(BinaryNode parent) {
		this.parent = parent;
	}

	/**
	 * Sets the left child of this node to the specified value.
	 * 
	 * @param p is the specified value of the left child.
	 */
	public void setLeft(BinaryNode p) {
		this.left = p;
	}

	/**
	 * Sets the right child of this node to the specified value.
	 * 
	 * @param p is the specified value of the right child.
	 */
	public void setRight(BinaryNode p) {
		this.right = p;
	}

	/**
	 * Stores the given pixel in this node
	 * 
	 * @param value is the specified pixel value.
	 */
	public void setData(Pixel value) {
		this.data = value;
	}

	/**
	 * Determines if this node is a leaf node
	 * 
	 * @return true is this node is a leaf node and false otherwise
	 */
	public boolean isLeaf() {
		if ((this.data == null) && (this.left == null) && (this.right == null)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the Pixel object stored in this node.
	 * 
	 * @return Pixel object
	 */
	public Pixel getData() {
		return this.data;
	}

	/**
	 * Returns the left child of this node.
	 * 
	 * @return left child
	 */
	public BinaryNode getLeft() {
		return this.left;
	}

	/**
	 * Returns the right child of this node.
	 * 
	 * @return right child
	 */
	public BinaryNode getRight() {
		return this.right;
	}
}
