package com.me.transactionDemo.dto;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/*@Data
@AllArgsConstructor
@ToString*/
public class TransactionDTO {
    private String transactionId;
    private String fromAccountId;
    private String toAccountId;
    private Date createAt;
    private BigDecimal amount;
    private String transactionType;
    private String relatedTransaction;
    private String dataLoadError;

    private TransactionDTO(String dataLoadError) {
        this.dataLoadError = dataLoadError;
    }

  
	public static TransactionDTO create(String[] data) {
        try {
            Date createAt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(data[3].trim());
            BigDecimal amount = new BigDecimal(data[4].trim());
            String relatedTransaction = (data.length == 7 && !data[6].trim().isEmpty()) ? data[6].trim() : null;
            return new TransactionDTO(data[0].trim(), data[1].trim(), data[2].trim(), createAt, amount, data[5].trim(), relatedTransaction, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new TransactionDTO("EXCEPTION IN LOADING THE TRANSACTION");
    }


	public String getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}


	public String getFromAccountId() {
		return fromAccountId;
	}


	public void setFromAccountId(String fromAccountId) {
		this.fromAccountId = fromAccountId;
	}


	public String getToAccountId() {
		return toAccountId;
	}


	public void setToAccountId(String toAccountId) {
		this.toAccountId = toAccountId;
	}


	public Date getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	public String getRelatedTransaction() {
		return relatedTransaction;
	}


	public void setRelatedTransaction(String relatedTransaction) {
		this.relatedTransaction = relatedTransaction;
	}


	public String getDataLoadError() {
		return dataLoadError;
	}


	public void setDataLoadError(String dataLoadError) {
		this.dataLoadError = dataLoadError;
	}


	public TransactionDTO(String transactionId, String fromAccountId, String toAccountId, Date createAt,
			BigDecimal amount, String transactionType, String relatedTransaction, String dataLoadError) {
		super();
		this.transactionId = transactionId;
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.createAt = createAt;
		this.amount = amount;
		this.transactionType = transactionType;
		this.relatedTransaction = relatedTransaction;
		this.dataLoadError = dataLoadError;
	}
}
