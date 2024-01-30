package com.demo;



public class Employee
{
	private int Eid;
	private String Ename;
	private String Address;
	private long MobileNo;
	private long AAdharNo;
	private String Gender;
	
	
	public int getEid() {
		return Eid;
	}
	public void setEid(int eid) {
		Eid = eid;
	}
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		Ename = ename;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public long getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(long mobileNo) {
		MobileNo = mobileNo;
	}
	public long getAAdharNo() {
		return AAdharNo;
	}
	public void setAAdharNo(long aAdharNo) {
		AAdharNo = aAdharNo;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}	
	
	@Override
	public String toString() {
		return "Employee [Eid=" + Eid + ", Ename=" + Ename + ", Address=" + Address + ", MobileNo=" + MobileNo
				+ ", AAdharNo=" + AAdharNo + ", Gender=" + Gender + "]";
	}

	
	
}