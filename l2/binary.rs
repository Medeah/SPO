fn main() {
    let a = [1,4,7,9,12,56,89,143,394,1946];
    let middle = &a;
    println!("{}", binary_search_rec(middle, 12, 0 ,9));
    println!("{}", binary_search_loop(middle, 12));
}

fn binary_search_rec(a: &[i32], value: i32, low: usize , high: usize) -> i32 {
      println!("{}{}", low, high);
      if high < low {
          return -1
      }
      let mid = (low + high) / 2;
      if a[mid] > value {
          return binary_search_rec(a, value, low, mid-1);
      }
      else if a[mid] < value {
          return binary_search_rec(a, value, mid+1, high);
      }
      else{
          return mid as i32;
      }
  }


fn binary_search_loop(a: &[i32], value: i32) -> i32 {
      let mut low = 0;
      let mut high = a.len() - 1;
      while low <= high {
          let mid = (low + high) / 2;
          if a[mid] > value{
              high = mid - 1;
          }
          else if a[mid] < value{
              low = mid + 1;
          }
          else{
              return mid as i32;
          }
      }
      return -1;
  }
