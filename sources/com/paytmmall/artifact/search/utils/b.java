package com.paytmmall.artifact.search.utils;

import android.content.Context;
import com.google.gsonhtcfix.c.a;
import com.paytmmall.artifact.grid.entity.CJRGridProduct;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import java.util.ArrayList;
import org.json.JSONArray;

public final class b extends a<CJRGridProduct> {

    /* renamed from: d  reason: collision with root package name */
    public static b f16018d;

    public b(Context context) {
        super(context, ViewHolderFactory.TYPE_RECENTLY_VIEWED, "productID");
    }

    public final ArrayList<CJRGridProduct> b() {
        JSONArray a2 = a();
        return (ArrayList) this.f16012c.a(String.valueOf(a2), new a<ArrayList<CJRGridProduct>>() {
        }.getType());
    }
}
