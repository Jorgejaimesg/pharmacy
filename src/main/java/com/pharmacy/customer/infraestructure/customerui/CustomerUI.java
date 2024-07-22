package com.pharmacy.customer.infraestructure.customerui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerUI extends JFrame implements ActionListener {
    private JLabel title, logoImg;
    private JButton findButton, addButton, updateButton, deleteButton;

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

        findButton = new JButton("Find");
        findButton.setBounds(520, 250, 150, 60);
        findButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        findButton.setForeground(new Color(0, 0, 100));
        findButton.addActionListener(this);
        add(findButton);
        
        addButton = new JButton("Add");
        addButton.setBounds(700, 250, 150, 60);
        addButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        addButton.setForeground(new Color(0, 0, 100));
        addButton.addActionListener(this);
        add(addButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(520, 330, 150, 60);
        updateButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        updateButton.setForeground(new Color(0, 0, 100));
        updateButton.addActionListener(this);
        add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(700, 330, 150, 60);
        deleteButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        deleteButton.setForeground(new Color(0, 0, 100));
        deleteButton.addActionListener(this);
        add(deleteButton);
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
            findUI.setBounds(0, 0, 500, 600);
            findUI.setVisible(true);
            findUI.setResizable(false);
            findUI.setLocationRelativeTo(null);
        } 
        
        if(e.getSource() == addButton){
            
            AddUI addui = new AddUI();
            addui.setBounds(0, 0, 500, 580);
            addui.setVisible(true);
            addui.setResizable(false);
            addui.setLocationRelativeTo(null);
            this.setVisible(false);

        }

        if(e.getSource()== deleteButton){
            DeleteUI deleteUI = new DeleteUI();
            deleteUI.setBounds(0, 0, 500, 300);
            deleteUI.setVisible(true);
            deleteUI.setResizable(false);
            deleteUI.setLocationRelativeTo(null);
            this.setVisible(false);
        }

        if (e.getSource() == updateButton){
            UpdateUI UpdateUI = new UpdateUI();
            UpdateUI.setBounds(0, 0, 500, 600);
            UpdateUI.setVisible(true);
            UpdateUI.setResizable(false);
            UpdateUI.setLocationRelativeTo(null);
            this.setVisible(false);
        }
    }
}