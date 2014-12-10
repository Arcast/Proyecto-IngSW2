/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shoop.model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.JDOMParseException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/** Class reads the information from UserXML
 * @author Francisco Gonzalez
 */
public class UserXmlFile
{
    /**Method read user information from data base
     * 
     * @param user
     * @return 
     */
    
public static boolean removeUserFromDataBase(String Pnickname)
    {
        User            user = null ;
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          name, lastName,email, password,birthDay,id,nickname,rol;
      

        
        

        boolean         found = false;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.USER_XML_PATH);

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (!found && pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                name            = child.getAttributeValue(Util.USER_NAME_TAG);
                lastName        = child.getAttributeValue(Util.USER_LASTNAME_TAG);
                email    =        child.getAttributeValue(Util.USER_EMAIL_TAG);
                password =        child.getAttributeValue(Util.USER_PASSWORD_TAG);
                birthDay =        child.getAttributeValue(Util.USER_BIRTHDAY_TAG);
                id =              child.getAttributeValue(Util.USER_ID_TAG);
                nickname =        child.getAttributeValue(Util.USER_NICKNAME_TAG);
                rol =             child.getAttributeValue(Util.USER_ROL_TAG);
               
                
                if(Pnickname.equals(nickname))
                {   
                    
                    root.removeContent(root.indexOf(child));
                    System.out.println("Borre");
                    
                    try
                    {
                        Format format = Format.getPrettyFormat();

                        /* Se genera un flujo de salida de datos XML */
                        XMLOutputter out = new XMLOutputter(format);

                        /* Se asocia el flujo de salida con el archivo donde se guardaran los datos */
                        FileOutputStream file = new FileOutputStream(Util.USER_XML_PATH);

                        /* Se manda el documento generado hacia el archivo XML */
                        out.output(doc,file);

                        /* Se limpia el buffer ocupado por el objeto file y se manda a cerrar el archivo */
                        file.flush();
                        file.close();
                    }
                    catch(Exception e)
                    {
                     e.printStackTrace();
                    }

                    user = new User(name, lastName,  nickname,password ,id,email,birthDay,rol);
                    
                    found = true;
                }
                else
                { user= null;
                    if (name == null)
                        System.out.println(Util.ERROR_USER_NAME_TAG);

                    if (lastName == null)
                        System.out.println(Util.ERROR_USER_LASTNAME_TAG);
                    
                    if (nickname == null)
                        System.out.println(Util.ERROR_USER_NICKNAME_TAG);
                    
                    pos++;
                }
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

        return found;
    }
    
    public static boolean readUserFromDataBase(User user)
    {
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          name, lastName, secondLastName, nickname,email, password,id,birthDay;
        boolean         found = false;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.USER_XML_PATH);

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (!found && pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                name            = child.getAttributeValue(Util.USER_NAME_TAG);
                lastName        = child.getAttributeValue(Util.USER_LASTNAME_TAG);
                secondLastName =  child.getAttributeValue(Util.USER_SECONDLASTNAME_TAG);
                email    =        child.getAttributeValue(Util.USER_EMAIL_TAG);
                password =        child.getAttributeValue(Util.USER_PASSWORD_TAG);
                birthDay =        child.getAttributeValue(Util.USER_BIRTHDAY_TAG);
                id =          child.getAttributeValue(Util.USER_ID_TAG);
                nickname =        child.getAttributeValue(Util.USER_NICKNAME_TAG);

                
                

                if(name != null             && name.equals(user.getName()) &&
                   lastName != null         && lastName.equals(user.getLastName()) &&
                   nickname != null               && nickname.equals(user.getNickname())&&
                   secondLastName != null && secondLastName.equals(user.getSecondLastName())&&
                        email != null &&
                        password !=null && password.equals(user.getPassword())&&
                        id !=null && id.equals(user.getPassword())&&
                        //status != null && status.equals(user.isStatus())&&
                        birthDay !=null && birthDay.equals(user.getBirthDay()))
                    
                {
                    found = true;
                }
                else
                {
                    if (name == null)
                        System.out.println(Util.ERROR_USER_NAME_TAG);

                    if (lastName == null)
                        System.out.println(Util.ERROR_USER_LASTNAME_TAG);
                   
                    if (secondLastName==null)
                        System.out.println(Util.ERROR_USER_SECONDLASTNAME_TAG);

                    if (nickname == null)
                        System.out.println(Util.ERROR_USER_NICKNAME_TAG);
                     
                    if (email==null)
                         System.out.println(Util.ERROR_USER_EMAIL_TAG);
                    
                    if (password == null)
                         System.out.println(Util.ERROR_USER_PASSWORD_TAG);
                    
                    if  (birthDay == null)
                         System.out.println(Util.ERROR_USER_BIRTHDAY_TAG);
                    
                    pos++;
                }
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

        return found;
    }
    
