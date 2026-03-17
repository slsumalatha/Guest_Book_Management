package com.example.demo.service;


import java.util.List;

import com.example.demo.model.GuestBook;

public interface IGuestBookService {
    GuestBook addEntry(GuestBook entry);
    GuestBook updateEntry(Long id, GuestBook updatedEntry);
    List<GuestBook> getAllEntries();
    boolean deleteEntry(Long id);
    GuestBook approveEntry(Long id);
    GuestBook replyToEntry(Long id, String reply);
}
