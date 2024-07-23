package com.pharmacy.customer.infraestructure.customerui;
import com.pharmacy.city.aplication.FindAllCityUseCase;
import com.pharmacy.city.aplication.FindCityByNameUseCase;
import com.pharmacy.city.domain.entity.City;
import com.pharmacy.city.domain.service.CityService;
import com.pharmacy.city.infraestructure.CityRepository;
import com.pharmacy.customer.aplication.CreateCustomerUseCase;
import com.pharmacy.customer.domain.entity.Customer;
import com.pharmacy.customer.domain.service.CustomerService;
import com.pharmacy.customer.infraestructure.CustomerRepository;
import com.pharmacy.neighborhood.aplication.FindNeighborhoodByCityUseCase;
import com.pharmacy.neighborhood.aplication.FindNeighborhoodByNameUseCase;
import com.pharmacy.neighborhood.domain.entity.Neighborhood;
import com.pharmacy.neighborhood.domain.service.NeighborhoodService;
import com.pharmacy.neighborhood.infraestructure.NeighborhoodRepository;
import com.pharmacy.typeid.aplication.FindAllTypeIDUseCase;
import com.pharmacy.typeid.aplication.FindTypeByNameUseCase;
import com.pharmacy.typeid.domain.entity.TypeID;
import com.pharmacy.typeid.domain.service.TypeIDService;
import com.pharmacy.typeid.infraestructure.TypeIDRepository;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class AddUI extends JFrame implements ActionListener {
    TypeIDService typeIDService = new TypeIDRepository();
    FindAllTypeIDUseCase findAllTypeIDUseCase = new FindAllTypeIDUseCase(typeIDService);
    FindTypeByNameUseCase findTypeByNameUseCase = new FindTypeByNameUseCase(typeIDService);
    List<TypeID> types = findAllTypeIDUseCase.findAllTypeID();

    CityService cityService = new CityRepository();
    FindCityByNameUseCase findCityByNameUseCase = new FindCityByNameUseCase(cityService);
    FindAllCityUseCase findAllCityUseCase = new FindAllCityUseCase(cityService);
    List<City> cities = findAllCityUseCase.findAllCity();

    NeighborhoodService neighborhoodService = new NeighborhoodRepository();
    FindNeighborhoodByCityUseCase findNeighborhoodByCityUseCase = new FindNeighborhoodByCityUseCase(neighborhoodService);
    FindNeighborhoodByNameUseCase findNeighborhoodByNameUseCase = new FindNeighborhoodByNameUseCase(neighborhoodService);

    private JLabel logoImg,title,labelID, labelTypeID, labelName,labelLastName,labelAge,labelBirthDate,labelCity,labelNeighborhood;
    private JTextField txtID, txtName,txtLastName,txtAge;
    private JDateChooser birthDate;
    private JComboBox<String> comboTypeID, comboCity,comboNeighborhood;
    private JButton addButton, backButton, newButton;
    private int cityID;

    public AddUI() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Add Customers");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/CustomerImg.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(20, 20, 70, 70);
        add(logoImg);

        title = new JLabel("Add Customers");
        title.setBounds(140, 20, 400, 70);
        title.setFont(new Font("Andale Mono", Font.BOLD, 40));
        title.setForeground(new Color(0, 0, 100));
        add(title);
        
        labelID = new JLabel("Customer ID : " );
        labelID.setBounds(35, 130, 150, 30);
        labelID.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelID.setForeground(new Color(0, 0, 100));
        add(labelID);

        txtID = new JTextField();
        txtID.setBounds(170, 130, 255, 30);
        txtID.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        txtID.setForeground(new Color(0, 0, 100));
        add(txtID);

        labelTypeID = new JLabel("Type ID : " );
        labelTypeID.setBounds(35, 170, 100, 30);
        labelTypeID.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelTypeID.setForeground(new Color(0, 0, 100));
        add(labelTypeID);

        comboTypeID = new JComboBox<String>();
        comboTypeID.setBounds(135, 170, 290, 30);
        comboTypeID.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        comboTypeID.setForeground(new Color(0, 0, 100));
        add(comboTypeID);
        comboTypeID.addItem("");
        for(TypeID type : types){
            comboTypeID.addItem(type.getType());
        };


        labelName = new JLabel("Name : " );
        labelName.setBounds(35, 210, 100, 30);
        labelName.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelName.setForeground(new Color(0, 0, 100));
        add(labelName);

        txtName = new JTextField();
        txtName.setBounds(125, 210, 300, 30);
        txtName.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        txtName.setForeground(new Color(0, 0, 100));
        add(txtName);

        labelLastName = new JLabel("Last name : " );
        labelLastName.setBounds(35, 250, 200, 30);
        labelLastName.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelLastName.setForeground(new Color(0, 0, 100));
        add(labelLastName);

        txtLastName = new JTextField();
        txtLastName.setBounds(155, 250, 270, 30);
        txtLastName.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        txtLastName.setForeground(new Color(0, 0, 100));
        add(txtLastName);

        labelAge = new JLabel("Age : " );
        labelAge.setBounds(35, 290, 100, 30);
        labelAge.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelAge.setForeground(new Color(0, 0, 100));
        add(labelAge);
        
        txtAge = new JTextField();
        txtAge.setBounds(125, 290, 300, 30);
        txtAge.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        txtAge.setForeground(new Color(0, 0, 100));
        add(txtAge);

        labelBirthDate = new JLabel("BirthDate : " );
        labelBirthDate.setBounds(35, 330, 150, 30);
        labelBirthDate.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelBirthDate.setForeground(new Color(0, 0, 100));
        add(labelBirthDate);
    
        birthDate = new JDateChooser ();
        birthDate.setBounds(155, 330, 270, 30);
        birthDate.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        birthDate.setForeground(new Color(0, 0, 100));
        add(birthDate);

        labelCity = new JLabel("City : " );
        labelCity.setBounds(35, 370, 150, 30);
        labelCity.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelCity.setForeground(new Color(0, 0, 100));
        add(labelCity);

        comboCity = new JComboBox<String>();
        comboCity.setBounds(100, 370, 325, 30);
        comboCity.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        comboCity.setForeground(new Color(0, 0, 100));
        add(comboCity);
        comboCity.addItem("");
        for(City city : cities){
            comboCity.addItem(city.getName());
        };

        
        labelNeighborhood = new JLabel("Neighborhood : " );
        labelNeighborhood.setBounds(35, 410, 150, 30);
        labelNeighborhood.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelNeighborhood.setForeground(new Color(0, 0, 100));
        add(labelNeighborhood);

        comboNeighborhood = new JComboBox<String>();
        comboNeighborhood.setBounds(180, 410, 245, 30);
        comboNeighborhood.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        comboNeighborhood.setForeground(new Color(0, 0, 100));
        add(comboNeighborhood);
        comboCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarNeighborhood();
            }
        });

        addButton = new JButton("Add");
        addButton.setBounds(55, 490, 120, 30);
        addButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        addButton.setForeground(new Color(0, 0, 100));
        addButton.addActionListener(this);
        add(addButton);

        backButton = new JButton("Go Back");
        backButton.setBounds(305, 490, 120, 30);
        backButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        backButton.setForeground(new Color(0, 0, 100));
        backButton.addActionListener(this);
        add(backButton);

        newButton = new JButton("New");
        newButton.setBounds(180, 490, 120, 30);
        newButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        newButton.setForeground(new Color(0, 0, 100));
        newButton.addActionListener(this);
        add(newButton);

    }
    public void startAddCustomer() {
        AddUI addui = new AddUI();
        addui.setBounds(0, 0, 500, 580);
        addui.setVisible(true);
        addui.setResizable(false);
        addui.setLocationRelativeTo(null);
    }

        private void actualizarNeighborhood() {
            comboNeighborhood.removeAllItems(); 
        String cityName = comboCity.getSelectedItem().toString();
        Optional<City> cityFound = findCityByNameUseCase.findCityByName(cityName);
        this.cityID =cityFound.get().getId();
        List<Neighborhood> neighborhoods = findNeighborhoodByCityUseCase.findAllNeighborhoodByCity(cityID);
        for(Neighborhood neighborhooditem : neighborhoods){
            comboNeighborhood.addItem(neighborhooditem.getName());
        };
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            try {
                Customer newCustomer = new Customer();

                newCustomer.setId(txtID.getText());

                String TypeTxt = comboTypeID.getSelectedItem().toString();
                Optional<TypeID> foundType = findTypeByNameUseCase.findTypeByName(TypeTxt);
                newCustomer.setTypeID(foundType.get().getID());

                newCustomer.setName(txtName.getText());
                newCustomer.setLastName(txtLastName.getText());
                newCustomer.setAge(Integer.parseInt(txtAge.getText()));
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                newCustomer.setBirthDate(dateFormat.format(birthDate.getDate()));
                newCustomer.setRegistrationDate(dateFormat.format(new Date()));
                newCustomer.setCityId(cityID);

                String neighborhoodTxt = comboNeighborhood.getSelectedItem().toString();
                Optional<Neighborhood> foundNeighborhood = findNeighborhoodByNameUseCase.execute(cityID, neighborhoodTxt);
                newCustomer.setNeighborhoodId(foundNeighborhood.get().getId());

                System.out.println(newCustomer);

                CustomerService customerService = new CustomerRepository();
                CreateCustomerUseCase createCustomerUseCase = new CreateCustomerUseCase(customerService);
                createCustomerUseCase.execute(newCustomer);
                JOptionPane.showMessageDialog(this, "Customer added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                //Limpiar las casillas
                txtID.setText("");
                comboTypeID.setSelectedItem("");
                txtName.setText("");
                txtLastName.setText("");
                txtAge.setText("");
                birthDate.setDate(null);
                comboCity.setSelectedItem("");
                comboNeighborhood.setSelectedItem("");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if(e.getSource()==backButton){
            this.setVisible(false);
            CustomerUI uiCustomer = new CustomerUI();
            uiCustomer.startCustomer();
        }

        if (e.getSource()==newButton){
            txtID.setText("");
                comboTypeID.setSelectedItem("");
                txtName.setText("");
                txtLastName.setText("");
                txtAge.setText("");
                birthDate.setDate(null);
                comboCity.setSelectedItem("");
                comboNeighborhood.setSelectedItem("");
        }
    }

}