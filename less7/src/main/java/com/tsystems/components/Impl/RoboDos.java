package com.tsystems.components.Impl;

import com.tsystems.components.*;

public class RoboDos implements Robo {

    private RoboHead head;
    private RoboLeg  leg;

    public RoboDos() {}

    public RoboDos (RoboHead head, RoboLeg leg) {
        this.head = head;
        this.leg = leg;
    }

    @Override
    public void Action() {
        head.Analize();
        leg.Go();
    }

    public RoboHead getHead() {
        return head;
    }

    public void setHead(RoboHead head) {
        this.head = head;
    }

    public RoboLeg getLeg() {
        return leg;
    }

    public void setLeg(RoboLeg leg) {
        this.leg = leg;
    }
}
