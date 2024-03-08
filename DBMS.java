
//===============================================================================
//*********************Customized DataBase Management System*********************
//===============================================================================



class DBMS
{
    public static void main(String ARgs[])
    {
        DataBase obj = new DataBase();

        obj.InsertIntoTable(1,"Amit","Pune", 89);
        obj.InsertIntoTable(2,"Pooja","Mumbai", 95);
        obj.InsertIntoTable(3,"Rahul","Satara", 80);
        obj.InsertIntoTable(4,"Neha","Pune", 78);

        obj.SelectStarFrom();

    }
}

class node
{
    public int Rno;
    public String Name;
    public String City;
    public int Marks;
    public node next;

    public node(int A,String B,String C,int D)
    {
        Rno = A;
        Name = B;
        City = C;
        Marks = D;
        next = null;
    }
}

class DataBase
{
    public node first;

    public DataBase()
    {
        first = null;
        System.out.println("DBMS initialized sucessfully...");
        System.out.println("Student table get created Sucessfully...");
    }

    //insert into table student values(1,Amit,pune,100);
    public void InsertIntoTable(int Rno,String Name,String City,int Marks)
    {
        node newn = new node(Rno, Name, City, Marks);
        node Temp = first;

        if(first == null)
        {
            first = newn;
        }
        else if(first.next == null)
        {
            first.next = newn;
        }
        else
        {
            while(Temp.next != null)
            {
                Temp = Temp.next;
            }
            Temp.next = newn;

        }
         System.out.println("One record inserted sucessfully...");

    }

    //select * from student
    //Display

    public void SelectStarFrom()
    {
        System.out.println("Data from the student table is : ");

        node Temp = first;
        
        System.out.println("--------------------------------------------------------------");
        while(Temp != null)
        {
            System.out.println("| "+Temp.Rno+"\t"+Temp.Name+"\t"+Temp.City+"\t"+Temp.Marks+"  | ");
            Temp = Temp.next;
        }
        System.out.println("--------------------------------------------------------------");

    }
}

