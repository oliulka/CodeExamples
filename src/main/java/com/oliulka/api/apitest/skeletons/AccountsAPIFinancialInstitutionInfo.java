package com.oliulka.api.apitest.skeletons;

public class AccountsAPIFinancialInstitutionInfo {
	private String id;
	private String updatedAt;
	private String createdAt;
	private String name;
	private String url;
	
	
    public AccountsAPIFinancialInstitutionInfo(String id, String updatedAt,  String createdAt, String name, String url)
	{
		this.id = id;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
		this.name = name;
		this.url = url;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
