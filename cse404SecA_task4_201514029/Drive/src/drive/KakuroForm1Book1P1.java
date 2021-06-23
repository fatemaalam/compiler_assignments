/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package drive;

/**
 *
 * @author user
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;


public class KakuroForm1Book1P1 extends JFrame{
    
 public static  Model model = new Model("my first kakuro problem Formulation1 Book 1 problem 1");
// 2. Create variables

/* kakuro board which is 6 X 6 for this problm */
/* we assume (0, 0) is the top left position */
/* and (5, 5) is the bottom right position */

public static IntVar[][] bd = model.intVarMatrix("bd", 6, 6, 0, 9);


private JMenuBar menuBar = new JMenuBar(); // Window menu ba


public static void main(String[] args) {


int i, j, k;


// 1. Create a Model



// 3. Post constraints


/* posting constraints for horizontal sums */
/* a total of 6 horizontal sum clues for this problem */
IntVar[] r0 = model.intVarArray("r0", 3, 1, 9);
IntVar[] r1 = model.intVarArray("r1", 4, 1, 9);
IntVar[] r2 = model.intVarArray("r2", 2, 1, 9);
IntVar[] r3 = model.intVarArray("r3", 2, 1, 9);
IntVar[] r4 = model.intVarArray("r4", 4, 1, 9);
IntVar[] r5 = model.intVarArray("r5", 3, 1, 9);

/* posting constraints for vertical */
/* a total of 6 vertical sum clues for this problem */
IntVar[] c0 = model.intVarArray("c0", 3, 1, 9);
IntVar[] c1 = model.intVarArray("c1", 4, 1, 9);
IntVar[] c2 = model.intVarArray("c2", 2, 1, 9);
IntVar[] c3 = model.intVarArray("c3", 2, 1, 9);
IntVar[] c4 = model.intVarArray("c4", 4, 1, 9);
IntVar[] c5 = model.intVarArray("c5", 3, 1, 9);



/* initializing the kakuro board */
/* assign zero to all null positions or black cells and also for clue cells*/

for ( j = 0; j < 6; j++) 
   model.arithm (bd[0][j], "=", 0).post();
   model.arithm (bd[1][0], "=", 0).post();
   
for ( j = 1; j < 4; j++) 
   model.arithm (bd[1][j], ">", 0).post();
for ( j = 4; j < 6; j++) 
   model.arithm (bd[1][j], "=", 0).post();  
   
model.arithm (bd[2][0], "=", 0).post();   


for ( j = 1; j < 5; j++) 
   model.arithm (bd[2][j], ">", 0).post();
   model.arithm (bd[2][5], "=", 0).post();
   model.arithm (bd[3][0], "=", 0).post();
   
for ( j = 1; j < 3; j++) 
   model.arithm (bd[3][j], ">", 0).post();   
    model.arithm (bd[3][3], "=", 0).post();   



for ( j = 4; j < 6; j++) 
   model.arithm (bd[3][j], ">", 0).post();
   
   

for ( j = 0; j < 2; j++) 
   model.arithm (bd[4][j], "=", 0).post();


for ( j = 2; j < 6; j++) 
   model.arithm (bd[4][j], ">", 0).post();
  

for ( j = 0; j < 3; j++) 
   model.arithm (bd[5][j], "=", 0).post();
for ( j = 3; j < 6; j++) 
   model.arithm (bd[5][j], ">", 0).post();



/* posting constraints for associating the horizontal */
/* sum variables with appropriate board positions */

/* for example r0 [0] + r0 [1] = bd [1, 3] + bd [1, 4] = 15*/

i = 0;
for ( j = 1; j < 4; j++)
       {
        model.arithm (bd[1][j], "=", r0[i]).post();
        i++;
       }
       
i = 0;
for ( j = 1; j < 5; j++)
       {
        model.arithm (bd[2][j], "=", r1[i]).post();
        i++;
       }

i = 0;
for ( j = 1; j < 3; j++)
       {
        model.arithm (bd[3][j], "=", r2[i]).post();
        i++;
       }

i = 0;
for ( j = 4; j < 6; j++)
       {
        model.arithm (bd[3][j], "=", r3[i]).post();
        i++;
       }

i = 0;
for ( j = 2; j < 6; j++)
       {
        model.arithm (bd[4][j], "=", r4[i]).post();
        i++;
       }

i = 0;
for ( j = 3; j < 6; j++)
       {
        model.arithm (bd[5][j], "=", r5[i]).post();
        i++;
       }
       


/* posting sum constraints for horizontal sums*/       
model.sum (r0, "=", 23).post();       
model.sum (r1, "=", 19).post();       
model.sum (r2, "=", 5).post();       
model.sum (r3, "=", 11).post();       
model.sum (r4, "=", 15).post();       
model.sum (r5, "=", 11).post();       




/* posting alldifferent constraints for horizontal sums */
model.allDifferent(r0).post();
model.allDifferent(r1).post();
model.allDifferent(r2).post();
model.allDifferent(r3).post();
model.allDifferent(r4).post();
model.allDifferent(r5).post();



/* posting constraints for associating the vertical */
/* sum variables with appropriate board positions */

/* for example c0 [0] + c0 [1] = bd [1, 3] + bd [2, 3] = 17  */


j = 0;
for ( i = 1; i < 4; i++)
       {
        model.arithm (bd[i][1], "=", c0[j]).post();
        j++;
       }

j = 0;
for ( i = 1; i < 5; i++)
       {
        model.arithm (bd[i][2], "=", c1[j]).post();
        j++;
       }

j = 0;
for ( i = 1; i < 3; i++)
       {
        model.arithm (bd[i][3], "=", c2[j]).post();
        j++;
       }

j = 0;
for ( i = 4; i < 6; i++)
       {
        model.arithm (bd[i][3], "=", c3[j]).post();
        j++;
       }

j = 0;
for ( i = 2; i < 6; i++)
       {
        model.arithm (bd[i][4], "=", c4[j]).post();
        j++;
       }

j = 0;
for ( i = 3; i < 6; i++)
       {
        model.arithm (bd[i][5], "=", c5[j]).post();
        j++;
       }


/* posting sum constraints for vertical sums*/       
model.sum (c0, "=", 9).post();       
model.sum (c1, "=", 22).post();       
model.sum (c2, "=", 10).post();       
model.sum (c3, "=", 17).post();       
model.sum (c4, "=", 13).post();       
model.sum (c5, "=", 13).post();       


/* posting alldifferent constraints for vertical sums */
model.allDifferent(c0).post();
model.allDifferent(c1).post();
model.allDifferent(c2).post();
model.allDifferent(c3).post();
model.allDifferent(c4).post();
model.allDifferent(c5).post();


// 4. Solve the problem


    
    Solver solver = model.getSolver();
    solver.showStatistics();
    solver.showSolutions();
    solver.findSolution();
    new KakuroForm1Book1P1().setVisible(true);

// 5. Print the solution

for ( i = 0; i < 6; i++)
    {
for ( j = 0; j < 6; j++)
     { 
        //System.out.print(vs [i][j]); 
        System.out.print(" "); 
        k = bd [i][j].getValue();
        System.out.print(k );
  // System.out.print(vs [0][1]); System.out.print(" "); 
 //System.out.print(vs [0][2]); System.out.print(" ");
     }
     System.out.println();
    }

   
}


