package com.example.Assignment.dao;

import com.example.Assignment.Models.Insurer;
import com.example.Assignment.Models.ThirdPartyQuote;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ThirdPartyQuoteRepository extends MongoRepository<ThirdPartyQuote,String> {
    ThirdPartyQuote findAllByMakeAndModelAndVertical(String Make, String Model, String Vertical);
 ThirdPartyQuote findAllByModel(String Model);

}
