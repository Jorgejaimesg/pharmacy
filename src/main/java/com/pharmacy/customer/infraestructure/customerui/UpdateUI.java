package com.pharmacy.customer.infraestructure.customerui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Optional;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.pharmacy.city.aplication.FindAllCityUseCase;
import com.pharmacy.city.aplication.FindCityByIdUseCase;
import com.pharmacy.city.aplication.FindCityByNameUseCase;
import com.pharmacy.city.domain.entity.City;
import com.pharmacy.city.domain.service.CityService;
import com.pharmacy.city.infraestructure.CityRepository;
import com.pharmacy.customer.aplication.FindCustomerUseCase;
import com.pharmacy.customer.aplication.UpdateCustomerUseCase;
import com.pharmacy.customer.domain.entity.Customer;
import com.pharmacy.customer.domain.service.CustomerService;
import com.pharmacy.customer.infraestructure.CustomerRepository;
import com.pharmacy.neighborhood.domain.entity.Neighborhood;
import com.pharmacy.neighborhood.aplication.FindNeighborhoodByCityUseCase;
import com.pharmacy.neighborhood.aplication.FindNeighborhoodByIDUseCase;
import com.pharmacy.neighborhood.aplication.FindNeighborhoodByNameUseCase;
import com.pharmacy.neighborhood.domain.service.NeighborhoodService;
import com.pharmacy.neighborhood.infraestructure.NeighborhoodRepository;
import com.pharmacy.typeid.aplication.FindAllTypeIDUseCase;
import com.pharmacy.typeid.aplication.FindTypeByIDUseCase;
import com.pharmacy.typeid.aplication.FindTypeByNameUseCase;
import com.pharmacy.typeid.domain.entity.TypeID;
import com.pharmacy.typeid.domain.service.TypeIDService;
import com.pharmacy.typeid.infraestructure.TypeIDRepository;
import com.toedter.calendar.JDateChooser;

public class UpdateUI extends JFrame implements ActionListener {

    TypeIDService typeIDService = new TypeIDRepository();
    FindAllTypeIDUseCase findAllTypeIDUseCase = new FindAllTypeIDUseCase(typeIDService);
    FindTypeByNameUseCase findTypeByNameUseCase = new FindTypeByNameUseCase(typeIDService);
    FindTypeByIDUseCase findTypeByIDUseCase = new FindTypeByIDUseCase(typeIDService);
    List<TypeID> types = findAllTypeIDUseCase.findAllTypeID();

    CityService cityService = new CityRepository();
    FindCityByNameUseCase findCityByNameUseCase = new FindCityByNameUseCase(cityService);
    FindAllCityUseCase findAllCityUseCase = new FindAllCityUseCase(cityService);
    FindCityByIdUseCase findCityByIdUseCase = new FindCityByIdUseCase(cityService);
    List<City> cities = findAllCityUseCase.findAllCity();
    private int cityID;

    NeighborhoodService neighborhoodService = new NeighborhoodRepository();
    FindNeighborhoodByCityUseCase findNeighborhoodByCityUseCase = new FindNeighborhoodByCityUseCase(
            neighborhoodService);
            FindNeighborhoodByIDUseCase findNeighborhoodByIDUseCase = new FindNeighborhoodByIDUseCase(neighborhoodService);
    FindNeighborhoodByNameUseCase findNeighborhoodByNameUseCase = new FindNeighborhoodByNameUseCase(
            neighborhoodService);

    private JLabel logoImg, title, labelID, labelTypeID, labelName, labelLastName, labelAge, labelBirthDate,
            labelRegistration, labelCity, labelNeighborhood;
    private JTextField ID, Name, LastName, Age, Registration;
    private JButton backButton, updateButton, findButton, newButton;
    private JDateChooser birthDate;
    private JComboBox<String> TypeID, City, ComboNeighborhood;

    public UpdateUI() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Update Customers");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/CustomerImg.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(20, 20, 70, 70);
        add(logoImg);

        title = new JLabel("Update Customers");
        title.setBounds(110, 20, 400, 70);
        title.setFont(new Font("Andale Mono", Font.BOLD, 40));
        title.setForeground(new Color(0, 0, 100));
        add(title);

        labelID = new JLabel("Customer ID : ");
        labelID.setBounds(35, 130, 150, 30);
        labelID.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelID.setForeground(new Color(0, 0, 100));
        add(labelID);

        ID = new JTextField();
        ID.setBounds(170, 130, 190, 30);
        ID.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        ID.setForeground(new Color(0, 0, 100));
        add(ID);

        findButton = new JButton("🔍");
        findButton.setBounds(365, 130, 60, 30);
        findButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        findButton.setForeground(new Color(0, 0, 100));
        findButton.addActionListener(this);
        add(findButton);

        labelTypeID = new JLabel("Type ID : ");
        labelTypeID.setBounds(35, 170, 100, 30);
        labelTypeID.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelTypeID.setForeground(new Color(0, 0, 100));
        add(labelTypeID);

