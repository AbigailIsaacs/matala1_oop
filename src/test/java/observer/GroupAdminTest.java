package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {

    @Test
    void register() {
        ConcreteMember member1 = new ConcreteMember();
        ConcreteMember member2 = new ConcreteMember();
        ConcreteMember member3 = new ConcreteMember();
        ConcreteMember member4 = new ConcreteMember();
        GroupAdmin groupAdmin = new GroupAdmin();
        groupAdmin.insert(0,"start");
        groupAdmin.register(member1);
        groupAdmin.register(member2);
        groupAdmin.register(member3);
        groupAdmin.register(member4);
        assertEquals(groupAdmin.undoableStringBuilder,member1.USB_OfConcreteMember);
        assertEquals(groupAdmin.undoableStringBuilder,member2.USB_OfConcreteMember);
        assertEquals(groupAdmin.undoableStringBuilder,member3.USB_OfConcreteMember);
        assertEquals(groupAdmin.undoableStringBuilder,member4.USB_OfConcreteMember);
        assertEquals(groupAdmin.undoableStringBuilder.toString(),"start");
        assertEquals(member1.USB_OfConcreteMember.toString(),"start");
        assertEquals(member2.USB_OfConcreteMember.toString(),"start");
        assertEquals(member3.USB_OfConcreteMember.toString(),"start");
        assertEquals(member4.USB_OfConcreteMember.toString(),"start");
    }

    @Test
    void unregister() {
        ConcreteMember member1 = new ConcreteMember();
        ConcreteMember member2 = new ConcreteMember();
        ConcreteMember member3 = new ConcreteMember();
        ConcreteMember member4 = new ConcreteMember();
        ConcreteMember member5 = new ConcreteMember();
        GroupAdmin groupAdmin = new GroupAdmin();
        groupAdmin.register(member1);
        groupAdmin.register(member2);
        groupAdmin.register(member3);
        groupAdmin.register(member4);
        groupAdmin.unregister(member1);
        groupAdmin.unregister(member3);
        groupAdmin.unregister(member4);
        groupAdmin.unregister(member5);
        assertEquals(groupAdmin.members.size(),1);
        assertEquals(groupAdmin.members.get(0),member2);

    }

    @Test
    void insert() {
        ConcreteMember member1 = new ConcreteMember();
        ConcreteMember member2 = new ConcreteMember();
        ConcreteMember member3 = new ConcreteMember();
        ConcreteMember member4 = new ConcreteMember();
        GroupAdmin groupAdmin = new GroupAdmin();
        groupAdmin.register(member1);
        groupAdmin.register(member2);
        groupAdmin.register(member3);
        groupAdmin.register(member4);
        groupAdmin.insert(0,"start");
        assertEquals(groupAdmin.undoableStringBuilder,member1.USB_OfConcreteMember);
        assertEquals(groupAdmin.undoableStringBuilder,member2.USB_OfConcreteMember);
        assertEquals(groupAdmin.undoableStringBuilder,member3.USB_OfConcreteMember);
        assertEquals(groupAdmin.undoableStringBuilder,member4.USB_OfConcreteMember);
        assertEquals(groupAdmin.undoableStringBuilder.toString(),"start");
        assertEquals(member1.USB_OfConcreteMember.toString(),"start");
        assertEquals(member2.USB_OfConcreteMember.toString(),"start");
        assertEquals(member3.USB_OfConcreteMember.toString(),"start");
        assertEquals(member4.USB_OfConcreteMember.toString(),"start");

    }

    @Test
    void append() {
        ConcreteMember member1 = new ConcreteMember();
        ConcreteMember member2 = new ConcreteMember();
        ConcreteMember member3 = new ConcreteMember();
        ConcreteMember member4 = new ConcreteMember();
        GroupAdmin groupAdmin = new GroupAdmin();
        groupAdmin.insert(0,"start");
        groupAdmin.register(member1);
        groupAdmin.register(member2);
        groupAdmin.register(member3);
        groupAdmin.register(member4);
        groupAdmin.append("end");
        assertEquals(groupAdmin.undoableStringBuilder,member1.USB_OfConcreteMember);
        assertEquals(groupAdmin.undoableStringBuilder,member2.USB_OfConcreteMember);
        assertEquals(groupAdmin.undoableStringBuilder,member3.USB_OfConcreteMember);
        assertEquals(groupAdmin.undoableStringBuilder,member4.USB_OfConcreteMember);
        assertEquals(groupAdmin.undoableStringBuilder.toString(),"startend");
        assertEquals(member1.USB_OfConcreteMember.toString(),"startend");
        assertEquals(member2.USB_OfConcreteMember.toString(),"startend");
        assertEquals(member3.USB_OfConcreteMember.toString(),"startend");
        assertEquals(member4.USB_OfConcreteMember.toString(),"startend");
    }

    @Test
    void delete() {
        ConcreteMember member1 = new ConcreteMember();
        ConcreteMember member2 = new ConcreteMember();
        ConcreteMember member3 = new ConcreteMember();
        ConcreteMember member4 = new ConcreteMember();
        GroupAdmin groupAdmin = new GroupAdmin();
        groupAdmin.insert(0,"start");
        groupAdmin.register(member1);
        groupAdmin.register(member2);
        groupAdmin.register(member3);
        groupAdmin.register(member4);
        groupAdmin.delete(0,2);
        assertEquals(groupAdmin.undoableStringBuilder,member1.USB_OfConcreteMember);
        assertEquals(groupAdmin.undoableStringBuilder,member2.USB_OfConcreteMember);
        assertEquals(groupAdmin.undoableStringBuilder,member3.USB_OfConcreteMember);
        assertEquals(groupAdmin.undoableStringBuilder,member4.USB_OfConcreteMember);
        assertEquals(groupAdmin.undoableStringBuilder.toString(),"art");
        assertEquals(member1.USB_OfConcreteMember.toString(),"art");
        assertEquals(member2.USB_OfConcreteMember.toString(),"art");
        assertEquals(member3.USB_OfConcreteMember.toString(),"art");
        assertEquals(member4.USB_OfConcreteMember.toString(),"art");
    }

    @Test
    void undo() {
        ConcreteMember member1 = new ConcreteMember();
        ConcreteMember member2 = new ConcreteMember();
        ConcreteMember member3 = new ConcreteMember();
        ConcreteMember member4 = new ConcreteMember();
        GroupAdmin groupAdmin = new GroupAdmin();
        groupAdmin.insert(0,"start");
        groupAdmin.register(member1);
        groupAdmin.register(member2);
        groupAdmin.register(member3);
        groupAdmin.register(member4);
        groupAdmin.delete(0,2);
        groupAdmin.undo();
        assertEquals(groupAdmin.undoableStringBuilder,member1.USB_OfConcreteMember);
        assertEquals(groupAdmin.undoableStringBuilder,member2.USB_OfConcreteMember);
        assertEquals(groupAdmin.undoableStringBuilder,member3.USB_OfConcreteMember);
        assertEquals(groupAdmin.undoableStringBuilder,member4.USB_OfConcreteMember);
        assertEquals(groupAdmin.undoableStringBuilder.toString(),"start");
        assertEquals(member1.USB_OfConcreteMember.toString(),"start");
        assertEquals(member2.USB_OfConcreteMember.toString(),"start");
        assertEquals(member3.USB_OfConcreteMember.toString(),"start");
        assertEquals(member4.USB_OfConcreteMember.toString(),"start");
    }
}