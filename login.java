import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class login implements ActionListener {

    static String Path = "....."
    final static String filePath = Path;
    
    public static JLabel userLabel;
    public static JTextField userText;
    public static JLabel passwordLabel;
    public static JTextField passwordText;
    public static JButton LoginButton;
    public static JButton RegisterButton;
    static HashMap<String,String> Info = new HashMap<>();
    static File file = new File(filePath);

    login(HashMap<String,String> InfoLogin, File file){
    JPanel panel = new JPanel();
    JFrame frame = new JFrame("Login");
    frame.setSize(500,500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel);
        
    panel.setLayout(null);


    
    //------------------------------------------------------//
    // USER
    //------------------------------------------------------//
    userLabel = new JLabel("Usermame:");
    userLabel.setBounds(100,30,150,25);
    panel.add(userLabel);
    
    userText = new JTextField(20);
    userText.setBounds(185,30,165,25);
    panel.add(userText);
        
    //------------------------------------------------------//
    // PASWWORD
    //------------------------------------------------------//
    passwordLabel = new JLabel("Password:");
    passwordLabel.setBounds(100,60,150,25);
    panel.add(passwordLabel);
    
    passwordText = new JPasswordField(20);
    passwordText.setBounds(185,60,165,25);
    panel.add(passwordText);
    
    //------------------------------------------------------//
    // LOGIN
    //------------------------------------------------------//
        
    LoginButton = new JButton("Login");
    LoginButton.setBounds(100,100,125,25);
    //LoginButton.addActionListener(new login());
    panel.add(LoginButton);
    LoginButton.addActionListener(this);
    
    //------------------------------------------------------//
    // REGISTER
    //------------------------------------------------------//
    
    RegisterButton = new JButton("Register");
    RegisterButton.setBounds(250,100,125,25);
    panel.add(RegisterButton);
    RegisterButton.addActionListener(this);
    
    frame.setVisible(true);
        
    //------------------------------------------------------//
    // ERRORS
    //------------------------------------------------------//
    
    JLabel errorLabel1 = new JLabel("");
    errorLabel1.setBounds(100,150,150,25);
    panel.add(errorLabel1);
    
    JLabel errorLabel2 = new JLabel("");
    errorLabel1.setBounds(100,150,150,25);
    panel.add(errorLabel1);
        
    JLabel errorLabel3 = new JLabel("");
    errorLabel1.setBounds(100,150,150,25);
    panel.add(errorLabel1);
}
    
void Login(HashMap<String,String> infoLogin, File file){
    
        String username = userText.getText();
        String password = passwordText.getText();
        
        
        if(infoLogin.containsKey(username)){
            for (String i : infoLogin.keySet()) {
                if(i.equals(username)){
                    if(infoLogin.get(i).equals(password)){
                        System.out.println("Right!");
                    }
                    else{
                        System.out.println("Wrong Password!");
                    }
                }
              }
            }
            else{
            System.out.println("Username not found!");
        }
    }

    
    HashMap<String,String> Register(HashMap<String,String> infoLogin,File file){

        
        String username = userText.getText();
        String password = passwordText.getText();

        if(infoLogin.containsKey(username)){
            System.out.println("Username already used!");
        }
        else{
            infoLogin.put(username,password);
            System.out.println("Sucess!");



            BufferedWriter bf = null;
  
        try {
  
            // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));
  
            // iterate map entries
            for (Map.Entry<String, String> Info :
            Info.entrySet()) {
  
                // put key and value separated by a colon
                bf.write(Info.getKey() + ":"
                         + Info.getValue());
  
                // new line
                bf.newLine();
            }
  
            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
  
            try {
  
                // always close the writer
                bf.close();
            }
            catch (Exception e) {
            }
        }
            //System.out.println(infoLogin);
            
        }
        
        return infoLogin;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == RegisterButton){
            Register(Info, file);
            
        }
        
        if(e.getSource() == LoginButton){
            
            Login(Info, file);
            
        }
    }
    
    public static Map<String, String> HashMapFromTextFile()
    {
  
        Map<String, String> map
            = new HashMap<String, String>();
        BufferedReader br = null;
  
        try {
  
            // create file object
            File file = new File(filePath);
  
            // create BufferedReader object from the File
            br = new BufferedReader(new FileReader(file));
  
            String line = null;
  
            // read file line by line
            while ((line = br.readLine()) != null) {
  
                // split the line by :
                String[] parts = line.split(":");
  
                // first part is name, second is number
                String name = parts[0].trim();
                String number = parts[1].trim();
  
                // put name, number in HashMap if they are
                // not empty
                if (!name.equals("") && !number.equals(""))
                    map.put(name, number);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
  
            // Always close the BufferedReader
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                };
            }
        }
  
        return map;
    }
    
    
    public static void main(String[] args){

        //Read HashMap from a file
        
        Map<String, String> mapFromFile
            = HashMapFromTextFile();

        for (Map.Entry<String, String> entry :
            mapFromFile.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
       }
   


        login boas = new login(Info, file);


        
    
    // Save Hashmap to a file
    
    }
}
