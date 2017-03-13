package wordCount.util;

import wordCount.dsForStrings.Node;

public interface Subject {
	public void registerObserver(Node n);
	public void removeObserver(Node n);
	public void notifyObservers(Node n);
}
