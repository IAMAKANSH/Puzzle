package puzzle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Step-3
public class Instructions extends JFrame implements ActionListener {

    JButton start;
    public Instructions()
    {
        //set the frame size wrt to laptop/desktop screen
        setBounds(200,100,1000,500);   /** dleft,duppersideOfScreen,length,breadth**/
        //set the background of the frame
        getContentPane().setBackground(Color.BLACK);
        //set the visibility true so that frame is visible
        setVisible(true);
        //it is set null so that custom label/textfield/button can be added
        setLayout(null);

        //Label instance is created with the title
        JLabel instructionHeading=new JLabel("Instructions!");
        //label is defined wrt to frame
        instructionHeading.setBounds(380,40,300,30);
        //fondType, fontStyle and size is defined
        instructionHeading.setFont(new Font("Viner Hand ITC",Font.BOLD,30));
        //font color is defined
        instructionHeading.setForeground(Color.RED);
        //added in the frame
        add(instructionHeading);

        //Label instance is created with the title
        JLabel jLabelInstruction=new JLabel();
        //labelText is defined as html content
        jLabelInstruction.setText("<html>"+
                        "1. Please read the instructions carefully" + "<br><br>" +
                "2. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
                "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
                "4. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                "5. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
                "6. Please space bar to start the quiz" + "<br><br>" +
                "<html>");
        //label is defined wrt to frame
        jLabelInstruction.setBounds(260,100,500,270);
        //Font color is set
        jLabelInstruction.setForeground(Color.RED);
        //Background is set
        jLabelInstruction.setBackground(Color.black);
        //FontType,FontStyle and size is dedined
        jLabelInstruction.setFont(new Font("Tahoma",Font.BOLD,12));
        //Border is set
        jLabelInstruction.setBorder(BorderFactory.createBevelBorder(1));
        //Added to the frame
        add(jLabelInstruction);

        //Button is added
        start=new JButton("Press the space bar to continue");
        //Button boundary is defined wrt to frame
        start.setBounds(300,400,400,25);
        //FontType,FontStyle and size is set
        start.setFont(new Font("Free Ink",Font.BOLD,20));
        //FOnt color is set
        start.setForeground(Color.RED);
        //Background is set
        start.setBackground(Color.black);
        //Listener property is added so that is can perform action based on click event
        start.addActionListener(this);
        add(start);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //If pressed on the start button paper frame is visible and instruction should be set off
        if(e.getSource()==start)
        {
            this.setVisible(false);
            new QuestionPaper().setVisible(true);
        }
    }
}
