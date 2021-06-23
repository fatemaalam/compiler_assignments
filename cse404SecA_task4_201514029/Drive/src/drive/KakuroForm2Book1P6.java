/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drive;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;
/**
 *
 * @author user
 */



public class KakuroForm2Book1P6 extends JFrame{
    
 public static  Model model = new Model("my second kakuro problem Formulation2 Book 1 problem 6");
// 2. Create variables

/* kakuro board which is 6 X 6 for this problm */
/* we assume (0, 0) is the top left position */
/* and (5, 5) is the bottom right position */
private JMenuBar menuBar = new JMenuBar(); // Window menu ba
public static IntVar[][] bd = model.intVarMatrix("bd", 6, 6, 0, 9);

public static void main(String[] args) {


int i, j, k;

// 3. Post constraints


/* posting constraints for horizontal sums */
/* a total of 6 horizontal sum clues for this problem */
IntVar[] r0 = model.intVarArray("r0", 2, 1, 9);
IntVar[] r1 = model.intVarArray("r1", 2, 1, 9);
IntVar[] r2 = model.intVarArray("r2", 5, 1, 9);
IntVar[] r3 = model.intVarArray("r3", 3, 1, 9);
IntVar[] r4 = model.intVarArray("r4", 5, 1, 9);
IntVar[] r5 = model.intVarArray("r5", 2, 1, 9);
IntVar[] r6 = model.intVarArray("r6", 2, 1, 9);








/* posting constraints for vertical */
/* a total of 6 vertical sum clues for this problem */
IntVar[] c0 = model.intVarArray("c0", 2, 1, 9);
IntVar[] c1 = model.intVarArray("c1", 2, 1, 9);
IntVar[] c2 = model.intVarArray("c2", 5, 1, 9);
IntVar[] c3 = model.intVarArray("c3", 3, 1, 9);
IntVar[] c4 = model.intVarArray("c4", 5, 1, 9);
IntVar[] c5 = model.intVarArray("c5", 2, 1, 9);
IntVar[] c6 = model.intVarArray("c6", 2, 1, 9);


/* initializing the kakuro board */
/* assign zero to all null positions or black cells and also for clue cells*/

for ( j = 0; j < 6; j++) 
   model.arithm (bd[0][j], "=", 0).post();
   
   model.arithm (bd[1][0], "=", 0).post();
   
for ( j = 1; j < 3; j++) 
   model.arithm (bd[1][j], ">", 0).post();
    model.arithm (bd[1][3], "=", 0).post();
   
for ( j = 4; j < 6; j++) 
   model.arithm (bd[1][j], ">", 0).post();  
   
model.arithm (bd[2][0], "=", 0).post();   


for ( j = 1; j < 6; j++) 
   model.arithm (bd[2][j], ">", 0).post();
   

for ( j = 1; j < 2; j++) 
   model.arithm (bd[3][j], "=", 0).post();  
   
  for ( j = 2; j < 5; j++)  
    model.arithm (bd[3][j], ">", 0).post();  
    
model.arithm (bd[3][5], "=", 0).post();  

model.arithm (bd[4][0], "=", 0).post();  


for ( j = 1; j < 6; j++) 
   model.arithm (bd[4][j], ">", 0).post();
   
    model.arithm (bd[5][0], "=", 0).post();
   
   

for ( j = 1; j < 3; j++) 
   model.arithm (bd[5][j], ">", 0).post();
   
    model.arithm (bd[5][3], "=", 0).post();
  

for ( j = 4; j < 6; j++) 
   model.arithm (bd[5][j], ">", 0).post();




/* posting constraints for associating the horizontal */
/* sum variables with appropriate board positions */

/* for example r0 [0] + r0 [1] = bd [1, 3] + bd [1, 4] = 15*/

i = 0;
for ( j = 1; j < 3; j++)
       {
        model.arithm (bd[1][j], "=", r0[i]).post();
        i++;
       }
       
i = 0;
for ( j = 4; j < 6; j++)
       {
        model.arithm (bd[1][j], "=", r1[i]).post();
        i++;
       }

i = 0;
for ( j = 1; j < 6; j++)
       {
        model.arithm (bd[2][j], "=", r2[i]).post();
        i++;
       }

i = 0;
for ( j = 2; j < 5; j++)
       {
        model.arithm (bd[3][j], "=", r3[i]).post();
        i++;
       }

i = 0;
for ( j = 1; j < 6; j++)
       {
        model.arithm (bd[4][j], "=", r4[i]).post();
        i++;
       }

i = 0;
for ( j = 1; j < 3; j++)
       {
        model.arithm (bd[5][j], "=", r5[i]).post();
        i++;
       }
       
       i = 0;
for ( j = 4; j < 6; j++)
       {
        model.arithm (bd[5][j], "=", r6[i]).post();
        i++;
       }
       


/* posting sum constraints for horizontal sums*/       
model.sum (r0, "=", 6).post();       
model.sum (r1, "=", 8).post();       
model.sum (r2, "=", 20).post();       
model.sum (r3, "=", 13).post();       
model.sum (r4, "=", 15).post();       
model.sum (r5, "=", 6).post();   
model.sum (r6, "=", 14).post(); 






/* for second formulation */
for ( i = 0; i < 2; i++ )
   model.arithm (r0[i], "<", 6).post();
for ( i = 0; i < 2; i++ )
   model.arithm (r1[i], "<", 8).post();
for ( i = 0; i < 5; i++ )
   model.arithm (r4[i], "<", 6).post();
for ( i = 0; i < 2; i++ )
   model.arithm (r5[i], "<", 6).post();
for ( i = 0; i < 2; i++ )
   model.arithm (r6[i], ">", 4).post();




/* posting alldifferent constraints for horizontal sums */
model.allDifferent(r0).post();
model.allDifferent(r1).post();
model.allDifferent(r2).post();
model.allDifferent(r3).post();
model.allDifferent(r4).post();
model.allDifferent(r5).post();
model.allDifferent(r6).post();



/* posting constraints for associating the vertical */
/* sum variables with appropriate board positions */

/* for example c0 [0] + c0 [1] = bd [1, 3] + bd [2, 3] = 17  */


j = 0;
for ( i = 1; i < 3; i++)
       {
        model.arithm (bd[i][1], "=", c0[j]).post();
        j++;
       }

j = 0;
for ( i = 4; i < 6; i++)
       {
        model.arithm (bd[i][1], "=", c1[j]).post();
        j++;
       }

j = 0;
for ( i = 1; i < 6; i++)
       {
        model.arithm (bd[i][2], "=", c2[j]).post();
        j++;
       }

j = 0;
for ( i = 2; i < 5; i++)
       {
        model.arithm (bd[i][3], "=", c3[j]).post();
        j++;
       }

j = 0;
for ( i = 1; i < 6; i++)
       {
        model.arithm (bd[i][4], "=", c4[j]).post();
        j++;
       }

j = 0;
for ( i = 1; i < 3; i++)
       {
        model.arithm (bd[i][5], "=", c5[j]).post();
        j++;
       }
       
       j = 0;
for ( i = 4; i < 6; i++)
       {
        model.arithm (bd[i][5], "=", c6[j]).post();
        j++;
       }


/* posting sum constraints for vertical sums*/       
model.sum (c0, "=", 4).post();       
model.sum (c1, "=", 3).post();       
model.sum (c2, "=", 15).post();       
model.sum (c3, "=", 9).post();       
model.sum (c4, "=", 21).post();       
model.sum (c5, "=", 16).post();       
model.sum (c6, "=", 14).post(); 



/* for second formulation */
for ( i = 0; i < 2; i++ )
   model.arithm (c0[i], "<", 4).post();
for ( i = 0; i < 2; i++ )
   model.arithm (c1[i], "<", 3).post();
for ( i = 0; i < 5; i++ )
   model.arithm (c2[i], "<", 6).post();
for ( i = 0; i < 3; i++ )
   model.arithm (c3[i], "<", 7).post();
for ( i = 0; i < 2; i++ )
   model.arithm (c5[i], ">", 6).post();
for ( i = 0; i < 2; i++ )
   model.arithm (c6[i], ">", 4).post();

/* posting alldifferent constraints for vertical sums */
model.allDifferent(c0).post();
model.allDifferent(c1).post();
model.allDifferent(c2).post();
model.allDifferent(c3).post();
model.allDifferent(c4).post();
model.allDifferent(c5).post();
model.allDifferent(c6).post();

// 4. Solve the problem



    Solver solver = model.getSolver();
    solver.showStatistics();
    solver.showSolutions();
    solver.findSolution();
    new KakuroForm2Book1P6().setVisible(true);

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
 public KakuroForm2Book1P6(){
     
     
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
                         String s = "4\\";
                        JButton box = new JButton(""+s);
                         box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                       
                        pannel.add(box);
                         }
                        else if(i==0 && j==2){
                         String s = "15\\";
                        JButton box = new JButton(""+s);
                         box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                       
                        pannel.add(box);
                         }
                        else if(i==0 && j==3){
                         String s = "\\";
                        JButton box = new JButton(""+s);
                         box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                       
                        pannel.add(box);
                         }
                        else if(i==0 && j==4){
                         String s = "21\\";
                        JButton box = new JButton(""+s);
                         box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                       
                        pannel.add(box);
                         }
                        else if(i==0 && j==5){
                         String s = "16\\";
                        JButton box = new JButton(""+s);
                         box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                       
                        pannel.add(box);
                         }
                        else if(i==1 && j==0){
                         String s = "\\6";
                        JButton box = new JButton(""+s);
                         box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                       
                        pannel.add(box);
                         }
                        else if(i==1 && j==3){
                         String s = "9\\8";
                        JButton box = new JButton(""+s);
                         box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                       
                        pannel.add(box);
                         }
                        else if(i==2 && j==0){
                         String s = "\\20";
                        JButton box = new JButton(""+s);
                         box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                       
                        pannel.add(box);
                         }
                        else if(i==3 && j==0){
                         String s = "\\";
                        JButton box = new JButton(""+s);
                         box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                       
                        pannel.add(box);
                         }
                        else if(i==3 && j==1){
                         String s = "3\\13";
                        JButton box = new JButton(""+s);
                         box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                       
                        pannel.add(box);
                         }
                        else if(i==3 && j==5){
                         String s = "14\\";
                       JButton box = new JButton(""+s);
                         box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                       
                        pannel.add(box);
                         }
                        
                        
                        else if(i==4 && j==0){
                         String s = "\\15";
                        JButton box = new JButton(""+s);
                         box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                       
                        pannel.add(box);
                         }
                        else if(i==5 && j==0){
                         String s = "\\6";
                        JButton box = new JButton(""+s);
                         box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,15));
                       
