package com.sel.bank.transaction.hexagonal.adapter.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sel.bank.transaction.hexagonal.adapter.input.dto.TransactionDto;
import com.sel.bank.transaction.hexagonal.adapter.input.dto.TransactionMapper;
import com.sel.bank.transaction.hexagonal.adapter.output.collection.Transaction;
import com.sel.bank.transaction.hexagonal.port.input.ITransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	private ITransactionService service;

	@Autowired
	private Environment env;
	
	@GetMapping("/list")
	public List<TransactionDto> findAll(){
		List<TransactionDto> dtoList = new ArrayList();
		service.findAll().stream().forEach(tx ->{
			TransactionDto dto = TransactionMapper.INSTANCE.transactionToTransactionDto(tx);
			log.info("TransactionDto:: {}",dto.toString());
			dto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			dtoList.add(dto);
		});
		return dtoList;
	}
	
	@GetMapping("{id}")
	public Optional<TransactionDto> findById(@PathVariable String id){
		Optional<Transaction> transactionDto = service.findById(id);
		if(transactionDto.isPresent()){
			TransactionDto dto = TransactionMapper.INSTANCE.transactionToTransactionDto(transactionDto.get());
			return Optional.of(dto);
		}
		return Optional.empty();
	}

	
	@PostMapping("/save")
	public TransactionDto save(@RequestBody TransactionDto transactionDto){
		Transaction transaction = service.save(TransactionMapper.INSTANCE.transactionDtoToTransaction(transactionDto));
		return TransactionMapper.INSTANCE.transactionToTransactionDto(transaction);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody TransactionDto transactionDto) {
		Transaction transaction = service.save(TransactionMapper.INSTANCE.transactionDtoToTransaction(transactionDto));
		service.delete(transaction);
	}
}
