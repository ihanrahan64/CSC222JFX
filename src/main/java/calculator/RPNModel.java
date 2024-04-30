/**
 * Complete the methods noted below
 **/

package calculator;

public class RPNModel {

    // Instance variables
    MyStack<Integer> stack = new MyStack<>();

    /**
     * TODO: Complete enter handler
     * @param val
     * @return
     */
    public boolean enter(int val)
    {
        return false;
    }

    public int getTop() throws Exception
    {
        if (stack.size() > 0) {
            return stack.get(stack.size() - 1);
        }
        throw new Exception("Nothing on the stack to get!");
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
     * TODO: Complete the multiply handler
     * @return
     */
    public boolean multiply()
    {
        return false;
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
        int v1 = stack.pop();
        stack.push( stack.pop() / v1);
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
     * TODO: Change the sign of the value on the top of the stack
     * @return
     */
    public boolean changeSign() {
        return false;
    }

    /**
     * TODO: Complete the subtract handler
     * @return true if successful
     */
    public boolean subtract()
    {
        return false;
    }

    /**
     * Returns a formatted string of the stack contents
     * @return string of items on stack separated by carriage returns
     * Note: No modification needed!
     */
    public int[] getValues() throws Exception
    {
        int[] values = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            values[i] = stack.get(i);
        }
        return values;
    }
}
