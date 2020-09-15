package com.zensar.myfirstproject.beans;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {

	public static void main(String[] args) {
		InputStream fis = null;
		OutputStream fos = null;
		
		try {
			fis = new FileInputStream("abc.txt");
			fos = new FileOutputStream("xyz.txt");
			int ch = 0;
			while ((ch = fis.read()) != -1) {
				System.out.print((char) ch);
				fos.write((char) ch);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fis != null ) {
					fis.close();
				
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/*
		 * Scanner sc = new Scanner(System.in); String name = sc.nextLine(); try { fos =
		 * new FileOutputStream("abc.txt"); for (int i = 0; i < name.length(); i++) {
		 * fos.write(name.charAt(i)); }
		 * 
		 * } catch (FileNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } finally { try { fos.close(); } catch
		 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); } }
		 */
	}

}
