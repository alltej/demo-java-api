package com.alltej.apps.rbtreeapp;

/**
 * @author Allan Tejano
 * 4/29/2018
 */
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Date 10/29/2015
 * @author Tushar Roy
 *
 * Red Black Tree
 *
 * Time complexity
 * Insert - O(logn)
 * Delete - O(logn)
 * Search - O(logn)
 *
 * Does not work for duplicates.
 *
 * References
 * http://pages.cs.wisc.edu/~skrentny/cs367-common/readings/Red-Black-Trees/
 * https://en.wikipedia.org/wiki/Red%E2%80%93black_tree
 */
public class RedBlackTree {

    private RedBlackNode treeRoot;


    /**
     * Main delete method of red black tree.
     */
    public RedBlackNode removeData( int data) {
        final RedBlackNode root = treeRoot;
        AtomicReference<RedBlackNode> rootReference = new AtomicReference<>();
        delete(root, data, rootReference);
        if(rootReference.get() == null) {
            return root;
        } else {
            return rootReference.get();
        }
    }

    /**
     * Main print method of red black tree.
     */
    public void printFromRoot() {
        printRedBlackTree( treeRoot, 0);
    }

    /**
     * Main validate method of red black tree.
     */
    public boolean validateRedBlackTreeDefault() {
        final  RedBlackNode root = treeRoot;
        if(root == null) {
            return true;
        }
        //check if root is black
        if(root.color != RedBlackNode.Color.BLACK) {
            System.out.print("Root is not black");
            return false;
        }
        //Use of AtomicInteger solely because java does not provide any other mutable int wrapper.
        AtomicInteger blackCount = new AtomicInteger(0);
        //make sure black count is same on all path and there is no red red relationship
        return checkBlackNodesCount(root, blackCount, 0) && noRedRedParentChild(root, RedBlackNode.Color.BLACK);
    }


    private void rightRotate( RedBlackNode root, boolean changeColor) {
        RedBlackNode parent = root.parent;
        root.parent = parent.parent;
        if(parent.parent != null) {
            if(parent.parent.right == parent) {
                parent.parent.right = root;
            } else {
                parent.parent.left = root;
            }
        }
        RedBlackNode right = root.right;
        root.right = parent;
        parent.parent = root;
        parent.left = right;
        if(right != null) {
            right.parent = parent;
        }
        if(changeColor) {
            root.color = RedBlackNode.Color.BLACK;
            parent.color = RedBlackNode.Color.RED;
        }
    }

    private void leftRotate( RedBlackNode root, boolean changeColor) {
        RedBlackNode parent = root.parent;
        root.parent = parent.parent;
        if(parent.parent != null) {
            if(parent.parent.right == parent) {
                parent.parent.right = root;
            } else {
                parent.parent.left = root;
            }
        }
        RedBlackNode left = root.left;
        root.left = parent;
        parent.parent = root;
        parent.right = left;
        if(left != null) {
            left.parent = parent;
        }
        if(changeColor) {
            root.color = RedBlackNode.Color.BLACK;
            parent.color = RedBlackNode.Color.RED;
        }
    }

    private Optional<RedBlackNode> findSiblingNode( RedBlackNode root) {
        RedBlackNode parent = root.parent;
        if(isLeftChild(root)) {
            return Optional.ofNullable(parent.right.isNullLeaf ? null : parent.right);
        } else {
            return Optional.ofNullable(parent.left.isNullLeaf ? null : parent.left);
        }
    }

    private boolean isLeftChild( RedBlackNode root) {
        RedBlackNode parent = root.parent;
        if(parent.left == root) {
            return true;
        } else {
            return false;
        }
    }

    public void insertData(int data) {
        if (treeRoot == null) {
            treeRoot = RedBlackNode.createBlackNode(data);
            return;
        }

        final RedBlackNode root = treeRoot;
        if(root.data == data) {
            throw new IllegalArgumentException("Duplicate date " + data);
        }

        if(root.data > data) {
            RedBlackNode left = insert(root, root.left, data);
            //if left becomes root parent means rotation
            //happened at lower level. So just return left
            //so that nodes at upper level can set their
            //child correctly
            if(left == root.parent) {
                return;
            }
            //set the left child returned to be left of root node
            root.left = left;
            //doLeftSideCheck( root );
            getNewLeftNode( root );
        } else {
            RedBlackNode right = insert(root, root.right, data);
            //if right becomes root parent means rotation
            //happened at lower level. So just return right
            //so that nodes at upper level can set their
            //child correctly
            if(right == root.parent) {
                return;
            }
            root.right = right;
            //doRightSideCheck( root );
            getNewRightNode( root );
        }
    }

