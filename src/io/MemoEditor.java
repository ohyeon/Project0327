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
	OutputStreamWriter writer;//���� ����� ��� ��Ʈ��
	PrintWriter writer2;//���� ����� ��� ��Ʈ��
	BufferedReader buffr;//����ó���� ���ڱ���Է½�Ʈ��

	public MemoEditor() {
		p_north = new JPanel();
		icon = new ImageIcon("C:/java_workspace2/Project0327/res/folder_on.png");
		bt_open = new JButton(icon);
		bt_save = new JButton("����");
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
			//���� ��� ��Ʈ������ ���� ����� �Ӽ��� ������ �� �ִ�.
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
			JOptionPane.showMessageDialog(this, "������ �������� �ʽ��ϴ�.");
			e.printStackTrace();//�����ڸ� ���� ���� �α� ����
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
			writer = new OutputStreamWriter(fos, "utf-8");//���� ���ڰ� ����
			writer2 = new PrintWriter(fos);
			
			writer2.write(area.getText());
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "������ �������� �ʽ��ϴ�.");
			e.printStackTrace();
		} /*catch (UnsupportedEncodingException e) {
			JOptionPane.showMessageDialog(this, "encoding�� �߸� ������.");
			e.printStackTrace();
		}*/ catch (IOException e) {
			JOptionPane.showMessageDialog(this, "����� ����");
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
