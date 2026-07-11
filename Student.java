public class Student {
    private int id;
    private String name;
    private int age;
    private String course;
    private String email;
    private String phone_number;

public Student(int id,String name,int age,String course,String email,String phone_number)
{
    this.id=id;
    this.name=name;
    this.age=age;
    this.course=course;
    this.email=email;
    this.phone_number=phone_number;
}
//getter
public int getid()
{
    return id;
}
public String getname()
{
    return name;
}
public int getage()
{
    return age;
}
public String getcourse()
{
    return course;
}
public String getemail()
{
    return email;
}
public String getno()
{
    return phone_number;
}

//setter
    public void setid(int id) {
        this.id=id;
    }
    public void setname(String name) {
        this.name=name;
    }
    public void setage(int age) {
        this.age=age;
    }
    public void setcourse(String course) {
        this.course=course;

    }
    public void setemail(String email) {
        this.email=email;
    }
public void setno(String phone_number) {
    this.phone_number=phone_number;
}
public void display()
{
    System.out.println("-----------------------------------------------");
    System.out.println("ID: "+id);
    System.out.println("Student Name: "+name);
    System.out.println("Age: "+age);
    System.out.println("Course: "+course);
    System.out.println("Email: "+email);
    System.out.println("Phone: "+phone_number);
    System.out.println("-----------------------------------------------");

}
}