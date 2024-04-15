module org.marcosbrindis.polymorphismstudentlist {
    requires javafx.controls;
    requires javafx.fxml;

    opens  org.marcosbrindis.polymorphismstudentlist.models;
    opens org.marcosbrindis.polymorphismstudentlist to javafx.fxml;
    exports org.marcosbrindis.polymorphismstudentlist;
    exports org.marcosbrindis.polymorphismstudentlist.controller;
    opens org.marcosbrindis.polymorphismstudentlist.controller to javafx.fxml;
}