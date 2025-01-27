package com.w2m.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import lombok.Data;

@EntityScan
@Data
public class NaveEspacial {

    @Id
    //@Generated(strategy = GeneratorType.IDENTITY)
    private Long id;
    private String name;
    private String series;

}