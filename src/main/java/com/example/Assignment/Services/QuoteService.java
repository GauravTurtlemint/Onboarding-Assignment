package com.example.Assignment.Services;

import com.example.Assignment.Models.Quotes;
import com.example.Assignment.dao.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    public Quotes getQuoteById(String requestId){
        return quoteRepository.findByRequestId(requestId);
    }

    public List<Quotes> getAllQuotes(){
        return quoteRepository.findAll();
    }

    public void addQuote(Quotes quote){
        quoteRepository.save(quote);
    }

    public void deleteTopic(String requestId){
        quoteRepository.deleteByRequestId(requestId);
    }
}
