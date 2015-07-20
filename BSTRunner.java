import java.util.Random;
import java.util.Scanner;

public class BSTRunner {
	final static boolean TESTING = false;
	final static int LOOPS = 10;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		boolean working = true;
		while(working){
			System.out.print("Enter number of random values to add to binary search tree: ");
			int n = Integer.parseInt(input.next());
			System.out.println();
			
			int[]sizeArray = new int[LOOPS];
			int[]heightArray = new int[LOOPS];
			long[]timeArray = new long[LOOPS];


			for(int i = 0; i < LOOPS; i++){
				Random random = new Random();
				BinarySearchTree<Integer> testBST = new BinarySearchTree<Integer>();
				long initialTime = System.nanoTime();

				for(int j = 0; j < n; j++){
					testBST.add(random.nextInt());
				}

				long finalTime = System.nanoTime();
				if(TESTING){
					System.out.print("DATA FOR LOOP ");
					System.out.print(i + 1);
					System.out.println(" (PROBLEM SIZE " + n + ")");
					
					System.out.println("Size: " + testBST.size(testBST.root));
				}
				sizeArray[i] = testBST.size(testBST.root);

				if(TESTING){
					System.out.println("Height: " + testBST.height(testBST.root));
				}
				heightArray[i] = testBST.height(testBST.root);

				if(TESTING){
					System.out.print("Insertion Time: " + finalTime + " - " + initialTime + " = ");
					System.out.print(finalTime - initialTime);
					System.out.println(" nanoseconds\n");
				}
				timeArray[i] = finalTime - initialTime;
			}

			System.out.println("***** AVERAGE STATS FOR BINARY SEARCH TREE (PROBLEM SIZE " + n + ") *****");
			System.out.println("Average Size: " + average(sizeArray) + " nodes.");
			System.out.println("Average Height: " + average(heightArray) + ".");
			System.out.println("Average Insertion Time: " + average(timeArray) + " nanoseconds.");

			System.out.print("\nRun another a test? (Y/N)");

			String response = input.next();
			if(!response.equalsIgnoreCase("y")){
				working = false;
			}
		}

		input.close();
		System.out.println("\n***** FINISHED *****");
	}

	public static double average(int[] intArray){
		double sum = 0;
		for(int i = 0; i < intArray.length; i++){
			sum += intArray[i];
		}

		return sum / intArray.length;
	}

	public static long average(long[] longArray){
		long sum = 0;
		for(int i = 0; i < longArray.length; i++){
			sum += longArray[i];
		}

		return sum / longArray.length;
	}
}
