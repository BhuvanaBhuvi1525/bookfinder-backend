package com.bhuvi.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("llmsearch")
public class LLMController {

	@Autowired
	LLMService llmservice;
@GetMapping("extendsearch")
public ResponseEntity<ExtendedSearchDTO> extendSearch(@RequestParam String query){
	return ResponseEntity.ok((new ExtendedSearchDTO(llmservice.extendSearch(query))));
}

@GetMapping("suggest")
public ResponseEntity<SuggestionDTO> suggestion(@RequestParam String title){
	return ResponseEntity.ok(new SuggestionDTO(llmservice.suggestBooks(title)));
}

@GetMapping("summary")
public ResponseEntity<SummaryDTO> summary(@RequestParam String title){
	return ResponseEntity.ok(new SummaryDTO(llmservice.summarizeTitle(title)));
}

}