                        pannel.add(box);
                         }
                        else if(i==5 && j==3){
                         String s = "\\14";
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

/*
OUTPUT:
* Choco 4.0.0 (2016-09) : Constraint Programming Solver, Copyleft (c) 2010-2016
- Model[my second kakuro problem] features:
	Variables : 89
	Constraints : 134
	Default search strategy : no
	Completed search strategy : no
- Solution #1 found. Model[my second kakuro problem], 1 Solutions, Resolution time 0.071s, 5 Nodes (70.5 n/s), 0 Backtracks, 0 Fails, 0 Restarts 
	bd[0][0] = 0 bd[0][1] = 0 bd[0][2] = 0 bd[0][3] = 0 bd[0][4] = 0 bd[0][5] = 0 bd[1][0] = 0 bd[1][1] = 1 bd[1][2] = 5 bd[1][3] = 0 bd[1][4] = 1 bd[1][5] = 7 bd[2][0] = 0 bd[2][1] = 3 bd[2][2] = 1 bd[2][3] = 5 bd[2][4] = 2 bd[2][5] = 9 bd[3][0] = 0 bd[3][1] = 0 bd[3][2] = 3 bd[3][3] = 1 bd[3][4] = 9 bd[3][5] = 0 bd[4][0] = 0 bd[4][1] = 1 bd[4][2] = 2 bd[4][3] = 3 bd[4][4] = 4 bd[4][5] = 5 bd[5][0] = 0 bd[5][1] = 2 bd[5][2] = 4 bd[5][3] = 0 bd[5][4] = 5 bd[5][5] = 9 r0[0] = 1 r0[1] = 5 r1[0] = 1 r1[1] = 7 r2[0] = 3 r2[1] = 1 r2[2] = 5 r2[3] = 2 r2[4] = 9 r3[0] = 3 r3[1] = 1 r3[2] = 9 r4[0] = 1 r4[1] = 2 r4[2] = 3 r4[3] = 4 r4[4] = 5 r5[0] = 2 r5[1] = 4 r6[0] = 5 r6[1] = 9 c0[0] = 1 c0[1] = 3 c1[0] = 1 c1[1] = 2 c2[0] = 5 c2[1] = 1 c2[2] = 3 c2[3] = 2 c2[4] = 4 c3[0] = 5 c3[1] = 1 c3[2] = 3 c4[0] = 1 c4[1] = 2 c4[2] = 9 c4[3] = 4 c4[4] = 5 c5[0] = 7 c5[1] = 9 c6[0] = 5 c6[1] = 9 .
- Complete search - 1 solution found.
	Model[my second kakuro problem]
	Solutions: 1
	Building time : 0.000s
	Resolution time : 0.076s
	Nodes: 5 (66.0 n/s) 
	Backtracks: 0
	Fails: 0
	Restarts: 0
 0 0 0 0 0 0
 0 1 5 0 1 7
 0 3 1 5 2 9
 0 0 3 1 9 0
 0 1 2 3 4 5
 0 2 4 0 5 9
*/

