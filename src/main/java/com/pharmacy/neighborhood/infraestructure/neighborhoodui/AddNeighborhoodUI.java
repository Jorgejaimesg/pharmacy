package com.pharmacy.neighborhood.infraestructure.neighborhoodui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.pharmacy.city.aplication.FindAllCityUseCase;
import com.pharmacy.city.aplication.FindCityByNameUseCase;
import com.pharmacy.city.domain.entity.City;
import com.pharmacy.city.domain.service.CityService;
import com.pharmacy.city.infraestructure.CityRepository;
import com.pharmacy.neighborhood.aplication.CreateNeighborhoodUseCase;
import com.pharmacy.neighborhood.domain.entity.Neighborhood;
import com.pharmacy.neighborhood.domain.service.NeighborhoodService;
import com.pharmacy.neighborhood.infraestructure.NeighborhoodRepository;

public class AddNeighborhoodUI extends JFrame implements ActionListener{
        
    private JLabel logoImg, title, labelName, labelCity;
    private JButton addButton, backButton;
    private JTextField Name;
    private JComboBox<String> city;

    NeighborhoodService neighborhoodService = new NeighborhoodRepository();
    CityService cityService = new CityRepository();
    FindAllCityUseCase findAllCityUseCase = new FindAllCityUseCase(cityService);
    FindCityByNameUseCase findCityByNameUseCase = new FindCityByNameUseCase(cityService);
    CreateNeighborhoodUseCase createNeighborhoodUseCase = new CreateNeighborhoodUseCase(neighborhoodService);
    List<City> cities = findAllCityUseCase.findAllCity();

    public AddNeighborhoodUI(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Add Neighborhood");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/neighborhood.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(60, 20, 90, 90);
        add(logoImg);

        title = new JLabel("Add Neighborhood");
        title.setBounds(180, 20, 400, 90);
        title.setFont(new Font("Andale Mono", Font.BOLD, 30));
        title.setForeground(new Color(0, 0, 100));
        add(title);

        labelName = new JLabel("Neighborhood : ");
        labelName.setBounds(35, 130, 150, 30);
        labelName.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelName.setForeground(new Color(0, 0, 100));
        add(labelName);

        Name = new JTextField();
        Name.setBounds(190, 130, 255, 30);
        Name.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        Name.setForeground(new Color(0, 0, 100));
        add(Name);

        labelCity = new JLabel("City : ");
        labelCity.setBounds(125, 170, 150, 30);
        labelCity.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelCity.setForeground(new Color(0, 0, 100));
        add(labelCity);

        city = new JComboBox<String>();
        city.setBounds(190, 170, 255, 30);
        city.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        city.setForeground(new Color(0, 0, 100));
        add(city);
        city.addItem("");
        for(City cityitem : cities){
            city.addItem(cityitem.getName());
        };

        addButton = new JButton("Add");
        addButton.setBounds(125, 240, 120, 30);
        addButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        addButton.setForeground(new Color(0, 0, 100));
        addButton.addActionListener(this);
        add(addButton);

        backButton = new JButton("Go Back");
        backButton.setBounds(275, 240, 120, 30);
        backButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        backButton.setForeground(new Color(0, 0, 100));
        backButton.addActionListener(this);
        add(backButton);
    }

    public void startAddNeighborhood() {
        AddNeighborhoodUI addNeighborhoodUI = new AddNeighborhoodUI();
        addNeighborhoodUI.setBounds(0, 0, 500, 350);
        addNeighborhoodUI.setVisible(true);
        addNeighborhoodUI.setResizable(false);
        addNeighborhoodUI.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==addButton){
            


            try {
                String cityName = city.getSelectedItem().toString();
                Optional<City> cityFound = findCityByNameUseCase.findCityByName(cityName);
                int cityID =cityFound.get().getId();
                System.out.println(cityID);
                String neighborhoodName = Name.getText().trim();
                if (neighborhoodName.length()>0){
                    Neighborhood newNeighborhood = new Neighborhood();
                
                    newNeighborhood.setName(neighborhoodName);
                    newNeighborhood.setCityId(cityID);
                    
                    createNeighborhoodUseCase.execute(newNeighborhood);
                
                JOptionPane.showMessageDialog(this, "Neighborhood added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                Name.setText("");
                city.setSelectedItem("");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Neighborhood", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }

    if(e.getSource()==backButton){
        this.setVisible(false);
        NeighborhoodUI neighborhoodUI = new NeighborhoodUI();
        neighborhoodUI.startNeighborhood();
    }
    }


}
