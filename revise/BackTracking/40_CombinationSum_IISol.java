class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates and enable pruning
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remainingTarget, int start, List<Integer> currentCombination, List<List<Integer>> result) {
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates to avoid duplicate combinations
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue; // 1,2,2,2 5 //this doesn't mean that all the 2's will not be considered, just that it will be considered in next iterator 
            }
            // [] this is how recurrsion work
            //     1   1,2  1,2,2  1,2,2,5                                
            //              1,2,5                       
            //     2   2,2     2,2,5
            //         2,5
            if (candidates[i] > remainingTarget) {
                break;
            }

            // Include the current candidate in the combination
            currentCombination.add(candidates[i]);
            // Recurse with the next index (since each number can only be used once)
            backtrack(candidates, remainingTarget - candidates[i], i + 1, currentCombination, result);
            // Backtrack: remove the last candidate to try other combinations
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}