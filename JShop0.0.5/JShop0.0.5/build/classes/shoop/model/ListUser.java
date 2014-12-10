/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shoop.model;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This its the class for the list of all users in the system
 * @author Francisco Gonzalez
 */
public class ListUser implements Serializable
{
     SortedSet <User> listUser;
    Comparator sortedComparator; 
    /**Method to initialize ListUser
     * 
     * @return iterator of users
     */
    public ListUser()
    {
        sortedComparator = new FirstLastNameComparator();
        this.listUser = new TreeSet(sortedComparator);
    }
    /**Method to go over the list of users
     * 
     * @return iterator of users
     */
    public Iterator iterator()
    {
        return this.listUser.iterator();
    }
     /**Method to add a user to the list of users
     * @param user
     * @return boolean if the user was added
     */
    public boolean addUser(User user)
    {
    return this.listUser.add(user);
    }
    /**Method to remove a user to the list of users
     * @param user
     * @return boolean if the user was remove
     */
    public boolean removeUser(User user)
    {
        return this.listUser.remove(user);
    }
    /**Method to search a user to the list of users
     * @param nicknameuser
     * @return User
     */
    public User  searchUser(String nicknameuser)
    {
         Iterator    iterator;
        User     actualUser=null;
        
        iterator = this.listUser.iterator();
        while (iterator.hasNext())
        {
            actualUser = (User) iterator.next();
            if (actualUser.getNickname().equals(nicknameuser)){
                return actualUser;
            }
        }
        return actualUser;
    }
    /**Method to print the list of users
     * 
     * @return the list of users
     */
    public void printUsers()
    {
        Iterator    iterator;
        User     actualUser;
        
        iterator = this.listUser.iterator();
        
        while (iterator.hasNext())
        {
            actualUser = (User) iterator.next();
            System.out.println("name : " + actualUser.getName());
        
    }
}
}