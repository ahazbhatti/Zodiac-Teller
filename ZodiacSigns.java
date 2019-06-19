

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.GridBagConstraints;

import java.awt.GridBagLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.GregorianCalendar;

import java.text.DateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JOptionPane;

import javax.swing.JPanel;

import javax.swing.JTextField;

public class ZodiacSigns {

public static void main(String[] args) {

      JFrame frame = new JFrame("Zodiac Signs");
      frame.setLocation(-100,100);
      // Setting location for frame
      // Creating frame
      
      JPanel panel = new JPanel(new GridBagLayout());
      panel.setBackground(Color.YELLOW);
      Dimension preferredSize = new Dimension(600, 480);
	  panel.setPreferredSize(preferredSize);
      

      JButton submit = new JButton("Submit");
      submit.setBackground(Color.RED);
      
      // 

      JButton clear = new JButton("Clear");
      clear.setBackground(Color.GREEN);

      JTextField yearField = new JTextField(10);

      JTextField monthField = new JTextField(10);

      JTextField dayField = new JTextField(10);

      JLabel zodiac = new JLabel();

      GridBagConstraints constraints = new GridBagConstraints();

      constraints.gridx = 0; //column 1

      constraints.gridy = 1; //row 2

     panel.add(new JLabel("Enter year: "), constraints);

      constraints.gridx = 2; //column 3

      panel.add(yearField, constraints);

      constraints.gridx = 0; //column 1

      constraints.gridy = 3; //row 4

      panel.add(new JLabel("Enter month: "), constraints);

      constraints.gridx = 2; //column 3

      panel.add(monthField, constraints);

      constraints.gridx = 0; //column 1

      constraints.gridy = 5; //row 6

      panel.add(new JLabel("Enter day: "), constraints);

      constraints.gridx = 2; //column 3

      panel.add(dayField, constraints);

      constraints.gridx = 0; //column 1
      constraints.gridy = 6; //row 7

      panel.add(submit, constraints);

      constraints.gridx = 2; //column 3

      panel.add(clear, constraints);

      constraints.gridx = 1; //column 2

      constraints.gridy = 8; //row 9
      

      panel.add(zodiac, constraints);
      JLabel icon = new JLabel();
      Dimension preferredSize2 = new Dimension(240, 200);
      icon.setPreferredSize(preferredSize2);
      constraints.gridx = 1; //column 2

      constraints.gridy = 0; //row 11
      
      panel.add(icon, constraints);

      frame.getContentPane().setLayout(new FlowLayout());

      frame.getContentPane().add(panel);

      frame.setVisible(true);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.setSize(550, 490);

  

      zodiac.setText(calendar.getTime().toString());

  

  

submit.addActionListener(new ActionListener() {
// Keeps listening for input
      

       @Override

       public void actionPerformed(ActionEvent e) {

           try

           {

              int day = Integer.valueOf(dayField.getText());

                 

              int month = Integer.valueOf(monthField.getText())-1;

             

              int year = Integer.valueOf(yearField.getText());

          

              if(!validDay(day, month, year) && !validMonth(month))

              {

                   return;

              }

              calendar.set(year, month, day); // Set the calendar to the date entered

          

              // Match the year for the sign start dates

             

              for(int i = 0 ; i < signStartDates.length ; ++i)

             //Get signs from array list

              signStartDates[i].set(GregorianCalendar.YEAR, year);

             

              for(int i = 0 ; i < signStartDates.length ; ++i)

             

              if(calendar.after(signStartDates[i]) && calendar.before(signStartDates[(i+1)%signStartDates.length])) {

             

              zodiac.setText(df.format(calendar.getTime()) + " is in the sign of " + signs[i]);
             
              
              icon.setIcon(new ImageIcon("C:\\Users\\Ahaz\\Desktop\\icons\\" + signs[i] + ".png"));
           
              // import images from my laptop

              break;

             

              }

           }catch (NumberFormatException ne) {
JOptionPane.showMessageDialog(null, "Invalid input. Try again.");

               return;

           }

       }

   });

clear.addActionListener(new ActionListener() {

      

       @Override

       public void actionPerformed(ActionEvent e) {

           dayField.setText("");

           monthField.setText("");

           yearField.setText("");

           zodiac.setText("");
           icon.setIcon(null);
           

       }

   });
}

// }

// Validate the month value

private static boolean validMonth(int month) {

if(month >= 0 && month <= 11)

return true;

else

System.out.println("The month value must be from 1 to 12. Try again.");

return false;

}

// Validate the day value for the month and year

private static boolean validDay(int day, int month, int year) {

/* A valid day must be:

   - between 1 and 31

   - less than 31 when the month is April, June, September, or November

   - less than 29 when the month is February and it is not a leap year

   - less than 30 when the month is February and it is a leap year

*/

if (day < 0 || day > 31) {

   JOptionPane.showMessageDialog(null,"Day values must be between 1 and 31. Try again.");

return false;

}

if(day > 30 && (month == 3 || month == 5 || month == 8 || month == 10)) {

   JOptionPane.showMessageDialog(null,"Day values must be less than 31 when the month" + " is " + MONTH_NAMES[month] + ". Try again.");

return false;

}

if(day > 28 && month == 1 && !calendar.isLeapYear(year)) {

   JOptionPane.showMessageDialog(null,year + " is not a leap year so day values must be less than 29. Try again.");

return false;

}

if(day > 29 && month == 1 && calendar.isLeapYear(year)) {

   JOptionPane.showMessageDialog(null,MONTH_NAMES[month] + " cannot have more than 29 days");

return false;

}

return true;

}

// Names for Zodiac signs and start dates. Remember - months start at zero.

private static String[] signs = {"Aquarius", "Pisces", "Aries" , "Taurus",

   "Gemini" , "Cancer", "Leo" , "Virgo",

   "Libra" ,"Scorpio", "Sagittarius", "Capricorn" };

private static GregorianCalendar[] signStartDates = {

   new GregorianCalendar(2002, 0, 20), // Aquarius start date

   new GregorianCalendar(2002, 1, 19), // Pisces start date

   new GregorianCalendar(2002, 2, 21), // Aries start date

   new GregorianCalendar(2002, 3, 20), // Taurus start date

   new GregorianCalendar(2002, 4, 21), // Gemini start date

   new GregorianCalendar(2002, 5, 21), // Cancer start date

   new GregorianCalendar(2002, 6, 23), // Leo start date

   new GregorianCalendar(2002, 7, 23), // Virgo start date

   new GregorianCalendar(2002, 8, 23), // Libra start date

   new GregorianCalendar(2002, 9, 23), // Scorpio start date

   new GregorianCalendar(2002, 10, 22), // Sagittarius start date

   new GregorianCalendar(2002, 11, 22), // Capricorn start date

};


private static GregorianCalendar calendar = new GregorianCalendar();

// Array defining the names of the months.

// Note that DateFormatSymbols class defines an instance method, getMonths(),

// that will return exactly this array of String objects


private static final String[] MONTH_NAMES = {

   "January" , "February", "March" , "April",

   "May" , "June" , "July" , "August",

   "September", "October" , "November", "December" };

// Date formatter for displaying dates

private static DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);

}