package com.pharmacy.customer.infraestructure.customerui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.pharmacy.customer.aplication.DeleteCustomerUseCase;
import com.pharmacy.customer.aplication.FindCustomerUseCase;
import com.pharmacy.customer.domain.entity.Customer;
import com.pharmacy.customer.domain.service.CustomerService;
import com.pharmacy.customer.infraestructure.CustomerRepository;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public class DeleteUI extends JFrame implements ActionListener {
    
    private JLabel logoImg, title, labelID;
    private JButton deleteButton, backButton, newButton;
    private JTextField ID;

    public DeleteUI(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Delete Customers");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/CustomerImg.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(20, 20, 70, 70);
        add(logoImg);

        title = new JLabel("Delete Customers");
        title.setBounds(140, 20, 400, 70);
        title.setFont(new Font("Andale Mono", Font.BOLD, 35));
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

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(55, 200, 120, 30);
        deleteButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        deleteButton.setForeground(new Color(0, 0, 100));
        deleteButton.addActionListener(this);
        add(deleteButton);

        newButton = new JButton("New");
        newButton.setBounds(180, 200, 120, 30);
        newButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        newButton.setForeground(new Color(0, 0, 100));
        newButton.addActionListener(this);
        add(newButton);


        backButton = new JButton("Go Back");
        backButton.setBounds(305, 200, 120, 30);
        backButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        backButton.setForeground(new Color(0, 0, 100));
        backButton.addActionListener(this);
        add(backButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteButton) {
            String customerID = ID.getText().trim();
            CustomerService customerService = new CustomerRepository();
            FindCustomerUseCase findCustomerUseCase = new FindCustomerUseCase(customerService);
            DeleteCustomerUseCase deleteCustomerUseCase = new DeleteCustomerUseCase(customerService);
            Optional<Customer> customer = findCustomerUseCase.execute(customerID);
            if (customer.isPresent()) {
                Customer foundCustomer = customer.get();

                int response = JOptionPane.showConfirmDialog(
                    this, 
                    "DO YOU WANT TO DELETE THIS COSTUMER?:"+
                    "\n"+
                    "\nID: " + foundCustomer.getId() + 
                    "\nName: " + foundCustomer.getName() + 
                    "\nLast Name: " + foundCustomer.getLastName() + 
                    "\nAge: " + foundCustomer.getAge() + 
                    "\nBirth Date: " + foundCustomer.getBirthDate() + 
                    "\nRegistration Date: " + foundCustomer.getRegistrationDate() + 
                    "\nCity ID: " + foundCustomer.getCityId() + 
                    "\nNeighborhood ID: " + foundCustomer.getNeighborhoodId(), customerID, JOptionPane.YES_NO_OPTION
                );

                if (response == JOptionPane.YES_OPTION) {

                    try {
                        deleteCustomerUseCase.execute(customerID);
                        JOptionPane.showMessageDialog(this, "Customer deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Failed to delete customer. Please check the ID and try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
        
                } else {
                    JOptionPane.showMessageDialog(this, "Deletion cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                }
            ID.setText("");


            } else {
                ID.setText("");
                JOptionPane.showMessageDialog(this, "Customer not found", "Error", JOptionPane.ERROR_MESSAGE);
            } 
        }
        if(e.getSource()==newButton){
            ID.setText("");
        }
        if(e.getSource()==backButton){
            this.setVisible(false);
            CustomerUI uiCustomer = new CustomerUI();
            uiCustomer.startCustomer();
        }
    }
}
