/**

 * Implementation of a Stack Abstract Type using Linked List example
 * - I have not discussed the source code in my program with anyone other than my instructor’s approved human sources (i.e. programming partner).
 * - I have not used source code obtained from another student, or any other unauthorized source, either modified or unmodified.
 * - If any source code or documentation used in my program was obtained from another source, such as a text book or course notes, that has been clearly noted *   with a proper citation in the comments of my program.
 * - I have not knowingly designed this program in such a way as to defeat or interfere with the normal operation of any machine it is graded on or to produce     apparently correct results when in fact it does not.
 * NOTE: !!! you don't have to change anything in this file !!!
 **/


package calculator;

/**
 *
 * @author wade
 */
public class MyStack<T>
{
    public static final int MAX_SIZE = 8;
    private LinkedList<T> ll = new LinkedList<>(); // composition
    
    public boolean push(T o)
    {
        if (size() >= MAX_SIZE)
            return false;
        ll.add(o);
        return true;
    }

    public boolean isEmpty()
    {
        return ll.isEmpty();
    }

    public T pop()
    {
        if (ll.isEmpty())
            return null;
        T o = ll.get(ll.size() - 1);
        ll.remove(ll.size() - 1);
        return o;
    }
    
    public int size()
    {
        return ll.size();
    }

    public T get(int i) throws Exception
    {
        if (i >= 0 && i < size())
            return ll.get(i);
        else
            throw new Exception("invalid index");
    }
    
    public static void main(String[] args)
    {
        MyStack<String> stack = new MyStack<>();
        String[] stuff = {"java","python","C++"};
        for (String st : stuff) {
            System.out.println("Pushing: " + st);
            stack.push(st);
        }

        while (!stack.isEmpty())
            System.out.println(stack.pop());

    }
    
}
