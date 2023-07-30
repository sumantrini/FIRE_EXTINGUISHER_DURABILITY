import javax.swing.*;
import java.awt.event.*;


/* <applet code="fire" width=800 height=250>
</applet>
*/

public class fire extends JApplet implements ActionListener{
    JTextField t1,t2,t3;
    JButton b;
    JLabel l1,l2,l3,l4;
    public void init(){
        setLayout(null);
        l1 = new JLabel("Foam Loss rate(X%): ");
        l1.setBounds(40,20,130,40);
        add(l1);
        t1 = new JTextField();
        t1.setText("");
        t1.setBounds(170,20,200,40);
        add(t1);
        l2 = new JLabel("Threshold rate(Y%): ");
        l2.setBounds(40,69,130,40);
        add(l2);
        t2 = new JTextField();
        t2.setText("");
        t2.setBounds(170,69,200,40);
        add(t2);
        l3 = new JLabel("Weeks left: ");
        l3.setBounds(40,128,90,40);
        add(l3);
        t3 = new JTextField();
        t3.setText("");
        t3.setBounds(170,128,430,40);
        add(t3);
        l4 = new JLabel("Weeks");
        l4.setBounds(600,128,80,40);
        add(l4);
        b = new JButton("CALCULATING");
        b.setBounds(138,180,150,50);
        add(b);
        b.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b){
            double lr,th,weeks;
            lr = Double.parseDouble(t1.getText());
            th = Double.parseDouble(t2.getText());

            try{
                if(lr>100){
                    if(th>100)
                    {
                        throw new Exception("Enter the value of x and y must be within 100");
                    }
                    else
                    if(th<=0){
                        throw new Exception("Enter the value of x must be within 100 and value of y must be greater than 0");
                    }
                    else{
                        throw new Exception("Enter the value of x must be within 100");
                    }
                }
                else
                if(lr<=0){
                    if(th<=0){
                        throw new Exception("Enter the value of x and y must be greater than 0");
                    }
                    else
                    if(th>100){
                        throw new Exception("Enter the value of x must be greater than 0 and value of y must be within 100");
                    }
                    else{
                        throw new Exception("Enter the value of x must be greater than 0");
                    }
                }
                else
                if(th>100){
                    throw new Exception("Enter the value of y must be within 100");
                }
                else
                if(th<=0){
                    throw new Exception("Enter the value of y must be greater than 0");
                }
                else{
                    double amountLeft = 100;
                    double days = 0;
                    lr /= 100.0;

                    while (th<=amountLeft) {
                        double amountlost=amountLeft*lr;
                        amountLeft -= amountlost;
                        days += 1.0;
                    }
                    weeks = days / 7.0;
                    t3.setText(""+weeks);
                }
            }catch (Exception e1){
                t3.setText(e1.getMessage());
            }
        }
    }
}