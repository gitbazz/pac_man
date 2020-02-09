# Pac-Man

“Pac-Man”-like game. Figures moved by the computer will chase the user controlled ones. These latter in turn will try to get rid of the target figures. Fixed figures constrain the movement of the mobile ones.

Four kinds of figures:
  - fixed figures, which cannot move
  - figures that can be moved by the user
  - figures that are moved by the computer
  - target figures, that disappear when the user-controled figures run into them
  
**Location.java** class that represents the position (x, y) of a pixel.
  
**Pixel.java** class that represents the data items to be stored in the binary search tree.
  
**BinaryNode.java** class that represents the nodes of the binary search tree. Each node stores an object of the class Pixel and has references to its left child, its right child, and its parent.

**BinarySearchTree.java** class that implements an ordered dictionary using a binary search tree. Each node of the tree stores a Pixel object; the attribute Location of the Pixel is its key.

**GraphicalFigure.java** class that represents a graphical figure object
