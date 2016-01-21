/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import java.util.List;
import org.aopalliance.intercept.MethodInvocation;
import org.jboss.logging.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 *
 * @author 
 */
public class AutocommitInterceptor {
    
  private static final Logger LOGGER = Logger.getLogger(AutocommitInterceptor.class);

  private List<String> autoCommitableMethods;
  private TransactionTemplate transactionTemplate;

  public AutocommitInterceptor() {
    super();
  }

  public void setAutoCommitableMethods(List<String> autoCommitableMethods) {
    this.autoCommitableMethods = autoCommitableMethods;
  }

  public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
    this.transactionTemplate = transactionTemplate;
  }

  public Object invoke(final MethodInvocation invocation) throws Throwable {
    if (isAutoCommitableMethod(invocation.getMethod().getName())) {
      return transactionTemplate.execute(new TransactionCallback() {
        public Object doInTransaction(TransactionStatus transactionStatus) {
          LOGGER.debug("OBTIENE TRAN");
          try {
            Object retVal = invocation.proceed();
            LOGGER.debug("COMMIT TRAN");
            return retVal;
          } catch (Throwable t) {
            LOGGER.error("A runtime exception has occured:", t);
            LOGGER.debug("ROLLBACK TRAN");
            throw new RuntimeException(t);
          }
        }
      });
    } else {
      return invocation.proceed();
    }
  }

  private boolean isAutoCommitableMethod(String methodName) {
    boolean isAutoCommitable = false;
    for (String autoCommitableMethod : autoCommitableMethods) {
      if (autoCommitableMethod.equals(methodName)) {
        isAutoCommitable = true;
        break;
      }
    }
    return isAutoCommitable;
  }
    
}
