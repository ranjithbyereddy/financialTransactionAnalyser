package com.me.transactionDemo.main;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.me.transactionDemo.dto.TransactionDTO;
import com.me.transactionDemo.sample.SampleData;

@SpringBootApplication
public class AnalyzeFinRecord {
    public static void main(String[] args) {
    	
    	if (args.length != 3) {
			System.err.println("Invalid number of arguments. (1) accountId (2) start date and (3) end date. Aborting...");
			return;
		}
    	BigDecimal balance = BigDecimal.ZERO;
    	balance = processFinTransaction(args);
        System.out.println("Relative balance for the period is: " + balance);
    }

	public static BigDecimal processFinTransaction(String[] args) {
		BigDecimal balance = BigDecimal.ZERO;
		try {            
            String accNumber =  args[0];
            List<TransactionDTO> sampleData = SampleData.get();
            List<TransactionDTO> selectedTrans = new ArrayList<>();
            while (true) {
                String finalAccNumber = accNumber;
                sampleData.stream().filter(transactionDTO -> (transactionDTO.getToAccountId().equalsIgnoreCase(finalAccNumber)
                        || transactionDTO.getFromAccountId().equalsIgnoreCase(finalAccNumber))).forEach(selectedTrans::add);
                if (selectedTrans.isEmpty()) {
                    System.out.println("Transactions not found for given account id. Kindly retry");
                    System.out.println("Account Number: ");
                } else {
                    break;
                }
            }
            gatherTimeLimitsData(selectedTrans, args );
            String finalAccNumber1 = accNumber;

            List<String> collect = sampleData.stream().map(TransactionDTO::getRelatedTransaction).filter(Objects::nonNull).collect(Collectors.toList());
            int count = 0;
            for (TransactionDTO transactionDTO : selectedTrans) {
                if (!collect.contains(transactionDTO.getTransactionId())) {
                    if (transactionDTO.getFromAccountId().equalsIgnoreCase(finalAccNumber1)) {
                        balance = balance.subtract(transactionDTO.getAmount());
                        count++;
                    } else if (transactionDTO.getToAccountId().equalsIgnoreCase(finalAccNumber1)) {
                        balance = balance.add(transactionDTO.getAmount());
                        count++;
                    }
                }
            }
           
            System.out.println("Number of transactions included is:" + count);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return balance;
	}

    private static void gatherTimeLimitsData(List<TransactionDTO> selectedTrans, String[] args) throws ParseException {
       
        Date fromDate = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(args[1]);
        selectedTrans.removeIf(transactionDTO -> transactionDTO.getCreateAt().before(fromDate));
        
        Date toDate = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(args[2]);
        selectedTrans.removeIf(transactionDTO -> transactionDTO.getCreateAt().after(toDate));
    }
}
