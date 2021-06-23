import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class frame implements ActionListener
{
Random random = new Random();
Agent agent[];
Agent winner = null;
private JFrame window = new JFrame("Tic-Tac-Toe");
private JButton buttons[] = new JButton[9];
private int count = 0;
private String letter = "";
private boolean win = false;
private static int startCount =0;
JMenuBar menu = new JMenuBar();

JMenuItem exit = new JMenuItem("Exit");
static String x = "Human";
static String y = "PC";

public frame()
{

window.setSize(400,400);
window.setLocationRelativeTo(null);
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.setLayout(new GridLayout(3,3));


for(int i=0; i<=8; i++)
{
buttons[i] = new JButton();
window.add(buttons[i]);
buttons[i].addActionListener(this);
}


menu.add(exit);


exit.addActionListener(this);

window.setJMenuBar(menu);

window.setVisible(true);
}
public frame(Agent a, Agent b) 
	{
		// TODO Auto-generated constructor stub
		agent = new Agent[2];
		agent[0] = a;
		agent[1] = b;
		
	}



public void actionPerformed(ActionEvent a)
{
Object source = a.getSource();




if(source == exit)
{
int answer = JOptionPane.showConfirmDialog(null, "EXIT", "Do you want to exit?", JOptionPane.YES_NO_OPTION);

if (answer == JOptionPane.YES_OPTION)
{
JOptionPane.showMessageDialog(null, "Thanks for playing");
System.exit(0);
}
}
else
{
count++;
int turn = random.nextInt(2);
if(count % 2 == 0)
{
    //turn = (turn+1)%2;
   // agent[turn].makeMove(this);
letter = "O";
}
else
{
   // turn = (turn+1)%2;
    //agent[turn].makeMove();
letter = "X";
}

JButton pressedButton = (JButton)source;
pressedButton.setText(letter);
pressedButton.setEnabled(false);



}
}

public void clearIt()
{

window.setVisible(false);
this.startIt();
}

public void startIt()
{
new frame();

}

}