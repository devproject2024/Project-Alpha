package com.travel.bus.pojo.common.entity;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusCommentBody implements IJRDataModel {
    @b(a = "comments")
    ArrayList<BusCJRBusComment> busComments = new ArrayList<>();

    public ArrayList<BusCJRBusComment> getBusComments() {
        return this.busComments;
    }
}
