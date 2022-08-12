import java.awt.*;
import java.io.*;
import java.util.*;

public class Solution {

  // Add constants for particle types here.
  public static final int EMPTY = 0;
  public static final int METAL = 1;
  public static final int SAND = 2;
  public static final int WATER = 3;
  public static final String[] NAMES = { "Empty", "Metal", "Sand", "Water" };

  // Do not add any more fields as part of Lab 5.
  private int[][] grid;
  private SandDisplayInterface display;
  private RandomGenerator random;

  /**
   * Constructor.
   *
   * @param display The display to use for this run
   * @param random  The random number generator to use to pick random points
   */
  public Solution(SandDisplayInterface display, RandomGenerator random) {
    this.display = display;
    this.random = random;
    grid = new int[display.getNumRows()][display.getNumColumns()];
    for (int i = 0; i < grid.length; i++) {
      for (int a = 0; a < grid[i].length; a++) {
        grid[i][a] = 0;
      }
    }
  }

  /**
   * Called when the user clicks on a location.
   *
   * @param row
   * @param col
   * @param tool
   */
  private void locationClicked(int row, int col, int tool) {
    // TODO: Populate this method in step 3.
    // grid update for every user click
    grid[row][col] = tool;
  }

  /** Copies each element of grid into the display. */
  public void updateDisplay() {
    // TODO Implement color variations within a material:
    // not all sand grains are the same tone of yellow.
    // Add support for random color variation in the sand that you pour.
    // Ensure that a grain's color stays the same once it is poured.
    for (int i = 0; i < grid.length; i++) {
      for (int a = 0; a < grid[i].length; a++) {
        if (grid[i][a] == 0) {
          display.setColor(i, a, Color.BLACK);
        } else if (grid[i][a] == 1) {
          display.setColor(i, a, Color.LIGHT_GRAY);
        } else if (grid[i][a] == 2) {
          display.setColor(i, a, Color.YELLOW);
        } else if (grid[i][a] == 3) {
          display.setColor(i, a, Color.CYAN);
        }
      }
    }
  }

  /** Called repeatedly. Causes one random particle to maybe do something. */
  public void step() {
    // TODO: Populate this method in step 6 and beyond.
    // Select grid point
    Point selectedPoint = random.getRandomPoint();
    int selectedRow = selectedPoint.row;
    int selectedCol = selectedPoint.column;
    int col = display.getNumColumns() - 1;
    int row = display.getNumRows() - 1;
    // Shift sand: if space below sand is free, move the sand down until it fills a
    // space
    if (grid[selectedRow][selectedCol] == 2 && selectedRow < row && grid[selectedRow + 1][selectedCol] == 0) {
      // Update grid
      grid[selectedRow][selectedCol] = 0;
      grid[selectedRow + 1][selectedCol] = 2;
    }
    // Sand shifting through water: Selected sand will shift to the bottom of the
    // water
    else if (grid[selectedRow][selectedCol] == 2 && selectedRow < row && grid[selectedRow + 1][selectedCol] == 3) {
      // Update grid
      grid[selectedRow][selectedCol] = 3;
      grid[selectedRow + 1][selectedCol] = 2;
    }
    // Sand down movement if sand is below: If the particle is sand and sand
    // is below, move in a random direction thais free

    // Shift Water: Water particle will move to the first available space
    else if (grid[selectedRow][selectedCol] == 3) {
      // Find an open space for water
      int randomDir = random.getRandomDirection();
      if ((selectedRow == row && randomDir == 0)
          || (selectedCol == col && randomDir == 1)
          || (selectedCol == 0 && randomDir == 2)) {
      }
      // Water particle will move in random direction of user click
      else if (randomDir == 0 && grid[selectedRow + 1][selectedCol] == 0) {
        grid[selectedRow][selectedCol] = 0;
        grid[selectedRow + 1][selectedCol] = 3;
      } else if (randomDir == 1 && grid[selectedRow][selectedCol + 1] == 0) {
        grid[selectedRow][selectedCol] = 0;
        grid[selectedRow][selectedCol + 1] = 3;
      } else if (randomDir == 2 && grid[selectedRow][selectedCol - 1] == 0) {
        grid[selectedRow][selectedCol] = 0;
        grid[selectedRow][selectedCol - 1] = 3;
      }
    }
  }

  /********************************************************************/
  /********************************************************************/
  /**
   * DO NOT MODIFY
   *
   * <p>
   * The rest of this file is UI and testing infrastructure. Do not modify as part
   * of pre-GDA Lab
   * 5.
   */
  /********************************************************************/
  /********************************************************************/

