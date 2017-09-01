import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MergeSort {
	
	private int p, q, r;
	
	public static void main(String[] args) {
		int[] in = new int[6];
		System.out.println("Enter the no of elements of input : ");
		Scanner inp = new Scanner(System.in);
		MergeSort obj = new MergeSort();
		obj.r = inp.nextInt();
		System.out.println("Enter the Element of list to be Sorted : ");
		for(int i= 0; i< obj.r; i++)
		{
			in[i] = (inp.nextInt());
		}
		
		obj.mergeSort(in, 0, obj.r-1);
		System.out.print("ms = ");
		for(int count = 0; count < in.length; count++)
		{
			System.out.print(" "+in[count]);
		}
		System.out.println("");
	}
	
	private void mergeSort(int[] a, int p, int q)
	{
		System.out.print("ms = ");
		for(int count = 0; count < a.length; count++)
		{
			System.out.print(" "+a[count]);
		}
		System.out.println("");
		int r = (p+q)/2;
		System.out.println("r = "+r);
		if(p < q)
		{
			mergeSort(a, p, r);
			mergeSort(a, r+1, q);
			merge(a, p, r, q);
		}
		
	}
	
	private void merge(int[] a, int p, int r, int q)
	{
		System.out.print("m ");
		for(int count = 0; count < a.length; count++)
		{
			System.out.print(" "+a[count]);
		}
		System.out.println("");
		int n1 = r-p+1;
		int n2 = q-r;
		System.out.println("n1 adn n2 = "+n1+n2);
		int[] left = new int[n1+1];
		int[] right = new int[n2+1];
		
		for(int i = 0; i < n1; i++)
		{
			left[i] = (a[i+p]);
			for(int count = 0; count < left.length; count++)
			{
				System.out.print("left "+left[count]);
			}
			System.out.println("");
		}
		for(int i = 0; i<n2; i++)
		{
			right[i] = (a[i+r+1]);
			for(int count = 0; count < right.length; count++)
			{
				System.out.print("right "+right[count]);
			}
			System.out.println("");
		}
		left[n1] = Integer.MAX_VALUE;
		right[n2] = Integer.MAX_VALUE;
		int i=0;
		int j = 0;
		for(int x = p; x<n1+n2; x++)
		{
			if(left[i] < right[j])
			{
				a[x] = left[i];
				i++;
			}
			else
			{
				a[x] = right[j];
				j++;
			}
		}
	}
 }
