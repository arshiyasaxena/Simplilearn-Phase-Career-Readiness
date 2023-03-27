package org.arshiya.fsd.cr.api.service;

import java.util.List;

import javax.annotation.Resource;

import org.arshiya.fsd.cr.api.dao.FeeDao;
import org.arshiya.fsd.cr.api.dto.Fee;
import org.arshiya.fsd.cr.api.exception.FoodBoxServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeeServiceImpl implements FeeService {

	@Resource
	private FeeDao feeDao;

	@Override
	@Transactional
	public List<Fee> getFees() throws FoodBoxServiceException {
		List<Fee> fees = null;

		try {
			fees = feeDao.getFees();
		} catch (Exception e) {
			throw new FoodBoxServiceException(e.getMessage());
		}

		return fees;
	}

	@Override
	@Transactional
	public Fee getFee(String type) throws FoodBoxServiceException {
		Fee fee = null;

		try {
			fee = feeDao.getFee(type);
		} catch (Exception e) {
			throw new FoodBoxServiceException(e.getMessage());
		}

		return fee;
	}

	@Override
	@Transactional
	public Fee createFee(Fee fee) throws FoodBoxServiceException {
		Fee savedFee = null;

		try {
			savedFee = feeDao.save(fee);
		} catch (Exception e) {
			throw new FoodBoxServiceException(e.getMessage());
		}

		return savedFee;
	}

	@Override
	@Transactional
	public Fee updateFee(Fee fee) throws FoodBoxServiceException {
		Fee savedFee = null;

		try {
			if (fee.getType() == null) {
				throw new FoodBoxServiceException("Fee type cannot be null.");
			}

			if (feeDao.getFee(fee.getType()) == null) {
				throw new FoodBoxServiceException("Fee " + fee.getType() + "not found.");
			}

			savedFee = feeDao.save(fee);
		} catch (Exception e) {
			throw new FoodBoxServiceException(e.getMessage());
		}

		return savedFee;
	}

	@Override
	@Transactional
	public Fee deleteFee(String type) throws FoodBoxServiceException {
		Fee deletedFee = null;

		try {
			if (type == null) {
				throw new FoodBoxServiceException("Fee type cannot be null.");
			}

			deletedFee = feeDao.getFee(type);

			if (deletedFee == null) {
				throw new FoodBoxServiceException("Fee " + type + "not found.");
			}

			feeDao.remove(type);
		} catch (Exception e) {
			throw new FoodBoxServiceException(e.getMessage());
		}

		return deletedFee;
	}

}
