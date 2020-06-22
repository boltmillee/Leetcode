class Solution {
    int index = -1;
    public int search(int[] nums, int target) {

        if(nums.length == 0)
            return -1;

        if(nums.length ==1){
            if(nums[0] == target)
                return 0;
            else
                return -1;
        }

        search(nums, 0, nums.length-1);
        System.out.print(index);

        if(index != -1){
             if(target<nums[0]){
            return bs(nums, index+1, nums.length-1, target);
        } else
            return bs(nums, 0, index, target);
        } else{
            return bs(nums, 0, nums.length-1, target);
        }



    }

    void search(int[] arr, int l, int r){

        if(l>=r)
            return;

        int mid = (l+r)/2;


        if(arr[mid] > arr[mid+1]){
            index = mid;
            return;
        }

        if(arr[mid]<=arr[l]){
            search(arr, l, mid);
        }else{
           search(arr, mid+1 , r);
        }
    }

    int bs(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return bs(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return bs(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }
}
