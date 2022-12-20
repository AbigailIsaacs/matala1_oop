package observer;

public class ConcreteMember implements Member {
    UndoableStringBuilder USB_OfConcreteMember;

    /**
     *
     * @param usb is the updated UndoableStringBuilder that we want sender to point at ("shallow copy")
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        USB_OfConcreteMember = usb;
    }
}
