package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();
        List<List<Integer>> twoDArray = new ArrayList<>();

        // Adding subarrays to the 2D list
        twoDArray.add(Arrays.asList(1, 2, 3, 4, 5));
        twoDArray.add(Arrays.asList(6, 7));
        twoDArray.add(List.of(8));
        twoDArray.add(Arrays.asList(9, 10, 11));
        twoDArray.add(Arrays.asList(12, 13, 14, 15, 16));

        List<List<Integer>> twoDArray2 = new ArrayList<>();

        // Adding subarrays to the 2D list
        twoDArray2.add(Arrays.asList(1, 2, 3));
        twoDArray2.add(Arrays.asList(4, 5, 6));
        twoDArray2.add(Arrays.asList(7, 8, 9));

//        System.out.println(s.minIncrementOperations(new int[]{43,31,14,4}, 73));
//        System.out.println(Arrays.toString(s.findDiagonalOrder(twoDArray)));
//        System.out.println(Arrays.toString(s.findDiagonalOrder(twoDArray2)));
//        System.out.println(Arrays.toString(s.findDiagonalOrder(List.of(List.of(6),List.of(8),List.of(6,1,6,16)))));
//        System.out.println(Arrays.toString(s.findDiagonalOrder(List.of(List.of(1,2,3),List.of(4),List.of(5,6,7),List.of(8),List.of(9,10,11)))));
//        System.out.println(Arrays.toString(s.findDiagonalOrder(List.of(List.of(1,2,3,4,5,6)))));
            String inputStr = "gvgvvgv";
            int kValue = 2;
            List<String> resultSubstrings = Solution. findSubstringsWithKOccurrences(inputStr, kValue);

            for (String substring : resultSubstrings) {
                System.out.println(substring);
            }
//        System.out.println(s.validPath());

    }

}

//class Solution {
//    public long minIncrementOperations(int[] A, int k) {
//        long dp1 = 0, dp2 = 0, dp3 = 0, dp;
//
//
//        for (int a: A) {
//            System.out.println("dp1 -> " + dp1);
//            System.out.println("dp2 -> " + dp2);
//            System.out.println("dp3 -> " + dp3);
//            System.out.println("k -> " + k);
//            System.out.println("a -> " + a);
//
//
//            dp = Math.min(dp1, Math.min(dp2, dp3)) + Math.max(k - a, 0);
//            System.out.println("dp -> " + dp);
//            System.out.println("=================================");
//            dp1 = dp2;
//            dp2 = dp3;
//            dp3 = dp;
//
//        }
//        return Math.min(dp1, Math.min(dp2, dp3));
//    }
//}

//class Solution
//{
//    public boolean validPath(int n, int[][] edges, int source, int destination)
//    {
//        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
//        for(int i=0;i<n;i++)
//        {
//            adj.add(new ArrayList<>());
//        }
//        for (int[] edge : edges) {
//            int u = edge[0];
//            int v = edge[1];
//
//            adj.get(u).add(v);
//            adj.get(v).add(u);
//
//        }
//        Queue<Integer>q=new LinkedList<>();
//        q.add(source);
//        boolean flag=false;
//        boolean[] vis =new boolean[n+1];
//        vis[source]=true;
//        while(!q.isEmpty())
//        {
//            int node=q.peek();
//            q.poll();
//            if(node==destination)
//            {
//                flag=true;
//                break;
//            }
//            for(Integer it:adj.get(node))
//            {
//                if(!vis[it])
//                {
//                    q.add(it);
//                    vis[it]=true;
//                }
//            }
//        }
//        return flag;
//    }
//}


 class Solution {

     public static List<String> findSubstringsWithKOccurrences(String word, int k) {
         List<String> result = new ArrayList<>();

         for (int length = k; length <= word.length(); length++) {
             int start = 0;
             int end = 0;

             Map<Character, Integer> charCount = new HashMap<>();

             while (end < length) {
                 char currentChar = word.charAt(end);
                 charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);
                 end++;
             }

             if (allCharactersKOccurrences(charCount, k) && isValidSubString(word.substring(start, end))) {
                 result.add(word.substring(start, end));
             }

             while (end < word.length()) {
                 char startChar = word.charAt(start);
                 charCount.put(startChar, charCount.get(startChar) - 1);
                 if (charCount.get(startChar) == 0) {
                     charCount.remove(startChar);
                 }
                 start++;

                 char currentChar = word.charAt(end);
                 charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);
                 end++;

                 if (allCharactersKOccurrences(charCount, k) && isValidSubString(word.substring(start, end))) {
                     result.add(word.substring(start, end));
                 }
             }
         }


         return result;
     }

     private static boolean allCharactersKOccurrences(Map<Character, Integer> charCount, int k) {
         for (int count : charCount.values()) {
             if (count != k) {
                 return false;
             }
         }
         return true;
     }
     private static boolean isValidSubString(String subString){
         //if the difference between adjacent characters is at most 2 return true else false
            for(int i = 0; i < subString.length()-1; i++){
                if(Math.abs(subString.charAt(i) - subString.charAt(i+1)) > 2){
                    return false;
                }
            }
            return true;
     }

}


