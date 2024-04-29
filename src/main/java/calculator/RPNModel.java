/**
 * CSIS 312 Assignment 2.
 * @author Wade Schofield and Abby Schofield
 * Model of an RPN Calculator
 * - I have not discussed the source code in my program with anyone other than my instructor’s approved human sources (i.e. programming partner).
 * - I have not used source code obtained from another student, or any other unauthorized source, either modified or unmodified.
 * - If any source code or documentation used in my program was obtained from another source, such as a text book or course notes, that has been clearly noted *   with a proper citation in the comments of my program.
 * - I have not knowingly designed this program in such a way as to defeat or interfere with the normal operation of any machine it is graded on or to produce     apparently correct results when in fact it does not.
 * Complete the methods noted below
 **/

package calculator;



public class RPNModel {

    // Instance variables
    MyStack<Integer> stack = new MyStack<>();

    /**
     * Complete enter handler
     * @param val
     * @return
     */
    public boolean enter(int val)
    {
        return true;
    }

    /**
     * Drops the top item on the stack if there is one
     * @return true if successful
     */
    public boolean drop()
    {
        if (stack.size() == 0)
            return false;
        else
            stack.pop();
            return true;
    }

    /**
     * Complete the multiply handler
     * @return
     */
    public boolean multiply()
    {
        return true;
    }

    /**
     * Divide Handler
     * @return true if successful, false otherwise
     * @throws Exception - in the event of a divide by zero
     * Removes items from stack and places the calculation result on the stack
     */
    public boolean divide() throws Exception
    {
        if (stack.size() < 2)
            return false;
        stack.push( stack.pop() / stack.pop());
        return true;
    }

    /**
     * Add Handler
     * @return true if successful, false otherwise
     * Removes items from stack and places the calculation result on the stack
     */
    public boolean add()
    {
        if (stack.size() < 2)
            return false;
        stack.push( stack.pop() + stack.pop());
        return true;
    }

    /**
     * Complete the subtract handler
     * @return true if successful
     */
    public boolean subtract()
    {
        return true;
    }

    /**
     * Returns a formatted string of the stack contents
     * @return string of items on stack separated by carriage returns
     * Note: No modification needed!
     */
    public String getValues() throws Exception
    {
        StringBuilder sb = new StringBuilder();
        // pre-load display with returns
        String[] display = new String[MyStack.MAX_SIZE];
        for (int i = 0; i < MyStack.MAX_SIZE; i++)
            display[i] = "\n";

        int j = MyStack.MAX_SIZE - 1;
        for (int i = stack.size() - 1; i >= 0; i--) {
            display[j] = stack.get(i).toString() + "\n";
            j--;
        }
        for (String l : display)
            sb.append(l);
        return sb.toString();
    }
}
