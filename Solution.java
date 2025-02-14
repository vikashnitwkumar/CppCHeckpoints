import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

class ProductOfNumbers {
    List<Integer> proIntegers;
    int zeroIndex;
    public ProductOfNumbers() {
        proIntegers = new ArrayList<Integer>();
        zeroIndex = -1;
    }
    
    public void add(int num) {
        if(proIntegers.size() == 0 || proIntegers.get(proIntegers.size()-1) == 0){
            proIntegers.add(num);
        }
        else{
            proIntegers.add(proIntegers.get(proIntegers.size()-1) * num);
        }
        if(num == 0){
            zeroIndex = proIntegers.size()-1;
        }
    }
    
    public int getProduct(int k) {
        int n = nums.size();
        if(proIntegers.size() == 0 ||  n-k>= zeroIndex) return 0;
        return proIntegers.get(proIntegers.size()-1);
    }

}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */