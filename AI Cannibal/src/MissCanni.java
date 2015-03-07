// Missionary and Cannibals Problemby Madhumita Dange
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MissCanni {

	public static void main(String args[]) {
		Queue<Node> Q = new LinkedList<Node>();
		Node initial = new Node(3, 3, 1, null);
		ArrayList<String> visitedNodes = new ArrayList<String>();
		ArrayList<String> boatNode = new ArrayList<String>(); // list of all possible actions 
		boatNode.add("011");
		boatNode.add("021");
		boatNode.add("101");
		boatNode.add("201");
		boatNode.add("111");
		Q.add(initial);// maintains search tree nodes
		MissCanni mCan = new MissCanni();
		mCan.solve(boatNode, Q, visitedNodes);// solve the puzzle and print solution path

	}

	public void solve(ArrayList<String> boatNode, Queue<Node> Q,
			ArrayList<String> visitedNodes) {
		while (!Q.isEmpty()) {
			Node current = Q.poll();
			if (current.getMiss() == 0 && current.getCanni() == 0
					&& current.getBoat() == 0) {
				// baghu termination and print
				Stack st = new Stack();
				while (current.getParent() != null) {
					st.push("" + current.getMiss() + current.getCanni()
							+ current.getBoat());
					// System.out.println(""+current.getMiss()+current.getCanni()+current.getBoat());
					current = current.getParent();
				}
				if (current.getParent() == null) {
					// System.out.println(""+current.getMiss()+current.getCanni()+current.getBoat());
					st.push("" + current.getMiss() + current.getCanni()
							+ current.getBoat());

				}
				System.out.println("Solution Path :");
				while (!st.isEmpty()) {

					System.out.println(st.pop());
				}
				System.out.println("Goal !!");
				break;
			}

			for (String bS : boatNode) {
				int mL = 0, cL = 0, b = 0, revDir = 0;
				if (current.getBoat() == 1) {
					mL = current.getMiss()
							- Integer.parseInt(bS.charAt(0) + "");
					cL = current.getCanni()
							- Integer.parseInt(bS.charAt(1) + "");
					b = current.getBoat() - Integer.parseInt(bS.charAt(2) + "");
					revDir = 0;
				} else if (current.getBoat() == 0) {

					mL = current.getMiss()
							+ Integer.parseInt(bS.charAt(0) + "");
					cL = current.getCanni()
							+ Integer.parseInt(bS.charAt(1) + "");
					b = current.getBoat() + Integer.parseInt(bS.charAt(2) + "");
					revDir = 1;
				}

				if (!visitedNodes.contains(mL + cL + b + "")) {// check for repetition 
					visitedNodes.add(mL + "" + cL + "" + b);
					//check for valid state
					if (mL >= 0
							&& cL >= 0
							&& mL <= 3
							&& cL <= 3
							&& ((mL >= cL) || (mL == 0 && cL >= 0))
							&& (((3 - mL) >= (3 - cL)) || ((3 - mL) == 0 && (3 - cL) >= 0))) {
						Q.add(new Node(mL, cL, revDir, current));
					}
				}
			}

		}
	}

}