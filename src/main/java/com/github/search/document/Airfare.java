package com.github.search.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Airfare implements Serializable {

    private static final long serialVersionUID= 1L;

    @Id
    private String id;
    private String originLocation;
    private String destinationLocation;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date departureDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date returnDate;

    private int adults;
    private int children;
    private int babies;

}
