package jp.scubism.cohki.mygit.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.scubism.cohki.mygit.controller.CommandStrategyFactory;

/**
 *
 * @author Koki Morii
 *
 */
public class MyGitMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String readLine = null;
			System.out.printf("MyGit > ");
			while((readLine = reader.readLine()) != null){
				System.out.println(CommandStrategyFactory.concreate(readLine).run());
				System.out.printf("MyGit > ");
			}
			System.out.println("exit..");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
