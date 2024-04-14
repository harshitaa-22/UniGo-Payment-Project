package com.bennett.unigo.wallet.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bennett.unigo.wallet.entity.Student;
import com.bennett.unigo.wallet.entity.Transaction;
import com.bennett.unigo.wallet.entity.Wallet;
import com.bennett.unigo.wallet.model.TransactionRequest;
import com.bennett.unigo.wallet.repository.StudentRepository;
import com.bennett.unigo.wallet.repository.TransactionRepository;
import com.bennett.unigo.wallet.repository.WalletRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private WalletRepository walletRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public Transaction createTransaction(Transaction transaction) {
    	Transaction txn = null;
        Optional<Wallet> sourceOpt = walletRepository.findById((long)transaction.getSource());
        Optional<Wallet> targetOpt = walletRepository.findById((long)transaction.getTarget());
        if (sourceOpt.isPresent() && targetOpt.isPresent()) {
        	Wallet source = sourceOpt.get();
        	Wallet target = targetOpt.get();
        	source.setBalance(source.getBalance() - transaction.getAmount());
        	target.setBalance(target.getBalance() + transaction.getAmount());
        	walletRepository.save(source);
        	walletRepository.save(target);
        	txn = transactionRepository.save(transaction);
        	}
        return txn;
    }
    
    public Transaction createTransaction(TransactionRequest request) {
    	Transaction transaction = new Transaction();
    	Student student= studentRepository.findByContactNo(request.getContactNo());
    	if(student != null) {
    		Wallet targetWallet = walletRepository.findByStudentId(Integer.valueOf(student.getId()+""));
    		if(targetWallet != null) {
    			transaction = new Transaction(null ,(double)request.getAmount(),request.getSourceWallet(), Integer.valueOf(targetWallet.getId()+""), 1, "success");
    	    	return createTransaction(transaction);
    		}
    	}
    	transaction.setStatus(2);
    	transaction.setStatusreason("Contact No not in the system");
    	return transaction;
    	
    }

    public Transaction updateTransaction(Long id, Transaction updatedTransaction) {
        Transaction existingTransaction = transactionRepository.findById(id).orElse(null);
        if (existingTransaction != null) {
        	if (updatedTransaction.getSource()!= null)
        		existingTransaction.setSource(updatedTransaction.getSource());
        	if (updatedTransaction.getTarget()!= null)
        		existingTransaction.setTarget(updatedTransaction.getTarget());
        	if (updatedTransaction.getAmount()!= null)
        		existingTransaction.setAmount(updatedTransaction.getAmount());
        	if (updatedTransaction.getStatus()!= null)
        		existingTransaction.setStatus(updatedTransaction.getStatus());
        	if (updatedTransaction.getStatusreason()!= null)
            	existingTransaction.setStatusreason(updatedTransaction.getStatusreason());
            return transactionRepository.save(existingTransaction);
        }
        return null;
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
