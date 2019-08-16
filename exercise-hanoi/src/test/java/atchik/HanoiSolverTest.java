package atchik;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


public class HanoiSolverTest {

    HanoiSolver hs = null;

    @Before
    public void init() {
        hs = new HanoiSolver();
    }

    @Test
    public void solve_A_to_B_NbPieces_1() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add(HanoiSolver.move(HanoiPillar.A, HanoiPillar.B));

        System.out.println("solve_A_to_B_NbPieces_1");
        System.out.println(expected);

        Assert.assertEquals("Order must be respected ", expected, hs.solve(HanoiPillar.A, HanoiPillar.B, 1));
    }

    @Test
    public void solve_C_to_A_NbPieces_3() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add(HanoiSolver.move(HanoiPillar.C, HanoiPillar.A));
        expected.add(HanoiSolver.move(HanoiPillar.C, HanoiPillar.B));
        expected.add(HanoiSolver.move(HanoiPillar.A, HanoiPillar.B));
        expected.add(HanoiSolver.move(HanoiPillar.C, HanoiPillar.A));
        expected.add(HanoiSolver.move(HanoiPillar.B, HanoiPillar.C));
        expected.add(HanoiSolver.move(HanoiPillar.B, HanoiPillar.A));
        expected.add(HanoiSolver.move(HanoiPillar.C, HanoiPillar.A));

        System.out.println("solve_C_to_A_NbPieces_3");
        System.out.println(expected);

        Assert.assertEquals("Order must be respected ", expected, hs.solve(HanoiPillar.C, HanoiPillar.A, 3));
    }

    //TODO Add Test Nbpiece 3 but different order
    //TODO Add Exception Tests


}