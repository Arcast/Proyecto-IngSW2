
package shoop.model;

import java.util.Date;

/** Class used to define Users 
 * @author Francisco Gonzalez
 * 
 * @param Name
 * @param LastName
 * @param SecondLastName
 * @param Nickname
 * @param Password
 * @param ID
 * @param email
 * @param Birthday
 */
public class User 
{
    private String Name;
    private String LastName;
    private String SecondLastName;
    private String Nickname;
    private String Password;
    private String ID;
    private String Email;
    private String BirthDay;
   
/**Method define the user parameters
 * 
 * @param Name
 * @param LastName
 * @param SecondLastName
 * @param Nickname
 * @param Password
 * @param ID
 * @param Email
 * @param BirthDay 
 */
    public User(String Name, String LastName, String Nickname, String Password, String ID,String Email,String BirthDay) {
        this.Name = Name;
        this.LastName = LastName;
        this.Nickname = Nickname;
        this.Password = Password;
        this.ID = ID;
        this.Email = Email;
        this.BirthDay = BirthDay;
     
    }
    
        public User(String name, String firstLastName, String nickname) {
        this.Name = name;
        this.LastName = firstLastName;
        this.Nickname = nickname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getSecondLastName() {
        return SecondLastName;
    }

    public void setSecondLastName(String SecondLastName) {
        this.SecondLastName = SecondLastName;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String Nickname) {
        this.Nickname = Nickname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(String BirthDay) {
        this.BirthDay = BirthDay;
    }



    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }


}
