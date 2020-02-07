package visitor;

import java.util.List;

import visitor.intefaces.LongFileVisitor;

public class CountFileVisitor implements LongFileVisitor{

	@Override
	public Long visit(Directory directory) {
		long count = 0;
		List<AbstractFile> contents = directory.getContents();
		CountFileVisitor visitor = new CountFileVisitor();
		for(AbstractFile file : contents) {
			count += file.accept(visitor);
		}
		
		return count;
	}

	@Override
	public Long visit(LeafFile file) {
		// TODO Auto-generated method stub
		return (long) 1;
	}

}
