package entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Set;

/**
 * The persistent class for the mccmnc database table.
 * 
 */
@NamedQueries({
		@NamedQuery(name = "MCCMNC.findAll", query = "select o from MCCMNC o"),
		@NamedQuery(name = "MCCMNC.findMCCMNCById", query = "select o from MCCMNC o where o.mccmncID=:mccmncID"),
		@NamedQuery(name = "MCCMNC.findMCCMNCByName", query = "select o from MCCMNC o where o.mnc=:mnc"),
		@NamedQuery(name = "MCCMNC.findMCCMNCByMCCMNC", query = "select o from MCCMNC o where o.mnc=:mnc and o.country.mcc=:mcc") })
@Entity
@Table(name = "MCCMNC")
@XmlRootElement
public class MCCMNC implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mccmncID;
	@Column
	private int mnc;
	@Column
	private String operator;

	@OneToMany(mappedBy = "mccmnc", fetch = FetchType.EAGER)
	private Set<BaseData> basedata;

	@ManyToOne
	@JoinColumn(name = "mcc")
	private Country country;

	public MCCMNC() {
	}

	public MCCMNC(Country country, int mnc, String operator) {
		super();

		this.country = country;
		this.mnc = mnc;
		this.operator = operator;
	}

	public int getMccmncID() {
		return this.mccmncID;
	}

	public void setMccmncID(int mccmncID) {
		this.mccmncID = mccmncID;
	}

	public int getMnc() {
		return this.mnc;
	}

	public void setMnc(int mnc) {
		this.mnc = mnc;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}