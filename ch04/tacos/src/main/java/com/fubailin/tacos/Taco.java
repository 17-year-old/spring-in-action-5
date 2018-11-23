package com.fubailin.tacos;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @NotNull(message = "不能为空")
    @Size(min = 5, message = "至少输入5个字符")
    private String name;

    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min = 1, message = "需要选择至少一种配料")
    private List<Ingredient> ingredients;

    private Date createdAt;
    private Date modifiedAt;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}