package com.dk.geek.lifecycle.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author dkay
 * @version 1.0
 */
@Data
@ToString(callSuper = true)
public class SuperUser extends User {
    private String job;
}
