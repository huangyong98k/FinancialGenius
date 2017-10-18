package online.shixun.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productId;
	private String productName;
	private double productCapital;
	private double productRate;
	private String productMoney;
	private String productMechanism;
	private int productStatus;
	@OneToMany
	@JoinColumn(name="productId")
	private List<Investment> investments;
}
