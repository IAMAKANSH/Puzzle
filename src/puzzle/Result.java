package puzzle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Step-5
public class Result extends JFrame implements ActionListener {
    JTextField numberRight=new JTextField();
    JTextField percentageField=new JTextField();
    JTextField correctVsQuestions=new JTextField();
    JTextField winOrLoseScreen=new JTextField();
    JTextField per=new JTextField();
    JButton tryAgain;
    JButton seeAnswers;
    char[] answerGot;
    String[][] optionsGot;
    public Result(Integer noOfQuestion,Integer correctAnswer,Integer percentage,char[] answers,String[][] options)
    {
        answerGot=answers;
        optionsGot=options;
        setBounds(200,100,1000,500);   /** dleft,duppersideOfScreen,length,breadth**/
        //set the background of the frame
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        JLabel resultHeading=new JLabel("Result!");
        resultHeading.setBounds(400,0,300,50);
        resultHeading.setFont(new Font("Viner Hand ITC",Font.BOLD,40));
        resultHeading.setForeground(Color.RED);
        add(resultHeading);

        correctVsQuestions.setText("(CorrectAnswer/No.Of Questions)");
        correctVsQuestions.setBounds(0,80,500,50);
        correctVsQuestions.setBackground(Color.BLACK);
        correctVsQuestions.setForeground(new Color(25,255,0));
        correctVsQuestions.setFont(new Font("Ink Free",Font.BOLD,20));
        correctVsQuestions.setBorder(BorderFactory.createBevelBorder(1));
        correctVsQuestions.setHorizontalAlignment(JTextField.CENTER);
        correctVsQuestions.setEditable(false);

        numberRight.setBounds(500,80,750,50);
        numberRight.setBackground(Color.BLACK);
        numberRight.setForeground(new Color(25,255,0));
        numberRight.setFont(new Font("Ink Free",Font.BOLD,20));
        numberRight.setBorder(BorderFactory.createBevelBorder(1));
        numberRight.setHorizontalAlignment(JTextField.LEFT);
        numberRight.setEditable(false);
        numberRight.setText("("+correctAnswer+" /"+ noOfQuestion+")");

        per.setBounds(0,130,500,50);
        per.setText("Percentage");
        per.setBackground(Color.BLACK);
        per.setForeground(new Color(25,255,0));
        per.setFont(new Font("Ink Free",Font.BOLD,20));
        per.setBorder(BorderFactory.createBevelBorder(1));
        per.setHorizontalAlignment(JTextField.CENTER);
        per.setEditable(false);

        percentageField.setBounds(500,130,750,50);
        percentageField.setBackground(Color.BLACK);
        percentageField.setForeground(new Color(25,255,0));
        percentageField.setFont(new Font("Ink Free",Font.BOLD,20));
        percentageField.setBorder(BorderFactory.createBevelBorder(1));
        percentageField.setHorizontalAlignment(JTextField.LEFT);
        percentageField.setEditable(false);
        percentageField.setText(percentage+"%");


        winOrLoseScreen.setBounds(0,180,1000,100);
        winOrLoseScreen.setBackground(Color.BLACK);
        winOrLoseScreen.setForeground(new Color(25,255,0));
        winOrLoseScreen.setFont(new Font("Ink Free",Font.BOLD,30));
        winOrLoseScreen.setBorder(BorderFactory.createBevelBorder(1));
        winOrLoseScreen.setHorizontalAlignment(JTextField.CENTER);
        winOrLoseScreen.setEditable(false);
        if(correctAnswer==noOfQuestion)
        {
            winOrLoseScreen.setText("You Won");
        }
        else
        {
            winOrLoseScreen.setText("You Lose");
        }

        tryAgain=new JButton("Try Again");
        tryAgain.setBounds(250,380,200,25);
        tryAgain.setFont(new Font("Free Ink",Font.BOLD,20));
        tryAgain.setForeground(Color.RED);
        tryAgain.setBackground(Color.black);
        tryAgain.addActionListener(this);
        add(tryAgain);

        seeAnswers=new JButton("See Answers");
        seeAnswers.setBounds(550,380,200,25);
        seeAnswers.setFont(new Font("Free Ink",Font.BOLD,20));
        seeAnswers.setForeground(Color.RED);
        seeAnswers.setBackground(Color.black);
        seeAnswers.addActionListener(this);
        add(seeAnswers);

        add(percentageField);
        add(numberRight);
        add(tryAgain);
        add(seeAnswers);
        add(correctVsQuestions);
        add(per);
        add(winOrLoseScreen);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==tryAgain)
        {
            this.setVisible(false);
            new PuzzleGame();
        }
        else
        {
            this.setVisible(false);
            new Answers(answerGot,optionsGot);
        }
    }

    public static void main(String[] args) {
        new Result(1,2,3,null,null);
    }
}
