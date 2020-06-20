package com.springmvc.service;

import java.util.List;

import com.springmvc.model.VideoSelection;

public interface VideoService {

	List<VideoSelection> findAllCategories();

}