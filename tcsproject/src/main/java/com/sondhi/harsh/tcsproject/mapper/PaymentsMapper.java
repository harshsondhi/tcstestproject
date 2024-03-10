package com.sondhi.harsh.tcsproject.mapper;

import com.sondhi.harsh.tcsproject.dto.PaymentsDto;
import com.sondhi.harsh.tcsproject.entity.Payments;

public class PaymentsMapper {

    public static PaymentsDto mapToPaymentsDto(Payments payments){
//        paymentsDto.setCardNumber(payments.getCardMe());
        PaymentsDto paymentsDto = new PaymentsDto();
        paymentsDto.setCardMemberId(payments.getCardMemberId());
        paymentsDto.setAmount(payments.getAmount());
        paymentsDto.setCardType(payments.getCardType());
        paymentsDto.setTotalLimit(payments.getTotalLimit());
        paymentsDto.setAvailableAmount(payments.getAvailableAmount());
        paymentsDto.setAmountUsed(payments.getAmountUsed());
        return paymentsDto;
    }

    public static Payments mapToPaymentsEntity(PaymentsDto paymentsDto){
//        payments.setCardNumber(paymentsDto.getCardNumber());
        Payments payments = new Payments();
        payments.setCardMemberId(paymentsDto.getCardMemberId());
        payments.setAmount(paymentsDto.getAmount());
        payments.setCardType(paymentsDto.getCardType());
        payments.setTotalLimit(paymentsDto.getTotalLimit());
        payments.setAvailableAmount(paymentsDto.getAvailableAmount());
        payments.setAmountUsed(paymentsDto.getAmountUsed());
        return payments;
    }

}
