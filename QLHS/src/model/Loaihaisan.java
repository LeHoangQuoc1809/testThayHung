package model;
// Generated Nov 25, 2023, 1:39:49 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Loaihaisan generated by hbm2java
 */
@Entity
@Table(name = "loaihaisan", catalog = "qlhs")
public class Loaihaisan implements java.io.Serializable {

	private Integer ma;
	private String ten;
	private Set<Haisan> haisans = new HashSet<Haisan>(0);

	public Loaihaisan() {
	}

	public Loaihaisan(String ten) {
		this.ten = ten;
	}

	public Loaihaisan(String ten, Set<Haisan> haisans) {
		this.ten = ten;
		this.haisans = haisans;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ma", unique = true, nullable = false)
	public Integer getMa() {
		return this.ma;
	}

	public void setMa(Integer ma) {
		this.ma = ma;
	}

	@Column(name = "ten", nullable = false, length = 50)
	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loaihaisan")
	public Set<Haisan> getHaisans() {
		return this.haisans;
	}

	public void setHaisans(Set<Haisan> haisans) {
		this.haisans = haisans;
	}

}
