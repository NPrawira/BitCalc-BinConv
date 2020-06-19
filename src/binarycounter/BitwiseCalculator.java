package binarycounter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BitwiseCalculator extends MainMenu{
    JFrame calcframe;
    JLabel titlecalc,numinput1,numinput2,baseunit,operation,resbin,resdec,reshex;
    JTextField numarea1,numarea2,resbinarea,resdecarea,reshexarea;
    JComboBox unit,operator;
    JButton getresult,reset;
    
    public BitwiseCalculator(){
        calcframe=new JFrame();
        
        titlecalc=new JLabel("Bitwise Calculator");
        titlecalc.setFont(new Font("Dubai Medium", Font.BOLD,24));
        
        baseunit=new JLabel("Base unit");
        baseunit.setFont(new Font("Dubai", Font.PLAIN,18));
        
        unit=new JComboBox();
        unit.setFont(new Font("Dubai", Font.PLAIN,18));
        unit.addItem("Binary");
        unit.addItem("Decimal");
        unit.addItem("Hexadecimal");
        
        numinput1=new JLabel("First number");
        numinput1.setFont(new Font("Dubai", Font.PLAIN,18));
        
        numarea1=new JTextField(25);
        numarea1.setFont(new Font("Dubai", Font.PLAIN,18));
        
        numinput2=new JLabel("Second number");
        numinput2.setFont(new Font("Dubai", Font.PLAIN,18));
        
        numarea2=new JTextField(25);
        numarea2.setFont(new Font("Dubai", Font.PLAIN,18));
        
        operation=new JLabel("Operator");
        operation.setFont(new Font("Dubai", Font.PLAIN,18));
        
        operator=new JComboBox();
        operator.setFont(new Font("Dubai", Font.PLAIN,18));
        operator.addItem("AND (&)");
        operator.addItem("OR (|)");
        operator.addItem("XOR (^)");
        operator.addItem("NAND (~(&))");
        operator.addItem("NOR (~(|))");
        operator.addItem("NXOR (~(^))");
        operator.addItem("NOT (~) (first number only)");
        operator.addItem("NOT (~) (second number only)");
        
        getresult=new JButton("Result");
        getresult.setFont(new Font("Dubai", Font.BOLD,18));
        getresult.addActionListener((ActionEvent a) -> {
            getbinbitcalcres();
            getdecbitcalcres();
            gethexbitcalcres();
        });
        
        reset=new JButton("Reset");
        reset.setFont(new Font("Dubai", Font.BOLD,18));
        reset.addActionListener((ActionEvent b) -> {
            resetcalc();
        });
        
        resbin=new JLabel("Result (in Binary)");
        resbin.setFont(new Font("Dubai", Font.PLAIN,18));
        
        resbinarea=new JTextField(25);
        resbinarea.setFont(new Font("Dubai", Font.PLAIN,18));
        resbinarea.setEditable(false);
        
        resdec=new JLabel("Result (in Decimal)");
        resdec.setFont(new Font("Dubai", Font.PLAIN,18));
        
        resdecarea=new JTextField(25);
        resdecarea.setFont(new Font("Dubai", Font.PLAIN,18));
        resdecarea.setEditable(false);
        
        reshex=new JLabel("Result (in Hexadecimal)");
        reshex.setFont(new Font("Dubai", Font.PLAIN,18));
        
        reshexarea=new JTextField(25);
        reshexarea.setFont(new Font("Dubai", Font.PLAIN,18));
        reshexarea.setEditable(false);
        
        setTitle("Bitwise Calculator");
        setSize(800,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        Component();
    }
    
    public void Action(){
        getbinbitcalcres();
        getdecbitcalcres();
        gethexbitcalcres();
    }
    
    public void resetcalc(){
        numarea1.setText(null);
        numarea2.setText(null);
        resbinarea.setText(null);
        resdecarea.setText(null);
        reshexarea.setText(null);
        unit.setSelectedItem("Binary");
        operator.setSelectedItem("AND (&)");
        numinput1.setVisible(true);
        numarea1.setVisible(true);
        numinput2.setVisible(true);
        numarea2.setVisible(true);
    }
    
    @Override
    public void Component(){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridx =2;
        c.gridy =0;
        c.weighty = 0.001;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(titlecalc,c);
        
        c.gridx =0;
        c.gridy =1;
        add(baseunit, c);
        
        c.gridx =2;
        c.gridy =1;
        add(unit, c);
        
        c.gridx =0;
        c.gridy =2;
        add(numinput1, c);
        
        c.gridx =2;
        c.gridy =2;
        add(numarea1, c);
        
        c.gridx =0;
        c.gridy =3;
        add(numinput2, c);
        
        c.gridx =2;
        c.gridy =3;
        add(numarea2, c);
        
        c.gridx =0;
        c.gridy =4;
        add(operation, c);
        
        c.gridx =2;
        c.gridy =4;
        add(operator, c);
        
        c.gridx =1;
        c.gridy =5;
        add(getresult, c);
        
        c.gridx =3;
        c.gridy =5;
        add(reset, c);
        
        c.gridx =0;
        c.gridy =6;
        add(resbin, c);
        
        c.gridx =2;
        c.gridy =6;
        add(resbinarea, c);
        
        c.gridx =0;
        c.gridy =7;
        add(resdec, c);
        
        c.gridx =2;
        c.gridy =7;
        add(resdecarea, c);
        
        c.gridx =0;
        c.gridy =8;
        add(reshex, c);
        
        c.gridx =2;
        c.gridy =8;
        add(reshexarea, c);
    }
    
    public void getbinbitcalcres(){
        String a,b,bin1,bin2;
        int input1,input2,res;
        try{
            a=(String) unit.getSelectedItem();
            bin1=numarea1.getText();
            bin2=numarea2.getText();
            b=(String) operator.getSelectedItem();
            switch(a){
                case "Binary":switch(b){
                    case "AND (&)":
                        input1 = Integer.parseInt(bin1,2);
                        input2 = Integer.parseInt(bin2,2);
                        res = input1&input2;
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                    case "OR (|)":
                        input1 = Integer.parseInt(bin1,2);
                        input2 = Integer.parseInt(bin2,2);
                        res = input1|input2;
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                    case "XOR (^)":
                        input1 = Integer.parseInt(bin1,2);
                        input2 = Integer.parseInt(bin2,2);
                        res = input1^input2;
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                    case "NAND (~(&))":
                        input1 = Integer.parseInt(bin1,2);
                        input2 = Integer.parseInt(bin2,2);
                        res = ~(input1&input2);
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                    case "NOR (~(|))":
                        input1 = Integer.parseInt(bin1,2);
                        input2 = Integer.parseInt(bin2,2);
                        res = ~(input1^input2);
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                    case "NXOR (~(^))":
                        input1 = Integer.parseInt(bin1,2);
                        input2 = Integer.parseInt(bin2,2);
                        res = ~(input1^input2);
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                    case "NOT (~) (first number only)":
                        numinput2.setVisible(false);
                        numarea2.setVisible(false);
                        input1 = Integer.parseInt(bin1,2);
                        res = ~input1;
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                    case "NOT (~) (second number only)":
                        numinput1.setVisible(false);
                        numarea1.setVisible(false);
                        input2 = Integer.parseInt(bin2,2);
                        res = ~input2;
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                }
            }
        }
        catch(NumberFormatException misbin){
            JOptionPane.showMessageDialog(null,"Give binary number input","Failed",JOptionPane.ERROR_MESSAGE);
            resetcalc();
        }
    }
    
    public void getdecbitcalcres(){
        String a,b,dec1,dec2;
        int input1,input2,res;
        try{
            a=(String) unit.getSelectedItem();
            dec1=numarea1.getText();
            dec2=numarea2.getText();
            b=(String) operator.getSelectedItem();
            switch(a){
                case "Decimal":switch(b){
                    case "AND (&)":
                        input1 = Integer.parseInt(dec1,10);
                        input2 = Integer.parseInt(dec2,10);
                        res = input1&input2;
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                    case "OR (|)":
                        input1 = Integer.parseInt(dec1,10);
                        input2 = Integer.parseInt(dec2,10);
                        res = input1|input2;
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                    case "XOR (^)":
                        input1 = Integer.parseInt(dec1,10);
                        input2 = Integer.parseInt(dec2,10);
                        res = input1^input2;
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                    case "NAND (~(&))":
                        input1 = Integer.parseInt(dec1,10);
                        input2 = Integer.parseInt(dec2,10);
                        res = ~(input1&input2);
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                    case "NOR (~(|))":
                        input1 = Integer.parseInt(dec1,10);
                        input2 = Integer.parseInt(dec2,10);
                        res = ~(input1^input2);
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                    case "NXOR (~(^))":
                        input1 = Integer.parseInt(dec1,10);
                        input2 = Integer.parseInt(dec2,10);
                        res = ~(input1^input2);
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                    case "NOT (~) (first number only)":
                        numinput2.setVisible(false);
                        numarea2.setVisible(false);
                        input1 = Integer.parseInt(dec1,10);
                        res = ~input1;
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                    case "NOT (~) (second number only)":
                        numinput1.setVisible(false);
                        numarea1.setVisible(false);
                        input2 = Integer.parseInt(dec2,10);
                        res = ~input2;
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                }
            }
        }
        catch(NumberFormatException misdec){
            JOptionPane.showMessageDialog(null,"Give decimal number input","Failed",JOptionPane.ERROR_MESSAGE);
            resetcalc();
        }
    }
    
    public void gethexbitcalcres(){
        String a,b,hex1,hex2;
        int input1,input2,res;
        try{
            a=(String) unit.getSelectedItem();
            hex1=numarea1.getText();
            hex2=numarea2.getText();
            b=(String) operator.getSelectedItem();
            switch(a){
                case "Hexadecimal":switch(b){
                    case "AND (&)":
                        input1 = Integer.parseInt(hex1,16);
                        input2 = Integer.parseInt(hex2,16);
                        res = input1&input2;
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                    case "OR (|)":
                        input1 = Integer.parseInt(hex1,16);
                        input2 = Integer.parseInt(hex2,16);
                        res = input1|input2;
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                    case "XOR (^)":
                        input1 = Integer.parseInt(hex1,16);
                        input2 = Integer.parseInt(hex2,16);
                        res = input1^input2;
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                    case "NAND (~(&))":
                        input1 = Integer.parseInt(hex1,16);
                        input2 = Integer.parseInt(hex2,16);
                        res = ~(input1&input2);
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                    case "NOR (~(|))":
                        input1 = Integer.parseInt(hex1,16);
                        input2 = Integer.parseInt(hex2,16);
                        res = ~(input1^input2);
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                    case "NXOR (~(^))":
                        input1 = Integer.parseInt(hex1,16);
                        input2 = Integer.parseInt(hex2,16);
                        res = ~(input1^input2);
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                    case "NOT (~) (first number only)":
                        numinput2.setVisible(false);
                        numarea2.setVisible(false);
                        input1 = Integer.parseInt(hex1,16);
                        res = ~input1;
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                    case "NOT (~) (second number only)":
                        numinput1.setVisible(false);
                        numarea1.setVisible(false);
                        input2 = Integer.parseInt(hex2,16);
                        res = ~input2;
                        resbinarea.setText(Integer.toBinaryString(res));
                        resdecarea.setText(Integer.toUnsignedString(res));
                        reshexarea.setText(Integer.toHexString(res));
                        break;
                }
            }
        }
        catch(NumberFormatException mishex){
            JOptionPane.showMessageDialog(null,"Give hexadecimal number input","Failed",JOptionPane.ERROR_MESSAGE);
            resetcalc();
        }
    }
    
}
