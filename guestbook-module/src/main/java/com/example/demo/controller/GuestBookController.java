package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.GuestBook;
import com.example.demo.service.IGuestBookService;
import java.util.List;

@RestController
@RequestMapping("/api/guestbook")
public class GuestBookController {

    private final IGuestBookService service;

    public GuestBookController(IGuestBookService service) {
        this.service = service;
    }

    // ✅ Customer: Add new guestbook entry
    @PostMapping("/add")
    public GuestBook addEntry(@RequestBody GuestBook entry) {
        return service.addEntry(entry);
    }

    // ✅ Public/Admin: View all entries
    @GetMapping("/all")
    public List<GuestBook> getAllEntries() {
        return service.getAllEntries();
    }

    // ✅ Admin: Delete an entry
    @DeleteMapping("/{id}")
    public boolean deleteEntry(@PathVariable Long id) {
        return service.deleteEntry(id);
    }

    // ✅ Admin: Approve an entry
    @PutMapping("/approve/{id}")
    public GuestBook approveEntry(@PathVariable Long id) {
        return service.approveEntry(id);
    }

    // ✅ Admin: Reply to an entry (via body)
    @PutMapping("/reply/{id}")
    public GuestBook replyToEntry(@PathVariable Long id, @RequestBody GuestBook request) {
        return service.replyToEntry(id, request.getReply());
    }

    // ✅ NEW: Update full entry (message, reply, status…)
    @PutMapping("/update/{id}")
    public GuestBook updateEntry(@PathVariable Long id, @RequestBody GuestBook updatedEntry) {
        return service.updateEntry(id, updatedEntry);
    }
}

