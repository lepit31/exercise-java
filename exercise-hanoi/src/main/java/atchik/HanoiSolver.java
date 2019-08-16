package atchik;

import java.util.ArrayList;

public class HanoiSolver {

    //dont override
    ArrayList<String> solve(HanoiPillar from, HanoiPillar to, int nbPieces) {
        ArrayList<String> result = new ArrayList();
        return solveRecursive(result, from, to, nbPieces);
    }

    //dont override
    static String move(HanoiPillar from, HanoiPillar to) {
        return String.format("Move %s to %s", from, to);
    }


    public ArrayList<String> solveRecursive(ArrayList<String> result, HanoiPillar from, HanoiPillar to, int size) {
        // TODO implement this method
        return result;
    }


    /*
    :-) you find a hint
     hanoi recursive algorithm can be found on wikipedia
     */
    public static HanoiPillar getIntermediate(HanoiPillar from, HanoiPillar to) {
        HanoiPillar intermediate = null;
        for (HanoiPillar pillar : HanoiPillar.values()) {
            if (!pillar.equals(from) && !pillar.equals(to)) {
                intermediate = pillar;
            }
        }
        return intermediate;
    }

}
