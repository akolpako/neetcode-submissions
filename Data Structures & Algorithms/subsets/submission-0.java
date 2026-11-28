class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Subsets subsets = new Subsets();
        subsets.add(new Subset());

        for (int num : nums) {
            var clones = subsets.cloneSubsets();
            for (Subset subset : clones) {
                subset.add(num);
            }
        }

        return subsets.subsets
            .stream()
            .map(subset -> subset.nums)
            .toList();
    }

    private static class Subsets {
        private List<Subset> subsets = new ArrayList<>();

        private void add(Subset subset) {
            subsets.add(subset);
        }

        private List<Subset> cloneSubsets() {
            var clones = subsets
                .stream()
                .map(Subset::cloneSubset)
                .collect(Collectors.toCollection(ArrayList::new));
            subsets.addAll(clones);
            return clones;
        }
    }

    private static class Subset {
        private List<Integer> nums = new ArrayList<>();

        private void add(int num) {
            nums.add(num);
        }

        private Subset cloneSubset() {
            Subset copy = new Subset();
            copy.nums.addAll(nums);
            return copy; 
        }
    }
}
