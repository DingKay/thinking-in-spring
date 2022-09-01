package com.dk.geek.lifecycle.domain;

import lombok.Data;

/**
 * @author dkay
 * @version 1.0
 */
@Data
public class User {
    private String name;
    private Integer age;
    private String[] address;
}
