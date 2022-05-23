package puzzle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//Step-4
public class QuestionPaper extends JFrame implements ActionListener {
    //Question Array is created
    String[] questions={
            "In Java arrays are",
            "Which one of the following is a valid statement",
            "Index values begin at",
            "int quiz[]=new int[5]. Determine no of element",
            "String[] strings=new String[2];"


    };
    //option 2d is created
    String[][] options={
            {
                    "objects","object references","primitive data type","None of the above"
            },
            {
                    "char[] c = new char();","char[] c = new char[5];","char[] c = new char(4);","char[] c = new char[];"
            }
            ,{
            "1","arr.length","0","-1"
    },
            {
                    "quiz.length","quiz.length()","quiz.size","quiz.size()"
            },
            {
                    "[null, null]","[,]","[Ljava.lang.String;@74a16682","None of the above"
            }

    };
    //Answer of question is created as array
    char[] answers={
            'A','B','C','A','C'
    };
    //question index start from 0
    int index=0;
    //This variable will hold correctGuesses
    int correctGuesses=0;
    //This variable hold total no of questions
    int totalQuestions=questions.length;
    //This variable hold percentage of correctness
    int result;
    //For timer seconds is defined here and can be increased/decreased based on the requriment
    int seconds=30;
    //This variable is used to set the answer as Correct/Wrong based on the answer given by the user
    Boolean correct=false;

    //This textField is defined for the correct/wrong answer given by the user
    JTextField correctOrWrongAnswer=new JTextField();
    //This textField have question Number in format "Question 1/2/3...." as the index changes
    JTextField questionNumberField=new JTextField();
    //This textField display the question
    JLabel questionDisplayField=new JLabel();
    //Option A button
    JButton buttonA=new JButton();
    //Option B button
    JButton buttonB=new JButton();
    //Option C button
    JButton buttonC=new JButton();
    //Option D button
    JButton buttonD=new JButton();

    //option A answer of a question
    JLabel answerLabelA=new JLabel();
    //option B answer of a question
    JLabel answerLabelB=new JLabel();
    //option C answer of a question
    JLabel answerLabelC=new JLabel();
    //option D answer of a question
    JLabel answerLabelD=new JLabel();


    //Timer label is used for timer
    JLabel timeLabel=new JLabel();
    //secondLeft Label will hold the seconds left for the question
    JLabel secondsLeft=new JLabel();


