package jp.scubism.cohki.mygit.controller;

/**
 *
 * @author Koki Morii
 *
 */
public class CommandStrategyFactory {

	public static final String COMMAND_GIT = "git";
	public static final String COMMAND_COMMIT = "commit";
	public static final String COMMAND_CHECHOUT = "checkout";

	public static CommandStrategy concreate(String readLine){
		CommandStrategy ret = new NullCommandStrategy();

		if(readLine != null){
			String[] readArrayStr = readLine.split("[\\s]+");

			if(readArrayStr.length > 1 && readArrayStr[0].equals(COMMAND_GIT)){
				if(readArrayStr[1].equals(COMMAND_COMMIT)){
					ret = new CommandStrategyCommit(readArrayStr);
				}
				if(readArrayStr[1].equals(COMMAND_CHECHOUT)){
					ret = new CommandStrategyCheckout(readArrayStr);
				}
			}
		}
		return ret;
	}
}
