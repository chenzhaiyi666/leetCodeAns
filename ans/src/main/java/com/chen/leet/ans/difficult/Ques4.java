package com.chen.leet.ans.difficult;


import java.util.Arrays;

//4. 寻找两个正序数组的中位数
//https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
public class Ques4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if((nums1.length + nums2.length) % 2==0) {
            int midOneIndex = (nums1.length + nums2.length)/2-1;
            int midTwoIndex = (nums1.length + nums2.length)/2;
            int midOne = 0; int midTwo = 0;

            //寻找两个置为数
            int head1 = 0; int head2 = 0; int seq = -1; int to = 0;
            while(head1<=nums1.length || head2<=nums2.length) {
                if(head1<nums1.length && head2<nums2.length) {
                    if(nums1[head1]<nums2[head2]) {
                        to = nums1[head1];
                        head1++;
                        seq++;
                    } else {
                        to = nums2[head2];
                        head2++;
                        seq++;
                    }
                } else if(head1<nums1.length && head2>=nums2.length) {
                    seq++;
                    to = nums1[head1];
                    head1++;
                } else if(head1>=nums1.length && head2<nums2.length) {
                    seq++;
                    to = nums2[head2];
                    head2++;
                }

                if(seq==midOneIndex) {
                    midOne = to;
                } else if(seq==midTwoIndex) {
                    midTwo = to;
                    break;
                }
            }
            return (Double.valueOf(midOne)+Double.valueOf(midTwo))/2;

        } else {
            int midIndex = (nums1.length + nums2.length)/2;
            int mid = 0;
            int head1 = 0; int head2 = 0; int seq = -1; int to = 0;
            while(head1<nums1.length || head2<nums2.length) {
                if(head1<nums1.length && head2<nums2.length) {
                    if(nums1[head1]<nums2[head2]) {
                        to = nums1[head1];
                        head1++;
                        seq++;
                    } else {
                        to = nums2[head2];
                        head2++;
                        seq++;
                    }
                } else if(head1<nums1.length && head2>=nums2.length) {
                    seq++;
                    to = nums1[head1];
                    head1++;
                } else if(head1>=nums1.length && head2<nums2.length) {
                    seq++;
                    to = nums2[head2];
                    head2++;
                }

                if(seq==midIndex) {
                    mid = to;
                    break;
                }
            }
            return mid;
        }

    }


    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2};
        int[] num2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(num1,num2));
    }
}
