class LinkedList {
    class ListNode {
        int val = -1;
        ListNode next = null;
    }
    ListNode head;
    public LinkedList() {
        head = new ListNode();
        head.val = -1;
    }

    public int get(int index) {
        int i = 0;
        ListNode node = head.next;
        while (node != null){
            if (index == i){
                return node.val;
            }
            i++;
            node = node.next;
        }
        return -1;
    }

    public void insertHead(int val) {
        ListNode t = head.next;
        head.next = new ListNode();
        head.next.val = val;
        head.next.next = t;
    }

    public void insertTail(int val) {
        if (head.next == null){
            head.next = new ListNode();
            head.next.val = val;
            return;
        }
        ListNode node = head.next;
        ListNode last = node;
        while (node != null){
            last = node;
            node = node.next;
        }
        if (last == null){
            last = new ListNode();
            last.val = val;
            return;
        }
        last.next = new ListNode();
        last.next.val = val;
        
    }

    public boolean remove(int index) {
        int i = 0;
        ListNode node = head.next;
        ListNode found = null;
        ListNode beforeFound = null;
        while (node != null){
            if (i == index){
                found = node;
                break;
            }
            i++;
            beforeFound = node;
            node = node.next;
        }
        if (beforeFound == null){
            beforeFound = head;
        }
        if (found != null){
            ListNode afterFound = found.next;
            beforeFound.next = afterFound;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        ListNode node = head.next;
        while (node != null){
            values.add(node.val);
            node = node.next;
        }
        return values;
    }
}
