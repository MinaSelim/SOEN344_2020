package visitor;

import java.util.List;

import visitor.intefaces.LongFileVisitor;

public class SizeFileVisitor implements LongFileVisitor{

	@Override
	public Long visit(Directory directory) {
		long size = 0;
		List<AbstractFile> contents = directory.getContents();
		SizeFileVisitor visitor = new SizeFileVisitor();
		for(AbstractFile file : contents) {
			size += file.accept(visitor);
		}
		return size;
	}

	@Override
	public Long visit(LeafFile file) {
		return file.getSize();
	}

}
