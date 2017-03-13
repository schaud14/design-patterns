package wordCount.dsForStrings;

import java.util.ArrayList;
import java.util.List;
import wordCount.util.Subject;
import wordCount.util.Observer;

public class Node implements Cloneable,Observer,Subject{
	private String data;
	private Node left;
	private Node right;
	private int hashCode;
	private int count;
	private int charCount;
	private List<Node> backupNodes;
	
	/**
	 * @return charCount
	 */
	public int getCharCount() {
		return charCount;
	}
	
	/**
	 * @param charCountIn
	 * 			charCount to set
	 */
	public void setCharCount(int charCountIn) {
		charCount = charCountIn;
	}
	/** 
	 * @return count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count
	 * 			count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * Constructor of node.
	 * @param dataIn
	 * set left and right node to null.
	 * set hashcode of data. 
	 */
	public Node(String dataIn) {
		data = dataIn;
		this.left = null;
		this.right = null;
		setHashCode(this.data.hashCode());
		setCharCount(this.data.length());
		backupNodes = new ArrayList<Node>();
	}
	/**
	 * 
	 * @return hashcode
	 */
	public int getHashCode() {
		return hashCode;
	}
	
	/**
	 * 
	 * @param hashCode
	 * 			hashcode to set
	 */
	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}
	
	/**
	 * 
	 * @return data
	 */
	public String getData() {
		return data;
	}
	
	/**
	 * 
	 * @param data
	 * 			data to set
	 */
	public void setData(String data) {
		this.data = data;
	}
	
	/**
	 * 
	 * @return left
	 */
	public Node getLeft() {
		return left;
	}
	
	/**
	 *
	 * @param left
	 * 		left to set.
	 */
	public void setLeft(Node left) {
		this.left = left;
	}
	
	/**
	 * 
	 * @return right
	 */
	public Node getRight() {
		return right;
	}
	/**
	 * 
	 * @param rightIn
	 * 		right to set.
	 */
	public void setRight(Node rightIn) {
		right = rightIn;
	}
	
	/**
	 * This method registers the observers in a ArrayList data structure of node.
	 * @param node
	 */
	@Override
	public void registerObserver(Node n) {
		backupNodes.add(n);	
	}
	
	/**
	 * This method removes an observer from a ArrayList data structure of node.
	 * @param node
	 */
	@Override
	public void removeObserver(Node n) {
		backupNodes.remove(n);
	}
	/**
	 * This method is used to update observers of the current subject node
	 */
	@Override
	public void notifyObservers(Node node) {
		node.backupNodes.forEach((n)->n.updateNode());
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
	
	/**
	 * This method is used to update the count from the subject node and call
	 * notifyAll() observers method to update corresponding observers.
	 */
	@Override
	public void update() {
		this.updateNode();
		notifyObservers(this);
	}
	/**
	 * This method updates the count of node by 1
	 */
	public void updateNode() {
		count = count+1;
	}
	
	/**
	 * returns the data and count of node in String format
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getData()).append(": ").append(this.count);
		return sb.toString();
	}
	 

}
