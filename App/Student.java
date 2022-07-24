package App;

public class Student {
    public int id;
    public String name;
    public String sex;
    public float math;
    public float english;
    public float physics;

    public Student() {
        
    }

    public Student(int id,String name,String sex,float math,float english,float physics) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.math = math;
        this.english = english;
        this.physics = physics;
    }
}
