package wordCount.visitors;

import wordCount.dsForStrings.TreeInterface;
import wordCount.util.FileProcessor;

public class PopulateVisitor implements DSProcessingVisitorI {
	FileProcessor fp;
	
	public PopulateVisitor(FileProcessor fpIn) {
		fp = fpIn;
	}
	public FileProcessor getFp() {
		return fp;
	}
	public void setFp(FileProcessor fp) {
		this.fp = fp;
	}
	
	public void visit(TreeInterface bst) {
		String input_line = null;
		try {
				while((input_line = fp.readInputLine())!= null)
				{
//					System.out.println(input_line);
//					input_line = input_line.replace(" / +(?= )/g"," ");
					String[] words = input_line.split("\\W+");
//					String[] words = input_line.split(" ");
					for(String word:words)
					{
						if(word.trim().length()!=0)
						{
							bst.insert(word);
						}
					}
				}
			} 
			catch (Exception e) 
			{
				System.out.println(e.toString());
				System.exit(1);
			}
	}

}
