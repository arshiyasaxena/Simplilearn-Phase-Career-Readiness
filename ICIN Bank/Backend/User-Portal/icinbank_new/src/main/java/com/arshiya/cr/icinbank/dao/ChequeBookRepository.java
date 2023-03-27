package com.arshiya.cr.icinbank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arshiya.cr.icinbank.model.ChequebookRequest;

public interface ChequeBookRepository extends JpaRepository<ChequebookRequest, Integer>{

	public List<ChequebookRequest> findByAccount(long account);
}
