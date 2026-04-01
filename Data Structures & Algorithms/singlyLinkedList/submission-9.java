class LinkedList {

    public class Node{
        int val = -1;
        Node next = null;
        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    };

    Node head;
    public LinkedList() {
        head = new Node( -1, null);
    }

    public int get(int index) {
       Node cur = head;
       int curIndex = -1;
       while (cur != null){
         if (curIndex == index){
           return cur.val; 
         } 
         cur = cur.next;
         curIndex++;
       }
       return -1;
    }

    public void insertHead(int val) {
        Node next = head.next;
        Node newNode = new Node(val, next);
        head.next = newNode;
    }

    public void insertTail(int val) {
        Node last = head;
        while (last != null && last.next != null){
            last = last.next;
        }
        Node node = new Node(val, null);
        last.next = node;
    }

    public boolean remove(int index) {
        if (index == 0){
            if (head.next != null){
                head.next = head.next.next;
                return true;
            }
        }
        Node node = head;
        int i = -1;
        Node prev = null;
        while (node != null){
            if (i == index){
                break;
            }
            prev = node;
            node = node.next;
            i++;
        }
        Node target = node;
        if (prev != null && target != null && target.next != null){
            prev.next = target.next;
            return true;
        } 
        if (target != null){
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        Node node = head;
        int i = -1;
        ArrayList<Integer> values = new ArrayList<>();
        while (node != null){
            if (i >= 0){
                values.add(node.val);   
            }
          node = node.next;
          i++;
        }
        return values;
    }
}
