package entities;
import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Set;


/**
 * The persistent class for the failure database table.
 * 
 */

@Entity
@XmlRootElement
public class Failure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int failureID;

	private String failureDescription;

	@OneToMany(mappedBy="failure", fetch = FetchType.EAGER)
	private Set<BaseData> basedata;

    public Failure() {
    }

    public Failure(int failureID, String failureDescription) {
		super();
		this.failureID = failureID;
		this.failureDescription = failureDescription;
	}
    
	public int getFailureID() {
		return this.failureID;
	}

	public void setFailureID(int failureID) {
		this.failureID = failureID;
	}

	public String getFailureDescription() {
		return this.failureDescription;
	}

	public void setFailureDescription(String failureDescription) {
		this.failureDescription = failureDescription;
	}
	
}