package visitor;

import javax.swing.tree.DefaultMutableTreeNode;

import visitor.intefaces.DefaultMutableTreeNodeFileVisitor;
import visitor.intefaces.LongFileVisitor;
import visitor.intefaces.StringFileVisitor;

public class LeafFile extends AbstractFile {
	private long size;
	
	public long getSize()
	{
		return size;
	}
	
	protected LeafFile(String name, int depth, long size) {
		super(name, depth);
		this.size = size;
	}


	@Override
	public String accept(StringFileVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public Long accept(LongFileVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public DefaultMutableTreeNode accept(DefaultMutableTreeNodeFileVisitor visitor) {
		return visitor.visit(this);
	}
}
