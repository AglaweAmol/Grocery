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

import com.grocery.model.Order;
import com.grocery.repository.OrderRepository;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@GetMapping(value = "/orders")
	public List<Order> getAllOrder() {

		return orderRepository.findAll();
	}

	@GetMapping(value="/orders/{orderId}")
	public Optional<Order> getAllOrderById(@PathVariable ("orderId") Integer id)
	{
		return orderRepository.findById(id);
	}

	@GetMapping(value="/orders/customer/{customerId}")
	public Optional<Order> getAllOrderByCustomerId(@PathVariable ("customerId") Integer id)
	{
		return orderRepository.findAllOrdersByCustomerId(id);
	}


	@PostMapping(value="/orders")
	public Order addOrder(@RequestBody Order order)
	{
		return orderRepository.save(order);
	}

	@PutMapping(value="/orders")
	public Order updateOrder(@RequestBody Order orderRequest)
	{
		Order order=orderRepository.findById(orderRequest.getOrderId()).get();
		order.setCustomerId(orderRequest.getCustomerId());
		order.setOrderStatus(orderRequest.getOrderStatus());
		order.setOrderTotal(orderRequest.getOrderTotal());
		order.setOrderTotalQuantity(orderRequest.getOrderTotalQuantity());
		return orderRepository.save(order);
	}

	@DeleteMapping(value="/orders/{orderId}")
	public void deleteOrderById(@PathVariable ("orderId") Integer id) {
		orderRepository.deleteById(id);
	}

}
