package com.bhuvi.demo;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {

public List<BookDTO> searchbooks(String query){
	String url= "https://openlibrary.org/search.json?q=" + URLEncoder.encode(query, StandardCharsets.UTF_8);
	RestTemplate resttemp = new RestTemplate();
	String rawjson=resttemp.getForObject(url, String.class);
	
	List<BookDTO> books = new ArrayList<>();
	JSONObject json =new JSONObject(rawjson);
	JSONArray docs = json.getJSONArray("docs");
	
	for(int i=0;i<docs.length();i++) {
		JSONObject doc=docs.getJSONObject(i);
		String title=doc.optString("title");
		String author =doc.has("author_name")?doc.getJSONArray("author_name").optString(0) : "unknown";
		Integer year=doc.optInt("first_publish_year", 0);
        String coverId=doc.has("cover_i")?doc.get("cover_i").toString():null;
        books.add(new BookDTO(title,author,year,coverId));
	}
	return books;
}
}
