package jp.scubism.cohki.mygit.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Koki Morii
 *
 */
public class StandardIO {

	public static String input(){
		String ret = null;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			ret = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static void output(String str){
		System.out.println(str);
	}
}
