package com.example.proxectoadeduardobn.Controller;

import com.example.proxectoadeduardobn.Model.DAO.AlmacenDAOImpl;
import com.example.proxectoadeduardobn.Model.DAO.ProductoDAOImpl;
import com.example.proxectoadeduardobn.Model.DAO.ProveedorDAOImpl;
import com.example.proxectoadeduardobn.Model.DTO.ProductoDTO;
import com.example.proxectoadeduardobn.Model.Entities.Almacen;
import com.example.proxectoadeduardobn.Model.Entities.Proveedor;
import com.example.proxectoadeduardobn.Model.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class AppController {

    @FXML
    private Button btnQueryAlmacen;

    @FXML
    private Button btnQueryProveedor;

    @FXML
    private Button btnQueryProducto;

    @FXML
    private TextField cifProveedorField;

    @FXML
    private TextField nomeProveedorField;

    @FXML
    private TextField telfProveedorField;

    @FXML
    private TextField calleProveedorField;

    @FXML
    private TextField cidadeProveedorField;

    @FXML
    private TextField provinciaProveedorField;

    @FXML
    private TextField codPosProveedorField;

    @FXML
    private Button btnAnteriorProveedor;

    @FXML
    private Button btnSeguinteProveedor;

    @FXML
    private TextField nombreAlmacenField;

    @FXML
    private TextField capacidadCajasField;

    @FXML
    private TextField refrigeradoField;

    @FXML
    private TextField calleAlmacenField;

    @FXML
    private TextField ciudadAlmacenField;

    @FXML
    private TextField provinciaAlmacenField;

    @FXML
    private TextField codigoPostalAlmacenField;

    @FXML
    private Button btnAnteriorAlmacen;

    @FXML
    private Button btnSeguinteAlmacen;

    @FXML
    private TextField nombreProductoField;

    @FXML
    private TextField marcaProductoField;

    @FXML
    private TextField modeloProductoField;

    @FXML
    private TextField precioProductoField;

    @FXML
    private TextField stockProductoField;

    @FXML
    private TextField proveedorProductoField;

    @FXML
    private ImageView imagenProductoView;

    @FXML
    private Button btnAnteriorProducto;

    @FXML
    private Button btnSeguinteProducto;

    private int currentIndexAlmacen = 0;
    private int currentIndexProveedor = 0;

    private int currentIndexProducto = 0;

    public void initialize() {
        actualizarCamposProveedor();
        actualizarCamposAlmacen();
        actualizarCamposProducto();
    }

    @FXML
    private void siguienteRegistro(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(btnSeguinteProveedor)) {
            currentIndexProveedor++;
            actualizarCamposProveedor();
        } else if (actionEvent.getSource().equals(btnSeguinteAlmacen)) {
            currentIndexAlmacen++;
            actualizarCamposAlmacen();
        } else if (actionEvent.getSource().equals(btnSeguinteProducto)) {
            currentIndexProducto++;
            actualizarCamposProducto();
        }
    }

    @FXML
    private void anteriorRegistro(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(btnAnteriorProveedor)) {
            currentIndexProveedor--;
            actualizarCamposProveedor();
        } else if (actionEvent.getSource().equals(btnAnteriorAlmacen)) {
            currentIndexAlmacen--;
            actualizarCamposAlmacen();
        } else if (actionEvent.getSource().equals(btnAnteriorProducto)){
            currentIndexProducto--;
            actualizarCamposProducto();
        }

    }

    private void actualizarCamposProveedor(){
        try (EntityManager eManager = EntityManagerUtil.createEntityManager()){
            ProveedorDAOImpl proveedorDAO = new ProveedorDAOImpl(eManager);
            if (currentIndexProveedor == proveedorDAO.getAll().size()-1){
                btnSeguinteProveedor.setDisable(true);
                btnAnteriorProveedor.setDisable(false);
            } else if (currentIndexProveedor == 0){
                btnAnteriorProveedor.setDisable(true);
                btnSeguinteProveedor.setDisable(false);
            } else {
                btnSeguinteProveedor.setDisable(false);
                btnAnteriorProveedor.setDisable(false);
            }
            Proveedor proveedor = proveedorDAO.getAll().get(currentIndexProveedor);
            cifProveedorField.setText(proveedor.getCif());
            nomeProveedorField.setText(proveedor.getNombre());
            telfProveedorField.setText(proveedor.getTelefonoContacto());
            calleProveedorField.setText(proveedor.getDireccion().getCalle());
            cidadeProveedorField.setText(proveedor.getDireccion().getCiudad());
            provinciaProveedorField.setText(proveedor.getDireccion().getProvincia());
            codPosProveedorField.setText(proveedor.getDireccion().getCodigoPostal());
        } catch (Exception e) {
            System.out.println("Error de conexión");
            e.printStackTrace();
        }
    }

    private void actualizarCamposAlmacen() {
        try (EntityManager eManager = EntityManagerUtil.createEntityManager()) {
            AlmacenDAOImpl almacenDAO = new AlmacenDAOImpl(eManager);
            if (currentIndexAlmacen == almacenDAO.getAll().size() - 1) {
                btnSeguinteAlmacen.setDisable(true);
                btnAnteriorAlmacen.setDisable(false);
            } else if (currentIndexAlmacen == 0) {
                btnAnteriorAlmacen.setDisable(true);
                btnSeguinteAlmacen.setDisable(false);
            } else {
                btnSeguinteAlmacen.setDisable(false);
                btnAnteriorAlmacen.setDisable(false);
            }
            Almacen almacen = almacenDAO.getAll().get(currentIndexAlmacen);
            nombreAlmacenField.setText(almacen.getNombre());
            capacidadCajasField.setText(String.valueOf(almacen.getCapacidadCajas()));
            refrigeradoField.setText(String.valueOf(almacen.isRefrigerado()));
            calleAlmacenField.setText(almacen.getDireccion().getCalle());
            ciudadAlmacenField.setText(almacen.getDireccion().getCiudad());
            provinciaAlmacenField.setText(almacen.getDireccion().getProvincia());
            codigoPostalAlmacenField.setText(almacen.getDireccion().getCodigoPostal());
        } catch (Exception e) {
            System.out.println("Error de conexión");
            e.printStackTrace();
        }
    }

    private void actualizarCamposProducto() {
        try (EntityManager eManager = EntityManagerUtil.createEntityManager()) {
            ProductoDAOImpl productoDAO = new ProductoDAOImpl(eManager);
            if (currentIndexProducto == productoDAO.getAllAsDTO().size() - 1) {
                btnSeguinteProducto.setDisable(true);
                btnAnteriorProducto.setDisable(false);
            } else if (currentIndexProducto == 0) {
                btnAnteriorProducto.setDisable(true);
                btnSeguinteProducto.setDisable(false);
            } else {
                btnSeguinteProducto.setDisable(false);
                btnAnteriorProducto.setDisable(false);
            }
            ProductoDTO producto = productoDAO.getAllAsDTO().get(currentIndexProducto);
            nombreProductoField.setText(producto.getNombre());
            marcaProductoField.setText(producto.getMarca());
            modeloProductoField.setText(producto.getModelo());
            precioProductoField.setText(String.valueOf(producto.getPrecio()));
            stockProductoField.setText(String.valueOf(producto.getStock()));
            proveedorProductoField.setText(producto.getProveedor().getNombre());

            // Cargar la imagen del producto en el ImageView
            if (producto.getImagen() != null) {
                Image image = new Image(new ByteArrayInputStream(producto.getImagen()));
                imagenProductoView.setImage(image);
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
            e.printStackTrace();
        }
    }

    @FXML
    private void openQueryDialog(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/proxectoadeduardobn/queryDialog.fxml"));
            DialogPane dialogPane = loader.load();

            QueryDialogController controller = loader.getController();
            ButtonType exitButton = new ButtonType("Send Query");
            dialogPane.getButtonTypes().add(exitButton);

            Dialog<Void> dialog = new Dialog<>();
            dialog.setDialogPane(dialogPane);

            dialog.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}