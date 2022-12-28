import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test(){
        String s1 = "Alice";
        String s2 = "Bob";

        logger.info(()->JvmUtilities.objectFootprint(s1));

        logger.info(()->JvmUtilities.objectFootprint(s1,s2));

        logger.info(()->JvmUtilities.objectTotalSize(s1));

        logger.info(() -> JvmUtilities.jvmInfo());
    }
    @Test
    void update() {
        ConcreteMember member1 = new ConcreteMember();
        ConcreteMember member2 = new ConcreteMember();
        ConcreteMember member3 = new ConcreteMember();
        ConcreteMember member4 = new ConcreteMember();
        GroupAdmin groupAdmin = new GroupAdmin();
        logger.info(()->JvmUtilities.objectFootprint(groupAdmin));
        logger.info(()->JvmUtilities.objectFootprint(groupAdmin.getUndoableStringBuilder()));
        groupAdmin.register(member1);
        groupAdmin.register(member2);
        groupAdmin.register(member3);
        groupAdmin.register(member4);
        groupAdmin.insert(0, "start");
        logger.info(()->JvmUtilities.objectFootprint(groupAdmin));
        logger.info(()->JvmUtilities.objectFootprint(groupAdmin.getUndoableStringBuilder()));
        for(int i = 0; i < groupAdmin.getMembers().size(); ++i) {
            Assertions.assertEquals(((ConcreteMember)groupAdmin.getMembers().get(i)).getUSB_OfConcreteMember().toString(), "start");
            Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), ((ConcreteMember) groupAdmin.getMembers().get(i)).getUSB_OfConcreteMember());
        }
        logger.info(() -> JvmUtilities.jvmInfo());

    }
    @Test
    void register() {
        ConcreteMember member1 = new ConcreteMember();
        ConcreteMember member2 = new ConcreteMember();
        ConcreteMember member3 = new ConcreteMember();
        ConcreteMember member4 = new ConcreteMember();
        GroupAdmin groupAdmin = new GroupAdmin();
        logger.info(()->("groupAdmin: "+JvmUtilities.objectTotalSize(groupAdmin)));
        logger.info(()->("UndoableStringBuilder: "+JvmUtilities.objectTotalSize(groupAdmin.getUndoableStringBuilder())));
        groupAdmin.insert(0, "start");
        logger.info(()->("groupAdmin after insert: "+JvmUtilities.objectTotalSize(groupAdmin)));
        logger.info(()->("UndoableStringBuilder after insert: "+JvmUtilities.objectTotalSize(groupAdmin.getUndoableStringBuilder())));
        groupAdmin.register(member1);
        groupAdmin.register(member2);
        groupAdmin.register(member3);
        groupAdmin.register(member4);
        logger.info(()->("groupAdmin after register: "+JvmUtilities.objectTotalSize(groupAdmin)));
        logger.info(()->("UndoableStringBuilder after register: "+ JvmUtilities.objectTotalSize(groupAdmin.getUndoableStringBuilder())));
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), member1.getUSB_OfConcreteMember());
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), member2.getUSB_OfConcreteMember());
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), member3.getUSB_OfConcreteMember());
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), member4.getUSB_OfConcreteMember());
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), "start");
        Assertions.assertEquals(member1.getUSB_OfConcreteMember(), "start");
        Assertions.assertEquals(member2.getUSB_OfConcreteMember(), "start");
        Assertions.assertEquals(member3.getUSB_OfConcreteMember(), "start");
        Assertions.assertEquals(member4.getUSB_OfConcreteMember(), "start");

        logger.info(() -> JvmUtilities.jvmInfo());
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
        Assertions.assertEquals(groupAdmin.getMembers().size(), 1);
        Assertions.assertEquals(groupAdmin.getMembers().get(0), member2);
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
        groupAdmin.insert(0, "start");
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), member1.getUSB_OfConcreteMember());
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), member2.getUSB_OfConcreteMember());
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), member3.getUSB_OfConcreteMember());
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), member4.getUSB_OfConcreteMember());
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), "start");
        Assertions.assertEquals(member1.getUSB_OfConcreteMember(), "start");
        Assertions.assertEquals(member2.getUSB_OfConcreteMember(), "start");
        Assertions.assertEquals(member3.getUSB_OfConcreteMember(), "start");
        Assertions.assertEquals(member4.getUSB_OfConcreteMember(), "start");
    }

    @Test
    void append() {
        ConcreteMember member1 = new ConcreteMember();
        ConcreteMember member2 = new ConcreteMember();
        ConcreteMember member3 = new ConcreteMember();
        ConcreteMember member4 = new ConcreteMember();
        GroupAdmin groupAdmin = new GroupAdmin();
        groupAdmin.insert(0, "start");
        groupAdmin.register(member1);
        groupAdmin.register(member2);
        groupAdmin.register(member3);
        groupAdmin.register(member4);
        groupAdmin.append("end");
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), member1.getUSB_OfConcreteMember());
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), member2.getUSB_OfConcreteMember());
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), member3.getUSB_OfConcreteMember());
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), member4.getUSB_OfConcreteMember());
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), "startend");
        Assertions.assertEquals(member1.getUSB_OfConcreteMember(), "startend");
        Assertions.assertEquals(member2.getUSB_OfConcreteMember(), "startend");
        Assertions.assertEquals(member3.getUSB_OfConcreteMember(), "startend");
        Assertions.assertEquals(member4.getUSB_OfConcreteMember(), "startend");
    }

    @Test
    void delete() {
        ConcreteMember member1 = new ConcreteMember();
        ConcreteMember member2 = new ConcreteMember();
        ConcreteMember member3 = new ConcreteMember();
        ConcreteMember member4 = new ConcreteMember();
        GroupAdmin groupAdmin = new GroupAdmin();
        groupAdmin.insert(0, "start");
        groupAdmin.register(member1);
        groupAdmin.register(member2);
        groupAdmin.register(member3);
        groupAdmin.register(member4);
        groupAdmin.delete(0, 2);
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), member1.getUSB_OfConcreteMember());
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), member2.getUSB_OfConcreteMember());
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), member3.getUSB_OfConcreteMember());
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), member4.getUSB_OfConcreteMember());
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), "art");
        Assertions.assertEquals(member1.getUSB_OfConcreteMember(), "art");
        Assertions.assertEquals(member2.getUSB_OfConcreteMember(), "art");
        Assertions.assertEquals(member3.getUSB_OfConcreteMember(), "art");
        Assertions.assertEquals(member4.getUSB_OfConcreteMember(), "art");
    }

    @Test
    void undo() {
        ConcreteMember member1 = new ConcreteMember();
        ConcreteMember member2 = new ConcreteMember();
        ConcreteMember member3 = new ConcreteMember();
        ConcreteMember member4 = new ConcreteMember();
        GroupAdmin groupAdmin = new GroupAdmin();
        groupAdmin.insert(0, "start");
        groupAdmin.register(member1);
        groupAdmin.register(member2);
        groupAdmin.register(member3);
        groupAdmin.register(member4);
        groupAdmin.delete(0, 2);
        groupAdmin.undo();
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), member1.getUSB_OfConcreteMember());
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), member2.getUSB_OfConcreteMember());
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), member3.getUSB_OfConcreteMember());
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), member4.getUSB_OfConcreteMember());
        Assertions.assertEquals(groupAdmin.getUndoableStringBuilder().toString(), "start");
        Assertions.assertEquals(member1.getUSB_OfConcreteMember(), "start");
        Assertions.assertEquals(member2.getUSB_OfConcreteMember(), "start");
        Assertions.assertEquals(member3.getUSB_OfConcreteMember(), "start");
        Assertions.assertEquals(member4.getUSB_OfConcreteMember(), "start");
    }
}