//class Solution {
//    public int[] findDiagonalOrder(List<List<Integer>> nums) {
//        if(nums.size() < 2){
//            return nums.get(0).stream().mapToInt(i -> i).toArray();
//        }
//        int count= 0;
//        List<List<Integer>> lists = new ArrayList<>();
//
//        for(int i = 0 ; i < nums.size(); i++){
//            List<Integer> row = nums.get(i);
//            for(int j = 0; j < row.size(); j++){
//                int idx = i + j;
//                if(lists.size() <= idx){
//                    lists.add(new ArrayList<>());
//                }
//                lists.get(idx).add(row.get(j));
//                count++;
//            }
//        }
//        int[] res = new int[count];
//        int idx = 0;
//        for(List<Integer> list : lists){
//            for(int i = list.size()-1; i >= 0; i--){
//                res[idx] = list.get(i);
//                idx++;
//            }
//        }
//
//        return res;
//    }
//}
//============== Leetcode 1814====================
//class Solution {
//    public int countNicePairs(int[] nums) {
//        long mod = 1000000007;
//        long count = 0;
//        Map<Integer, Long> s = new HashMap<>();
//        for (int num : nums) {
//            int nr = num - rev(num);
//            s.put(nr, s.getOrDefault(nr, (long) 0) + 1);
//        }
//
//
//        for(long num : s.values()){
//            if(num > 1){
//                count += ((num-1) * (num))/2;
//            }
//        }
//
//        return (int) (count % mod);
//    }
//
//    private int rev (int num){
//        int reverse = 0;
//        while(num != 0){
//            int remainder = num % 10;
//            reverse = reverse * 10 + remainder;
//            num = num/10;
//        }
//        return reverse;
//    }
//
//}
//class Solution {
//    public int maxFrequency(int[] nums, int k) {
//        Arrays.sort(nums);
//        int res = 1;
//        int l = 0;
//        int r = 0;
//        long currentSum = nums[r];
//        while(l < nums.length && r < nums.length){
//            long total =  ((long) nums[r] * ((r - l)+1));
//            if(currentSum + k >= total){
//                res = Math.max(res,((r - l)+1));
//                r++;
//                if(r < nums.length){
//                    currentSum += nums[r];
//                }
//            }else{
//                currentSum -= nums[l];
//                l++;
//            }
//        }
//        return res;
//    }
//}


