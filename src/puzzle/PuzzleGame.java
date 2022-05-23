package puzzle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Step 2
public class PuzzleGame extends JFrame implements ActionListener {

    JButton continueButton;
    public PuzzleGame()
    {
        //frame boundary is set
        setBounds(200,100,1000,500);
        //set the background of the frame
        getContentPane().setBackground(Color.BLACK);
        //layout is null so that custom jLabel,jTextField can be set
        setLayout(null);
        //Adding icon/image to the screen
        ImageIcon quizImage=new ImageIcon(ClassLoader.getSystemResource("puzzle/icons/QuizImg.jpg"));
        JLabel labelImage=new JLabel(quizImage);
        //icon boundary is set wrt frame
        labelImage.setBounds(0,0,1000,500);
        //added to the frame
        add(labelImage);

        //button instance is created
        continueButton=new JButton("Press space bar to continue");
        //boundary is set wrt to frame
        continueButton.setBounds(300,400,400,25);
        //fontType fontStyle and size is set
        continueButton.setFont(new Font("Free Ink",Font.BOLD,20));
        //font color is set
        continueButton.setForeground(Color.RED);
        //background of button is set
        continueButton.setBackground(Color.black);
        //action listener is added ao that action can be performed based on clil event
        continueButton.addActionListener(this);
        add(continueButton);

        //This is used to make screen visible to the use.By default it is false
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //action is performed when continueButton is pressed
        //Instruction visible off and Instruction is called
        if(e.getSource()==continueButton)
        {
                this.setVisible(false);
                new Instructions();
        }
    }
}
