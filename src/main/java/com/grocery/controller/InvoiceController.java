package com.grocery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.model.Invoice;
import com.grocery.repository.InvoiceRepository;

@RestController
@RequestMapping("/api/v1")
public class InvoiceController {

	@Autowired
	private InvoiceRepository invoiceRepository;

	@GetMapping(value = "/invoice")
	public List<Invoice> getAllInvoice() {
		return invoiceRepository.findAll();
	}


	@GetMapping(value="/invoice/{invoiceId}")
	public Optional<Invoice> getInvoiceById(@PathVariable ("invoiceId") Integer id)
	{
		return invoiceRepository.findById(id);
	} 

	@PostMapping(value="/invoice")
	public Invoice addInvoice(@RequestBody Invoice invoice) {

		return invoiceRepository.save(invoice);
	}

	@PutMapping(value="/invoice")
	public Invoice updateInvoice(@RequestBody Invoice invoiceRequest)
	{
		Invoice invoice=invoiceRepository.findById(invoiceRequest.getInvoiceId()).get();
		invoice.setOrderId(invoiceRequest.getOrderId());
		invoice.setProductId(invoiceRequest.getProductId());
		invoice.setQuantity(invoiceRequest.getQuantity());
		invoice.setProductTotalAmount(invoiceRequest.getProductTotalAmount());
		return invoiceRepository.save(invoice);
	}

	@DeleteMapping(value="/invoice/{invoiceId}")
	public void deleteInvoiceById(@PathVariable("invoiceId") Integer id) {
		invoiceRepository.deleteById(id);
	}

}
