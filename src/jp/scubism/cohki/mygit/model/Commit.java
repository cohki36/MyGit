package jp.scubism.cohki.mygit.model;

import java.util.LinkedList;

/**
 *
 * @author Koki Morii
 *
 */
public class Commit {
	private int id;
	private String comment;
	private String data;
	private LinkedList<Branch> branchList = new LinkedList<Branch>();

	public Commit(int id, String comment, String data, Branch branch){
		this.id = id;
		this.comment = comment;
		this.data = data;
		this.branchList.add(branch);
	}

	public void addNewBranch(Branch branch){
		if(!findBranch(branch.getName())){
			branchList.add(branch);
		}
	}

	public boolean findBranch(String branchName){
		boolean ret = false;
		for(Branch branch: branchList){
			if(branch.getName().equals(branchName)){
				ret = true;
			}
		}
		return ret;
	}

	public void deleteBranch(String branchName){
		for(int i=branchList.size()-1; i>=0; i--){
			Branch branch = branchList.get(i);
			if(branch.getName().equals(branchName)){
				branchList.remove(i);
				break;
			}
		}
	}

	public boolean isHead(String branchName){
		boolean ret = false;
		for(Branch branch: branchList){
			if(branch.getName().equals(branchName)){
				if(branch.isHead()){
					ret = true;
				}
			}
		}
		return ret;
	}

	public int getPreviousCommitId(String branchName){
		int ret = -1;
		for(Branch branch: branchList){
			if(branch.getName().equals(branchName)){
				ret = branch.getPreviousCommitId();
			}
		}
		return ret;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
