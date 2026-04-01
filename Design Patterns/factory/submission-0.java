interface Vehicle {
    String getType();
}

class Car implements Vehicle {
    @Override
    public String getType() {
        return "Car";
    }
}

class Bike implements Vehicle {
    @Override
    public String getType() {
        return "Bike";
    }
}

class Truck implements Vehicle {
    @Override
    public String getType() {
        return "Truck";
    }
}

abstract class VehicleFactory {
    abstract Vehicle createVehicle();
}

class CarFactory extends VehicleFactory {
    public CarFactory(){
        super();
    }

    @Override
    public Vehicle createVehicle(){
        return new Car();
    }
}

class BikeFactory extends VehicleFactory {
    public BikeFactory(){
        super();
    }

    @Override
    public Vehicle createVehicle(){
        return new Bike();
    }
}

class TruckFactory extends VehicleFactory {
    public TruckFactory(){
        super();
    }

    @Override
    public Vehicle createVehicle(){
        return new Truck();
    }
}