    private RedBlackNode insert( RedBlackNode parent, RedBlackNode adjNode, int data) {
        if(adjNode  == null || adjNode.isNullLeaf) {
            //if parent is not null means tree is not empty
            //so create a red leaf node
            if(parent != null) {
                return RedBlackNode.createRedNode(parent, data);
            } else { //otherwise create a black root node if tree is empty
                System.out.println("CREATING BLACK NODE");
                return RedBlackNode.createBlackNode(data);
            }
        }

        //duplicate insertion is not allowed for this tree.
        if(adjNode.data == data) {
            throw new IllegalArgumentException("Duplicate date " + data);
        }
        //if we go on left side then isLeft will be true
        //if we go on right side then isLeft will be false.
        boolean isLeft;
        if(adjNode.data > data) {
            RedBlackNode left = insert(adjNode, adjNode.left, data);
            //if left becomes root parent means rotation
            //happened at lower level. So just return left
            //so that nodes at upper level can set their
            //child correctly
            if(left == adjNode.parent) {
                return left;
            }
            //set the left child returned to be left of root node
            adjNode.left = left;
            return getNewLeftNode( adjNode );
            //return doLeftSideCheck( adjNode );
        } else {
            RedBlackNode right = insert(adjNode, adjNode.right, data);
            //if right becomes root parent means rotation
            //happened at lower level. So just return right
            //so that nodes at upper level can set their
            //child correctly
            if(right == adjNode.parent) {
                return right;
            }
            //set the right child returned to be right of root node
            adjNode.right = right;
            return getNewRightNode( adjNode );
        }
    }

    private RedBlackNode getNewRightNode( RedBlackNode adjNode ) {
        //this is mirror case of above. So same comments as above.
        if(adjNode.color == RedBlackNode.Color.RED && adjNode.right.color == RedBlackNode.Color.RED) {
            Optional<RedBlackNode> sibling = findSiblingNode(adjNode);
            if(!sibling.isPresent() || sibling.get().color == RedBlackNode.Color.BLACK) {
                if(!isLeftChild(adjNode)) {
                    leftRotate(adjNode, true);
                } else {
                    leftRotate(adjNode.right, false);
                    adjNode = adjNode.parent;
                    rightRotate(adjNode, true);
                }
            } else {
                adjNode.color = RedBlackNode.Color.BLACK;
                sibling.get().color = RedBlackNode.Color.BLACK;
                if(adjNode.parent.parent != null) {
                    adjNode.parent.color = RedBlackNode.Color.RED;
                }
            }
        }
        return adjNode;
    }

    private RedBlackNode getNewLeftNode( RedBlackNode adjNode ) {
        //if we went to left side check to see Red-Red conflict
        //between root and its left child
        if(adjNode.color == RedBlackNode.Color.RED && adjNode.left.color == RedBlackNode.Color.RED) {
            //get the sibling of root. It is returning optional means
            //sibling could be empty
            Optional<RedBlackNode> sibling = findSiblingNode(adjNode);
            //if sibling is empty or of BLACK color
            if(!sibling.isPresent() || sibling.get().color == RedBlackNode.Color.BLACK) {
                //check if root is left child of its parent
                if(isLeftChild(adjNode)) {
                    //this creates left left situation. So do one right rotate
                    rightRotate(adjNode, true);
                } else {
                    //this creates left-right situation so do one right rotate followed
                    //by left rotate

                    //do right rotation without change in color. So sending false.
                    //when right rotation is done root becomes right child of its left
                    //child. So make root = root.parent because its left child before rotation
                    //is new root of this subtree.
                    rightRotate(adjNode.left, false);
                    //after rotation root should be root's parent
                    adjNode = adjNode.parent;
                    //then do left rotate with change of color
                    leftRotate(adjNode, true);
                }

            } else {
                //we have sibling color as RED. So change color of root
                //and its sibling to Black. And then change color of their
                //parent to red if their parent is not a root.
                adjNode.color = RedBlackNode.Color.BLACK;
                sibling.get().color = RedBlackNode.Color.BLACK;
                //if parent's parent is not null means parent is not root.
                //so change its color to RED.
                if(adjNode.parent.parent != null) {
                    adjNode.parent.color = RedBlackNode.Color.RED;
                }
            }
        }
        return adjNode;
    }

