package observer;

public class ConcreteMember implements Member {
    private UndoableStringBuilder USB_OfConcreteMember;

    /**
     * @param usb is the updated UndoableStringBuilder that we want sender to point at ("shallow copy")
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        USB_OfConcreteMember = usb;
    }

    public String getUSB_OfConcreteMember(){
        return USB_OfConcreteMember.toString();
    }
}
