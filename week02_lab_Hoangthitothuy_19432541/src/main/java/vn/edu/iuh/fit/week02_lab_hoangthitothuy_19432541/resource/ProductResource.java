package vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.dao.ProductDAO;
import vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.models.Product;

import java.util.List;

@Path("/products")
public class ProductResource {
    ProductDAO productDAO = new ProductDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello()   throws  Exception{
        productDAO.setup();;
        List<Product> products = productDAO.listProduct();

        String json;

        ObjectMapper objectMapper = new ObjectMapper();

        json = objectMapper.writeValueAsString(products);

        return json;
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Product findById(@PathParam("id") int ms)throws Exception{
        System.out.println(ms);
        productDAO.setup();
        return  productDAO.findProductById(ms);
    }
    @GET
    @Path("delete/{id}")
    @Produces("application/json")
    public void deleteById(@PathParam("id") int ms)throws Exception{
        System.out.println(ms);
        productDAO.setup();
        productDAO.deleteProductById(ms);
    }

    @POST
    @Consumes("application/json")

    public Response insertNewCandidate(Product product) throws Exception{
        productDAO.setup();
        productDAO.insertProduct(product);
        return Response.ok("Success").build();
    }

}