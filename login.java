import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class login implements ActionListener {
    
    public static JLabel userLabel;
    public static JTextField userText;
    public static JLabel passwordLabel;
    public static JTextField passwordText;
    public static JButton LoginButton;
    public static JButton RegisterButton;
    static HashMap<String,String> Info = new HashMap<>();

    login(HashMap<String,String> InfoLogin){
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
    
    void Login(HashMap<String,String> infoLogin){

        HashMap<String,String> copy = new HashMap<>();
        copy = infoLogin;

        String username = userText.getText();
        String password = passwordText.getText();

        //System.out.println(copy);
        
        if(copy.containsKey(username)){
            for (String i : copy.keySet()) {
                if(i.equals(username)){
                    if(copy.get(i).equals(password)){
                        System.out.println("Right!");
                    }
                    else{
                        System.out.println("Wrong Password!");
                    }
                }
              }
        }
        else{
            System.out.println("Username Invalid");
        }
    }


    HashMap<String,String> Register(HashMap<String,String> infoLogin){

        HashMap<String,String> copy = new HashMap<>();
        copy = infoLogin;

        String username = userText.getText();
        String password = passwordText.getText();

        if(copy.containsKey(username)){
            System.out.println("Username already used");
        }
        else{
            infoLogin.put(username,password);
            System.out.println("Sucess!");
            //System.out.println(infoLogin);

        }
        
        return copy;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == RegisterButton){
            Register(Info);
    
        }
    
        if(e.getSource() == LoginButton){

            Login(Info);
    
        }
    }
    


    public static void main(String[] args){

    //Read HashMap from a file

    login boas = new login(Info);
    
    // Save Hashmap to a file
    
    }
}
