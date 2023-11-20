package com.spring.demo.tx.controller;

import com.spring.demo.tx.dao.ClassroomRepository;
import com.spring.demo.tx.domain.Classroom;
import com.spring.demo.tx.service.TxTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class TxTestController {

    @Resource
    private TxTestService testService;

    @Resource
    private ClassroomRepository classroomRepository;

    @Transactional
    @GetMapping("/testTx")
    public String testTx() {
        Classroom classroom = new Classroom();
        classroom.setClassroomName("test class");
        classroomRepository.save(classroom);
        if (TransactionSynchronizationManager.isSynchronizationActive()) {
            TransactionSynchronizationManager.registerSynchronization(
                    new TransactionSynchronizationAdapter() {

                        @Override
                        public void afterCommit() {
                            log.info("call testService.doSomeTx()");
                            testService.doSomeTx();
                        }
                    });
            log.info("TxTestController register synchronization completed");
        } else {
            log.error("No active synchronization found, please check your datasource connection.");
        }
        return "";
    }
}