////////Jframe 
 public KakuroForm1Book1P1(){
     
     
         setJMenuBar(menuBar); // Add the menu bar to the window
    
    JMenu fileMenu = new JMenu("File"); // Create File menu
    JMenu elementMenu = new JMenu("Elements"); // Create Elements menu
    menuBar.add(fileMenu); // Add the file menu
    menuBar.add(elementMenu); // Add the element menu 
        
         JPanel pannel=new JPanel(); // Create jpanel
         pannel.setLayout(new GridLayout(6,6)); // Set Grid to 6 x 6 matrix
         pannel.setBounds(500,20, 500, 500);  // Set size and position
         setDefaultCloseOperation(EXIT_ON_CLOSE); //Close frame
         
        for (int i=0;i<6;i++)
            {
               for (int j=0;j<6;j++)
                     {
                         if(i==0 && j==0){
                         String s = "\\";
                        JButton box = new JButton(""+s);
                        box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                       
                        pannel.add(box);
                         }
                        else if(i==0 && j==1){
                         String s = "9\\";
                        JButton box = new JButton(""+s);
                        box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                       
                        pannel.add(box);
                         }
                        else if(i==0 && j==2){
                         String s = "22\\";
                        JButton box = new JButton(""+s);
                        box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                       pannel.add(box);
                         }
                        else if(i==0 && j==3){
                         String s = "10\\";
                        JButton box = new JButton(""+s);
                        box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                        pannel.add(box);
                         }
                        else if(i==0 && j==4){
                         String s = "\\";
                      JButton box = new JButton(""+s);
                        box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                         pannel.add(box);
                         }
                        else if(i==0 && j==5){
                         String s = "\\";
                       JButton box = new JButton(""+s);
                        box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                        pannel.add(box);
                         }
                        else if(i==1 && j==0){
                         String s = "\\23";
                        JButton box = new JButton(""+s);
                        box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                        pannel.add(box);
                         }
                        else if(i==1 && j==4){
                         String s = "13\\";
                        JButton box = new JButton(""+s);
                        box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                       pannel.add(box);
                         }
                        else if(i==1 && j==5){
                         String s = "\\";
                       JButton box = new JButton(""+s);
                        box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                        pannel.add(box);
                         }
                        else if(i==2 && j==0){
                         String s = "\\19";
                       JButton box = new JButton(""+s);
                        box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                        pannel.add(box);
                         }
                        else if(i==2 && j==5){
                         String s = "\\13";
                        JButton box = new JButton(""+s);
                        box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                       pannel.add(box);
                         }
                        else if(i==3 && j==0){
                         String s = "\\5";
                        JButton box = new JButton(""+s);
                        box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                       pannel.add(box);
                         }
                        
                        
                        else if(i==3 && j==3){
                         String s = "17\\11";
                        JButton box = new JButton(""+s);
                        box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                       pannel.add(box);
                         }
                        else if(i==4 && j==0){
                         String s = "\\";
                       JButton box = new JButton(""+s);
                        box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                       pannel.add(box);
                         }
                        else if(i==4 && j==1){
                         String s = "\\15";
                        JButton box = new JButton(""+s);
                        box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                        pannel.add(box);
                         }
                        else if(i==5 && j==0){
                         String s = "\\";
                        JButton box = new JButton(""+s);
                        box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                       pannel.add(box);
                         }
                        else if(i==5 && j==1){
                         String s = "\\";
                        JButton box = new JButton(""+s);
                        box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                       pannel.add(box);
                         }
                        else if(i==5 && j==2){
                         String s = "\\11";
                        JButton box = new JButton(""+s);
                        box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                        pannel.add(box);
                         }
                        
                        
               else{

                        int p = bd [i][j].getValue();
                        if(p!= 0){
                           JButton blank = new JButton(""+p);
                            blank.setBackground(Color.pink);
                            blank.setFont(new Font("TimesRoman",Font.PLAIN,15));
                            pannel.add(blank);
                        }   } }  }
        add(pannel); }

}

