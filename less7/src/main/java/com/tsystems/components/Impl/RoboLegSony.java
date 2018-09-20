package com.tsystems.components.Impl;

import com.tsystems.components.InjectRandomInt;
import com.tsystems.components.RoboLeg;

public class RoboLegSony implements RoboLeg {
    String[] pathToAim = {"Two steps forward, five steps left","Six steps forward, three steps right","Ten steps backward", "Seven steps forward, one left, forward, one step right"};
    @InjectRandomInt(min=0, max=3)
    private int pathNum;

    @Override
    public void Go(){
        System.out.println("Sony leg going... " + pathToAim[pathNum]);
    }
}