        public static User readUserFromJDrawDataBase(String nicknameuser) throws ParseException 
    {
        User            user = null;
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          name, firstlastName, secondLastName, nickname, email, password, id, birthdate,rol;
        boolean         found = false;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.USER_XML_PATH);

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (!found && pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                name            = child.getAttributeValue(Util.USER_NAME_TAG);
                firstlastName   = child.getAttributeValue(Util.USER_LASTNAME_TAG);
                secondLastName  = child.getAttributeValue(Util.USER_SECONDLASTNAME_TAG);
                nickname        = child.getAttributeValue(Util.USER_NICKNAME_TAG);
                email           = child.getAttributeValue(Util.USER_EMAIL_TAG);
                birthdate       = child.getAttributeValue(Util.USER_BIRTHDAY_TAG);
                password        = child.getAttributeValue(Util.USER_PASSWORD_TAG);
                id              = child.getAttributeValue(Util.USER_ID_TAG);
                rol             = child.getAttributeValue(Util.USER_ROL_TAG);
                
                

                if(name != null && firstlastName != null && secondLastName != null &&
                   nickname.equals(nicknameuser))
                {
                    user = new User(name, firstlastName, nickname,password,id,email,birthdate,rol);
                    found = true;
                }
                else
                {
                    if (name == null)
                        System.out.println(Util.ERROR_USER_NAME_TAG);

                    if (firstlastName == null)
                        System.out.println(Util.ERROR_USER_LASTNAME_TAG);
                    
                    if (nickname == null)
                        System.out.println(Util.ERROR_USER_NICKNAME_TAG);
                    
                    if (secondLastName == null)
                        System.out.println(Util.ERROR_USER_SECONDLASTNAME_TAG);
                    
                  
                    
                    
                    pos++;
                }
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

        return user;
    }
    
   /*Method read user information from data base
    *
    */
    public static void readAllUserListFromDataBase(ListUser UserList)
    {
       
        User            user = null;
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          name, lastName, rol,email, password,birthDay,id,nickname;

        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.USER_XML_PATH);

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                name            = child.getAttributeValue(Util.USER_NAME_TAG);
                lastName        = child.getAttributeValue(Util.USER_LASTNAME_TAG);
                email    =        child.getAttributeValue(Util.USER_EMAIL_TAG);
                password =        child.getAttributeValue(Util.USER_PASSWORD_TAG);
                birthDay =        child.getAttributeValue(Util.USER_BIRTHDAY_TAG);
                id =          child.getAttributeValue(Util.USER_ID_TAG);
                nickname =        child.getAttributeValue(Util.USER_NICKNAME_TAG);
                rol =           child.getAttributeValue(Util.USER_ROL_TAG);
                
