package com.prompo.knit.model;


import lombok.Getter;
import lombok.Setter;
/**
 * Validation
 */
import javax.validation.constraints.NotBlank;
@Setter
@Getter
public class SearchCriteria {
    @NotBlank(message = "username can't empty!")
    String productName;
}