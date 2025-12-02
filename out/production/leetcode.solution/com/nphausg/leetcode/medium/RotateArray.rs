/// <a href="https://leetcode.com/problems/rotate-array/">189. Rotate Array</a>

/// Intermediate array, Space = O(n), Time = O(n)
pub fn rotate(nums: &mut [i32], k: i32) {
    let n = nums.len();
    if n == 0 {
        return;
    }
    
    let k = (k as usize) % n;
    if k == 0 {
        return;
    }
    
    let mut result = vec![0; n];
    
    // Copy the last k elements to the beginning of result
    for i in 0..k {
        result[i] = nums[n - k + i];
    }
    
    // Copy the remaining elements
    for i in k..n {
        result[i] = nums[i - k];
    }
    
    // Copy result back to nums
    nums.copy_from_slice(&result);
}

/// Bubble Rotate O(n*k) -> Time Limit Exceeded
pub fn rotate2(nums: &mut [i32], k: i32) {
    if k > 0 {
        for _ in 0..k {
            for j in (1..nums.len()).rev() {
                nums.swap(j, j - 1);
            }
        }
    }
}

