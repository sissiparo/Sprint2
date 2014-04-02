//package entityWS;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//
//import javax.ejb.EJB;
//import javax.ejb.LocalBean;
//import javax.ejb.Stateless;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//
//import jxl.Cell;
//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.WorkbookSettings;
//import entities.AccessCapability;
//import entityDAO.JPAAccessCapabilityDAO;
//
//@Path("/accesscapability")
//@Stateless
//@LocalBean
//public class AccessCapabilityWS {
//
//	@EJB
//	private static JPAAccessCapabilityDAO accessCapabilitysDao;
//
//	@GET
//	@Path("/{accessID}")
//	public AccessCapability getAccessCapability(@PathParam("accessID") int indivCapabilities) {
//		return accessCapabilitysDao.getAccessCapability(indivCapabilities);
//	}
//	
//	@GET
//	@Path("/{accessCapability}")
//	public static AccessCapability getAccessCapability(@PathParam("accessCapability") String indivCapabilities) {
//		return accessCapabilitysDao.getAccessCapability(indivCapabilities);
//	}
//
//	@GET
//	@Path("/all")
//	public List<AccessCapability> getAllAccessCapability() {
//		return accessCapabilitysDao.getAllAccessCapability();
//	}
//
//	@POST
//	public void addAccessCapabilitys(List<AccessCapability> accessCapabilities) {
//		accessCapabilitysDao.addAccessCapabilitys(accessCapabilities);
//	}
//	
//	@POST
//	public static void addAccessCapability(String accessCapability) {
//		accessCapabilitysDao.addAccessCapability(accessCapability);
//	}
//	
//	
//
//	private static Workbook workbook;
//	public AccessCapabilityWS() {
//
//		super();
//		//initialise();
//	}
//	public static Workbook getWorkbook(String workbookFileName) {
//		try {
//			if (workbook == null) {
//				WorkbookSettings workbookSettings = new WorkbookSettings();
//				workbookSettings.setLocale(new Locale("en", "EN"));
//				workbook = Workbook.getWorkbook(new File(workbookFileName),
//						workbookSettings);
//			}
//		} catch (UnsupportedEncodingException e) {
//			System.err.println(e.toString());
//		} catch (IOException e) {
//			System.err.println(e.toString());
//		} catch (Exception e) {
//			System.err.println(e.toString());
//		}
//		return workbook;
//	}
//
//	static String	workbookFileName = "/home/group5/workspace/Database3/LargeData.xls";	
//	
//	public static void main(String[] args){
//	//public void initialise() {
//		Workbook workbook = getWorkbook(workbookFileName);
//		Sheet currentSheet = workbook.getSheet(3);
//		
//		Cell[] row;
//
//		for (int i = 1; i < currentSheet.getRows(); i++) {
//			row = currentSheet.getRow(i);
//
//			if (row.length > 0) {
//				String concatCapabilities = row[3].getContents();
//				String[] indivCapabilities = concatCapabilities.split(", ");
//				for (int j = 0; j < indivCapabilities.length; j++) {
//					
//					if (getAccessCapability(indivCapabilities[j]) == null) {
//					
//						addAccessCapability(indivCapabilities[j]);
//					}
//				}
//
//			}
//
//		}
//
//	}
//	
//		
//	
//	
//
//}
//
//
//
