package org.marcosbrindis.polymorphismstudentlist.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.marcosbrindis.polymorphismstudentlist.models.*;
import java.time.LocalDate;
import java.util.Optional;


public class MainController {

    @FXML
    private AnchorPane AnchorPanelAgregar,AnchorPanelModificar,AnchorPanelTop,AnchorPanelView;
    @FXML
    private ImageView btnAdd,btnApagar,btnVer,btnmodif;
    @FXML
    private CheckBox checkBoxFemale,checkBoxFemaleMod,checkBoxMan,checkBoxManMod;
    @FXML
    private DatePicker dataPickerBirtday,datePickerBirdaymod;
    @FXML
    private ListView<Student> listViewStudent;
    @FXML
    private TextField serch,textFieldNameMod,textFieldCurpMod,textFieldEmailMod,textFieldPhoneMod;
    @FXML
    private TextField textFieldName,textFieldCurp,textFieldEmail,textFieldPhone;
    @FXML
    private TableColumn<Student, Integer> tableColumnAge;

    @FXML
    private TableColumn<Student, String> tableColumnCurp;

    @FXML
    private TableColumn<Student, String> tableColumnEmail;

    @FXML
    private TableColumn<Student, String> tableColumnName;

    @FXML
    private TableColumn<Student, Long> tableColumnPhone;

    @FXML
    private TableColumn<Student, String> tableColumnRegister;
    @FXML
    private TableView<Student> tableStudents;
    private School school;
    public void setSchool(School school){
        this.school=school;
        cargarEstudiantes();
        cargarStudentTable();
    }
    public void cargarEstudiantes() {
        if (school != null && school.getDataBase() != null && school.getDataBase().getStudentList1() != null) {
            listViewStudent.getItems().addAll(school.getDataBase().getStudentList1());
        }
    }
    public void cargarStudentTable(){
        if (school != null && school.getDataBase() != null && school.getDataBase().getStudentList1() != null) {
            tableStudents.getItems().addAll(school.getDataBase().getStudentList1());
        }
    }

