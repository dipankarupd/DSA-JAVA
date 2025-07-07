package com.old.binarytree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class BT {

    // level order traversal:
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // iterate until queue is not empty
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(list);
        }

        return res;
    }

    // average of values in a level
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add((levelSum/levelSize));
        }

        return res;
    }

    // calculate the next successor in level order trav
    public TreeNode successor(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                // check if this is the node whose successor we want:
                if (node.val == key) {
                    break;
                }
            }
        }
        return queue.peek();
    }

    // zigzag order traversal
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean reverse = false;
        // iterate until queue is not empty
        while (!queue.isEmpty()) {

            List<Integer> list = new ArrayList<>();
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {

                if (!reverse) {
                    TreeNode node = queue.pollFirst();
                    list.add(node.val);
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                } else {
                    TreeNode node = queue.pollLast();
                    list.add(node.val);
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                }
            }
            reverse = !reverse;
            res.add(list);
        }

        return res;
    }

    // populate the next right pointer
    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Node leftmost = root;

        while(leftmost.left != null) {
            Node current = leftmost;
            while(current != null) {

                current.left.next = current.right;
                if(current.next != null) {
                    current.right.next  = current.next.left;
                }
                current = current.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }


    // right side view of binary tree
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {

                TreeNode node = queue.poll();

                if(i == levelSize - 1) {
                    res.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

    // cousin of binary tree
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {

            boolean xx = false, yy = false;
            TreeNode parentX = null, parentY = null;

            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if(node.left != null) {
                    queue.offer(node.left);
                    if(node.left.val == x) {
                        xx = true;
                        parentX = node;
                    }
                    if(node.left.val == y) {
                        yy = true;
                        parentY = node;
                    }
                }

                if(node.right != null) {
                    queue.offer(node.right);
                    if(node.right.val == x) {
                        xx = true;
                        parentX = node;
                    }
                    if(node.right.val == y) {
                        yy = true;
                        parentY = node;
                    }
                }
            }

            // check for the condition:
            if (xx && yy && parentX != parentY) {
                return true;
            }

            if (xx || yy) {
                return false;
            }
        }
        return false;
    }

    // different approach
    public boolean isCousins2(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        TreeNode xx = find(root, x);
        TreeNode yy = find(root, y);

        return ((level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy)));
    }

    private TreeNode find(TreeNode root, int x) {
        if (root == null) {
            return null;
        }

        if (root.val == x) {
            return root;
        }

        TreeNode n = find(root.left, x);
        if (n != null) {
            return n;
        }
        return find(root.right, x);
    }

    private int level(TreeNode root, TreeNode x, int level) {
        if (root == null) {
            return 0;
        }
        if (x == root) {
            return level;
        }

        int lev = level(root.left, x, level + 1);
        if (lev != 0) {
            return lev;
        }
        return level(root.right, x, level + 1);
    }

    private boolean isSibling(TreeNode root, TreeNode x, TreeNode y) {
        if (root == null) {
            return false;
        }

        return ((root.left == x && root.right == y) || (root.right == x && root.left == y) || isSibling(root.left, x, y) || isSibling(root.right, x, y));
    }


    // check for symmetric trees:
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left == null && right == null) {
                continue;
            }
            if(left == null || right == null) {
                return false;
            }
            if(left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

}
