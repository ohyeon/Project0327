/*
 *아이콘 생성시 그 크기를 조정하려면 코드가 복잡하므로, 
 *앞으로 재사용 가능성을 염두해 두고 
 *나만의 재조정 이미지 아이콘을 새로 정의해본다. 
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
		//크기를 재 조정한 후 결과적으로 이미지 객체를 다시 반환
		this.setImage(result);
	}
}
