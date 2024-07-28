package com.travel.train.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.q;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.a.a.b;
import com.travel.train.fragment.e;
import com.travel.train.k.a;
import com.travel.train.k.g;
import com.travel.train.model.trainticket.CJRTrainLSSearchResult;
import java.util.List;

public class AJRLSSearchTrains extends CJRTrainBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private a f25876a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f25877b = null;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public CJRTrainLSSearchResult.Train f25878c = null;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public CJRTrainLSSearchResult.Schedule f25879d = null;

    /* renamed from: e  reason: collision with root package name */
    private Boolean f25880e = Boolean.FALSE;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f25881f = Boolean.FALSE;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_activity_ls_search_trains_layout);
        this.f25876a = (a) am.a((FragmentActivity) this, (al.b) new g(new g.a(g.b.LS).a(com.travel.train.a.a.a((b) new com.travel.train.a.a.a(this))))).a(a.class);
        if (getIntent() != null && getIntent().hasExtra("intent_extra_train_upcoming_trips")) {
            this.f25876a.f27613b.postValue((List) getIntent().getSerializableExtra("intent_extra_train_upcoming_trips"));
        }
        if (getIntent() != null && getIntent().hasExtra("intent_extra_from_search_by_train")) {
            this.f25880e = Boolean.valueOf(getIntent().getBooleanExtra("intent_extra_from_search_by_train", false));
        }
        if (getIntent() != null && getIntent().hasExtra("intent_extra_from_train_home")) {
            this.f25881f = Boolean.valueOf(getIntent().getBooleanExtra("intent_extra_from_train_home", false));
        }
        q a2 = getSupportFragmentManager().a();
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("intent_extra_from_search_by_train", this.f25880e.booleanValue());
        bundle2.putBoolean("intent_extra_from_train_home", this.f25881f.booleanValue());
        a2.b(R.id.fragment_container, e.a(bundle2), (String) null);
        a2.c();
        this.f25876a.f27615d.observe(this, new z<String>() {
            public final /* synthetic */ void onChanged(Object obj) {
                String unused = AJRLSSearchTrains.this.f25877b = (String) obj;
            }
        });
        this.f25876a.f27616e.observe(this, new z<CJRTrainLSSearchResult.Train>() {
            public final /* synthetic */ void onChanged(Object obj) {
                CJRTrainLSSearchResult.Train unused = AJRLSSearchTrains.this.f25878c = (CJRTrainLSSearchResult.Train) obj;
            }
        });
        this.f25876a.f27617f.observe(this, new z<CJRTrainLSSearchResult.Schedule>() {
            public final /* synthetic */ void onChanged(Object obj) {
                CJRTrainLSSearchResult.Schedule unused = AJRLSSearchTrains.this.f25879d = (CJRTrainLSSearchResult.Schedule) obj;
            }
        });
        this.f25876a.f27618g.observe(this, new z<Boolean>() {
            public final /* synthetic */ void onChanged(Object obj) {
                Intent intent = new Intent();
                intent.putExtra("intent_extra_server_ist", AJRLSSearchTrains.this.f25877b);
                intent.putExtra("intent_extra_train_selected", AJRLSSearchTrains.this.f25878c);
                intent.putExtra("intent_extra_bp_selected", AJRLSSearchTrains.this.f25879d);
                AJRLSSearchTrains.this.setResult(-1, intent);
                AJRLSSearchTrains.this.finish();
            }
        });
        this.f25876a.f27619h.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRLSSearchTrains.this.a((Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        Intent intent = new Intent();
        intent.putExtra("intent_extra_server_ist", this.f25877b);
        intent.putExtra("intent_extra_train_selected", this.f25878c);
        intent.putExtra("intent_extra_bp_selected", this.f25878c.getSchedule().get(0));
        intent.putExtra("intent_extra_schedule_selected", this.f25878c.getSchedule().get(0));
        setResult(-1, intent);
        finish();
    }
}
