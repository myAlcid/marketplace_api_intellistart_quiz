package com.test.marketplace_api_intellistart_quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchaseDto {

    @NotNull(message = "user id should not be null")
    private Long userId;

    @NotNull(message = "product id should not be null")
    private Long productId;
}
