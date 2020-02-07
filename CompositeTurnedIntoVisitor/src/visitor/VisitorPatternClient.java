package visitor;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

public class VisitorPatternClient {

	public static void main(String args[]) {
		System.out.println("test");
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		chooser.setDialogTitle("Select Directory");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		
		

		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File selectedDirectory = chooser.getSelectedFile();

			AbstractFile topDir = new Directory(selectedDirectory);
			
			LsFileVisitor lsVisitor = new LsFileVisitor();
			CountFileVisitor countVisitor = new CountFileVisitor();
			SizeFileVisitor sizeVisitor = new SizeFileVisitor();
			
			System.out.println(topDir.accept(lsVisitor));
			System.out.println(topDir.accept(sizeVisitor));
			System.out.println(topDir.accept(countVisitor));
			
			MutableTreeNodeFileVisitor nodeFileVisitor = new MutableTreeNodeFileVisitor();
			
			JFrame frame = new JFrame();
			JTree tree = new JTree(topDir.accept(nodeFileVisitor));
			JScrollPane scrollPane = new JScrollPane(tree);
			frame.getContentPane().add(scrollPane);
			frame.pack();
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
}
