package jp.scubism.cohki.mygit.model;

/**
 *
 * @author Koki Morii
 *
 */
public class Branch {

	private String name;
	private boolean isHead;
	private int previousCommitId;

	public Branch(String name, boolean isHead, int previousCommitId) {
		this.name = name;
		this.isHead = isHead;
		this.previousCommitId = previousCommitId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isHead() {
		return isHead;
	}
	public void setHead(boolean isHead) {
		this.isHead = isHead;
	}
	public int getPreviousCommitId() {
		return previousCommitId;
	}
	public void setPreviousCommitId(int previousCommitId) {
		this.previousCommitId = previousCommitId;
	}

}
