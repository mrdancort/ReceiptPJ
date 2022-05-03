

import java.util.Scanner; //CLASS THAT WILL CAPTURE IMPUT
import java.util.Calendar; //CLASS TO GET THE SATE AND TIME

public class receiptCode
{
  private static Scanner input = new Scanner(System.in);
  private static Calendar dateTime = Calendar.getInstance();
  
  private static String hammockDesc = "", colorSelected = "";
  private static String salesReceipt = String.format("%n%nSALES RECEIPT"
                                                       + "%n%nLAZY HAZY SAYS, INC"
                                                       + "%nHuebner Oaks Mall"
                                                       + "%nSan Antonio, TX"
                                                       + "%n%nDate:   %tD"
                                                       + "%nTime:   %tr%n", dateTime, dateTime);
  
  private static boolean repeat;
  private static double price;
  
  //Default constructor
  public void KriechRAlvarexF()
  {
    
  }
  
  public static void main(String[] arges)
  {
    
    //All the local variables being declared
    int hammock = 0, 
      quantity = 0, 
      color = 0, 
      iterations = 1;
    
    double itemTotal = 0.0,
      subtotal = 0.0,
      discount = 0.0,
      discSubtotal = 0.0,
      tax = 0.0,
      total = 0.0,
      discRate = 0.0;
    
    boolean printFinal = false;
    
    char morePurchases = 'y';
    do
    {
      do
      {
        hammock = promptHammock(); 
        input.nextLine();
        if(hammock < 1 || hammock > 3)
        {
          System.out.printf("You entered an invalid hammock choice. Enter 'Y' to re-enter your choice or 'N' to exit the program:  ");
          morePurchases = input.next().toLowerCase().charAt(0);
        }
      }while(hammock < 1 || hammock > 3 && Character.toLowerCase(morePurchases) == 'y');//should now set hammock price, ask quantity, and then promptColor
      
      if(morePurchases == 'y')
      {
        setHammockSizePrice(hammock);
        quantity = promptQuantity();
        //Calculating ItemTotal
        itemTotal = quantity * price;
        //CALCULATE subtotal
        subtotal += itemTotal;
        do
        {
          color = promptColor();
          input.nextLine();
          if(color < 1 || color > 5)
          {
            System.out.printf("You entered an invalid color choice. Enter 'Y' to re-enter your choice or 'N' to exit the program:  ");
            morePurchases = input.next().toLowerCase().charAt(0);
          }
        }while(color < 1 || color > 5 && Character.toLowerCase(morePurchases) == 'y');
        
        if(morePurchases == 'y')
        {
          setHammockColor(color);
        }
      }
      if(morePurchases == 'y')
      {
        salesReceipt += String.format("%n%-24s %c %-13s %5s %, 7d %4s %s%,14.2f", hammockDesc, '-', colorSelected, " ", quantity, " ", iterations > 1 ? " " : "$", itemTotal);
        System.out.printf("Do you want to purchase another hammock? Enter 'Y' to continue or 'N' to exit the program:  ");
        morePurchases = input.next().toLowerCase().charAt(0);
        if(morePurchases == 'n')
        {
          printFinal = true;
          ++iterations;
        }
      }
      
      
    }while(morePurchases == 'y');
    
    if (subtotal >= 100000.00)
    {
      discRate = .035;
      discount = subtotal * discRate;
    }
    else
    {
      if (subtotal >= 50000.00)
      {
        discRate = .03;
        discount = subtotal * discRate;
      }
      else
      {
        if (subtotal >= 10000.00)
        {
          discRate = .025;
          discount = subtotal * discRate;
        }
        else
        {
          if (subtotal >= 5000.00)
          {
            discRate = .02;
            discount = subtotal * discRate;
          }
          else
          {
            discRate = 0.0;
            discount = 0.0;
          }//END if subtotal >= 5000 else discount = 0
        }//END if subtotal >= 10000 else subtotal >= 5000
      }//END if subtotal >= 50000 else subtotal >= 10000
    }//END if subtotal >= 100000 else subtotal >= 50000
    
    
    
    
    //CALCULATION FOR discSubtotal
    discSubtotal += subtotal - discount;
    //CALCULATION FOR tax  
    tax = discSubtotal * .0825;  
    //CALCULAITON FOR total
    total = discSubtotal + tax;
    
    if(printFinal == true)
    {
      displaySalesReceipt(subtotal, discount, tax, total);
    }
    System.exit(0);
  }//End of the Main
  
