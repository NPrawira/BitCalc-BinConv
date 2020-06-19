package binarycounter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BinaryConverter extends MainMenu{
    JFrame convframe;
    JLabel titleconv,numinput,from,to,result;
    JTextField inarea,outarea;
    JComboBox convfrom,convdest;
    JButton getresult,reset;
    
    public BinaryConverter(){
        convframe = new JFrame();
        titleconv=new JLabel("Binary Converter");
        titleconv.setFont(new Font("Dubai Medium", Font.BOLD,24));
        
        numinput=new JLabel("Input number");
        numinput.setFont(new Font("Dubai", Font.PLAIN,18));
        
        from=new JLabel("Convert");
        from.setFont(new Font("Dubai", Font.PLAIN,18));
        
        to=new JLabel("to");
        to.setFont(new Font("Dubai", Font.PLAIN,18));
        
        result=new JLabel("Result");
        result.setFont(new Font("Dubai", Font.PLAIN,18));
        
        inarea=new JTextField(25);
        inarea.setFont(new Font("Dubai", Font.PLAIN,18));
        
        outarea=new JTextField(25);
        outarea.setFont(new Font("Dubai", Font.PLAIN,18));
        outarea.setEditable(false);
    
        convfrom=new JComboBox();
        convfrom.setFont(new Font("Dubai", Font.PLAIN,18));
        convfrom.addItem("Binary");
        convfrom.addItem("Decimal");
        convfrom.addItem("Hexadecimal");
        convfrom.addItem("Octal");
        
        convdest=new JComboBox();
        convdest.setFont(new Font("Dubai", Font.PLAIN,18));
        convdest.addItem("Binary");
        convdest.addItem("Decimal");
        convdest.addItem("Hexadecimal");
        convdest.addItem("Octal");
        
        getresult=new JButton("Result");
        getresult.setFont(new Font("Dubai", Font.BOLD,18));
        getresult.addActionListener((ActionEvent a) -> {
            getBinConvRes();
            getDecConvRes();
            getHexConvRes();
            getOctConvRes();
        });
        
        reset=new JButton("Reset");
        reset.setFont(new Font("Dubai", Font.BOLD,18));
        reset.addActionListener((ActionEvent b) -> {
            resetconv();
        });
        
        setTitle("Binary Converter");
        setSize(800,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        Component();
    }
    
    @Override
    public void Component(){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridx =1;
        c.gridy =0;
        c.weighty = 0.001;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(titleconv,c);
        
        c.gridx =0;
        c.gridy =1;
        add(numinput, c);
        
        c.gridx =2;
        c.gridy =1;
        add(inarea, c);
        
        c.gridx =0;
        c.gridy =2;
        add(from, c);
        
        c.gridx =2;
        c.gridy =2;
        add(convfrom, c);
        
        c.gridx =0;
        c.gridy =3;
        add(to, c);
        
        c.gridx =2;
        c.gridy =3;
        add(convdest, c);
        
        c.gridx =1;
        c.gridy =4;
        add(getresult, c);
        
        c.gridx =0;
        c.gridy =6;
        add(result, c);
        
        c.gridx =2;
        c.gridy =6;
        add(outarea, c);
        
        c.gridx =1;
        c.gridy =5;
        add(reset, c);
    }
    
    public void resetconv(){
        inarea.setText(null);
        convfrom.setSelectedItem("Binary");
        convdest.setSelectedItem("Binary");
        outarea.setText(null);
    }
    
    public void getBinConvRes(){
	String a,b,bin;
	int input;
	try{
            a=(String)convfrom.getSelectedItem();
            b=(String)convdest.getSelectedItem();
            bin=inarea.getText();
            switch(a){
                case "Binary": switch(b){
                case "Decimal":
                    input = Integer.parseInt(bin,2);
                    outarea.setText(Integer.toUnsignedString(input));
                    break;
		case "Hexadecimal":
                    input = Integer.parseInt(bin,2);
                    outarea.setText(Integer.toHexString(input));
                    break;
		case "Octal":
                    input = Integer.parseInt(bin,2);
                    outarea.setText(Integer.toOctalString(input));
                    break;
                case "Binary":
                    JOptionPane.showMessageDialog(null,"Cannot convert between same unit","Failed",JOptionPane.ERROR_MESSAGE);
                    resetconv();
                    break;
		}
            }
	}
	catch(NumberFormatException misbin){
		JOptionPane.showMessageDialog(null,"Give binary number input","Failed",JOptionPane.ERROR_MESSAGE);
                resetconv();
	}
    }
    
    public void getDecConvRes(){
	String a,b,dec;
	int input;
	try{
            a=(String)convfrom.getSelectedItem();
            b=(String)convdest.getSelectedItem();
            dec=inarea.getText();
            switch(a){
                case "Decimal": switch(b){
                case "Binary":
                    input = Integer.parseInt(dec,10);
                    outarea.setText(Integer.toBinaryString(input));
                    break;
		case "Hexadecimal":
                    input = Integer.parseInt(dec,10);
                    outarea.setText(Integer.toHexString(input));
                    break;
		case "Octal":
                    input = Integer.parseInt(dec,10);
                    outarea.setText(Integer.toOctalString(input));
                    break;
                case "Decimal":
                    JOptionPane.showMessageDialog(null,"Cannot convert between same unit","Failed",JOptionPane.ERROR_MESSAGE);
                    resetconv();
                    break;
		}
            }
	}
	catch(NumberFormatException misdec){
		JOptionPane.showMessageDialog(null,"Give decimal number input","Failed",JOptionPane.ERROR_MESSAGE);
                resetconv();
	}
    }
    
    public void getHexConvRes(){
	String a,b,hex;
	int input;
	try{
            a=(String)convfrom.getSelectedItem();
            b=(String)convdest.getSelectedItem();
            hex=inarea.getText();
            switch(a){
                case "Hexadecimal": switch(b){
                case "Binary":
                    input = Integer.parseInt(hex,16);
                    outarea.setText(Integer.toBinaryString(input));
                    break;
		case "Decimal":
                    input = Integer.parseInt(hex,16);
                    outarea.setText(Integer.toUnsignedString(input));
                    break;
		case "Octal":
                    input = Integer.parseInt(hex,16);
                    outarea.setText(Integer.toOctalString(input));
                    break;
                case "Hexadecimal":
                    JOptionPane.showMessageDialog(null,"Cannot convert between same unit","Failed",JOptionPane.ERROR_MESSAGE);
                    resetconv();
                    break;
		}
            }
	}
	catch(NumberFormatException mishex){
		JOptionPane.showMessageDialog(null,"Give hexadecimal number input","Failed",JOptionPane.ERROR_MESSAGE);
                resetconv();
	}
    }
    
    public void getOctConvRes(){
	String a,b,oct;
	int input;
	try{
            a=(String)convfrom.getSelectedItem();
            b=(String)convdest.getSelectedItem();
            oct=inarea.getText();
            switch(a){
                case "Octal": switch(b){
                case "Binary":
                    input = Integer.parseInt(oct,8);
                    outarea.setText(Integer.toBinaryString(input));
                    break;
		case "Decimal":
                    input = Integer.parseInt(oct,8);
                    outarea.setText(Integer.toUnsignedString(input));
                    break;
		case "Hexadecimal":
                    input = Integer.parseInt(oct,8);
                    outarea.setText(Integer.toHexString(input));
                    break;
                case "Octal":
                    JOptionPane.showMessageDialog(null,"Cannot convert between same unit","Failed",JOptionPane.ERROR_MESSAGE);
                    resetconv();
                    break;
		}
            }
	}
	catch(NumberFormatException misoct){
		JOptionPane.showMessageDialog(null,"Give octal number input","Failed",JOptionPane.ERROR_MESSAGE);
                resetconv();
	}
    }
    
}
