# matala1_oop
This project is written in JAVA
In order to run the project open the files in IntelliJ version 19.
There is no main, in order to run the project, run the test "Tests" or you can create a main function by yourself.
In this project we created the classes "GroupAdmin","ConcreteMember" that implements the interfaces "Member","Sender".
In GroupAdmin we used ArreyList from type "Member" to store the observers, in addition GroupAdmin has a data member of type UndoableStringBuilder.
In ConcreteMember there in one function only "update()" which updates the observers in every change on the UndoableStringBuilder (shallw coppy).
In order to prevent a possibility that a ConcreteMember could make a change in the UndoableStringBuilder of GroupAdmin we defined the UndoableStringBuilder (of ConcreteMember) to be private, so that changes could only be made by GroupAdmin.
Therefore in order observe the UndoableStringBuilder content we created a getUndoableStringBuilder() function that returns the current string.
In "Tests" we cheacked that the when a change happens all the members are updated, in addition we printed the  functions "objectFootprint()","objectTotalSize()", "jvmInfo()" from "JvmUtilities" class in order to follow all the references that the object contains, his size in the heap and the total memory and available cores. 
