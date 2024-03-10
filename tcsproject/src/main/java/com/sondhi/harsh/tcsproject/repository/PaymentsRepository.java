package com.sondhi.harsh.tcsproject.repository;


import com.sondhi.harsh.tcsproject.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Long> {
    List<Payments> findByCardMemberId(Long cardMemberId);
}
