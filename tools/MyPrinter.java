package blackjack.tools;

import java.util.Map;

public class MyPrinter {

    public static Object backUp;

    public  MyPrinter(){
   
   }

    public static void title(Object toBePrint){
        MyPrinter.backUp = toBePrint;
        System.out.println();
        System.out.println("<------------" + toBePrint + "------------>");
        System.out.println();
    }
    
      public static void pr(Object toBePrint){
        MyPrinter.backUp = toBePrint;
        //System.out.println("------------ PRINTER ------------ ");
        System.out.println("------ " + toBePrint);
        System.out.println();
    }
      
     public static void printBunsh(Map<Object, Object> map){
         for(Object key : map.keySet()){
             System.out.print(map.get(key) + "\t");
         }
     } 

}
