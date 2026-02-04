import model.Vessel;

import model.Vessel;
import utils.Util;

public class Main {
    public static void main(String[] args) {

        Util util = new Util();

        Vessel v1 = new Vessel("V201", "Sea Hawk", 24.5, "Cargo");
        Vessel v2 = new Vessel("V202", "Ocean Pearl", 30.0, "Cruise");

        util.addVesselPerformance(v1);
        util.addVesselPerformance(v2);

        for (Vessel v : util.getVesselList()) {
            System.out.println(
                    v.getVesselId() + " - " +
                            v.getVesselName() + " - " +
                            v.getAverageSpeed()
            );
        }

        Vessel result = util.getVesselById("V201");

        if (result != null) {
            System.out.println("Vessel Found: " + result.getVesselName());
        } else {
            System.out.println("Vessel not found");
        }
    }
}
