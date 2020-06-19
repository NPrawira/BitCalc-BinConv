package binarycounter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends BinCount{
    JFrame mainframe;
    JButton bincalc, binconv;
    JLabel title;
    
    public MainMenu(){
        mainframe = new JFrame();
        
        bincalc = new JButton("Bitwise Calculator");
        bincalc.setFont(new Font("Dubai", Font.PLAIN, 18));
        bincalc.addActionListener((ActionEvent a) -> {
            new BitwiseCalculator().setVisible(true);
        });
        
        binconv = new JButton("Binary Converter");
        binconv.setFont(new Font("Dubai", Font.PLAIN, 18));
        binconv.addActionListener((ActionEvent b) -> {
            new BinaryConverter().setVisible(true);
        });
        
        title = new JLabel("Bitwise Calculator & Binary Converter");
        title.setFont(new Font("Dubai Medium", Font.BOLD, 24));
    
        setTitle("Main Menu");
        setSize(500,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    @Override
    public void Component(){
        setLayout(new GridBagLayout());
        GridBagConstraints b = new GridBagConstraints();
        
        b.gridx =0;
        b.gridy =0;
        b.weighty =0.1;
        b.anchor = GridBagConstraints.CENTER;
        add(title,b);
        
        b.gridx =0;
        b.gridy =1;
        add(bincalc, b);
        
        b.gridx =0;
        b.gridy =2;
        add(binconv, b);
    }
    
}
