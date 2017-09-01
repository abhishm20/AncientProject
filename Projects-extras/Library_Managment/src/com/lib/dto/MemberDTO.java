package com.lib.dto;

public class MemberDTO {
	private String name;
	private String mem_id;
	private String branch;
	@Override
	public String toString() {
		return "MemberDTO [name=" + name + ", mem_id=" + mem_id + ", branch="
				+ branch + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}

}
 