package com.travel.train.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.b.aa;
import com.travel.train.b.z;
import com.travel.train.i.o;
import com.travel.train.j.h;
import com.travel.train.model.trainticket.a;
import com.travel.train.model.trainticket.j;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.b;
import io.reactivex.rxjava3.d.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class AJRTrainSelectContactListActivity extends CJRTrainBaseActivity implements o {

    /* renamed from: a  reason: collision with root package name */
    private TextView f26106a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f26107b;

    /* renamed from: c  reason: collision with root package name */
    private EditText f26108c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f26109d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f26110e;

    /* renamed from: f  reason: collision with root package name */
    private ViewGroup f26111f;

    /* renamed from: g  reason: collision with root package name */
    private RecyclerView f26112g;

    /* renamed from: h  reason: collision with root package name */
    private RecyclerView f26113h;

    /* renamed from: i  reason: collision with root package name */
    private List<a> f26114i;
    private ArrayList<a> j;
    private z k;
    private aa l;
    private View m;
    private boolean n;
    private int o;
    private String p;
    private String q;
    private c r;
    private String s = "AJRTrainSelectContactListActivity";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.pre_t_train_contact_list);
        this.f26106a = (TextView) findViewById(R.id.text_view_cancel);
        this.f26107b = (TextView) findViewById(R.id.text_view_done);
        this.f26108c = (EditText) findViewById(R.id.edit_text_search);
        this.f26109d = (TextView) findViewById(R.id.text_view_select_contacts_label);
        this.f26110e = (TextView) findViewById(R.id.text_view_no_of_contacts_selected);
        this.m = findViewById(R.id.layout_progress);
        this.f26112g = (RecyclerView) findViewById(R.id.recycler_view_contacts_selected);
        this.f26113h = (RecyclerView) findViewById(R.id.recycler_view_contacts);
        this.f26111f = (ViewGroup) findViewById(R.id.layout_selected_contacts);
        this.f26111f.setVisibility(8);
        Map map = (Map) getIntent().getSerializableExtra("intent_extra_contact_params");
        this.n = ((Boolean) com.travel.train.j.o.a((Map<String, Object>) map, "multiSelect", Boolean.FALSE)).booleanValue();
        this.o = ((Integer) com.travel.train.j.o.a((Map<String, Object>) map, "maxLimit", 1)).intValue();
        this.p = (String) com.travel.train.j.o.a((Map<String, Object>) map, "title", getString(R.string.select_contacts));
        this.q = (String) com.travel.train.j.o.a((Map<String, Object>) map, "maxLimitExceedMessage", getString(R.string.contact_select_max_limit_reached));
        this.f26109d.setText(this.p);
        this.f26106a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainSelectContactListActivity.this.b(view);
            }
        });
        this.f26107b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainSelectContactListActivity.this.a(view);
            }
        });
        com.travel.train.h.a.a(this.f26108c).debounce(400, TimeUnit.MILLISECONDS).distinctUntilChanged().subscribeOn(io.reactivex.rxjava3.i.a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new g() {
            public final void accept(Object obj) {
                AJRTrainSelectContactListActivity.this.a((String) obj);
            }
        });
        this.f26108c.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AJRTrainSelectContactListActivity.this.a(view, z);
            }
        });
        a(true);
        this.r = y.a(new Callable() {
            public final Object call() {
                return AJRTrainSelectContactListActivity.this.b();
            }
        }).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new b() {
            public final void accept(Object obj, Object obj2) {
                AJRTrainSelectContactListActivity.this.a((List) obj, (Throwable) obj2);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        setResult(0);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Intent intent = new Intent();
        intent.putExtra("intent_extra_selected_contacts", this.j);
        setResult(-1, intent);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str) throws Throwable {
        this.k.getFilter().filter(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view, boolean z) {
        this.f26109d.setVisibility(z ? 8 : 0);
    }

    private void a() {
        int i2;
        this.j = new ArrayList<>();
        Iterator it2 = ((List) com.travel.train.j.o.a((Map<String, Object>) (Map) getIntent().getSerializableExtra("intent_extra_contact_params"), "intent_extra_multiple_contact", new ArrayList())).iterator();
        while (true) {
            i2 = 0;
            if (!it2.hasNext()) {
                break;
            }
            a aVar = (a) it2.next();
            String contactNumber = aVar.getContactNumber();
            Iterator<a> it3 = this.f26114i.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                a next = it3.next();
                if (next.getContactNumber().equalsIgnoreCase(contactNumber)) {
                    this.j.add(next);
                    i2 = 1;
                    break;
                }
            }
            if (i2 == 0) {
                this.j.add(aVar);
            }
        }
        this.l = new aa(this, this.j, this);
        this.f26112g.setAdapter(this.l);
        ViewGroup viewGroup = this.f26111f;
        if (this.j.size() <= 0) {
            i2 = 8;
        }
        viewGroup.setVisibility(i2);
        this.k = new z(this, this.f26114i, this);
        this.k.a((List<? extends j>) this.j);
        this.f26113h.setAdapter(this.k);
        this.f26113h.addItemDecoration(new com.travel.train.widget.c(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List b() throws Exception {
        return h.a(h.a((Context) this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(List list, Throwable th) throws Throwable {
        if (th == null) {
            this.f26114i = list;
        } else {
            this.f26114i = new ArrayList();
        }
        a(false);
        a();
    }

    public final void a(a aVar) {
        if (this.j.size() >= this.o) {
            String string = getString(R.string.dg_wx_alert_title);
            String str = this.q;
            try {
                c.a aVar2 = new c.a(this);
                aVar2.a((CharSequence) string);
                aVar2.b((CharSequence) str);
                aVar2.a((CharSequence) getResources().getString(R.string.ok), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        if (dialogInterface != null) {
                            dialogInterface.dismiss();
                        }
                    }
                });
                aVar2.b();
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.c(e2.getMessage());
                }
            }
        } else if (!this.j.contains(aVar)) {
            this.j.add(aVar);
            this.l.notifyDataSetChanged();
            this.k.a((List<? extends j>) this.j);
            int i2 = 0;
            this.f26110e.setText(String.format(getString(R.string.selected_count), new Object[]{Integer.valueOf(this.j.size())}));
            ViewGroup viewGroup = this.f26111f;
            if (this.j.size() <= 0) {
                i2 = 8;
            }
            viewGroup.setVisibility(i2);
            this.f26112g.scrollToPosition(this.j.size() - 1);
        }
    }

    public final void b(a aVar) {
        this.j.remove(aVar);
        this.l.notifyDataSetChanged();
        this.k.a((List<? extends j>) this.j);
        this.k.getFilter().filter(this.f26108c.getText().toString());
        int i2 = 0;
        this.f26110e.setText(String.format(getString(R.string.selected_count), new Object[]{Integer.valueOf(this.j.size())}));
        ViewGroup viewGroup = this.f26111f;
        if (this.j.size() <= 0) {
            i2 = 8;
        }
        viewGroup.setVisibility(i2);
    }

    public void onBackPressed() {
        setResult(0);
        finish();
    }

    public void onStop() {
        super.onStop();
        io.reactivex.rxjava3.b.c cVar = this.r;
        if (cVar != null && !cVar.isDisposed()) {
            this.r.dispose();
        }
    }

    private void a(boolean z) {
        this.m.setVisibility(z ? 0 : 8);
    }
}
