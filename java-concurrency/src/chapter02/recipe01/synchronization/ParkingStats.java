package chapter02.recipe01.synchronization;

public class ParkingStats {

  private long numberCars;
  private long numberMotorcycles;

  private ParkingCash cash;

  public ParkingStats(ParkingCash cash) {
    numberCars = 0;
    numberMotorcycles = 0;
    this.cash = cash;
  }

  public void carComeIn() {
    numberCars++;
  }

  public void carGoOut() {
    numberCars--;
    cash.vehiclePay();
  }

  public void motoComeIn() {
    numberMotorcycles++;
  }

  public void motoGoOut() {
    numberMotorcycles--;
    cash.vehiclePay();
  }

  public long getNumberCars() {
    return numberCars;
  }

  public long getNumberMotorcycles() {
    return numberMotorcycles;
  }

}
