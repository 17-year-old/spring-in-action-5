package com.fubailin.tacos;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
public class Taco {
    protected long id;

    @NotNull(message = "不能为空")
    @Size(min = 5, message = "至少输入5个字符")
    private String name;

    @Size(min = 1, message = "需要选择至少一种配料")
    private List<Ingredient> ingredients;

    private Date createdAt;
    private Date modifiedAt;

    void createdAt() {
        this.createdAt = new Date();
    }
}