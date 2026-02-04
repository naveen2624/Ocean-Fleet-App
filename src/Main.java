import java.util.List;
import java.util.Scanner;

import model.Vessel;
import utils.Util;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Util util = new Util();

        // Step 1: Number of vessels
        System.out.print("Enter number of vessels: ");
        int n = Integer.parseInt(sc.nextLine());

        // Step 2–4: Read vessel details and store
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter vessel " + i + " details (id:name:speed:type):");
            String input = sc.nextLine();

            // Step 3: Parse input
            String[] parts = input.split(":");

            String vesselId = parts[0];
            String vesselName = parts[1];
            double averageSpeed = Double.parseDouble(parts[2]);
            String vesselType = parts[3];

            // Step 4: Create object
            Vessel vessel = new Vessel(
                    vesselId,
                    vesselName,
                    averageSpeed,
                    vesselType
            );

            // Delegate storage to Util
            util.addVesselPerformance(vessel);
        }

        // Step 5: Retrieve vessel by ID
        System.out.print("\nEnter Vessel ID to search: ");
        String searchId = sc.nextLine();

        Vessel found = util.getVesselById(searchId);

        if (found != null) {
            System.out.println("Vessel Found:");
            printVessel(found);
        } else {
            System.out.println("Vessel not found");
        }

        // Step 6: Display high-performance vessels
        System.out.println("\nHigh Performance Vessels:");
        List<Vessel> highPerf = util.getHighPerformanceVessels();

        if (highPerf.isEmpty()) {
            System.out.println("No vessel data available");
        } else {
            for (Vessel v : highPerf) {
                printVessel(v);
            }
        }

        sc.close();
    }

    // Utility method to display vessel in required format
    private static void printVessel(Vessel v) {
        System.out.println(
                v.getVesselId() + " | " +
                        v.getVesselName() + " | " +
                        v.getVesselType() + " | " +
                        v.getAverageSpeed() + " knots"
        );
    }
}
