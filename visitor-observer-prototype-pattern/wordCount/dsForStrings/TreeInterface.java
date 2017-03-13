package wordCount.dsForStrings;

import wordCount.store.Results;
import wordCount.visitors.DSProcessingVisitorI;

public interface TreeInterface {
	/**
	 * This method should insert a word into the tree.
	 * @param data
	 * 			word to be inserted
	 */
	public void insert(String data);
	/**
	 * This method should insert a new node into the tree.
	 * @param newNode
	 * 			Node to be inserted
	 */
	public void insert(Node newNode);
	
	/**
	 * This method is a part of template to implement visitor pattern.
	 * @param visitor
	 */
	public void accept(DSProcessingVisitorI visitor);
	/**
	 * Returns the root of the tree.
	 * @return root
	 */
	public Node getRootNode();
	
	/**
	 * This method is used for traversing the tree and
	 * calculate the result.
	 * calculate total word count,total character count and 
	 * total distinct word count.
	 * @param res
	 */
	public void getResult(Results res);
	
}
