package com.example.Assignment.Controllers;

import com.example.Assignment.Models.*;
import com.example.Assignment.Services.QuoteService;
import com.example.Assignment.Services.ThirdPartyService;
import com.example.Assignment.dao.QuoteRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/")
public class QuoteController {

    @Autowired
    public QuoteRepository quoteRepository;

    @Autowired
    public QuoteService quoteService;

    @Autowired
    public ThirdPartyService thirdPartyService;

    @GetMapping("/{requestId}")
    public Quotes getQuote(@PathVariable String requestId){
        return quoteService.getQuoteById(requestId);
    }

    @GetMapping("/")
    public List<Quotes> getAllQuote(){
        return quoteService.getAllQuotes();
    }

    @PostMapping("/")
    public Quotes addQuotes(@RequestBody VechicleDetails vechicleDetails){
        ObjectId requestId = new ObjectId();

        while(quoteRepository.findByRequestId(requestId.toString()) != null){
            requestId = new ObjectId();
        }

        Quotes quote = new Quotes();
        quote.setPremiumRequested(vechicleDetails);
        quote.setRequestId(requestId.toString());
        quote.setPremiumResult(thirdPartyService.getPremiums(vechicleDetails));
        quoteService.addQuote(quote);
        return quote;
    }

    @DeleteMapping("/{requestId}")
    public void deleteTopic(@PathVariable String requestId){
        quoteService.deleteTopic(requestId);
    }
}
