package net.one97.paytm.recharge.common.widget;

import android.view.View;
import com.paytm.contactsSdk.database.Tables;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.h;
import net.one97.paytm.recharge.common.widget.CJRBaseHeaderListLayoutV8;
import net.one97.paytm.recharge.model.ContactItemModel;

public final class CJRContactListV8 extends CJRBaseHeaderListLayoutV8 {

    /* renamed from: e  reason: collision with root package name */
    private final a f61859e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f61860f;

    public final View b(int i2) {
        if (this.f61860f == null) {
            this.f61860f = new HashMap();
        }
        View view = (View) this.f61860f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f61860f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final a getOptions() {
        return this.f61859e;
    }

    public final int getShimmerLayoutId() {
        return R.layout.content_shimmer_contact_item_v8;
    }

    public static final class a extends CJRBaseHeaderListLayoutV8.a {

        /* renamed from: b  reason: collision with root package name */
        public List<? extends ContactItemModel> f61861b;

        /* renamed from: c  reason: collision with root package name */
        public h.c f61862c;

        /* renamed from: d  reason: collision with root package name */
        private String f61863d;

        public final a a(String str) {
            k.c(str, "title");
            this.f61863d = str;
            return this;
        }

        public final a a(List<? extends ContactItemModel> list) {
            k.c(list, Tables.CONTACTS);
            this.f61861b = list;
            return this;
        }
    }
}