    //Timer is set
    Timer timer=new Timer(1000, e -> {
        seconds--;
        secondsLeft.setText(String.valueOf(seconds));
        if(seconds<=0)
        {
            displayAnswer();
        }
    });
    public QuestionPaper() {
        //frame boundary is defined wrt to desktop/laptop
        setBounds(200,100,1000,500);
        //set the background of the frame
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        setResizable(false);

        /**
         * Label,TextField and Button boundary,color,background,font style border is set
         */
        questionNumberField.setBounds(0,0,1000,50);
        questionNumberField.setBackground(Color.BLACK);
        questionNumberField.setForeground(Color.yellow);
        questionNumberField.setFont(new Font("Ink Free",Font.BOLD,50));
        questionNumberField.setBorder(BorderFactory.createBevelBorder(1));
        questionNumberField.setHorizontalAlignment(JTextField.CENTER);
        questionNumberField.setEditable(false);


        questionDisplayField.setBounds(0,50,1000,100);
        questionDisplayField.setBackground(Color.BLACK);
        questionDisplayField.setForeground(Color.YELLOW);
        questionDisplayField.setFont(new Font("Ink Free",Font.BOLD,25));
        questionDisplayField.setBorder(BorderFactory.createBevelBorder(1));


        buttonA.setBounds(0,150,100,50);
        buttonA.setFont(new Font("MV Boli",Font.BOLD,25));
        buttonA.setFocusable(true);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0,200,100,50);
        buttonB.setFont(new Font("MV Boli",Font.BOLD,25));
        buttonB.setFocusable(true);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0,250,100,50);
        buttonC.setFont(new Font("MV Boli",Font.BOLD,25));
        buttonC.setFocusable(true);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0,300,100,50);
        buttonD.setFont(new Font("MV Boli",Font.BOLD,25));
        buttonD.setFocusable(true);
        buttonD.addActionListener(this);
        buttonD.setText("D");


        answerLabelA.setBounds(130,120,850,100);
        answerLabelA.setBackground(new Color(50,50,50));
        answerLabelA.setForeground(new Color(25,255,0));
        answerLabelA.setFont(new Font("MV Boli",Font.PLAIN,25));

        answerLabelB.setBounds(130,170,850,100);
        answerLabelB.setBackground(new Color(50,50,50));
        answerLabelB.setForeground(new Color(25,255,0));
        answerLabelB.setFont(new Font("MV Boli",Font.PLAIN,25));


        answerLabelC.setBounds(130,220,850,100);
        answerLabelC.setBackground(new Color(50,50,50));
        answerLabelC.setForeground(new Color(25,255,0));
        answerLabelC.setFont(new Font("MV Boli",Font.PLAIN,25));

        answerLabelD.setBounds(130,270,850,100);
        answerLabelD.setBackground(new Color(50,50,50));
        answerLabelD.setForeground(new Color(25,255,0));
        answerLabelD.setFont(new Font("MV Boli",Font.PLAIN,25));


        secondsLeft.setBounds(880,360,100,100);
        secondsLeft.setBackground(new Color(25,25,25));
        secondsLeft.setForeground(new Color(255,0,0));
        secondsLeft.setFont(new Font("Ink Free",Font.BOLD,60));
        secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
        secondsLeft.setOpaque(true);
        secondsLeft.setHorizontalAlignment(JTextField.CENTER);
        secondsLeft.setText(String.valueOf(seconds));

        timeLabel.setBounds(880,340,100,25);
        timeLabel.setBackground(new Color(50,50,50));
        timeLabel.setForeground(new Color(255,0,0));
        timeLabel.setFont(new Font("Ink Free",Font.BOLD,16));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        timeLabel.setText("Timer");


        correctOrWrongAnswer.setBounds(0,400,880,50);
        correctOrWrongAnswer.setBackground(Color.BLACK);
        correctOrWrongAnswer.setFont(new Font("Ink Free",Font.BOLD,50));
        correctOrWrongAnswer.setBorder(BorderFactory.createBevelBorder(1));
        correctOrWrongAnswer.setHorizontalAlignment(JTextField.CENTER);
        correctOrWrongAnswer.setEditable(false);

        //All the textField,button,label is added to the frame
        add(timeLabel);
        add(secondsLeft);
        add(answerLabelA);
        add(answerLabelB);
        add(answerLabelC);
        add(answerLabelD);
        add(buttonA);
        add(buttonB);
        add(buttonC);
        add(buttonD);
        add(questionNumberField);
        add(questionDisplayField);
        add(correctOrWrongAnswer);
        setVisible(true);


        //Let begin our quiz

        nextQuestion();
    }

    public void nextQuestion() {
        //if the index >=no of question display the answer frame
        if(index>=totalQuestions)
        {
            results();
        }
        //else continue with next question
        else {
            questionNumberField.setText("Question "+(index+1));
            questionDisplayField.setText(questions[index]);
            answerLabelA.setText(options[index][0]);
            answerLabelB.setText(options[index][1]);
            answerLabelC.setText(options[index][2]);
            answerLabelD.setText(options[index][3]);
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        //if buttonA is press and its correct answer so we will increase the correctGuesses count by 1 and set correct=true
        if(e.getSource()==buttonA)
        {
            char answer='A';
            if(answer==answers[index])
            {
                correct=true;
                correctGuesses++;
            }
        }
        //if buttonB is press and its correct answer so we will increase the correctGuesses count by 1 and set correct=true
        else if(e.getSource()==buttonB)
        {
            char answer='B';
            if(answer==answers[index])
            {
                correct=true;
                correctGuesses++;
            }
        }
        //if buttonC is press and its correct answer so we will increase the correctGuesses count by 1 and set correct=true
        else if(e.getSource()==buttonC)
        {
            char answer='C';
            if(answer==answers[index])
            {
                correct=true;
                correctGuesses++;
            }
        }
        //if buttonD is press and its correct answer so we will increase the correctGuesses count by 1 and set correct=true
        else if(e.getSource()==buttonD)
        {
            char answer='D';
            if(answer==answers[index])
            {
                correct=true;
                correctGuesses++;
            }
        }
        displayAnswer();
    }
    //displayAnswer display whether the answer is correctOrWrong
    public void displayAnswer() {
        //timer is stooped
        timer.stop();
        //All the button is disabled
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        //if its correct answer
        if(correct)
        {
            //Display result
            correctOrWrongAnswer.setText("Correct Answer");
            //Color is set green for success
            correctOrWrongAnswer.setForeground(Color.GREEN);
        }else
        {
            //Display result
            correctOrWrongAnswer.setText("Wrong Answer");
            //Color is set red for failure
            correctOrWrongAnswer.setForeground(Color.RED);
        }
        //Timer is reset
        //2 sec wait before the next question
        //second reinitialized with 30seconds
        //correct=false
        //button is enabled again
        //index is increased for next questinon
        //correctWrong text is null
        //nextQuestion is called
        Timer pause=new Timer(2000, e -> {
            seconds=30;
            secondsLeft.setText(String.valueOf(seconds));
            correct=false;
            buttonA.setEnabled(true);
            buttonB.setEnabled(true);
            buttonC.setEnabled(true);
            buttonD.setEnabled(true);
            index++;
            correctOrWrongAnswer.setText("");
            nextQuestion();
        });
        //send one one action to the listener
        pause.setRepeats(false);
        //start the timer again
        pause.start();

    }

    public void results() {
        setVisible(false);
        result= (int) (((double)correctGuesses/totalQuestions)*100);
        new Result(totalQuestions,correctGuesses,result,answers,options).setVisible(true);
    }

}
