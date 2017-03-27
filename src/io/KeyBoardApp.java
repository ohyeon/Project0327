/*
FileInputStream���� �����ڰ� ���ϴ� ������ ��Ʈ���� ������ �� ������,
Ű����� ���� ǥ�� �Է� �ϵ������ ��쿣 �ڹٰ� �������� �������� ���ϰ� �ش�os�� �����ϹǷ�, 
�ڹ� �����ڴ� os�� ���� ǥ���Է� ��Ʈ���� ���;��Ѵ�.

�ڹ��� Ŭ������ System Ŭ������ static������� �� 
�� has a ����� ������ InputStream�� in��ü�� �ٷ� ǥ�� �Է� ��Ʈ���� �޾Ƴ��� ��ü�̴�. 
���� ���ÿ� �׳� System.in;�� ����Ѵ�.

���� ��� ��Ʈ�� Ŭ������ �̸� ��Ģ
�Է� : ~~Reader
��� : ~~Writer
*/
package io;

import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class KeyBoardApp {
	public static void main(String[] args) {
		InputStream is = System.in;

		//���� ��� ��Ʈ���� �ܵ����� �����ϴ� ���� �ƴ϶�, �̹� ����Ʈ ��� ��Ʈ���� ������ �Ѵ�.
		//������ �������� �μ��� ����Ʈ ��� ��Ʈ���� �ִ´�.
		InputStreamReader reader = null;
		reader = new InputStreamReader(is);

		int data;

		try {
			while (true) {
				data = reader.read();//�����ڵ�� �� �ѱ���.
				System.out.print((char)data);
			}
			
		}	catch (IOException e) {
			
		}

	}
}