    /**
     * Using atomicreference because java does not provide mutable wrapper. Its like
     * double pointer in C.
     */
    private void delete( RedBlackNode root, int data, AtomicReference<RedBlackNode> rootReference) {
        if(root == null || root.isNullLeaf) {
            return;
        }
        if(root.data == data) {
            //if node to be deleted has 0 or 1 null children then we have
            //deleteOneChild use case as discussed in video.
            if(root.right.isNullLeaf || root.left.isNullLeaf) {
                deleteOneChild(root, rootReference);
            } else {
                //otherwise look for the inorder successor in right subtree.
                //replace inorder successor data at root data.
                //then delete inorder successor which should have 0 or 1 not null child.
                RedBlackNode inorderSuccessor = findSmallest(root.right);
                root.data = inorderSuccessor.data;
                delete(root.right, inorderSuccessor.data, rootReference);
            }
        }
        //search for the node to be deleted.
        if(root.data < data) {
            delete(root.right, data, rootReference);
        } else {
            delete(root.left, data, rootReference);
        }
    }

    private RedBlackNode findSmallest( RedBlackNode root) {
        RedBlackNode prev = null;
        while(root != null && !root.isNullLeaf) {
            prev = root;
            root = root.left;
        }
        return prev != null ? prev : root;
    }

    /**
     * Assumption that node to be deleted has either 0 or 1 non leaf child
     */
    private void deleteOneChild( RedBlackNode nodeToBeDelete, AtomicReference<RedBlackNode> rootReference) {
        RedBlackNode child = nodeToBeDelete.right.isNullLeaf ? nodeToBeDelete.left : nodeToBeDelete.right;
        //replace node with either one not null child if it exists or null child.
        replaceNode(nodeToBeDelete, child, rootReference);
        //if the node to be deleted is BLACK. See if it has one red child.
        if(nodeToBeDelete.color == RedBlackNode.Color.BLACK) {
            //if it has one red child then change color of that child to be Black.
            if(child.color == RedBlackNode.Color.RED) {
                child.color = RedBlackNode.Color.BLACK;
            } else {
                //otherwise we have double black situation.
                deleteCase1(child, rootReference);
            }
        }
    }


    /**
     * If double black node becomes root then we are done. Turning it into
     * single black node just reduces one black in every path.
     */
    private void deleteCase1( RedBlackNode doubleBlackNode, AtomicReference<RedBlackNode> rootReference) {
        if(doubleBlackNode.parent == null) {
            rootReference.set(doubleBlackNode);
            return;
        }
        deleteCase2(doubleBlackNode, rootReference);
    }

    /**
     * If sibling is red and parent and sibling's children are black then rotate it
     * so that sibling becomes black. Double black node is still double black so we need
     * further processing.
     */
    private void deleteCase2( RedBlackNode doubleBlackNode, AtomicReference<RedBlackNode> rootReference) {
        RedBlackNode siblingNode = findSiblingNode(doubleBlackNode).get();
        if(siblingNode.color == RedBlackNode.Color.RED) {
            if(isLeftChild(siblingNode)) {
                rightRotate(siblingNode, true);
            } else {
                leftRotate(siblingNode, true);
            }
            if(siblingNode.parent == null) {
                rootReference.set(siblingNode);
            }
        }
        deleteCase3(doubleBlackNode, rootReference);
    }

    /**
     * If sibling, sibling's children and parent are all black then turn sibling into red.
     * This reduces black node for both the paths from parent. Now parent is new double black
     * node which needs further processing by going back to case1.
     */
    private void deleteCase3( RedBlackNode doubleBlackNode, AtomicReference<RedBlackNode> rootReference) {

        RedBlackNode siblingNode = findSiblingNode(doubleBlackNode).get();

        if(doubleBlackNode.parent.color == RedBlackNode.Color.BLACK && siblingNode.color == RedBlackNode.Color.BLACK && siblingNode.left.color == RedBlackNode.Color.BLACK
                && siblingNode.right.color == RedBlackNode.Color.BLACK) {
            siblingNode.color = RedBlackNode.Color.RED;
            deleteCase1(doubleBlackNode.parent, rootReference);
        } else {
            deleteCase4(doubleBlackNode, rootReference);
        }
    }

