public class LinkedStack {

    private class Node implements Comparable<Object>{

        private Object data;
        private Node next;

        public Node(Object elem, Node n) {
            this.data = elem;
            this.next = n;
        }

        public Node(Object elem){
            this.data = elem;
            this.next= null;
        }

        @Override
        public int compareTo(Object o) {
            return CharSequence.compare(this.data.toString(),o.toString());
        }
    }

    protected Node head;
    protected int size;

    public LinkedStack() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void push(Object p){
        Node newNode = new Node(p, this.head);
        this.head = newNode;
        this.size++;
    }

    public Object pop(){
        Node temp = new Node(this.head.data);
        if(size==0)
            return null;
        if(this.size==1) {
            this.head = null;
        }
        else{
            this.head = this.head.next;
        }
        this.size--;
        return temp.data;
    }

}
