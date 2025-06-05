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

    public void enqueue(Object elem) {
        QueueNode newNode = new QueueNode(elem);
        if (this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
            this.size++;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
            this.size++;
        }
    }

    public Object dequeue(){
        if(size==0)
            return null;
        else{
            QueueNode temp = new QueueNode(head.data);
            this.head=head.next;
            this.size--;
            if(size==0)
                this.tail=null;
            return temp.data;
        }
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
