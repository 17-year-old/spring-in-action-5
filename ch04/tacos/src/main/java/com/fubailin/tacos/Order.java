package com.fubailin.tacos;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "Taco_Order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "不允许为空")
    private String deliveryName;
    @NotBlank(message = "不允许为空")
    private String deliveryStreet;
    @NotBlank(message = "不允许为空")
    private String deliveryCity;
    @NotBlank(message = "不允许为空")
    private String deliveryState;
    @NotBlank(message = "不允许为空")
    private String deliveryZip;
    @NotBlank(message = "不是合法的信用卡号")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([/])([1-9][0-9])$",
            message = "必须按照格式'月/年'输入,月和年都是两位数字")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "不是合法的CVV")
    private String ccCVV;
    private Date placedAt;
    private Date modifiedAt;

    @ManyToOne
    private User user;

    @ManyToMany(targetEntity = Taco.class)
    private List<Taco> tacos = new ArrayList<>();

    public void addDesign(Taco taco) {
        tacos.add(taco);
    }

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }
}


