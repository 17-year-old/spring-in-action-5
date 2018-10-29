package com.fubailin.tacocloud;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Taco {

    // end::allButValidation[]
    @NotNull(message = "不能为空")
    @Size(min=5, message="至少输入5个字符")
    // tag::allButValidation[]
    private String name;
    // end::allButValidation[]
    @Size(min=1, message="需要选择至少一种配料")
    // tag::allButValidation[]
    private List<String> ingredients;

}