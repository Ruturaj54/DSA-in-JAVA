
class DS1
{
    public static void main(String args[])
    {
        int iRet = 0;
        SinglyLL obj = new SinglyLL();
        obj.InsertFirst(51);
        obj.InsertFirst(21);
        obj.InsertFirst(11);

        obj.Display();

        iRet = obj.CountNode();
        System.out.println("Total Nodes in the Linked List are : "+iRet);
        
        obj.InsertLast(101);
        obj.InsertLast(121);
        obj.InsertLast(151);

        obj.Display();

        iRet = obj.CountNode();
        System.out.println("Total Nodes in the Linked List are : "+iRet);

        obj.InsertAtPos(1111,5);

        obj.Display();

        iRet = obj.CountNode();
        System.out.println("Total Nodes in the Linked List are : "+iRet);

        obj.DeleteAtPos(5);

        obj.Display();

        iRet = obj.CountNode();
        System.out.println("Total Nodes in the Linked List are : "+iRet);

    }
}

class node   //struct node
{
    public int data;
    public node next; //struct node *next;

    public node(int no) //initialization done here
    {
        data = no;
        next = null;
    }
}

class SinglyLL
{
    private node first;
    private int Count;

    public SinglyLL()
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

    public void DeleteFirst()
    {
        if(first == null)
        {
            System.out.println("The Linked List is Empty..");
            return;
        }
        else if(first.next == null)
        {
            first = null;
            Count--;
        }
        else
        {
            first = first.next;
            Count--;
        }
    }

    public void DeleteLast()
    {
        node Temp = first;
        if(first == null)
        {
            System.out.println("The Linked List is Empty..");
            return;
        }
        else if(first.next == null)
        {
            first = null;
            Count--;
        }
        else
        {
            while(Temp.next.next != null)
            {
                Temp = Temp.next;
            }
            Temp.next = null;
            Count--;
        }
    }

    public void InsertAtPos(int no,int iPos)
    {
        node newn = new node(no);
        node Temp = first;

        if(iPos < 1 || iPos > Count + 1)
        {
            System.out.println("Invalid Position");
            return;
        }
        else if(iPos == 1)
        {
            InsertFirst(no);
        }
        else if(iPos == Count+1)
        {
            InsertLast(no);
        }
        else
        {
            for(int i = 1;i < iPos-1;i++)
            {
                Temp = Temp.next;
            }
            newn.next = Temp.next;
            Temp.next = newn;
            Count++;
        }
        
    }

    public void DeleteAtPos(int iPos)
    {
       
        node Temp = first;

        if(iPos < 1 || iPos > Count)
        {
            System.out.println("Invalid Position...");
            return;
        }

       if(first == null)
       {
            System.out.println("Linked List is Already Empty...");
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
            for(int i = 1;i < iPos-1;i++)
            {
                Temp = Temp.next;
            }
            Temp.next = Temp.next.next;
            Count--;
       }
    }

    public void Display()
    {
        node Temp = first;

        if(first == null)
        {
            System.out.println("The Linked List is Empty..");
            return;
        }
        else
        {
            System.out.println("The Contents of Linked List are : ");
            while(Temp != null)
            {
                System.out.print("| "+Temp.data+" |-->");
                Temp = Temp.next;
            }System.out.println("NULL");
        }
    }
    
    public int CountNode()
    {
        return Count;
    }
}