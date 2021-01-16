package com.github.search.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Airfare {

    @Id
    private String id;
    private String origin;

    // private Date departureDate;
    //private Date returnDate;

    private int adults;
    private int children;
    private int babies;

}
