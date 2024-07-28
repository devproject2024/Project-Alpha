package com.travel.train.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import com.travel.train.R;
import com.travel.train.b;
import com.travel.train.i.ac;
import com.travel.train.i.m;
import com.travel.train.i.w;
import com.travel.train.viewholder.bj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class y extends RecyclerView.a<bj> implements m {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<? extends IJRDataModel> f26578a;

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f26579b;

    /* renamed from: c  reason: collision with root package name */
    private Context f26580c;

    /* renamed from: d  reason: collision with root package name */
    private w f26581d;

    /* renamed from: e  reason: collision with root package name */
    private int f26582e = 0;

    /* renamed from: f  reason: collision with root package name */
    private String f26583f;

    /* renamed from: g  reason: collision with root package name */
    private ac f26584g;

    /* renamed from: h  reason: collision with root package name */
    private String f26585h = "CJRTrainCityRecentPopularAdapter";

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ((bj) vVar).a((IJRDataModel) this.f26578a.get(i2), i2, this.f26578a.size());
    }

    public y(Context context, ArrayList<? extends IJRDataModel> arrayList, int i2, String str, ac acVar) {
        this.f26578a = arrayList;
        this.f26580c = context;
        this.f26582e = i2;
        this.f26579b = (LayoutInflater) this.f26580c.getSystemService("layout_inflater");
        this.f26583f = str;
        this.f26584g = acVar;
    }

    public final void a(w wVar) {
        if (wVar instanceof w) {
            this.f26581d = wVar;
        }
    }

    public final int getItemCount() {
        return this.f26578a.size();
    }

    public final void a() {
        for (int i2 = 0; i2 <= this.f26582e; i2++) {
            this.f26578a.remove(0);
            notifyItemRemoved(0);
        }
    }

    public final void a(String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("train_orig_dest_field_name", (this.f26583f == null || !this.f26583f.equalsIgnoreCase("source")) ? "destination" : "origin");
            if (str2 != null && !TextUtils.isEmpty(str2)) {
                hashMap.put("train_user_id", str2);
            }
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains");
            b.a();
            b.b().a(str, (Map<String, Object>) hashMap, this.f26580c);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    public final void a(String str, String str2, int i2, String str3) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("user_id", com.paytm.utility.b.n(this.f26580c) != null ? com.paytm.utility.b.n(this.f26580c) : "");
            hashMap.put(d.dL, str2);
            hashMap.put(d.dM, Integer.valueOf(i2));
            if (str3 == null || TextUtils.isEmpty(str3)) {
                hashMap.put(d.dN, "");
            } else {
                String str4 = d.dN;
                hashMap.put(str4, str3 + "Kms");
            }
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains");
            b.a();
            b.b().a(str, (Map<String, Object>) hashMap, this.f26580c);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new bj(this.f26580c, this.f26579b.inflate(R.layout.pre_t_recet_popular_train_city_item, viewGroup, false), this.f26582e, this.f26581d, this, this.f26584g);
    }
}
