import javax.swing.*;
import java.awt.event.*;

public class login implements ActionListener {
    

    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JTextField passwordText;
    private static JButton LoginButton;
    private static JButton RegisterButton;

    public static void main(String[] args){

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
        LoginButton.addActionListener(new login());
        panel.add(LoginButton);

        //------------------------------------------------------//
        // REGISTER
        //------------------------------------------------------//

        RegisterButton = new JButton("Register");
        RegisterButton.setBounds(250,100,125,25);
        panel.add(RegisterButton);

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

    @Override
    public void actionPerformed(ActionEvent e){
        String username = userText.getText();
        String password = passwordText.getText();
        System.out.println(username + "," + password);

        //TODO VERIFICAR register.txt

    }
}
