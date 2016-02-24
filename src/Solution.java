import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        Integer T = in.nextInt();

        while(T-- > 0){
            Integer N = in.nextInt();
            Integer input[] = new Integer[N];
            for(int i=0;i<N;i++){
                input[i] = in.nextInt();
            }

            if(checkBST(N,input)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    private static boolean checkBST(Integer N,Integer input[]){
        if(input == null){
            return true;
        }
        if(N.equals(0) || N.equals(1)){
            return true;
        }
        Integer root =  input[0];
        Integer leftSubTree[]  =  getLHS(input, N);
        Integer rightSubTree[] =  getRHS(input, N);

        if(!checkRHSforElementsGreaterThanRoot(root,rightSubTree)){
            return false;
        }
        boolean lhsCheck = ((leftSubTree == null)? true : checkBST(leftSubTree.length, leftSubTree));
        boolean rhsCheck = ((rightSubTree == null)? true: checkBST(rightSubTree.length, rightSubTree));
        return lhsCheck && rhsCheck;
    }

    private static boolean checkRHSforElementsGreaterThanRoot(Integer root,Integer[] subTree){
        if(null == subTree){
            return true;
        }
        for(int i=0;i<subTree.length;i++){
            if(subTree[i].compareTo(root) < 0){
                return false;
            }
        }
        return true;
    }
    private static Integer[] getLHS(Integer input[], Integer N){
        if(N.equals(1)){
            return null;
        }
        Integer root = input[0];
        Integer len = 0;
        int i;

        for(i = 1;i<N;i++){
            if(input[i].compareTo(root) >= 0){
                break;
            }
        }

        if(i == 1){
            return null;
        }

        Integer lhs[] = new Integer[i-1];
        for(int j=1,k=0; j <= i-1; j++,k++){
            lhs[k] = new Integer(input[j]);
        }

        return lhs;
    }

    private static Integer[] getRHS(Integer input[], Integer N){
        Integer root = input[0];
        Integer len = 0;
        Integer i;
        for(i = 1;i<N;i++){
            if(input[i].compareTo(root) >= 0){
                break;
            }
        }

        if(i.equals(N)){
            return null;
        }

        Integer rhs[] = new Integer[N - i];
        for(int j=i,k=0;j< N ;j++,k++){
            rhs[k] = input[j];
        }

        return rhs;
    }

}

//Given a list of numbers, determine whether they can represent the pre-order traversal list of a binary search tree (BST).
