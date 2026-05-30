class linked{
    Node head;
class Node{
    int data;
    Node next;
    
    Node(int data){
        this.data = data;
        this.next = next;
    }
}
//add - first, last
public void addFirst(int data){
    Node newNode = new Node(data);
    if(head==null){
        head = newNode;
        return;
    }
    newNode.next = head;
    head = newNode;
}

public void addLast(int data){
    Node newNode = new Node(data);
    if(head==null){
        head = newNode;
        return;
    }
    Node currNode = head;
    while(currNode.next != null){
        currNode = currNode.next;
    }
    currNode.next = newNode;
}

//print
public void printList(){
    Node currNode = head;
    while(currNode != null){
        System.out.print(currNode.data + " ->");
        currNode = currNode.next;
    }
    System.out.println("NULL");
}

//delete first node
public void deleteFirst(){
    if(head == null){
        System.out.println("Linked list is empty");
        return;
    }
    head = head.next;
}

//delete last node
public void deleteLast(){
    if(head == null){
        System.out.println("Linked list is empty");
        return;
    }
    if(head.next == null){
        head = null;
        return;
    }
    Node secondLast = head;
    Node lastNode = head.next;
    while(lastNode.next != null){
        lastNode = lastNode.next;
        secondLast = secondLast.next;
    }
    secondLast.next = null;
}

public void reverseIterate() {
    if(head == null || head.next == null) {
        return;
    }
    Node prevNode = head;
    Node currNode = head.next;

    while(currNode != null) {
        Node nextNode = currNode.next;
        currNode.next = prevNode;

        //update
        prevNode = currNode;
        currNode = nextNode;
    }
    head.next = null;
    head = prevNode;

}

public Node reverseRecursive(Node head) {
    if(head == null || head.next == null){
        return head;
    }

    Node newHead = reverseRecursive(head.next);
    head.next.next = head;
    head.next = null;

    return newHead;
}

public static void main(String[] args){
    linked link = new linked();
    link.addLast(1);
    link.addLast(2);
    link.addLast(3);
    link.addLast(4);
    link.printList();

    link.reverseIterate();
    link.printList();
}
}