package com.pharmacy.typeid.infraestructure.typeui;

import java.util.List;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.pharmacy.main.infraestructure.MainUI;
import com.pharmacy.typeid.aplication.FindAllTypeIDUseCase;
import com.pharmacy.typeid.domain.entity.TypeID;
import com.pharmacy.typeid.domain.service.TypeIDService;
import com.pharmacy.typeid.infraestructure.TypeIDRepository;

public class TypeUI extends JFrame implements ActionListener{

    private JLabel title, logoImg;
    private JButton addButton, deleteButton, allTypeButton, backButton;

    public TypeUI(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("ID Types");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/type.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(10, 40, 500, 500);
        add(logoImg);

        title = new JLabel("ID Types");
        title.setBounds(555, 10, 500, 300);
        title.setFont(new Font("Andale Mono", Font.BOLD, 90));
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

        allTypeButton = new JButton("All ID Types");
        allTypeButton.setBounds(520, 335, 330, 60);
        allTypeButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        allTypeButton.setForeground(new Color(0, 0, 100));
        allTypeButton.addActionListener(this);
        add(allTypeButton);
    }
    public void startType() {
        TypeUI typeUI = new TypeUI();
        typeUI.setBounds(0, 0, 1000, 600);
        typeUI.setVisible(true);
        typeUI.setResizable(false);
        typeUI.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==addButton){
            this.setVisible(false);
            AddTypeUI addTypeUI = new AddTypeUI();
            addTypeUI.startAddTypeID();
        }
        
        if(e.getSource()==deleteButton){
            this.setVisible(false);
            DeleteTypeUI deleteTypeUI = new DeleteTypeUI();
            deleteTypeUI.startDeleteTypeID();
        }

        if (e.getSource()==allTypeButton){
                TypeIDService typeIDService = new TypeIDRepository();
                FindAllTypeIDUseCase findAllTypeIDUseCase = new FindAllTypeIDUseCase(typeIDService);
                List<TypeID> Types = findAllTypeIDUseCase.findAllTypeID();
        
                String[] columns = {"ID", "Type"};
                DefaultTableModel defaultTableModel = new DefaultTableModel(columns, 0);

                Types.forEach(typeID -> {
                    Object[] row = {typeID.getID(), typeID.getType()};
                    defaultTableModel.addRow(row);
                });

        JTable table = new JTable(defaultTableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JOptionPane.showMessageDialog(null, scrollPane, "ID Types List", JOptionPane.PLAIN_MESSAGE);
        }

        if(e.getSource()==backButton){
            this.setVisible(false);
            MainUI mainUI = new MainUI();
            mainUI.startMenu();
        }

        }
    }

