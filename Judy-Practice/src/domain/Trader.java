package domain;

import java.util.ArrayList;
import java.util.List;

public class Trader{
	  private int id;
	  private List<Order> orders = new ArrayList<>();
	 
	  public Trader(int id) {
	    this.id = id;
	  }

	  public List<Order> getOrders() {
	    return orders;
	  }

	  public void addOrder(Order order) {
	    orders.add(order);
	  }
	 
	}

