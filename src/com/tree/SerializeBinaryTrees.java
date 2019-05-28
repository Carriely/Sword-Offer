package com.tree;

//序列化二叉树
//解法：
//使用前序遍历进行序列化和反序列化。
public class SerializeBinaryTrees {
	public String Serialize(TreeNode root) {
		StringBuilder res = new StringBuilder();
		if (root == null) {
			return res.toString();
		}
		serializeHelper(root, res);
		res.deleteCharAt(res.lastIndexOf(","));
		return res.toString();
	}

	private void serializeHelper(TreeNode root, StringBuilder res) {
		if (root == null) {
			res.append("#");
			res.append(",");
			return;
		}
		res.append(root.val);
		res.append(",");
		serializeHelper(root.left, res);
		serializeHelper(root.right, res);
	}

	private int index = -1;

	public TreeNode Deserialize(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		String[] treeNodeStr = str.split(",");
		return deserializeHelper(treeNodeStr);
	}

	private TreeNode deserializeHelper(String[] treeNodeStr) {
		index++;
		TreeNode node = null;

		// index不越界并且当前节点不为#
		if (index < treeNodeStr.length && !"#".equals(treeNodeStr[index])) {
			node = new TreeNode(Integer.valueOf(treeNodeStr[index]));
			node.left = deserializeHelper(treeNodeStr);
			node.right = deserializeHelper(treeNodeStr);
		}
		return node;
	}
}
