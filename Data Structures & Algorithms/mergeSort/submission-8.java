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
        List<Pair> left = new ArrayList<>();
        List<Pair> right = new ArrayList<>();
        for (int i = L; i < M + 1; i++){
            left.add(pairs.get(i));
        }
        for (int i = M + 1; i < R + 1; i++){
            right.add(pairs.get(i));
        }
        int i = 0;
        int j = 0;
        int k = L;
        while (i < left.size() && j < right.size()){
            if (left.get(i).key <= right.get(j).key){
                pairs.set(k, left.get(i));
                i++;
            } else {
                pairs.set(k, right.get(j));
                j++;
            }
            k++;
        }
        while (i < left.size()){
            pairs.set(k, left.get(i));
            i++;
            k++;
        }
        while (j < right.size()){
            pairs.set(k, right.get(j));
            j++;
            k++;
        }
    }
}
