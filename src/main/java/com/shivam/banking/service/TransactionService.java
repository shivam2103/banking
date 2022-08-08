package com.shivam.banking.service;

import com.shivam.banking.dto.transaction.TransactionRequest;
import com.shivam.banking.dto.transaction.TransactionResponse;

/**
 * TransactionService Interface
 */
public interface TransactionService {

    /**
     * Process transaction of the user.
     *
     * @param customerId
     * @param transactionRequest
     * @return
     */
    TransactionResponse processTransaction(String customerId, TransactionRequest transactionRequest);
}
