import javax.swing.*;
import java.util.Random;
public class QuizGame {


    static double userAnswer, correctAnswer;
    static String displayProblem = "";
    static JPanel panel;
    static JButton newProblemButton, checkAnswerButton;
    static JTextField answerInput;
    static JLabel showProblem, showResults;
    static JRadioButton addition, subtraction, multiplication, division;

    public static void main(String[] args) {

        new QuizGame();
        /*createProblem();
        getUserAnswer();
        checkAnswer();*/
    }

    public QuizGame(){

        JFrame frame = new JFrame("Quiz Game");
        frame.setSize(300, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        addition = new JRadioButton("Addition");
        subtraction = new JRadioButton("Subtraction");
        multiplication = new JRadioButton("Multiplication");
        division = new JRadioButton("Division");
        ButtonGroup radios = new ButtonGroup();
        newProblemButton = new JButton("Give Me A Problem");
        showProblem = new JLabel("PLACEHOLDER TEXT");
        checkAnswerButton = new JButton("Am I RIGHT?");
        showResults = new JLabel("PLACEHOLDER TEXT");
        answerInput = new JTextField(10);

        addition.setBounds(100, 10, 200, 30);
        subtraction.setBounds(100, 40, 200, 30);
        multiplication.setBounds(100, 70, 200, 30);
        division.setBounds(100, 100, 200, 30);
        newProblemButton.setBounds(75, 130, 150, 25);
        showProblem.setBounds(75, 160, 150, 25);
        answerInput.setBounds(75, 190, 150, 25);
        checkAnswerButton.setBounds(75, 190, 150, 25);
        showResults.setBounds(75, 220, 150, 25);

        radios.add(addition);
        radios.add(subtraction);
        radios.add(multiplication);
        radios.add(division);

        newProblemButton.addActionListener(new ProblemChoiceListener());

        addition.setSelected(true);

        panel.add(addition);
        panel.add(subtraction);
        panel.add(multiplication);
        panel.add(division);
        panel.add(newProblemButton);
        panel.add(showProblem);
        panel.add(answerInput);

        panel.add(checkAnswerButton);
        panel.add(showResults);

        frame.add(panel);
        panel.setLayout(null);
        frame.setVisible(true);
    }

    private class ProblemChoiceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (addition.isSelected()) {
                addProblem();
            }
            if (subtraction.isSelected()) {
                subProblem();
            }
            if (multiplication.isSelected()) {
                multiplyProblem();
            }
            if (division.isSelected()) {
                divideProblem();
            }
        }
    }

    public static void showResults() {
        JOptionPane.showMessageDialog(null, displayProblem);
    }

    public static void checkAnswer() {
        if (userAnswer == correctAnswer) {
            showResults.setText("You are correct!");
            panel.add(newProblemButton);
            panel.updateUI();
        } else {
            showResults.setText("Incorrect. Better luck next time.");
        }
    }

    public static void getUserAnswer() {

        userAnswer = Double.parseDouble(answerInput.getText());

    }

    public static void createProblem() {

        int choice = Integer.parseInt(JOptionPane.showInputDialog("Choose: \nAddition(1)\nSubtraction(2)\nMultiplication(3)\nDivision(4)"));

        if (choice <= 4) {
            if (choice >= 1) {

                if (choice == 1) {
                    addProblem();
                }
                if (choice == 2) {
                    subProblem();
                }
                if (choice == 3) {
                    multiplyProblem();
                }
                if (choice == 4) {
                    divideProblem();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Invalid Input, run program again.");
                System.exit(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Input, run program again.");
            System.exit(0);
        }
    }

    public static void addProblem() {

        int number1 = randomNum();
        int number2 = randomNum();

        correctAnswer = number1 + number2;
        displayProblem = number1 +  " + " + number2;
    }

    public static void subProblem() {

        int number1 = randomNum();
        int number2 = randomNum();

        correctAnswer = number1 - number2;
        displayProblem = number1 + " - " + number2;
    }

    public static void multiplyProblem() {

        int number1 = randomNum();
        int number2 = randomNum();

        correctAnswer = number1 * number2;
        displayProblem = number1 +  " X " + number2;
    }

    public static void divideProblem() {
        int number1 = randomNum();
        int number2 = randomNum();

        correctAnswer = (double)number1 / number2;

        correctAnswer = Math.round(correctAnswer * 100)/100.0;
        System.out.println(correctAnswer);
        displayProblem = number1 +  " / " + number2;
    }

    public static int randomNum() {
        Random random = new Random();
        return random.nextInt(210) + 1;
    }

    public static double input(String message) {
        return Double.parseDouble(JOptionPane.showInputDialog(message));
    }
}








