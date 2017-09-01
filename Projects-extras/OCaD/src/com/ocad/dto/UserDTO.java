package com.ocad.dto;

import java.awt.Image;

import org.apache.tomcat.jni.File;

public class UserDTO{
	private Image profilePic;
	public Image getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(Image profilePic) {
		this.profilePic = profilePic;
	}
	private  String userId;
	private String username;
	private  String emailId;
	private  String password;
	private  String Fname;
	private  String Mname;
	private  String Lname;
	private  String dob;
	private  String address;
	private  String mobNo;
	private String gender;
	private String occupation;
	private String companyName;
	private String securityQue;
	private String securityAns;
	private String state;
	private String city;
	private String country;
	private String pinCode;
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the fname
	 */
	public String getFname() {
		return Fname;
	}
	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		Fname = fname;
	}
	/**
	 * @return the mname
	 */
	public String getMname() {
		return Mname;
	}
	/**
	 * @param mname the mname to set
	 */
	public void setMname(String mname) {
		Mname = mname;
	}
	/**
	 * @return the lname
	 */
	public String getLname() {
		return Lname;
	}
	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		Lname = lname;
	}
	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the mobNo
	 */
	public String getMobNo() {
		return mobNo;
	}
	/**
	 * @param mobNo the mobNo to set
	 */
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the occupation
	 */
	public String getOccupation() {
		return occupation;
	}
	/**
	 * @param occupation the occupation to set
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the securityQue
	 */
	public String getSecurityQue() {
		return securityQue;
	}
	/**
	 * @param securityQue the securityQue to set
	 */
	public void setSecurityQue(String securityQue) {
		this.securityQue = securityQue;
	}
	/**
	 * @return the securityAns
	 */
	public String getSecurityAns() {
		return securityAns;
	}
	/**
	 * @param securityAns the securityAns to set
	 */
	public void setSecurityAns(String securityAns) {
		this.securityAns = securityAns;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the pinCode
	 */
	public String getPinCode() {
		return pinCode;
	}
	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", username=" + username
				+ ", emailId=" + emailId + ", password=" + password
				+ ", Fname=" + Fname + ", Mname=" + Mname + ", Lname=" + Lname
				+ ", dob=" + dob + ", address=" + address + ", mobNo=" + mobNo
				+ ", gender=" + gender + ", occupation=" + occupation
				+ ", companyName=" + companyName + ", securityQue="
				+ securityQue + ", securityAns=" + securityAns + ", state="
				+ state + ", city=" + city + ", country=" + country
				+ ", pinCode=" + pinCode + ", getUserId()=" + getUserId()
				+ ", getUsername()=" + getUsername() + ", getEmailId()="
				+ getEmailId() + ", getPassword()=" + getPassword()
				+ ", getFname()=" + getFname() + ", getMname()=" + getMname()
				+ ", getLname()=" + getLname() + ", getDob()=" + getDob()
				+ ", getAddress()=" + getAddress() + ", getMobNo()="
				+ getMobNo() + ", isGender()=" + getGender()
				+ ", isOccupation()=" + getOccupation() + ", getCompanyName()="
				+ getCompanyName() + ", getSecurityQue()=" + getSecurityQue()
				+ ", getSecurityAns()=" + getSecurityAns() + ", getState()="
				+ getState() + ", getCity()=" + getCity() + ", getCountry()="
				+ getCountry() + ", getPinCode()=" + getPinCode()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}