package net.one97.paytm.passbook.statementDownload;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import java.util.ArrayList;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.statementDownload.TabPageIndicator;

public final class k extends m implements View.OnClickListener, TabPageIndicator.a {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<Fragment> f58718a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<l> f58719b;

    /* renamed from: c  reason: collision with root package name */
    private SelectDurationActivity f58720c;

    public interface a {
    }

    public k(Context context, j jVar, ArrayList<l> arrayList) {
        super(jVar);
        this.f58719b = arrayList;
        this.f58720c = (SelectDurationActivity) context;
    }

    public final CharSequence getPageTitle(int i2) {
        return this.f58719b.get(i2).f58721a;
    }

    public final Fragment getItem(int i2) {
        j jVar = new j();
        Bundle bundle = new Bundle();
        bundle.putInt("key_index", i2);
        jVar.setArguments(bundle);
        this.f58718a.put(i2, jVar);
        return jVar;
    }

    public final int getCount() {
        return this.f58719b.size();
    }

    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        try {
            this.f58718a.remove(i2);
            viewGroup.removeView(((Fragment) obj).getView());
        } catch (Exception unused) {
        }
        super.destroyItem(viewGroup, i2, obj);
    }

    public final void a(ViewGroup viewGroup, int i2) {
        ArrayList<l> arrayList;
        if (this.f58720c != null && (arrayList = this.f58719b) != null && arrayList.size() > 0) {
            try {
                l lVar = this.f58719b.get(i2);
                View inflate = this.f58720c.f58596a.inflate(R.layout.pass_datepicker_tab_row, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.datepicker_tab_from_to_tv)).setText(lVar.f58721a);
                ((TextView) inflate.findViewById(R.id.datepicker_tab_date_tv)).setText(lVar.f58722b);
                ((TextView) inflate.findViewById(R.id.datepicker_tab_month_tv)).setText(lVar.f58723c);
                ((TextView) inflate.findViewById(R.id.datepicker_tab_year_tv)).setText(lVar.f58724d);
                inflate.setTag(Integer.valueOf(i2));
                viewGroup.addView(inflate, new LinearLayout.LayoutParams(-1, -1, 1.0f));
                inflate.setOnClickListener(this);
            } catch (Exception unused) {
            }
        }
    }

    public final void onClick(View view) {
        SelectDurationActivity selectDurationActivity = this.f58720c;
        if (selectDurationActivity != null && (selectDurationActivity instanceof a)) {
            try {
                Integer valueOf = Integer.valueOf(Integer.parseInt(view.getTag().toString()));
                SelectDurationActivity selectDurationActivity2 = this.f58720c;
                int intValue = valueOf.intValue();
                if (selectDurationActivity2.f58597b != null) {
                    selectDurationActivity2.f58597b.setCurrentItem(intValue);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void a(ViewGroup viewGroup, boolean z) {
        try {
            viewGroup.findViewById(R.id.viewpageIndicator_marker).setVisibility(z ? 0 : 4);
        } catch (Exception unused) {
        }
    }
}
