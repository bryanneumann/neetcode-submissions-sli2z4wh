class LinkedList {
	class ListNode {
		ListNode next =null;
		int val = -1;
		public ListNode(int v, ListNode n){
			this.val = v;
			this.next= n;
		}
	}
    ListNode head;
    public LinkedList() {
        head = new ListNode(-1, null);
    }

    public int get(int index) {
        int i = 0;
        ListNode node = head.next;
        while (node != null){
            if (i == index){
                return node.val;
            }
            node = node.next;
            i++;
        }
        return -1;
    }

    public void insertHead(int val) {
        if (head == null){
            // Throw exception
        }
        if (head.next == null){
            head.next = new ListNode(val, null);
            return;
        }
        ListNode t = head.next;
        head.next = new ListNode(val, t);
    }

    public void insertTail(int val) {
        ListNode node = head.next;
        ListNode beforeNode = head;
        while (node != null){
            beforeNode = node;
            node = node.next;
        }
        beforeNode.next = new ListNode(val, null);
    }

    public boolean remove(int index) {
        int i = 0;
        ListNode node = head.next;
        ListNode beforeNode = head;
        while (node != null){
            if (i == index){
                ListNode afterNode = node.next;
                beforeNode.next = afterNode;
                return true;
            }
            beforeNode = node;
            node = node.next;
            i++;
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
