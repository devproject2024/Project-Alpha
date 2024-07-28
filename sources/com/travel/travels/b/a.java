package com.travel.travels.b;

import android.app.Activity;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.travel.widget.EditView;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRCatalog;
import net.one97.paytm.i.h;

public abstract class a extends h implements Response.ErrorListener, Response.Listener<IJRDataModel>, EditView.a {

    /* renamed from: b  reason: collision with root package name */
    protected CJRCatalog f28477b;

    public void onErrorResponse(VolleyError volleyError) {
    }

    public /* bridge */ /* synthetic */ void onResponse(Object obj) {
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getArguments() != null && getArguments().getSerializable("CACHED_CATALOG_DATA") != null) {
            this.f28477b = (CJRCatalog) getArguments().getSerializable("CACHED_CATALOG_DATA");
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onDestroyView() {
        super.onDestroyView();
    }
}
