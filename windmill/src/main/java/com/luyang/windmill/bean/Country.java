package com.luyang.windmill.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Country implements Serializable {
    private Long id;
    private String countryName;
    private String countryCode;
}
