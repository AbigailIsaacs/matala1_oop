package observer;

/*
Use the class you've implemented in previous assignment
 */
import java.util.*;
public class UndoableStringBuilder{
    Stack<StringBuilder> stc;

    /**
     * Default constructor - opens a new stack inorder to save all the changes that been done on the StringBuilder object
     * Pushes the new StringBuilder to the stack
     */
    public UndoableStringBuilder() {
        stc = new Stack<>();
        StringBuilder start = new StringBuilder();
        stc.push(start);
    }

    /**
     * Constructor - opens a new stack inorder to save all the changes that been done on the StringBuilder object
     * @param s is our initialize string.
     * Converting string s to a StringBuilder
     * Pushes the new StringBuilder s to the stack
     */
    public UndoableStringBuilder(String s) throws NullPointerException{
        if(s == null ) {
            throw new NullPointerException("Expected NullPointerException");
        }
        StringBuilder start = new StringBuilder();
        StringBuilder start_2 = new StringBuilder(s);
        stc = new Stack<>();
        stc.push(start);
        stc.push(start_2);
    }

    /**
     * @param str is String
     * Sends the current StringBuilder and the string str to the append function in StringBuilder
     * Saves the new StringBuilder and push it to the stack
     */

    public UndoableStringBuilder append(String str) {
        StringBuilder to_push =new StringBuilder("");

        if (!stc.empty()){
            StringBuilder p =new StringBuilder(stc.peek());
            to_push.append(p) ;
        }
        stc.push(to_push.append(str));
        return this;
    }

    /**
     * @param start index
     * @param end index
     *  Sends the start and end index to delete function in StringBuilder
     *  Saves the new StringBuilder and push it to the stack
     */

    public UndoableStringBuilder delete(int start, int end){
        StringBuilder to_push = new StringBuilder("");
        try {
            StringBuilder p = new StringBuilder(stc.peek());
            to_push.append(p.delete(start, end));
            stc.push(to_push);
        }
        catch(StringIndexOutOfBoundsException e) {
            System.out.println("String index out of bounds");
            System.err.println(e);
            e.printStackTrace();
        }

        return this;
    }

    /**
     * @param offset index
     * @param str string to insert
     * Sends the offset index to insert function in StringBuilder
     * Saves the new StringBuilder and push it to the stack
     */
    public UndoableStringBuilder insert(int offset, String str){
        StringBuilder to_push = new StringBuilder("");
        try {
            StringBuilder p = new StringBuilder(stc.peek());
            to_push.append(p.insert(offset, str));
            stc.push(to_push);
        }
        catch(StringIndexOutOfBoundsException e){
            System.out.println("String index out of bounds");
            System.err.println(e);
            e.printStackTrace();
        }

        return this;

    }

    /**
     * @param start index
     * @param end index
     * @param str string to replace
     * Sends the start and end index with str string to replace function in StringBuilder
     * Saves the new StringBuilder and push it to the stack
     */
    public UndoableStringBuilder replace(int start,int end, String str){
        StringBuilder to_push = new StringBuilder("");
        try {
            StringBuilder p = new StringBuilder(stc.peek());
            to_push.append(p.replace(start, end, str));
            stc.push(to_push);
        }
        catch(NullPointerException n){
            System.out.println("null is not a string");
            System.err.println(n);
            n.printStackTrace();
        }
        catch(StringIndexOutOfBoundsException e){
            System.out.println("String index out of bounds");
            System.err.println(e);
            e.printStackTrace();
        }

        return this;
    }

    /**
     * Sends the current StringBuilder to reverse function in StringBuilder
     * Saves the new StringBuilder and push it to the stack
     */
    public UndoableStringBuilder reverse(){

        StringBuilder to_push = new StringBuilder("") ;
        StringBuilder p = new StringBuilder(stc.peek()) ;
        to_push.append(p.reverse()) ;
        stc.push(to_push);
        return this;
    }

    /**
     * Overriding the toString() method
     * @return the current StringBuilder as String
     */
    public String toString(){
        StringBuilder ans = new StringBuilder(stc.peek()) ;
        return ans.toString();
    }

    /**
     * Pops the last StringBuilder out of the stack
     */
    public void undo(){
        try {
            if (stc.size()>1)
                stc.pop();
        }
        catch(EmptyStackException e) {
            StringBuilder n = new StringBuilder();
            e.printStackTrace();
        }

    }

}



