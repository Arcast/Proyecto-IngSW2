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
public class EditProfileViewController {
    private static JTextField FieldName; 
    private static JTextField FieldLastName; 
    private static JTextField FieldID;
    private static JTextField FieldEmail; 
    private static JPasswordField FieldPw;
    private static JPasswordField FieldRepPw;
    private static JTextField BdayMonth;
    private static JTextField BdayDay;
    private static JTextField BdayYear;
    private static String Nickname;
    
    
    public static void initOutlets(JTextField FieldName,JTextField FieldLastName, JTextField FieldID,JTextField FieldEmail,JPasswordField FieldPw,JPasswordField FieldRepPw,JTextField BdayMonth,JTextField BdayYear,JTextField BdayDay)
{
    EditProfileViewController.FieldName = FieldName;
    EditProfileViewController.FieldLastName = FieldLastName;
    EditProfileViewController.FieldEmail = FieldEmail;
    EditProfileViewController.FieldID = FieldID;
    EditProfileViewController.FieldPw = FieldPw;
    EditProfileViewController.FieldRepPw = FieldRepPw;
    EditProfileViewController.BdayDay = BdayDay;
    EditProfileViewController.BdayMonth = BdayMonth;
    EditProfileViewController.BdayYear = BdayYear;
}

    public static String getNickname() {
        return Nickname;
    }

    public static void setNickname(String Nickname) {
        EditProfileViewController.Nickname = Nickname;
    }

    public static void loadUser(String Nickname)
    {
        User user1 = UserXmlFile.readUser(Nickname);
        String [] Bday = user1.getBirthDay().split("/");
        EditProfileViewController.BdayDay.setText(Bday[0]);
        EditProfileViewController.BdayMonth.setText(Bday[1]);
        EditProfileViewController.BdayYear.setText(Bday[2]);
        EditProfileViewController.FieldName.setText(user1.getName());
        EditProfileViewController.FieldLastName.setText(user1.getLastName());
        EditProfileViewController.FieldID.setText(user1.getID());
        EditProfileViewController.FieldEmail.setText(user1.getEmail());
        EditProfileViewController.FieldPw.setText(user1.getPassword());
        EditProfileViewController.FieldRepPw.setText(user1.getPassword());
    }

    public static boolean modifyUser(String Nickname)
    {
        User user1 = new User(EditProfileViewController.FieldName.getText(),EditProfileViewController.FieldLastName.getText(),Nickname,EditProfileViewController.FieldPw.getText(),EditProfileViewController.FieldID.getText(),EditProfileViewController.FieldEmail.getText(),EditProfileViewController.BdayDay.getText()+"/"+EditProfileViewController.BdayMonth.getText()+"/"+EditProfileViewController.BdayYear.getText());
        boolean answer = UserXmlFile.ModifyUser(user1);
        return answer;
    }

}