// =========================== leetcode =====================
// O(N) solution
//class Solution {
//    public boolean checkInclusion(String s1, String s2) {
//        if(s1.length() > s2.length()){
//            return false;
//        }
//        HashMap<Character, Integer> hm = new HashMap<>();
//        int left = 0;
//        int right = s1.length()-1;
//
//        for(int i = 0; i <= right; i++){
//            hm.put(s1.charAt(i), hm.getOrDefault(s1.charAt(i), 0) + 1);
//            hm.put(s2.charAt(i), hm.getOrDefault(s2.charAt(i), 0) - 1);
//        }
//        while(left < s2.length() && right < s2.length()){
//            boolean isValid = true;
//            for(int num : hm.values()){
//                if (num != 0) {
//                    isValid = false;
//                    break;
//                }
//            }
//            if(isValid){
//                return true;
//            }
//            if(right-left < s1.length()-1){
//                right++;
//                hm.put(s2.charAt(right), hm.getOrDefault(s2.charAt(right), 0) - 1);
//                hm.put(s1.charAt(right%s1.length()), hm.getOrDefault(s1.charAt(right%s1.length()), 0) + 1);
//
//            }
//            else{
//                right++;
//                if(right < s2.length()){
//                    hm.put(s2.charAt(right), hm.getOrDefault(s2.charAt(right), 0) - 1);
//                }
//                hm.put(s2.charAt(left), hm.getOrDefault(s2.charAt(left), 0) + 1);
//                left++;
//            }
//
//
//
//        }
//        return false;
//
//
//    }
//}

// O(n2) solution
//class Solution {
//    public boolean checkInclusion(String s1, String s2) {
//        if(s1.length() > s2.length()){
//            return false;
//        }
//        for(int j = 0; j <= s2.length() - s1.length(); j++){
//            HashMap<Character, Integer> hm = new HashMap<>();
//            for(int i = j; i < j + s1.length(); i++){
//                hm.put(s1.charAt(i%s1.length()), hm.getOrDefault(s1.charAt(i%s1.length()), 0) + 1);
//                hm.put(s2.charAt(i), hm.getOrDefault(s2.charAt(i), 0) - 1);
//                System.out.println(hm);
//            }
//            boolean isValid = true;
//            for(int num : hm.values()){
//                if (num != 0) {
//                    isValid = false;
//                    break;
//                }
//            }
//            if(isValid){
//                return true;
//            }else{
//                if(j == s2.length()-1){
//                    return false;
//                }
//            }
//
//        }
//        return false;
//
//
//    }
//}


