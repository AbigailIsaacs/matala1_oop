package observer;

public class ConcreteMember implements Member {
    UndoableStringBuilder sender;
    @Override
    public void update(UndoableStringBuilder usb) {
        sender = usb;
    }
}