  //All methods outside of the main
  public static int promptHammock()
  {
    do
    {
      System.out.printf("%nLAZY HAZY DAYS, INC."
                          + "%n%nOur beautifil cotton hammock sport a traditional "
                          + "look and are very comfortable " 
                          + "%n%n1.  Small - 48 in. x 11 ft. - Good for 1 person\t\t\t\t$100.00 " 
                          + "%n2.  Large - 55 in. x 13 ft. - Good for 2 people\t\t\t\t$140.00 " 
                          + "%n3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people\t\t\t$175.00 " 
                          + "%n%nEnter your choice:  ");  
      
      repeat = !input.hasNextInt();
      
      validateNumber();
    }while(repeat);
    
    return input.nextInt();
  }
  
  public static void setHammockSizePrice(int hammock)
  {
    switch(hammock){
      case 1:
        hammockDesc = "Small - 48 in. x 11 ft.";
        price = 100.00;
        break;
      case 2:
        hammockDesc = "Large - 55 in. x 13 ft.";
        price = 140.00;
        break;
      case 3:
        hammockDesc = "Deluxe - 60 in. x 13 ft.";
        price = 175.00;
        break;
    }
  }
  
  public static int promptQuantity()
  {
    do
    {
      System.out.printf("%nEnter the quantity:  ");
      
      repeat = !input.hasNextInt();
      
      validateNumber();
    }while(repeat);
    
    return input.nextInt();
  }
  
  public static int promptColor()
  {
    do
    {
      System.out.printf("%n%n1. Crimson Red"
                          + "%n2. Emerald Green"
                          + "%n3. Indigo Blue"
                          + "%n4. Natural"
                          + "%n5. Purple Haze"
                          + "%n%nEnter your choice of colors:  ");
      
      repeat = !input.hasNextInt();
      
      validateNumber();
    }while(repeat);
    
    return input.nextInt();
  }
  
  public static void setHammockColor(int color)
  {
    switch(color){
      case 1:
        colorSelected = "Crimson Red";
        break;
      case 2:
        colorSelected = "Emerald Green";
        break;
      case 3:
        colorSelected = "Indigo Blue";
        break;
      case 4:
        colorSelected = "Natural";
        break;
      case 5:
        colorSelected = "Purple Haze";
        break;
    }
  }
  
  public static void validateNumber()
  {
    if (repeat)
    {
      input.next();
      System.out.printf("%nYou must enter a valid integer "
                          + "or floating-point value!%n");
    }
  }
  
