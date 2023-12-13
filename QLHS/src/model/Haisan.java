package model;
// Generated Nov 25, 2023, 1:39:49 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Haisan generated by hbm2java
 */
@Entity
@Table(name = "haisan", catalog = "qlhs")
public class Haisan implements java.io.Serializable {

	private Integer ma;
	private Loaihaisan loaihaisan;
	private String ten;
	private String xuatxu;
	private String donvitinh;
	private boolean tuoisong;

	public Haisan() {
	}

	public Haisan(Loaihaisan loaihaisan, String ten, String xuatxu, String donvitinh, boolean tuoisong) {
		this.loaihaisan = loaihaisan;
		this.ten = ten;
		this.xuatxu = xuatxu;
		this.donvitinh = donvitinh;
		this.tuoisong = tuoisong;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maloai", nullable = false)
	public Loaihaisan getLoaihaisan() {
		return this.loaihaisan;
	}

	public void setLoaihaisan(Loaihaisan loaihaisan) {
		this.loaihaisan = loaihaisan;
	}

	@Column(name = "ten", nullable = false, length = 50)
	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	@Column(name = "xuatxu", nullable = false, length = 50)
	public String getXuatxu() {
		return this.xuatxu;
	}

	public void setXuatxu(String xuatxu) {
		this.xuatxu = xuatxu;
	}

	@Column(name = "donvitinh", nullable = false, length = 20)
	public String getDonvitinh() {
		return this.donvitinh;
	}

	public void setDonvitinh(String donvitinh) {
		this.donvitinh = donvitinh;
	}

	@Column(name = "tuoisong", nullable = false)
	public boolean isTuoisong() {
		return this.tuoisong;
	}

	public void setTuoisong(boolean tuoisong) {
		this.tuoisong = tuoisong;
	}

}