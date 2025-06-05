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

    //do this
    public void push(Object p){
        Node newNode = new Node(p);
        newNode.next = this.head;
        this.head = newNode;
        size++;
    }

    //do this
    public Object pop(){
        Node temp = this.head;
        this.head = this.head.next;
        size--;
        return temp.data;
    }

    public Object top(){
        if(this.head==null)
            return null;

        return this.head.data;
    }

    public boolean isEmpty(){
        if(size==0){
            if(this.head!=null)
                this.head = null;
            return true;
        }

        return false;
    }
    public static boolean isInt(char a){
        if(a=='0'||a=='1'||a=='2'||a=='3'||a=='4'||a=='5'||a=='6'||a=='7'||a=='8'||a=='9')
            return true;
        return false;
    }

    //do this
    public String toPostfix(String infix){
        String postfix = "";
        for(int i=0; i<infix.length(); i++){
            Node cur = this.head;
            char c = infix.charAt(i);
            if(isInt(c))
                postfix += c;
            else if(c == '(')
                push(c);
            else if(c == ')'){
                while(! cur.data.equals('(')){
                    postfix += this.pop();
                    cur = cur.next;
                }
                this.pop();
            }
            else{
                while(!this.isEmpty() && ((this.top().toString()).compareTo(String.valueOf(c))<0)&& !this.top().equals('(')
                        && c != '^')
                    postfix += this.pop();
                push(c);
            }
        }
        while(! this.isEmpty()){
            postfix += this.pop();
        }
        return postfix;
    }
    //do this
    public int evaluate(String postfix){
        if(postfix.equals(null))
            throw new NullPointerException("postfix is null");
        int num = 0;
        for(int i=0; i<postfix.length(); i++){
            char c = postfix.charAt(i);
            if(isInt(c))
                this.push(c);
            else{
                int right = Integer.parseInt(String.valueOf(this.pop()));
                int left = Integer.parseInt(String.valueOf(this.pop()));
                if(c =='+')
                    num = left + right;
                else if(c == '-')
                    num = left - right;
                else if(c == '^')
                    num = (int)Math.pow(left,right);
                else if(c == '*')
                    num = left * right;
                else if(c == '/')
                    num = left/right;
                else if(c == '%')
                    num = left%right;
                push(num);
            }
        }
        return (int)this.pop();
    }

}

