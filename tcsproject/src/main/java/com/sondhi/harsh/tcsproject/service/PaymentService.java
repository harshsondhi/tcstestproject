package com.sondhi.harsh.tcsproject.service;

import com.sondhi.harsh.tcsproject.entity.Payments;

import java.util.List;

public interface PaymentService {
    public void acceptPayment(Payments payments);
    public void stopPayment(Long paymentId, double threshold);
    public List<Payments> getPaymentsByCardMember(Long cardMemberId);
}