        TypeID = new JComboBox<String>();
        TypeID.setBounds(135, 170, 290, 30);
        TypeID.setFont(new Font("Andale Mono", Font.ITALIC, 20));
        TypeID.setForeground(new Color(0, 0, 100));
        TypeID.setVisible(false);
        add(TypeID);
        TypeID.addItem("");
        for (TypeID type : types) {
            TypeID.addItem(type.getType());
        }
        ;

        labelName = new JLabel("Name : ");
        labelName.setBounds(35, 210, 100, 30);
        labelName.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelName.setForeground(new Color(0, 0, 100));
        add(labelName);

        Name = new JTextField();
        Name.setBounds(125, 210, 300, 30);
        Name.setFont(new Font("Andale Mono", Font.ITALIC, 20));
        Name.setForeground(new Color(0, 0, 100));
        Name.setVisible(false);
        add(Name);

        labelLastName = new JLabel("Last name : ");
        labelLastName.setBounds(35, 250, 200, 30);
        labelLastName.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelLastName.setForeground(new Color(0, 0, 100));
        add(labelLastName);

        LastName = new JTextField();
        LastName.setBounds(155, 250, 270, 30);
        LastName.setFont(new Font("Andale Mono", Font.ITALIC, 20));
        LastName.setForeground(new Color(0, 0, 100));
        LastName.setVisible(false);
        add(LastName);

        labelAge = new JLabel("Age : ");
        labelAge.setBounds(35, 290, 100, 30);
        labelAge.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelAge.setForeground(new Color(0, 0, 100));
        add(labelAge);

        Age = new JTextField();
        Age.setBounds(125, 290, 300, 30);
        Age.setFont(new Font("Andale Mono", Font.ITALIC, 20));
        Age.setForeground(new Color(0, 0, 100));
        Age.setVisible(false);
        Age.setEditable(false);
        add(Age);

        labelBirthDate = new JLabel("BirthDate : ");
        labelBirthDate.setBounds(35, 330, 150, 30);
        labelBirthDate.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelBirthDate.setForeground(new Color(0, 0, 100));
        add(labelBirthDate);

