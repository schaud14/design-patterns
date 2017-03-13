package wordCount.dsForStrings;

import wordCount.store.Results;
import wordCount.util.FileProcessor;
import wordCount.visitors.DSProcessingVisitorI;

public class BinarySearchTree implements TreeInterface{
	private Node root;
	
	/**
	 * Method to set root node of tree
	 * @param root
	 */
	public void setRoot(Node root) {
		this.root = root;
	}
	
	/**
	 * Constructor of BinarySearchTree class
	 * sets root to null;
	 */
	public BinarySearchTree() {
		this.root = null;
	}
	
	/**
	 * Method to insert node into BinarySearchTree 
	 * using string as input param.. 
	 * It will create a node and then insert it into tree.
	 * @param data
	 */
	public void insert(String data)
	{
		root = insertNode(root,data);
	}
	
	/**
	 * This is recursive insert function for inserting Node.
	 * @param node
	 * @param data
	 * @return Node
	 */
	public Node insertNode(Node node,String data)
	{
		if(node == null)
		{
			Node newNode  = new Node(data);
			node = newNode;
			node.setCount(1);
		}
		else
		{
			if(node.getHashCode() == data.hashCode())
			{
				node.setCount(node.getCount()+1);
			}
			else if(data.hashCode() < node.getHashCode())
			{
				node.setLeft(insertNode(node.getLeft(),data));
			}
			else if(data.hashCode() > node.getHashCode())
			{
				node.setRight(insertNode(node.getRight(),data));
			}
		}
		return node;
	}	
	
	/**
	 * Method to insert node into BinarySearchTree 
	 * using Node as input param.. 
	 * It will insert it into tree.
	 * @param data
	 */
	public void insert(Node data)
	{
		root = insertNode(root,data);
	}
	
	/**
	 * This is recursive insert function for inserting Node.
	 * 
	 * @param root
	 * @param data
	 * @return node
	 */
	public Node insertNode(Node root,Node data)
	{
		if(root == null)
		{
			root = data;
		}
		else
		{
			if(root.getHashCode() == data.hashCode())
			{
				root.setCount(root.getCount()+1);
			}
			else if(data.hashCode() < root.getHashCode())
			{
				root.setLeft(insertNode(root.getLeft(),data));
			}
			else if(data.hashCode() > root.getHashCode())
			{
				root.setRight(insertNode(root.getRight(),data));
			}
		}
		return root;
	}	
	
	
	/**
	 * Method to call visit method of the visitor.
	 * @param visitor
	 */
	public void accept(DSProcessingVisitorI visitor) {
		visitor.visit(this);	
	}
	
	/**
	 * Method to get word count into result object.
	 * @param res
	 */
	public void getResult(Results res)
	{
		traverseTree(root,res);
	}
	/**
	 * Method to traverse tree in inorder manner
	 * It simultaneously updates the result object 
	 * as it traverses each node.
	 * @param node
	 * @param res
	 */
	public void traverseTree(Node node,Results res)
	{
		if(node!= null)
		{
			traverseTree(node.getLeft(),res);
			res.setWordCount(res.getWordCount()+node.getCount());
			res.setCharCount(res.getCharCount()+(node.getCharCount()*node.getCount()));
			res.setDistinctWordCount(res.getDistinctWordCount()+1);
			if(res.getMaxFreq() == node.getCount())
			{
				res.addWord(node.getData());
			}
			if(res.getMaxFreq() < node.getCount())
			{
				res.clearMaxWords();
				res.setMaxFreq(node.getCount());
				res.addWord(node.getData());
			}
			traverseTree(node.getRight(),res);
		}
	}

	/**
	 * method to write results to the output file
	 * @param res
	 * @param fp
	 */
	public void writeResults(Results res,FileProcessor fp)
	{
		
		StringBuilder sb = new StringBuilder("Total Word Count: ");
		fp.writeToFile(sb.append(res.getWordCount()).toString());
		
		sb = new StringBuilder("Total Character Count: ");
		fp.writeToFile(sb.append(res.getCharCount()).toString());
	
		sb = new StringBuilder("Distinct Word Count: ");
		fp.writeToFile(sb.append(res.getDistinctWordCount()).toString());
		
		sb = new StringBuilder("Distinct Words: ");
		if(!(res.getMaxWords().isEmpty()))
			fp.writeToFile(sb.append(res.getMaxWords().substring(0, (res.getMaxWords().length()-1))).toString());
		fp.closeFile();
	}
	/**
	 * Method to get root node of tree.
	 *  @return root node of tree
	 */
	@Override
	public Node getRootNode() {
		return root;
	}
}
