import javax.swing.*;

public class app{


    public static void showWindow(){
        JFrame frame = new JFrame("Window 1");
        frame.setBounds(100,100,100,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

    public static void main(String[] args){

        showWindow();
    }

}