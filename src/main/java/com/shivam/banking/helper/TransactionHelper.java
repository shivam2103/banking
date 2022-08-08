package com.shivam.banking.helper;

import com.shivam.banking.dto.transaction.TransactionRequest;
import com.shivam.banking.dtp.AccountResponse;
import com.shivam.banking.entity.TransactionEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TransactionHelper {

    private Logger log = LoggerFactory.getLogger(TransactionHelper.class);

    /**
     * Populate Transaction Details Entity.
     * @param transactionRequest
     * @param id
     * @param transactionType
     * @param transferAccountResponse
     * @return
     */
    public TransactionEntity prepareTransactionDetails(TransactionRequest transactionRequest,
                                                       String id,
                                                       String transactionType,
                                                       AccountResponse transferAccountResponse) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setTransactionId(id);
        transactionEntity.setAccountId(transferAccountResponse.getAccountId().intValue());
        transactionEntity.setAccountNumber(transferAccountResponse.getAccountNumber());
        transactionEntity.setTransactionDate(LocalDateTime.now());
        transactionEntity.setTransactionType(transactionType);
        transactionEntity.setAmount(transactionRequest.getAmount());
        transactionEntity.setComments(transactionRequest.getComments());
        return transactionEntity;
    }

    /**
     * Throw error when the balance is in
     * @param transferAccountResponse
     */
    public void validateIfPayeeHasValidAmount(AccountResponse transferAccountResponse,
                                              TransactionRequest transactionRequest) {
        if(Double.compare(transferAccountResponse.getBalance().doubleValue(),
                transactionRequest.getAmount()) > 0 == false) {
            log.error("Insufficient Balance in Account");
            //throw new InSufficentBalanceException();
        }
    }
}
