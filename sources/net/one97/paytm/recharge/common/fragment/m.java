package net.one97.paytm.recharge.common.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import com.paytm.utility.q;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.i.h;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.j;
import net.one97.paytm.recharge.common.e.v;
import net.one97.paytm.recharge.common.utils.ab;

public class m extends h implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public View.OnClickListener f61320a;

    /* renamed from: b  reason: collision with root package name */
    private View f61321b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ListView f61322c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public j f61323d;

    /* renamed from: e  reason: collision with root package name */
    private List<CJRFrequentOrder> f61324e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public v f61325f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public AdapterView.OnItemClickListener f61326g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f61327h = false;

    /* renamed from: i  reason: collision with root package name */
    private CJRItem f61328i;
    /* access modifiers changed from: private */
    public boolean j = false;
    /* access modifiers changed from: private */
    public Button k;
    /* access modifiers changed from: private */
    public boolean l;
    private a m;
    private b n;

    public interface b {
        void a(Boolean bool);
    }

    public m() {
    }

    public m(CJRItem cJRItem, boolean z, v vVar, AdapterView.OnItemClickListener onItemClickListener, List<CJRFrequentOrder> list, b bVar) {
        this.f61326g = onItemClickListener;
        this.f61325f = vVar;
        this.f61324e = list;
        this.f61328i = cJRItem;
        this.j = z;
        this.n = bVar;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        j jVar = this.f61323d;
        if (jVar != null && this.f61327h) {
            jVar.b(i2);
            this.f61325f.a(this.f61324e.get(i2));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f61321b = layoutInflater.inflate(R.layout.recharge_tab_item, (ViewGroup) null);
        this.f61322c = (ListView) this.f61321b.findViewById(R.id.recharge_item_list_view);
        this.k = (Button) this.f61321b.findViewById(R.id.show_more_btn);
        List<CJRFrequentOrder> list = this.f61324e;
        if (list != null && list.size() > 5) {
            this.l = true;
            this.k.setText(R.string.show_more);
        }
        this.k.setOnClickListener(this);
        return this.f61321b;
    }

    public void onStart() {
        super.onStart();
        if (this.f61328i != null) {
            a aVar = this.m;
            if (aVar == null || (aVar.isCancelled() && this.f61323d == null)) {
                String uRLType = this.f61328i.getURLType();
                if (uRLType.equalsIgnoreCase("utility") || uRLType.equalsIgnoreCase("utility_creditcard")) {
                    uRLType = this.f61328i.getName();
                }
                this.m = new a(uRLType, this.f61324e, Boolean.FALSE);
                this.m.execute(new Void[0]);
            }
        }
    }

    class a extends AsyncTask<Void, Void, List<CJRFrequentOrder>> {

        /* renamed from: a  reason: collision with root package name */
        String f61329a;

        /* renamed from: b  reason: collision with root package name */
        List<CJRFrequentOrder> f61330b;

        /* renamed from: c  reason: collision with root package name */
        Boolean f61331c;

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            List<CJRFrequentOrder> list = (List) obj;
            if (m.this.getActivity() != null && m.this.f61322c != null) {
                if (!this.f61331c.booleanValue()) {
                    m mVar = m.this;
                    j unused = mVar.f61323d = new j(mVar.getActivity(), m.this.f61325f, m.this.j, this.f61329a, list);
                    j d2 = m.this.f61323d;
                    m mVar2 = m.this;
                    d2.f60549d = mVar2;
                    mVar2.f61322c.setAdapter(m.this.f61323d);
                    m.this.f61322c.setOnItemClickListener(m.this.f61326g);
                } else if (m.this.f61323d != null) {
                    j d3 = m.this.f61323d;
                    d3.f60548c = list;
                    d3.notifyDataSetChanged();
                }
                if (m.this.l) {
                    m.this.k.setVisibility(0);
                }
            }
        }

        a(String str, List<CJRFrequentOrder> list, Boolean bool) {
            this.f61329a = str;
            this.f61330b = list;
            this.f61331c = bool;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            m.a(m.this, (List) this.f61330b);
            return this.f61330b;
        }
    }

    public final void a() {
        j jVar = this.f61323d;
        if (jVar != null) {
            this.f61327h = false;
            if (jVar.f60546a != null && jVar.f60546a.size() > 0) {
                jVar.f60546a.clear();
                jVar.notifyDataSetChanged();
            }
        }
        ListView listView = this.f61322c;
        if (listView != null) {
            listView.setOnItemClickListener(this.f61326g);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        View childAt;
        if (i2 != 203) {
            super.onActivityResult(i2, i3, intent);
        } else if (i3 == -1) {
            int intExtra = intent != null ? intent.getIntExtra("key_position", -1) : -1;
            if (intExtra != -1 && this.f61323d != null && (childAt = this.f61322c.getChildAt(intExtra)) != null && (childAt.getTag() instanceof j.b)) {
                j.b bVar = (j.b) childAt.getTag();
                if (bVar.f60559a != null && bVar.f60560b == intExtra) {
                    bVar.f60559a.setVisibility(8);
                }
                if (this.f61320a != null && getContext() != null) {
                    View view = new View(getContext());
                    view.setTag(net.one97.paytm.recharge.automatic.b.a.j.ENABLED);
                    this.f61320a.onClick(view);
                }
            }
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.show_more_btn && this.l) {
            this.l = false;
            this.k.setVisibility(8);
            j jVar = this.f61323d;
            if (jVar != null) {
                jVar.f60547b = this.l;
                jVar.notifyDataSetChanged();
            }
            b bVar = this.n;
            if (bVar != null) {
                bVar.a(Boolean.valueOf(this.l));
            }
        }
    }

    public void onStop() {
        super.onStop();
        a aVar = this.m;
        if (aVar != null && aVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.m.cancel(true);
        }
    }

    static /* synthetic */ void a(m mVar, List list) {
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                String paidOn = ((CJRFrequentOrder) list.get(i2)).getPaidOn();
                String rechargeNumber = ((CJRFrequentOrder) list.get(i2)).getRechargeNumber();
                if (!TextUtils.isEmpty(paidOn)) {
                    instance.setTime(simpleDateFormat.parse(paidOn));
                    String displayName = instance.getDisplayName(2, 1, Locale.getDefault());
                    int i3 = instance.get(1);
                    int i4 = instance.get(5);
                    ((CJRFrequentOrder) list.get(i2)).setDate(i4 + " " + displayName + " " + i3);
                }
                if (rechargeNumber != null) {
                    ((CJRFrequentOrder) list.get(i2)).setContactName(ab.a(mVar.getContext(), rechargeNumber));
                }
            } catch (Exception e2) {
                q.d(e2.getMessage());
            }
        }
    }
}
