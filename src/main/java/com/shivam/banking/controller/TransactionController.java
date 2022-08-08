package com.shivam.banking.controller;

import com.shivam.banking.dto.transaction.TransactionRequest;
import com.shivam.banking.dto.transaction.TransactionResponse;
import com.shivam.banking.exception.BaseException;
import com.shivam.banking.service.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Transaction Controller
 */
@RestController
@RequestMapping(name = "/banking/transactions", produces = "application/json")
@Api(
        tags = "Transaction", value = "Transaction Controller", produces = "application/json")
public class TransactionController {

    private Logger log = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/{customerId}")
    @ApiOperation(
            value = "/{customerId}",
            notes = "Method to perform transaction",
            response = TransactionResponse.class, httpMethod = "POST"
    )
    public TransactionResponse processTransaction(
            @ApiParam(
                    name = "transactionRequest", required = true, allowEmptyValue = false,
                    example = "TransactionRequest"
            )
            @RequestBody TransactionRequest transactionRequest,
            @ApiParam(
                    name = "customerId", required = true, allowEmptyValue = false,
                    example = "1234"
            ) @PathVariable String customerId) {
        log.info("Entered into processTransaction() for customer {}",customerId);
        if(StringUtils.isEmpty(transactionRequest.getAmount())) {
            throw new BaseException("Empty String", "101", HttpStatus.BAD_REQUEST);
        }
        return transactionService.processTransaction(customerId, transactionRequest);
    }
}
