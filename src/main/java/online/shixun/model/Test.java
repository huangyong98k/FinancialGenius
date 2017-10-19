package online.shixun.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_test")
public class Test {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
}
