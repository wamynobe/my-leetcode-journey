package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.minIncrementOperations(new int[]{43,31,14,4}, 73));

    }

}

class Solution {
    public long minIncrementOperations(int[] A, int k) {
        long dp1 = 0, dp2 = 0, dp3 = 0, dp;


        for (int a: A) {
            System.out.println("dp1 -> " + dp1);
            System.out.println("dp2 -> " + dp2);
            System.out.println("dp3 -> " + dp3);
            System.out.println("k -> " + k);
            System.out.println("a -> " + a);


            dp = Math.min(dp1, Math.min(dp2, dp3)) + Math.max(k - a, 0);
            System.out.println("dp -> " + dp);
            System.out.println("=================================");
            dp1 = dp2;
            dp2 = dp3;
            dp3 = dp;

        }
        return Math.min(dp1, Math.min(dp2, dp3));
    }
}
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

