package visitor;

import java.util.List;

import visitor.intefaces.StringFileVisitor;

public class LsFileVisitor implements StringFileVisitor{

	@Override
	public String visit(Directory directory) {
		StringBuilder sb = new StringBuilder();
		sb.append(directory.printTabs()).append(directory.getName()).append("\n");
		List<AbstractFile> contents = directory.getContents();
		LsFileVisitor visitor = new LsFileVisitor();
		for(AbstractFile file : contents) {
			sb.append(file.accept(visitor));
		}
		return sb.toString();
		
	}

	@Override
	public String visit(LeafFile file) {
		StringBuilder sb = new StringBuilder();
		sb.append(file.printTabs()).append(file.getName()).append("\n");
		return sb.toString();
		
	}

}
