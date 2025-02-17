
class LetterTilePossibilities{
    void helper(int x, char[] original, StringBuilder temp, Integer result, boolean[] visited) {
        if(x == 0){
            
            return;
        }
        for (int i = 0; i < original.length; i++) {
            if((i==0 || original[i-1] != original[i] || visited[i-1] ) && !visited[i] ){
                visited[i] = true;
                helper(x - 1, original, temp, result, visited);
                visited[i] = false;
            }
        }
    }
   
    public int numTilePossibilities(String tiles) {    
        char[] original = tiles.toCharArray();
        int n = original.length;
        Integer result = new Integer();
        result = 0;
        Arrays.sort(original);
        for (int i = 1; i < original.length + 1; i++) {
            Set<String> set = new HashSet<String>();
            boolean[] visited = new boolean[n];
             helper(i, original, new StringBuilder(), result, visited);
             result += set.size();
        }
        return result;      
    }
}