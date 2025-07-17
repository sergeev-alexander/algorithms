package sergeev.alexander.leetcode;

// 1603. Design Parking System
public class a1603 {

    class ParkingSystem {

        private int big;
        private int medium;
        private int small;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            return switch (carType) {
                case 1 -> --big >= 0;
                case 2 -> --medium >= 0;
                case 3 -> --small >= 0;
                default -> false;
            };
        }
    }
}
