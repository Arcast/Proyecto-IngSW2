/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoop.controller;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import shoop.model.UserXmlFile;

/**
 *
 * @author Arcast
 */
public class LobbyViewController {
    
    private static JTextField FieldUsername;
    private static JTextField FieldUsername1;
    private static JPasswordField FieldPw;
    private static JPasswordField FieldPw1;
    
public static void initOutlets(JTextField FieldUsername, JTextField FieldUsername1, JPasswordField FieldPw, JPasswordField FieldPw1) 
{
    LobbyViewController.FieldUsername = FieldUsername;
    LobbyViewController.FieldUsername1 = FieldUsername1;
    LobbyViewController.FieldPw = FieldPw;
    LobbyViewController.FieldPw1 = FieldPw1;
}   
    
public static boolean logIn()
{
    String Answer;
    Answer = UserXmlFile.LogIn(FieldUsername.getText(),String.copyValueOf(FieldPw.getPassword()));
    if (Answer.equals("TRUE"))
    {
     return true;
    }
     return false;
}



}
