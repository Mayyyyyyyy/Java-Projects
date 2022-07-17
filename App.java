
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyle;

import DishUtils.*;

public class App{
    public static ArrayList<Dish> dishList = new ArrayList<Dish>();
    public static ArrayList<Dish> orderedDish = new ArrayList<Dish>();

    public static void main(String[] args){
      //  for (int i = 0; i < dishList.size(); i++) {
      //    System.out.println(dishList.get(i).getId()+"\n");
      //  }
      createMenu();
      Scanner s = new Scanner(System.in);
       while(true){
          Utils.showMainMenu();
          int num = s.nextInt();
          System.out.print("用户输入数字"+num+"\n");
          switch(num){
            case 1:
               while(true){
                showMenu();
                int menuN = s.nextInt();
                if(menuN == 0){
                  break;
                }
                orderedDish.add(dishList.get(menuN-1));
               }
               break;
            case 2:
              //  System.out.print("!!!!!!   1" + "\n");
               showOrderedDishes();
              //  System.out.print("!!!!!!   3" + "\n");
               break;
            case 3:
               buy();
               return;
          }
       }
    }
    
    public static void createMenu() {
      dishList.add(new Dish(1, "鱼香肉丝", 16.0));
      dishList.add(new Dish(2, "酸辣土豆丝", 24.0));
      dishList.add(new Dish(3, "麻辣小龙虾", 59.0));
      dishList.add(new Dish(4, "鸡公煲", 29.0));
    }

    public static void showMenu() {
      System.out.print("--------输入数字选择菜品------"+"\n");
      for (int i = 0; i < dishList.size(); i++) {
        Dish item = dishList.get(i);
        System.out.println(item.getId() + ".\t\t\t" + item.getName() +"\t\t\t"+ item.getPrice() +"\n");
      }
      System.out.print("-----输入0返回主菜单-----\n");
    }

    public static void showOrderedDishes(){
      // System.out.print("!!!!!!  2" + "\n");
      System.out.print("--------已选菜品------" + "\n");
      for (int i = 0; i < orderedDish.size(); i++) {
        Dish item = orderedDish.get(i);
        System.out.println(item.getId() + ".\t\t\t" + item.getName() + "\t\t\t" + item.getPrice() + "\n");
      }
      // System.out.print("-----输入0返回主菜单-----\n");
    }

    public static void buy(){
      double total = 0;
      for (int i = 0; i < orderedDish.size(); i++) {
        Dish item = orderedDish.get(i);
        total+=item.getPrice();
      }
      System.out.print("您需支付" +total+"元"+ "\n");
    }
}

