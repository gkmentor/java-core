package org.hagiakinh.design_pattern.structural.adapter;

import org.hagiakinh.design_pattern.structural.adapter.roud.RoundHole;
import org.hagiakinh.design_pattern.structural.adapter.roud.RoundPeg;
import org.hagiakinh.design_pattern.structural.adapter.square.SquarePeg;
import org.hagiakinh.design_pattern.structural.adapter.square.SquarePegAdapter;

public class Demo {
    public static void main(String[] args) {
        // Round fits round, no surprise.
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);
        if (hole.fits(rpeg)) {
            System.out.println("Chốt tròn r5 vừa với lỗ tròn r5.");
        }

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);
        // hole.fits(smallSqPeg); // Won't compile.

        // Adapter solves the problem.
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        if (hole.fits(smallSqPegAdapter)) {
            System.out.println("Chốt vuông w2 vừa lỗ tròn r5");
        }

        if (!hole.fits(largeSqPegAdapter)) {
            System.out.println("Chốt vuông w20 không vừa với lỗ tròn r5.");
        }
    }
}
