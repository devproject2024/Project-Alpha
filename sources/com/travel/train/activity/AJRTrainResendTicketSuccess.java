package com.travel.train.activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.travel.cdn.ResourceUtils;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.b.ao;
import com.travel.train.helper.k;
import com.travel.train.i.l;
import com.travel.train.model.f;
import com.travel.train.model.trainticket.d;
import com.travel.train.model.trainticket.e;
import com.travel.utils.n;
import java.util.ArrayList;

public class AJRTrainResendTicketSuccess extends CJRTrainBaseActivity implements l {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f26080a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f26081b;

    /* renamed from: c  reason: collision with root package name */
    private ao f26082c;

    /* renamed from: d  reason: collision with root package name */
    private FrameLayout f26083d;

    public final void a() {
    }

    public final void a(e eVar) {
    }

    public final void a(e eVar, int i2) {
    }

    public final void a(e eVar, String str) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_activity_ajrtrain_resend_ticket_success);
        this.f26083d = (FrameLayout) findViewById(R.id.frame_layout);
        this.f26080a = (RecyclerView) findViewById(R.id.recycler_view_tickets_sent_to);
        this.f26081b = (ImageView) findViewById(R.id.image_view);
        ResourceUtils.loadTrainImagesFromCDN(this.f26081b, "resend_ticket.png", false, false, n.a.V1);
        f fVar = (f) getIntent().getSerializableExtra("intent_extra_train_resend_tickets_to");
        String[] contactPhones = fVar.getContactPhones();
        String[] contactEmails = fVar.getContactEmails();
        ArrayList arrayList = new ArrayList();
        if (contactEmails != null && contactEmails.length > 0) {
            for (String dVar : contactEmails) {
                arrayList.add(new d(dVar));
            }
        }
        if (contactPhones != null && contactPhones.length > 0) {
            for (String dVar2 : contactPhones) {
                arrayList.add(new d(dVar2));
            }
        }
        this.f26082c = new ao(this, arrayList, e.GENERIC, this);
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this);
        flexboxLayoutManager.c(0);
        flexboxLayoutManager.c();
        flexboxLayoutManager.b();
        flexboxLayoutManager.d(0);
        Rect rect = new Rect();
        rect.right = (int) getResources().getDimension(R.dimen.dimen_10dp);
        rect.top = (int) getResources().getDimension(R.dimen.dimen_7dp);
        this.f26080a.setLayoutManager(flexboxLayoutManager);
        this.f26080a.setAdapter(this.f26082c);
        this.f26080a.addItemDecoration(new k(rect));
        this.f26083d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainResendTicketSuccess.this.finish();
            }
        });
    }
}