                if(name != null && lastName != null && nickname!= null && email !=null && password!= null && id != null && birthDay != null && rol != null)
                {       
                        user = new User(name, lastName, nickname);
                        if(user.getNickname().equals("invent") != true)
                            UserList.addUser(user);
                }
                else
                {if (name == null)
                        System.out.println(Util.ERROR_USER_NAME_TAG);

                    if (lastName == null)
                        System.out.println(Util.ERROR_USER_LASTNAME_TAG);

                    if (nickname == null)
                        System.out.println(Util.USER_NICKNAME_TAG);
                    }
                pos++;
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
    }
        /**Method read user information from data base
     * 
     */
    public static void readAllUsersFromJDrawDataBase(ListUser listuser)
    {
        User            user = null;
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          name, firstlastName, secondLastName, nickname;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.USER_XML_PATH);

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                name            = child.getAttributeValue(Util.USER_NAME_TAG);
                firstlastName        = child.getAttributeValue(Util.USER_LASTNAME_TAG);
                secondLastName             = child.getAttributeValue(Util.USER_SECONDLASTNAME_TAG);
               
                nickname        = child.getAttributeValue(Util.USER_NICKNAME_TAG);

                if(name != null && firstlastName != null && secondLastName != null && nickname != null)
                {
                    user = new User(name, firstlastName, nickname);
                    
                    listuser.addUser(user);
                }
                else
                {
                    if (name == null)
                        System.out.println(Util.ERROR_USER_NAME_TAG);

                    if (firstlastName == null)
                        System.out.println(Util.ERROR_USER_LASTNAME_TAG);

                    if (secondLastName == null)
                        System.out.println(Util.ERROR_USER_SECONDLASTNAME_TAG);
                    
              
                    
                    if (nickname == null )
                        System.out.println(Util.ERROR_USER_NICKNAME_TAG);
                }
                
                pos++;
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
    }
