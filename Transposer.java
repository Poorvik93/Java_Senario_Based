////  *Question* 
////Indian Demographic Data Transposer

// // Develop a Java program capable of transposing demographic data of Indian cities, represented as a matrix. The first column of the matrix contains city names, while subsequent columns contain various demographic statistics (like population, area, density, etc.). Your program should transpose this matrix and apply a custom arithmetic operation to the transposed numeric elements, incrementing each by 1. The operation should not affect the city names.

// // Condition:

// // The program must transpose the matrix, swapping rows and columns.
// // For each numeric element in the transposed matrix, increment the value by 1.
// // The first column contains city names and should not be modified during transposition.
// // Note:

// // The numeric data in the matrix might be represented in various formats, including plain integers and strings with suffixes (e.g., "M" for millions). The program should correctly parse and modify these values.

// // Input Description:

// // The first line contains two integers representing the dimensions of the matrix: the number of rows and the number of columns.
// // The following lines contain the data for each row of the matrix. Each row starts with a city name (a string), followed by demographic data (which could be integers or strings representing numbers, possibly with suffixes like "M" for millions).
// // The data in each row is space-separated.
// // General Output Description:


// // The output is the transposed version of the input matrix with each numeric element incremented by 1.
// // The first row of the output contains the city names, transposed from the first column of the input.
// // The subsequent rows contain the demographic data, which has been incremented. For numeric data represented with a suffix (like "M"), the increment is applied to the numeric part, keeping the suffix unchanged.
// // Each row of the output is printed on a new line, with its elements space-separated.

// // Examples:

// // Input: 
// // 2 
// // 3
// // Kolkata 15M 205
// // Pune 7M 331
// // Output: 
// // Transposed and Modified Matrix:
// // Kolkata Pune 
// // 16.0M 8.0M 
// // 206 332


// // Input: 
// // 3 
// // 2
// // Mumbai 20M
// // Delhi 18M
// // Kolkata 15M
// // Output: 
// // Transposed and Modified Matrix:
// // Mumbai Delhi Kolkata 
// // 21.0M 19.0M 16.0M




import java.util.Scanner;



public class Main {



  public static String[][] transposeAndModifyData(String[][] dataMatrix) {

    if (dataMatrix == null || dataMatrix.length == 0) {

      return new String[0][0];

    }



    String[][] transposedMatrix = new String[dataMatrix[0].length][dataMatrix.length];



    for (int i = 0; i < dataMatrix.length; i++) {

      for (int j = 0; j < dataMatrix[i].length; j++) {

        transposedMatrix[j][i] = modifyElement(dataMatrix[i][j], j != 0); // Only modify if it's not the first column

      }

    }



    return transposedMatrix;

  }



  private static String modifyElement(String element, boolean isNumeric) {

    if (!isNumeric) {

      return element;

    }



    try {

      // Assuming numeric data is in millions "M" or as plain numbers

      if (element.endsWith("M")) {

        double value = Double.parseDouble(element.substring(0, element.length() - 1));

        return String.format("%.1fM", value + 1);

      } else {

        int value = Integer.parseInt(element);

        return Integer.toString(value + 1);

      }

    } catch (NumberFormatException e) {

      return element; // Return the original element if it's not a valid number

    }

  }



  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

     

    int rows = scanner.nextInt();

    scanner.nextLine(); // Consume newline



     

    int cols = scanner.nextInt();

    scanner.nextLine(); // Consume newline



    String[][] dataMatrix = new String[rows][cols];

    

    for (int i = 0; i < rows; i++) {

      for (int j = 0; j < cols; j++) {

        dataMatrix[i][j] = scanner.next();

      }

    }



    String[][] transposed = transposeAndModifyData(dataMatrix);



    System.out.println("Transposed and Modified Matrix:");

    for (String[] row : transposed) {

      for (String element : row) {

        System.out.print(element + " ");

      }

      System.out.println();

    }

  }

}