// ======================= leetcode ==========================
//class Solution {
//    public String findDifferentBinaryString(String[] nums) {
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < nums.length; i++){
//            if(nums[i].charAt(i) == '0'){
//                sb.append("1");
//            }else{
//                sb.append("0");
//
//            }
//        }
//        return sb.toString();
//    }
//}
//class Solution {
//    public String findDifferentBinaryString(String[] nums) {
//        int max = (int) Math.pow(2, nums.length);
//        Set<String> s = new HashSet<>(Arrays.asList(nums));
//        for(int i = 0; i <= max; i++){
//            String binary = String.format("%"+nums.length+"s", Integer.toBinaryString(i)).replace(' ', '0');
//            if(s.add(binary)){
//                return binary;
//            }
//        }
//        return "";
//    }
//}
// ================= Leetcode 739 ================
//class Solution {
//    public int[] dailyTemperatures(int[] temperatures) {
//        int l = temperatures.length;
//        int[] res = new int[l];
//        Stack<Integer> s = new Stack<>();
//        res[l-1] = 0;
//        for(int i =0; i < l;i++){
//            while(!s.empty() && temperatures[s.peek()] < temperatures[i]){
//                int pop = s.pop();
//                res[pop] = i -  pop;
//            }
//            s.add(i);
//        }
//        return res;
//    }
//}

//=================== Leet code biweekly 117 Q2 ===================
//class Solution {
//    public long distributeCandies(int n, int limit) {
//        long count = 0;
//
//        for (int i = 0; i <= limit; i++) {
//            System.out.println("i -> " + i);
//            int diff = n - i;
//            System.out.println("diff -> " + diff);
//
//            if (diff < 0) {
//                break;
//            }
//
//            // case 0,3,0 or 0,0,0,5,0,0
//            if (diff == 0) {
//                count++;
//                continue;
//            }
//
//            if (diff <= limit) {
//                count += (diff + 1);
//            } else {
//                if (diff == 2 * limit) {
//                    count++;
//                } else {
//                    int b = diff - limit;
//                    count += limit - b + 1;
//                }
//
//            }
//
//        }
//        return count;
//    }
//};


//class Solution {
//    public long distributeCandies(int n, int limit) {
//        long count = 0;
//
//        for(int i = 0; i <= limit; i++){
//            int l = 0;
//            while(l <= limit){
//                if(i + l  <= n && n - (i+l) <= limit){
//                    count++;
//                }
//                l++;
//
//            }
//        }
//        return count;
//
//    }
//}


// ============================== Leetcode contest 371 q3 =========================
//class Solution {
//    public int minOperations(int[] nums1, int[] nums2) {
//
//        int[] n1 = Arrays.copyOf(nums1, nums1.length);
//        int[] n2 = Arrays.copyOf(nums2, nums1.length);
//        int c = 0;
//        int c2 = 0;
//        int l1 = nums1.length;
//        int m1 = nums1[l1 - 1];
//        int m2 = nums2[l1 - 1];
//        for (int i = 0; i < l1 - 1; i++) {
//            if (!(nums1[i] <= m1 && nums2[i] <= m2)) {
//                int t = nums1[i];
//                nums1[i] = nums2[i];
//                nums2[i] = t;
//                if (nums1[i] <= m1 && nums2[i] <= m2) {
//                    c++;
//                }
//            }
//        }
//        int z = n1[l1 - 1];
//        n1[l1 - 1] = n2[l1 - 1];
//        n2[l1 - 1] = z;
//        c2++;
//        m1 = n1[l1 - 1];
//        m2 = n2[l1 - 1];
//        for (int i = 0; i < l1 - 1; i++) {
//            if (!(n1[i] <= m1 && n2[i] <= m2)) {
//                int t = n1[i];
//                n1[i] = n2[i];
//                n2[i] = t;
//                if (n1[i] <= m1 && n2[i] <= m2) {
//                    c2++;
//                } else {
//                    return -1;
//                }
//            }
//        }
//        return Math.min(c, c2) == 0 ? -1 : Math.min(c, c2);
//
//    }
//}

//=============================== Leetcode contest 371 q2 ======================
//class Solution {
//    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
//        Map<String, ArrayList<String>> t = new HashMap<>();
//        Set<String> res = new HashSet<>();
//        Set<String> d = new HashSet<>();
//
//        for (List<String> accessTime : access_times) {
//            d.add(accessTime.get(0));
//            if(t.get(accessTime.get(0))== null){
//                ArrayList<String> z = new ArrayList<>();
//                z.add(accessTime.get(1));
//                t.put(accessTime.get(0),z);
//            }else{
//                t.get(accessTime.get(0)).add(accessTime.get(1));
//            }
//        }
//        for (String  key   : d) {
//            if (t.get(key).size() > 2) {
//                Collections.sort(t.get(key));
//
//                for(int i = 0; i < t.get(key).size(); i ++ ){
//                    int l = i+1;
//                    int r = l+1;
//                    while(l < r && r < t.get(key).size()){
//                        int mi = Integer.parseInt(t.get(key).get(i).substring(0, 2)) * 60 + Integer.parseInt(t.get(key).get(i).substring(2, 4));
//                        int ml = Integer.parseInt(t.get(key).get(l).substring(0, 2)) * 60 + Integer.parseInt(t.get(key).get(l).substring(2, 4));
//                        int mr = Integer.parseInt(t.get(key).get(r).substring(0, 2)) * 60 + Integer.parseInt(t.get(key).get(r).substring(2, 4));
//                        if (mr - mi < 60 && ml - mi < 60) {
//                            res.add(key);
//                            l++;
//                            if (l == r - 1) {
//                                r++;
//                            }
//                        } else  {
//
//                            if(l == r-1){
//                                r++;
//                            }
//                            l++;
//                        }
//
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(res);
//    }
//}

//================= Leetcode same tree ==================
//  class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode() {}
//      TreeNode(int val) { this.val = val; }
//      TreeNode(int val, TreeNode left, TreeNode right) {
//          this.val = val;
//          this.left = left;
//          this.right = right;
//      }
// }
//class Solution {
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if(p == null && q != null){
//            return false;
//        }
//        if(p != null && q == null){
//            return false;
//        }
//        if(p == null){
//            return true;
//        }
//        return helper(p,q);
//    }
//    private boolean helper (TreeNode a, TreeNode b){
//        boolean result = false;
//
//        if( (a != null && b != null) && (a.val == b.val)){
//            result = true;
//            if(a.left != null && b.left != null){
//                result = helper(a.left,b.left);
//            }
//            else if (a.left != null || b.left != null){
//                result = false;
//            }
//            if(result){
//                if(a.right != null && b.right != null){
//                    result = helper(a.right, b.right);
//
//                }
//                else if (a.right != null || b.right != null){
//                    result = false;
//                }
//            }
//
//        }
//
//        return result;
//    }
//}

//class Solution {
//    public int findChampion(int n, int[][] edges) {
//        if(edges.length == 1 && edges[0].length == 1 || n == 1){
//            return 0;
//        }
//        int[] done = new int[n];
//        Set<Integer> s = new HashSet<>();
//        for(int[] z : edges){
//            s.add(z[0]);
//            s.add(z[1]);
//        }
//        int remain = n - s.size();
//        int result = -1;
//        for(int i = 0; i < edges.length; i++){
//            if(edges[i].length > 0 && done[edges[i][0]]!=1){
//                done[edges[i][0]] = 1;
//                int count = 0;
//                for(int j = 0; j < edges.length; j++){
//                    if(edges[i][0] == edges[j][1] && i!=j){
//                        count++;
//                    }
//                }
//                if(count == 0){
//                    if(result != -1 || remain > 0){
//                        return -1;
//                    }
//                    result = edges[i][0];
//                }
//            }
//
//        }
//        return result;
//    }
//}

// =================== Merge sort ==========================
//class Solution {
//    public int[] sortArray(int[] nums) {
//        split(nums);
//        return nums;
//    }
//
//    private void split(int[] array){
//        int l = array.length;
//        if(l == 1){
//            return;
//        }
//        int mid = l / 2;
//        int[] leftArray = new int[mid];
//        int[] rightArray = new int[l - mid];
//        int i = 0;
//        int j = 0;
//        //coppy left and right array
//        for(int k = 0; k<array.length; k++){
//            if(k < mid){
//                leftArray[i] = array[k];
//                i++;
//            }else{
//                rightArray[j] = array[k];
//                j++;
//            }
//
//        }
//
//        split(leftArray);
//        split(rightArray);
//        merge(leftArray, rightArray, array);
//    }
//
//    private void merge (int[] a, int[] b, int[] res){
//        int l = 0;
//        int r = 0;
//        int idx = 0;
//        while(l < a.length && r < b.length){
//            if(a[l] < b[r]){
//                res[idx] = a[l];
//                l++;
//            }else{
//                res[idx] = b[r];
//                r++;
//            }
//            idx++;
//        }
//        while(l < a.length){
//            res[idx] = a[l];
//            l++;
//            idx++;
//        }
//        while(r < b.length){
//            res[idx] = b[r];
//            r++;
//            idx++;
//        }
//    }
//}
// =================== Leetcode trap water hard problem ===================
// class Solution {
//    public int trap(int[] height) {
//        int left = 0;
//        int right = height.length - 1;
//        int lmax = Integer.MIN_VALUE;
//        int rmax = Integer.MIN_VALUE;
//        int ans = 0;
//        while (left < right) {
//
//
//            lmax = Math.max(lmax, height[left]);
//            rmax = Math.max(rmax, height[right]);
//            if(lmax < rmax){
//                ans += lmax - height[left];
//                left++;
//            }else{
//                ans +=  rmax - height[right];
//                System.out.println("rmax " + rmax);
//                System.out.println(ans);
//
//                right--;
//            }
//        }
//        return ans;
//    }
//}

// ==================== Leetcode problem 11 ===============================
//class Solution {
//    public int maxArea(int[] height) {
//        int result = 0;
//
//        int left = 0;
//        int right = height.length - 1;
//        while(left < right){
//            result = Math.max(Math.min(height[left], height[right]) * (right - left), result);
//            if(height[left] < height[right]){
//                left++;
//            }else{
//                right --;
//            }
//        }
//        return result;
//    }
//}
// ================= Leetcode problem 15 =======================
//class Solution {
//    public List<List<Integer>> threeSum(int[] nums) {
//        Set<List<Integer>> rs = new HashSet<>();
//        Arrays.sort(nums);
//        for(int i = 0; i < nums.length; i++){
//            int left = i+1;
//            int right = nums.length - 1;
//            while(left < right){
//                if(nums[left] + nums[right] < (-nums[i]) ){
//                    left++;
//                }
//                else if(nums[left] + nums[right] > (-nums[i]) ){
//                    right--;
//                }
//                else {
//                    rs.add(List.of(nums[i], nums[left], nums[right]));
//                    left++;
//                    right--;
//                }
//            }
//        }
//        return rs.stream().toList();
//    }
//}


//================== Leetcode problem 167 ===================
//class Solution {
//    public int[] twoSum(int[] numbers, int target) {
//        int left = 0;
//        int right = numbers.length - 1;
//        while(numbers[left] + numbers[right] != target){
//            int nl  = numbers[left];
//            int nr = numbers[right];
//            if(nl + nr > target){
//                right--;
//            }
//            if (nl + nr < target){
//                left++;
//            }
//        }
//
//        return new int[]{left+1,right+1};
//
//    }
//
//
//}


// ================= neet code last hash&array problem ==========================

//class Solution {
//    public int longestConsecutive(int[] nums) {
//        if (nums.length < 2){
//            return nums.length;
//        }
//        int count = 1;
//        int result = 1;
//        Set<Integer> s = new HashSet<>();
//        for(int num : nums){
//            s.add(num);
//        }
//        for (int num : nums) {
//           if(!s.contains(num + 1)){
//               int currentNumber = num;
//               count = 1;
//               while(s.contains(currentNumber - 1)){
//                   count++;
//                   currentNumber--;
//               }
//           }
//           result = Math.max(count,result);
//        }
//
//
//        return result;
//    }
//}


// ===================== Leetcode soduku ======================
//class Solution {
//    public boolean isValidSudoku(char[][] board) {
//        ArrayList<HashSet<Character>> arrayHashMap = new ArrayList<>();
//        arrayHashMap.add(new HashSet<>());
//        arrayHashMap.add(new HashSet<>());
//        arrayHashMap.add(new HashSet<>());
//
//        for(int i = 0; i < 9;i++){
//            Set<Character> dp = new HashSet<>();
//            Set<Character> dp2 = new HashSet<>();
//            if(i%3==0){
//                arrayHashMap.get(0).clear();
//                arrayHashMap.get(1).clear();
//                arrayHashMap.get(2).clear();
//            }
//            for(int j = 0; j < 9; j++){
//
//                if(board[i][j] != '.'){
//                    if(!dp.add(board[i][j])){
//                        return false;
//
//                    }
//                    HashSet<Character> t = arrayHashMap.get(j/3);
//                    if(!t.add(board[i][j])){
//                        return false;
//                    }
//                }
//                if(board[j][i] != '.'){
//                    if(!dp2.add(board[j][i])){
//                        return false;
//                    }
//                }
//
//            }
//        }
//        return true;
//
//    }
//
//}

// ===================== leetcode 238 ========================
//using prefix and suffix technique
//class Solution {
//    public int[] productExceptSelf(int[] nums) {
//        int len = nums.length;
//        int[] result = new int[len];
//
//        int[] pre = new int[len];
//        int[] suf = new int [len];
//        pre[0] = 1;
//        suf[len - 1] = 1;
//
//        for(int i = 1 ; i< nums.length; i++){
//            pre[i] = pre[i-1] * nums[i-1];
//        }
//        for(int i = len - 2 ; i >= 0; i--){
//            suf[i] = suf[i+1] * nums[i+1];
//        }
//        for(int i = 0; i < nums.length; i++){
//            result[i] = pre[i] * suf[i];
//        }
//
//        return result;
//    }
//}
// =============== leetcode problem 67 ==============
//class Solution {
//    public String addBinary(String a, String b) {
//        int c = 0;
//        int l1 = a.length()-1;
//        int l2 = b.length()-1;
//        StringBuilder r = new StringBuilder();
//
//        while(l1 >=0 || l2 >= 0 || c > 0){
//            if(l1>=0){
//                c += a.charAt(l1) - '0';
//                l1--;
//            }
//            if(l2>=0){
//                c += b.charAt(l2) - '0';
//                l2--;
//            }
//
//            r.append(c % 2);
//            c = c/2;
//        }
//
//        return r.reverse().toString();
//
//    }
//}

// ========================= Leetcode problem 125 =====================
//class Solution {
//    public boolean isPalindrome(String s) {
//        if(s.equals(" ")){
//            return true;
//        }
//        int left = 0;
//        int right = s.length() - 1;
//        boolean result = true;
//        while(left < right){
//            char leftChar = s.charAt(left);
//            char rightChar = s.charAt(right);
//            boolean isLeftCharValid = Character.isLetterOrDigit(leftChar);
//            boolean isRightCharValid = Character.isLetterOrDigit(rightChar);
//            if (!isLeftCharValid && isRightCharValid){
//                left++;
//            }  if (isLeftCharValid && !isRightCharValid){
//                right--;
//            }
//            if(isLeftCharValid && isRightCharValid){
//                if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)){
//                    return false;
//                }
//                left++;
//                right--;
//            }
//            if(!isLeftCharValid && !isRightCharValid){
//                left++;
//                right--;
//            }
//        }
//        return result;
//    }
//}


// ====================== LeetCode ===================
//class Solution {
//    public int lengthOfLongestSubstring(String s) {
//        int n = s.length();
//        int maxLength = 0;
//        int[] charIndex = new int[128];
//        Arrays.fill(charIndex, -1);
//        int left = 0;
//        for (int right = 0; right < n; right++) {
//            if (charIndex[s.charAt(right)] >= left) {
//                left = charIndex[s.charAt(right)] + 1;
//            }
//            charIndex[s.charAt(right)] = right;
//            maxLength = Math.max(maxLength, right - left + 1);
//        }
//
//        return maxLength;
//    }
//}


// ================== LEETCODE KFREQUENT ================
//class Solution {
//    public int[] topKFrequent(int[] nums, int k) {
//        if (nums.length < 2) {
//            return nums;
//        }
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
//
//        pq.addAll(map.keySet());
//
//        int i = 0;
//        int[] result = new int[k];
//
//        while (i < k) {
//
//            result[i] = pq.poll();
//            i++;
//        }
//        return result;
//
//
//    }

//================= QUICK SORT ============================
//    public void quickSort(int[] arr, int start , int end){
//        if(end <= start){
//            return;
//        }
//        int pivot = partition(arr, start, end);
//
//        quickSort(arr,start, pivot - 1);
//        quickSort(arr,pivot + 1, end);
//    }
//
//    private int partition(int[] arr, int start, int end){
//        int pivot = arr[end];
//        int i = start - 1;
//        for(int j = start ; j <= end - 1; j++){
//            if(arr[j] < pivot){
//                i++;
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//            }
//        }
//        i++;
//        int temp = arr[i];
//        arr[i] = arr[end];
//        arr[end] = temp;
//        return i;
//    }
//}

