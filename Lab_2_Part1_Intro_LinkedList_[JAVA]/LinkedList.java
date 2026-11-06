class LinkedList{
    Node head;
    public void append(Integer val){
        // TODO: Insert node at the end
        Node newNode = new Node(val);

        if(head == null){
            head = newNode;
        }

        Node current = head;

        while (current.next != null) {
            current.next = current;
        }

        current = newNode;
    }
    public void printList(){
        // TODO: Print all elements from head

    }
    public void prepend(Integer val){
        // TODO: Insert node at the beginning
        Node newNode = head;
        head = newNode;
    }
    public Node nodeAt(int indx){
        // TODO: Return node at given index (0-based)
        int count = 0;
        Node current = head;
        
        while (current != null) {
            if(count == indx){
                break;
            }
            count++;
            current = current.next;
        }
        return current;
    }
    public void removeFirst(){
        // TODO: Remove the first node
        
    }
    public void removeLast(){
        // TODO: Remove the last node

    }
}