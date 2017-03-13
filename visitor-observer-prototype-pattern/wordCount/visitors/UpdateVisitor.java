package wordCount.visitors;

import wordCount.dsForStrings.Node;
import wordCount.dsForStrings.TreeInterface;

public class UpdateVisitor implements DSProcessingVisitorI {

	@Override
	public void visit(TreeInterface bst) {
		updateTree(bst.getRootNode());
	}

	private void updateTree(Node rootNode) {
		if(rootNode != null)
		{
			updateTree(rootNode.getLeft());
			rootNode.update();
			updateTree(rootNode.getRight());
			
		}
	}

}
