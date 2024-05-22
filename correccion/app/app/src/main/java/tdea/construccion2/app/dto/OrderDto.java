package tdea.construccion2.app.dto;

import tdea.construccion2.app.models.Order;

public class OrderDto {
	private long idorder;
	private PersonDto idOwner;
	private PetDto idPet;
	private PersonDto idDoctor;
	private String medicine;
	private long dateOrder;
	private String orderCancellation;

	public OrderDto() {
		super();
	}

	public OrderDto(long idorder,PetDto idPet, PersonDto idOwner, PersonDto idDoctor, String medicine, long dateOrder,
			String orderCancellation) {
		super();
		this.idorder = idorder;
		this.idPet = idPet;
		this.idOwner = idOwner;
		this.idDoctor = idDoctor;
		this.medicine = medicine;
		this.dateOrder = dateOrder;
		this.orderCancellation = orderCancellation;
	}

	public OrderDto(Order order) {
		this.idorder = order.getIdorder();
		this.idPet = new PetDto(order.getIdPet());
		this.idOwner = new PersonDto(order.getIdOwner());
		this.idDoctor = new PersonDto(order.getIdDoctor());
		this.medicine = order.getMedicine();
		this.dateOrder = order.getDateorder();
		this.orderCancellation = order.getOrderCancellation();
		
	}

	
	
	public long getIdorder() {
		return idorder;
	}

	public void setIdorder(long idorder) {
		this.idorder = idorder;
	}

	public PetDto getIdPet() {
		return idPet;
	}

	public void setIdPet(PetDto idPet) {
		this.idPet = idPet;
	}

	public PersonDto getIdOwner() {
		return idOwner;
	}

	public void setIdOwner(PersonDto idOwner) {
		this.idOwner = idOwner;
	}

	public PersonDto getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(PersonDto idDoctor) {
		this.idDoctor = idDoctor;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public long getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(long dateOrder) {
		this.dateOrder = dateOrder;
	}

	public String getOrderCancellation() {
		return orderCancellation;
	}

	public void setOrderCancellation(String orderCancellation) {
		this.orderCancellation = orderCancellation;
	}

	public void setIdOwner1(PersonDto personDto1) {
		// TODO Auto-generated method stub

	}

}
