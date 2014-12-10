/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoop.controller;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import shoop.model.User;
import shoop.model.UserXmlFile;


/**
 *
 * @author Arcast
 */
public class RegisterViewController {
    private static JTextField FieldName; 
    private static JTextField FieldLastName; 
    private static JTextField FieldID;
    private static JTextField FieldEmail; 
    private static JTextField FieldUserName;
    private static JPasswordField FieldPw;
    private static JTextField BdayMonth;
    private static JTextField BdayDay;
    private static JTextField BdayYear;
    private static JComboBox  JComboBox1;


public static void initOutlets(JTextField FieldName,JTextField FieldLastName, JTextField FieldID,JTextField FieldEmail,JTextField FieldUserName,JPasswordField FieldPw,JTextField BdayMonth,JTextField BdayYear,JTextField BdayDay,JComboBox JComboBox1)
{
    RegisterViewController.FieldName = FieldName;
    RegisterViewController.FieldLastName = FieldLastName;
    RegisterViewController.FieldEmail = FieldEmail;
    RegisterViewController.FieldID = FieldID;
    RegisterViewController.FieldUserName = FieldUserName;
    RegisterViewController.FieldPw = FieldPw;
    RegisterViewController.BdayDay = BdayDay;
    RegisterViewController.BdayMonth = BdayMonth;
    RegisterViewController.BdayYear = BdayYear;
    RegisterViewController.JComboBox1 = JComboBox1;
    
}

public static void registerUser()
{
    User user1 = new User(FieldName.getText(),FieldLastName.getText(),FieldUserName.getText(),String.copyValueOf(FieldPw.getPassword()),FieldID.getText(),FieldEmail.getText(),BdayDay.getText()+"/"+BdayMonth.getText()+"/"+BdayYear.getText(),"comprador");
    UserXmlFile.saveUserInDataBase(user1);
}




}