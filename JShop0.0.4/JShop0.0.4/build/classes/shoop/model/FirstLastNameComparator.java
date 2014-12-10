/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shoop.model;

import java.io.Serializable;
import java.util.Comparator;

/**Class to compare firstlastname of user
 * @author Pedro Apostol
 * @author Unai Lecue
 * @author Francisco Gonzalez

 */
public class FirstLastNameComparator implements Comparator,Serializable
{
 /**Method that returns the largest surname
 * @param firstObject 
 * @param secondObject
 * @return int 
 * 
 */
    @Override

    public int compare(Object firstObject, Object secondObject)
    {
        int result = ((User) firstObject).getLastName().compareTo(((User) secondObject).getLastName());
        
        if (result <= 0)
            return -1;
        
        return 1;
    }
}
    

