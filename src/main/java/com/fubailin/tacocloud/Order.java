package com.fubailin.tacocloud;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Data
public class Order {
    @NotBlank(message = "不允许为空")
    private String name;
    @NotBlank(message = "不允许为空")
    private String street;
    @NotBlank(message = "不允许为空")
    private String city;
    @NotBlank(message = "不允许为空")
    private String state;
    @NotBlank(message = "不允许为空")
    private String zip;
    @CreditCardNumber(message = "不是合法的信用卡号")
    private String ccNumber;
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="必须按照格式'月/年'输入,月和年都是两位数字")
    private String ccExpiration;
    @Digits(integer=3, fraction=0, message="不是合法的CVV")
    private String ccCVV;
}