/**Method saves the user information
 * 
 * @param user
 * @return 
 */
    public static String saveUserInDataBase(User user)
    {
        Document    doc;
        Element     root, newChild;

        SAXBuilder  builder = new SAXBuilder();
        if(readUserToWriteOnDataBase(user.getNickname())==true) 
        { return "false:nickname repeated";}

        try
        {
            doc = builder.build(Util.USER_XML_PATH);

            root = doc.getRootElement();

            // Creamos una nueva etiqueta
            newChild = new Element(Util.USER_TAG);

            // Añadimos un atributo
            newChild.setAttribute(Util.USER_NAME_TAG, user.getName());
            newChild.setAttribute(Util.USER_LASTNAME_TAG, user.getLastName());
            newChild.setAttribute(Util.USER_NICKNAME_TAG,user.getNickname());
            newChild.setAttribute(Util.USER_PASSWORD_TAG,user.getPassword());
            newChild.setAttribute(Util.USER_EMAIL_TAG,user.getEmail());
            newChild.setAttribute(Util.USER_BIRTHDAY_TAG,user.getBirthDay());
            newChild.setAttribute(Util.USER_ID_TAG,user.getID());
            newChild.setAttribute(Util.USER_ROL_TAG,user.getRol());

            // La añadimos como hija a una etiqueta ya existente
            root.addContent(newChild);

            try
            {
                Format format = Format.getPrettyFormat();

                /* Se genera un flujo de salida de datos XML */
                XMLOutputter out = new XMLOutputter(format);

                /* Se asocia el flujo de salida con el archivo donde se guardaran los datos */
                FileOutputStream file = new FileOutputStream(Util.USER_XML_PATH);

                /* Se manda el documento generado hacia el archivo XML */
                out.output(doc,file);

                /* Se limpia el buffer ocupado por el objeto file y se manda a cerrar el archivo */
                file.flush();
                file.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

        return "true:Successfuly Registration";
        
    }
    /**method delete a user from data base
     * 
     * @param UserList
     * @param removenickname 
     */
     public static void removeUserListFromDataBase(ListUser UserList, String removenickname)
    {
       
        User            user = null;
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          name, lastName, secondLastName,email, password,birthDay,id,nickname;

        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.USER_XML_PATH);

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                 name            = child.getAttributeValue(Util.USER_NAME_TAG);
                lastName        = child.getAttributeValue(Util.USER_LASTNAME_TAG);
                secondLastName =  child.getAttributeValue(Util.USER_SECONDLASTNAME_TAG);
                email    =        child.getAttributeValue(Util.USER_EMAIL_TAG);
                password =        child.getAttributeValue(Util.USER_PASSWORD_TAG);
                birthDay =        child.getAttributeValue(Util.USER_BIRTHDAY_TAG);
                id       =        child.getAttributeValue(Util.USER_ID_TAG);
                nickname =        child.getAttributeValue(Util.USER_NICKNAME_TAG);

                if(name != null && lastName != null && nickname!= null  &&
                     secondLastName !=null && email !=null && password!= null)
                    
                {     if (nickname.equals(removenickname)!= true) {
                    
                 
                    ListUser Userlist = new ListUser();
                        Userlist.addUser(user);}
                        
            }
                 else
                {if (name == null)
                        System.out.println(Util.ERROR_USER_NAME_TAG);

                    if (lastName == null)
                        System.out.println(Util.ERROR_USER_LASTNAME_TAG);

                    if (nickname == null)
                        System.out.println(Util.USER_NICKNAME_TAG);
                    }
               pos++;
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
    }
    
   /**Read user parameters
    * 
    * @param Pnickaname
    * @return 
    */
       public static User readUser(String Pnickaname)
    {
        User            user = null ;
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          name, lastName,rol, password,birthDay,id,email,nickname;
      
        
        

        boolean         found = false;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.USER_XML_PATH);

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (!found && pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                name            = child.getAttributeValue(Util.USER_NAME_TAG);
                lastName        = child.getAttributeValue(Util.USER_LASTNAME_TAG);
                password =        child.getAttributeValue(Util.USER_PASSWORD_TAG);
                birthDay =        child.getAttributeValue(Util.USER_BIRTHDAY_TAG);
                email    =        child.getAttributeValue(Util.USER_EMAIL_TAG);
                id       =        child.getAttributeValue(Util.USER_ID_TAG);
                nickname =        child.getAttributeValue(Util.USER_NICKNAME_TAG);
                rol      =        child.getAttributeValue(Util.USER_ROL_TAG);
               
                if(Pnickaname.equals(nickname))
                {  
                    
                    user = new User(name, lastName,  nickname,password , id,email, birthDay,rol);
                    
                    found = true;
                }
                else
                { user= null;
                    if (name == null)
                        System.out.println(Util.ERROR_USER_NAME_TAG);

                    if (lastName == null)
                        System.out.println(Util.ERROR_USER_LASTNAME_TAG);
                    
                    if (nickname == null)
                        System.out.println(Util.ERROR_USER_NICKNAME_TAG);
                    
                    pos++;
                }
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

        return user;
    }
       /**method allows the user log in if the password and nickname matches with the saved on the data base
        * 
        * @param Pnickaname
        * @param UPassword
        * @return 
        */
  public static String LogIn(String Pnickaname,String UPassword)
    {
        User            user = null ;
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          name, lastName, secondLastName,email, password,birthDay,addres,nickname,avatar;
        Date            date=new Date();

        
        

        boolean         found = false;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.USER_XML_PATH);

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (!found && pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                name            = child.getAttributeValue(Util.USER_NAME_TAG);
                lastName        = child.getAttributeValue(Util.USER_LASTNAME_TAG);
                secondLastName =  child.getAttributeValue(Util.USER_SECONDLASTNAME_TAG);
                email    =        child.getAttributeValue(Util.USER_EMAIL_TAG);
                password =        child.getAttributeValue(Util.USER_PASSWORD_TAG);
                birthDay =        child.getAttributeValue(Util.USER_BIRTHDAY_TAG);
                addres =        child.getAttributeValue(Util.USER_ID_TAG);
                nickname =        child.getAttributeValue(Util.USER_NICKNAME_TAG);
              
                if(Pnickaname.equals(nickname))
                {   
                    if(UPassword.equals(password))
                    {
                        return "TRUE";
                    }
                    else
                    {
                        return "WRONG PASSWORD";
                    }
                    
                }
                else
                { 
                    pos++;
                }
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

        return "FALSE1";
    }
              
         /**Method check the user information from the data base
          * 
          * @param Pnickname
          * @return 
          */     
              public static boolean checkUserFromDataBase(String Pnickname)
    {
        User            user = null ;
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          name, lastName,email, password,birthDay,id,nickname,rol;
      

        
        

        boolean         found = false;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.USER_XML_PATH);

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (!found && pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                 name            = child.getAttributeValue(Util.USER_NAME_TAG);
                lastName        = child.getAttributeValue(Util.USER_LASTNAME_TAG);
                email    =        child.getAttributeValue(Util.USER_EMAIL_TAG);
                password =        child.getAttributeValue(Util.USER_PASSWORD_TAG);
                birthDay =        child.getAttributeValue(Util.USER_BIRTHDAY_TAG);
                id =        child.getAttributeValue(Util.USER_ID_TAG);
                nickname =        child.getAttributeValue(Util.USER_NICKNAME_TAG);
                rol =             child.getAttributeValue(Util.USER_ROL_TAG);
               
                
                if(Pnickname.equals(nickname))
                {   
                    
                    user = new User(name, lastName,  nickname,password ,id,email,birthDay,rol);
                    
                    found = true;
                }
                else
                { user= null;
                    if (name == null)
                        System.out.println(Util.ERROR_USER_NAME_TAG);

                    if (lastName == null)
                        System.out.println(Util.ERROR_USER_LASTNAME_TAG);
                    
                    if (nickname == null)
                        System.out.println(Util.ERROR_USER_NICKNAME_TAG);
                    
                    pos++;
                }
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

        return found;
    }

    /**
     * 
     * @param Nickname
     * @return 
     */
       public static boolean readUserToWriteOnDataBase(String Nickname)
       {
        User            User = null;
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          UNickname;
        boolean         found = false;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.USER_XML_PATH);
                    

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (!found && pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                UNickname        = child.getAttributeValue(Util.USER_NICKNAME_TAG);

                if(UNickname != null && UNickname.equals(Nickname))
                {
                    found = true;
                }
                else
                {
                    if (UNickname == null)
                        System.out.println(Util.ERROR_USER_NICKNAME_TAG);
                    pos++;
                }
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
        }

        return found;
        
        
        
        
    }
       
       
        public static boolean ModifyUser(User user)
    {
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          Niickname;
        boolean         found = false;
        int             pos = 0;
        Date date =      new Date();

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.USER_XML_PATH);

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (!found && pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                Niickname  = child.getAttributeValue(Util.USER_NICKNAME_TAG);
               String date1 = child.getAttributeValue(Util.ERROR_USER_BIRTHDAY_TAG);

                if(Niickname != null && Niickname.equals(user.getNickname())) 
                    
                {
                    
            child.setAttribute(Util.USER_NAME_TAG, user.getName());
            child.setAttribute(Util.USER_LASTNAME_TAG, user.getLastName());;
            child.setAttribute(Util.USER_NICKNAME_TAG,user.getNickname());
            child.setAttribute(Util.USER_PASSWORD_TAG,user.getPassword());
            child.setAttribute(Util.USER_EMAIL_TAG,user.getEmail());
            child.setAttribute(Util.USER_BIRTHDAY_TAG,user.getBirthDay());
            child.setAttribute(Util.USER_ID_TAG,user.getID());
            child.setAttribute(Util.USER_ROL_TAG,user.getRol());

             
            
                    found = true;
                }
                else
                {
                    if (Niickname == null)
                        System.out.println(Util.ERROR_USER_NICKNAME_TAG);                
                    pos++;
                }
            }
             try
            {
                Format format = Format.getPrettyFormat();

                /* Se genera un flujo de salida de datos XML */
                XMLOutputter out = new XMLOutputter(format);

                /* Se asocia el flujo de salida con el archivo donde se guardaran los datos */
                FileOutputStream file = new FileOutputStream(Util.USER_XML_PATH);

                /* Se manda el documento generado hacia el archivo XML */
                out.output(doc,file);

                /* Se limpia el buffer ocupado por el objeto file y se manda a cerrar el archivo */
                file.flush();
                file.close();
            }
             catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        return found;
    }
     /**allows the log in if the user and password has matches from the users in data base
      * 
      * @param Pnickaname
      * @param Password
      * @return 
      */   
               public static User logIn(String Pnickaname,String Password)
    {
        User             user = null ;
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String       name, lastName, rol, password,birthDay,id,nickname,email;
        Date           date=new Date();

        
        

        boolean         found = false;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.USER_XML_PATH);

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (!found && pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                 name            = child.getAttributeValue(Util.USER_NAME_TAG);
                lastName        = child.getAttributeValue(Util.USER_LASTNAME_TAG);
                password =        child.getAttributeValue(Util.USER_PASSWORD_TAG);
                birthDay =        child.getAttributeValue(Util.USER_BIRTHDAY_TAG);
                email =           child.getAttributeValue(Util.USER_EMAIL_TAG);
                id =        child.getAttributeValue(Util.USER_ID_TAG);
                nickname =        child.getAttributeValue(Util.USER_NICKNAME_TAG);
                rol =             child.getAttributeValue(Util.USER_ROL_TAG);
                
                
                if(Pnickaname.equals(nickname) && Password.equals(password))
                {   
                    
                    user = new User(name, lastName,  nickname,password ,id ,email,birthDay,rol);
                    
                    found = true;
                }
                else
                { user= null;
                    if (name == null)
                        System.out.println(Util.ERROR_USER_NAME_TAG);

                    if (lastName == null)
                        System.out.println(Util.ERROR_USER_LASTNAME_TAG);
                    
                    if (nickname == null)
                        System.out.println(Util.ERROR_USER_NICKNAME_TAG);
                    
                    pos++;
                }
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

        return user;
    }
    

       public static boolean Finally(User user)
    {
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          Niickname;
        boolean         found = false;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.USER_XML_PATH);

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (!found && pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                Niickname        = child.getAttributeValue(Util.USER_NICKNAME_TAG);

                if(Niickname != null && Niickname.equals(user.getNickname()) )
                {
            child.setAttribute(Util.USER_NAME_TAG, user.getName());
            child.setAttribute(Util.USER_LASTNAME_TAG, user.getLastName());
            child.setAttribute(Util.USER_SECONDLASTNAME_TAG, user.getSecondLastName());
            child.setAttribute(Util.USER_NICKNAME_TAG,user.getNickname());
            child.setAttribute(Util.USER_PASSWORD_TAG,user.getPassword());
            child.setAttribute(Util.USER_BIRTHDAY_TAG,user.getBirthDay());
            child.setAttribute(Util.USER_ID_TAG,user.getID());
             
            
                    found = true;
                }
                else
                {
                    if (Niickname == null)
                        System.out.println(Util.ERROR_USER_NICKNAME_TAG);                
                    pos++;
                }
            }
             try
            {
                Format format = Format.getPrettyFormat();

                /* Se genera un flujo de salida de datos XML */
                XMLOutputter out = new XMLOutputter(format);

                /* Se asocia el flujo de salida con el archivo donde se guardaran los datos */
                FileOutputStream file = new FileOutputStream(Util.USER_XML_PATH);

                /* Se manda el documento generado hacia el archivo XML */
                out.output(doc,file);

                /* Se limpia el buffer ocupado por el objeto file y se manda a cerrar el archivo */
                file.flush();
                file.close();
            }
             catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        return found;
    }
    }
    
     
     
     

      
                    
                        
                    
                    
                   
                
            
        
       