        birthDate = new JDateChooser();
        birthDate.setBounds(155, 330, 270, 30);
        birthDate.setFont(new Font("Andale Mono", Font.ITALIC, 20));
        birthDate.setForeground(new Color(0, 0, 100));
        birthDate.setVisible(false);
        add(birthDate);
        birthDate.addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                updateAge();
            }
        });

        labelRegistration = new JLabel("Registration : ");
        labelRegistration.setBounds(35, 370, 150, 30);
        labelRegistration.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelRegistration.setForeground(new Color(0, 0, 100));
        add(labelRegistration);

        Registration = new JTextField();
        Registration.setBounds(170, 370, 255, 30);
        Registration.setFont(new Font("Andale Mono", Font.ITALIC, 20));
        Registration.setForeground(new Color(0, 0, 100));
        Registration.setVisible(false);
        add(Registration);

        labelCity = new JLabel("City : ");
        labelCity.setBounds(35, 410, 150, 30);
        labelCity.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelCity.setForeground(new Color(0, 0, 100));
        add(labelCity);

        City = new JComboBox<String>();
        City.setBounds(100, 410, 325, 30);
        City.setFont(new Font("Andale Mono", Font.ITALIC, 20));
        City.setForeground(new Color(0, 0, 100));
        City.setVisible(false);
        add(City);
        City.addItem("");
        for (City city : cities) {
            City.addItem(city.getName());
        }
        ;

        labelNeighborhood = new JLabel("Neighborhood : ");
        labelNeighborhood.setBounds(35, 450, 150, 30);
        labelNeighborhood.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelNeighborhood.setForeground(new Color(0, 0, 100));
        add(labelNeighborhood);

        ComboNeighborhood = new JComboBox<String>();
        ComboNeighborhood.setBounds(180, 450, 245, 30);
        ComboNeighborhood.setFont(new Font("Andale Mono", Font.ITALIC, 20));
        ComboNeighborhood.setForeground(new Color(0, 0, 100));
        ComboNeighborhood.setVisible(false);
        add(ComboNeighborhood);
        City.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarNeighborhood();
            }
        });

        updateButton = new JButton("Update");
        updateButton.setBounds(55, 510, 120, 30);
        updateButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        updateButton.setForeground(new Color(0, 0, 100));
        updateButton.addActionListener(this);
        add(updateButton);

        newButton = new JButton("New");
        newButton.setBounds(180, 510, 120, 30);
        newButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        newButton.setForeground(new Color(0, 0, 100));
        newButton.addActionListener(this);
        add(newButton);

        backButton = new JButton("Go Back");
        backButton.setBounds(305, 510, 120, 30);
        backButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        backButton.setForeground(new Color(0, 0, 100));
        backButton.addActionListener(this);
        add(backButton);
    }

    private void actualizarNeighborhood() {
        ComboNeighborhood.removeAllItems();
        String cityName = City.getSelectedItem().toString();
        Optional<City> cityFound = findCityByNameUseCase.findCityByName(cityName);
        this.cityID = cityFound.get().getId();
        List<Neighborhood> neighborhoods = findNeighborhoodByCityUseCase.findAllNeighborhoodByCity(cityID);
        
        for (Neighborhood neighborhooditem : neighborhoods) {
            ComboNeighborhood.addItem(neighborhooditem.getName());
        }
    }

    public void startUpdateCustomer() {
        UpdateUI UpdateUI = new UpdateUI();
        UpdateUI.setBounds(0, 0, 500, 600);
        UpdateUI.setVisible(true);
        UpdateUI.setResizable(false);
        UpdateUI.setLocationRelativeTo(null);

    }

    private void updateAge() {
        Date birthDatedaDate = birthDate.getDate();
        if (birthDate != null) {
            LocalDate birthLocalDate = birthDatedaDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate currentDate = LocalDate.now();
            int age = Period.between(birthLocalDate, currentDate).getYears();
            Age.setText(String.valueOf(age));
        } else {
            Age.setText("");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CustomerService customerService = new CustomerRepository();
        FindCustomerUseCase findCustomerUseCase = new FindCustomerUseCase(customerService);
        UpdateCustomerUseCase updateCustomerUseCase = new UpdateCustomerUseCase(customerService);

        if (e.getSource() == findButton) {
            String customerID = ID.getText().trim();
            Optional<Customer> customer = findCustomerUseCase.execute(customerID);

            // Primero busco el cliente
            if (customer.isPresent()) {
                Customer foundCustomer = customer.get();
                // obtener todos los datos
                // creo el formato para que me lea la fecha que esta como string y me la pase a
                // un tipo Date
                SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
                Date birthDateformat;
                try {
                    int TypeIdBox = foundCustomer.getTypeID();
                    Optional<TypeID> foundType = findTypeByIDUseCase.findTypeById(TypeIdBox);
                    TypeID.setSelectedItem(foundType.get().getType());

                    Name.setText(foundCustomer.getName());
                    LastName.setText(foundCustomer.getLastName());
                    Age.setText(Integer.toString(foundCustomer.getAge()));
                    birthDateformat = simpledateformat.parse(foundCustomer.getBirthDate());
                    birthDate.setDate(birthDateformat);
                    Registration.setText(foundCustomer.getRegistrationDate());

                    int citybox = foundCustomer.getCityId();
                    Optional<City> foundCity = findCityByIdUseCase.findCityByID(citybox);
                    City.setSelectedItem(foundCity.get().getName());

                    int neighborhoodBox = foundCustomer.getNeighborhoodId();
                    Optional<Neighborhood> foundNeighborhood = findNeighborhoodByIDUseCase.findNeighborhoodByID(neighborhoodBox);
                    ComboNeighborhood.setSelectedItem(foundNeighborhood.get().getName());
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                Registration.setEditable(false);
                changeVisibility(true);

            } else {
                ID.setText("");
                JOptionPane.showMessageDialog(this, "Customer not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == updateButton) {
            // con esto lo modifico
            try {
                Customer newCustomer = new Customer();

                newCustomer.setId(ID.getText());

                String TypeTxt = TypeID.getSelectedItem().toString();
                Optional<TypeID> foundType = findTypeByNameUseCase.findTypeByName(TypeTxt);
                newCustomer.setTypeID(foundType.get().getID());

                newCustomer.setName(Name.getText());
                newCustomer.setLastName(LastName.getText());
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                newCustomer.setBirthDate(dateFormat.format(birthDate.getDate()));
                newCustomer.setRegistrationDate(dateFormat.format(new Date()));
                newCustomer.setCityId(cityID);

                String neighborhoodTxt = ComboNeighborhood.getSelectedItem().toString();
                Optional<Neighborhood> foundNeighborhood = findNeighborhoodByNameUseCase.execute(cityID,
                        neighborhoodTxt);
                newCustomer.setNeighborhoodId(foundNeighborhood.get().getId());
                
                System.out.println(newCustomer);
                updateCustomerUseCase.execute(newCustomer);
                // Limpiar las casillas
                ID.setEditable(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "Customer updated successfully.", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            ID.setText("");
            changeVisibility(false);
        }

        if (e.getSource() == newButton) {
            ID.setText("");
            changeVisibility(false);
        }

        if (e.getSource() == backButton) {
            this.setVisible(false);
            CustomerUI uiCustomer = new CustomerUI();
            uiCustomer.startCustomer();
        }
    }

    public void changeVisibility(boolean visibility) {
        ID.setEditable(!visibility);
        TypeID.setVisible(visibility);
        Name.setVisible(visibility);
        LastName.setVisible(visibility);
        Age.setVisible(visibility);
        birthDate.setVisible(visibility);
        Registration.setVisible(visibility);
        City.setVisible(visibility);
        ComboNeighborhood.setVisible(visibility);
    }

}