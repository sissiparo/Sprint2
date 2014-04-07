package entities;
import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Set;


/**
 * The persistent class for the uemodel database table.
 * 
 */

@Entity
@XmlRootElement
public class UEModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int modelId;

	private String modelName;

	@OneToMany(mappedBy="uemodel", fetch = FetchType.EAGER)
	private Set<UserEquipment> userequipments;

    public UEModel() {
    }

    public UEModel(String modelName) {
		super();
		this.modelName = modelName;

	}
	public int getModelId() {
		return this.modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return this.modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
}