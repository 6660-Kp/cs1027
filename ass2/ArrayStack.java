
public class ArrayStack <T> implements ArrayStackADT<T>
{
	  /**
	   * constant to represent the default capacity of the array
	   */
	  private final int Default_Capacity = 20;

	  /**
	   * int that represents both the number of elements and the next
	   * available position in the array
	   */
	  private int top=-1;  

	  /**
	   * array of generic elements to represent the stack
	   */
	  private T[] stack;
	  
	  /**
	   * Creates an empty stack using the default capacity.
	   */
	  public ArrayStack()
	  {
	    top = 0;
	    stack = (T[])(new Object[Default_Capacity]);
	  }
	  public ArrayStack(int initialCapacity) {
		    top = 0;
		    stack = (T[])(new Object[initialCapacity]);
		  
	  }


	  /**
	   * Adds the specified element to the top of this stack, expanding
	   * the capacity of the stack array if necessary.
	   */
	  public void push (T element)
	  {
	    if ((size() == stack.length) && (size()<100)) {
	      expandCapacityT();}
	    else if((size() == stack.length) && (size()>=100)) {
	    	expandCapacityW();}
	    stack[top] = element;
	    top++;
	  }

	  /**
	   * Removes the element at the top of this stack and returns a
	   * reference to it. Throws an EmptyCollectionException if the stack
	   * is empty.
	   */
	  public T pop() throws EmptyStackException
	  {
	    if (isEmpty())
	      throw new EmptyStackException("Stack");
	    top--;
	    T result = stack[top];
	    stack[top] = null; 
	    if ((top<stack.length/3)&&(stack.length>20)) {
	    	expandCapacityH(top);
	    } 
	    return result;}
	   
	  /**
	   * Returns a reference to the element at the top of this stack.
	   * The element is not removed from the stack.  Throws an
	   * EmptyCollectionException if the stack is empty.  
	   */
	  public T peek() throws EmptyStackException
	  {
	    if (isEmpty())
	      throw new EmptyStackException("Stack");

	    return stack[top-1];
	  }

	  /**
	   * Returns true if this stack is empty and false otherwise. 
	   * @return boolean true if this stack is empty, false otherwise
	   */
	  public boolean isEmpty()
	  {
	    return (top <= 0);
	  }
	 
	  /**
	   * Returns the number of elements in this stack.
	   * @return int the number of elements in this stack
	   */
	  public int size()
	  {
	    return top;
	  }
	  public int length() {
		  return stack.length;
	  }
	  /**
	   * Returns a string representation of this stack. 
	   * @return String representation of this stack
	   */
	  public String toString()
	  {
	    StringBuffer result =new StringBuffer();
	    result.append("Stack: ");
	    for (int scan=0; scan <= top-1; scan++)
	    	if(scan+1<=top-1) {
	    		result.append(stack[scan].toString()+", ");
	    	}else
	    		result.append(stack[scan].toString());
	    return result.toString();
	  }

	  /**
	   * Creates a new array to store the contents of this stack with
	   * twice the capacity of the old one.
	   */
	  private void expandCapacityT()
	  {

			T[] sm = (T[])(new Object[stack.length*2]);
		    for (int index=0; index < stack.length; index++) 
			      sm[index] = stack[index];	
		    
			    stack = sm;
				    

	  }
	  private void expandCapacityH(int top)
	  {	  
	    	T[] Ms = (T[])(new Object[stack.length/2]);
	    for (int index=0; index < top; index++) 
		      Ms[index] = stack[index];
		    stack = Ms;
	    }
	  
	  
	  private void expandCapacityW()
	  {
	    	T[] larger = (T[])(new Object[stack.length+50]);
		    for (int index=0; index < stack.length; index++) 
			      larger[index] = stack[index];
			    
			    stack = larger; 
			    }
				  	  
}

