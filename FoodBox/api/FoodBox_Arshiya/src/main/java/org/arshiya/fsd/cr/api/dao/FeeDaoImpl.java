package org.arshiya.fsd.cr.api.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.arshiya.fsd.cr.api.dto.Fee;
import org.arshiya.fsd.cr.api.exception.FoodBoxDaoException;
import org.arshiya.fsd.cr.api.mapper.FeeMapper;
import org.arshiya.fsd.cr.api.repository.FeeRepository;
import org.springframework.stereotype.Repository;

@Repository
public class FeeDaoImpl implements FeeDao {

	@Resource
	private FeeRepository repository;

	@Resource
	private FeeMapper mapper;

	@Override
	public Fee getFee(String type) throws FoodBoxDaoException {
		Fee fee = null;

		try {
			fee = repository.findById(type)
					.map(entity -> mapper.toDto(entity))
					.orElse(null);
		} catch (Exception e) {
			throw new FoodBoxDaoException(e.getMessage());
		}

		return fee;
	}

	@Override
	public List<Fee> getFees() throws FoodBoxDaoException {
		List<Fee> fees = null;

		try {
			fees = repository.findAll().stream()
					.map(entity -> mapper.toDto(entity))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new FoodBoxDaoException(e.getMessage());
		}

		return fees;
	}

	@Override
	public Fee save(Fee fee) throws FoodBoxDaoException {
		Fee savedFee = null;

		try {
			savedFee = mapper.toDto(repository.save(mapper.toEntity(fee)));
		} catch (Exception e) {
			throw new FoodBoxDaoException(e.getMessage());
		}

		return savedFee;
	}

	@Override
	public void remove(String type) throws FoodBoxDaoException {
		try {
			repository.deleteById(type);
		} catch (Exception e) {
			throw new FoodBoxDaoException(e.getMessage());
		}
	}

}
