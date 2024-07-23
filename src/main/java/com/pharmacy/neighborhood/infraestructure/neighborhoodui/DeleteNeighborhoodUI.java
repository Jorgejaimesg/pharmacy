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

import com.pharmacy.city.aplication.FindAllCityUseCase;
import com.pharmacy.city.aplication.FindCityByNameUseCase;
import com.pharmacy.city.domain.entity.City;
import com.pharmacy.city.domain.service.CityService;
import com.pharmacy.city.infraestructure.CityRepository;
import com.pharmacy.neighborhood.aplication.DeleteNeighborhoodByNameUseCase;
import com.pharmacy.neighborhood.aplication.FindNeighborhoodByCityUseCase;
import com.pharmacy.neighborhood.domain.entity.Neighborhood;
import com.pharmacy.neighborhood.domain.service.NeighborhoodService;
import com.pharmacy.neighborhood.infraestructure.NeighborhoodRepository;


public class DeleteNeighborhoodUI extends JFrame implements ActionListener{
    NeighborhoodService neighborhoodService = new NeighborhoodRepository();
    CityService cityService = new CityRepository();
    FindCityByNameUseCase findCityByNameUseCase = new FindCityByNameUseCase(cityService);
    FindAllCityUseCase findAllCityUseCase = new FindAllCityUseCase(cityService);
    FindNeighborhoodByCityUseCase findNeighborhoodByCityUseCase = new FindNeighborhoodByCityUseCase(neighborhoodService);
    DeleteNeighborhoodByNameUseCase deleteNeighborhoodByNameUseCase = new DeleteNeighborhoodByNameUseCase(neighborhoodService);
    List<City> cities = findAllCityUseCase.findAllCity();
    

    private JLabel logoImg, title, labelCity, labelNeighborhood;
    private JButton deleteButton, backButton;
    private JComboBox<String> City, Neighborhood;
    private int cityID;

    public DeleteNeighborhoodUI(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Delete NeighborhoodUI");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/neighborhood.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(15, 20, 90, 90);
        add(logoImg);

        title = new JLabel("Delete Neighborhood");
        title.setBounds(130, 20, 400, 90);
        title.setFont(new Font("Andale Mono", Font.BOLD, 33));
        title.setForeground(new Color(0, 0, 100));
        add(title);

        labelCity = new JLabel("City : ");
        labelCity.setBounds(35, 130, 150, 30);
        labelCity.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelCity.setForeground(new Color(0, 0, 100));
        add(labelCity);

        City = new JComboBox<String>();
        City.setBounds(180, 130, 255, 30);
        City.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        City.setForeground(new Color(0, 0, 100));
        add(City);
        City.addItem("");
        for(City city : cities){
            City.addItem(city.getName());
        };

        labelNeighborhood = new JLabel("Neighborhood : ");
        labelNeighborhood.setBounds(35, 170, 150, 30);
        labelNeighborhood.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelNeighborhood.setForeground(new Color(0, 0, 100));
        add(labelNeighborhood);

        Neighborhood = new JComboBox<String>();
        Neighborhood.setBounds(180, 170, 255, 30);
        Neighborhood.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        Neighborhood.setForeground(new Color(0, 0, 100));
        add(Neighborhood);
        City.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarNeighborhood();
            }
        });


        deleteButton = new JButton("Delete");
        deleteButton.setBounds(125, 230, 120, 30);
        deleteButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        deleteButton.setForeground(new Color(0, 0, 100));
        deleteButton.addActionListener(this);
        add(deleteButton);

        backButton = new JButton("Go Back");
        backButton.setBounds(275, 230, 120, 30);
        backButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        backButton.setForeground(new Color(0, 0, 100));
        backButton.addActionListener(this);
        add(backButton);

        
    }

    private void actualizarNeighborhood() {
        Neighborhood.removeAllItems(); 
        String cityName = City.getSelectedItem().toString();
        Optional<City> cityFound = findCityByNameUseCase.findCityByName(cityName);
        this.cityID =cityFound.get().getId();
        List<Neighborhood> neighborhoods = findNeighborhoodByCityUseCase.findAllNeighborhoodByCity(cityID);
        for(Neighborhood neighborhooditem : neighborhoods){
            Neighborhood.addItem(neighborhooditem.getName());
        };
    }

    public void startDeleteNeighborhood() {
        DeleteNeighborhoodUI deleteNeighborhoodUI = new DeleteNeighborhoodUI();
        deleteNeighborhoodUI.setBounds(0, 0, 500, 350);
        deleteNeighborhoodUI.setVisible(true);
        deleteNeighborhoodUI.setResizable(false);
        deleteNeighborhoodUI.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==deleteButton){
                try {
                String neighborhoodName = Neighborhood.getSelectedItem().toString();
                if (neighborhoodName.length()>0){
                
                
                    deleteNeighborhoodByNameUseCase.execute(cityID, neighborhoodName);


                JOptionPane.showMessageDialog(this, "Neighborhood added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                City.setSelectedItem("");
                Neighborhood.removeAllItems(); 
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Neighborhood.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource()== backButton){
            this.setVisible(false);
            NeighborhoodUI neighborhoodUI = new NeighborhoodUI();
            neighborhoodUI.startNeighborhood();
        }
        
    }
}
