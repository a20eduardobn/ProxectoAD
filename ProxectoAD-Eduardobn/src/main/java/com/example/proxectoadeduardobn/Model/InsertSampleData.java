package com.example.proxectoadeduardobn.Model;

import com.example.proxectoadeduardobn.Model.DAO.AlmacenDAOImpl;
import com.example.proxectoadeduardobn.Model.DAO.ProductoDAOImpl;
import com.example.proxectoadeduardobn.Model.DAO.ProveedorDAOImpl;
import com.example.proxectoadeduardobn.Model.Entities.*;
import jakarta.persistence.EntityManager;


//Clase para insertar unos datos de ejemplo en la base de datos
public class InsertSampleData {
    public static void insertData(){
        try (EntityManager eManager = EntityManagerUtil.createEntityManager()) {
            AlmacenDAOImpl almacenDAO = new AlmacenDAOImpl(eManager);
            ProductoDAOImpl productoDAO = new ProductoDAOImpl(eManager);
            ProveedorDAOImpl proveedorDAO = new ProveedorDAOImpl(eManager);

            Direccion direccionAlmacen = new Direccion("Calle San Clemente", "Santiago de Compostela", "A Coruña", "15705");
            Direccion direccionSegundoAlmacen = new Direccion("Avenida Diagonal", "Barcelona", "Barcelona", "08019");
            Direccion direccionProveedor = new Direccion("Calle Mayor", "Madrid", "Madrid", "28001");
            Direccion direccionSegundoProveedor = new Direccion("Rua do Rosal", "Vigo", "Pontevedra", "36201");
            Direccion direccionTercerProveedor = new Direccion("Avenida de Concha Espina", "Madrid", "Madrid", "28036");

            Almacen almacen1 = new Almacen("Almacen 1", direccionAlmacen, 230, false);
            Almacen almacen2 = new Almacen("Almacen 2", direccionSegundoAlmacen, 320, true);

            Proveedor proveedor1 = new Proveedor("67427896Q", "Samsung España", "981234567",direccionProveedor);
            Proveedor proveedor2 = new Proveedor("12345678A", "Ikea", "986123456", direccionSegundoProveedor);
            Proveedor proveedor3 = new Proveedor("87654321B", "Nike", "912345678", direccionTercerProveedor);

            Producto producto1 = new Producto("Smartphone", "Samsung", "Galaxy S21", "Nuevo modelo de smartphone", 799.99, 100, true, null, Categoria.ELECTRONICA);
            producto1.setImagenFromURL("https://images.samsung.com/is/image/samsung/assets/pt/2201/preorder/1_image_carousel/" +
                    "2_group_kv2/S21FE_Carousel_GroupKV2_MO.jpg?imbypass=true");
            Producto producto2 = new Producto("Camiseta", "Nike", "Sportswear", "Camiseta deportiva de algodón", 29.99, 200, true, null, Categoria.ROPA);
            producto2.setImagenFromURL("https://www.deportesapalategui.com/media/catalog/product/cache/1/small_imag" +
                    "e/580x400/9df78eab33525d08d6e5fb8d27136e95/8/9/892215-100-phsfh001-1000.jpeg");
            Producto producto3 = new Producto("Silla", "IKEA", "POÄNG", "Silla ergonómica de madera", 79.99, 50, true, null, Categoria.HOGAR);
            producto3.setImagenFromURL("https://www.ikea.com/es/es/images/products/ivar-silla-pino__0728155_pe736115_s5.jpg");

            proveedor1.addProducto(producto1);
            proveedor2.addProducto(producto3);
            proveedor3.addProducto(producto2);

            producto1.setProveedor(proveedor1);
            producto2.setProveedor(proveedor3);
            producto3.setProveedor(proveedor2);

            producto1.addAlmacen(almacen1);
            producto2.addAlmacen(almacen2);
            producto3.addAlmacen(almacen2);

            almacen1.addProducto(producto1);
            almacen2.addProducto(producto2);
            almacen2.addProducto(producto3);

            eManager.getTransaction().begin();
            almacenDAO.save(almacen1);
            almacenDAO.save(almacen2);
            eManager.getTransaction().commit();

            eManager.getTransaction().begin();
            proveedorDAO.save(proveedor1);
            proveedorDAO.save(proveedor2);
            proveedorDAO.save(proveedor3);
            eManager.getTransaction().commit();

            eManager.getTransaction().begin();
            productoDAO.save(producto1);
            productoDAO.save(producto2);
            productoDAO.save(producto3);
            eManager.getTransaction().commit();
        }
    }
}