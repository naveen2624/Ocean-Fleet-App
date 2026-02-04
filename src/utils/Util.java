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
    public Vessel getVesselById(String vesselId) {

        for (Vessel vessel : vesselList) {
            if (vessel.getVesselId().equals(vesselId)) {
                return vessel;   // Vessel found
            }
        }

        return null;  // Vessel not found
    }

}
