package com.shivam.banking.service.impl;

import com.shivam.banking.dto.transaction.TransactionRequest;
import com.shivam.banking.dto.transaction.TransactionResponse;
import com.shivam.banking.dtp.AccountResponse;
import com.shivam.banking.helper.TransactionHelper;
import com.shivam.banking.repository.TransactionRepository;
import com.shivam.banking.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    private Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionHelper transactionHelper;

    /**
     * Perform transactions.
     *
     * @param customerId
     * @param transactionRequest
     * @return
     */
    @Override
    public TransactionResponse processTransaction(String customerId,
                                                  TransactionRequest transactionRequest) {
        log.info("Entered into processTransaction() for customer []", customerId);
        /*AccountResponse transferAccountResponse =
                client.fetchAccountDetailsByAccountId(transactionRequest.getOrginAccountId());
        AccountResponse creditAccountResponse =
                client.fetchAccountDetailsByAccountNumber(transactionRequest.getDestinationAccountId());
        // Business Validations
        transactionHelper.validateIfPayeeHasValidAmount(transferAccountResponse,transactionRequest);
        String id = UUID.randomUUID().toString();
        transactionRepository.save(transactionHelper.prepareTransactionDetails(
                transactionRequest, id, "debit",
                transferAccountResponse));
        transactionRepository.save(transactionHelper.prepareTransactionDetails(
                transactionRequest, id, "credit",
                creditAccountResponse));*/
        // Update the account Db
        log.info("Completed processTransaction() for customer []", customerId);
        return TransactionResponse.builder().data("Success").build();
    }

}
