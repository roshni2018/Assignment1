package assignment;

import java.util.ArrayList;
import java.util.Scanner;


public class Assignment {
        
        
        
    public static class clsUserData{
        
        private int SensorID;
	private int MSeconds;
	private int Temparature;

        public int getSensorID() {
            return SensorID;
        }

        public void setSensorID(int SensorID) {
            this.SensorID = SensorID;
        }

        public int getMSeconds() {
            return MSeconds;
        }

        public void setMSeconds(int MSeconds) {
            this.MSeconds = MSeconds;
        }

        public int getTemparature() {
            return Temparature;
        }

        public void setTemparature(int Temparature) {
            this.Temparature = Temparature;
        }
        
        

    }
    
    public static void main(String[] args) {
            
            getTempData();
            
            new Scanner(System.in).nextLine();
            
    }                
         public static void getTempData(){
            
            int duration=1; 
            String deli_1 = "-";
            String deli_2 = ",";
        
            String[] inputData;
            ArrayList<Integer> list1,list2,list3,list4;
         
             
             
            System.out.println("Give Your Input, Seprated by '-'   ");
            System.out.println("eg. : 1,10001,40-1,10010,45-1,11010,50");
            System.out.println("");
            //Get User Input
	    String data = new Scanner(System.in).nextLine();
			
            inputData = data.split(deli_1);

	    ArrayList<clsUserData> listUserData = new ArrayList<clsUserData>();
                        
                        for (int i = 0; i < inputData.length; i++)
			{
				String[] splitdata = inputData[i].split(deli_2);

				clsUserData userInputData = new clsUserData();
				
                                userInputData.setSensorID(Integer.parseInt(splitdata[0]));
				userInputData.setMSeconds(Integer.parseInt(splitdata[1]));
				userInputData.setTemparature(Integer.parseInt(splitdata[2]));
                                
				listUserData.add(userInputData);
			}
                        
                        list1 = new ArrayList<Integer>();
			list2 = new ArrayList<Integer>();
			list3 = new ArrayList<Integer>();
			list4 = new ArrayList<Integer>();

                        for (int i = 0; i < listUserData.size(); i++)
			{
				if (listUserData.get(i).getMSeconds()>= 10000 && listUserData.get(i).getMSeconds()<= 10999)
                                        list1.add(listUserData.get(i).getTemparature());
				
				if (listUserData.get(i).getMSeconds()>= 11000 && listUserData.get(i).getMSeconds()<= 11999)
                                        list2.add(listUserData.get(i).getTemparature());
				
				if (listUserData.get(i).getMSeconds()>= 12000 && listUserData.get(i).getMSeconds()<= 12999)
                                        list3.add(listUserData.get(i).getTemparature());
				
				if (listUserData.get(i).getMSeconds() >= 13000 && listUserData.get(i).getMSeconds() <= 13999)
                                        list4.add(listUserData.get(i).getTemparature());
				
                        }

                        System.out.print("10000 - 10999 :: ");
                        System.out.println(list1.stream().mapToInt(val -> val).average().orElse(0.0));
			
                        System.out.print("11000 - 11999 :: " );
                        System.out.println(list2.stream().mapToInt(val -> val).average().orElse(0.0));
			
                        System.out.print("12000 - 12999 :: ");
                        System.out.println(list3.stream().mapToInt(val -> val).average().orElse(0.0));
			
                        System.out.print("13000 - 13999 :: ");
                        System.out.println(list4.stream().mapToInt(val -> val).average().orElse(0.0));
         }
    
}
