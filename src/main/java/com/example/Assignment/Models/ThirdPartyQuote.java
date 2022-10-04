package com.example.Assignment.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Data
@Document(collection = "ThirdPartyQuotes")
public class ThirdPartyQuote {
    @Id
    private String id;
    private String vertical;
    private String make;
    private String model;
    private List<Insurer> supportedInsurers ;
}
