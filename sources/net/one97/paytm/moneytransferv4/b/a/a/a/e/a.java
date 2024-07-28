package net.one97.paytm.moneytransferv4.b.a.a.a.e;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.contacts.entities.beans.ContactDetail;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransferv4.b.a.a.a.e.c;
import net.one97.paytm.moneytransferv4.b.a.a.d;
import net.one97.paytm.moneytransferv4.b.a.a.e;
import net.one97.paytm.moneytransferv4.b.a.a.f;
import net.one97.paytm.moneytransferv4.b.a.a.g;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.util.UpiUtils;

public final class a extends e<C1009a> {

    /* renamed from: b  reason: collision with root package name */
    final ContactDetail f55275b;

    /* renamed from: c  reason: collision with root package name */
    private d f55276c;

    public final int getItemCount() {
        return 1;
    }

    public a(ContactDetail contactDetail) {
        k.c(contactDetail, "contactModel");
        this.f55275b = contactDetail;
    }

    public final /* synthetic */ void a(RecyclerView.v vVar, int i2) {
        C1009a aVar = (C1009a) vVar;
        k.c(aVar, "holder");
        k.c(this, "contact");
        c.a aVar2 = c.f55286a;
        View view = aVar.itemView;
        k.a((Object) view, "itemView");
        ContactDetail contactDetail = this.f55275b;
        d dVar = aVar.f55277a;
        k.c(view, "view");
        k.c(contactDetail, "contact");
        k.c(dVar, "listener");
        View findViewById = view.findViewById(R.id.contactName);
        k.a((Object) findViewById, "view.findViewById<TextView>(R.id.contactName)");
        ((TextView) findViewById).setText(contactDetail.getContactName());
        View findViewById2 = view.findViewById(R.id.contactMobile);
        k.a((Object) findViewById2, "view.findViewById<TextView>(R.id.contactMobile)");
        ((TextView) findViewById2).setText(contactDetail.getPrimaryPhoneNumber());
        View findViewById3 = view.findViewById(R.id.contactInitials);
        k.a((Object) findViewById3, "view.findViewById<TextView>(R.id.contactInitials)");
        ((TextView) findViewById3).setText(UpiUtils.getNameInitials(f.a(contactDetail.getContactName())));
        view.findViewById(R.id.contactImage).setBackgroundColor(m.c()[i2 % 10]);
        view.findViewById(R.id.clickView).setOnClickListener(new c.a.C1012a(dVar, contactDetail, i2));
        View findViewById4 = view.findViewById(R.id.progressBar);
        k.a((Object) findViewById4, "view.findViewById<Circul…essBar>(R.id.progressBar)");
        f.a(findViewById4, contactDetail.isSelected());
        TextView textView = (TextView) view.findViewById(R.id.newPlaceHolder);
        if (!TextUtils.isEmpty(contactDetail.getContactNewTime()) && TextUtils.isDigitsOnly(contactDetail.getContactNewTime())) {
            String contactNewTime = contactDetail.getContactNewTime();
            if (contactNewTime == null) {
                throw new u("null cannot be cast to non-null type kotlin.String");
            } else if (Long.parseLong(contactNewTime) - System.currentTimeMillis() > 0) {
                k.a((Object) textView, "newTag");
                textView.setVisibility(0);
            } else {
                k.a((Object) textView, "newTag");
                textView.setVisibility(4);
            }
        } else if (TextUtils.isEmpty(contactDetail.getContactNewAddedTimeLocal()) || !TextUtils.isDigitsOnly(contactDetail.getContactNewAddedTimeLocal())) {
            k.a((Object) textView, "newTag");
            textView.setVisibility(4);
        } else {
            String contactNewAddedTimeLocal = contactDetail.getContactNewAddedTimeLocal();
            if (contactNewAddedTimeLocal == null) {
                throw new u("null cannot be cast to non-null type kotlin.String");
            } else if (Long.parseLong(contactNewAddedTimeLocal) - System.currentTimeMillis() > 0) {
                k.a((Object) textView, "newTag");
                textView.setVisibility(0);
            } else {
                k.a((Object) textView, "newTag");
                textView.setVisibility(4);
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        f.a aVar = net.one97.paytm.moneytransferv4.b.a.a.f.f55348a;
        View a2 = f.a.a(viewGroup, g.WIDGET_TYPE_CONTACTS.getId());
        d dVar = this.f55276c;
        if (dVar == null) {
            k.a();
        }
        return new C1009a(a2, dVar);
    }

    public final int a() {
        return g.WIDGET_TYPE_CONTACTS.getId();
    }

    /* renamed from: net.one97.paytm.moneytransferv4.b.a.a.a.e.a$a  reason: collision with other inner class name */
    public static final class C1009a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final d f55277a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1009a(View view, d dVar) {
            super(view);
            k.c(view, "itemView");
            k.c(dVar, "onWidgetClickListener");
            this.f55277a = dVar;
        }
    }

    public final void a(d dVar) {
        k.c(dVar, "onWidgetClickListener");
        this.f55276c = dVar;
    }

    public final void a(boolean z) {
        this.f55275b.setSelected(z);
    }
}
