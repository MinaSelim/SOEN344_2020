package visitor;

import javax.swing.tree.DefaultMutableTreeNode;

import visitor.intefaces.DefaultMutableTreeNodeFileVisitor;
import visitor.intefaces.LongFileVisitor;
import visitor.intefaces.StringFileVisitor;

public abstract class AbstractFile {
	private String name;
	private int depth;
	
	protected AbstractFile(String name, int depth) {
		this.name = name;
		this.depth = depth;
	}

	public String getName() {
		return name;
	}

	protected String printTabs() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<depth; i++) {
			sb.append("\t");
		}
		return sb.toString();
	}

	public abstract String accept(StringFileVisitor visitor);
	public abstract Long accept(LongFileVisitor visitor);
	public abstract DefaultMutableTreeNode accept(DefaultMutableTreeNodeFileVisitor visitor);
}
