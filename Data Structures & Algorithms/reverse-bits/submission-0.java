class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i <= 31; i++){
            int extractedBit = (( n >> i) & 1);
            if (extractedBit == 1){
                int setBit = (1 << (31 - i));
                res |= setBit;
            }
        }
        return res;
    }
}
