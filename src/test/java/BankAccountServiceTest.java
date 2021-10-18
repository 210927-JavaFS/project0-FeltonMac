
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.daos.BankAccountDao;
import com.revature.daos.BankAccountDaosImp;
import com.revature.models.BankAccount;
import com.revature.models.User;
import com.revature.services.BankAccountService;

public class BankAccountServiceTest {
	    public static BankAccountDao testdao= new BankAccountDaosImp();
	    public static BankAccountService BAS;
	    public static BankAccount dummyaccount;
	    public static User dummyuser;
	    public static boolean result;
	    public static String level;
	    public static String level2;
	    public static String pass;
	    public static String name;
	    public static String acnum;
	    public static Double bal;
	    public static Double mathresult;
	    public static Logger log = LoggerFactory.getLogger(BankAccountServiceTest.class);
	    
	    @BeforeAll
	    public static void setaccount() {
	        log.info("set");
	        dummyuser = new User();
	        dummyaccount = new BankAccount();
	    }
	    
	    @BeforeEach
	    public void setStrings() {
	    	level="two";
	    	acnum="2222";
	    	bal= 200.00;
	        log.info("In setInts");
	    }
	    
	    @Test
	   public void testaddaccount() {
	        log.info("test withdraw");
	        result = BAS.addAccount("5454");
	    	assertTrue( result== true);
	    }
	    @Test
	    public void testwithdraw() {
	        log.info("test withdraw");
	        result = BAS.withdrawpullin(acnum, bal);
	    	assertTrue( result== true);
	    }
	    @Test	
	    public void testwithdrawtoolarge() {
	        log.info("test withdraw");
	        result = BAS.withdrawpullin(acnum, 9000.00);
	    	assertTrue( result== false);
	    }
	    @Test
	    public void testdeposit() {
	        log.info("test deposit");
	    	assertTrue( BAS.withdrawpullin(acnum, bal) == true);
	    }
	    
	    
	    
	    
//	    @Test
//	    public void testSubtract() {
//	        log.info("In testSubtract.");
//	        result = mathUtil.subtract(i, j);
//	        assertTrue(result==2);
//	    }
//	    
//	    @Test
//	    public void testDivideByZero() {
//	        log.info("In testDivideByZero");
//	        assertThrows(ArithmeticException.class, () -> mathUtil.divide(i,k));
//	    }
//	    
//	    //While so far we have been testing directly inputs and outputs it can often be more useful to test properties.
//	    //For example, addition has the commutative property. 
//	    @Test
//	    public void testCommutativeAdd() {
//	        log.info("in testCommutativeAdd");
//	        assertEquals(mathUtil.add(i, j), mathUtil.add(j, i));
//	    }
	    
	    
	    @AfterEach
	    public void cleardouble() {
	        log.info(" clearResult");
	    }
	    
	    @AfterAll 
	    public static void clearMathUtil() {
	        dummyuser = null;
	        log.info("= clear user");
	    }
	    
	    

	}
