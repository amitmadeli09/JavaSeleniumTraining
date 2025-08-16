package day6;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class ScheduleTask {

    public static void main(String[] args) {
        // Creating Hashmap 
        HashMap<Integer, String> map=new HashMap<>();

        // mapping the time with tasks
        map.put(9,"Breakfast (9:00 - 9:30)");
        map.put(10,"Coding (9:30 - :12:30)");
        map.put(11,"Coding (9:30 - 12:30)");
        map.put(12,"Bath and Lunch (12:30 - 14:00 )");
        map.put(13,"Bath and Lunch (12:30 - 14:00)");
        map.put(14,"Reading (14:00 - 16:00 PM)");
        map.put(15,"Reading (14:00 - 16:00 PM)");
        map.put(16,"Nap (16:00 - 18:00 PM)");
        map.put(17,"Nap (16:00 - 18:00 PM)");

        //Using scanner class for taking the input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an hour (24 hours Format):  ");
        String input = sc.nextLine();

        int hour;
        if(input.isEmpty()) {  //is empty function is only available in non-primitive data types             
        	Random random = new Random(); //random class used to generate random number
        	hour = random.nextInt(24);
        	System.out.println("Random Hour Selected: "+hour);
        }else {
        	hour = Integer.parseInt(input);  //converting string to int
        }
        
        if(map.containsKey(hour)) {
        	System.out.println("Task Schedules: "+hour+":00->"+map.get(hour));
        }else {
        	System.out.println("No tasks has been Scheduled "+ hour+":00");
        }
        sc.close();
    }
}