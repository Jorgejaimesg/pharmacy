package com.pharmacy.neighborhood.infraestructure.neighborhoodui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.pharmacy.main.infraestructure.MainUI;
import com.pharmacy.neighborhood.aplication.FindAllNeighborhoodUseCase;
import com.pharmacy.neighborhood.domain.entity.NeighborhoodShow;
import com.pharmacy.neighborhood.domain.service.NeighborhoodService;
import com.pharmacy.neighborhood.infraestructure.NeighborhoodRepository;

public class NeighborhoodUI extends JFrame implements ActionListener{
    private JLabel title, logoImg;
    private JButton addButton, deleteButton, allCityButton, backButton;

    public NeighborhoodUI(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Neighborhoods");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/neighborhood.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(10, 40, 500, 500);
        add(logoImg);

        title = new JLabel("Neighborhoods");
        title.setBounds(490, 10, 500, 300);
        title.setFont(new Font("Andale Mono", Font.BOLD, 60));
        title.setForeground(new Color(0, 0, 100));
        add(title);

        backButton = new JButton("🔙");
        backButton.setBounds(0, 0, 60, 30);
        backButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        backButton.setForeground(new Color(0, 0, 100));
        backButton.addActionListener(this);
        add(backButton);
        
        addButton = new JButton("Add");
        addButton.setBounds(520, 255, 150, 60);
        addButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        addButton.setForeground(new Color(0, 0, 100));
        addButton.addActionListener(this);
        add(addButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(700, 255, 150, 60);
        deleteButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        deleteButton.setForeground(new Color(0, 0, 100));
        deleteButton.addActionListener(this);
        add(deleteButton);

        allCityButton = new JButton("All Neighborhoods");
        allCityButton.setBounds(520, 335, 330, 60);
        allCityButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        allCityButton.setForeground(new Color(0, 0, 100));
        allCityButton.addActionListener(this);
        add(allCityButton);
    }
    public void startNeighborhood() {
        NeighborhoodUI neighborhoodUI  = new NeighborhoodUI ();
        neighborhoodUI.setBounds(0, 0, 1000, 600);
        neighborhoodUI.setVisible(true);
        neighborhoodUI.setResizable(false);
        neighborhoodUI.setLocationRelativeTo(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==addButton){
            this.setVisible(false);
            AddNeighborhoodUI addNeighborhoodUI = new AddNeighborhoodUI();
            addNeighborhoodUI.startAddNeighborhood(); 
        }
        
        if(e.getSource()==deleteButton){
            this.setVisible(false);
            DeleteNeighborhoodUI deleteNeighborhoodUI = new DeleteNeighborhoodUI();
            deleteNeighborhoodUI.startDeleteNeighborhood();
        }

        if (e.getSource()==allCityButton){
                NeighborhoodService neighborhoodService = new NeighborhoodRepository();
                FindAllNeighborhoodUseCase findAllNeighborhoodUseCase = new FindAllNeighborhoodUseCase(neighborhoodService);
                List<NeighborhoodShow> neighborhoods = findAllNeighborhoodUseCase.findAllNeighborhood();
        
                String[] columns = {"ID", "Neighborhood", "City"};
                DefaultTableModel defaultTableModel = new DefaultTableModel(columns, 0);

                neighborhoods.forEach(neighborhood -> {
                    Object[] row = {neighborhood.getId(), neighborhood.getName(), neighborhood.getCity() };
                    defaultTableModel.addRow(row);
                });

        JTable table = new JTable(defaultTableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JOptionPane.showMessageDialog(null, scrollPane, "Neighborhood List", JOptionPane.PLAIN_MESSAGE);
        }

        if(e.getSource()==backButton){
            this.setVisible(false);
            MainUI mainUI = new MainUI();
            mainUI.startMenu();
        }

        }

}
