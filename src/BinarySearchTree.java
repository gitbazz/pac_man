/**
 * Implements an ordered dictionary using a binary search tree. Each node of the
 * tree stores a Pixel object; the attribute Location of the Pixel is its key.
 * 
 * @author Bazillah Zargar
 */
public class BinarySearchTree implements BinarySearchTreeADT {

	private BinaryNode root; // root of the binary search tree

	/**
	 * Constructor that creates a tree whose root is a leaf node
	 * 
	 */
	public BinarySearchTree() {
		BinaryNode newRoot = new BinaryNode();
		this.root = newRoot;
	}

	/**
	 * Returns Pixel storing the given key.
	 * 
	 * @return pixel storing the given key if the key is stored in in the tree,
	 *         returns null otherwise
	 */
	public Pixel get(BinaryNode r, Location key) {
		BinaryNode nodeFound = getHelper(r, key);
		return nodeFound.getData();
	}

	/**
	 * Helper method. Returns the Binary Node which stores the Pixel storing the
	 * given key.
	 * 
	 * @return the Binary Node which stores the Pixel storing the given key if the
	 *         key is stored in in the tree, returns null otherwise
	 */
	private BinaryNode getHelper(BinaryNode r, Location key) {
		if (r.isLeaf() == true) {
			return r;
		} else {
			if (r.getData().getLocation().compareTo(key) == 0) {
				return r;
			} else if (key.compareTo(r.getData().getLocation()) == -1) {
				return getHelper(r.getLeft(), key);
			} else {
				return getHelper(r.getRight(), key);
			}
		}
	}

	/**
	 * Inserts the given data in the tree if no data item with the same key is
	 * already there. If a node already stores the same key, the algorithm throws a
	 * DuplicatedKeyException
	 * 
	 * @param r    is the root of the tree
	 * @param data is the Pixel to be inserted into the tree
	 * 
	 */
	public void put(BinaryNode r, Pixel data) throws DuplicatedKeyException {
		Location key = data.getLocation();
		BinaryNode nodeFound = getHelper(r, key);
		if (nodeFound.isLeaf() != true) {
			throw new DuplicatedKeyException("A node in the BST already stores the same key");
		} else {
			putHelper(r, data);
		}

	}

	/**
	 * Helper Method. Inserts the given data in the tree if no data item with the
	 * same key is already there.
	 * 
	 * @param r    is the root of the tree
	 * @param data is the Pixel to be inserted into the tree
	 * 
	 */
	private void putHelper(BinaryNode r, Pixel data) {
		Location key = data.getLocation();
		BinaryNode newNode = new BinaryNode(data, new BinaryNode(), new BinaryNode(), r);
		if (r.isLeaf() == true) {
			this.root = new BinaryNode(data, new BinaryNode(), new BinaryNode(), null);
		} else {
			if (key.compareTo(r.getData().getLocation()) == -1) {
				if (r.getLeft().isLeaf() == true) {
					r.setLeft(newNode);
					newNode.getLeft().setParent(newNode);
					newNode.getRight().setParent(newNode);
				} else {
					putHelper(r.getLeft(), data);
				}
			} else if (key.compareTo(r.getData().getLocation()) == 1) {
				if (r.getRight().isLeaf() == true) {
					r.setRight(newNode);
					newNode.getLeft().setParent(newNode);
					newNode.getRight().setParent(newNode);
				} else {
					putHelper(r.getRight(), data);
				}
			}
		}
	}

	/**
	 * Removes the data item with the given key, if the key is stored in the tree.
	 * Throws an InexistentKeyException otherwise.
	 * 
	 * @param r   is the root of the tree
	 * @param key is the key of the node to be removed from the tree
	 * 
	 */
	public void remove(BinaryNode r, Location key) throws InexistentKeyException {
		BinaryNode nodeFound = getHelper(r, key);
		if ((r.isLeaf() == true) || (nodeFound.isLeaf() == true)) {
			throw new InexistentKeyException("A data item with this key is not stored in the BST");
		} else {
			BinaryNode parent = nodeFound.getParent();
			BinaryNode otherChild;
			if ((nodeFound.getLeft().isLeaf() == true) && (nodeFound.getRight().isLeaf() == true)) {
				nodeFound.setData(null);
				nodeFound.setLeft(null);
				nodeFound.setRight(null);
			} else if ((nodeFound.getLeft().isLeaf() == true) && (nodeFound.getRight().isLeaf() == false)) {
				otherChild = nodeFound.getRight();
				otherChild.setParent(parent);
				if (parent.getLeft() == nodeFound) {
					parent.setLeft(otherChild);
				} else {
					parent.setRight(otherChild);
				}
			} else if ((nodeFound.getLeft().isLeaf() == false) && (nodeFound.getRight().isLeaf() == true)) {
				otherChild = nodeFound.getLeft();
				otherChild.setParent(parent);
				if (parent.getLeft() == nodeFound) {
					parent.setLeft(otherChild);
				} else {
					parent.setRight(otherChild);
				}
			} else {
				BinaryNode smallest = smallestHelper(nodeFound.getRight());
				nodeFound.setData(smallest.getData());
				remove(smallest, smallest.getData().getLocation());
			}
		}
	}

