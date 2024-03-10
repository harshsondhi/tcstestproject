package com.sondhi.harsh.tcsproject.entity;



import jakarta.persistence.*;
import lombok.*;



@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Payments extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

//    private String cardNumber;
     private Long cardMemberId;

    private double amount;

    private String cardType;

    private int totalLimit;

    private int amountUsed;

    private int availableAmount;
}
