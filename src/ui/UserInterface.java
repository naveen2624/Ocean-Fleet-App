package ui;

import java.util.List;
import java.util.Scanner;

import model.Vessel;
import utils.Util;

public class UserInterface {

    private Util util = new Util();
    private Scanner sc = new Scanner(System.in);

    public void start() {

        System.out.print("Enter number of vessels: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter vessel details (id:name:speed:type):");
            String[] data = sc.nextLine().split(":");

            Vessel vessel = new Vessel(
                    data[0],
                    data[1],
                    Double.parseDouble(data[2]),
                    data[3]
            );

            util.addVesselPerformance(vessel);
        }

        System.out.print("\nEnter Vessel ID to search: ");
        String id = sc.nextLine();

        Vessel found = util.getVesselById(id);
        if (found != null) {
            displayVessel(found);
        } else {
            System.out.println("Vessel not found");
        }

        System.out.println("\nHigh Performance Vessels:");
        List<Vessel> top = util.getHighPerformanceVessels();
        for (Vessel v : top) {
            displayVessel(v);
        }
    }

    private void displayVessel(Vessel v) {
        System.out.println(
                v.getVesselId() + " | " +
                        v.getVesselName() + " | " +
                        v.getVesselType() + " | " +
                        v.getAverageSpeed() + " knots"
        );
    }
}

