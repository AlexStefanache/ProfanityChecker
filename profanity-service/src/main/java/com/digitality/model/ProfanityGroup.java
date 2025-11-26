package com.digitality.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection="profanity")
public class ProfanityGroup{
	@MongoId
	private String code;
	private List<String> profanities;
	
	protected ProfanityGroup() {}
	public ProfanityGroup(String code, List<String> profanities) {
		this.code = code;
		this.profanities = profanities;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<String> getProfanities() {
		return profanities;
	}
	public void setProfanities(List<String> profanities) {
		this.profanities = profanities;
	}
}
