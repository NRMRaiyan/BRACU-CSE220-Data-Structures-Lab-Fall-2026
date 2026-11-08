public class AssignmentTask6 {

    //SUBMIT ONLY THIS METHOD
    public static void pairJoin(DNode dh1, DNode dh2) {
        // TO DO
        DNode p1 = dh1.next;
        DNode p2 = dh2.next;

        while (p1 != null && p1 != dh1 && p2 != null && p2 != dh2) {

            DNode next1 = p1.next;
            DNode next2 = p2.next;

            p1.next = p2;
            p2.prev = p1;

            p2.next = next1;

            if (next1 != null) {
                next1.prev = p2;
            } else {
                dh1.prev = p2;
            }

            p1 = next1;
            p2 = next2;
        }

        if (dh1.prev != null && dh1.prev.next != dh1) {
            dh1.prev.next = dh1;
        }

        if (dh1.next != null && dh1.next.prev != dh1) {
            dh1.next.prev = dh1;
        }
    }

    //DO NOT SUBMIT THE DRIVER CODE BELOW
    //SUBMITTING IT WILL INCREASE YOUR PLAG % FOR NO REASON
    public static void main(String[] args) {
        Object[] list1 = {"A", "B", "C", "D"};
        Object[] list2 = {"E", "F", "G", "H"};

        DNode dh1 = LinkedListHelpers.createDummyHeadedDoublyLL(list1, false);
        DNode dh2 = LinkedListHelpers.createDummyHeadedDoublyLL(list2, false);

        System.out.println("Given Linked List 1:");
        LinkedListHelpers.printDummyHeadedDoublyLL(dh1);

        System.out.println("Given Linked List 2:");
        LinkedListHelpers.printDummyHeadedDoublyLL(dh2);

        System.out.println("\nExpected Output:");
        Object[] expected = {"A", "E", "B", "F", "C", "G", "D", "H"};
        DNode expectedHead = LinkedListHelpers.createDummyHeadedDoublyLL(expected, true);
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(expectedHead);

        //Running the Pair Join
        pairJoin(dh1, dh2);
        //Printing after Pair Join
        System.out.println("\nYour Output:");
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(dh1);
    }
}
