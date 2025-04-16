import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CarRoute {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Города и расстояния между ними
        Map<String, Map<String, Integer>> distances = new HashMap<>();

        Map<String, Integer> tokyoRoutes = new HashMap<>();
        tokyoRoutes.put("大阪", 500);
        tokyoRoutes.put("京都", 450);

        Map<String, Integer> osakaRoutes = new HashMap<>();
        osakaRoutes.put("東京", 500);
        osakaRoutes.put("京都", 60);

        Map<String, Integer> kyotoRoutes = new HashMap<>();
        kyotoRoutes.put("東京", 450);
        kyotoRoutes.put("大阪", 60);

        distances.put("東京", tokyoRoutes);
        distances.put("大阪", osakaRoutes);
        distances.put("京都", kyotoRoutes);

        String[] cities = {"東京", "大阪", "京都"};

        System.out.println(" << CarRoute in Japan >> へようこそ！");
        System.out.println("出発地を選んでください：");

        for (int i = 0; i < cities.length; i++) {
            System.out.println((i + 1) + ". " + cities[i]);
        }

        System.out.print("選択肢：");
        int fromIndex = scanner.nextInt() - 1;

        System.out.println("目的地を選んでください：");

        for (int i = 0; i < cities.length; i++) {
            System.out.println((i + 1) + ". " + cities[i]);
        }

        System.out.print("選択肢：");
        int toIndex = scanner.nextInt() - 1;

        String fromCity = cities[fromIndex];
        String toCity = cities[toIndex];

        if (fromCity.equals(toCity)) {
            System.out.println("同じ都市を選びました。");
        } else {
            int distance = distances.get(fromCity).get(toCity);
            double time = (double) distance / 60; // Средняя скорость 60 км/ч

            System.out.println(fromCity + "から" + toCity + "までの距離：" + distance + "km");
            System.out.println("所要時間：" + String.format("%.2f", time) + "時間");

            System.out.print("燃費（100kmあたりのリットル）：");
            double fuelConsumption = scanner.nextDouble();

            double totalFuel = (fuelConsumption / 100) * distance;
            System.out.println("必要な燃料：" + String.format("%.2f", totalFuel) + "リットル");

            System.out.print("燃料の価格（1リットルあたり、円）：");
            double fuelPrice = scanner.nextDouble();

            double totalCost = totalFuel * fuelPrice;
            System.out.println("旅行の概算費用：" + String.format("%.0f", totalCost) + "円");
        }

        scanner.close();
    }
}
