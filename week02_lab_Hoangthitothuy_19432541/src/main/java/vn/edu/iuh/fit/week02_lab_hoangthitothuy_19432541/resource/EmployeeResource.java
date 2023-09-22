package vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.dao.EmployeeDAO;
import vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.models.Employee;

import java.util.List;

@Path("/employees")
public class EmployeeResource {

    EmployeeDAO employeeDAO = new EmployeeDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello()   throws  Exception{
        employeeDAO.setup();;
        List<Employee> employees = employeeDAO.listEmployee();

        String json;

        ObjectMapper objectMapper = new ObjectMapper();

            json = objectMapper.writeValueAsString(employees);

        return json;
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Employee findById(@PathParam("id") int ms)throws Exception{
        System.out.println(ms);
        employeeDAO.setup();
    return  employeeDAO.findById(ms);
}
    @GET
    @Path("delete/{id}")
    @Produces("application/json")
    public void deleteById(@PathParam("id") int ms)throws Exception{
        System.out.println(ms);
        employeeDAO.setup();
        employeeDAO.deleteById(ms);
    }

    @POST
    @Consumes("application/json")

    public Response insertNewCandidate(Employee employee) throws Exception{
        employeeDAO.setup();
        employeeDAO.insertEmployee(employee);
        return Response.ok("Success").build();
    }

}