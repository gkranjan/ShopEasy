package com.shopeasy.main;

import java.util.Scanner;

import com.shopeasy.model.Customer;
import com.shopeasy.model.Product;
import com.shopeasy.payment.CashOnDelivery;
import com.shopeasy.payment.Payment;
import com.shopeasy.payment.UpiPayment;
import com.shopeasy.service.CartService;
import com.shopeasy.service.OrderService;
import com.shopeasy.service.ProductService;

public class ShopEasyApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Create service objects.
		ProductService productService = new ProductService();
		CartService cartService = new CartService();
		OrderService orderService = new OrderService();

		System.out.println("====================================");
		System.out.println("       WELCOME TO SHOPEASY");
		System.out.println("====================================");

		System.out.print("Enter Customer ID: ");
		int customerId = readInt(sc);

		System.out.print("Enter Customer Name: ");
		String name = sc.nextLine();

		System.out.print("Enter Customer Email: ");
		String email = sc.nextLine();
       
		Customer customer = new Customer(customerId, name, email);

		int choice;

		do {
			System.out.println();
			System.out.println("============== MAIN MENU ==============");
			System.out.println("1. View Products");
			System.out.println("2. Add Product to Cart");
			System.out.println("3. View Cart");
			System.out.println("4. Remove Product from Cart");
			System.out.println("5. Checkout");
			System.out.println("6. View Customer Details");
			System.out.println("0. Exit");
			System.out.println("=======================================");

			System.out.print("Enter your choice: ");
			choice = readInt(sc);

			switch (choice) {

			case 1:
				productService.displayProducts(); 
				break;

			case 2:
				productService.displayProducts();

				System.out.print("Enter Product ID: ");
				int productId = readInt(sc);

				System.out.print("Enter Quantity: ");
				int quantity = readInt(sc);

				Product product = productService.findProductById(productId);

				cartService.addToCart(product, quantity);
				break;

			case 3:
				cartService.displayCart();
				break;

			case 4:
				System.out.print("Enter Product ID to remove: ");
				int removeId = readInt(sc);

				cartService.removeFromCart(removeId);
				break;

			case 5:
				if (cartService.isEmpty()) {
					System.out.println("Your cart is empty.");
					break;
				}

				cartService.displayCart();

				System.out.println("Choose Payment Method:");
				System.out.println("1. UPI (Simulation)");
				System.out.println("2. Cash on Delivery");

				System.out.print("Enter choice: ");
				int paymentChoice = readInt(sc);

				Payment payment;
				String paymentMethod;

				if (paymentChoice == 1) {
					payment = new UpiPayment();
					paymentMethod = "UPI (Simulation)";
				} else if (paymentChoice == 2) {
					payment = new CashOnDelivery();
					paymentMethod = "Cash on Delivery";
				} else {
					System.out.println("Invalid payment method.");
					break;
				}

				orderService.placeOrder(customer, cartService, payment, paymentMethod);

				break;

			case 6:
				customer.displayCustomer();
				break;

			case 0:
				System.out.println("Thank you for visiting ShopEasy!");
				break;

			default:
				System.out.println("Invalid menu choice. Try again.");
			}

		} while (choice != 0);

		sc.close();
	}

	// Read an integer without crashing on invalid text.
	private static int readInt(Scanner sc) {
		while (true) {
			String input = sc.nextLine();

			try {
				return Integer.parseInt(input.trim());
			} catch (NumberFormatException e) {
				System.out.print("Invalid input. Enter a whole number: ");
			}
		}
	}
}