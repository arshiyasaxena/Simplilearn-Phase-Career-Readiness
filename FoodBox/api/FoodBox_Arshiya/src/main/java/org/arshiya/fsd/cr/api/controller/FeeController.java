package org.arshiya.fsd.cr.api.controller;

import java.util.List;

import org.arshiya.fsd.cr.api.dto.Fee;
import org.arshiya.fsd.cr.api.exception.FoodBoxServiceException;
import org.arshiya.fsd.cr.api.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
public class FeeController {

	@Autowired
	FeeService service;

	@GetMapping("/fee")
	@ResponseBody
	public List<Fee> getFees() throws FoodBoxServiceException {
		return service.getFees();
	}

	@GetMapping("/fee/{type}")
	@ResponseBody
	public Fee getFeeById(@PathVariable("type") String type) throws FoodBoxServiceException {
		return service.getFee(type);
	}

	@PostMapping("/fee")
	@ResponseBody
	public Fee createFee(@Validated @RequestBody Fee fee) throws FoodBoxServiceException {
		return service.createFee(fee);
	}

	@PutMapping("/fee")
	@ResponseBody
	public Fee updateFee(@Validated @RequestBody Fee fee) throws FoodBoxServiceException {
		return service.updateFee(fee);
	}

	@DeleteMapping("/fee/{id}")
	@ResponseBody
	public Fee deleteFee(@PathVariable("type") String type) throws FoodBoxServiceException {
		return service.deleteFee(type);
	}

}
