package entities;
import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Set;


/**
 * The persistent class for the eventcause database table.
 * 
 */
@Entity
@Table(name="EventCause")
@XmlRootElement
public class EventCause implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eventcauseCode;
	@Column
	private int causeCode;
	@Column
	private String causeDescription;
	@Column
	private int eventID;

	@OneToMany(mappedBy="eventcause", fetch = FetchType.EAGER)
	private Set<BaseData> basedata;

    public EventCause() {
    }

    public EventCause(int causeCode, int eventID, String causeDescription) {
		super();

		this.causeCode = causeCode;
		this.eventID = eventID;
		this.causeDescription = causeDescription;
	}
    
	public int getEventcauseCode() {
		return this.eventcauseCode;
	}

	public void setEventcauseCode(int eventcauseCode) {
		this.eventcauseCode = eventcauseCode;
	}

	public int getCauseCode() {
		return this.causeCode;
	}

	public void setCauseCode(int causeCode) {
		this.causeCode = causeCode;
	}

	public String getCauseDescription() {
		return this.causeDescription;
	}

	public void setCauseDescription(String causeDescription) {
		this.causeDescription = causeDescription;
	}

	public int getEventID() {
		return this.eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}
	
}