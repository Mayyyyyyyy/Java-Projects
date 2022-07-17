package DishUtils;

import java.io.*;
import java.util.ArrayList;

public class Utils {
    
    static ArrayList<Dish> dishList = new ArrayList<Dish>();

    public static void createMenu() {
       
        dishList.add(new Dish(1, "鱼香肉丝", 16.0));
        dishList.add(new Dish(2, "酸辣土豆丝", 24.0));
        dishList.add(new Dish(3, "麻辣小龙虾", 59.0));
        dishList.add(new Dish(4, "鸡公煲", 29.0));
    }

    public static void showMainMenu(){
        System.out.print("-----主菜单，输入数字进入界面-----\n");
        System.out.print("1\t\t\t菜单\n");
        System.out.print("2\t\t\t已点\n");
        System.out.print("3\t\t\t买单\n");
        System.out.print("-----输入0返回主菜单-----\n");
    }

    public static void showMenu(ArrayList list){
        System.out.print("--------输入数字选择菜品------");
        for (int i = 0; i < dishList.size(); i++) {
            Dish item= dishList.get(i);
            System.out.println(item.id+".-------"+item.name + "\n");
        }
        System.out.print("-----输入0返回主菜单-----\n");
    }
}
