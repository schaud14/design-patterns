package wordCount.visitors;

import wordCount.dsForStrings.BinarySearchTree;
import wordCount.dsForStrings.TreeInterface;
import wordCount.store.Results;
import wordCount.util.FileProcessor;

public class WordCountVisitor implements DSProcessingVisitorI{
	private Results res;
	private FileProcessor fp;
	
	public WordCountVisitor(FileProcessor fpIn) {
		this.res = new Results();
		fp = fpIn;
	}

	@Override
	public void visit(TreeInterface bst) {
		bst.getResult(res);
		((BinarySearchTree) bst).writeResults(res,fp);
	}
	
}