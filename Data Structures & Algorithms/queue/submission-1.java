class Deque {
    class Node{
        int val = -1;
    }
    List<Integer> q = new ArrayList<>();
    public Deque() {

    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public void append(int value) {
       q.add(value);
    }

    public void appendleft(int value) {
       if (!q.isEmpty()){
        q.add(0, value);
       } else {
        q.add(value);
       }
    }

    public int pop() {
        if (q.isEmpty()){
            return -1;
        }
       int r = q.get(q.size() - 1);
       q.remove(q.size()-1);
       return r;
    }

    public int popleft() {
        if (q.isEmpty()){
            return -1;
        }
       int r = q.get(0);
       q.remove(0);
       return r; 
    }
}
