package com.grocery.controller;

import java.util.List;

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
import com.grocery.model.OrderResponseModel;
import com.grocery.repository.CustomerAddressRepository;
import com.grocery.repository.OrderRepository;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerAddressRepository customerAddressRepository;
	//
	//	@GetMapping(value = "/orders")
	//	public List<OrderResponseModel> getAllOrder() {
	//		List<Order> order=orderRepository.findAll();
	//		OrderResponseModel orderResponse =new OrderResponseModel();
	//		orderResponse.setOrder(order);
	//		System.out.println(order);
	//
	//		return null;
	//	}


	//	@GetMapping(value="/orders")
	//	public List<OrderResponseModel> getAllOrderById()
	//	{
	//		List<Order> order = orderRepository.findAll();
	//		List<OrderResponseModel> orderResponse = new ArrayList<>();
	//		orderResponse.setOrder(order);
	//		System.out.println(orderResponse.add(order));
	//		return orderResponse;
	//
	//	}
	@GetMapping(value="/orders/{orderId}")
	public OrderResponseModel getAllOrderById(@PathVariable ("orderId") Integer id)
	{
		Order order = orderRepository.findById(id).get();
		OrderResponseModel orderResponse = new OrderResponseModel();
		orderResponse.setOrder(order);
		orderResponse.setCustomerAddress(customerAddressRepository.findByCustomerId(order.getCustomerId()));
		return orderResponse;
	}

	@GetMapping(value="/orders/customer/{customerId}")
	public List<Order> getAllOrderByCustomerId(@PathVariable ("customerId") Integer id)
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
