/**
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
