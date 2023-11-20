package com.spring.demo.tx.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@Slf4j
public class TxTestService {

    public void doSomeTx() {
        if (TransactionSynchronizationManager.isSynchronizationActive()) {
            TransactionSynchronizationManager.registerSynchronization(
                    new TransactionSynchronizationAdapter() {
                        @Override
                        public void afterCommit() {
                            log.warn("print 1");
                        }
                    });
            log.info("TxTestService register synchronization completed");
        } else {
            log.warn("print 2");
        }
    }
}
