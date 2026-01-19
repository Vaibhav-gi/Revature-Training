public class StudentObj {
    int stid;
    String name;
    String course;
    public StudentObj()
    {}
    public StudentObj(int id,String n,String c)
    {
        this.stid=id;
        this.name=n;
        this.course=c;
    }

    @Override
    public String toString() {
        return "StudentObj{" +
                "stid=" + stid +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                '}';
    }

    public static void main(String[] args) {
        StudentObj [] studentlist=new StudentObj[4];
        studentlist[0]=new StudentObj(1,"Hari","Java");
        studentlist[1]=new StudentObj(2,"Raman","Csharp");
        studentlist[2]=new StudentObj(3,"Rishi","Python");
        studentlist[3]=new StudentObj(4,"Narayan","Spring boot");
        for (int i=0;i<=3;i++)
        {
            System.out.println(studentlist[i]);
        }


    }
}
