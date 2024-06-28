package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.mapper.BookmarkMapper;

@Service
public class BookmarkBO {
	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	public List<Bookmark> getBookmarkList() {
		return bookmarkMapper.selectBookmarkList();
	}
	
	public void addBookmark(String name, String url) {
		bookmarkMapper.insertBookmark(name, url);
	}
	
	// input: url
	// output: boolean
	
	public boolean isDuplicaitonByUrl(String url) {
		// 중복[bookmark1, bookmark2] true       중복 아님: [] false
		List<Bookmark> bookmarkList = bookmarkMapper.selectBookmarkListByUrl(url);
		return bookmarkList.isEmpty() ? false : true;
		// return bookmarkList.isEmpty()
	}
	
	public int deleteBookmarkById(String id) {
		return bookmarkMapper.deleteBookmarkById(id);
	}
	
	
}
