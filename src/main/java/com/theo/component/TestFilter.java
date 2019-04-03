package com.theo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter
public class TestFilter implements Filter {

    @Autowired
    private DataSourceTransactionManager transactionManager;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus transactionStatus = transactionManager.getTransaction(defaultTransactionDefinition);
        try {
            filterChain.doFilter(servletRequest,servletResponse);
        }catch (Exception e){
            transactionManager.rollback(transactionStatus);
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("过滤器！");
    }
}
