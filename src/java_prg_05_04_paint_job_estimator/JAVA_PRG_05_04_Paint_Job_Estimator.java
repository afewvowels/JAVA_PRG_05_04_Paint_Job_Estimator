/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_prg_05_04_paint_job_estimator;

import java.util.Scanner;
/**
 *
 * @author bluebackdev
 * A painting company has determined that for every 115 square feet of wall
 * space, one gallon of paint land eight hours of labor will be required. The
 * company charges $18.00 per hour for labor. Write a program that allows the
 * user to enter the number of rooms to be painted and the price of the paint
 * per gallon. It should also ask for the square feet of wall space in each
 * room. The program should have methods that return the following data:
 * 
 *      * The number of gallons of paint required
 *      * The hours of labor required
 *      * The cost of the paint
 *      * The labor charges
 *      * The total cost of the paint job
 * 
 * Then it should display the data on the screen.
 */
public class JAVA_PRG_05_04_Paint_Job_Estimator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        double dblSquareFootage;
        double dblGallons;
        double dblPaintCost;
        double dblLaborCost;
        double dblTotalCost;
        
        int intNumRooms;
        
        intNumRooms = getNumRooms();
        
        dblSquareFootage = getSquareFootagePerRoom(intNumRooms);
        dblGallons = getGallons(dblSquareFootage);
        dblPaintCost = getGallonsCost(dblGallons);
        dblLaborCost = getHoursLaborCost(dblSquareFootage);
        
        dblTotalCost = calculateCost(dblLaborCost, dblPaintCost);
        
        displayCost(intNumRooms, dblSquareFootage,
            dblGallons, dblPaintCost,
            dblLaborCost, dblTotalCost);
    }
    
    public static int getNumRooms()
    {
        int intNumRooms = -1;
        
        Scanner scrKeyboard = new Scanner(System.in);
        
        while (intNumRooms  <= 0 || intNumRooms > 10)
        {
            System.out.print("Please enter the number\n" +
                    "of rooms to be painted: ");

            intNumRooms = scrKeyboard.nextInt();
        }
        
        return intNumRooms;
    }
    
    public static double getSquareFootagePerRoom(int intNumRooms)
    {
        double dblSquareFootageRoom = -1;
        double dblSquareFootageTotal = 0;
        
        Scanner scrKeyboard = new Scanner(System.in);
        
        for (int i = 0 ; i < intNumRooms ; i++)
        {
            do
            {
                System.out.print("Please enter the square footage\n" +
                        "of room #" + (i + 1) + ": ");
                
                dblSquareFootageRoom = scrKeyboard.nextDouble();
            } while (dblSquareFootageRoom <= 0 || dblSquareFootageRoom > 10000);
            
            dblSquareFootageTotal += dblSquareFootageRoom;
        }
        
        return dblSquareFootageTotal;
    }
    
    public static double getGallons(double dblSquareFootage)
    {
        double dblGallons;
        
        final double DBL_GALLONS_RATIO = 1.0 / 115.0;
        
        dblGallons = DBL_GALLONS_RATIO * dblSquareFootage;
        
        return dblGallons;
    }
    
    public static double getGallonsCost(double dblGallons)
    {
        double dblGallonCost = -1.0;
        double dblPaintCost;
        
        Scanner scrKeyboard = new Scanner(System.in);
        
        while (dblGallonCost <= 0.0 || dblGallonCost > 100.0)
        {
            System.out.print("Please enter the cost of one gallon of paint: $");

            dblGallonCost = scrKeyboard.nextDouble();
        }
        
        dblPaintCost = dblGallonCost * dblGallons;
        
        return dblPaintCost;
    }
    
    public static double getHoursLaborCost(double dblSquareFootage)
    {
        double dblHoursLabor;
        double dblLaborCost;
        
        final double DBL_LABOR_RATIO = 8.0 / 115.0;
        final double DBL_LABOR_COST = 18.0;
        
        dblHoursLabor = DBL_LABOR_RATIO * dblSquareFootage;
        
        dblLaborCost = DBL_LABOR_COST * dblHoursLabor;
        
        return dblLaborCost;
    }
    
    public static double calculateCost(double dblLaborCost, double dblPaintCost)
    {
        double dblTotalCost;
        
        dblTotalCost = dblLaborCost + dblPaintCost;
        
        return dblTotalCost;
    }
    
    public static void displayCost(int intNumRooms, double dblSquareFootage,
            double dblGallons, double dblPaintCost,
            double dblLaborCost, double dblTotalCost)
    {
        System.out.println("Number of rooms: " + intNumRooms);
        System.out.println("Total square footage: " + dblSquareFootage);
        System.out.println("Total gallons of paint required: " + dblGallons);
        System.out.println("Total cost of paint: $" + dblPaintCost);
        System.out.println("Total cost of labor: $" + dblLaborCost);
        System.out.println("Total cost of project: $" + dblTotalCost);
    }
}
