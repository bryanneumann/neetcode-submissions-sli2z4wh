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
        mergeSort(0, pairs.size() - 1, pairs);
        return pairs;
    }

    void mergeSort(int L, int R, List<Pair> pairs){
        if (L < R){
            int M = (L + R) >>> 1;
            mergeSort(L, M, pairs);
            mergeSort(M + 1, R, pairs);
            merge(L, M, R, pairs);
        }
    }

    void merge(int L, int M, int R, List<Pair> pairs){
        List<Pair> left = new ArrayList<>();
        List<Pair> right = new ArrayList<>();
        int len1 = M + 1;
        int len2 = R - M; 
        for (int i = L; i < len1; i++){
            left.add(pairs.get(i));
        }
        for (int j = M + 1; j < R + 1; j++){
            right.add(pairs.get(j));
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
