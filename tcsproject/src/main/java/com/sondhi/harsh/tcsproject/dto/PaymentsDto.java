package com.sondhi.harsh.tcsproject.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class PaymentsDto {

    @Positive(message = "Card Member Id greater than zero")
    private Long cardMemberId;

    @PositiveOrZero(message = "Total amount used should be equal or greater than zero")
    private double amount;

    @NotEmpty(message = "Card Type can not be a null or empty")
    private String cardType;

    @Positive(message = "totalLimit greater than zero")
    private int totalLimit;

    @Positive(message = "amountUsed greater than zero")
    private int amountUsed;

    @Positive(message = "Card availableAmount greater than zero")
    private int availableAmount;
}
