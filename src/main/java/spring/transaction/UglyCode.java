package spring.transaction;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by chensongkui on 2018/3/13.
 * https://www.ibm.com/developerworks/cn/education/opensource/os-cn-spring-trans/index.html
 */
public class UglyCode {

    /**
     * 基于API的编程事务
     * @param fromId
     * @param toId
     * @param amount
     * @return
     */
    public boolean transfer(Long fromId, Long toId, double amount) {
        TransactionStatus txStatus = txManager.getTransaction(txDefinition);
        boolean result = false;
        try {
            result = bankDao.transfer(fromId， toId， amount);
            txManager.commit(txStatus);
        } catch (Exception e) {
            result = false;
            txManager.rollback(txStatus);
            System.out.println("Transfer Error!");
        }
        return result;
    }

    /**
     * 模版回调事务
     * @param fromId
     * @param toId
     * @param amount
     * @return
     */
    public boolean transfer(final Long fromId, final Long toId, final double amount) {
        return (Boolean) transactionTemplate.execute(new TransactionCallback(){
            public Object doInTransaction(TransactionStatus status) {
                Object result;
                try {
                    result = bankDao.transfer(fromId, toId, amount);
                } catch (Exception e) {
                    status.setRollbackOnly();
                    result = false;
                    System.out.println("Transfer Error!");
                }
                return result;
            }
        });
    }


    /**
     * Spring 的声明式事务管理在底层是建立在 AOP 的基础之上的。
     * 其本质是对方法前后进行拦截，然后在目标方法开始之前创建或者加入一个事务，在执行完目标方法之后根据执行情况提交或者回滚事务。
     * 因为事务管理本身就是一个典型的横切逻辑，正是 AOP 的用武之地。
     */

    /**
     * 注解式声明事务
     * @param fromId
     * @param toId
     * @param amount
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean transfer(Long fromId, Long toId, double amount) {
        return bankDao.transfer(fromId, toId, amount);
    }


}
