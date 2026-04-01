// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        mergeSort(pairs, 0, pairs.size() - 1);
        return pairs;
    }

    void mergeSort(List<Pair> pairs, int L, int R){
        if (L < R){
            int M = (L + R) >>> 1;
            mergeSort(pairs, L, M);
            mergeSort(pairs, M + 1, R);
            merge(pairs, L, M, R); 
        }
    }

    void merge(List<Pair> pairs, int L, int M, int R){
        List<Pair> left = new ArrayList<>(pairs.subList(L, M + 1));
        List<Pair> right = new ArrayList<>(pairs.subList(M + 1, R + 1));
        for (int i = 0; i <= M; i++){
            // left.add(pairs.get(i));
        }
        for (int j = M + 1; j <= R; j++){
//            right.add(pairs.get(j));
        }
        int i = 0;
        int j = 0;
        int k = L;
        while (i < left.size() && j < right.size()){
            Pair p1 = left.get(i);
            Pair p2 = right.get(j);
            if (p1.key <= p2.key){
                pairs.set(k, p1);
                i++;
            } else {
                pairs.set(k, p2);
                j++;
            }
            k++;
        }
        while (i < left.size()){
            pairs.set(k, left.get(i));
            i++;
            k++;
        }
        while ( j< right.size()){
            pairs.set(k, right.get(j));
            j++;
            k++;
        }
    }
}
