package online.shixun.model;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_investment")
public class Investment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long investmentId;
	private Date beginTime;
	private Date overTime;
	private double earning;
	private int investmentStatus;
	private int number;
	private double principal;
}
