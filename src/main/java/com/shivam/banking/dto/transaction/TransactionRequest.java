package com.shivam.banking.dto.transaction;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransactionRequest {

    private String orginAccountId;

    private String destinationAccountId;

    private Double amount;

    private String comments;
}
