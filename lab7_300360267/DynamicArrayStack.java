import java.util.EmptyStackException;

public class DynamicArrayStack<E> implements Stack<E> {

    // Instance variables

    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private static final int DEFAULT_INC = 25;   //Used to store default increment / decrement

    @SuppressWarnings( "unchecked" )

    // Constructor
    public DynamicArrayStack(int capacity) {
        elems = (E[]) new Object[capacity];
        top = 0;
    }


    // Gets current capacity of the array
    public int getCapacity() {
        return elems.length;
    }

    // Returns true if this DynamicArrayStack is empty
    public boolean isEmpty() {
        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it
    public E peek() {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return elems[ top-1 ];
    }

    @SuppressWarnings( "unchecked" )

    // Removes and returns the top element of this stack
    public E pop() {

        // pre-conditions: ! isEmpty()

        // *first* decrements top, then access the value!
        //pop can be same:minimum size of the array is never less that DEFAULT_INC (25).
        if (isEmpty()){
            throw new EmptyStackException();
        }
        E saved = elems[ --top ];

        elems[ top ] = null; // scrub the memory!

        return saved;
    }

    @SuppressWarnings( "unchecked" )

    // Puts the element onto the top of this stack.
    public void push( E element ) {

        // Pre-condition: the stack is not full
        // *first* stores the element at position top, then increments top
        if (top==elems.length-1){
            throw new FullStackException("Stack is full");
        }
        //elems[ top++ ] = element;
        if (elems.length==top){
            E[] newArray = (E[]) new Object[elems.length + DEFAULT_INC];
            for (int i = 0; i < top; i++) {
                newArray[i] = elems[i];
            }
            elems = newArray;

        }
        elems[top++]=element;
    }


    @SuppressWarnings( "unchecked" )

    public void clear(){
        for (int i=0; i<top; i++){
            elems[i]=null;
        }
        top=0;
    }
}



