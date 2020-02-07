package visitor;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import visitor.intefaces.DefaultMutableTreeNodeFileVisitor;

public class MutableTreeNodeFileVisitor implements DefaultMutableTreeNodeFileVisitor
{

	@Override
	public DefaultMutableTreeNode visit(Directory directory) {
		DefaultMutableTreeNode parentNode = new DefaultMutableTreeNode(directory.getName());
		List<AbstractFile> contents = directory.getContents();
		MutableTreeNodeFileVisitor visitor = new MutableTreeNodeFileVisitor();
		for(AbstractFile file : contents) {
			parentNode.add(file.accept(visitor));
		}
		return parentNode;
	}

	@Override
	public DefaultMutableTreeNode visit(LeafFile file) {
		return new DefaultMutableTreeNode(file.getName());
	}

}
