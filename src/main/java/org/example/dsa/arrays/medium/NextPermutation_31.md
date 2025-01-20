<b>Permutation</b>

The term permutation refers to a mathematical calculation 
of the number of ways a particular set can be arranged.
Simply, How many types of combination, we can construct an array.

Simply, If we give a value - <b>[1,2,3]</b>
below is the sequecial way to find next permuatations
<p>[1, 2, 3]</p>
<p>[1, 3, 2]</p>
<p>[2, 1, 3]</p>
<p>[2, 3, 1]</p>
<p>[3, 1, 2]</p>
<p>[3, 2, 1]</p>

We can identify, how many permutation we can construct based on inputs. In above example, an array contains 3 values, So 3! (factorial) is 6. We can get 6 set of permutation values.
Simply no of values of factorial is equal to permutation steps. Also the final permutation step is in decreasing order.

To achieve this, we have to follow 4 steps for to solve in optimal way.

Steps are defined in simple english for my understanding.
1. Final goal is all numbers should be in descending order.
2. So, if any ascending order exists, we should mark the index
3. Then, we should find maximum number when compare with marked index and swap those 2 numbers.
4. Finally reverse the remaining part (which is after the elements from marked index).

Below steps are used to understand the code
Step 1: Find the break-point, i: Break-point means the first index i from the back of the given array where arr[i] becomes smaller than arr[i+1].
For example, if the given array is {2,1,5,4,3,0,0}, the break-point will be index 1(0-based indexing). Here from the back of the array, index 1 is the first index where arr[1] i.e. 1 is smaller than arr[i+1] i.e. 5.

```
// We should traverse from reverse order to find the larger number followed by smaller number, simply it should not come with ascending order. permutation goal is to make the complete list in decreasing order. 
int dipIndex=-1;
for(int i=nums.length-2; i>=0; i--){
    if(nums[i]<nums[i+1]){
        dipIndex=i;
        break;
    }
}
```
Step 2: To find the break-point, using a loop we will traverse the array backward and store the index i where arr[i] is less than the value at index (i+1) i.e. arr[i+1].
If such a break-point does not exist i.e. if the array is sorted in decreasing order, the given permutation is the last one in the sorted order of all possible permutations. So, the next permutation must be the first i.e. the permutation in increasing order.

Step 3: So, in this case, we will reverse the whole array and will return it as our answer.
````
// reverse the complete array, if it is on the final step of permutation
if(dipIndex==-1){
    int left=0;
    int right=nums.length-1;
    while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;right--;
    }
}
````
Step 4: If a break-point exists:
Find the smallest number i.e. > arr[i] and in the right half of index i(i.e. from index i+1 to n-1) and swap it with arr[i].

```
for(int i=nums.length-1; i>=0; i--){
    if(nums[i]>nums[dipIndex]){
        // swap both values using its indexes
            int temp=nums[dipIndex];
            nums[dipIndex]=nums[i];
            nums[i]=temp;
    }
}
```
Reverse the entire right half(i.e. from index i+1 to n-1) of index i. And finally, return the array.
```
    int left=dipIndex+1;
    int right=nums.length-1;
    while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;right--;
    }
```
In above problem states that, we need to find the next permutation values, but if we need to find the final permutation value, we should do recursion.
Refer below full code

```java
class Solution {
    static void reverse(int[] nums, int left, int right){
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;right--;
        }
    }
    static void swap(int[] nums, int left, int right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
    }

    public static void nextPermutation(int[] nums) {
        int dipIndex = -1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                dipIndex=i;
                break;
            }
        }

        if(dipIndex==-1){
             int left=0;
             int right=nums.length-1;
             reverse(nums, left, right);
        }
        else{
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>nums[dipIndex]){
                swap(nums, dipIndex, i);
                break;
            }
        }
        reverse(nums, dipIndex+1, nums.length-1);
        }
    }
}
```
