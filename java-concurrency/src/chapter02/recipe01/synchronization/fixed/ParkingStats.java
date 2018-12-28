package chapter02.recipe01.synchronization.fixed;

public class ParkingStats {

  private final Object controlCars, controlMotorcybles;
  
  private long numberCars;
  private long numberMotorcycles;

  private ParkingCash cash;

  public ParkingStats(ParkingCash cash) {
    numberCars = 0;
    numberMotorcycles = 0;
    
    controlCars = new Object();
    controlMotorcybles = new Object();
    
    this.cash = cash;
  }

  public void carComeIn() {
    synchronized (controlCars) {
      numberCars++;
    }
  }

  public void carGoOut() {
    synchronized (controlCars) {
      numberCars--;
    }
    cash.vehiclePay();
  }

  public void motoComeIn() {
    synchronized (controlMotorcybles) {
      numberMotorcycles++;
    }
  }

  public void motoGoOut() {
    synchronized (controlMotorcybles) {
      numberMotorcycles--;
    }
    cash.vehiclePay();
  }

  public long getNumberCars() {
    return numberCars;
  }

  public long getNumberMotorcycles() {
    return numberMotorcycles;
  }

}
