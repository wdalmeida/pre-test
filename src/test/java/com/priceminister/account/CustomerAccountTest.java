package com.priceminister.account;


import static org.junit.Assert.*;

import org.junit.*;

import com.priceminister.account.implementation.*;

import java.util.logging.Logger;


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

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        logger.info("Setting Up CustomerAccount");
        customerAccount = new CustomerAccount();
    }
    
    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        logger.info("Start testAccountWithoutMoneyHasZeroBalance()");

        Double delta = 0.01;

        //When
        Double result = customerAccount.getBalance();

        //Verify
        assertNotNull(customerAccount);
        assertEquals(0.0,result,delta);
    }
    
    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() {
        logger.info("Start testAddPositiveAmount()");

        Double delta = 0.01;
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

    }
    
    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     */
    @Ignore
    public void testWithdrawAndReportBalanceIllegalBalance() {
        fail("not yet implemented");
    }
    
    // Also implement missing unit tests for the above functionalities.

}
