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


public class KakuroForm2Book2P3 extends JFrame{
    
 public static  Model model = new Model("my third kakuro problem Formulation2 Book 2 problem 3");
// 2. Create variables
private JMenuBar menuBar = new JMenuBar(); // Window menu ba
/* kakuro board which is 6 X 6 for this problm */
/* we assume (0, 0) is the top left position */
/* and (5, 5) is the bottom right position */

public static IntVar[][] bd = model.intVarMatrix("bd", 9, 9, 0, 9);

public static void main(String[] args) {


int i, j, k;

// 3. Post constraints


/* posting constraints for horizontal sums */
/* a total of 6 horizontal sum clues for this problem */
IntVar[] r0 = model.intVarArray("r0", 2, 1, 9);
IntVar[] r1 = model.intVarArray("r1", 2, 1, 9);
IntVar[] r2 = model.intVarArray("r2", 2, 1, 9);
IntVar[] r3 = model.intVarArray("r3", 3, 1, 9);
IntVar[] r4 = model.intVarArray("r4", 2, 1, 9);
IntVar[] r5 = model.intVarArray("r5", 2, 1, 9);
IntVar[] r6 = model.intVarArray("r6", 5, 1, 9);
IntVar[] r7 = model.intVarArray("r7", 2, 1, 9);
IntVar[] r8 = model.intVarArray("r8", 2, 1, 9);
IntVar[] r9 = model.intVarArray("r9", 5, 1, 9);
IntVar[] r10 = model.intVarArray("r10", 2, 1, 9);
IntVar[] r11 = model.intVarArray("r11", 2, 1, 9);
IntVar[] r12 = model.intVarArray("r12", 3, 1, 9);
IntVar[] r13 = model.intVarArray("r13", 2, 1, 9);
IntVar[] r14 = model.intVarArray("r14", 2, 1, 9);
IntVar[] r15 = model.intVarArray("r15", 2, 1, 9);
/* posting constraints for vertical */
/* a total of 6 vertical sum clues for this problem */
IntVar[] c0 = model.intVarArray("c0", 2, 1, 9);
IntVar[] c1 = model.intVarArray("c1", 2, 1, 9);
IntVar[] c2 = model.intVarArray("c2", 7, 1, 9);
IntVar[] c3 = model.intVarArray("c3", 2, 1, 9);
IntVar[] c4 = model.intVarArray("c4", 3, 1, 9);
IntVar[] c5 = model.intVarArray("c5", 2, 1, 9);
IntVar[] c6 = model.intVarArray("c6", 2, 1, 9);
IntVar[] c7 = model.intVarArray("c7", 2, 1, 9);
IntVar[] c8 = model.intVarArray("c8", 2, 1, 9);
IntVar[] c9 = model.intVarArray("c9", 3, 1, 9);
IntVar[] c10 = model.intVarArray("c10", 2, 1, 9);
IntVar[] c11 = model.intVarArray("c11", 7, 1, 9);
IntVar[] c12 = model.intVarArray("c12", 2, 1, 9);
IntVar[] c13 = model.intVarArray("c13", 2, 1, 9);

/* initializing the kakuro board */
/* assign zero to all null positions or black cells and also for clue cells*/

for ( j = 0; j < 9; j++) 
   model.arithm (bd[0][j], "=", 0).post();
   
   model.arithm (bd[1][0], "=", 0).post();
   
for ( j = 1; j < 3; j++) 
   model.arithm (bd[1][j], ">", 0).post();
   
 for ( j = 3; j < 5; j++) 
   model.arithm (bd[1][j], "=", 0).post();  
   
 for ( j = 5; j < 7; j++) 
   model.arithm (bd[1][j], ">", 0).post();  
   
 for ( j = 7; j < 9; j++) 
   model.arithm (bd[1][j], "=", 0).post();  
    
    model.arithm (bd[2][0], "=", 0).post();
  for ( j = 1; j < 3; j++) 
   model.arithm (bd[2][j], ">", 0).post();
    for ( j = 3; j < 5; j++) 
   model.arithm (bd[2][j], "=", 0).post();  
   for ( j = 5; j < 8; j++) 
   model.arithm (bd[2][j], ">", 0).post();  
   model.arithm (bd[2][8], "=", 0).post();
   
   
  for ( j = 0; j < 2; j++) 
   model.arithm (bd[3][j], "=", 0).post();
    for ( j = 2; j < 4; j++) 
   model.arithm (bd[3][j], ">", 0).post();
    for ( j = 4; j < 6; j++) 
   model.arithm (bd[3][j], "=", 0).post();
    for ( j = 6; j < 8; j++) 
   model.arithm (bd[3][j], ">", 0).post();
   model.arithm (bd[3][8], "=", 0).post();
    
   model.arithm (bd[4][0], "=", 0).post();
    for ( j = 1; j < 6; j++) 
   model.arithm (bd[4][j], ">", 0).post();
    model.arithm (bd[4][6], "=", 0).post();
    for ( j = 7; j < 9; j++) 
   model.arithm (bd[4][j], ">", 0).post();
   
    model.arithm (bd[5][0], "=", 0).post();
   for ( j = 1; j < 3; j++) 
   model.arithm (bd[5][j], ">", 0).post();
   model.arithm (bd[5][3], "=", 0).post();
   for ( j = 4; j < 9; j++) 
   model.arithm (bd[5][j], ">", 0).post();
   
   for ( j = 0; j < 2; j++) 
   model.arithm (bd[6][j], "=", 0).post();
   for ( j = 2; j < 4; j++) 
   model.arithm (bd[6][j], ">", 0).post();
   for ( j = 4; j < 6; j++) 
   model.arithm (bd[6][j], "=", 0).post();
   for ( j = 6; j < 8; j++) 
   model.arithm (bd[6][j], ">", 0).post();
    model.arithm (bd[6][8], "=", 0).post();
   
  for ( j = 0; j < 2; j++) 
   model.arithm (bd[7][j], "=", 0).post();
   for ( j = 2; j < 5; j++) 
   model.arithm (bd[7][j], ">", 0).post();
   for ( j = 5; j < 7; j++) 
   model.arithm (bd[7][j], "=", 0).post();
   for ( j = 7; j < 9; j++) 
   model.arithm (bd[7][j], ">", 0).post();
   
   for ( j = 0; j < 3; j++) 
   model.arithm (bd[8][j], "=", 0).post();
   for ( j = 3; j < 5; j++) 
   model.arithm (bd[8][j], ">", 0).post();
   for ( j = 5; j < 7; j++) 
   model.arithm (bd[8][j], "=", 0).post();
   for ( j = 7; j < 9; j++) 
   model.arithm (bd[8][j], ">", 0).post();
   
  
   
 



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
for ( j = 5; j < 7; j++)
       {
        model.arithm (bd[1][j], "=", r1[i]).post();
        i++;
       }

i = 0;
for ( j = 1; j < 3; j++)
       {
        model.arithm (bd[2][j], "=", r2[i]).post();
        i++;
       }

i = 0;
for ( j = 5; j < 8; j++)
       {
        model.arithm (bd[2][j], "=", r3[i]).post();
        i++;
       }

i = 0;
for ( j = 2; j < 4; j++)
       {
        model.arithm (bd[3][j], "=", r4[i]).post();
        i++;
       }

i = 0;
for ( j = 6; j < 8; j++)
       {
        model.arithm (bd[3][j], "=", r5[i]).post();
        i++;
       }
       
       i = 0;
for ( j = 1; j < 6; j++)
       {
        model.arithm (bd[4][j], "=", r6[i]).post();
        i++;
       }
       
i = 0;
for ( j = 7; j < 9; j++)
       {
        model.arithm (bd[4][j], "=", r7[i]).post();
        i++;
       }
       
i = 0;
for ( j = 1; j < 3; j++)
       {
        model.arithm (bd[5][j], "=", r8[i]).post();
        i++;
       }

i = 0;
for ( j = 4; j < 9; j++)
       {
        model.arithm (bd[5][j], "=", r9[i]).post();
        i++;
       }

i = 0;
for ( j = 2; j < 4; j++)
       {
        model.arithm (bd[6][j], "=", r10[i]).post();
        i++;
       }

i = 0;
for ( j = 6; j < 8; j++)
       {
        model.arithm (bd[6][j], "=", r11[i]).post();
        i++;
       }

i = 0;
for ( j = 2; j < 5; j++)
       {
        model.arithm (bd[7][j], "=", r12[i]).post();
        i++;
       }
       
       i = 0;
for ( j = 7; j < 9; j++)
       {
        model.arithm (bd[7][j], "=", r13[i]).post();
        i++;
       }
i = 0;
for ( j = 3; j < 5; j++)
       {
        model.arithm (bd[8][j], "=", r14[i]).post();
        i++;
       }
       
       i = 0;
for ( j = 7; j < 9; j++)
       {
        model.arithm (bd[8][j], "=", r15[i]).post();
        i++;
       }

/* posting sum constraints for horizontal sums*/       
model.sum (r0, "=", 8).post();       
model.sum (r1, "=", 17).post();       
model.sum (r2, "=", 15).post();       
model.sum (r3, "=", 12).post();       
model.sum (r4, "=", 4).post();       
model.sum (r5, "=", 8).post();   
model.sum (r6, "=", 29).post(); 
model.sum (r7, "=", 4).post();       
model.sum (r8, "=", 3).post();       
model.sum (r9, "=", 17).post();       
model.sum (r10, "=", 3).post();       
model.sum (r11, "=", 6).post();       
model.sum (r12, "=", 11).post();   
model.sum (r13, "=", 12).post(); 
model.sum (r14, "=", 7).post();   
model.sum (r15, "=", 10).post(); 



/* for second formulation */


for ( i = 0; i < 2; i++ )
   model.arithm (r0[i], "<", 8).post();
for ( i = 0; i < 2; i++ )
   model.arithm (r1[i], ">", 7).post();
for ( i = 0; i < 2; i++ )
   model.arithm (r2[i], ">", 5).post();
for ( i = 0; i < 2; i++ )
   model.arithm (r4[i], "<", 4).post();
for ( i = 0; i < 2; i++ )
   model.arithm (r5[i], "<", 8).post();
for ( i = 0; i < 2; i++ )
   model.arithm (r7[i], "<", 4).post();
for ( i = 0; i < 2; i++ )
   model.arithm (r8[i], "<", 3).post();
for ( i = 0; i < 5; i++ )
   model.arithm (r9[i], "<", 8).post();
for ( i = 0; i < 2; i++ )
   model.arithm (r10[i], "<", 3).post();
for ( i = 0; i < 2; i++ )
   model.arithm (r11[i], "<", 6).post();
   for ( i = 0; i < 3; i++ )
   model.arithm (r12[i], "<", 9).post();
    for ( i = 0; i < 2; i++ )
   model.arithm (r13[i], ">", 2).post();
    for ( i = 0; i < 2; i++ )
   model.arithm (r14[i], "<", 7).post();
 


/* posting alldifferent constraints for horizontal sums */
model.allDifferent(r0).post();
model.allDifferent(r1).post();
model.allDifferent(r2).post();
model.allDifferent(r3).post();
model.allDifferent(r4).post();
model.allDifferent(r5).post();
model.allDifferent(r6).post();
model.allDifferent(r7).post();
model.allDifferent(r8).post();
model.allDifferent(r9).post();
model.allDifferent(r10).post();
model.allDifferent(r11).post();
model.allDifferent(r12).post();
model.allDifferent(r13).post();
model.allDifferent(r14).post();
model.allDifferent(r15).post();


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
for ( i = 1; i < 8; i++)
       {
        model.arithm (bd[i][2], "=", c2[j]).post();
        j++;
       }

j = 0;
for ( i = 3; i < 5; i++)
       {
        model.arithm (bd[i][3], "=", c3[j]).post();
        j++;
       }

j = 0;
for ( i = 6; i < 9; i++)
       {
        model.arithm (bd[i][3], "=", c4[j]).post();
        j++;
       }

j = 0;
for ( i = 4; i < 6; i++)
       {
        model.arithm (bd[i][4], "=", c5[j]).post();
        j++;
       }
       
j = 0;
for ( i = 7; i < 9; i++)
       {
        model.arithm (bd[i][4], "=", c6[j]).post();
        j++;
       }
j = 0;
for ( i = 1; i < 3; i++)
       {
        model.arithm (bd[i][5], "=", c7[j]).post();
        j++;
       }

j = 0;
for ( i = 4; i < 6; i++)
       {
        model.arithm (bd[i][5], "=", c8[j]).post();
        j++;
       }

j = 0;
for ( i = 1; i < 4; i++)
       {
        model.arithm (bd[i][6], "=", c9[j]).post();
        j++;
       }

j = 0;
for ( i = 5; i < 7; i++)
       {
        model.arithm (bd[i][6], "=", c10[j]).post();
        j++;
       }

j = 0;
for ( i = 2; i < 9; i++)
       {
        model.arithm (bd[i][7], "=", c11[j]).post();
        j++;
       }
j = 0;
for ( i = 4; i < 6; i++)
       {
        model.arithm (bd[i][8], "=", c12[j]).post();
        j++;
       }

j = 0;
for ( i = 7; i < 9; i++)
       {
        model.arithm (bd[i][8], "=", c13[j]).post();
        j++;
       }

/* posting sum constraints for vertical sums*/       
model.sum (c0, "=", 7).post();       
model.sum (c1, "=", 11).post();       
model.sum (c2, "=", 36).post();       
model.sum (c3, "=", 9).post();       
model.sum (c4, "=", 7).post();       
model.sum (c5, "=", 3).post();       
model.sum (c6, "=", 4).post(); 
model.sum (c7, "=", 10).post();       
model.sum (c8, "=", 8).post();       
model.sum (c9, "=", 24).post();       
model.sum (c10, "=", 3).post();       
model.sum (c11, "=", 31).post();       
model.sum (c12, "=", 5).post();       
model.sum (c13, "=", 8).post(); 



/* for second formulation */
for ( i = 0; i < 2; i++ )
   model.arithm (c0[i], "<", 7).post();
for ( i = 0; i < 2; i++ )
   model.arithm (c1[i], ">", 1).post();
for ( i = 0; i < 2; i++ )
   model.arithm (c3[i], "<", 9).post();
for ( i = 0; i < 3; i++ )
   model.arithm (c4[i], "<", 5).post();
for ( i = 0; i < 2; i++ )
   model.arithm (c5[i], "<", 3).post();
for ( i = 0; i < 2; i++ )
   model.arithm (c6[i], "<", 4).post();
   
   for ( i = 0; i < 2; i++ )
   model.arithm (c8[i], "<", 8).post();
for ( i = 0; i < 3; i++ )
   model.arithm (c9[i], ">", 6).post();
   
   for ( i = 0; i < 2; i++ )
   model.arithm (c10[i], "<", 3).post();
for ( i = 0; i < 2; i++ )
   model.arithm (c12[i], "<", 5).post();
for ( i = 0; i < 2; i++ )
   model.arithm (c13[i], "<", 8).post();

/* posting alldifferent constraints for vertical sums */
model.allDifferent(c0).post();
model.allDifferent(c1).post();
model.allDifferent(c2).post();
model.allDifferent(c3).post();
model.allDifferent(c4).post();
model.allDifferent(c5).post();
model.allDifferent(c6).post();
model.allDifferent(c7).post();
model.allDifferent(c8).post();
model.allDifferent(c9).post();
model.allDifferent(c10).post();
model.allDifferent(c11).post();
model.allDifferent(c12).post();
model.allDifferent(c13).post();
// 4. Solve the problem



    Solver solver = model.getSolver();
    solver.showStatistics();
    solver.showSolutions();
    solver.findSolution();
    new KakuroForm2Book2P3().setVisible(true);

// 5. Print the solution

for ( i = 0; i < 9; i++)
    {
for ( j = 0; j < 9; j++)
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
 public KakuroForm2Book2P3(){
     
     
         setJMenuBar(menuBar); // Add the menu bar to the window
    
    JMenu fileMenu = new JMenu("File"); // Create File menu
    JMenu elementMenu = new JMenu("Elements"); // Create Elements menu
    menuBar.add(fileMenu); // Add the file menu
    menuBar.add(elementMenu); // Add the element menu 
    
        JPanel pannel=new JPanel(); // Create jpanel
         pannel.setLayout(new GridLayout(9,9)); // Set Grid to 6 x 6 matrix
         pannel.setBounds(500,20, 500, 500);  // Set size and position
         setDefaultCloseOperation(EXIT_ON_CLOSE); //Close frame
                
          
        
       for (int i=0;i<9;i++)
            {
               for (int j=0;j<9;j++)
                     {
                         if(i==0 && j==0){
                         String s = "\\";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                        else if(i==0 && j==1){
                         String s = "7\\";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                        else if(i==0 && j==2){
                         String s = "36\\";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                        else if(i==0 && j==3){
                         String s = "\\";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                        else if(i==0 && j==4){
                         String s = "\\";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                        else if(i==0 && j==5){
                         String s = "10\\";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                         else if(i==0 && j==6){
                         String s = "24\\";
                       JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                          else if(i==0 && j==7){
                         String s = "\\";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                           else if(i==0 && j==8){
                         String s = "\\";
                       JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                        else if(i==1 && j==0){
                         String s = "\\8";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                        else if(i==1 && j==3){
                         String s = "\\";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                        else if(i==1 && j==4){
                         String s = "\\17";
                       JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                        else if(i==1 && j==7){
                         String s = "31\\";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                        else if(i==1 && j==8){
                         String s = "\\";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                        else if(i==2 && j==0){
                         String s = "\\15";
                       JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                        else if(i==2 && j==3){
                         String s = "9\\";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                        else if(i==2 && j==4){
                         String s = "\\12";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                        
                        
                        else if(i==2 && j==8){
                         String s = "\\";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                        else if(i==3 && j==0){
                         String s = "\\";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                        else if(i==3 && j==1){
                         String s = "11\\4";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,9));
                      
                        pannel.add(box);
                         }
                        else if(i==3 && j==4){
                         String s = "3\\";
                       JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                        else if(i==3 && j==5){
                         String s = "8\\8";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                         else if(i==3 && j==8){
                         String s = "5\\";
                       JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                          else if(i==4 && j==0){
                         String s = "\\29";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                           else if(i==4 && j==6){
                         String s = "3\\4";
                       JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                            else if(i==5 && j==0){
                         String s = "\\3";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                             else if(i==5 && j==3){
                         String s = "7\\17";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,9));
                      
                        pannel.add(box);
                         }
                              else if(i==6 && j==0){
                         String s = "\\";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                          else if(i==6 && j==1){
                         String s = "\\3";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }  
                              else if(i==6 && j==4){
                         String s = "4\\";
                       JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }    else if(i==6 && j==5){
                         String s = "\\6";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                         
                             else if(i==6 && j==8){
                         String s = "8\\";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                          else if(i==7 && j==0){
                         String s = "\\";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }   else if(i==7 && j==1){
                         String s = "\\11";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }  else if(i==7 && j==5){
                         String s = "\\";
                       JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }  else if(i==7 && j==6){
                         String s = "\\12";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }    else if(i==8 && j==0){
                         String s = "\\";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }   else if(i==8 && j==1){
                         String s = "\\";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }   else if(i==8 && j==2){
                         String s = "\\7";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }  else if(i==8 && j==5){
                         String s = "\\";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }  else if(i==8 && j==6){
                         String s = "\\10";
                        JButton box = new JButton(""+s);
                          box.setBackground(Color.cyan);
                         box.setFont(new Font("TimesRoman",Font.PLAIN,11));
                      
                        pannel.add(box);
                         }
                          
                        
               else{

                        int p = bd [i][j].getValue();
                        if(p!= 0){
                           JButton blank = new JButton(""+p);
                            blank.setBackground(Color.pink);
                            blank.setFont(new Font("TimesRoman",Font.PLAIN,11));
                            pannel.add(blank);
                        }   } }  }
        add(pannel); }

}
/*
OUTPUT:

* Choco 4.0.0 (2016-09) : Constraint Programming Solver, Copyleft (c) 2010-2016
- Model[my third kakuro problem] features:
	Variables : 177
	Constraints : 275
	Default search strategy : no
	Completed search strategy : no
- Solution #1 found. Model[my third kakuro problem], 1 Solutions, Resolution time 0.102s, 3 Nodes (29.5 n/s), 1 Backtracks, 1 Fails, 0 Restarts 
	bd[0][0] = 0 bd[0][1] = 0 bd[0][2] = 0 bd[0][3] = 0 bd[0][4] = 0 bd[0][5] = 0 bd[0][6] = 0 bd[0][7] = 0 bd[0][8] = 0 bd[1][0] = 0 bd[1][1] = 1 bd[1][2] = 7 bd[1][3] = 0 bd[1][4] = 0 bd[1][5] = 9 bd[1][6] = 8 bd[1][7] = 0 bd[1][8] = 0 bd[2][0] = 0 bd[2][1] = 6 bd[2][2] = 9 bd[2][3] = 0 bd[2][4] = 0 bd[2][5] = 1 bd[2][6] = 9 bd[2][7] = 2 bd[2][8] = 0 bd[3][0] = 0 bd[3][1] = 0 bd[3][2] = 3 bd[3][3] = 1 bd[3][4] = 0 bd[3][5] = 0 bd[3][6] = 7 bd[3][7] = 1 bd[3][8] = 0 bd[4][0] = 0 bd[4][1] = 9 bd[4][2] = 6 bd[4][3] = 8 bd[4][4] = 1 bd[4][5] = 5 bd[4][6] = 0 bd[4][7] = 3 bd[4][8] = 1 bd[5][0] = 0 bd[5][1] = 2 bd[5][2] = 1 bd[5][3] = 0 bd[5][4] = 2 bd[5][5] = 3 bd[5][6] = 1 bd[5][7] = 7 bd[5][8] = 4 bd[6][0] = 0 bd[6][1] = 0 bd[6][2] = 2 bd[6][3] = 1 bd[6][4] = 0 bd[6][5] = 0 bd[6][6] = 2 bd[6][7] = 4 bd[6][8] = 0 bd[7][0] = 0 bd[7][1] = 0 bd[7][2] = 8 bd[7][3] = 2 bd[7][4] = 1 bd[7][5] = 0 bd[7][6] = 0 bd[7][7] = 5 bd[7][8] = 7 bd[8][0] = 0 bd[8][1] = 0 bd[8][2] = 0 bd[8][3] = 4 bd[8][4] = 3 bd[8][5] = 0 bd[8][6] = 0 bd[8][7] = 9 bd[8][8] = 1 r0[0] = 1 r0[1] = 7 r1[0] = 9 r1[1] = 8 r2[0] = 6 r2[1] = 9 r3[0] = 1 r3[1] = 9 r3[2] = 2 r4[0] = 3 r4[1] = 1 r5[0] = 7 r5[1] = 1 r6[0] = 9 r6[1] = 6 r6[2] = 8 r6[3] = 1 r6[4] = 5 r7[0] = 3 r7[1] = 1 r8[0] = 2 r8[1] = 1 r9[0] = 2 r9[1] = 3 r9[2] = 1 r9[3] = 7 r9[4] = 4 r10[0] = 2 r10[1] = 1 r11[0] = 2 r11[1] = 4 r12[0] = 8 r12[1] = 2 r12[2] = 1 r13[0] = 5 r13[1] = 7 r14[0] = 4 r14[1] = 3 r15[0] = 9 r15[1] = 1 c0[0] = 1 c0[1] = 6 c1[0] = 9 c1[1] = 2 c2[0] = 7 c2[1] = 9 c2[2] = 3 c2[3] = 6 c2[4] = 1 c2[5] = 2 c2[6] = 8 c3[0] = 1 c3[1] = 8 c4[0] = 1 c4[1] = 2 c4[2] = 4 c5[0] = 1 c5[1] = 2 c6[0] = 1 c6[1] = 3 c7[0] = 9 c7[1] = 1 c8[0] = 5 c8[1] = 3 c9[0] = 8 c9[1] = 9 c9[2] = 7 c10[0] = 1 c10[1] = 2 c11[0] = 2 c11[1] = 1 c11[2] = 3 c11[3] = 7 c11[4] = 4 c11[5] = 5 c11[6] = 9 c12[0] = 1 c12[1] = 4 c13[0] = 7 c13[1] = 1 .
- Complete search - 1 solution found.
	Model[my third kakuro problem]
	Solutions: 1
	Building time : 0.000s
	Resolution time : 0.106s
	Nodes: 3 (28.2 n/s) 
	Backtracks: 1
	Fails: 1
	Restarts: 0
 0 0 0 0 0 0 0 0 0
 0 1 7 0 0 9 8 0 0
 0 6 9 0 0 1 9 2 0
 0 0 3 1 0 0 7 1 0
 0 9 6 8 1 5 0 3 1
 0 2 1 0 2 3 1 7 4
 0 0 2 1 0 0 2 4 0
 0 0 8 2 1 0 0 5 7
 0 0 0 4 3 0 0 9 1

*/
