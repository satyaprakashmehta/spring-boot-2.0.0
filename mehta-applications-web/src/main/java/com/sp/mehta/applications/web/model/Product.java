package com.sp.mehta.applications.web.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;

import org.springframework.web.multipart.MultipartFile;

public class Product implements Serializable {
	private static final long serialVersionUID = -8434527366176988223L;

	private String name;
	private String description;

	private List<MultipartFile> images;

	@Column(name = "name", length = 10, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 1000)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "images")
	public List<MultipartFile> getImages() {
		return images;
	}

	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}
}