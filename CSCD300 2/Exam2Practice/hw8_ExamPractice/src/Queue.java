public class Queue {

    private QueueNode head;
    private QueueNode tail;
    private int size;
    private class QueueNode{
        private Object data;
        private QueueNode next;

        private QueueNode(Object d){
            this.data = d;
            this.next = null;
        }
    }

    public void Queue(){
        this.head = new QueueNode(null);
        this.tail = this.head;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    //do this
    public void enqueue(Object elem) {
        QueueNode newNode = new QueueNode(elem);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    //do this
    public Object dequeue(){
       QueueNode temp = this.head;
       this.head = this.head.next;
       size--;
       return temp.data;
    }

    public Object front(){
        return this.head;
    }

    public boolean isEmpty(){
        if(this.size == 0)
            return true;

        return false;
    }

}
