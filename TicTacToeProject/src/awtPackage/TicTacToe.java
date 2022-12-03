package awtPackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe implements ActionListener {
	//Create a JFrame
    JFrame window = new JFrame("Tic Tac Toe");
    //Create a JPanel
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel reloadPanel = new JPanel();
    JPanel scorePanel = new JPanel();
    //Creat a JLable
    JLabel textfield = new JLabel();
    //Creat a JButtonArray
    JButton[] buttons = new JButton[9];
    //Create buttons
    JButton reloadButton =new JButton("Reload");
    JButton closeButton = new JButton("Close");
    //Create a Score Label
    JLabel score_label_playerX = new JLabel();
    JLabel score_label_playerO = new JLabel();
    //Create a Score Variable
    int playerX_score = 0;
    int playerO_score = 0;

    //Create a Constructor
    TicTacToe(){
         //set the size of the JFrame
         window.setSize(1000,800);
        //set the background color of the JFrame
         window.getContentPane().setBackground(new Color(50,50,50));
        //set the layout of the JFrame
        window.setLayout(new BorderLayout());
        //set the JFrame to be visible
        window.setVisible(true);
        //set the background color of the JLabel
        textfield.setBackground(new Color(25,25,25));
        //set the background color of the JLabel
        textfield.setForeground(new Color(25,255,255));
        //set the font the JLabel
        textfield.setFont(new Font("Ink Free",Font.BOLD,75));
        //set the horizontalAlignment of the JLabel
        textfield.setHorizontalAlignment(JLabel.CENTER);
        //set the text of the JLabel
        textfield.setText("Tic-Tac-Toe");
        //set the JLabel to be opaque
        textfield.setOpaque(true);
        //set the layout of the JPanel
        titlePanel.setLayout(new BorderLayout());
        //set the Bounds of the JPanel
        titlePanel.setBounds(0,0,800,100);
        //add the JLabel to the JFrame
        titlePanel.add(textfield);
        //add the jPanel to the JFrame
        window.add(titlePanel,BorderLayout.NORTH);
        //set the layout of the JPanel
        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150,150,150));
        //create a for loop
        for(int i= 0; i<9; i++){
            // set the JButton array to a new JButton
            buttons[i] = new JButton();
            // add the JButton array to the JPanel
            buttonPanel.add(buttons[i]);
            // set the font of the JButton array
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            // set the JButton array to be not focusable
            buttons[i].setFocusable(false);
            // add an action listener to the JButton array
            buttons[i].addActionListener(this);
        }
        window.add(buttonPanel);
        /*set the layout of the JPanel such that reload button is on the left
        and close button is on the right*/
        reloadPanel.setLayout(new GridLayout(1,2));
        //set the background color of JPanel
        reloadPanel.setBackground(new Color(150,150,150));
        //add the reload button to the JPanel
        reloadPanel.add(reloadButton);
        //add the close button to the JPanel
        reloadPanel.add(closeButton);
        // set the font of the reload button
        reloadButton.setFont(new Font("MV Boli",Font.BOLD,50));
        // set color of the reload button
        reloadButton.setBackground(new Color(0,0,255));
        // set the reload button to be not focusable
        reloadButton.setFocusable(false);
        // add an action listener to the reload button
        reloadButton.addActionListener(this);
        // set the font of the close button
        closeButton.setFont(new Font("MV Boli", Font.BOLD, 50));
        // set color of the close button
        closeButton.setBackground(new Color(255,0,0));
        // set the close button to be not focusable
        closeButton.setFocusable(false);
        // add an action listener to the close button
        closeButton.addActionListener(this);
        // add the JPanel to the JFrame
        window.add(reloadPanel,BorderLayout.SOUTH);
        //set the layout of JPanel
        scorePanel.setLayout(new GridLayout(2,1));
        // set the background color of the JPanel as gold
        scorePanel.setBackground(new Color(255,255,0));
        // set the font of the score label
        score_label_playerX.setFont(new Font("MV Boli",Font.BOLD, 20));
        /* set the text of the score label such that it displays the score of
         both players in two lines.*/
        score_label_playerX.setText("Player X: " +playerX_score);
        // add the score label to the JPanel
        scorePanel.add(score_label_playerX);
        // set the font of the score label
        score_label_playerO.setFont(new Font("MV Boli",Font.BOLD,20));
        /* set the text of the score label such that it displays the score of both
        players in two lines */
        score_label_playerO.setText("Player O: " + playerO_score);
        // add the score label to the JPanel
        scorePanel.add(score_label_playerO);
        window.add(scorePanel,BorderLayout.EAST);
        firstTurn();
    }
    //create a boolean
     boolean player1_turn;
    // create an action performed method
    public void actionPerformed(ActionEvent e){
        for(int i = 0; i<9; i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    //set the text of the JButton array to X
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(0,255,0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");
                        // change color of the textfield
                        textfield.setForeground(new Color(0,0,255));
                        check();
                    }
                }
                else{
                    //set the text of the JButton array to O
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turn");
                        // change color of the textfield
                        textfield.setForeground(new Color(0,255,0));
                        check();
                    }
                }
            }
        }
        // add functionality to the reload button
        if(e.getSource()==reloadButton){
            // call the reload method
            reload();
        }
        //add functionality to the close button
        if(e.getSource()==closeButton){
            //close the window
            window.dispose();
        }
    }
    //create a method
    public void firstTurn(){
        //create a try catch block
        try{
            //create a thread
            textfield.setText("Tic-Tac-Toe");
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(Math.random() < 0.5){
            player1_turn = true;
            textfield.setText("X turn");
        }
        else{
            player1_turn = false;
            textfield.setText("O turn");
        }
    }
    //create a method
    public void reload(){
        for(int i = 0; i<9; i++){
            // set the text of the JButton array to empty
            buttons[i].setText("");
            // set the background color of the JButton array to the default color
            buttons[i].setBackground(new Color(240,240,240));
            // set the text of the textfield to empty
            buttons[i].setEnabled(true);
        }
        // call the firstTurn method
        firstTurn();
    }
    //Create a method
    public void check(){
        if((buttons[0].getText()=="X")&&(buttons[1].getText()=="X")&&
                (buttons[2].getText()=="X")){
            xWins(0,1,2);
        }
        if((buttons[3].getText()=="X")&&(buttons[4].getText()=="X")&&
                (buttons[5].getText()=="X")){
            xWins(3,4,5);
        }
        if((buttons[6].getText()=="X")&&(buttons[7].getText()=="X")&&
                (buttons[8].getText()=="X")){
            xWins(6,7,8);
        }
        if((buttons[0].getText()=="X")&&(buttons[3].getText()=="X")&&
                (buttons[6].getText()=="X")){
            xWins(0,3,6);
        }
        if((buttons[1].getText()=="X")&&(buttons[4].getText()=="X")&&
                (buttons[7].getText()=="X")){
            xWins(1,4,7);
        }
        if((buttons[2].getText()=="X")&&(buttons[5].getText()=="X")&&
                (buttons[8].getText()=="X")){
            xWins(2,5,8);
        }
        if((buttons[0].getText()=="X")&&(buttons[4].getText()=="X")&&
                (buttons[8].getText()=="X")){
            xWins(0,4,8);
        }
        if((buttons[2].getText()=="X")&&(buttons[4].getText()=="X")&&
                (buttons[6].getText()=="X")){
            xWins(2,4,6);
        }
        //For "O" As well
        if((buttons[0].getText()=="O")&&(buttons[1].getText()=="O")&&
                (buttons[2].getText()=="O")){
            oWins(0,1,2);
        }
        if((buttons[3].getText()=="O")&&(buttons[4].getText()=="O")&&
                (buttons[5].getText()=="O")){
            oWins(3,4,5);
        }
        if((buttons[6].getText()=="O")&&(buttons[7].getText()=="O")&&
                (buttons[8].getText()=="O")){
            oWins(6,7,8);
        }
        if((buttons[0].getText()=="O")&&(buttons[3].getText()=="O")&&
                (buttons[6].getText()=="O")){
            oWins(0,3,6);
        }
        if((buttons[1].getText()=="O")&&(buttons[4].getText()=="O")&&
                (buttons[7].getText()=="O")){
            oWins(1,4,7);
        }
        if((buttons[2].getText()=="O")&&(buttons[5].getText()=="O")&&
                (buttons[8].getText()=="O")){
            oWins(2,5,8);
        }
        if((buttons[0].getText()=="O")&&(buttons[4].getText()=="O")&&
                (buttons[8].getText()=="O")){
            oWins(0,4,8);
        }
        if((buttons[2].getText()=="O")&&(buttons[4].getText()=="O")&&
                (buttons[6].getText()=="O")){
            oWins(2,4,6);
        }
    }
    //Create a method
    public void xWins(int a, int b, int c){
        // set the text of the textfield to X wins
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i = 0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins");
        // add 1 to the xCount
        playerX_score++;
        // set the text of the playerX_score_label to the xCount
        score_label_playerX.setText("Player X: "+ playerX_score);
    }
    public void oWins(int a, int b, int c){
        // set the text of the textfield to X wins
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i = 0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins");
        // add 1 to the xCount
        playerO_score++;
        // set the text of the playerX_score_label to the xCount
        score_label_playerO.setText("Player O: "+ playerO_score);
    }
}
