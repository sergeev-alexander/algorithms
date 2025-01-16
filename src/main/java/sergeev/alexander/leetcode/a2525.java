package sergeev.alexander.leetcode;

// 2525. Categorize Box According to Criteria
public class a2525 {

    /*
    Given four integers length, width, height, and mass, representing the dimensions and mass of a box, respectively,
    return a string representing the category of the box.
    The box is "Bulky" if:
    Any of the dimensions of the box is greater or equal to 104.
    Or, the volume of the box is greater or equal to 109.
    If the mass of the box is greater or equal to 100, it is "Heavy".
    If the box is both "Bulky" and "Heavy", then its category is "Both".
    If the box is neither "Bulky" nor "Heavy", then its category is "Neither".
    If the box is "Bulky" but not "Heavy", then its category is "Bulky".
    If the box is "Heavy" but not "Bulky", then its category is "Heavy".
    Note that the volume of the box is the product of its length, width and height.
     */

    public static void main(String[] args) {
        int length = 200, width = 50, height = 800, mass = 50;
        System.out.println(categorizeBox(length, width, height, mass));
    }

    // BEATS 100%
    public static String categorizeBox(int length, int width, int height, int mass) {
        int dimensionThreshold = (int) Math.pow(10, 4);
        int volumeThreshold = (int) Math.pow(10, 9);
        int massThreshold = 100;
        boolean bulky = (length >= dimensionThreshold || width >= dimensionThreshold || height >= dimensionThreshold)
                || (long) length * width * height >= volumeThreshold;
        boolean heavy = mass >= massThreshold;
        if (bulky & !heavy) return "Bulky";
        else if (!bulky & heavy) return "Heavy";
        else if (bulky & heavy) return "Both";
        else return "Neither";
    }
}