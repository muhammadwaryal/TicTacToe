package projects;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class J extends JFrame{
    JProgressBar jp;
    public J(){
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(420, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jp = new JProgressBar();
        jp.setValue(0);
        jp.setBounds(0, 0, 420, 150 );
        jp.setStringPainted(true);
        jp.setForeground(Color.red);
        jp.setBackground(Color.black);
        jp.setFont(new Font("Consolas", Font.BOLD, 15));

        add(jp);
        fill();

    }
    public void fill(){
        int counter = 0;
        while(counter<=100){
            jp.setValue(counter);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter += 1;
        }
        jp.setString("Game is starting");
    }

}    // end of class J

class Game2 extends JFrame implements ActionListener {

    JLabel text;
    Random random = new Random();
    JButton [] button = new JButton[9];
    JPanel panel1, panel2;
    boolean player1Turn = true;
    public Game2(){
        setSize(650, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        text = new JLabel("Tic-Tac-Toe");
        text.setFont(new Font("Ink Free", Font.BOLD, 60));
        text.setForeground(Color.green);
        text.setHorizontalAlignment(text.CENTER);

        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setBackground(new Color(75, 75, 75));
        panel1.setBounds(0, 0, 650, 100);
        panel1.add(text);

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3, 3));
        panel2.setBounds(100, 100, 650, 530);
        for (int i=0; i<button.length; i++){
            button[i] = new JButton();
            button[i].setFocusable(false);
            button[i].addActionListener(this);
            button[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            panel2.add(button[i]);
        }

        add(panel1, BorderLayout.NORTH);
        add(panel2);
        firstTurn();
        setVisible(true);
    }

    public void firstTurn(){
        J j = new J();
        j.dispose();
        if (random.nextInt(2)==0){
            player1Turn = true;
            text.setText("X Turn");
        } else {
            player1Turn = false;
            text.setText("O Turn");
        }
    }
    public void check(){
        // check X wins condition
        if(button[0].getText()=="X" && button[1].getText()=="X" && button[2].getText()=="X"){
            xWins(0, 1, 2);
        }
        if(button[3].getText()=="X" && button[4].getText()=="X" && button[5].getText()=="X"){
            xWins(3, 4, 5);
        }
        if(button[6].getText()=="X" && button[7].getText()=="X" && button[8].getText()=="X"){
            xWins(6, 7, 8);
        }
        if(button[0].getText()=="X" && button[3].getText()=="X" && button[6].getText()=="X"){
            xWins(0, 3, 6);
        }
        if(button[1].getText()=="X" && button[4].getText()=="X" && button[7].getText()=="X"){
            xWins(1, 4, 7);
        }
        if(button[2].getText()=="X" && button[5].getText()=="X" && button[8].getText()=="X"){
            xWins(2, 5, 8);
        }
        if(button[0].getText()=="X" && button[4].getText()=="X" && button[8].getText()=="X"){
            xWins(0, 4, 8);
        }
        if(button[2].getText()=="X" && button[4].getText()=="X" && button[6].getText()=="X"){
            xWins(2, 4, 6);
        }

        // check O wins condition
        if(button[0].getText()=="O" && button[1].getText()=="O" && button[2].getText()=="O"){
            oWins(0, 1, 2);
        }
        if(button[3].getText()=="O" && button[4].getText()=="O" && button[5].getText()=="O"){
            oWins(3, 4, 5);
        }
        if(button[6].getText()=="O" && button[7].getText()=="O" && button[8].getText()=="O"){
            oWins(6, 7, 8);
        }
        if(button[0].getText()=="O" && button[3].getText()=="O" && button[6].getText()=="O"){
            oWins(0, 3, 6);
        }
        if(button[1].getText()=="O" && button[4].getText()=="O" && button[7].getText()=="O"){
            oWins(1, 4, 7);
        }
        if(button[2].getText()=="O" && button[5].getText()=="O" && button[8].getText()=="O"){
            oWins(2, 5, 8);
        }
        if(button[0].getText()=="O" && button[4].getText()=="O" && button[8].getText()=="O"){
            oWins(0, 4, 8);
        }
        if(button[2].getText()=="O" && button[4].getText()=="O" && button[6].getText()=="O"){
            oWins(2, 4, 6);
        }
    }
    public void xWins(int a, int b, int c){
        button[a].setBackground(Color.green);
        button[b].setBackground(Color.green);
        button[c].setBackground(Color.green);
        text.setText("X Wins");
        for (int i=0; i<button.length; i++){
            button[i].setEnabled(false);
        }
    }
    public void oWins(int a, int b, int c){
        button[a].setBackground(Color.green);
        button[b].setBackground(Color.green);
        button[c].setBackground(Color.green);
        text.setText("O Wins");
        for (int i=0; i<button.length; i++){
            button[i].setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<button.length; i++){
            if (e.getSource()==button[i]){
                if(player1Turn){
                    if (button[i].getText()==""){
                        button[i].setText("X");
                        button[i].setForeground(Color.red);
                        player1Turn = false;
                        text.setText("O Turn");
                        check();
                    }
                } else {
                    if (button[i].getText()==""){
                        button[i].setText("O");
                        button[i].setForeground(Color.BLUE);
                        player1Turn = true;
                        text.setText("X Turn");
                        check();
                    }
                }
            }
        }
    }

}
// end of class Game2

public class TicTacToe {
    public static void main(String[] args) {
        Game2 game2 = new Game2();
    }
}