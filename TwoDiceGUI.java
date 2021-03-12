// this app needs the class die.java in the root directory

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoDiceGUI extends JFrame implements ActionListener
{

	Font mainFont = new Font("Impact", Font.PLAIN, 26);
	JLabel title = new JLabel("Two Dice Game");
	JLabel playerLabel = new JLabel("The players roll is: ");
	JLabel comLabel = new JLabel("The Computers roll is: ");
	JLabel result = new JLabel("");
	JTextField pRoll =new JTextField(4);
	JTextField cRoll =new JTextField(4);
	JButton button = new JButton("Click to Play");

	//custom constructor for this class 
	public TwoDiceGUI()
	{
		super("Two Dice Game");
		setBounds(450, 450, 300, 240);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new FlowLayout());

		title.setFont(mainFont);
		result.setFont(mainFont);
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);

		add(title);
		add(playerLabel);
		add(pRoll);
		add(comLabel);
		add(cRoll);
		add(button);
		add(result);

		button.addActionListener(this);

	}

	//event handlers
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// variables and constants
		Die playerDie = new Die();
		Die computerDie = new Die();
		String outcome;

		//calculation phase
		if(playerDie.getDieValue() > computerDie.getDieValue())
		{
			outcome ="The player wins!";
		}	
		else if(playerDie.getDieValue() < computerDie.getDieValue()) {
			outcome = "the computer has won.";
		}
		else
		{
			outcome = "We have a tie game.";
		}	

		//output phase 
		pRoll.setText("" + playerDie.getDieValue());
		cRoll.setText("" + computerDie.getDieValue());
		result.setText(outcome);
		button.setText("Play again?");	
	}

	public static void main(String[] args)
	{
		TwoDiceGUI frame = new TwoDiceGUI();
	}
}