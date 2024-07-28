package com.travel.flight.pojo;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public int f25410a;

    /* renamed from: b  reason: collision with root package name */
    public NetworkCustomError f25411b;

    /* renamed from: c  reason: collision with root package name */
    private IJRPaytmDataModel f25412c;

    private /* synthetic */ a() {
        this(500, (IJRPaytmDataModel) null, (NetworkCustomError) null);
    }

    public a(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f25410a = i2;
        this.f25412c = iJRPaytmDataModel;
        this.f25411b = networkCustomError;
    }
}
