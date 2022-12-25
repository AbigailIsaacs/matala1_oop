# matala1_oop
This project is written in JAVA
In order to run the project open the files in IntelliJ version 19.
There is no main, in order to run the project, run the tests "GroupAdminTest","ConcreteMemberTest" or you can create a main function by yourself.
In this project we created the classes "GroupAdmin","ConcreteMember" that implements the interfaces "Member","Sender".
In GroupAdmin we used ArreyList from type "Member" to store the observers, in addition GroupAdmin has a data member of type UndoableStringBuilder.
In ConcreteMember there in one function only "update()" which updates the observers in every change on the UndoableStringBuilder (shallw coppy).
