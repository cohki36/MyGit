package jp.scubism.cohki.mygit.controller;

import jp.scubism.cohki.mygit.model.CommitManager;

/**
 *
 * @author Koki Morii
 *
 */
public class CommandStrategyCheckout implements CommandStrategy{

	public static final String OPTION_B = "-b";
	private String[] readStrArray;

	public CommandStrategyCheckout(String[] readStrArray){
		this.readStrArray = readStrArray;
	}

	public String run(){
		CommitManager manager = CommitManager.getInstance();
		String ret = "";

		// checkout
		if(readStrArray.length == 3){
			String branchName = readStrArray[2];
			if(branchName != null){
				manager.changeCurrentBranch(branchName);
				ret = manager.getPrintString();
			}
		}
		// checkout -b
		if(readStrArray.length == 5 && readStrArray[2].equals(OPTION_B)){
			String branchName = readStrArray[3];
			int commitId = Integer.valueOf(readStrArray[4]);
			if(branchName != null){
				manager.createBranch(branchName, commitId);
				ret = manager.getPrintString();
			}

		}

		return ret;
	}
}
