package com.paytmmall.artifact.clp.c;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.android.volley.VolleyError;
import com.google.gson.f;
import com.google.gson.o;
import com.paytmmall.clpartifact.common.RedirectorModel;
import com.paytmmall.clpartifact.ga.GAJobModel;
import com.paytmmall.clpartifact.modal.clpCommon.CLPNetworkResponse;
import com.paytmmall.clpartifact.modal.clpCommon.CLPResponse;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.network.CLPNetworkService;
import com.paytmmall.clpartifact.repositories.CLPRepository;
import com.paytmmall.clpartifact.utils.LogUtils;
import java.util.LinkedList;
import java.util.Queue;

public class a extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public y<CLPNetworkResponse> f15614a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f15615b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f15616c;

    /* renamed from: d  reason: collision with root package name */
    public y<RedirectorModel> f15617d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public View f15618e;

    /* renamed from: f  reason: collision with root package name */
    public String f15619f;

    /* renamed from: g  reason: collision with root package name */
    public Queue<GAJobModel> f15620g = new LinkedList();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final String f15621h = a.class.getSimpleName();

    /* renamed from: i  reason: collision with root package name */
    private CLPRepository f15622i = new CLPRepository();

    public a(Application application) {
        super(application);
    }

    public final LiveData<CLPNetworkResponse> a(String str) {
        this.f15614a = new y<>();
        this.f15616c = true;
        this.f15622i.loadInitial(str, new CLPNetworkService.IResponseListener() {
            public final void onSuccess(String str, o oVar) {
                boolean unused = a.this.f15616c = false;
                try {
                    a.this.f15614a.setValue((CLPResponse) new f().a(str, CLPResponse.class));
                } catch (Exception e2) {
                    LogUtils.e(a.this.f15621h, "onSuccess:", e2);
                    a.this.f15614a.setValue(new CLPNetworkResponse(new VolleyError(e2.getMessage())));
                }
            }

            public final void onError(VolleyError volleyError) {
                boolean unused = a.this.f15616c = false;
                a.this.f15614a.setValue(new CLPNetworkResponse(volleyError));
            }
        });
        return this.f15614a;
    }

    public final void a(boolean z) {
        this.f15615b = this.f15615b || z;
    }

    public final void a() {
        this.f15617d.setValue(new RedirectorModel(1008));
    }

    public final void a(CLPResponse cLPResponse) {
        this.f15619f = (cLPResponse == null || cLPResponse.getGaKey() == null) ? this.f15619f : cLPResponse.getGaKey();
    }
}
