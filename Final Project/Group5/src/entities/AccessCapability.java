package entities;
import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the accesscapability database table.
 * 
 */

@Entity
@Table (name="AccessCapability")
public class AccessCapability implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accessID;
	@Column
	private String accessCapability;

    public AccessCapability() {
    }

    public AccessCapability(String accessCapability) {
		super();
		this.accessCapability = accessCapability;
	}
	public int getAccessID() {
		return this.accessID;
	}

	public void setAccessID(int accessID) {
		this.accessID = accessID;
	}

	public String getAccessCapability() {
		return this.accessCapability;
	}

	public void setAccessCapability(String accessCapability) {
		this.accessCapability = accessCapability;
	}
	
}