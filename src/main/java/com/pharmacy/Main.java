package com.pharmacy;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Image;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.pharmacy.city.infraestructure.cityui.CityUI;
import com.pharmacy.customer.infraestructure.customerui.CustomerUI;
import com.pharmacy.neighborhood.infraestructure.neighborhoodui.NeighborhoodUI;
import com.pharmacy.typeid.infraestructure.typeui.TypeUI;

public class Main extends JFrame implements ActionListener{
    private JButton customer, city, neighborhood, typeID;
    private JLabel title, logoImg;
    public Main(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("George's Pharmacy");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/icon.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        ImageIcon imagenOriginalCustomer = new ImageIcon(getClass().getClassLoader().getResource("images/CustomerImg.png"));
        Image imagenRedimensionadaCustomer = imagenOriginalCustomer.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon imagenCustomer = new ImageIcon(imagenRedimensionadaCustomer);

        ImageIcon imagenOriginalCity = new ImageIcon(getClass().getClassLoader().getResource("images/CityImg.png"));
        Image imagenRedimensionadaCity = imagenOriginalCity.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon imagenCity = new ImageIcon(imagenRedimensionadaCity);

        ImageIcon imagenOriginalNeighborhood = new ImageIcon(getClass().getClassLoader().getResource("images/neighborhood.png"));
        Image imagenRedimensionadaNeighborhood = imagenOriginalNeighborhood.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon imagenNeighborhood = new ImageIcon(imagenRedimensionadaNeighborhood);

        ImageIcon imagenOriginalTypeId = new ImageIcon(getClass().getClassLoader().getResource("images/type.png"));
        Image imagenRedimensionadaTypeId = imagenOriginalTypeId.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon imagenTypeId = new ImageIcon(imagenRedimensionadaTypeId);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(-60, 75, 500, 500);
        add(logoImg);

        title = new JLabel("George's Pharmacy");
        title.setBounds(75, -70, 1000, 300);
        title.setFont(new Font("Andale Mono", Font.BOLD, 90));
        title.setForeground(new Color(0, 0, 100));
        add(title);

        customer = new JButton("Customer",imagenCustomer);
        customer.setBounds(380, 200, 120, 120);
        customer.setFont(new Font("Andale Mono", Font.PLAIN, 13));
        customer.setHorizontalTextPosition(JButton.CENTER);
        customer.setVerticalTextPosition(JButton.BOTTOM);
        customer.setForeground(new Color(0, 0, 100));
        customer.addActionListener(this);
        add(customer);
        
        city = new JButton("City", imagenCity);
        city.setBounds(520, 200, 120, 120);
        city.setFont(new Font("Andale Mono", Font.PLAIN, 13));
        city.setHorizontalTextPosition(JButton.CENTER);
        city.setVerticalTextPosition(JButton.BOTTOM);
        city.setForeground(new Color(0, 0, 100));
        city.addActionListener(this);
        add(city);

        neighborhood = new JButton("Neighborhood",imagenNeighborhood);
        neighborhood.setBounds(660, 200, 120, 120);
        neighborhood.setFont(new Font("Andale Mono", Font.PLAIN, 13));
        neighborhood.setHorizontalTextPosition(JButton.CENTER);
        neighborhood.setVerticalTextPosition(JButton.BOTTOM);
        neighborhood.setForeground(new Color(0, 0, 100));
        neighborhood.addActionListener(this);
        add(neighborhood);

        typeID = new JButton("ID types",imagenTypeId);
        typeID.setBounds(790, 200, 120, 120);
        typeID.setFont(new Font("Andale Mono", Font.PLAIN, 13));
        typeID.setHorizontalTextPosition(JButton.CENTER);
        typeID.setVerticalTextPosition(JButton.BOTTOM);
        typeID.setForeground(new Color(0, 0, 100));
        typeID.addActionListener(this);
        add(typeID);
    }

    public static void main(String args[]) {
        Main main = new Main();
        main.startMenu();
    }

    public void startMenu() {
        Main Main = new Main();
        Main.setBounds(0, 0, 1000, 600);
        Main.setVisible(true);
        Main.setResizable(false);
        Main.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==customer){
            this.setVisible(false);
            CustomerUI customerUI = new CustomerUI();
            customerUI.startCustomer();
        }
        
        if (e.getSource()==city){
            this.setVisible(false);
            CityUI cityUI = new CityUI();
            cityUI.startCity();
        }

        if (e.getSource()==neighborhood){
            this.setVisible(false);
            NeighborhoodUI neighborhoodUI = new NeighborhoodUI();
            neighborhoodUI.startNeighborhood();

        }

        if (e.getSource()==typeID){
            this.setVisible(false);
            TypeUI typeUI = new TypeUI();
            typeUI.startType();
        }

    }


}
