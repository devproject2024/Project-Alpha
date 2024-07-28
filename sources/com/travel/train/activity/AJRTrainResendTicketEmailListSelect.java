package com.travel.train.activity;

import android.app.Activity;
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
import com.travel.train.b.ab;
import com.travel.train.b.ao;
import com.travel.train.helper.k;
import com.travel.train.i.l;
import com.travel.train.i.p;
import com.travel.train.j.h;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.c;
import com.travel.train.model.trainticket.e;
import com.travel.train.model.trainticket.j;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.b;
import io.reactivex.rxjava3.i.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class AJRTrainResendTicketEmailListSelect extends CJRTrainBaseActivity implements l, p {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f26071a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f26072b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f26073c;

    /* renamed from: d  reason: collision with root package name */
    private ao f26074d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<j> f26075e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView f26076f;

    /* renamed from: g  reason: collision with root package name */
    private ab f26077g;

    /* renamed from: h  reason: collision with root package name */
    private List<c> f26078h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f26079i;
    private TextView j;
    private View k;
    private b l;
    private String m;

    public final void a(e eVar) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_activity_train_resend_ticket_email_select);
        this.f26071a = (ImageView) findViewById(R.id.image_view_cancel);
        this.f26071a.setImageResource(com.travel.common.R.drawable.travel_res_common_close);
        this.f26072b = (TextView) findViewById(R.id.text_view_done);
        this.f26079i = (LinearLayout) findViewById(R.id.lv_suggestion_container);
        this.j = (TextView) findViewById(R.id.text_view_suggestion);
        this.f26073c = (RecyclerView) findViewById(R.id.recycler_view_emails);
        this.f26076f = (RecyclerView) findViewById(R.id.recycler_view_email_suggestion);
        this.k = findViewById(R.id.layout_progress);
        this.f26071a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainResendTicketEmailListSelect.this.c(view);
            }
        });
        this.f26072b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainResendTicketEmailListSelect.this.b(view);
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainResendTicketEmailListSelect.this.a(view);
            }
        });
        this.l = new b();
        a(true);
        this.l.a(y.a(new Callable() {
            public final Object call() {
                return AJRTrainResendTicketEmailListSelect.this.d();
            }
        }).b(a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new io.reactivex.rxjava3.d.b() {
            public final void accept(Object obj, Object obj2) {
                AJRTrainResendTicketEmailListSelect.this.a((List) obj, (Throwable) obj2);
            }
        }));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        setResult(0);
        supportFinishAfterTransition();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Iterator<j> it2 = this.f26075e.iterator();
        while (it2.hasNext()) {
            j next = it2.next();
            if (next instanceof com.travel.train.model.trainticket.b) {
                ((com.travel.train.model.trainticket.b) next).setText("");
            }
        }
        Intent intent = new Intent();
        intent.putExtra("intent_extra_selected_emails", this.f26075e);
        setResult(-1, intent);
        supportFinishAfterTransition();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List d() throws Exception {
        return h.b(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(List list, Throwable th) throws Throwable {
        a(false);
        if (th == null) {
            this.f26078h = list;
        } else {
            this.f26078h = new ArrayList();
        }
        b();
    }

    private void b() {
        Intent intent = getIntent();
        this.m = intent.getStringExtra("maxLimitExceedMessage");
        List list = (List) intent.getSerializableExtra("intent_extra_selected_emails");
        String[] stringArrayExtra = intent.getStringArrayExtra("intent_extra_train_resend_profile_emails");
        if (stringArrayExtra != null && stringArrayExtra.length > 0) {
            o.b(this.f26078h, stringArrayExtra);
        }
        this.f26075e = new ArrayList<>();
        Iterator it2 = list.iterator();
        while (true) {
            boolean z = false;
            if (it2.hasNext()) {
                j jVar = (j) it2.next();
                if (jVar instanceof c) {
                    c cVar = (c) jVar;
                    Iterator<c> it3 = this.f26078h.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        c next = it3.next();
                        if (next.getEmail().equalsIgnoreCase(cVar.getEmail())) {
                            this.f26075e.add(next);
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        this.f26075e.add(cVar);
                    }
                }
            } else {
                com.travel.train.model.trainticket.b bVar = new com.travel.train.model.trainticket.b();
                bVar.setHint(getString(R.string.enter_resend_email_address));
                this.f26075e.add(bVar);
                this.f26074d = new ao(this, this.f26075e, e.EMAIL, this);
                FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this);
                flexboxLayoutManager.c(0);
                flexboxLayoutManager.c();
                flexboxLayoutManager.b();
                flexboxLayoutManager.d(0);
                Rect rect = new Rect();
                rect.right = (int) getResources().getDimension(R.dimen.dimen_10dp);
                rect.top = (int) getResources().getDimension(R.dimen.dimen_7dp);
                this.f26073c.setLayoutManager(flexboxLayoutManager);
                this.f26073c.setAdapter(this.f26074d);
                this.f26073c.addItemDecoration(new k(rect));
                this.f26077g = new ab(this, this.f26078h, this);
                this.f26077g.a((List<? extends j>) this.f26075e);
                this.f26076f.setAdapter(this.f26077g);
                c();
                return;
            }
        }
    }

    public final void a(e eVar, int i2) {
        this.f26075e.remove(i2);
        this.f26074d.notifyDataSetChanged();
        this.f26077g.a((List<? extends j>) this.f26075e);
    }

    public final void a(e eVar, String str) {
        String trim = str.trim();
        this.f26077g.getFilter().filter(trim);
        this.f26079i.setVisibility(TextUtils.isEmpty(trim) ? 8 : 0);
        this.j.setText(trim);
    }

    public final void a(c cVar) {
        o.a((Activity) this);
        if (this.f26075e.size() - 1 >= 5) {
            Toast.makeText(this, this.m, 1).show();
        } else if (!this.f26075e.contains(cVar)) {
            if (this.f26075e.size() == 0) {
                this.f26075e.add(cVar);
            } else {
                ArrayList<j> arrayList = this.f26075e;
                arrayList.add(arrayList.size() - 1, cVar);
            }
            this.f26074d.notifyDataSetChanged();
            this.f26077g.a((List<? extends j>) this.f26075e);
            this.f26074d.a("");
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
        this.l.a(y.a(1).a(TimeUnit.MILLISECONDS).b(a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new io.reactivex.rxjava3.d.b() {
            public final void accept(Object obj, Object obj2) {
                AJRTrainResendTicketEmailListSelect.this.a((Integer) obj, (Throwable) obj2);
            }
        }));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Integer num, Throwable th) throws Throwable {
        this.f26074d.a();
    }

    private void a(boolean z) {
        this.k.setVisibility(z ? 0 : 8);
    }

    public final void a() {
        if (this.f26075e.size() > 1) {
            int size = this.f26075e.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                } else if (this.f26075e.get(size) instanceof c) {
                    this.f26075e.remove(size);
                    break;
                } else {
                    size--;
                }
            }
            this.f26074d.notifyDataSetChanged();
            this.f26077g.a((List<? extends j>) this.f26075e);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        c cVar;
        String trim = this.j.getText().toString().trim();
        Iterator<c> it2 = this.f26078h.iterator();
        while (true) {
            if (!it2.hasNext()) {
                cVar = null;
                break;
            }
            cVar = it2.next();
            if (cVar.getEmail().equalsIgnoreCase(trim)) {
                break;
            }
        }
        if (cVar != null) {
            a(cVar);
            this.f26074d.a("");
        } else if (o.d(trim)) {
            a(new c("", trim));
            this.f26074d.a("");
        }
    }
}
