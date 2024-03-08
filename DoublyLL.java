//==================================================================================================
//*******************************Doubly linear linked list******************************************
//==================================================================================================

import java.util.Scanner;

public class DoublyLL 
{
    public static void main(String Args[])
    {
        Scanner sobj = new Scanner(System.in);
        LinkedlistDLL obj = new LinkedlistDLL();
        int Choice = 0;
        while(Choice != 5){
        System.out.println("Enter You Choice !!!");
        System.out.println("1.Insert : ");
        System.out.println("2.Delete : ");
        System.out.println("3.Display : ");
        System.out.println("4.CountNode : ");
        System.out.println("5.Exit : ");
        Choice = sobj.nextInt();

        switch(Choice)
        {
            case 1:
                System.out.println("----------------------------------------------------------------");
                System.out.println("Please Enter Insert Function choice : ");
                System.out.println("1.InsertFirst : ");
                System.out.println("2.InsertLast : ");
                System.out.println("3.InsertAtPos : ");
                int Choi = sobj.nextInt();

                if(Choi == 1)
                {
                    System.out.println("Enter the number you want to insert : ");
                    int Num = sobj.nextInt();
                    obj.InsertFirst(Num);
                }
                else if(Choi == 2)
                {
                    System.out.println("Enter the number you want to insert : ");
                    int Num = sobj.nextInt();
                    obj.InsertLast(Num);

                }
                else if(Choi == 3)
                {
                    System.out.println("Enter the number you want to insert : ");
                    int Num = sobj.nextInt();
                    System.out.println("Enter the position where you want to insert Number : ");
                    int Pos = sobj.nextInt();
                    obj.InsertAtPos(Num,Pos);
                }
                else
                {
                    System.out.println("Please Enter Valid Choice : ");   
                }
                System.out.println("----------------------------------------------------------------");
                break;
            
            case 2:
                System.out.println("----------------------------------------------------------------");
                System.out.println("Please Enter Delete Function choice : ");
                System.out.println("1.DeleteFirst : ");
                System.out.println("2.DeleteLast : ");
                System.out.println("3.DeleteAtPos : ");
                Choi = sobj.nextInt();

                if(Choi == 1)
                {
                    System.out.println("Delete First Function called : ");
                    obj.DeleteFirst();
                }
                else if(Choi == 2)
                {
                    System.out.println("Delete Last Function called : ");
                    obj.DeleteLast();

                }
                else if(Choi == 3)
                {
                    System.out.println("Enter the position that you want to Delete : ");
                    int Pos = sobj.nextInt();
                    obj.DeleteAtPos(Pos);
                }
                else
                {
                    System.out.println("Please Enter Valid Choice : ");   
                }
                System.out.println("----------------------------------------------------------------");
                break;
            
                case 3:
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("Contents of Linked list are : ");
                    obj.Display();
                    System.out.println("----------------------------------------------------------------");
                    break;
                case 4:
                    System.out.println("----------------------------------------------------------------");
                    int iRet = obj.CountNode();
                    System.out.println("Number of Node in Linked list are : "+iRet);
                    System.out.println("----------------------------------------------------------------");
                    break;
                case 5:
                    System.out.println("Linked list Exited Succesfully...");
                    return;
                default:
                    System.out.println("Please Enter Valid Choice : ");
                    
        }
    }

        sobj.close();

    }
}

class node
{
    public int data;
    public node next;
    public node prev;

    public node(int A)
    {
        data = A;
        next = null;
        prev = null;
    }
}

class LinkedlistDLL
{
    private node first;
    private int Count;

    public LinkedlistDLL()
    {
        first = null;
        Count = 0;
    }

    public void InsertFirst(int no)
    {
        node newn = new node(no);

        if(first == null)
        {
            first = newn;
        }
        else
        {
            newn.next = first;
            first.prev = newn;
            first = newn;
        }
        Count++;
    }

    public void InsertLast(int no)
    {
        node newn = new node(no);
        node Temp = first;

        if(first == null)
        {
            first = newn;
        }
        else if(first.next == null)
        {
            first.next = newn;
            newn.prev = first;
            newn.next = null;
        }
        else
        {
            while(Temp.next != null)
            {
                Temp = Temp.next;
            }
            Temp.next = newn;
            newn.prev = Temp;
            newn.next = null;
            
        }
        Count++;
    }

    public void DeleteFirst()
    {
        if(first == null)
        {
            System.out.println("Linked List is already Empty...");
            return;
        }
        else if(first.next == null)
        {
            first = null;
        }
        else
        {
            first = first.next;
            first.prev = null;
        }
        Count--;
    }

    public void DeleteLast()
    {
        node Temp = first;
        if(first == null)
        {
            System.out.println("Linked List is already Empty...");
            return;
        }
        else if(first.next == null)
        {
            first = null;
        }
        else
        {
            while(Temp.next.next != null)
            {
                Temp = Temp.next;
            }
            Temp.next = null;

        }
        Count--;
    }


    public void InsertAtPos(int no,int iPos)
    {
        node newn = new node(no);
        node Temp = first;

        if(iPos < 1 || iPos > Count + 1)
        {
            System.out.println("Invalid Position please enter valid position...");
            return;
        }
        else if(iPos == 1)
        {
            InsertFirst(no);
        }
        else if(iPos == Count)
        {
            InsertLast(no);
        }
        else
        {
            for(int i = 1;i < iPos - 1;i++)
            {
                Temp = Temp.next;
            }
            Temp.next.prev = newn;
            newn.next = Temp.next;
            newn.prev = Temp;
            Temp.next = newn;

            Count++;
        }
    }
    
    public void DeleteAtPos(int iPos)
    {
        node Temp = first;

        if(iPos < 1 || iPos > Count)
        {
            System.out.println("Invalid Position please enter valid position...");
            return;
        }
        else if(iPos == 1)
        {
            DeleteFirst();
        }
        else if(iPos == Count)
        {
            DeleteLast();
        }
        else
        {
            for(int i = 1;i < iPos - 1;i++)
            {
                Temp = Temp.next;
            }
            Temp.next = Temp.next.next;
            Temp.next.prev = Temp;
            
            Count--;
        }
    }
    

    public int CountNode()
    {
        return Count;
    }

    public void Display()
    {
        node Temp = first;

        System.out.print("NULL<==>");
        while(Temp != null)
        {
            System.out.print("| "+Temp.data+" |<==>");
            Temp = Temp.next;
        }System.out.println("NULL");

    }
}
