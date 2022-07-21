import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class GuessNumber extends JFrame{
    private int WINDOW_WIDTH = 270;
    private int WINDOW_HEIGHT = 150;
    private JLabel headlineLabel;
    private JLabel resultJLabel = new JLabel("Can you guess my number?");
    private JTextField textField;
    private JButton newGameBtn;
    private JPanel panel;
    private int numberInital;

    GuessNumber(){
        numberInital = randomNumber();
        System.out.println(numberInital);

        setTitle("Guessing Game");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createPanel();
        add(panel);

        setVisible(true);
    }

    private void createPanel(){
        panel = new JPanel();
        headlineLabel = new JLabel("I have a number between 1 and 100.");
        textField = new JTextField(15);
        newGameBtn = new JButton("New Game");

        textField.addActionListener(new guessCorrectOrNot());
        newGameBtn.addActionListener(new newGameButton());

        panel.add(headlineLabel);
        panel.add(resultJLabel);
        panel.add(textField);
        panel.add(newGameBtn);
    }

    private class guessCorrectOrNot implements ActionListener{
        public void actionPerformed(ActionEvent e){
         try{
            String textNumber = textField.getText();
            int guessNumber = Integer.parseInt(textNumber);

            System.out.println(textNumber);
            System.out.println(guessNumber);

            if (numberInital == guessNumber){
                resultJLabel.setText("Congratulations, You are correct!");
            }else if(numberInital > guessNumber){
                resultJLabel.setText("Too Low, try a higher number");
                headlineLabel.setText("I have a number between " + guessNumber + " and 100.");
            }else{
                resultJLabel.setText("Too High, try a lower number");
                headlineLabel.setText("I have a number between 1 and " + guessNumber + ".");
            }

            panel.revalidate();
            panel.repaint();

         }catch(Exception ex){
            resultJLabel.setText("Please enter a valid data type");
         } 
        }
    }

    private class newGameButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            numberInital = randomNumber();
            System.out.println(numberInital);
        }
    }

    private int randomNumber(){
        Random rand = new Random();
        int randomNumber = rand.nextInt(100);
        return (randomNumber + 1);
    }

    public static void main(String[] args) {
        GuessNumber guessNumber = new GuessNumber(); 
    }

    
}
