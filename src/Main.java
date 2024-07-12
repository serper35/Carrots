import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> gardens = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> carrotsInGardens = new ArrayList<>(Arrays.asList(50, 1, 3, 0, 0));
        System.out.println(harvest(carrotsInGardens, gardens));


    }

    public static int harvest(List<Integer> carrotsInGardens, List<Integer> gardens) {
        int attempts = 10;
        int maxWeight = 5;
        int totalWeight = 0;
        int gardenSize = gardens.size() - 1;

        while (attempts > 0) {
            int currentWeight = 0;
            for (int i = gardenSize; i >= 0; i--) {
                if (carrotsInGardens.get(i) > 0 && gardens.get(i) <= maxWeight - currentWeight) {
                    int possibleHarvest = Math.min(carrotsInGardens.get(i), (maxWeight - currentWeight) / gardens.get(i));
                    currentWeight += gardens.get(i) * possibleHarvest;
                    carrotsInGardens.set(i, carrotsInGardens.get(i) - possibleHarvest);
                    if (currentWeight == maxWeight) {
                        break;
                    }
                }
            }
            totalWeight += currentWeight;
            attempts--;
        }
        return totalWeight;
    }
}