package entityWS;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import entities.CellTable;
import entityDAO.CellTableDAO;

@Path("/celltable")
@Stateless
@LocalBean
public class CellTableWS {

    @EJB
    private CellTableDAO cellTablesDao;

    @GET
    @Path("/{cellID}")
    @Produces("application/json")
    public CellTable getCellTable(@PathParam("cellID") int cellID) {
        return cellTablesDao.getCellTable(cellID);
    }
    
    @GET
    @Path("/all")
    @Produces("application/json")
    public List<CellTable> getAllCellTable() {
        return cellTablesDao.getAllCellTable();
    }
    
    @POST
    public void addCellTables(List<CellTable> cellTables) {
        cellTablesDao.addCellTables(cellTables);
    }
    
}