package file;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;

public class FileWindow extends JFrame{
	MyPanel mp;
	MyIcon folder_on, folder_off; 
	ArrayList<String> list = new ArrayList<String>();
	
	public FileWindow() {
		setLayout(new FlowLayout());

		folder_on = new MyIcon(this.getClass().getResource("/folder_on.png"), 50, 50);
		folder_off = new MyIcon(this.getClass().getResource("/folder_off.png"), 50, 50);
		
		list = getDirList();
		
		for (int i = 0; i < list.size(); i++) {
			String dirName = list.get(i);
			mp = new MyPanel(dirName, folder_off);
			
			add(mp);
		}
		

		
		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//원하는 경로에 하위 디렉토리/파일 구하기
	public ArrayList<String> getDirList() {
		File file = new File("c:/");
		File[] fileList = file.listFiles();
		ArrayList<String> dirList = new ArrayList<String>();
		
		for (int i = 0; i < fileList.length; i++) {
			if (fileList[i].isDirectory()) {
				dirList.add(fileList[i].getName());
			}
		}
		
		return dirList;
	}
	
	public static void main(String[] args) {
		new FileWindow();
	}

}
