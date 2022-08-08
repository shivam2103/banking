package com.shivam.banking.dtp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class AccountResponse {

    private Long accountId;

    private String customerId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal balance;

    private String accountNumber;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private Long accountProductDetails;
}
