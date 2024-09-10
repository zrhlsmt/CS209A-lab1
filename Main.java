import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private ArrayList<emp> system=new ArrayList<>();

    public void add(String name ,int age){
        int exist=0;
        for (int i = 0; i < system.size(); i++) {
            if (system.get(i).name.equals(name)){
                exist=1;
                break;
            }
        }
        if (exist==0){
            emp a=new emp(name,age);
            system.add(a);
        }
    }

    public void delete(String name){
        for (int i = 0; i < system.size(); i++) {
            if (system.get(i).name.equals(name)){
                system.remove(i);
                break;
            }
        }
    }

    public void print(){
        system.sort(Comparator.comparing(emp::getName));
        for (int i = 0; i < system.size(); i++) {
            System.out.println(system.get(i).name);
        }
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Main main=new Main();
        int quit=0;
        while (quit==0){
            String oper= scanner.next();
            if (oper.equals("quit")){
                quit=1;
            } else if (oper.equals("add")) {
                String name=scanner.next();
                int age=scanner.nextInt();
                main.add(name,age);
            }else if (oper.equals("delete")){
                String name=scanner.next();
                main.delete(name);
            } else if (oper.equals("print")) {
                main.print();
            }
        }

    }
}

class emp{
    String name;
    int age;

    public emp(String name,int age){
        this.name=name;
        this.age=age;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

}