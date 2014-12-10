/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shoop.model;
import java.io.Serializable;
import java.util.Comparator;

/**Class compare nickname from the data base
 * @author Francisco Gonzalez
 */
public class NickNameComparator implements Comparator,Serializable {

    @Override
    public int compare(Object o1, Object o2) {
       
      int  result = ((User)o1).getNickname().compareTo(((User)o2).getNickname());
   if (result==1)
   {return 1;}
     
          return -1; //para excluir el repetido
        
        
    
    }
    
}
