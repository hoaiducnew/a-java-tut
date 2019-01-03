package chapter02.recipe01.synchronization;

public class ParkingCash {

  private static final int cost = 2;

  private long cash;

  public ParkingCash() {
    cash = 0;
  }

  public void vehiclePay() {
    cash += cost;
  }

  public void close() {
    System.out.printf("Closing accounting. ");
    long totalAmount;
    totalAmount = cash;
    cash = 0;
    System.out.printf("The total ammount is : %d", totalAmount);
  }
}
