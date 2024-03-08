import java.util.Scanner;

public class Queue 
{
    public static void main(String args[])
    {
        Scanner sobj = new Scanner(System.in);
        QueueDS obj = new QueueDS();
        
        int Choice = 0;

        while(Choice != 5){
        System.out.println("Enter You Choice !!!");
        System.out.println("1.Enqueue in Queue : ");
        System.out.println("2.Dequeue from Queue : ");
        System.out.println("3.Display : ");
        System.out.println("4.CountNode : ");
        System.out.println("5.Exit : ");
        Choice = sobj.nextInt();
        
        switch(Choice)
        {
            case 1:
                System.out.println("----------------------------------------------------------------");
                System.out.println("Enter the Number in the Queue : ");
                int Num = sobj.nextInt();
                obj.Enqueue(Num);
                System.out.println("----------------------------------------------------------------");
                break;
            case 2:
                System.out.println("----------------------------------------------------------------");
                System.out.println("Dequeue the Number from Queue : ");
                int No = obj.Dequeue();
                System.out.println("Dequeued value from the Queue is : "+No);
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
                System.out.println("Number of Nodes in Queue are : "+Count);
                System.out.println("----------------------------------------------------------------");
                break;
            case 5:
                System.out.println("Queue Exited Sucessfully...");
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

class QueueDS
{
    private node first;
    private int Count;

    public QueueDS()
    {
        first = null;
        Count = 0;
    }

    public void Enqueue(int no)
    {
        node newn = new node(no);
        node Temp = first;

        if(first == null)
        {
            first = newn;
            newn.next = null;
        }
        else if(first.next == null)
        {
            first.next = newn;
            newn.next = null;
        }
        else
        {
            while(Temp.next != null)
            {
                Temp = Temp.next;
            }
            Temp.next = newn;
            newn.next = null;
        }
        Count++;
    }

    public int Dequeue()
    {
        int Val = 0;

        if(first == null)
        {
            System.out.println("The Queue is already Empty...");
            return -1;
        }
        else if(first.next == null)
        {
            Val = first.data;
            first = null;
        }
        else
        {
            Val = first.data;
            first = first.next;
        }
        Count--;

        return Val;
    }

    public int CountNode()
    {
        return Count;
    }

    public void Display()
    {
        node Temp = first;

        System.out.println("Contents of Queue are : ");
        System.out.print("Exit from Queue <--");

        while (Temp != null) 
        {
            System.out.print("| "+Temp.data+" |<--");
            Temp = Temp.next;
        }System.out.println(" Entry of the Data");
    }
}


