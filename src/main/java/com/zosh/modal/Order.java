package com.zosh.modal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.zosh.user.domain.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String orderId;

	@ManyToOne
	private User user;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderItem> orderItems = new ArrayList<>();

	private LocalDate orderDate = LocalDate.now();

	private LocalDate deliveryDate;

	@OneToOne
	private Address shippingAddress;

	@Embedded
	private PaymentDetails paymentDetails = new PaymentDetails();

	private double totalPrice;

	private Integer totalDiscountedPrice;

	private Integer discount;

	private OrderStatus orderStatus;

	private int totalItem;

	private LocalDateTime createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getTotalDiscountedPrice() {
		return totalDiscountedPrice;
	}

	public void setTotalDiscountedPrice(Integer totalDiscountedPrice) {
		this.totalDiscountedPrice = totalDiscountedPrice;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Order(Long id, String orderId, User user, List<OrderItem> orderItems, LocalDate orderDate,
			LocalDate deliveryDate, Address shippingAddress, PaymentDetails paymentDetails, double totalPrice,
			Integer totalDiscountedPrice, Integer discount, OrderStatus orderStatus, int totalItem,
			LocalDateTime createdAt) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.user = user;
		this.orderItems = orderItems;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.shippingAddress = shippingAddress;
		this.paymentDetails = paymentDetails;
		this.totalPrice = totalPrice;
		this.totalDiscountedPrice = totalDiscountedPrice;
		this.discount = discount;
		this.orderStatus = orderStatus;
		this.totalItem = totalItem;
		this.createdAt = createdAt;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

}
