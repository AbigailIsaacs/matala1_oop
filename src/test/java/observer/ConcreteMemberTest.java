package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMemberTest {

    @Test
    void update() {
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
        for (int i = 0; i < groupAdmin.members.size(); i++) {
            assertEquals(groupAdmin.undoableStringBuilder, ((ConcreteMember) groupAdmin.members.get(i)).sender);
            assertEquals(((ConcreteMember) groupAdmin.members.get(i)).sender.toString(),"start");
        }
    }
}