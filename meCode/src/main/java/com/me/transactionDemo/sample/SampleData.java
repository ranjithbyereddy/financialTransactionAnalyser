package com.me.transactionDemo.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.me.transactionDemo.dto.TransactionDTO;

public class SampleData {

    public static List<TransactionDTO> get() {
        return csvData().stream().map(TransactionDTO::create).filter(transactionDTO -> transactionDTO.getDataLoadError() == null).collect(Collectors.toList());
    }

    private static List<String[]> csvData() {
        List<String[]> dataLines = new ArrayList<>();
        dataLines.add(new String[]
                {"TX10001", "ACC334455", "ACC778899", "20/10/2018 12:47:55", "25.00", "PAYMENT",});
        dataLines.add(new String[]
                {"TX10002", "ACC334455", "ACC998877", "20/10/2018 17:33:43", "10.50", "PAYMENT",});
        dataLines.add(new String[]
                {"TX10003", "ACC998877", "ACC778899", "20/10/2018 18:00:00", "5.00", "PAYMENT",});
        dataLines.add(new String[]
                {"TX10004", "ACC334455", "ACC998877", "20/10/2018 19:45:00", "10.50", "REVERSAL", "TX10002"});
        dataLines.add(new String[]
                {"TX10005", "ACC334455", "ACC778899", "21/10/2018 09:30:00", "7.25", "PAYMENT",});        
		/*
		 * dataLines.add(new String[] {"TX10006", "ACC778899", "ACC334455",
		 * "21/10/2018 09:36:00", "7.25", "PAYMENT",});
		 */
        return dataLines;
    }

	public SampleData() {
		super();
	}
}