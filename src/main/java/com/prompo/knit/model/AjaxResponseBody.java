package com.prompo.knit.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Data
@Setter
@Getter
/**
 * Some Pojo (?)
 */
public class AjaxResponseBody {
    public String msg;
    public List<Product> result;
}
