/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoop.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.JComboBox;
import shoop.model.ListUser;
import shoop.model.UserXmlFile;
import shoop.model.User;

/**
 *
 * @author Arcast
 */
public class AdminDeleteEditUserViewController {
    
    private static String Nickname,Nickname2;
    private static JComboBox JComboBox1;
    
public static void initOutlets(String Nickname, JComboBox JComboBox1){

    AdminDeleteEditUserViewController.JComboBox1 = JComboBox1;
    AdminDeleteEditUserViewController.Nickname = Nickname;

}    

    public static void loadUserinCombo()
    {
        ListUser la = new ListUser();
        UserXmlFile.readAllUserListFromDataBase(la);
        Iterator listIterator = la.iterator();
        
        JComboBox1.removeAllItems();
        
        while (listIterator.hasNext())
        {
            User actualUser = (User) listIterator.next();
           if (Nickname.equals(actualUser.getNickname())==false){
             String information = actualUser.getLastName()+ ", " + actualUser.getName()+ ", Username"+ " : " + actualUser.getNickname();
            
            JComboBox1.addItem(information);  }
            
        }
     JComboBox1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                            String prueba= JComboBox1.getSelectedItem().toString();
                            String[] nickname=prueba.split(" : ");
                            System.out.println("Username: " + nickname[1]);
                            User usercombo=la.searchUser(nickname[1]);
                            if (usercombo != null){
                                Nickname2 = usercombo.getNickname();
                             }
		         
			}
		});
    }
    
    public static void deleteUser()
    {
        UserXmlFile.removeUserFromDataBase(Nickname2);
    
    }

    public static String getNickname() {
        return Nickname;
    }

    public static void setNickname(String Nickname) {
        AdminDeleteEditUserViewController.Nickname = Nickname;
    }

    public static String getNickname2() {
        return Nickname2;
    }

    public static void setNickname2(String Nickname2) {
        AdminDeleteEditUserViewController.Nickname2 = Nickname2;
    }
    
}
