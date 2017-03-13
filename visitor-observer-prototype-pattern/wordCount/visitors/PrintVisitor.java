package wordCount.visitors;

import wordCount.dsForStrings.Node;
import wordCount.dsForStrings.TreeInterface;
import wordCount.util.FileProcessor;

public class PrintVisitor implements DSProcessingVisitorI {
	FileProcessor fp;
	public PrintVisitor(FileProcessor fpIn) {
		fp = fpIn;
	}

	@Override
	public void visit(TreeInterface bst) {
		inorderPrint(bst.getRootNode());
		
	}
	private void inorderPrint(Node rootNode) {
		if(rootNode != null)
		{
			inorderPrint(rootNode.getLeft());
			fp.writeToFile(rootNode.toString());
			inorderPrint(rootNode.getRight());
		}
	}
}
