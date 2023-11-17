package com.spring.demo.tx.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class TxTestService {

    public void doSomeTx() {
        if (TransactionSynchronizationManager.isSynchronizationActive()) {
            TransactionSynchronizationManager.registerSynchronization(
                    new TransactionSynchronizationAdapter() {
                        @Override
                        public void afterCommit() {
                            System.err.println("print 1");
                        }
                    });
        } else {
            System.err.println("print 2");
        }
    }
}