  private static class Point {
    private int row;
    private int column;

    public Point(int row, int column) {
      this.row = row;
      this.column = column;
    }

    public int getRow() {
      return row;
    }

    public int getColumn() {
      return column;
    }
  }

  /**
   * Special random number generating class to help get consistent results for
   * testing.
   *
   * <p>
   * Please use getRandomPoint to get an arbitrary point on the grid to evaluate.
   *
   * <p>
   * When dealing with water, please use getRandomDirection.
   */
  public static class RandomGenerator {
    private static Random randomNumberGeneratorForPoints;
    private static Random randomNumberGeneratorForDirections;
    private int numRows;
    private int numCols;

    public RandomGenerator(int seed, int numRows, int numCols) {
      randomNumberGeneratorForPoints = new Random(seed);
      randomNumberGeneratorForDirections = new Random(seed);
      this.numRows = numRows;
      this.numCols = numCols;
    }

    public RandomGenerator(int numRows, int numCols) {
      randomNumberGeneratorForPoints = new Random();
      randomNumberGeneratorForDirections = new Random();
      this.numRows = numRows;
      this.numCols = numCols;
    }

    public Point getRandomPoint() {
      return new Point(
          randomNumberGeneratorForPoints.nextInt(numRows),
          randomNumberGeneratorForPoints.nextInt(numCols));
    }

    /**
     * Method that returns a random direction.
     *
     * @return an int indicating the direction of movement: 0: Indicating the water
     *         should attempt
     *         to move down 1: Indicating the water should attempt to move right 2:
     *         Indicating the water
     *         should attempt to move left
     */
    public int getRandomDirection() {
      return randomNumberGeneratorForDirections.nextInt(3);
    }
  }

  public static void main(String[] args) {
    // Test mode, read the input, run the simulation and print the result
    Scanner in = new Scanner(System.in);
    int numRows = in.nextInt();
    int numCols = in.nextInt();
    int iterations = in.nextInt();
    Solution lab = new Solution(new NullDisplay(numRows, numCols), new RandomGenerator(0, numRows, numCols));
    lab.readGridValues(in);
    lab.runNTimes(iterations);
    lab.printGrid();
  }

  /**
   * Read a grid set up from the input scanner.
   *
   * @param in
   */
  private void readGridValues(Scanner in) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        grid[i][j] = in.nextInt();
      }
    }
  }

  /** Output the current status of the grid for testing purposes. */
  private void printGrid() {
    for (int i = 0; i < grid.length; i++) {
      System.out.println(Arrays.toString(grid[i]));
    }
  }

  /** Runner that advances the display a determinate number of times. */
  private void runNTimes(int times) {
    for (int i = 0; i < times; i++) {
      runOneTime();
    }
  }

  /** Runner that controls the window until it is closed. */
  public void run() {
    while (true) {
      runOneTime();
    }
  }

  /**
   * Runs one iteration of the display. Note that one iteration may call step
   * repeatedly depending
   * on the speed of the UI.
   */
  private void runOneTime() {
    for (int i = 0; i < display.getSpeed(); i++) {
      step();
    }
    updateDisplay();
    display.repaint();
    display.pause(1); // Wait for redrawing and for mouse
    int[] mouseLoc = display.getMouseLocation();
    if (mouseLoc != null) { // Test if mouse clicked
      locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
    }
  }

  /**
   * An implementation of the SandDisplayInterface that doesn't display anything.
   * Used for testing.
   */
  static class NullDisplay implements SandDisplayInterface {
    private int numRows;
    private int numCols;

    public NullDisplay(int numRows, int numCols) {
      this.numRows = numRows;
      this.numCols = numCols;
    }

    public void pause(int milliseconds) {
    }

    public int getNumRows() {
      return numRows;
    }

    public int getNumColumns() {
      return numCols;
    }

    public int[] getMouseLocation() {
      return null;
    }

    public int getTool() {
      return 0;
    }

    public void setColor(int row, int col, Color color) {
    }

    public int getSpeed() {
      return 1;
    }

    public void repaint() {
    }
  }

  /** Interface for the UI of the SandLab. */
  public interface SandDisplayInterface {
    public void repaint();

    public void pause(int milliseconds);

    public int[] getMouseLocation();

    public int getNumRows();

    public int getNumColumns();

    public void setColor(int row, int col, Color color);

    public int getSpeed();

    public int getTool();
  }
}
