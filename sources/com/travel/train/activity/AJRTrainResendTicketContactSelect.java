package com.travel.train.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.b.ao;
import com.travel.train.b.z;
import com.travel.train.helper.k;
import com.travel.train.i.l;
import com.travel.train.i.o;
import com.travel.train.j.h;
import com.travel.train.model.trainticket.a;
import com.travel.train.model.trainticket.e;
import com.travel.train.model.trainticket.j;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class AJRTrainResendTicketContactSelect extends CJRTrainBaseActivity implements l, o {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f26062a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f26063b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f26064c;

    /* renamed from: d  reason: collision with root package name */
    private ao f26065d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<j> f26066e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView f26067f;

    /* renamed from: g  reason: collision with root package name */
    private List<a> f26068g;

    /* renamed from: h  reason: collision with root package name */
    private z f26069h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f26070i;
    private TextView j;
    private String k;
    private b l;

    public final void a(e eVar) {
    }

    public final void b(a aVar) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_activity_train_resend_ticket_contact_select);
        this.f26062a = (ImageView) findViewById(R.id.image_view_cancel);
        this.f26062a.setImageResource(com.travel.common.R.drawable.travel_res_common_close);
        this.f26063b = (TextView) findViewById(R.id.text_view_done);
        this.f26070i = (LinearLayout) findViewById(R.id.lv_suggestion_container);
        this.j = (TextView) findViewById(R.id.text_view_suggestion);
        this.f26064c = (RecyclerView) findViewById(R.id.recycler_view_contacts);
        this.f26067f = (RecyclerView) findViewById(R.id.recycler_view_contact_suggestion);
        this.f26062a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainResendTicketContactSelect.this.c(view);
            }
        });
        this.f26063b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainResendTicketContactSelect.this.b(view);
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainResendTicketContactSelect.this.a(view);
            }
        });
        this.l = new b();
        this.l.a(y.a(new Callable() {
            public final Object call() {
                return AJRTrainResendTicketContactSelect.this.d();
            }
        }).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new io.reactivex.rxjava3.d.b() {
            public final void accept(Object obj, Object obj2) {
                AJRTrainResendTicketContactSelect.this.a((List) obj, (Throwable) obj2);
            }
        }));
    }

    private void b() {
        Intent intent = getIntent();
        this.k = intent.getStringExtra("maxLimitExceedMessage");
        List list = (List) intent.getSerializableExtra("intent_extra_selected_contacts");
        String[] stringArrayExtra = intent.getStringArrayExtra("intent_extra_train_resend_profile_contacts");
        if (stringArrayExtra != null && stringArrayExtra.length > 0) {
            com.travel.train.j.o.a(this.f26068g, stringArrayExtra);
        }
        this.f26066e = new ArrayList<>();
        Iterator it2 = list.iterator();
        while (true) {
            boolean z = false;
            if (it2.hasNext()) {
                j jVar = (j) it2.next();
                if (jVar instanceof a) {
                    a aVar = (a) jVar;
                    String contactNumber = aVar.getContactNumber();
                    Iterator<a> it3 = this.f26068g.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        a next = it3.next();
                        if (next.getContactNumber().equalsIgnoreCase(contactNumber)) {
                            this.f26066e.add(next);
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        this.f26066e.add(aVar);
                    }
                }
            } else {
                com.travel.train.model.trainticket.b bVar = new com.travel.train.model.trainticket.b();
                bVar.setHint(getString(R.string.enter_resend_mobile_number));
                this.f26066e.add(bVar);
                this.f26065d = new ao(this, this.f26066e, e.CONTACT, this);
                FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this);
                flexboxLayoutManager.c(0);
                flexboxLayoutManager.c();
                flexboxLayoutManager.b();
                flexboxLayoutManager.d(0);
                Rect rect = new Rect();
                rect.right = (int) getResources().getDimension(R.dimen.dimen_10dp);
                rect.top = (int) getResources().getDimension(R.dimen.dimen_7dp);
                this.f26064c.setLayoutManager(flexboxLayoutManager);
                this.f26064c.setAdapter(this.f26065d);
                this.f26064c.addItemDecoration(new k(rect));
                this.f26069h = new z(this, this.f26068g, this);
                this.f26069h.a((List<? extends j>) this.f26066e);
                this.f26067f.setAdapter(this.f26069h);
                c();
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List d() throws Exception {
        return h.a(h.a((Context) this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(List list, Throwable th) throws Throwable {
        if (th == null) {
            this.f26068g = list;
        } else {
            this.f26068g = new ArrayList();
        }
        b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        setResult(0);
        supportFinishAfterTransition();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Iterator<j> it2 = this.f26066e.iterator();
        while (it2.hasNext()) {
            j next = it2.next();
            if (next instanceof com.travel.train.model.trainticket.b) {
                ((com.travel.train.model.trainticket.b) next).setText("");
            }
        }
        Intent intent = new Intent();
        intent.putExtra("intent_extra_selected_contacts", this.f26066e);
        setResult(-1, intent);
        supportFinishAfterTransition();
    }

    public final void a(e eVar, int i2) {
        this.f26066e.remove(i2);
        this.f26065d.notifyDataSetChanged();
        this.f26069h.a((List<? extends j>) this.f26066e);
    }

    public final void a(e eVar, String str) {
        String trim = str.trim();
        this.f26069h.getFilter().filter(trim);
        this.f26070i.setVisibility(TextUtils.isEmpty(trim) ? 8 : 0);
        this.j.setText(trim);
    }

    public final void a(a aVar) {
        com.travel.train.j.o.a((Activity) this);
        if (this.f26066e.size() - 1 >= 5) {
            Toast.makeText(this, this.k, 1).show();
        } else if (!this.f26066e.contains(aVar)) {
            if (this.f26066e.size() == 0) {
                this.f26066e.add(aVar);
            } else {
                ArrayList<j> arrayList = this.f26066e;
                arrayList.add(arrayList.size() - 1, aVar);
            }
            this.f26065d.notifyDataSetChanged();
            this.f26069h.a((List<? extends j>) this.f26066e);
            this.f26065d.a("");
            c();
        }
    }

    public void onStop() {
        super.onStop();
        b bVar = this.l;
        if (bVar != null && !bVar.isDisposed()) {
            this.l.dispose();
        }
    }

    private void c() {
        this.l.a(y.a(1).a(TimeUnit.MILLISECONDS).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new io.reactivex.rxjava3.d.b() {
            public final void accept(Object obj, Object obj2) {
                AJRTrainResendTicketContactSelect.this.a((Integer) obj, (Throwable) obj2);
            }
        }));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Integer num, Throwable th) throws Throwable {
        this.f26065d.a();
    }

    public final void a() {
        if (this.f26066e.size() > 1) {
            int size = this.f26066e.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                } else if (this.f26066e.get(size) instanceof a) {
                    this.f26066e.remove(size);
                    break;
                } else {
                    size--;
                }
            }
            this.f26065d.notifyDataSetChanged();
            this.f26069h.a((List<? extends j>) this.f26066e);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a aVar;
        String trim = this.j.getText().toString().trim();
        Iterator<a> it2 = this.f26068g.iterator();
        while (true) {
            if (!it2.hasNext()) {
                aVar = null;
                break;
            }
            aVar = it2.next();
            if (aVar.getContactNumber().equalsIgnoreCase(trim)) {
                break;
            }
        }
        if (aVar != null) {
            a(aVar);
            this.f26065d.a("");
        } else if (com.travel.train.j.o.c(trim)) {
            a aVar2 = new a("", trim);
            aVar2.setColor(com.travel.train.j.a.f27481b.a());
            a(aVar2);
            this.f26065d.a("");
        }
    }
}
