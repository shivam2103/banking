package com.shivam.banking.dto.transaction;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class TransactionResponse {
    private String data;
}
