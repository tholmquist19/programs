import java.util.Arrays;

public class TestProblems {


    //Count white space
    public int countSpace(String str) {
        int count = 0;
        if(str.length() == 0)
            return 0;
        count = countSpace(str.substring(1));
        if(str.charAt(0) == ' ')
            count++;

        return count; //change this line of code as needed.
    }

    public int countSpace2(String str) {
        int count = 0;
        if(str.length() == 0)
            return 0;
        count = countSpace2(str.substring(1));
        if(str.charAt(0) == ' ')
            count++;
        return count;
    }

    public int countSpace3(String str) {
        int count = 0;
        if(str.length() == 0)
            return 0;
        count = countSpace3(str.substring(1));
        if(str.charAt(0) == ' ')
            count++;
        return count;
    }

    public int countSpace4(String str) {
        int count = 0;
        if(str.length() == 0)
            return 0;
        count = countSpace4(str.substring(1));
        if(str.charAt(0) == ' ')
            count++;
        return count;
    }

    public int countSpace5(String str) {
        int count = 0;
        if(str.length() == 0)
            return 0;
        count = countSpace5(str.substring(1));
        if(str.charAt(0) == ' ')
            count++;
        return count;
    }

    public int countSpace6(String str) {
        int count = 0;
        if(str.length() == 0)
            return 0;
        count = countSpace6(str.substring(1));
        if(str.charAt(0) == ' ')
            count++;
        return count;
    }


    //Contains
    public boolean myContains(String s1, String s2){
        if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0)
            return false;
        if(s2.length() < s1.length())
            return false;
        if(s2.startsWith(s1))
            return true;
        else
            return myContains(s1,s2.substring(1));
    }

    public boolean myContains2(String s1, String s2){
        
        return false;
    }

    public boolean myContains3(String s1, String s2){

        return false;
    }

    public boolean myContains4(String s1, String s2){

        return false;
    }

    public boolean myContains5(String s1, String s2){

        return false;
    }

    public boolean myContains6(String s1, String s2){

        return false;
    }

    public int countSpace7(String str) {

        return 0;
    }

    //Divide

    public int div(int m, int n) throws IllegalArgumentException {
        int count = 0;
        if(m == 0 || n == 0)
            throw new IllegalArgumentException("Can't divide by zero");
        if(n == m)
            return 1;
        if(n > m)
            return 0;
        count = div(m-n,n);
        count++;

        return count; //change this line of code as needed.
    }

    public int div2(int m, int n) throws IllegalArgumentException {

        return 0;
    }

    public int div3(int m, int n) throws IllegalArgumentException {

        return 0;
    }

    public int div4(int m, int n) throws IllegalArgumentException {

        return 0;
    }

    public int div5(int m, int n) throws IllegalArgumentException {

        return 0;
    }

    public int div6(int m, int n) throws IllegalArgumentException {

        return 0;
    }


    public int countSpace8(String str) {

        return 0;
    }


    public boolean myContains7(String s1, String s2){

        return false;
    }

    //Is sum 24?

    private boolean isSum24(int arr[], int targetSum) {
        if(arr.length == 1){
            if(arr[0]-targetSum == 0)
                return true;
            else
                return false;
        }
        if(arr.length == 0)
            return false;
        return isSum24(Arrays.copyOfRange(arr,1, arr.length), targetSum-arr[0]);
    }

    private boolean isSum242(int arr[], int targetSum) {

        return false;
    }

    private boolean isSum243(int arr[], int targetSum) {

        return false;
    }

    private boolean isSum244(int arr[], int targetSum) {

        return false;
    }

    private boolean isSum245(int arr[], int targetSum) {

        return false;
    }

    private boolean isSum246(int arr[], int targetSum) {

        return false;
    }



    public int countSpace9(String str) {

        return 0;
    }


    public boolean myContains8(String s1, String s2){

        return false;
    }

    public int div7(int m, int n) throws IllegalArgumentException {

        return 0;
    }

    //Reverse array

    private void reverseArray(int a[], int low, int high) {
        int temp;
        if(low >= high)
            return;
        temp = a[low];
        a[low] = a[high];
        a[high] = temp;
        reverseArray(a, low+1, high-1);

    }

    private void reverseArray2(int a[], int low, int high) {
    }

    private void reverseArray3(int a[], int low, int high) {
    }

    private void reverseArray4(int a[], int low, int high) {
    }

    private void reverseArray5(int a[], int low, int high) {
    }

    private void reverseArray6(int a[], int low, int high) {
    }




    public int countSpace10(String str) {

        return 0;
    }


    public boolean myContains9(String s1, String s2){

        return false;
    }

    public int div8(int m, int n) throws IllegalArgumentException {

        return 0;
    }

    private boolean isSum247(int arr[], int targetSum) {

        return false;
    }

    //Recursive selection sort

    private void recursiveSelectionSort(int a[], int low, int high) {
        int smallest = a[low];
        int y = smallest;
        int temp;
        int tracker = 0;
        if(low == high)
            return;
        for(int i = low; i<=high; i++){
            if(a[i]<smallest) {
                smallest = a[i];
                tracker = i;
            }
        }
        if(smallest<y) {
            temp = a[low];
            a[low] = smallest;
            a[tracker] = temp;
        }
        recursiveSelectionSort(a, low+1, high);
    }

    private void recursiveSelectionSort2(int a[], int low, int high) {

    }

    private void recursiveSelectionSort3(int a[], int low, int high) {

    }

    private void recursiveSelectionSort4(int a[], int low, int high) {

    }

    private void recursiveSelectionSort5(int a[], int low, int high) {

    }

    private void recursiveSelectionSort6(int a[], int low, int high) {

    }





    public int countSpace11(String str) {

        return 0;
    }


    public boolean myContains10(String s1, String s2){

        return false;
    }

    public int div9(int m, int n) throws IllegalArgumentException {

        return 0;
    }

    private boolean isSum248(int arr[], int targetSum) {

        return false;
    }

    private void recursiveSelectionSort7(int a[], int low, int high) {

    }

    //regular selection sort

    public static void selectionSort(String[] arr){
        int n = arr.length;

        for(int i=0; i<n-1; i++){
            int smallest = i;
            for(int j=i+1; j<n; j++){
                if(CharSequence.compare(arr[j], arr[smallest])<0){
                    smallest = j;
                }
            }
            String temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
    }

    public static void selectionSort2(String[] arr){

    }

    public static void selectionSort3(String[] arr){

    }

    public static void selectionSort4(String[] arr){

    }

    public static void selectionSort5(String[] arr){

    }

    public static void selectionSort6(String[] arr){

    }







    public int countSpace12(String str) {

        return 0;
    }


    public boolean myContains11(String s1, String s2){

        return false;
    }

    public int div10(int m, int n) throws IllegalArgumentException {

        return 0;
    }

    private boolean isSum249(int arr[], int targetSum) {

        return false;
    }

    private void recursiveSelectionSort8(int a[], int low, int high) {

    }

}
