package vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.test;

import vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.dao.EmployeeDAO;
import vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.dao.ProductDAO;
import vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.dao.Product_imageDAO;
import vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.models.Product;
import vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.models.ProductImage;

public class Main {
    public static void main(String[] args) {

        //employee
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.setup();




        //product
        ProductDAO productDAO = new ProductDAO();
        productDAO.setup();

        productDAO.insertProduct(new Product(1,"Mì gói","Thức ăn nhanh",100,"Chua cay",1));
        productDAO.insertProduct(new Product(2,"Mì Omachi","Thức ăn nhanh",100,"Bò",1));
        productDAO.insertProduct(new Product(3,"Mì Morden","Thức ăn nhanh ",100,"Mỳ tương đen",1));


        //productIMG
        Product_imageDAO productImageDAO = new Product_imageDAO();
        productImageDAO.setup();
        productImageDAO.insertProductImage(new ProductImage(1,"h","h",productDAO.findProductById(1)));
        productImageDAO.insertProductImage(new ProductImage(1,"h","h",productDAO.findProductById(1)));
        productImageDAO.insertProductImage(new ProductImage(1,"h","h",productDAO.findProductById(1)));

        productImageDAO.insertProductImage(new ProductImage(2,"h","h",productDAO.findProductById(1)));
        productImageDAO.insertProductImage(new ProductImage(2,"h","h",productDAO.findProductById(1)));
        productImageDAO.insertProductImage(new ProductImage(2,"h","h",productDAO.findProductById(1)));

        //  productImageDAO.insertProductImage(new Product_image());

    }
}
