package observer;

import java.util.ArrayList;

public class GroupAdmin implements Sender{
    UndoableStringBuilder undoableStringBuilder;
    ArrayList<Member> members;
    public GroupAdmin(){
        members = new ArrayList<>();
        undoableStringBuilder= new UndoableStringBuilder();
    }

    @Override
    public void register(Member obj) {
        this.members.add(obj);
        obj.update(undoableStringBuilder);

    }

    @Override
    public void unregister(Member obj) {
        this.members.remove(obj);
    }

    @Override
    public void insert(int offset, String obj) {
        undoableStringBuilder.insert(offset,obj);
        for (int i = 0; i < members.size(); i++) {
            members.get(i).update(undoableStringBuilder);
        }

    }

    @Override
    public void append(String obj) {
        undoableStringBuilder.append(obj);
        for (int i = 0; i < members.size(); i++) {
            members.get(i).update(undoableStringBuilder);
        }
    }

    @Override
    public void delete(int start, int end) {
        undoableStringBuilder.delete(start,end);
        for (int i = 0; i < members.size(); i++) {
            members.get(i).update(undoableStringBuilder);
        }
    }

    @Override
    public void undo() {
        undoableStringBuilder.undo();
        for (int i = 0; i < members.size(); i++) {
            members.get(i).update(undoableStringBuilder);
        }
    }
}
