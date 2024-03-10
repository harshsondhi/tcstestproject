package com.sondhi.harsh.tcsproject.controller;

import com.sondhi.harsh.tcsproject.dto.PaymentsDto;
import com.sondhi.harsh.tcsproject.entity.Payments;
import com.sondhi.harsh.tcsproject.mapper.PaymentsMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.sondhi.harsh.tcsproject.service.PaymentService;

@Tag(
        name = "CRUD REST APIs for Payment",
        description = "CRUD REST APIs for Payments to ACCEPT, STOP, FETCH PAYMENT details"
)
@RestController
@RequestMapping("/payments")
@AllArgsConstructor
@Validated
public class PaymentController {


    private PaymentService paymentService;

    @Operation(
            summary = "Fetch payments-ms health REST API",
            description = "REST API to fetch health of PAYMENTS-MS"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error"

            )
    })
    @GetMapping("/health")
    public ResponseEntity<String> getHealth(){
        return ResponseEntity.ok("PAYMENT-MS UP and RUNNING");
    }

    @Operation(
            summary = "Update Card Details REST API",
            description = "REST API to update card details based on a card number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),

            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error"
            )
    })
    @PostMapping("/accept")
    public ResponseEntity<String> acceptPayment(@Valid @RequestBody PaymentsDto paymentsdto) {
        Payments payments = PaymentsMapper.mapToPaymentsEntity(paymentsdto);
        paymentService.acceptPayment(PaymentsMapper.mapToPaymentsEntity(paymentsdto));
        return ResponseEntity.status(HttpStatus.CREATED).body("Payment accepted successfully");
    }

    @Operation(
            summary = "stop payments",
            description = "REST API to stop payment"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),

            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error"
            )
    })
    @PostMapping("/stop")
    public ResponseEntity<String> stopPayment(@Valid @RequestParam Long paymentId, @Valid @RequestParam double threshold) {
        paymentService.stopPayment(paymentId, threshold);
        return ResponseEntity.ok("Payment stopped successfully");
    }


    @Operation(
            summary = "card member info",
            description = "REST API to fetch card member payments info"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),

            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error"
            )
    })
    @GetMapping("/cardmember/{cardMemberId}")
    public ResponseEntity<?> getPaymentsByCardMember(@Valid @PathVariable Long cardMemberId) {
        return ResponseEntity.ok(paymentService.getPaymentsByCardMember(cardMemberId));
    }

}
