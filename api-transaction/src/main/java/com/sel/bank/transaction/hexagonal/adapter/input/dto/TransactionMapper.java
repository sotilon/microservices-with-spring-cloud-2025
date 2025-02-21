package com.sel.bank.transaction.hexagonal.adapter.input.dto;

import com.sel.bank.transaction.hexagonal.adapter.output.collection.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper( TransactionMapper.class );

    Transaction transactionDtoToTransaction(TransactionDto dto);

    TransactionDto transactionToTransactionDto(Transaction dto);

}
