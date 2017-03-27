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
		
		bt.setBorderPainted(false);//경계선 없애기
		bt.setContentAreaFilled(false);//색 채우기 없음
		bt.setFocusPainted(false);//포커스에 의한 경계 없애기
		bt.setOpaque(false);//투명 해지기
		
		add(label, BorderLayout.NORTH);
		add(bt);
	}
}
