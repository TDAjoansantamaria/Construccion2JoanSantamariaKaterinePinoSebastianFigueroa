package tdea.construccion2.app.dao;

import tdea.construccion2.app.dto.OrderDto;

public interface OrderDao {
	public OrderDto findOrderById(OrderDto orderDto) throws Exception;

	public OrderDto createOrder(OrderDto ordetDto) throws Exception;
}