/*Output:
* Choco 4.0.0 (2016-09) : Constraint Programming Solver, Copyleft (c) 2010-2016
- Model[my first kakuro problem] features:
	Variables : 82
	Constraints : 96
	Default search strategy : no
	Completed search strategy : no
- Solution #1 found. Model[my first kakuro problem], 1 Solutions, Resolution time 0.115s, 4 Nodes (34.8 n/s), 3 Backtracks, 3 Fails, 0 Restarts 
	bd[0][0] = 0 bd[0][1] = 0 bd[0][2] = 0 bd[0][3] = 0 bd[0][4] = 0 bd[0][5] = 0 bd[1][0] = 0 bd[1][1] = 6 bd[1][2] = 8 bd[1][3] = 9 bd[1][4] = 0 bd[1][5] = 0 bd[2][0] = 0 bd[2][1] = 2 bd[2][2] = 9 bd[2][3] = 1 bd[2][4] = 7 bd[2][5] = 0 bd[3][0] = 0 bd[3][1] = 1 bd[3][2] = 4 bd[3][3] = 0 bd[3][4] = 3 bd[3][5] = 8 bd[4][0] = 0 bd[4][1] = 0 bd[4][2] = 1 bd[4][3] = 9 bd[4][4] = 2 bd[4][5] = 3 bd[5][0] = 0 bd[5][1] = 0 bd[5][2] = 0 bd[5][3] = 8 bd[5][4] = 1 bd[5][5] = 2 r0[0] = 6 r0[1] = 8 r0[2] = 9 r1[0] = 2 r1[1] = 9 r1[2] = 1 r1[3] = 7 r2[0] = 1 r2[1] = 4 r3[0] = 3 r3[1] = 8 r4[0] = 1 r4[1] = 9 r4[2] = 2 r4[3] = 3 r5[0] = 8 r5[1] = 1 r5[2] = 2 c0[0] = 6 c0[1] = 2 c0[2] = 1 c1[0] = 8 c1[1] = 9 c1[2] = 4 c1[3] = 1 c2[0] = 9 c2[1] = 1 c3[0] = 9 c3[1] = 8 c4[0] = 7 c4[1] = 3 c4[2] = 2 c4[3] = 1 c5[0] = 8 c5[1] = 3 c5[2] = 2 .
- Complete search - 1 solution found.
	Model[my first kakuro problem]
	Solutions: 1
	Building time : 0.000s
	Resolution time : 0.127s
	Nodes: 4 (31.5 n/s) 
	Backtracks: 3
	Fails: 3
	Restarts: 0
 0 0 0 0 0 0
 0 6 8 9 0 0
 0 2 9 1 7 0
 0 1 4 0 3 8
 0 0 1 9 2 3
 0 0 0 8 1 2
*/
