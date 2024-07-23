package com.pharmacy.typeid.infraestructure.typeui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.pharmacy.typeid.aplication.CreateTypeIDUseCase;
import com.pharmacy.typeid.domain.entity.TypeID;
import com.pharmacy.typeid.domain.service.TypeIDService;
import com.pharmacy.typeid.infraestructure.TypeIDRepository;

public class AddTypeUI extends JFrame implements ActionListener{
        private JLabel logoImg, title, labelType;
    private JButton addButton, backButton;
    private JTextField type;

    public AddTypeUI(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("ID Types");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/type.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(80, 20, 90, 90);
        add(logoImg);

        title = new JLabel("Add ID Types");
        title.setBounds(200, 20, 400, 90);
        title.setFont(new Font("Andale Mono", Font.BOLD, 35));
        title.setForeground(new Color(0, 0, 100));
        add(title);

        labelType = new JLabel("ID Type : ");
        labelType.setBounds(35, 130, 150, 30);
        labelType.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelType.setForeground(new Color(0, 0, 100));
        add(labelType);

        type = new JTextField();
        type.setBounds(170, 130, 255, 30);
        type.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        type.setForeground(new Color(0, 0, 100));
        add(type);

        addButton = new JButton("Add");
        addButton.setBounds(125, 200, 120, 30);
        addButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        addButton.setForeground(new Color(0, 0, 100));
        addButton.addActionListener(this);
        add(addButton);

        backButton = new JButton("Go Back");
        backButton.setBounds(275, 200, 120, 30);
        backButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        backButton.setForeground(new Color(0, 0, 100));
        backButton.addActionListener(this);
        add(backButton);
    }

    public void startAddTypeID() {
        AddTypeUI addUI = new AddTypeUI();
        addUI.setBounds(0, 0, 500, 300);
        addUI.setVisible(true);
        addUI.setResizable(false);
        addUI.setLocationRelativeTo(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==addButton){

            try {
                String typeName = type.getText().trim();
                if (typeName.length()>0){
                TypeID newtype = new TypeID();
                
                newtype.setType(typeName);
                
                TypeIDService typeIDService = new TypeIDRepository();
                CreateTypeIDUseCase createTypeIDUseCase = new CreateTypeIDUseCase(typeIDService);
                createTypeIDUseCase.execute(newtype);
                JOptionPane.showMessageDialog(this, "Type ID added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                type.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Type.", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }

    if(e.getSource()==backButton){
            this.setVisible(false);
            TypeUI TypeUI = new TypeUI();
            TypeUI.startType();
    }
    }



}
