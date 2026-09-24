class Solution {
private:
    vector<int> merge(vector<int> arr1, vector<int> arr2){
        int i = 0, j = 0, k = 0;
        vector<int> temp;
        while(i < arr1.size() && j < arr2.size()){
            if(arr1[i] < arr2[j])
                temp.push_back(arr1[i++]);
            else
                temp.push_back(arr2[j++]);
        }
        while(i < arr1.size())
            temp.push_back(arr1[i++]);
        while(j < arr2.size())
            temp.push_back(arr2[j++]);
        return temp;
    }
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        vector<int> mergedArray = merge(nums1, nums2);
        double median = 0;
        if(mergedArray.size() % 2 == 0){
            int mid = mergedArray.size() / 2;
            median = (mergedArray[mid - 1] + mergedArray[mid]) / 2.0;
            return median;
        } else {
            int mid = mergedArray.size() / 2;
            median = mergedArray[mid];
            return median;
        }
    return median;
    }
};