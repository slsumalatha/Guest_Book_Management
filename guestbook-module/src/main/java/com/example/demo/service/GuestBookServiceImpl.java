package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.GuestBook;
import com.example.demo.repository.IGuestBookRepository;

import java.util.List;

@Service
public class GuestBookServiceImpl implements IGuestBookService {

    private final IGuestBookRepository repo;

    // constructor injection
    public GuestBookServiceImpl(IGuestBookRepository repo) {
        this.repo = repo;
    }

    @Override
    public GuestBook addEntry(GuestBook entry) {
        return repo.save(entry); // save to database
    }

    @Override
    public List<GuestBook> getAllEntries() {
        return repo.findAll(); // fetch all records
    }

    @Override
    public boolean deleteEntry(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public GuestBook approveEntry(Long id) {
        return repo.findById(id).map(entry -> {
            entry.setStatus("APPROVED");
            return repo.save(entry);
        }).orElse(null);
    }

    @Override
    public GuestBook replyToEntry(Long id, String reply) {
        return repo.findById(id).map(entry -> {
            entry.setReply(reply);
            return repo.save(entry);
        }).orElse(null);
    }
    @Override
    public GuestBook updateEntry(Long id, GuestBook updatedEntry) {
        GuestBook existing = repo.findById(id).orElseThrow();
        existing.setCustomerName(updatedEntry.getCustomerName());
        existing.setMessage(updatedEntry.getMessage());
        existing.setReply(updatedEntry.getReply());
        existing.setStatus(updatedEntry.getStatus());
        return repo.save(existing);
    }

}