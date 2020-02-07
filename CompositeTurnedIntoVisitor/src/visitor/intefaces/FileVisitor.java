package visitor.intefaces;

import visitor.Directory;
import visitor.LeafFile;

public interface FileVisitor<T>
{
	public T visit(Directory directory);
	public T visit(LeafFile file);
}