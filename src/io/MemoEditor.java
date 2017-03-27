package io;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemoEditor extends JFrame{
	JPanel p_north;
	JButton bt_open, bt_save;
	ImageIcon icon;
	JTextArea area;
	JScrollPane scroll;
	
	String ori = "C:/java_workspace2/Project0327/res/memo.txt";
	String dest = "C:/java_workspace2/Project0327/res/memo_copy.txt";
	FileInputStream fis;
	FileOutputStream fos;
	InputStreamReader reader;
	OutputStreamWriter writer;//문자 기반의 출력 스트림
	PrintWriter writer2;//문자 기반의 출력 스트림
	BufferedReader buffr;//버퍼처리된 문자기반입력스트림

	public MemoEditor() {
		p_north = new JPanel();
		icon = new ImageIcon("C:/java_workspace2/Project0327/res/folder_on.png");
		bt_open = new JButton(icon);
		bt_save = new JButton("저장");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		
		bt_open.setBorderPainted(false);
		bt_open.setContentAreaFilled(false);
		bt_open.setFocusPainted(false);
		bt_open.setOpaque(false);
		
		p_north.add(bt_open);
		p_north.add(bt_save);
		
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		bt_open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});
		
		bt_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		
		setSize(1100, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void open() {
		try {
			fis = new FileInputStream(ori);
			//문자 기반 스트림에는 문자 인토딩 속성을 지정할 수 있다.
			reader = new InputStreamReader(fis, "utf-8");
			buffr = new BufferedReader(reader);
			
			//int data;
			String data;
			int count = 0;
			
			while (true) {
				//data = reader.read();
				data = buffr.readLine();
				count++;
				
				if (data == null) {
					break;
				}
				
				area.append(data + "\n");
				//area.append(Character.toString((char)data));	
			}
			
			System.out.println(count);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "파일이 존재하지 않습니다.");
			e.printStackTrace();//개발자를 위한 에러 로그 정보
		} catch (IOException e) {
			e.printStackTrace();
		} /*finally {
			try {
				if (writer != null) {
					writer.close();
				}
				if (fos != null) {
					fos.close();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}*/
	}
	
	public void save() {
		try {
			fos = new FileOutputStream(dest);
			writer = new OutputStreamWriter(fos, "utf-8");//사용시 문자가 깨짐
			writer2 = new PrintWriter(fos);
			
			writer2.write(area.getText());
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "파일이 존재하지 않습니다.");
			e.printStackTrace();
		} /*catch (UnsupportedEncodingException e) {
			JOptionPane.showMessageDialog(this, "encoding을 잘못 적었다.");
			e.printStackTrace();
		}*/ catch (IOException e) {
			JOptionPane.showMessageDialog(this, "입출력 에러");
			e.printStackTrace();
		} finally {
			try {
				if (writer2 != null) {
					writer2.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new MemoEditor();
	}

}
