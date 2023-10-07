/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exam_4;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Exam_3 {
    
    
        
     private class PriorityNode {
        int printCount;
        int priority;
        PriorityNode next;

        PriorityNode(int printCount, int priority) {
            this.printCount = printCount;
            this.priority = priority;
            this.next = null;
        }
    }

    private PriorityNode front;
    private int printCount;
    
   
    public Exam_3 () {
        front = null;
        
    }
    
    private void insertion (int printcount, int priority) throws Exception{
        PriorityNode newnode = new PriorityNode(printcount,priority);
        
        
        if (front == null|| priority <= front.priority) {
          newnode.next = front;
          front = newnode;
          
        } else {
            PriorityNode temp = front;
            while (temp.next != null && temp.next.priority <= priority) {                
                temp = temp.next;
            }
            newnode.next = temp.next;
            temp.next = newnode;
        }
       
        if (printCount >4) {
            deletion();
        }
         printCount++;
    }
   
    public int deletion() throws Exception {
        
        if (front == null) {
            throw new Exception("Queue is empty");
        
        }
        
        int temp = front.printCount;
        front = front.next;
        printCount --;
        return temp;
        
    }
    public void display () throws Exception {
        if (front == null) {
          throw new Exception("Queue is empty");
        }
        PriorityNode temp = front;
        System.out.println("Priority Queue");
        while (temp!= null) {            
            System.out.println("PrintCount: " + temp.printCount +" priority ->" + temp.priority);
            temp = temp.next;
        }
       
        
    }
    
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner (System.in);
        Exam_3 list = new Exam_3 ();
        
        while (true) {            
            System.out.println("======Priority Queue Printing=====");
            System.out.println("1. to insert number of pages and priority");
            
            System.out.println("2. to display the list of priority print");
            System.out.println("3. to exit program");
            int input = in.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Enter number of pages");
                    int insert1 = in.nextInt();
                    System.out.println("Enter priority Number");
                    int prio = in.nextInt();
                    list.insertion(insert1, prio);
                    break;
                case 2:
                    System.out.println("display priority prints");
                {
                    try {
                        list.display();
                    } catch (Exception ex) {
                        Logger.getLogger(Exam_3.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;

                default:
                    throw new AssertionError();
            }
        }
    }
    
}
