package com.oliulka.api.apitest.skeletons;

public class AccountsAPIUserInfo {

	private String id;
	private String updatedAt;
	private String createdAt;

	
    public AccountsAPIUserInfo(String id, String updatedAt, String createdAt)
	{
		this.id = id;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
	}
  
    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
    
	 public String toString()
	 {
		 return id + "," + updatedAt +"," + createdAt;
	 }
}
