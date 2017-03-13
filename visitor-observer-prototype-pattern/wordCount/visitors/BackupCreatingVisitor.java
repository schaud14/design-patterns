package wordCount.visitors;

import wordCount.dsForStrings.Node;
import wordCount.dsForStrings.TreeInterface;

public class BackupCreatingVisitor implements DSProcessingVisitorI{
	TreeInterface orgbst;
	public BackupCreatingVisitor(TreeInterface orgbstIn) {
		orgbst = orgbstIn;
	}

	@Override
	public void visit(TreeInterface bstBk) {
		createBackup(orgbst.getRootNode(),bstBk);
	}

	private void createBackup(Node node,TreeInterface bstBk) {
		if(node!= null)
		{
			createBackup(node.getLeft(),bstBk);
			Node newNode = null;
			try 
			{
				newNode = (Node)node.clone();
				newNode.setLeft(null);
				newNode.setRight(null);
			} 
			catch (CloneNotSupportedException e) 
			{
				e.printStackTrace();
			}
			bstBk.insert(newNode);
			node.registerObserver(newNode);
			createBackup(node.getRight(),bstBk);
		
		}
	}	
	
}