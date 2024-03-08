import java.util.Scanner;

public class Stack 
{
    public static void main(String args[])
    {
        Scanner sobj = new Scanner(System.in);
        StackDS obj = new StackDS();
        int Choice = 0;

        while(Choice != 5){
        System.out.println("Enter You Choice !!!");
        System.out.println("1.Push in Stack : ");
        System.out.println("2.Pop from Stack : ");
        System.out.println("3.Display : ");
        System.out.println("4.CountNode : ");
        System.out.println("5.Exit : ");
        Choice = sobj.nextInt();
        
        switch(Choice)
        {
            case 1:
                System.out.println("----------------------------------------------------------------");
                System.out.println("Enter the number you want to Push in Stack : ");
                int Num = sobj.nextInt();
                obj.Push(Num);
                System.out.println("----------------------------------------------------------------");
                break;
            case 2:
                System.out.println("----------------------------------------------------------------");
                System.out.println("POP function called : ");
                int No = obj.Pop();
                System.out.println("Poped value from the stack is : "+No);
                System.out.println("----------------------------------------------------------------");
                break;
            case 3:
                System.out.println("----------------------------------------------------------------");
                System.out.println("Display function called : ");
                obj.Display();
                System.out.println("----------------------------------------------------------------");
                break;
            case 4:
                System.out.println("----------------------------------------------------------------");
                System.out.println("CountNodes function called : ");
                int Count = obj.CountNode();
                System.out.println("Number of Nodes in stack are : "+Count);
                System.out.println("----------------------------------------------------------------");
                break;
            case 5:
                System.out.println("Stack Exited Sucessfully...");
                System.out.println("----------------------------------------------------------------");
                System.out.println("----------------------------------------------------------------");
                return;
            default:
                System.out.println("Please Enter valid Choice...");
                break;
            
        } 
    }
    sobj.close();  
        
    }
    
}

class node
{
    public int data;
    public node next;

    public node(int A)
    {
        data = A;
        next = null;
    }
}

class StackDS
{
    private node first;

    public StackDS()
    {
        first = null;
    }

    public void Push(int no)
    {
        node newn = new node(no);

        if(first == null)
        {
            first = newn;
            newn.next = null;
        }
        else
        {
            newn.next = first;
            first = newn;
        }
    }

    public int Pop()
    {
        int Val = 0;

        if(first == null)
        {
            System.out.println("The Stack is already Empty...");
            return -1;
        }
        else
        {
            Val = first.data;
            first = first.next;
        }
        return Val;
    }

    public void Display()
    {
        node Temp = first;

        System.out.println("Contents of Stack is : ");

        while(Temp != null)
        {
            System.out.println("|"+Temp.data+"|");
            Temp = Temp.next;
        }System.out.println();

    }

    public int CountNode()
    {
        node Temp = first;
        int iCnt = 0;

        while(Temp != null)
        {
            iCnt++;
            Temp = Temp.next;
        }
        return iCnt;
    }
}
