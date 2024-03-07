module com.example.proxectoadeduardobn {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    opens com.example.proxectoadeduardobn.Model.Entities;
    opens com.example.proxectoadeduardobn to javafx.fxml;
    exports com.example.proxectoadeduardobn;
    exports com.example.proxectoadeduardobn.Controller;
    opens com.example.proxectoadeduardobn.Controller to javafx.fxml;
}