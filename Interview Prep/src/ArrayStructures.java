/**
 * Watched Derek Banas video and followed along
 */
public class ArrayStructures {

    private int[] theArray = new int[50];

    private int arraySize = 10;

    public void generateRandomArray() {

        for(int i = 0; i < arraySize; i++) {
            theArray[i] = (int) (Math.random()*10) + 10;
        }
    }

    public void printArray() {
        System.out.println("--------");

        for(int i = 0; i < arraySize; i++) {
            System.out.print("| " + i + " | " );
            System.out.println(theArray[i] + " |");

            System.out.println("--------");
        }
    }

    public static void main(String[] args) {
        ArrayStructures newArray = new ArrayStructures();

        newArray.generateRandomArray();

        newArray.printArray();
    }

}