    /**
     * If sibling color is black, parent color is red and sibling's children color is black then swap color b/w sibling
     * and parent. This increases one black node on double black node path but does not affect black node count on
     * sibling path. We are done if we hit this situation.
     */
    private void deleteCase4( RedBlackNode doubleBlackNode, AtomicReference<RedBlackNode> rootReference) {
        RedBlackNode siblingNode = findSiblingNode(doubleBlackNode).get();
        if(doubleBlackNode.parent.color == RedBlackNode.Color.RED && siblingNode.color == RedBlackNode.Color.BLACK && siblingNode.left.color == RedBlackNode.Color.BLACK
                && siblingNode.right.color == RedBlackNode.Color.BLACK) {
            siblingNode.color = RedBlackNode.Color.RED;
            doubleBlackNode.parent.color = RedBlackNode.Color.BLACK;
            return;
        } else {
            deleteCase5(doubleBlackNode, rootReference);
        }
    }

    /**
     * If sibling is black, double black node is left child of its parent, siblings right child is black
     * and sibling's left child is red then do a right rotation at siblings left child and swap colors.
     * This converts it to delete case6. It will also have a mirror case.
     */
    private void deleteCase5( RedBlackNode doubleBlackNode, AtomicReference<RedBlackNode> rootReference) {
        RedBlackNode siblingNode = findSiblingNode(doubleBlackNode).get();
        if(siblingNode.color == RedBlackNode.Color.BLACK) {
            if (isLeftChild(doubleBlackNode) && siblingNode.right.color == RedBlackNode.Color.BLACK && siblingNode.left.color == RedBlackNode.Color.RED) {
                rightRotate(siblingNode.left, true);
            } else if (!isLeftChild(doubleBlackNode) && siblingNode.left.color == RedBlackNode.Color.BLACK && siblingNode.right.color == RedBlackNode.Color.RED) {
                leftRotate(siblingNode.right, true);
            }
        }
        deleteCase6(doubleBlackNode, rootReference);
    }

    /**
     * If sibling is black, double black node is left child of its parent, sibling left child is black and sibling's right child is
     * red, sibling takes its parent color, parent color becomes black, sibling's right child becomes black and then do
     * left rotation at sibling without any further change in color. This removes double black and we are done. This
     * also has a mirror condition.
     */
    private void deleteCase6( RedBlackNode doubleBlackNode, AtomicReference<RedBlackNode> rootReference) {
        RedBlackNode siblingNode = findSiblingNode(doubleBlackNode).get();
        siblingNode.color = siblingNode.parent.color;
        siblingNode.parent.color = RedBlackNode.Color.BLACK;
        if(isLeftChild(doubleBlackNode)) {
            siblingNode.right.color = RedBlackNode.Color.BLACK;
            leftRotate(siblingNode, false);
        } else {
            siblingNode.left.color = RedBlackNode.Color.BLACK;
            rightRotate(siblingNode, false);
        }
        if(siblingNode.parent == null) {
            rootReference.set(siblingNode);
        }
    }

    private void replaceNode( RedBlackNode root, RedBlackNode child, AtomicReference<RedBlackNode> rootReference) {
        child.parent = root.parent;
        if(root.parent == null) {
            rootReference.set(child);
        }
        else {
            if(isLeftChild(root)) {
                root.parent.left = child;
            } else {
                root.parent.right = child;
            }
        }
    }

    private void printRedBlackTree( RedBlackNode root, int space) {
        if(root == null || root.isNullLeaf) {
            return;
        }
        printRedBlackTree(root.right, space + 5);
        for(int i=0; i < space; i++) {
            System.out.print(" ");
        }
        System.out.println(root.data + " " + (root.color == RedBlackNode.Color.BLACK ? "B" : "R"));
        printRedBlackTree(root.left, space + 5);
    }

    private boolean noRedRedParentChild( RedBlackNode root, RedBlackNode.Color parentColor) {
        if(root == null) {
            return true;
        }
        if(root.color == RedBlackNode.Color.RED && parentColor == RedBlackNode.Color.RED) {
            return false;
        }

        return noRedRedParentChild(root.left, root.color) && noRedRedParentChild(root.right, root.color);
    }

    private boolean checkBlackNodesCount( RedBlackNode root, AtomicInteger blackCount, int currentCount) {

        if(root.color == RedBlackNode.Color.BLACK) {
            currentCount++;
        }

        if(root.left == null && root.right == null) {
            if(blackCount.get() == 0) {
                blackCount.set(currentCount);
                return true;
            } else {
                return currentCount == blackCount.get();
            }
        }
        return checkBlackNodesCount(root.left, blackCount, currentCount) && checkBlackNodesCount(root.right, blackCount, currentCount);
    }

}
