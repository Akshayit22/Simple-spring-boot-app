package com.springboot.springboot_first_app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;
import com.springboot.springboot_first_app.entity.JournalEntry;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
	
	private Map<Long ,JournalEntry> journalEntries = new HashMap<>();
	
	@GetMapping
	public List<JournalEntry> getAll(){
		return new ArrayList<>(journalEntries.values());
	}
	
	@PostMapping
	public boolean createEntry(@RequestBody JournalEntry myEntry) {
		journalEntries.put(myEntry.getId(), myEntry);
		return true;
	}
	
	@GetMapping("id/{myId}")
	public JournalEntry getJournalById(@PathVariable Long myId) {
		return journalEntries.get(myId);
	}
	
	@DeleteMapping("id/{myId}")
	public JournalEntry deleteJournalById(@PathVariable Long myId) {
		return journalEntries.remove(myId);
	}
	
	@PutMapping("id/{myId}")
	public JournalEntry updateJournalById(@PathVariable Long myId, @RequestBody JournalEntry myEntry) {
		return journalEntries.put(myId,myEntry);
	}

}
