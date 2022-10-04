package com.example.Assignment.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@Document(collection = "quotes")
@AllArgsConstructor
@NoArgsConstructor
public class Quotes {
    @Id
    private String requestId;
    private VechicleDetails premiumRequested;
    private List<Insurer> premiumResult;
}
