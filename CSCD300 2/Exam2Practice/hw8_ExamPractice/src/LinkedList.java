import java.util.NoSuchElementException;

public class LinkedList{

    private ListNode head;
    private int size;

    private class ListNode {
        private Object data;
        private ListNode next, prev;
        private ListNode(Object d, ListNode prev, ListNode next) {
            this.data = d;
            this.next = next;
            this.prev = prev;
        }
    }

    public LinkedList() {
        this.head = new ListNode(null, null, null);
        this.head.next = this.head;
        this.head.prev = this.head;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void addFirst(Object e)
    {
        ListNode nn = new ListNode(e, this.head, this.head.next);
        this.head.next.prev = nn;
        this.head.next = nn;
        this.size ++;
    }

    public void add(Object e) {
        ListNode nn = new ListNode(e,null,null);
        nn.next=this.head;
        nn.prev=this.head.prev;
        this.head.prev.next = nn;
        this.head.prev=nn;
        size++;
    }

    public int getSize(){
        ListNode cur = this.head.next;
        int count = 0;
        while(cur != this.head){
            cur = cur.next;
            count++;
        }
        return count;
    }

    public boolean isSorted(){
        int flag = 0;
        ListNode cur = this.head.next.next;
        while(cur != this.head){
            if((Integer)cur.prev.data > (Integer)cur.data)
                flag = 1;
            cur = cur.next;
        }
        if(flag == 0)
            return true;

        return false;
    }

    public LinkedList merge(LinkedList list1, LinkedList list2){
        ListNode cur = list1.head.next;
        ListNode cur2 = list2.head.next;
        LinkedList newList = new LinkedList();
        while(cur != list1.head && cur2 != list2.head){
            if((Integer)cur.data < (Integer)cur2.data){
                newList.add(cur.data);
                cur = cur.next;
            }
            else{
                newList.add(cur2.data);
                cur2 = cur2.next;
            }
        }
        if(cur == list1.head){
            while(cur2 != list2.head){
                newList.add(cur2.data);
                cur2 = cur2.next;
            }
        }
        if(cur2 == list2.head){
            while(cur != list1.head){
                newList.add(cur.data);
                cur = cur.next;
            }
        }
        return newList;
    }

    //do this
    public void MergeSort(){
        Queue q = new Queue;

    }

    public void InsertionSort(){
        ListNode lastSorted, sortedWalker;
        Comparable firstUnsortedData;
        for(lastSorted=this.head.next; lastSorted != this.head.prev; lastSorted = lastSorted.next ) {
            firstUnsortedData = (Comparable)lastSorted.next.data;
            for(sortedWalker=lastSorted; sortedWalker != head &&
                    ((Comparable)sortedWalker.data).compareTo(firstUnsortedData) > 0;
                sortedWalker = sortedWalker.prev) {
                sortedWalker.next.data = sortedWalker.data;
            }
            sortedWalker.next.data = firstUnsortedData;
        }
    }

}

