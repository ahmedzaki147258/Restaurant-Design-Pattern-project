package com.example.restrant;

public class BranchesFactory {

    public ResturantBranches getBranch(String Name) {
        if (Name == null) {
            return null;
        }
        if (Name.equalsIgnoreCase("Almaza City Center")) {
            return new AlmazaCityCenter();
        } else if (Name.equalsIgnoreCase("Cairo Festival City")) {
            return new CairoFestivalCity();
        } else if (Name.equalsIgnoreCase("River Walk")) {
            return new RiverWalk();
        } else if (Name.equalsIgnoreCase("Heliopolis")) {
            return new Heliopolis();
        } else if (Name.equalsIgnoreCase("Arkan Plaza")) {
            return new ArkanPlaza();
        } else if (Name.equalsIgnoreCase("Madinaty Open Air Mall")) {
            return new MadinatyOpenAirMall();
        }
        return null;
    }
}
