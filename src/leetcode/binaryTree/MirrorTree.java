package leetcode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MirrorTree {

    static TreeNode head;

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }


    public void levelOrderTraversal(TreeNode root) {
        System.out.println("Level Order Traversal ");
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while( treeNodeQueue.size() != 0 ) {
            TreeNode temp = treeNodeQueue.poll();
            if ( temp.left != null ) {
                treeNodeQueue.add(temp.left);
            }
            if ( temp.right != null ) {
                treeNodeQueue.add(temp.right);
            }
            System.out.print(temp.val + " ");
        }
    }

    void inorderTraversal(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inorderTraversal(treeNode.left);
        System.out.print(treeNode.val + " ");
        inorderTraversal(treeNode.right);
    }

    void inMirrorAdditionTraversal(TreeNode treeNode, TreeNode siblingTreeNode, int height) {
        if (treeNode == null) {
            return;
        }
        inMirrorAdditionTraversal(treeNode.left, siblingTreeNode.right, height + 1);
        System.out.print((treeNode.val + siblingTreeNode.val) + " ");
        if ( height == 0 ) {
            return;
        }
        inMirrorAdditionTraversal(treeNode.right,siblingTreeNode.left, height + 1);
    }

    public static void main(String args[]) {
        MirrorTree mirrorTree = new MirrorTree();
        head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.right = new TreeNode(7);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(9);
        System.out.println("Inorder Traversal");
        mirrorTree.inorderTraversal(head);
        System.out.println();

        System.out.println("Mirror Addition Traversal");
        mirrorTree.inMirrorAdditionTraversal(head, head, 0);
        System.out.println();

        mirrorTree.levelOrderTraversal(head);
        System.out.println();

        head = mirrorTree.invertTree(head);

        mirrorTree.levelOrderTraversal(head);
        System.out.println();
    }

}
