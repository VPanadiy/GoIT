package goit.jdbc.controllers;

import goit.jdbc.model.Employee;
import goit.jdbc.model.EmployeeDao;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

/**
 * Created by Splayd on 07.05.2017.
 */
public class EmployeeController {

    private PlatformTransactionManager txManager;
    private EmployeeDao employeeDao;

    public List<Employee> getAllEmployee() {
        //PROPAGATION_REQUIRED -> if transaction are open run this transaction(supposed that transaction is not creating);
        //PROPAGATION_REQUIRES_NEW -> when call txManager.getTransaction create new transaction (don`t matter if transaction exist or not) (previous will be suspended (not committed));
        //PROPAGATION_MANDATORY -> at the moment when call txManager.getTransaction, must be already created transaction (if transaction not exist will throw Exception);
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED));
        try {
            List<Employee> result = employeeDao.getAll();
            txManager.commit(status);
            return result;
        } catch (Exception e) {
            txManager.rollback(status);
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public Employee getEmployeeById(int id) {
        return employeeDao.load(id);
    }

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
