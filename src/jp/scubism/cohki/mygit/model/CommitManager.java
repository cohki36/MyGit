package jp.scubism.cohki.mygit.model;

import java.util.LinkedList;

/**
 *
 * @author Koki Morii
 *
 */
public class CommitManager {
	private static CommitManager instance = new CommitManager();
	private LinkedList<Commit> commitList = new LinkedList<Commit>();
	private int currentCommitId = 0;
	private String currentBranchName = "master";
	private int sequenceNum = 0;

	private CommitManager(){
		// Initial Commit
		commitList.add(new Commit(0,
								  null,
								  null,
								  new Branch("master", true, -1)));
	}

	public static CommitManager getInstance(){
		return CommitManager.instance;
	}

	/**
	 * Commit
	 * @param comment
	 * @param data
	 */
	public void addNewCommit(String comment, String data){

		int previousCommitId = currentCommitId;
		currentCommitId = ++sequenceNum;
		commitList.add(new Commit(currentCommitId,
								  comment,
								  data,
								  new Branch(currentBranchName,
										  	 false,
										  	 previousCommitId)));
	}

	/**
	 * Amend
	 * @param comment
	 * @param data
	 */
	public void amendCommit(String comment, String data){
		Commit currentCommit = getCommitById(currentCommitId);
		int previousCommitId = currentCommit.getPreviousCommitId(currentBranchName);

		currentCommit.deleteBranch(currentBranchName);

		currentCommitId = ++sequenceNum;
		commitList.add(new Commit(currentCommitId,
								  comment,
								  data,
								  new Branch(currentBranchName,
										  	 false,
										  	 previousCommitId)));

	}

	private Commit getCommitById(int id){
		Commit ret = null;
		for(Commit commit: commitList){
			if(commit.getId() == id){
				ret = commit;
			}
		}
		return ret;
	}

	public void changeCurrentBranch(String branchName){
		this.currentBranchName = branchName;
	}

	public void createBranch(String branchName, int commitId){
		for(Commit commit: commitList){
			if(commit.getId() == commitId){
				commit.addNewBranch(new Branch(branchName,
											   true,
											   -1));
				this.changeCurrentBranch(branchName);
				break;
			}
		}
	}

	public String getPrintString(){
		String ret = "";
		ret += "------Commit Topology-----------------------------------------\n";
		ret += "[" + currentBranchName + "]";
		int previousCommitId = -1;
		boolean previousCommitFlag = false;

		for(int i=commitList.size()-1; i>=0; i--){
			Commit commit = commitList.get(i);
			if(commit.findBranch(currentBranchName)){
				ret += " --> | ";
				ret += commit.getId();

				if(previousCommitId == commit.getId() && !previousCommitFlag){
					ret += " [" + currentBranchName + "^]";
					previousCommitFlag = true;
				}
				if(commit.isHead(currentBranchName)){
					ret += " [HEAD]";
				}
				ret += " |";
				if(!previousCommitFlag){
					previousCommitId = commit.getPreviousCommitId(currentBranchName);
				}
			}
		}
		ret += "\n--------------------------------------------------------------";
		return ret;
	}
}
