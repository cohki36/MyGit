package jp.scubism.cohki.mygit.controller;

import jp.scubism.cohki.mygit.model.CommitManager;
import jp.scubism.cohki.mygit.util.StandardIO;

/**
 *
 * @author Koki Morii
 *
 */
public class CommandStrategyCommit implements CommandStrategy {

	public static final String OPTION_AMEND = "-amend";
	private String[] readStrArray;

	public CommandStrategyCommit(String[] readStrArray){
		this.readStrArray = readStrArray;
	}

	@Override
	public String run() {
		CommitManager manager = CommitManager.getInstance();
		String ret = "";

		// commit
		if(readStrArray.length == 2){
			StandardIO.output("Please input a commit coment.");
			String comment = StandardIO.input();
			if(comment != null){
				manager.addNewCommit(comment, null);
				ret = manager.getPrintString();
			}
		}
		// commit -amend
		else if(readStrArray.length == 3 && readStrArray[2].equals(OPTION_AMEND)){
			StandardIO.output("Please input a commit coment.");
			String comment = StandardIO.input();
			if(comment != null){
				manager.amendCommit(comment, null);
				ret = manager.getPrintString();
			}
		}

		return ret;
	}

}
