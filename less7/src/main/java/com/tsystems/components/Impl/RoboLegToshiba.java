package com.tsystems.components.Impl;

import com.tsystems.components.InjectRandomInt;
import com.tsystems.components.RoboLeg;

public class RoboLegToshiba implements RoboLeg {
    String[] pathToAim = {"Steps forward... broken","Step right... broken","Step backward... run", "Stop"};
    @InjectRandomInt(min=0, max=3)
    private int pathNum;

    @Override
    public void Go(){
        System.out.println("Toshiba leg going... " + pathToAim[pathNum]);
    }
}
