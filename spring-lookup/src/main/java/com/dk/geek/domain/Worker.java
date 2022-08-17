package com.dk.geek.domain;

import lombok.*;

/**
 * @author dkay
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Worker {
    private String name;
    private Integer age;
    private String position;
}
