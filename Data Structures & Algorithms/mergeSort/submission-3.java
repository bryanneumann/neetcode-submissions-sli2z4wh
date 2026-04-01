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
            if (R - L + 1 <= 1){
                return;
            }
            int M = (L + R) / 2;
            mergeSort(pairs, L, M);
            mergeSort(pairs, M + 1, R);
            merge(pairs, L, M, R);
        }
    }

    void merge(List<Pair> pairs, int L, int M, int R){
        int len1 = M - L + 1;
        int len2 = R - M;
        List<Pair> left = new ArrayList<>();
        List<Pair> right = new ArrayList<>();
        for (int i = 0; i < len1; i++){
            left.add(pairs.get(L + i));
        }
        for (int j =0; j < len2; j++){
            right.add(pairs.get(M + j + 1));
        }
        int i = 0;
        int j = 0;
        int k = L;
        while (i < len1 && j < len2){
            if (left.get(i).key <= right.get(j).key){
                pairs.set(k, left.get(i));
                i++;
            } else {
                pairs.set(k, right.get(j));
                j++;
            }
            k++;
        }
        while (i < len1){
            pairs.set(k, left.get(i));
            i++;
            k++;
        }
        while (j < len2){
            pairs.set(k, right.get(j));
            j++;
            k++;
        }
    }
}