	/**
	 * Returns the pixel with the smallest key larger than the given one.
	 * 
	 * @param r   is the root of the tree
	 * @param key is the key of who's successor is being searched for
	 * @return the pixel with the smallest key larger than the given one or null if
	 *         the given key has no successor
	 * 
	 */
	public Pixel successor(BinaryNode r, Location key) {
		if (r.isLeaf() == true) {
			return null;
		} else {
			BinaryNode nodeFound = getHelper(r, key);
			if ((nodeFound.isLeaf() == false) && (nodeFound.getRight().isLeaf() == false)) {
				return smallestHelper(nodeFound.getRight()).getData();
			} else {
				BinaryNode parent = nodeFound.getParent();
				while ((nodeFound.getParent() != null) && (parent.getData().getLocation().compareTo(key) == -1)) {
					parent = parent.getParent();
				}
				if (parent.getData() == null) {
					return null;
				} else {
					return parent.getData();
				}
			}
		}
	}

	/**
	 * Returns the pixel with the largest key smaller than the given one.
	 * 
	 * @param r   is the root of the tree
	 * @param key is the key of who's predecessor is being searched for
	 * @return the pixel with the largest key smaller than the given one or null if
	 *         the given key has no successor
	 * 
	 */
	public Pixel predecessor(BinaryNode r, Location key) {
		if (r.isLeaf() == true) {
			return null;
		} else {
			BinaryNode nodeFound = getHelper(r, key);
			if ((nodeFound.isLeaf() == false) && (nodeFound.getLeft().isLeaf() == false)) {
				return largestHelper(nodeFound.getLeft()).getData();
			} else {
				BinaryNode parent = nodeFound.getParent();
				while ((parent != null) && (parent.getData().getLocation().compareTo(key) == 1)) {
					parent = parent.getParent();
				}
				if (parent.getData() == null) {
					return null;
				} else {
					return parent.getData();
				}
			}
		}
	}

	/**
	 * Returns the pixel with the smallest key. Throws an EmptyTreeException if the
	 * tree does not contain any data.
	 * 
	 * @param r is the root of the tree
	 * @return the pixel with the smallest key
	 * 
	 */
	public Pixel smallest(BinaryNode r) throws EmptyTreeException {
		if (r.isLeaf() == true) {
			throw new EmptyTreeException("The BST is empty");
		} else {
			BinaryNode node = smallestHelper(r);
			return node.getData();
		}
	}

	/**
	 * Helper method. Returns the node containing the pixel with the smallest key.
	 * 
	 * @param r is the root of the tree
	 * @return the node containing the pixel with the smallest key
	 * 
	 */
	private BinaryNode smallestHelper(BinaryNode r) {
		BinaryNode node = r;
		while (node.getLeft().isLeaf() == false) {
			node = node.getLeft();
		}
		return node;
	}

	/**
	 * Returns the pixel with the largest key. Throws an EmptyTreeException if the
	 * tree does not contain any data.
	 * 
	 * @param r is the root of the tree
	 * @return the pixel with the largest key
	 * 
	 */
	public Pixel largest(BinaryNode r) throws EmptyTreeException {
		if (r.isLeaf() == true) {
			throw new EmptyTreeException("The BST is empty");
		} else {
			BinaryNode node = largestHelper(r);
			return node.getData();
		}
	}

	/**
	 * Helper method. Returns the node containing the pixel with the largest key.
	 * 
	 * @param r is the root of the tree
	 * @return the node containing the pixel with the largest key
	 * 
	 */
	private BinaryNode largestHelper(BinaryNode r) {
		BinaryNode node = r;
		while (node.getRight().isLeaf() == false) {
			node = node.getRight();
		}
		return node;
	}

	/**
	 * Returns the root of the binary search tree.
	 * 
	 * @return root
	 */
	public BinaryNode getRoot() {
		return this.root;
	}

}
