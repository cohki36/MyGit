package jp.scubism.cohki.mygit.controller;

/**
 *
 * @author Koki Morii
 *
 */
public class NullCommandStrategy implements CommandStrategy {

	@Override
	public String run() {
		return "Invalid command..";
	}

}
