/*
 *������ ������ �� ũ�⸦ �����Ϸ��� �ڵ尡 �����ϹǷ�, 
 *������ ���� ���ɼ��� ������ �ΰ� 
 *������ ������ �̹��� �������� ���� �����غ���. 
*/
package file;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class MyIcon extends ImageIcon{
	
	public MyIcon(URL url, int width, int height) {
		super(url);//URL : Uniformed Resource Locator
		
		Image scaledImg = this.getImage();
		Image result =  scaledImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		//ũ�⸦ �� ������ �� ��������� �̹��� ��ü�� �ٽ� ��ȯ
		this.setImage(result);
	}
}
