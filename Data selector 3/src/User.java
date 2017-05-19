
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;       // My imports 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jackg
 */
public class User {

    protected String username; // Declaring string username
    protected String password; // Declaring string password
    protected String email; // Declaring string email 
    private ArrayList<String> users = new ArrayList<String>(); // creating arraylist of strings called users
    File file = new File("Users.txt"); // creating file object with file name 
     JFrame frame = new JFrame(); // declaring a new frame for dialog box

    public User() { // user constructor 
    }

    public User(String username, String password, String email) { //user constructor with parameters 
        this.username = username; // assigning variable username to parameter for username passed
        this.password = password; // assigning variable username to parameter for password passed
        this.email = email; // assigning variable username to parameter for email passed

        try {

            try (Scanner myScanner = new Scanner(file)) { // creating scanner object and assigning the file object so scan
                while (myScanner.hasNext()) { // while the scanner has next word to scan 
                    users.add(myScanner.next()); // add the word to the arraylist user 
                  //  System.out.println(users); // testing the scanner and arraylist to see what it was adding 
        

                }
                myScanner.close(); // close if no more words to scan 
            }
        } catch (FileNotFoundException ex) { // catch if file is not found 
           JOptionPane.showMessageDialog(frame, "File not found"); // diaglog box to let user know that the file was not found, helps them identifty the problem and also the developer.
        }
    }

    public boolean passwordMatch(String password) { // boolean method called password match with string parameter
        for (String element : users) { // loops through the arraylist users from start to finish 
            if (users.contains(password)) { // if the arraylist contains the string 'password' that was passed 
                return true; // returns true if users contains string
            }
        }
        return false; // if users does not contain string, return false 
    }

    public void setUser(String username) { // Method called set user with stirng parameter
        this.username = username; // assigning username variables to the string that was passed 
      //  System.out.println("set user " + username); // testing to see if the string passed was correct 
    }

    public String getUser() { // method get user 
        return username;  // returns the username that was set 
    }

    public void storeUser(String username, String password, String email) throws IOException { // store user method throws exception with string parameters 
        StringBuilder sb = new StringBuilder(); // creating string builder object 
        for (int i = 0; i < username.length(); i++) { // loops through the length of the first string passed character by character 
            char c = username.charAt(i); // creating character variable and assigning each character to it loop by loop
            if (c >= 'a' && c <= 'm') { // rot 13 encryption. if character equals a or equals m or is inbetween, then plus that character by 13 letters up the alphabet 
                c += 13;
            } else if (c >= 'A' && c <= 'M') { // rot 13 encryption. if character equals capital A or equals captial M or is inbetween, then plus that character by 13 letters up the alphabet 
                c += 13;
            } else if (c >= 'n' && c <= 'z') { // rot 13 encryption. if character equals n or equals z or is inbetween, then minus that character by 13 letters up the alphabet 
                c -= 13;
            } else if (c >= 'N' && c <= 'Z') { // rot 13 encryption. if character equals capital N or equals captial Z or is inbetween, then minus that character by 13 letters up the alphabet 
                c -= 13;
            }
            sb.append(c); // append each character to the string builder loop by loop 
          
        }
        sb.append(" "); // after first string is done, seperate by a space in string builder.
        for (int i = 0; i < password.length(); i++) { // loops through the length of the second string passed character by character 
            char c = password.charAt(i); // creating character variable and assigning each character to it loop by loop
            if (c >= 'a' && c <= 'm') { // rot 13 encryption. if character equals a or equals m or is inbetween, then plus that character by 13 letters up the alphabet 
                c += 13;
            } else if (c >= 'A' && c <= 'M') { // rot 13 encryption. if character equals capital A or equals captial M or is inbetween, then plus that character by 13 letters up the alphabet 
                c += 13;
            } else if (c >= 'n' && c <= 'z') { // rot 13 encryption. if character equals n or equals z or is inbetween, then minus that character by 13 letters up the alphabet 
                c -= 13;
            } else if (c >= 'N' && c <= 'Z') { // rot 13 encryption. if character equals capital N or equals captial Z or is inbetween, then minus that character by 13 letters up the alphabet
                c -= 13;
            }
            sb.append(c); // append each character to the string builder loop by loop 

        }

        BufferedWriter output = new BufferedWriter(new FileWriter(file, true)); // instantiate my buffered write and file write also open it in append mode.

        output.write(sb.toString()); // writing the string builder to my file
        output.newLine(); // write new line in file
        output.write(email); // write my email variable to my file
        output.newLine(); // write new line in file
        output.close(); // close file
    }

    public void emailPassword(String email) { // emailPassword method with string parameter
        this.email = email; // set the email parameter passed to the variable email 
    }

    public void changeUserDetails(String email, String name, String pass) {
        this.email = email; // set the email parameter passed to the variable email 
        this.username = name; // set the username parameter passed to the variable username
        this.password = pass; // set the password parameter passed to the vairiable password
    }

    boolean checkUserExist(String username) { // checkUserExist boolean method with string parameter 
        StringBuilder sb = new StringBuilder(); // creaint string builder object 
        for (int i = 0; i < users.size(); i++) { // loop through the size of the arraylist index by index
            String getUser = users.get(i); // creating a new string and assigning the index value to it 
            for (int y = 0; y < getUser.length(); y++) { // looping through the new string character by character
                char c = getUser.charAt(y);  // creating character variable and assigning each character to it loop by loop
                if (c >= 'a' && c <= 'm') { // rot 13 decryption. if character equals a or equals m or is inbetween, then plus that character by 13 letters up the alphabet 
                    c += 13;
                } else if (c >= 'A' && c <= 'M') { // rot 13 decryption. if character equals capital A or equals captial M or is inbetween, then minus that character by 13 letters up the alphabet 
                    c -= 13;
                } else if (c >= 'n' && c <= 'z') { // rot 13 decryption. if character equals n or equals z or is inbetween, then minus that character by 13 letters up the alphabet 
                    c -= 13;
                } else if (c >= 'N' && c <= 'Z') { // rot 13 decryption. if character equals capital N or equals captial Z or is inbetween, then minus that character by 13 letters up the alphabet
                    c -= 13;
                    // Decrypts the usernames in the file to check if entered username already exists 
                }
                sb.append(c); // appends character by character to the string builder 

            }
            sb.append(";"); // seperates strings by delimeter ';'
           

        }
        String[] userArray = sb.toString().split(";"); //Creating array of strings and assigning the values of the string builder split by the delimeter ';' to it 
       Collections.addAll(users, userArray);  // adding to the arraylist users, the arraylist that i just created 
      

        for (String element : users) { // looping through the updated arraylist
            if (users.contains(username)) { // checking if the username entered is in the arraylist 
                return true; // returns true if it contains it.
            }
        }
        return false; // returns false if it does not. 
    }

}