    @FXML
    void onMouseClickedButtomAgregar(MouseEvent event) {
        String name = textFieldName.getText();
        LocalDate date = dataPickerBirtday.getValue();
        String gender;
        if (checkBoxMan.isSelected()) {
            gender = checkBoxMan.getText();
        } else {
            gender = checkBoxFemale.getText();
        }
        String curp=textFieldCurp.getText();
        String email=textFieldEmail.getText();
        try {
            Long phone = Long.parseLong(textFieldPhone.getText());
            if (name.isEmpty() || date == null || gender.isEmpty() || curp.isEmpty() || email.isEmpty() || phone == 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error.");
                alert.setHeaderText(null);
                alert.setContentText("Please complete all fields.");
                agregarCssAlerta(alert);
                alert.showAndWait();
                return;
            }
            Student student=new Student(name,date,gender,email,curp,phone);
            school.addStudent(student);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Added Successfully.");
            alert.setHeaderText(null);
            alert.setContentText("student added successfully.");
            agregarCssAlerta(alert);
            alert.showAndWait();
            imprimirconsola();
            clearDates();
        }catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid value on phone.");
            agregarCssAlerta(alert);
            alert.showAndWait();
        }

    }

    @FXML
    void onMouseClickedButtomModificar(MouseEvent event) {
        Student studentSeleccionado = listViewStudent.getSelectionModel().getSelectedItem();
        String name = textFieldNameMod.getText();
        LocalDate date = datePickerBirdaymod.getValue();
        String gender;
        if (checkBoxManMod.isSelected()) {
            gender = checkBoxManMod.getText();
        } else {
            gender = checkBoxFemaleMod.getText();
        }
        String curp=textFieldCurpMod.getText();
        String email=textFieldEmailMod.getText();
        try {
            Long phone = Long.parseLong(textFieldPhoneMod.getText());
            if (name.isEmpty() || date == null || gender.isEmpty() || curp.isEmpty() || email.isEmpty() || phone == 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error.");
                alert.setHeaderText(null);
                alert.setContentText("Please complete all fields.");
                agregarCssAlerta(alert);
                alert.showAndWait();
                return;
            }
            Student studentModificado = new Student(studentSeleccionado.getId(),name, date, gender, email, curp, phone);
            school.updateStudent(studentModificado);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Added Successfully.");
            alert.setHeaderText(null);
            alert.setContentText("student successfully modified.");
            agregarCssAlerta(alert);
            alert.showAndWait();
            imprimirconsola();
            clearDates();
        }catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid value on phone.");
            agregarCssAlerta(alert);
            alert.showAndWait();
        }
        listViewStudent.getItems().clear();
        cargarEstudiantes();
    }
    public void clearDatesmod(){
        textFieldNameMod.setText(null);
        datePickerBirdaymod.setValue(null);
        checkBoxManMod.setSelected(false);
        checkBoxFemaleMod.setSelected(false);
        textFieldCurpMod.setText(null);
        textFieldEmailMod.setText(null);
        textFieldPhoneMod.setText(null);
    }
    public void clearDates(){
        textFieldName.setText(null);
        dataPickerBirtday.setValue(null);
        checkBoxMan.setSelected(false);
        checkBoxFemale.setSelected(false);
        textFieldCurp.setText(null);
        textFieldEmail.setText(null);
        textFieldPhone.setText(null);
    }

    public void imprimirconsola(){
        System.out.println("***************************************************************");
        for (Student student:school.getDataBase().getStudentList1()){
            System.out.println(student.imprimir());
        }
        System.out.println("_______________________________________________________");
        for (Student student:school.getDataBase2().getStudentList2()){
            System.out.println(student.imprimir());
        }
        System.out.println("_______________________________________________________");
        for (Student student:school.getDataBase3().getStudentList3()){
            System.out.println(student.imprimir());
        }
        System.out.println("***************************************************************");
    }

    @FXML
    void hanleButtonAction(MouseEvent event) {
        boolean isVisible = false;
        if (event.getTarget() == btnAdd) {
            isVisible = AnchorPanelAgregar.isVisible();
        } else if (event.getTarget() == btnmodif) {
            isVisible = AnchorPanelModificar.isVisible();
            listViewStudent.getItems().clear();
            cargarEstudiantes();
        } else if (event.getTarget() == btnVer) {
            isVisible = AnchorPanelView.isVisible();
            tableStudents.getItems().clear();
            cargarStudentTable();
        }
        if (isVisible) {
            if (event.getTarget() == btnAdd) {
                AnchorPanelAgregar.setVisible(false);
            } else if (event.getTarget() == btnmodif) {
                AnchorPanelModificar.setVisible(false);
            } else if (event.getTarget() == btnVer) {
                AnchorPanelView.setVisible(false);
            }
            return;
        }
        AnchorPanelAgregar.setVisible(false);
        AnchorPanelModificar.setVisible(false);
        AnchorPanelView.setVisible(false);
        if (event.getTarget() == btnAdd) {
            AnchorPanelAgregar.setVisible(true);
        } else if (event.getTarget() == btnmodif) {
            AnchorPanelModificar.setVisible(true);
        } else if (event.getTarget() == btnVer) {
            AnchorPanelView.setVisible(true);
        } else if (event.getTarget() == btnApagar) {
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            agregarCssAlerta(confirmAlert);
            confirmAlert.setTitle("Confirm Off.");
            confirmAlert.setHeaderText(null);
            confirmAlert.setContentText("Are you sure you want to shut down the system?");
            Optional<ButtonType> result = confirmAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                System.exit(1);
            }
        }
    }

    @FXML
    void initialize() {
        checkBoxSelection();
        cargarEstudiantes();
        configureTable();

        serch.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String searchTerm = serch.getText().trim();
                buscarStudent(searchTerm);
            }
        });

        listViewStudent.setOnMouseClicked(event -> {
            Student selectedStudent = listViewStudent.getSelectionModel().getSelectedItem();
            if (selectedStudent != null) {
                textFieldNameMod.setText(selectedStudent.getName());
                textFieldCurpMod.setText(selectedStudent.getCurp());
                textFieldEmailMod.setText(selectedStudent.getEmail());
                textFieldPhoneMod.setText(String.valueOf(selectedStudent.getPhoneNumbre()));
                datePickerBirdaymod.setValue(selectedStudent.getBirthdate());
                if (selectedStudent.getGender().equals("Male")){
                    checkBoxManMod.setSelected(true);
                }else {
                    checkBoxFemaleMod.setSelected(true);
                }
            }
        });
    }

    public  void configureTable(){
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        tableColumnCurp.setCellValueFactory(new PropertyValueFactory<>("curp"));
        tableColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableColumnPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumbre"));
        tableColumnRegister.setCellValueFactory(new PropertyValueFactory<>("id"));
    }
    public void buscarStudent(String id) {
        if (id != null && !id.isEmpty()) {
            ObservableList<Student> studentFiltrados = FXCollections.observableArrayList();
            for (Student student : school.getDataBase().getStudentList1()) {
                if (student.getId().equalsIgnoreCase(id)) {
                    studentFiltrados.add(student);
                }
            }
            listViewStudent.setItems(studentFiltrados);
        } else {
            listViewStudent.setItems(FXCollections.observableArrayList(school.getDataBase().getStudentList1()));
        }
    }

    public void checkBoxSelection(){
        checkBoxFemale.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                checkBoxMan.setSelected(false);
            }
        });
        checkBoxMan.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                checkBoxFemale.setSelected(false);
            }
        });
        checkBoxFemaleMod.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                checkBoxManMod.setSelected(false);
            }
        });
        checkBoxManMod.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                checkBoxFemaleMod.setSelected(false);
            }
        });
    }
    public void agregarCssAlerta(Alert alert){
        try {
            String cssFile = getClass().getResource("/Style.css").toExternalForm();
            alert.getDialogPane().getStylesheets().add(cssFile);
        } catch (NullPointerException e) {
            System.err.println("No se pudo encontrar el archivo CSS.");
            e.printStackTrace();
        }
    }

}