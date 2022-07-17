import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.plaf.synth.SynthStyle;

import Bills.Bill;


public class App {
    static ArrayList<Bill> billList = new ArrayList<Bill>();
    static{
        billList.add(new Bill(1, "支出", "购物",101 ,"2021-01-02"));
        billList.add(new Bill(2, "支出", "家具", 200,"2021-02-02"));
        billList.add(new Bill(3, "收入", "工资", 350,"2021-03-02"));
        billList.add(new Bill(4, "收入", "红包", 271,"2022-04-02"));
        billList.add(new Bill(5, "支出", "交通",560, "2022-05-02"));
    }
    public static void main(String[] args) {
        boolean flag = true;
        while(flag){
            showMainMenu();
            Scanner s = new Scanner(System.in);
            int mainInt = s.nextInt();
            System.out.println("用户输入：" + mainInt);
            switch (mainInt) {
                case 1:
                    addBill();
                    break;
                case 2:
                    deleteBill();
                    break;
                case 3:
                    queryAccount();
                    break;
                case 4:
                    flag = false;
                    break;
            }
            // s.close();
        }
    }
    
    private static void showMainMenu() {
        System.out.println("------主菜单，请输入数字-------");
        System.out.println("1，添加账单\t\t 2，删除账单\t\t 3，查询账单\t\t 4，退出");
    }

    private static void deleteBill() {
        System.out.println("------主菜单>>删除账单-------");
        Scanner s = new Scanner(System.in);
        System.out.println("请输入账单ID");
        int id = s.nextInt();
        billList.remove(id-1);
        System.out.println("账单删除成功");
    }

    private static void addBill() {
        System.out.println("------主菜单>>添加账单-------");
        Bill bill = new Bill(0, null, null, 0, null);
        Scanner s = new Scanner(System.in);
        System.out.println("请输入ID");
        bill.setId(s.nextInt());
        System.out.println("请输入类型");
        bill.setType(s.next());
        System.out.println("请输入内容");
        bill.setContent(s.next());
        System.out.println("请输入金额");
        bill.setAmount(s.nextInt());
        System.out.println("请输入时间");
        bill.setTime(s.next());
        billList.add(bill);
        System.out.println("账单添加成功");
    }
    
    private static void queryAccount() {
        System.out.println("------主菜单>>查询账单-------");
        System.out.println("1，查询所有\t\t 2，按类型查询\t\t 3，按时间查询\t\t ");
        System.out.println("请输入数字");
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        switch(num){
            case 1:
                queryAll();
                break;
            case 2:
                queryByType();
                break;
            case 3:
                queryByTime();
                break;
        }
    }
    
    private static void queryAll() {
        System.out.println("ID\t\t类型\t\t内容\t\t金额\t\t时间\t\t");
        for(int i = 0; i< billList.size();i++){
            Bill bill = billList.get(i);
            System.out.println(bill.getId()+"\t\t"+bill.getType()+"\t\t"+bill.getContent()+"\t\t"+bill.getAmount()+"\t\t"+bill.getTime());
        }
    }
    
    private static void queryByType() {
        System.out.println("请输入类型：收入或支出");
        Scanner s = new Scanner(System.in);
        String type = s.nextLine();
        System.out.println("ID\t\t类型\t\t内容\t\t金额\t\t时间\t\t");
        billList.stream().filter(item->item.getType().equals(type)).forEach(bill->{
            System.out.println(bill.getId() + "\t\t" + bill.getType() + "\t\t" + bill.getContent() + "\t\t"
                    + bill.getAmount() + "\t\t" + bill.getTime());
        });;
    }

    private static void queryByTime() {
        System.out.println("请输入开始时间");
        Scanner s1 = new Scanner(System.in);
        String start = s1.nextLine();
        System.out.println("请输入结束时间");
        Scanner s2 = new Scanner(System.in);
        String end = s2.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("ID\t\t类型\t\t内容\t\t金额\t\t时间\t\t");
        billList.stream().filter(item -> {
            try {
                Date startTime = sdf.parse(start);
                Date endTime = sdf.parse(end);
                Date time = sdf.parse(item.getTime());
                if(time.before(endTime)&& time.after(startTime)){
                    return true;
                }
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return false;
        }).forEach(bill -> {
            System.out.println(bill.getId() + "\t\t" + bill.getType() + "\t\t" + bill.getContent() + "\t\t"
                    + bill.getAmount() + "\t\t" + bill.getTime());
        });
        ;
    }
}
