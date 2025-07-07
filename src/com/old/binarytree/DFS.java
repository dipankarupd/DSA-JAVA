package com.old.binarytree;

import java.util.Arrays;

public class DFS extends BT{

    // diameter of a bt:
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        int height = calculateHeight(root);

        return diameter-1;
    }

    private int calculateHeight(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int left = calculateHeight(root.left);
        int right = calculateHeight(root.right);

        int dia = left + right + 1;
        diameter = Math.max(dia, diameter);

        return Math.max(left, right) + 1;
    }

    // invert a binary tree:
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;


        return root;
    }

    // maximum depth:
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    // sorted array to BST
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] nums, int s, int e) {
        if(s > e) {
            return null;
        }
        int m = s + (e-s)/2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = helper(nums, s, m-1);
        root.right = helper(nums, m+1, e);
        return root;
    }

    // flatten binary tree:
    public void flatten(TreeNode root) {

        TreeNode curr = root;
        while(curr != null) {
            if(curr.left != null) {
                TreeNode temp = curr.left;
                while(temp.right != null) {
                    temp = temp.right;
                }
                temp.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    // validate BST
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if(root == null) {
            return true;
        }

        if(min != null && root.val <= min) {
            return false;
        }
        if(max != null && root.val >= max) {
            return false;
        }

        boolean left = helper(root.left, min , root.val);
        boolean right = helper(root.right, root.val,max);

        return left && right;
    }

    // lowest common ancestor:
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }


    /// kth smallest element in BST
    public int kthSmallest(TreeNode root, int k) {
        return helper(root,k).val;
    }

    private TreeNode helper(TreeNode node, int k) {
        int c = 0;
        if(node == null) {
            return null;
        }

        TreeNode left = helper(node.left, k);
        if(left != null) {
            return left;
        }
        c++;

        if(c == k) {
            return node;
        }
        return helper(node.right, k);
    }

    // binary tree from inorder and preorder traversal:
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0) return null;

        int idx = 0;
        int r = preorder[0];

        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == r) {
                idx = i;
            }
        }

        TreeNode root = new TreeNode(r);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, idx+1), Arrays.copyOfRange(inorder, 0, idx));
        root.right = buildTree(Arrays.copyOfRange(preorder, idx+1, preorder.length), Arrays.copyOfRange(inorder, idx+1, inorder.length));

        return root;
    }
}
