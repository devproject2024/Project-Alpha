package net.one97.paytm.common.entity.quick_pay;

import java.util.ArrayList;

public class Payload {
    private ArrayList<StandingInstructionList> standingInstructionList;

    public ArrayList<StandingInstructionList> getStandingInstructionList() {
        return this.standingInstructionList;
    }

    public void setStandingInstructionList(ArrayList<StandingInstructionList> arrayList) {
        this.standingInstructionList = arrayList;
    }

    public String toString() {
        return "ClassPojo [standingInstructionList = " + this.standingInstructionList + "]";
    }
}
