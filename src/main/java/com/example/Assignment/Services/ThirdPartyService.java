package com.example.Assignment.Services;

import com.example.Assignment.Models.Insurer;
import com.example.Assignment.Models.ThirdPartyQuote;
import com.example.Assignment.Models.VechicleDetails;
import com.example.Assignment.dao.ThirdPartyQuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ThirdPartyService {

    @Autowired
    private ThirdPartyQuoteRepository thirdPartyQuoteRepository;

    public List<Insurer> getPremiums(VechicleDetails vechicleDetails){
        return thirdPartyQuoteRepository.findAllByMakeAndModelAndVertical(vechicleDetails.getMake(), vechicleDetails.getModel(), vechicleDetails.getVertical()).getSupportedInsurers();
    }
}
