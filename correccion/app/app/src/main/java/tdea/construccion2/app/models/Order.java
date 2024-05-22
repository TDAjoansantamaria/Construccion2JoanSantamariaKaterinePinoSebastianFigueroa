package tdea.construccion2.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import tdea.construccion2.app.dto.OrderDto;


@Entity
@Table(name = "orderhc")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idorder;
	@ManyToOne
	@JoinColumn(name = "idpet")
	private Pet idPet;
	@ManyToOne
	@JoinColumn(name = "idowner")
	private Person idOwner;
	@ManyToOne
	@JoinColumn(name = "iddoctor")
	private Person idDoctor;
	@Column(name = "medicine")
	private String medicine;
	@Column(name = "dateorder")
	private long dateorder;
	@Column(name = "ordercancellation")
	private String orderCancellation;

	
	public Order(OrderDto orderDto) {
		this.idDoctor=new Person(orderDto.getIdDoctor());
		this.idOwner=new Person(orderDto.getIdOwner());
	    this.idPet = new Pet(orderDto.getIdPet());
	    this.medicine = orderDto.getMedicine();
		this.dateorder = orderDto.getDateOrder();
		this.orderCancellation = orderDto.getOrderCancellation();	
		}

	public Order() {
		super();
	}

	public long getIdorder() {
		return idorder;
	}

	public void setIdorder(long idorder) {
		this.idorder = idorder;
	}

	public long getDateorder() {
		return dateorder;
	}

	public void setDateorder(long dateorder) {
		this.dateorder = dateorder;
	}

	public Pet getIdPet() {
	return idPet;
	}

	public void setIdPet(Pet idPet) {
		this.idPet = idPet;
	}

	public Person getIdOwner() {
		return idOwner;
	}

	public void setIdOwner(Person idOwner) {
		this.idOwner = idOwner;
	}

	public Person getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(Person idDoctor) {
		this.idDoctor = idDoctor;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public long getDateOrder() {
		return dateorder;
	}

	public void setDateOrder(long dateOrder) {
		this.dateorder = dateOrder;
	}

	public String getOrderCancellation() {
		return orderCancellation;
	}

	public void setOrderCancellation(String orderCancellation) {
		this.orderCancellation = orderCancellation;
	}

}