  public static void displaySalesReceipt(double subtotal, double discount, double tax, double total)
  {
    salesReceipt += String.format("%n%n%52s %-6s $%,14.2f"
                                    + "%n%52s %-7s %,14.2f"
                                    + "%n%52s %-7s %,14.2f"
                                    + "%n%n%52s %-6s $%,14.2f%n",
                                  "SUBTOTAL:", " ", subtotal,
                                  "DISCOUNT:", " ", discount, "TAX @ 8.250%:",
                                  " ", tax, "TOTAL:", " ", total); 
    System.out.print(salesReceipt);
  }
  
}//End of the Entire application
//Sample output
//Sample output SMALL QUANTITY
/**
 * LAZY HAZY DAYS, INC. 
 
Our beautifil cotton hammock sport a traditional look and are very comfortable  
 
1.  Small - 48 in. x 11 ft. - Good for 1 person    $100.00  
2.  Large - 55 in. x 13 ft. - Good for 2 people    $140.00  
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00  
 
Enter your choice:  q
 
You must enter a valid integer or floating-point value! 
 
LAZY HAZY DAYS, INC. 
 
Our beautifil cotton hammock sport a traditional look and are very comfortable  
 
1.  Small - 48 in. x 11 ft. - Good for 1 person    $100.00  
2.  Large - 55 in. x 13 ft. - Good for 2 people    $140.00  
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00  
 
Enter your choice:  4
You entered an invalid hammock choice. Enter 'Y' to re-enter your choice or 'N' to exit the program:  y
 
LAZY HAZY DAYS, INC. 
 
Our beautifil cotton hammock sport a traditional look and are very comfortable  
 
1.  Small - 48 in. x 11 ft. - Good for 1 person    $100.00  
2.  Large - 55 in. x 13 ft. - Good for 2 people    $140.00  
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00  
 
Enter your choice:  1
 
Enter the quantity:  z
 
You must enter a valid integer or floating-point value! 
 
Enter the quantity:  2
 
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
 
Enter your choice of colors:  6
You entered an invalid color choice. Enter 'Y' to re-enter your choice or 'N' to exit the program:  y
 
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
 
Enter your choice of colors:  4
Do you want to purchase another hammock? Enter 'Y' to continue or 'N' to exit the program:  y
 
LAZY HAZY DAYS, INC. 
 
Our beautifil cotton hammock sport a traditional look and are very comfortable  
 
1.  Small - 48 in. x 11 ft. - Good for 1 person    $100.00  
2.  Large - 55 in. x 13 ft. - Good for 2 people    $140.00  
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00  
 
Enter your choice:  2
 
Enter the quantity:  100
 
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
 
Enter your choice of colors:  2
Do you want to purchase another hammock? Enter 'Y' to continue or 'N' to exit the program:  y
 
LAZY HAZY DAYS, INC. 
 
Our beautifil cotton hammock sport a traditional look and are very comfortable  
 
1.  Small - 48 in. x 11 ft. - Good for 1 person    $100.00  
2.  Large - 55 in. x 13 ft. - Good for 2 people    $140.00  
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00  
 
Enter your choice:  3
 
Enter the quantity:  50
 
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
 
Enter your choice of colors:  5
Do you want to purchase another hammock? Enter 'Y' to continue or 'N' to exit the program:  n
 
 
SALES RECEIPT 
 
LAZY HAZY SAYS, INC 
Huebner Oaks Mall 
San Antonio, TX 
 
Date:   10/25/21 
Time:   06:31:18 PM 
 
Small - 48 in. x 11 ft.  - Natural                   2      $        200.00 
Large - 55 in. x 13 ft.  - Emerald Green           100      $     14,000.00 
Deluxe - 60 in. x 13 ft. - Purple Haze              50      $      8,750.00 
 
                                           SUBTOTAL:        $     22,950.00 
                                           DISCOUNT:                 573.75 
                                       TAX @ 8.250%:               1,846.04 
 
                                              TOTAL:        $     24,222.29 

*/
/** 
 * SAMPLE QUANTITY LARGE ORDER
 * 
 * LAZY HAZY DAYS, INC. 
 
Our beautifil cotton hammock sport a traditional look and are very comfortable  
 
1.  Small - 48 in. x 11 ft. - Good for 1 person    $100.00  
2.  Large - 55 in. x 13 ft. - Good for 2 people    $140.00  
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00  
 
Enter your choice:  1
 
Enter the quantity:  100000
 
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
 
Enter your choice of colors:  4
Do you want to purchase another hammock? Enter 'Y' to continue or 'N' to exit the program:  y
 
LAZY HAZY DAYS, INC. 
 
Our beautifil cotton hammock sport a traditional look and are very comfortable  
 
1.  Small - 48 in. x 11 ft. - Good for 1 person    $100.00  
2.  Large - 55 in. x 13 ft. - Good for 2 people    $140.00  
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00  
 
Enter your choice:  2
 
Enter the quantity:  10000
 
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
 
Enter your choice of colors:  1
Do you want to purchase another hammock? Enter 'Y' to continue or 'N' to exit the program:  y
 
LAZY HAZY DAYS, INC. 
 
Our beautifil cotton hammock sport a traditional look and are very comfortable  
 
1.  Small - 48 in. x 11 ft. - Good for 1 person    $100.00  
2.  Large - 55 in. x 13 ft. - Good for 2 people    $140.00  
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00  
 
Enter your choice:  3
 
Enter the quantity:  1000
 
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
 
Enter your choice of colors:  5
Do you want to purchase another hammock? Enter 'Y' to continue or 'N' to exit the program:  n
 
 
SALES RECEIPT 
 
LAZY HAZY SAYS, INC 
Huebner Oaks Mall 
San Antonio, TX 
 
Date:   10/25/21 
Time:   06:38:12 PM 
 
Small - 48 in. x 11 ft.  - Natural              100,000      $ 10,000,000.00 
Large - 55 in. x 13 ft.  - Crimson Red          10,000      $  1,400,000.00 
Deluxe - 60 in. x 13 ft. - Purple Haze           1,000      $    175,000.00 
 
                                           SUBTOTAL:        $ 11,575,000.00 
                                           DISCOUNT:             405,125.00 
                                       TAX @ 8.250%:             921,514.69 
 
                                              TOTAL:        $ 12,091,389.69 
*/
/** SAMPLE OUTPUT ERRORS
  * LAZY HAZY DAYS, INC. 
 
Our beautifil cotton hammock sport a traditional look and are very comfortable  
 
1.  Small - 48 in. x 11 ft. - Good for 1 person    $100.00  
2.  Large - 55 in. x 13 ft. - Good for 2 people    $140.00  
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00  
 
Enter your choice:  4
You entered an invalid hammock choice. Enter 'Y' to re-enter your choice or 'N' to exit the program:  n
*/
/** SAMPLE OUTPUT ERRORS #2
  * LAZY HAZY DAYS, INC. 
 
Our beautifil cotton hammock sport a traditional look and are very comfortable  
 
1.  Small - 48 in. x 11 ft. - Good for 1 person    $100.00  
2.  Large - 55 in. x 13 ft. - Good for 2 people    $140.00  
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00  
 
Enter your choice:  3
 
Enter the quantity:  0
 
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
 
Enter your choice of colors:  7
You entered an invalid color choice. Enter 'Y' to re-enter your choice or 'N' to exit the program:  n
*/
