class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }

        Arrays.sort(cars, Comparator.comparingInt(Car::position));

        int fleetsCount = 0;
        double fleetTimeToFinish = 0;
        for (int i = cars.length - 1; i >= 0; i--) {
            Car car = cars[i];
            double timeToFinish = car.needsTimeToFinish(target);

            if (timeToFinish > fleetTimeToFinish) {
                fleetsCount++;
                fleetTimeToFinish = timeToFinish;
            }
        }

        return fleetsCount;
    }

    private record Car(int position, int speed){
        private double needsTimeToFinish(int target) {
            int distance = target - position;
            return (distance) / (double)speed;
        }
    }
}
