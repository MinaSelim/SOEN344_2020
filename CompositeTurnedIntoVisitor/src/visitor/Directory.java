package visitor;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import visitor.intefaces.DefaultMutableTreeNodeFileVisitor;
import visitor.intefaces.LongFileVisitor;
import visitor.intefaces.StringFileVisitor;

public class Directory extends AbstractFile {
	private List<AbstractFile> contents = new ArrayList<AbstractFile>();
	
	public List<AbstractFile> getContents(){
		return contents;
	}
	
	public Directory(java.io.File directory) {
		this(directory, 0);
	}

	private Directory(java.io.File directory, int depth) {
		super(directory.getName(), depth);
		java.io.File[] files = directory.listFiles();
		for (java.io.File file : files) {
			if (file.isDirectory()) {
				contents.add(new Directory(file, depth + 1));
			} else {
				contents.add(new LeafFile(file.getName(), depth + 1, file.length()));
			}
		}
	}
	
	private Directory(String name, int depth) {
		super(name, depth);
	}
	
	public String accept(StringFileVisitor visitor)
	{
		return visitor.visit(this);
	}
	
	public Long accept(LongFileVisitor visitor)
	{
		return visitor.visit(this);
	}

	@Override
	public DefaultMutableTreeNode accept(DefaultMutableTreeNodeFileVisitor visitor) {
		return visitor.visit(this);
	}
}
