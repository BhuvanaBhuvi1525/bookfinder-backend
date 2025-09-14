package com.bhuvi.demo;

public class BookDTO {
  private String title;
 private String author;
 private Integer PublishYear;
 private String CoverId;
 private String ImageURL;
 public BookDTO(String title, String author, Integer publishYear, String coverId) {
	
	this.title = title;
	this.author = author;
	this.PublishYear = publishYear;
	this.CoverId = coverId;
	this.ImageURL=(CoverId!=null)?"https://covers.openlibrary.org/b/id/" + coverId + "-L.jpg"
			:null;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public Integer getPublishYear() {
	return PublishYear;
}

public void setPublishYear(Integer publishYear) {
	PublishYear = publishYear;
}

public String getCoverId() {
	return CoverId;
}

public void setCoverId(String coverId) {
	CoverId = coverId;
}

public String getImageURL() {
	return ImageURL;
}

public void setImageURL(String imageURL) {
	ImageURL = imageURL;
}
 
 
 
}
