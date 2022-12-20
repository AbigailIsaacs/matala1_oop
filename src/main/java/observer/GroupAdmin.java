package observer;

import java.util.ArrayList;

public class GroupAdmin implements Sender{
    UndoableStringBuilder undoableStringBuilder;
    ArrayList<Member> members;

    /**
     * constructor - we used ArrayList to store all the members that register to this GroupAdmin
     */
    public GroupAdmin(){
        members = new ArrayList<>();
        undoableStringBuilder= new UndoableStringBuilder();
    }

    /**
     *
     * @param obj is the new member to add to the ArrayList
     */
    @Override
    public void register(Member obj) {
        this.members.add(obj);
        obj.update(undoableStringBuilder);

    }

    /**
     *
     * @param obj is the former member to remove from the ArrayList
     */
    @Override
    public void unregister(Member obj) {
        this.members.remove(obj);
    }

    /**
     * Sends the undoableStringBuilder to insert() in UndoableStringBuilder class
     * updates all the members with the change
     * @param offset
     * @param obj
     */
    @Override
    public void insert(int offset, String obj) {
        undoableStringBuilder.insert(offset,obj);
        for (int i = 0; i < members.size(); i++) {
            members.get(i).update(undoableStringBuilder);
        }

    }

    /**
     * Sends the undoableStringBuilder to append() in UndoableStringBuilder class
     * updates all the members with the change
     * @param obj
     */
    @Override
    public void append(String obj) {
        undoableStringBuilder.append(obj);
        for (int i = 0; i < members.size(); i++) {
            members.get(i).update(undoableStringBuilder);
        }
    }

    /**
     * Sends the undoableStringBuilder to delete() in UndoableStringBuilder class
     * updates all the members with the change
     * @param start
     * @param end
     */
    @Override
    public void delete(int start, int end) {
        undoableStringBuilder.delete(start,end);
        for (int i = 0; i < members.size(); i++) {
            members.get(i).update(undoableStringBuilder);
        }
    }

    /**
     * Sends the undoableStringBuilder to undo() in UndoableStringBuilder class
     * updates all the members with the change
     */
    @Override
    public void undo() {
        undoableStringBuilder.undo();
        for (int i = 0; i < members.size(); i++) {
            members.get(i).update(undoableStringBuilder);
        }
    }
}
