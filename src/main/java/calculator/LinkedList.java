/**
* !! Note you don't have to change this code at all !!
**/
package calculator;

//
public class LinkedList<T>
{    
    // Points to the first item in the list
    Item start = null; // what is private?

    // Holds a single list element
    public class Item<T>    // what is protected?
    {
        Item next = null;
        Item prev = null;
        T data;

        public Item(T data)
        {
            this.data = data;
        }       
        
        @Override
        public String toString()
        {
            return data.toString();
        }
    }

    /**
     * Size method
     * @return size of the linked list
     */
    public int size()
    {
        int count = 0;
        if (isEmpty())
            return count;
        else
        {         
            Item item = start;
            do
            {
                count++;
                item = item.next;
            }
            while (item != null); 
        }
        return count;
    }

    /**
     *
     * @return
     */
    private Item findEnd()
    {
        if (!isEmpty())
        {
            Item item = start;
            while (item.next != null) {
                item = item.next;
            }
            return item;
        }
        else
        {
            return null;
        }
    }

    /**
     *
     */
    public void add(T o)
    {
        Item item = new Item(o);
        
        // handle empty list
        if (isEmpty())
        {
            start = item;
            start.prev = null;  // nothing before
        }
        else
        {           
            Item end = findEnd();
            item.prev = end;
            end.next = item;  
        }
    }

    public boolean isEmpty()
   {
        return (start == null); // empty list
   }

    public T get(int i)
    {
        int ndx = 0;
        if (!isEmpty())
        {       
            Item item = start;
            do 
            {
                if (ndx == i)
                {
                    return (T)item.data;
                }
                item = item.next;
                ndx+=1;
            }
            while (item != null);
        }
        return null;   // not found;
    }

    public boolean remove(int i)
    {
        int ndx = 0;
        if (!isEmpty())
        {       
            Item item = start;
            do 
            {
                if (ndx == i)
                {
                    if (item.prev != null)                    
                        (item.prev).next = item.next;                    
                    else
                        start = item.next;
                    return true;
                }
                item = item.next;
                ndx+=1;
            }
            while (item != null);
        }
        return false;   // not found;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        if (!isEmpty())
        {
            Item item = start;
            do
            {
                sb.append(item);
                item = item.next;
            } while (item != null);   
            return sb.toString();
        }
        else
        {
            return "<Empty>";
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        LinkedList<String> ll = new LinkedList<>();
        String[] data = {"See","Jane","Run","Fast","Home","Bear","Chasing"};
        for (String s : data)
        {
            System.out.println(s);
            ll.add(s);
        }
        
                System.out.println(ll);

        ll.remove(3);
        System.out.println(ll);
    }


}
