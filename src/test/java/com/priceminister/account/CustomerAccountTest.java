package com.priceminister.account;


import com.priceminister.account.implementation.CustomerAccount;
import com.priceminister.account.implementation.CustomerAccountRule;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.mock;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 *
 * We want to see how you "think code", and how you organize and structure a simple application.
 *
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 *
 */
public class CustomerAccountTest {

    private final Logger logger = Logger.getLogger(CustomerAccountTest.class.getName());

    private Account customerAccount;
    private AccountRule rule;
    private Double delta;


    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        logger.info("Start set up");
        customerAccount = new CustomerAccount();
        rule = mock(CustomerAccountRule.class);
        delta = 0.01;
        logger.info("End set up");

    }

    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        logger.info("Start testAccountWithoutMoneyHasZeroBalance()");


        //When
        Double result = customerAccount.getBalance();

        //Verify
        assertNotNull(customerAccount);
        assertEquals(0.0,result,delta);
        logger.info("End testAccountWithoutMoneyHasZeroBalance()");

    }

    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() {
        logger.info("Start testAddPositiveAmount()");

        Double addedAmount = 20.9;
        Double addAgain = 2.1;


        //When
        customerAccount.add(addedAmount);
        logger.info("Add 20.9 to the balance");
        Double result = customerAccount.getBalance();

        //Verify
        assertEquals(addedAmount,result,delta);
        logger.info("Result should be "+ addedAmount);


        //When
        customerAccount.add(addAgain);
        logger.info("Add 2.1 to the balance");
        result = customerAccount.getBalance();

        //Verify
        assertEquals(addedAmount+addAgain,result,delta);
        logger.info("Result should be "+ (addedAmount+addAgain) );

        logger.info("End testAddPositiveAmount()");

    }

    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     */
    @Test
    public void testWithdrawAndReportBalanceIllegalBalance() {
        logger.info("Start testWithdrawAndReportBalanceIllegalBalance()");
        Double addedAmount = -54.7;

        //When
        when(rule.withdrawPermitted(addedAmount)).thenReturn(false);
        try {
            customerAccount.withdrawAndReportBalance(addedAmount, rule);
            fail("Test failed because of the method that hasn't thrown the exception");
        } catch (IllegalBalanceException e) {
            verify(rule,times(1)).withdrawPermitted(addedAmount);
            assertEquals(e.toString(), "Illegal account balance: " + addedAmount);
        }
        logger.info("End testWithdrawAndReportBalanceIllegalBalance()");
    }

    // Also implement missing unit tests for the above functionalities.

    /**
     * Tests that the withdraw amount is added to the balance.
     */
    @Test
    public void testWithdrawAndReportBalance() {
        logger.info("Start testWithdrawAndReportBalance()");
        Double addedAmount = 54.7;

        //When
        when(rule.withdrawPermitted(addedAmount)).thenReturn(true);

        try {
            Double result = customerAccount.withdrawAndReportBalance(addedAmount, rule);

            //Verify
            verify(rule,times(1)).withdrawPermitted(addedAmount);
            assertEquals(addedAmount,result,delta);
        } catch (IllegalBalanceException e) {
            fail("Test failed because the exception was raised");

        }
        logger.info("End testWithdrawAndReportBalance()");
    }

}
