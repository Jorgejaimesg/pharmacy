package com.pharmacy.customer.infraestructure.customerui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.pharmacy.customer.aplication.FindAllCustomersUseCase;
import com.pharmacy.customer.domain.entity.Customer;
import com.pharmacy.customer.domain.service.CustomerService;
import com.pharmacy.customer.infraestructure.CustomerRepository;
import com.pharmacy.main.infraestructure.MainUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CustomerUI extends JFrame implements ActionListener {
    private JLabel title, logoImg;
    private JButton findButton, addButton, updateButton, deleteButton, allCustomerButton, backButton;

    public CustomerUI() { 
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Customers");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/CustomerImg.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(10, 40, 500, 500);
        add(logoImg);

        title = new JLabel("Customers");
        title.setBounds(500, 10, 500, 300);
        title.setFont(new Font("Andale Mono", Font.BOLD, 75));
        title.setForeground(new Color(0, 0, 100));
        add(title);

        backButton = new JButton("🔙");
        backButton.setBounds(0, 0, 60, 30);
        backButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        backButton.setForeground(new Color(0, 0, 100));
        backButton.addActionListener(this);
        add(backButton);

        findButton = new JButton("Find");
        findButton.setBounds(520, 225, 150, 60);
        findButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        findButton.setForeground(new Color(0, 0, 100));
        findButton.addActionListener(this);
        add(findButton);
        
        addButton = new JButton("Add");
        addButton.setBounds(700, 225, 150, 60);
        addButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        addButton.setForeground(new Color(0, 0, 100));
        addButton.addActionListener(this);
        add(addButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(520, 305, 150, 60);
        updateButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        updateButton.setForeground(new Color(0, 0, 100));
        updateButton.addActionListener(this);
        add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(700, 305, 150, 60);
        deleteButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        deleteButton.setForeground(new Color(0, 0, 100));
        deleteButton.addActionListener(this);
        add(deleteButton);

        allCustomerButton = new JButton("All customers");
        allCustomerButton.setBounds(520, 385, 330, 60);
        allCustomerButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        allCustomerButton.setForeground(new Color(0, 0, 100));
        allCustomerButton.addActionListener(this);
        add(allCustomerButton);
    }
    public void startCustomer() {
        CustomerUI customerUI = new CustomerUI();
        customerUI.setBounds(0, 0, 1000, 600);
        customerUI.setVisible(true);
        customerUI.setResizable(false);
        customerUI.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == findButton){
            this.setVisible(false);
            FindUI findUI = new FindUI();
            findUI.startFindCustomer();
        } 
        
        if(e.getSource() == addButton){
            this.setVisible(false);
            AddUI addUI = new AddUI();
            addUI.startAddCustomer();
        }
        
        if(e.getSource()== deleteButton){
            
            this.setVisible(false);
            DeleteUI deleteUI = new DeleteUI();
            deleteUI.startDeleteCustomer();
        }
        
        if (e.getSource() == updateButton){
            
            this.setVisible(false);
            UpdateUI updateUI = new UpdateUI();
            updateUI.startUpdateCustomer();
        }
        

        if(e.getSource()==allCustomerButton){
    
        CustomerService customerService = new CustomerRepository();
        FindAllCustomersUseCase findAllCustomersUseCase = new FindAllCustomersUseCase(customerService);
        List<Customer> customers = findAllCustomersUseCase.findAllCustomer();
        
        String[] columns = {"ID", "Name", "LastName","City"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(columns, 0);

        customers.forEach(customer -> {
            Object[] row = {customer.getId(), customer.getName(), customer.getLastName(), customer.getCityId()};
            defaultTableModel.addRow(row);
        });

        JTable table = new JTable(defaultTableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JOptionPane.showMessageDialog(null, scrollPane, "Customer List", JOptionPane.PLAIN_MESSAGE);
        }

        if(e.getSource()==backButton){
            this.setVisible(false);
            MainUI mainUI = new MainUI();
            mainUI.startMenu();
        }
    }
}