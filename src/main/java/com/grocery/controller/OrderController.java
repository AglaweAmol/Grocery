package com.grocery.controller;

import java.util.ArrayList;
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

import com.grocery.model.Cart;
import com.grocery.model.CartProduct;
import com.grocery.model.Invoice;
import com.grocery.model.Order;
import com.grocery.model.OrderResponseModel;
import com.grocery.model.Product;
import com.grocery.repository.CartRepository;
import com.grocery.repository.CustomerAddressRepository;
import com.grocery.repository.CustomerRepository;
import com.grocery.repository.OrderRepository;
import com.grocery.repository.ProductRepository;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerAddressRepository customerAddressRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CustomerRepository customerRepository;


	//
	// @GetMapping(value = "/orders")
	// public List<OrderResponseModel> getAllOrder() {
	// List<Order> order=orderRepository.findAll();
	// OrderResponseModel orderResponse =new OrderResponseModel();
	// orderResponse.setOrder(order);
	// System.out.println(order);
	//
	// return null;
	// }

	@GetMapping(value = "/orders")
	public List<OrderResponseModel> getAllOrderById() {
		List<Order> orderList = orderRepository.findAll();
		List<OrderResponseModel> orderResponseList = new ArrayList<>();

		orderList.forEach(orderObject -> {
			OrderResponseModel orderResponseModel = new OrderResponseModel();
			orderResponseModel.setOrder(orderObject);
			orderResponseModel.setCustomerAddress(
					customerAddressRepository.findByCustAddressId(orderObject.getCustomerAddressID()));
			orderResponseList.add(orderResponseModel);
		});

		return orderResponseList;

	}

	@GetMapping(value = "/orders/{orderId}")
	public OrderResponseModel getAllOrderById(@PathVariable("orderId") Integer id) {
		Order order = orderRepository.findById(id).get();
		OrderResponseModel orderResponse = new OrderResponseModel();
		orderResponse.setOrder(order);
		orderResponse.setCustomerAddress(customerAddressRepository.findByCustAddressId(order.getCustomerAddressID()));
		return orderResponse;
	}

	@GetMapping(value = "/orders/customer/{customerId}")
	public List<OrderResponseModel> getAllOrderByCustomerId(@PathVariable("customerId") Integer id) {

		List<Order> orderList = orderRepository.findAllOrdersByCustomerId(id);
		List<OrderResponseModel> orderResponseList = new ArrayList<>();
		orderList.forEach(orderObject -> {
			OrderResponseModel orderResponseModel = new OrderResponseModel();
			orderResponseModel.setOrder(orderObject);
			orderResponseModel.setCustomerAddress(
					customerAddressRepository.findByCustAddressId(orderObject.getCustomerAddressID()));
			orderResponseList.add(orderResponseModel);
		});

		return orderResponseList;
	}

	@PostMapping(value = "/orders")
	public Order addOrder(@RequestBody Order orderRequest) {


		//		Integer customerID=orderRequest.getCustomerId();

		Optional<Cart> cart=cartRepository.findByCustomerId(orderRequest.getCustomerId());


		//		Double d=cart.get().getCartTotalPrice();

		//		System.out.println(cartlist.get().getCartId());

		List<Invoice> invoiceList = new ArrayList<Invoice>();

		List<CartProduct> cartProductlist=cart.get().getCartProducts();

		//		Invoice invoice;

		for(CartProduct i:cartProductlist)
		{

			Invoice invoice=new Invoice();

			System.out.println(i.getProductId());

			Integer productId=i.getProductId();

			Optional<Product> prod = productRepository.findById(productId);

			invoice.setProductId(i.getProductId());
			invoice.setProductTotalAmount(prod.get().getProductBuyingPrice());

			invoiceList.add(invoice);

			orderRequest.setInvoiceList(invoiceList);

		}
		orderRequest.setOrderTotal(cart.get().getCartTotalPrice());
		orderRequest.setOrderTotalQuantity(cart.get().getCartItemQuantity());


		System.out.println("Order Request==>"+orderRequest);

		//		orderTotalQuantity

		//		System.out.println("cartList=>"+cartlist.ge);

		//		List<Customer> customer=customerRepository.find



		//		List<Invoice> orderInvoiceList = orderRequest.getInvoiceList();
		//
		//		List<Invoice> invoiceList = new ArrayList<Invoice>();
		//		List<Cart> cartList = cartRepository.findByCustomerId(orderRequest.getCustomerId());
		//
		//		String successResponse = "Order created Successfully";
		//
		//		boolean isCheckProductQuantity = true;
		//		Integer orderTotalQuantity = 0;
		//		// Scenario 1 -
		//		for (Invoice i : orderInvoiceList) {
		//			Integer productId = i.getProductId();
		//			Integer productQuantity = i.getQuantity();
		//			Optional<Product> prod = productRepository.findById(productId);
		//			Integer productAvailableQunatity = prod.get().getProductAvailableQuantity();
		//
		//			if (productAvailableQunatity < productQuantity) {
		//				isCheckProductQuantity = false;
		//				System.out.println("Check condidtion is False or true=>" + isCheckProductQuantity);
		//			} else {
		//				orderTotalQuantity = orderTotalQuantity + productQuantity;
		//				Integer productAvailableQuantity = productAvailableQunatity - productQuantity;
		//				prod.get().setProductAvailableQuantity(productAvailableQuantity);
		//				invoiceList.add(i);
		//				orderRequest.setInvoiceList(invoiceList);
		//			}
		//		}
		//		if (isCheckProductQuantity == false) {
		//			System.out.println("Requested quantity is too high. Order cannot be saved");
		//		} else {
		//			orderRequest.setOrderTotalQuantity(orderTotalQuantity);
		//			orderRequest.setInvoiceList(invoiceList);
		//			// System.out.println(orderRequest);
		//			System.out.println(successResponse);
		//			orderRepository.save(orderRequest);
		//			cartRepository.deleteAll(cartList);
		//			return orderRequest;
		//		}
		return null;

	}

	@PutMapping(value = "/orders")
	public Order updateOrder(@RequestBody Order orderRequest) {
		Order order = orderRepository.findById(orderRequest.getOrderId()).get();
		order.setCustomerId(orderRequest.getCustomerId());
		order.setOrderStatus(orderRequest.getOrderStatus());
		order.setOrderTotal(orderRequest.getOrderTotal());
		order.setOrderTotalQuantity(orderRequest.getOrderTotalQuantity());
		return orderRepository.save(order);
	}

	@DeleteMapping(value = "/orders/{orderId}")
	public void deleteOrderById(@PathVariable("orderId") Integer id) {
		orderRepository.deleteById(id);
	}

}
