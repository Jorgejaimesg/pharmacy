package com.pharmacy.customer.infraestructure.customerui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.pharmacy.customer.aplication.FindCustomerUseCase;
import com.pharmacy.customer.domain.entity.Customer;
import com.pharmacy.customer.domain.service.CustomerService;
import com.pharmacy.customer.infraestructure.CustomerRepository;

public class FindUI extends JFrame implements ActionListener {

    private JLabel logoImg, title, labelID, labelTypeID, TypeID, labelName, Name, labelLastName, LastName, labelAge,
            Age, labelBirthDate, BirthDate, labelRegistration, Registration, labelCity, City, labelNeighborhood, Neighborhood;
    private JButton FindButton, backButton, newButton;
    private JTextField ID;

    public FindUI() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Find Customers");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/CustomerImg.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(20, 20, 70, 70);
        add(logoImg);

        title = new JLabel("Find Customers");
        title.setBounds(140, 20, 400, 70);
        title.setFont(new Font("Andale Mono", Font.BOLD, 40));
        title.setForeground(new Color(0, 0, 100));
        add(title);

        labelID = new JLabel("Customer ID : ");
        labelID.setBounds(35, 130, 150, 30);
        labelID.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelID.setForeground(new Color(0, 0, 100));
        add(labelID);

        ID = new JTextField();
        ID.setBounds(170, 130, 255, 30);
        ID.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        ID.setForeground(new Color(0, 0, 100));
        add(ID);

        labelTypeID = new JLabel("Type ID : ");
        labelTypeID.setBounds(35, 170, 100, 30);
        labelTypeID.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelTypeID.setForeground(new Color(0, 0, 100));
        add(labelTypeID);

        TypeID = new JLabel();
        TypeID.setBounds(135, 170, 290, 30);
        TypeID.setFont(new Font("Andale Mono", Font.ITALIC, 20));
        TypeID.setForeground(new Color(0, 0, 100));
        add(TypeID);

        labelName = new JLabel("Name : ");
        labelName.setBounds(35, 210, 100, 30);
        labelName.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelName.setForeground(new Color(0, 0, 100));
        add(labelName);

        Name = new JLabel();
        Name.setBounds(125, 210, 300, 30);
        Name.setFont(new Font("Andale Mono", Font.ITALIC, 20));
        Name.setForeground(new Color(0, 0, 100));
        add(Name);

        labelLastName = new JLabel("Last name : ");
        labelLastName.setBounds(35, 250, 200, 30);
        labelLastName.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelLastName.setForeground(new Color(0, 0, 100));
        add(labelLastName);

        LastName = new JLabel();
        LastName.setBounds(155, 250, 270, 30);
        LastName.setFont(new Font("Andale Mono", Font.ITALIC, 20));
        LastName.setForeground(new Color(0, 0, 100));
        add(LastName);

        labelAge = new JLabel("Age : ");
        labelAge.setBounds(35, 290, 100, 30);
        labelAge.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelAge.setForeground(new Color(0, 0, 100));
        add(labelAge);

        Age = new JLabel();
        Age.setBounds(125, 290, 300, 30);
        Age.setFont(new Font("Andale Mono", Font.ITALIC, 20));
        Age.setForeground(new Color(0, 0, 100));
        add(Age);

        labelBirthDate = new JLabel("BirthDate : ");
        labelBirthDate.setBounds(35, 330, 150, 30);
        labelBirthDate.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelBirthDate.setForeground(new Color(0, 0, 100));
        add(labelBirthDate);

        BirthDate = new JLabel();
        BirthDate.setBounds(155, 330, 270, 30);
        BirthDate.setFont(new Font("Andale Mono", Font.ITALIC, 20));
        BirthDate.setForeground(new Color(0, 0, 100));
        add(BirthDate);

        labelRegistration = new JLabel("Registration : ");
        labelRegistration.setBounds(35, 370, 150, 30);
        labelRegistration.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelRegistration.setForeground(new Color(0, 0, 100));
        add(labelRegistration);

        Registration = new JLabel();
        Registration.setBounds(170, 370, 270, 30);
        Registration.setFont(new Font("Andale Mono", Font.ITALIC, 20));
        Registration.setForeground(new Color(0, 0, 100));
        add(Registration);

        labelCity = new JLabel("City : ");
        labelCity.setBounds(35, 410, 150, 30);
        labelCity.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelCity.setForeground(new Color(0, 0, 100));
        add(labelCity);

        City = new JLabel();
        City.setBounds(100, 410, 325, 30);
        City.setFont(new Font("Andale Mono", Font.ITALIC, 20));
        City.setForeground(new Color(0, 0, 100));
        add(City);

        labelNeighborhood = new JLabel("Neighborhood : ");
        labelNeighborhood.setBounds(35, 450, 150, 30);
        labelNeighborhood.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelNeighborhood.setForeground(new Color(0, 0, 100));
        add(labelNeighborhood);

        Neighborhood = new JLabel();
        Neighborhood.setBounds(180, 450, 245, 30);
        Neighborhood.setFont(new Font("Andale Mono", Font.ITALIC, 20));
        Neighborhood.setForeground(new Color(0, 0, 100));
        add(Neighborhood);

        FindButton = new JButton("Find");
        FindButton.setBounds(55, 510, 120, 30);
        FindButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        FindButton.setForeground(new Color(0, 0, 100));
        FindButton.addActionListener(this);
        add(FindButton);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==FindButton){
            String customerID = ID.getText().trim();
            CustomerService customerService = new CustomerRepository();
            FindCustomerUseCase findCustomerUseCase = new FindCustomerUseCase(customerService);
            Optional<Customer> customer = findCustomerUseCase.execute(customerID);
            if (customer.isPresent()) {
                Customer foundCustomer = customer.get();

                String TypeIdBox = Integer.toString(foundCustomer.getTypeID());
                TypeID.setText(TypeIdBox);
                Name.setText(foundCustomer.getName());
                LastName.setText(foundCustomer.getLastName());
                Age.setText(Integer.toString(foundCustomer.getAge()));
                BirthDate.setText(foundCustomer.getBirthDate());
                Registration.setText(foundCustomer.getRegistrationDate());

                String citybox = Integer.toString(foundCustomer.getCityId());
                City .setText(citybox);

                String neighborhoodBox = Integer.toString(foundCustomer.getNeighborhoodId());
                Neighborhood.setText(neighborhoodBox);

                ID.setEditable(false);


            } else {
                ID.setText("");
                JOptionPane.showMessageDialog(this, "Customer not found", "Error", JOptionPane.ERROR_MESSAGE);
            }            
        }

        if (e.getSource()==newButton){
            ID.setEditable(true);
            ID.setText("");
            TypeID.setText("");
            Name.setText("");
            LastName.setText("");
            Age.setText("");
            BirthDate.setText("");
            Registration.setText("");
            City .setText("");
            Neighborhood.setText("");
        }

        if(e.getSource()==backButton){
            this.setVisible(false);
            CustomerUI uiCustomer = new CustomerUI();
            uiCustomer.startCustomer();
        }
    }

}
