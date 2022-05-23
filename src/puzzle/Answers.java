package puzzle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
//Step-6
public class Answers extends JFrame implements ActionListener {

    JButton exit;
    JButton tryAgain;
    Answers(char[] answers,String[][] questions)
    {
        Map<Integer,String> finalResult=formatAnswers(answers,questions);
        //define its area/dimension on the wrt screen
        setBounds(200,100,1000,500);
        //set the background of the frame
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
        //it is set null so that label and textField can be added in the frame
        setLayout(null);

        //Label is create and added to the frame
        JLabel answerHeading=new JLabel("Answers!");
        //area is defined wrt to frame
        answerHeading.setBounds(380,40,300,30);
        //fonttype ,font style and size is set
        answerHeading.setFont(new Font("Viner Hand ITC",Font.BOLD,30));
        //font color is set
        answerHeading.setForeground(Color.RED);
        //added to the frae
        add(answerHeading);

        JLabel answerResults=new JLabel();
        answerResults.setText("<html>"+
                "1. "+finalResult.get(1)+ "<br><br>" +
                "2. " +finalResult.get(2)+"<br><br>" +
                "3. " +finalResult.get(3)+"<br><br>" +
                "4. " +finalResult.get(4)+"<br><br>" +
                "5. " +finalResult.get(5)+"<br><br>" +
                "<html>");
        answerResults.setBounds(260,100,500,270);
        answerResults.setForeground(Color.RED);
        answerResults.setBackground(Color.black);
        answerResults.setFont(new Font("Tahoma",Font.BOLD,12));
        answerResults.setBorder(BorderFactory.createBevelBorder(1));
        add(answerResults);

        //Button tryAgain to tryAgain the game
        tryAgain=new JButton("Try Again");
        tryAgain.setBounds(260,380,150,25);
        tryAgain.setFont(new Font("Free Ink",Font.BOLD,20));
        tryAgain.setForeground(Color.RED);
        tryAgain.setBackground(Color.black);
        tryAgain.addActionListener(this);
        add(tryAgain);

        //Button exit to exit the game
        exit=new JButton("Exit");
        exit.setBounds(660,380,100,25);
        exit.setFont(new Font("Free Ink",Font.BOLD,20));
        exit.setForeground(Color.RED);
        exit.setBackground(Color.black);
        exit.addActionListener(this);
        add(exit);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //action ->if button tryAgain pressed->>start the quiz again and set the visibility of Answer frame off
        if(e.getSource()==tryAgain)
        {
            this.setVisible(false);
            new PuzzleGame().setVisible(true); ;
        }
        //action->if exit button pressed->>close the frame
        else if(e.getSource()==exit)
        {
            System.exit(0);
        }
    }
    //Formatting the answer as per the requirement
    //format 1. A-Objects
    public static Map<Integer,String> formatAnswers(char[] answers,String[][] options)
    {
        Map<Integer,String> map=new HashMap<>();
        for (int i=0;i<answers.length;i++)
        {
                map.put(i+1,answers[i]+" - "+options[i][getAnswerInInt(answers[i])]);
        }
        return map;
    }

    /**
     *To find the correct option which is
     * 2D array of any question based on the input answer converting into index
     * if A->0
     * if B->1
     * if C->2
     * if D->3
     *
     */
    public static int getAnswerInInt(char answer)
    {
        if(answer=='A')
        {
            return 0;
        }
        else if(answer=='B')
        {
            return 1;
        }
        else if(answer=='C')
        {
            return 2;
        }
        else
        {
            return 3;
        }
    }

}
