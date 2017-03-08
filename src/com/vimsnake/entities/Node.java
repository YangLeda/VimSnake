package com.vimsnake.entities;

import com.vimsnake.util.NodeStatus;

// 网格中的节点
public class Node {

	private NodeStatus nodeStatus = NodeStatus.EMPTY;

	public NodeStatus getNodeStatus() {
		return nodeStatus;
	}

	public void setNodeStatus(NodeStatus nodeStatus) {
		this.nodeStatus = nodeStatus;
	}

}
