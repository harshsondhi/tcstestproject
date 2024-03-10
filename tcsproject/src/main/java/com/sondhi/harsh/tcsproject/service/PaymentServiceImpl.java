package com.sondhi.harsh.tcsproject.service;

import com.sondhi.harsh.tcsproject.entity.Payments;
import com.sondhi.harsh.tcsproject.exception.ResourceNotFoundException;
import com.sondhi.harsh.tcsproject.repository.PaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl  implements PaymentService{

    @Autowired
    private PaymentsRepository paymentRepository;
    @Override
    public void acceptPayment(Payments payments) {
        paymentRepository.save(payments);
    }

    @Override
    public void stopPayment(Long paymentId, double threshold) {
        Payments payments = paymentRepository.findById(paymentId).orElseThrow(() -> new ResourceNotFoundException("Payment", "paymentId", paymentId.toString()));
        if (payments != null && payments.getAmount() >= threshold) {
            paymentRepository.delete(payments);
        }

    }

    @Override
    public List<Payments> getPaymentsByCardMember(Long cardMemberId) {

        return paymentRepository.findByCardMemberId(cardMemberId);
    }
}
