package tdea.construccion2.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdea.construccion2.app.dto.OrderDto;
import tdea.construccion2.app.models.Order;
import tdea.construccion2.app.repository.OrderRepository;

@Service
public class OrderDaoImp implements OrderDao {
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public OrderDto findOrderById(OrderDto orderDto) throws Exception {
		Order order =orderRepository.findById(orderDto.getDateOrder());
		if (order == null) {
			return null;
		}
		return new OrderDto(order);
	}

	@Override
	public  OrderDto createOrder(OrderDto orderDto) {
		Order order= new Order(orderDto);
		order = orderRepository.save(order);
		System.out.println(order.getDateOrder());
		return new OrderDto(order);
	}

	public OrderRepository getOrderRepository() {
		return orderRepository;
	}

	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	
}
