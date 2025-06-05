public class Main {
    public static void main(String[] args) {

        String[] a = {"time", "in", "moment", "this", "at", "scene", "before","never", "always"};
        for(int i=0; i<a.length; i++){
            System.out.printf(a[i] + ", ");
        }
        System.out.println();
        selectionSort4(a);
        for(int i=0; i<a.length; i++){
            System.out.printf(a[i] + ", ");
        }
    }

    public static void selectionSort(String[] arr){
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (CharSequence.compare(arr[j] , arr[min_idx]) < 0)
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            String temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void selectionSort2(String[] arr){
      int n = arr.length;
      for(int i = 0; i<n-1; i++){
          int smallest = i;
          for(int j=i+1; j<n; j++)
              if(CharSequence.compare(arr[j], arr[smallest])<0)
                  smallest = j;
          String temp = arr[smallest];
          arr[smallest] = arr[i];
          arr[i] = temp;

      }
    }

    public static void selectionSort3(String[] arr){
       int n = arr.length;
       for(int i=0; i<n-1; i++){
           int smallest = i;
           for(int j=i+1; j<n; j++)
               if(CharSequence.compare(arr[j], arr[smallest])<0)
                   smallest = j;
           String temp = arr[smallest];
           arr[smallest]=arr[i];
           arr[i] = temp;
       }
    }


    public static void selectionSort5(String[] arr){
       int n = arr.length;
       for(int i=0; i<n-1; i++){
           int smallest = i;
           for(int j=i+1; j<n; j++)
               if(CharSequence.compare(arr[j], arr[smallest])<0)
                   smallest = j;
           String temp = arr[smallest];
           arr[smallest] = arr[i];
           arr[i]= temp;
       }
    }
}