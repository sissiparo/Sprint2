package entityDAO;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import entities.BaseData;
import entities.Failure;

import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Stateless
@LocalBean
public class BaseDataDAO {

	@PersistenceContext
	private EntityManager em;

	public BaseData getBaseData(int baseDataID) {
		return em.find(BaseData.class, baseDataID);
	}

	public List<BaseData> getAllBaseData() {
		// TypedQuery<BaseData> q = em.createQuery("select o from BaseData o",
		// BaseData.class);
		Query q = em.createQuery("select o from BaseData o");
		List<BaseData> listOfBaseData = q.setMaxResults(10).getResultList();
		return listOfBaseData;
	}

	public List<BaseData> getImsiBaseData() {
		Query q = em.createQuery("select imsi from BaseData");
		List<BaseData> listOfBaseData = q.setMaxResults(10).getResultList();
		return listOfBaseData;

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addBaseDatas(List<BaseData> baseDatas) {
		for (BaseData baseData : baseDatas) {
			em.persist(baseData);
		}
	}

	public List<BaseData> userStory4(String imsi) {
		Query q = em
				.createQuery("select baseDate, eventcause.eventID, eventcause.causeCode, eventcause.causeDescription from BaseData"
						+ " where imsi=" + imsi);
		List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;
	}

	public List<BaseData> userStory5(String imsi, Date startDate,
			Date endDate) {


		Query q = em
				.createQuery(
						"select count(*) from BaseData where BaseDate >= :startDate and BaseDate <= :endDate and imsi="
								+ imsi)
				.setParameter("startDate", startDate, TemporalType.DATE)
				.setParameter("endDate", endDate, TemporalType.DATE);
		List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;
	}

	public List<BaseData> userStory6(String imsi) {
		Query q = em
				.createQuery("SELECT imsi, eventcause.eventID, eventcause.eventcauseCode,"
						+ " eventcause.causeCode, eventcause.causeDescription FROM BaseData where imsi="
						+ imsi + " GROUP BY eventcause.causeCode");
		List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;
	}


	public List<BaseData> userStory7(Date startDate, Date endDate) {
		

		Query q = em
				.createQuery(
						"SELECT baseDate,imsi FROM BaseData where BaseDate >= :startDate and BaseDate <= :endDate")
				.setParameter("startDate", startDate, TemporalType.DATE)
				.setParameter("endDate", endDate, TemporalType.DATE);
		List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;
	}

	public List<BaseData> userStory8(String tac, Date startDate,
			Date endDate) {

		

		Query q = em
				.createQuery(
						"select count(*) from BaseData where BaseDate >= :startDate and BaseDate <= :endDate and TAC="
								+ tac)
				.setParameter("startDate", startDate, TemporalType.DATE)
				.setParameter("endDate", endDate, TemporalType.DATE);
		List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;
	}

	public List<BaseData> userStory9(Date startDate, Date endDate) {

		

		Query q = em
				.createQuery(
						"select baseDate, imsi, eventcause.eventID, eventcause.causeCode,eventcause.causeDescription from BaseData where BaseDate >= :startDate and BaseDate <= :endDate")
				.setParameter("startDate", startDate, TemporalType.DATE)
				.setParameter("endDate", endDate, TemporalType.DATE);
		List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;
	}

	
	public List<BaseData> userStory10(String tac) {

		Query q = em
				.createQuery("Select userequipment.tac, eventcause.eventID, eventcause.causeCode,"
						+ " eventcause.causeDescription, count(*) "
						+ "from BaseData where userequipment.tac= "
						+ tac
						+ " group by eventcause.eventID, eventcause.causeCode");
		List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;
	}

	public List<BaseData> populateDdl() {

		Query q = em
				.createQuery("Select userequipment.uemodel.modelName from BaseData");
		List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;
	}

	public List<BaseData> userStory11(Date startDate, Date endDate) {

		
		Query q = em
				.createQuery(
						"select mccmnc.country.mcc, mccmnc.mnc, celltable.cellID, count(*) as totalFailures from BaseData where BaseDate>= :startDate and BaseDate <= :endDate group by mccmnc.mccmncID, celltable.cellID order by totalFailures DESC")
				.setParameter("startDate", startDate, TemporalType.DATE)
				.setParameter("endDate", endDate, TemporalType.DATE);
		List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;
	}

	public List<BaseData> userStory12(Date startDate, Date endDate) {

		
		Query q = em
				.createQuery(
						"SELECT imsi, userequipment.tac, mccmnc.country.mcc, mccmnc.mnc, count(*) as totalFailures from BaseData where BaseDate >= :startDate and BaseDate <= :endDate group by imsi order by totalFailures DESC")
				.setParameter("startDate", startDate, TemporalType.DATE)
				.setParameter("endDate", endDate, TemporalType.DATE);
		List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;
	}

	public List<BaseData> userStory14(String failureClassID) {
		Query q = em
				.createQuery("SELECT baseDate, imsi, eventcause.eventID, eventcause.causeDescription from BaseData where failureClassID ="
						+ Integer.parseInt(failureClassID)
						+ " order by imsi,baseDate");
		List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;
	}

	public List<BaseData> failureClasses() {
		Query q = em
				.createQuery("SELECT failureClassID from BaseData group by failureClassID");
		List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;
	}

	public List<Failure> getFailures(String notneeded) {
		Query q = em.createQuery("SELECT o from Failure o");
		List<Failure> listOfFailures = q.getResultList();
		return listOfFailures;
	}

}
