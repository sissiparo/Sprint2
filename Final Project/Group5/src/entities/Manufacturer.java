package entities;
import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Set;


/**
 * The persistent class for the manufacturer database table.
 * 
 */

@Entity
@Table(name="Manufacturer")
@XmlRootElement
public class Manufacturer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int manufacturerID;
	@Column
	private String manufacturerName;

	@OneToMany(mappedBy="manufacturer", fetch = FetchType.EAGER)
	private Set<UserEquipment> userequipments;

    public Manufacturer() {
    }
    
    public Manufacturer(String manufacturerName) {
		super();
		this.manufacturerName = manufacturerName;
	}

	public int getManufacturerID() {
		return this.manufacturerID;
	}

	public void setManufacturerID(int manufacturerID) {
		this.manufacturerID = manufacturerID;
	}

	public String getManufacturerName() {
		return this.manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
	
}