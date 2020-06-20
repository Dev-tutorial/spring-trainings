package com.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springmvc.model.VideoSelection;

@Service
public class VideoServiceImpl implements VideoService {
	
	/* (non-Javadoc)
	 * @see com.springmvc.service.VideoService#findAllCategories()
	 */
	public List<VideoSelection> findAllCategories(){
		
		List<VideoSelection> categories = new ArrayList<VideoSelection>();
		VideoSelection recent = new VideoSelection();
		recent.setCategory("recently viewed");
		categories.add(recent);
		VideoSelection bollywood = new VideoSelection();
		bollywood.setCategory("bollywood");
		categories.add(bollywood);
		VideoSelection hollywood = new VideoSelection();
		hollywood.setCategory("Hollywood");
		categories.add(hollywood);
		VideoSelection kids = new VideoSelection();
		kids.setCategory("Kids movies");
		categories.add(kids);
		return categories;
	}
}
