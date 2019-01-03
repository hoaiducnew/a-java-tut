package chapter02.recipe01.synchronization.fixed;

public class Main {

  public static void main(String[] args) throws InterruptedException {

    ParkingCash cash = new ParkingCash();
    ParkingStats stats = new ParkingStats(cash);

    System.out.printf("Parking Simulator\n");
    int numberSensors = 2 * Runtime.getRuntime().availableProcessors();
    Thread threads[] = new Thread[numberSensors];
    for (int i = 0; i < numberSensors; i++) {
      Sensor sensor = new Sensor(stats);
      threads[i] = new Thread(sensor);
      threads[i].start();
    }

    for (int i = 0; i < numberSensors; i++) {
      threads[i].join();
    }

    System.out.printf("Number of cars: %d\n", stats.getNumberCars());
    System.out.printf("Number of motorcycles: %d\n", stats.getNumberMotorcycles());
    cash.close();
  }

}
