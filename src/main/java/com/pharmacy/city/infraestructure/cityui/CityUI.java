package com.pharmacy.city.infraestructure.cityui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.pharmacy.city.domain.entity.City;
import com.pharmacy.customer.infraestructure.customerui.DeleteUI;

public class CityUI extends JFrame implements ActionListener{
    private JLabel title, logoImg;
    private JButton findButton, addButton, updateButton, deleteButton, allCustomerButton;

    public CityUI(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Cities");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/CityImg.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(10, 40, 500, 500);
        add(logoImg);

        title = new JLabel("Cities");
        title.setBounds(555, 10, 500, 300);
        title.setFont(new Font("Andale Mono", Font.BOLD, 90));
        title.setForeground(new Color(0, 0, 100));
        add(title);
        
        addButton = new JButton("Add");
        addButton.setBounds(520, 255, 150, 60);
        addButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        addButton.setForeground(new Color(0, 0, 100));
        addButton.addActionListener(this);
        add(addButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(520, 335, 150, 60);
        updateButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        updateButton.setForeground(new Color(0, 0, 100));
        updateButton.addActionListener(this);
        add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(700, 335, 150, 60);
        deleteButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        deleteButton.setForeground(new Color(0, 0, 100));
        deleteButton.addActionListener(this);
        add(deleteButton);

        allCustomerButton = new JButton("All cities");
        allCustomerButton.setBounds(700, 255, 150, 60);
        allCustomerButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        allCustomerButton.setForeground(new Color(0, 0, 100));
        allCustomerButton.addActionListener(this);
        add(allCustomerButton);
    }
    public void startCity() {
        CityUI cityUI = new CityUI();
        cityUI.setBounds(0, 0, 1000, 600);
        cityUI.setVisible(true);
        cityUI.setResizable(false);
        cityUI.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==addButton){
            AddCityUI addUI = new AddCityUI();
            addUI.setBounds(0, 0, 500, 300);
            addUI.setVisible(true);
            addUI.setResizable(false);
            addUI.setLocationRelativeTo(null);
            this.setVisible(false);

        }

        if(e.getSource()==deleteButton){

            DeleteCityUI deleteUIA = new DeleteCityUI();
            deleteUIA.setBounds(0, 0, 500, 300);
            deleteUIA.setVisible(true);
            deleteUIA.setResizable(false);
            deleteUIA.setLocationRelativeTo(null);
            this.setVisible(false);
        }
    }
}
