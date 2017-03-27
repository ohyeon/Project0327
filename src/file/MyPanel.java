package file;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	JLabel label;
	JButton bt;
	
	public MyPanel(String title, Icon icon) {
		label = new JLabel(title);
		bt = new JButton(icon);
		
		setLayout(new BorderLayout());
		setBackground(Color.orange);
		
		bt.setBorderPainted(false);//��輱 ���ֱ�
		bt.setContentAreaFilled(false);//�� ä��� ����
		bt.setFocusPainted(false);//��Ŀ���� ���� ��� ���ֱ�
		bt.setOpaque(false);//���� ������
		
		add(label, BorderLayout.NORTH);
		add(bt);
	}
}
