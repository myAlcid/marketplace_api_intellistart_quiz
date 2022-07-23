package com.test.marketplace_api_intellistart_quiz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotBlank(message = "user first name should not be blank or null")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "user last name should not be blank or null")
    private String lastName;

    @Column(name = "amount_of_money")
    @NotNull(message = "user amountOfMoney should not be null")
    @Positive(message = "user amount of money should be above or equal zero")
    private Double amountOfMoney;

}
