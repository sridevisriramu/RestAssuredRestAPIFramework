package com.test.utils;

public enum EndPointURL {
	
	GET_COUNTRY("/country/get/all"),
	
	GET_COUNTRY_2("/all"),
	GET_CITY("/Hyderabad");
	
	String resourcePath;
	
	EndPointURL(String resourcePath)
	{
		this.resourcePath= resourcePath;
	}
	public String getResourcepath()
	{
		return this.resourcePath;
	}
	
	public String getResourcepath(String data)
	{
		return this.resourcePath+data;
	}

	
}
