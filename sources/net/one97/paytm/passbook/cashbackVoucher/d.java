package net.one97.paytm.passbook.cashbackVoucher;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.mapping.f;
import net.one97.paytm.passbook.utility.q;

public final class d extends androidx.viewpager.widget.a {

    /* renamed from: a  reason: collision with root package name */
    final Context f57158a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<a> f57159b;

    public d(Context context, ArrayList<a> arrayList) {
        k.c(context, "mContext");
        k.c(arrayList, "pagerItemList");
        this.f57158a = context;
        this.f57159b = arrayList;
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "container");
        View inflate = LayoutInflater.from(this.f57158a).inflate(R.layout.pass_cb_voucher_pager_item, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(mCon…r_item, container, false)");
        a aVar = this.f57159b.get(i2);
        k.a((Object) aVar, "pagerItemList[position]");
        a aVar2 = aVar;
        inflate.setBackgroundColor(Color.parseColor(aVar2.f57165f));
        ((AppCompatTextView) inflate.findViewById(R.id.tvPagerTitle)).setText(aVar2.f57160a);
        Integer num = aVar2.f57161b;
        if (num != null) {
            ((AppCompatTextView) inflate.findViewById(R.id.tvPagerSubtitle)).setText(num.intValue());
        } else {
            AppCompatTextView appCompatTextView = (AppCompatTextView) inflate.findViewById(R.id.tvPagerSubtitle);
            k.a((Object) appCompatTextView, "view.tvPagerSubtitle");
            appCompatTextView.setVisibility(8);
        }
        ((AppCompatTextView) inflate.findViewById(R.id.tvPagerButton)).setText(aVar2.f57162c);
        ((AppCompatImageView) inflate.findViewById(R.id.ivPagerImage)).setImageResource(aVar2.f57163d);
        String str = aVar2.f57164e;
        if (str != null) {
            inflate.setOnClickListener(new b(str, this, inflate, i2));
        }
        viewGroup.addView(inflate);
        return inflate;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f57166a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f57167b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f57168c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f57169d;

        b(String str, d dVar, View view, int i2) {
            this.f57166a = str;
            this.f57167b = dVar;
            this.f57168c = view;
            this.f57169d = i2;
        }

        public final void onClick(View view) {
            f b2 = net.one97.paytm.passbook.d.b();
            String str = this.f57166a;
            Context context = this.f57167b.f57158a;
            if (context != null) {
                b2.a(str, (Activity) context);
                int i2 = this.f57169d;
                k.a((Object) view, "it");
                Context context2 = view.getContext();
                k.a((Object) context2, "it.context");
                if (i2 == 0) {
                    q.a(context2, "uth_passbook", "brand_voucher_banner_clicked", (String) null, (String) null, "/uth_passbook_myaccounts/cb_voucher", "PASSBOOK");
                } else {
                    q.a(context2, "uth_passbook", "deals_banner_clicked", (String) null, (String) null, "/uth_passbook_myaccounts/cb_voucher", "PASSBOOK");
                }
            } else {
                throw new u("null cannot be cast to non-null type android.app.Activity");
            }
        }
    }

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        k.c(viewGroup, "container");
        k.c(obj, "object");
        viewGroup.removeView((View) obj);
    }

    public final int getItemPosition(Object obj) {
        k.c(obj, "object");
        return super.getItemPosition(obj);
    }

    public final boolean isViewFromObject(View view, Object obj) {
        k.c(view, "view");
        k.c(obj, "object");
        return k.a((Object) view, obj);
    }

    public final int getCount() {
        return this.f57159b.size();
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final int f57160a;

        /* renamed from: b  reason: collision with root package name */
        final Integer f57161b;

        /* renamed from: c  reason: collision with root package name */
        final int f57162c;

        /* renamed from: d  reason: collision with root package name */
        final int f57163d;

        /* renamed from: e  reason: collision with root package name */
        final String f57164e;

        /* renamed from: f  reason: collision with root package name */
        final String f57165f;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if ((this.f57160a == aVar.f57160a) && k.a((Object) this.f57161b, (Object) aVar.f57161b)) {
                        if (this.f57162c == aVar.f57162c) {
                            if (!(this.f57163d == aVar.f57163d) || !k.a((Object) this.f57164e, (Object) aVar.f57164e) || !k.a((Object) this.f57165f, (Object) aVar.f57165f)) {
                                return false;
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            int i2 = this.f57160a * 31;
            Integer num = this.f57161b;
            int i3 = 0;
            int hashCode = (((((i2 + (num != null ? num.hashCode() : 0)) * 31) + this.f57162c) * 31) + this.f57163d) * 31;
            String str = this.f57164e;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f57165f;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return hashCode2 + i3;
        }

        public final String toString() {
            return "ViewPagerItemData(pagerTitle=" + this.f57160a + ", pagerSubtitle=" + this.f57161b + ", pagerButtonText=" + this.f57162c + ", pagerImage=" + this.f57163d + ", buttonDeeplink=" + this.f57164e + ", bgColor=" + this.f57165f + ")";
        }

        public a(int i2, Integer num, int i3, int i4, String str, String str2) {
            k.c(str2, "bgColor");
            this.f57160a = i2;
            this.f57161b = num;
            this.f57162c = i3;
            this.f57163d = i4;
            this.f57164e = str;
            this.f57165f = str2;
        }
    }
}
