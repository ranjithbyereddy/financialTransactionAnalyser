/**
 * 
 */
package meCode;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.ParseException;

import org.junit.Test;

import com.me.transactionDemo.main.AnalyzeFinRecord;

/**
 * @author rbyeredd
 *
 */
public class AnalyzeFinRecordTest {
	
	@Test
	public void testTransManagerWithDefaultSample() throws ParseException {
		String account="ACC334455";
		String fromDate = "20/10/2018 12:00:00";
		String toDate = "20/10/2018 09:30:31";
		assertEquals(new BigDecimal("-25.00"), AnalyzeFinRecord.processFinTransaction(new String[]{account,fromDate,toDate}));
	}
	
	@Test
	public void testTransManagerWithDefaultSample2() throws ParseException {
		String account="ACC334455";
		String fromDate = "20/10/2018 12:00:00";
		String toDate = "21/10/2018 09:30:31";
		assertEquals(new BigDecimal("-42.75"), AnalyzeFinRecord.processFinTransaction(new String[]{account, fromDate, toDate}));
	}

}
