package normal;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liying
 */
public class 二叉树的中序遍历 {
    /**
     * 1
     * \
     * 2
     * /
     * 3
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node1, null);
        TreeNode root = new TreeNode(1, null, node2);
        二叉树的中序遍历 run = new 二叉树的中序遍历();
        run.inorderTraversal(root);
    }

    /**
     * 遍历左节点压栈->没有子节点->输出中间节点->选取右节点作为root节点->以此往复
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            root = checkLeft(stack, root);
        }
        while (root != null) {
            list.add(root.val);
            if (root.right != null) {
                root = checkLeft(stack, root.right);
            } else {
                if (stack.isEmpty()) {
                    root = null;
                } else {
                    root = stack.pop();
                }
            }
        }
        return list;
    }

    private TreeNode checkLeft(Stack<TreeNode> stack, TreeNode root) {
        while (root.left != null) {
            stack.push(root);
            root = root.left;
        }
        return root;
    }


}
