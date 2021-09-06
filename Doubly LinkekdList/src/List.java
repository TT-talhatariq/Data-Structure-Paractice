public class List {
    static class DoublyList {
        class Node {
            int data;
            Node next;
            Node pre;

            public Node(int val) {
                data = val;
                this.next = null;
                this.pre = null;
            }
        }

    Node head;

        public DoublyList(){
        head = null;
        }
        public DoublyList(int val){
            head = new Node(val);
        }

        public void addAtHead(int val) {
            head = new Node(val);
        }

        public boolean search(int val) {
            Node cur = head;

            while (cur != null) {

                if (cur.data == val)
                    return true;

                cur = cur.next;
            }
            return false;
        }

        public void insert(int val){
            if(head == null) {
                head = new Node(val);
                return;
            }
            Node cur = head;

            while (cur.next != null)
                cur = cur.next;
            Node tmp = new Node(val);
            tmp.pre = cur;
            cur.next = tmp;
        }

        public void insertbeg(int val) {
            Node cur = head;
            Node tmp = new Node(val);
            cur.pre = tmp;
            tmp.next = cur;
            head = tmp;
        }

        public int count(int val) {
            int cn = 0;
            Node tmp = head;
            while (tmp != null) {
                if (tmp.data == val)
                    cn++;
                tmp = tmp.next;
            }
            return cn;
        }
        public void insert_dur(int index, int val){
            Node tmp = new Node(val);

            Node cur = head;
            int i = 1;
            while(cur != null && i != index){
                cur = cur.next;
                i++;
            }
            if(cur == null) {
                insert(val);
                return;
            }
            if(cur.next == null) {
                insert(val);
                return;
            }
            cur.next.pre = tmp;
            tmp.pre = cur;
            tmp.next = cur.next;
            cur.next = tmp;

        }
        public void print(){
            Node tmp = head;
            while(tmp!=null){
                System.out.print(tmp.data+", ");
                tmp = tmp.next;
            }
            System.out.println("");
        }
        public void print_reverse(){
            Node tmp = head;
            while(tmp.next!=null){
                tmp = tmp.next;
            }

            do {
                System.out.print(tmp.data+", ");
                tmp = tmp.pre;
            }
            while (tmp!=null);
        }

        public void removevalue(int val){
            Node tmp = head;
            Node pre = null, next = head;

            if (tmp == null)
                return;

            pre.next = next.next;
        }



    }
    public static void main(String [] args){
        DoublyList a = new DoublyList(12);
        a.insert(24);
        a.insert(44);
        a.insertbeg(43);
        a.insert_dur(2, 53);
        a.print();
        a.print_reverse();
    }
}
