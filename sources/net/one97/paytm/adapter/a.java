package net.one97.paytm.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.paytm.utility.b.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.flightticket.CJROffersDetails;
import net.one97.paytm.paytm_finance.R;

public final class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f52301a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f52302b;

    /* renamed from: c  reason: collision with root package name */
    private CJROffersDetails f52303c;

    /* renamed from: d  reason: collision with root package name */
    private String f52304d = "";

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<String> f52305e = new ArrayList<>();

    /* renamed from: net.one97.paytm.adapter.a$a  reason: collision with other inner class name */
    public static class C0937a {

        /* renamed from: a  reason: collision with root package name */
        ImageView f52306a;

        /* renamed from: b  reason: collision with root package name */
        ProgressBar f52307b;
    }

    public a(Activity activity, CJROffersDetails cJROffersDetails) {
        this.f52302b = activity;
        this.f52303c = cJROffersDetails;
        this.f52301a = LayoutInflater.from(activity);
    }

    public final int getCount() {
        CJROffersDetails cJROffersDetails = this.f52303c;
        if (cJROffersDetails == null || cJROffersDetails.getmOfferItems() == null) {
            return 0;
        }
        return this.f52303c.getmOfferItems().size();
    }

    public final Object getItem(int i2) {
        return this.f52303c.getmOfferItems().get(i2);
    }

    public final long getItemId(int i2) {
        return (long) this.f52303c.getmOfferItems().get(i2).hashCode();
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f52301a.inflate(R.layout.carousel_horizontal_list_item, (ViewGroup) null);
            C0937a aVar = new C0937a();
            aVar.f52306a = (ImageView) view.findViewById(R.id.item_image);
            aVar.f52307b = (ProgressBar) view.findViewById(R.id.image_progress_bar);
            view.setTag(aVar);
        }
        C0937a aVar2 = (C0937a) view.getTag();
        String str = this.f52303c.getmOfferItems().get(i2).getmImageUrl();
        this.f52302b.getResources().getDimension(R.dimen.carousel_horizontal_list_width);
        this.f52302b.getResources().getDimension(R.dimen.carousel_horizontal_list_height);
        if (str != null) {
            aVar2.f52307b.setVisibility(0);
            b.a.C0750a a2 = b.a(this.f52302b);
            a2.f43753a = str;
            b.a.C0750a.a(a2.a(com.paytm.utility.b.b.a.NONE).a(aVar2.f52307b), aVar2.f52306a, (com.paytm.utility.b.b.b) null, 2);
        } else {
            aVar2.f52307b.setVisibility(8);
        }
        CJROffersDetails cJROffersDetails = this.f52303c;
        if (!(cJROffersDetails == null || cJROffersDetails.getmOfferItems() == null || i2 >= this.f52303c.getmOfferItems().size())) {
            String itemID = this.f52303c.getmOfferItems().get(i2).getItemID();
            ArrayList<String> arrayList = this.f52305e;
            if (arrayList != null && itemID != null && !arrayList.contains(itemID) && !TextUtils.isEmpty(this.f52304d)) {
                this.f52305e.add(itemID);
                net.one97.paytm.j.a.b((CJRItem) this.f52303c.getmOfferItems().get(i2), (Context) this.f52302b, i2, this.f52304d);
            }
        }
        return view;
    }
}
