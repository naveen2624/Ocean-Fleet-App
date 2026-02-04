package utils;

import java.util.ArrayList;
import java.util.List;
import model.Vessel;

public class Util {

    private List<Vessel> vesselList;

    // Constructor
    public Util() {
        vesselList = new ArrayList<>();
    }

    // Add vessel to list
    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }

    // Getter for vessel list
    public List<Vessel> getVesselList() {
        return vesselList;
    }

    // UC3: Retrieve Vessel by ID
    public Vessel getVesselById(String vesselId) {

        for (Vessel vessel : vesselList) {
            if (vessel.getVesselId().equals(vesselId)) {
                return vessel;
            }
        }

        return null;
    }

    // UC4: Identify High-Performance Vessels
    public List<Vessel> getHighPerformanceVessels() {

        List<Vessel> result = new ArrayList<>();

        if (vesselList.isEmpty()) {
            return result;
        }

        // Step 1: Find maximum speed
        double maxSpeed = vesselList.get(0).getAverageSpeed();

        for (Vessel vessel : vesselList) {
            if (vessel.getAverageSpeed() > maxSpeed) {
                maxSpeed = vessel.getAverageSpeed();
            }
        }

        // Step 2: Collect all vessels with max speed
        for (Vessel vessel : vesselList) {
            if (vessel.getAverageSpeed() == maxSpeed) {
                result.add(vessel);
            }
        }

        return result;
    }
}
