package net.one97.paytm.moneytransferv4.b.a.a.a.e;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransferv4.b.a.a.d;
import net.one97.paytm.moneytransferv4.b.a.a.e;
import net.one97.paytm.moneytransferv4.b.a.a.f;
import net.one97.paytm.moneytransferv4.b.a.a.g;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;

public final class b extends e<a> {

    /* renamed from: b  reason: collision with root package name */
    public boolean f55278b;

    /* renamed from: c  reason: collision with root package name */
    private d f55279c;

    public final int getItemCount() {
        return 1;
    }

    public b(boolean z) {
        this.f55278b = z;
    }

    public final /* synthetic */ void a(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        boolean z = this.f55278b;
        ((TextView) aVar.itemView.findViewById(R.id.allowContactsTextView)).setOnClickListener(new a.C1010a(aVar, z));
        TextView textView = aVar.f55280a;
        k.a((Object) textView, "tnc");
        CharSequence text = textView.getText();
        k.a((Object) text, "tnc.text");
        int a2 = p.a(text, "Privacy", 0, true);
        TextView textView2 = aVar.f55280a;
        k.a((Object) textView2, "tnc");
        int length = textView2.getText().length();
        if (a2 > 0 && length > 0) {
            TextView textView3 = aVar.f55280a;
            k.a((Object) textView3, "tnc");
            SpannableString spannableString = new SpannableString(textView3.getText());
            spannableString.setSpan(new a.C1011b(), a2, length, 33);
            TextView textView4 = aVar.f55280a;
            k.a((Object) textView4, "tnc");
            textView4.setText(spannableString);
            TextView textView5 = aVar.f55280a;
            k.a((Object) textView5, "tnc");
            textView5.setMovementMethod(LinkMovementMethod.getInstance());
            TextView textView6 = aVar.f55280a;
            k.a((Object) textView6, "tnc");
            textView6.setHighlightColor(0);
        }
        if (z) {
            TextView textView7 = aVar.f55281b;
            k.a((Object) textView7, "settings");
            textView7.setVisibility(0);
            TextView textView8 = aVar.f55281b;
            k.a((Object) textView8, "settings");
            CharSequence text2 = textView8.getText();
            k.a((Object) text2, "settings.text");
            int a3 = p.a(text2, "Settings", 0, true);
            TextView textView9 = aVar.f55281b;
            k.a((Object) textView9, "settings");
            int length2 = textView9.getText().length();
            if (a3 > 0 && length2 > 0) {
                TextView textView10 = aVar.f55281b;
                k.a((Object) textView10, "settings");
                SpannableString spannableString2 = new SpannableString(textView10.getText());
                spannableString2.setSpan(new a.c(aVar), a3, length2, 33);
                TextView textView11 = aVar.f55281b;
                k.a((Object) textView11, "settings");
                textView11.setText(spannableString2);
                TextView textView12 = aVar.f55281b;
                k.a((Object) textView12, "settings");
                textView12.setMovementMethod(LinkMovementMethod.getInstance());
                TextView textView13 = aVar.f55281b;
                k.a((Object) textView13, "settings");
                textView13.setHighlightColor(0);
                return;
            }
            return;
        }
        TextView textView14 = aVar.f55281b;
        k.a((Object) textView14, "settings");
        textView14.setVisibility(8);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        f.a aVar = f.f55348a;
        View a2 = f.a.a(viewGroup, g.WIDGET_TYPE_CONTACT_PERMISSION.getId());
        d dVar = this.f55279c;
        if (dVar == null) {
            k.a("onWidgetClickListener");
        }
        return new a(a2, dVar);
    }

    public final int a() {
        return g.WIDGET_TYPE_CONTACT_PERMISSION.getId();
    }

    public final void a(d dVar) {
        k.c(dVar, "onWidgetClickListener");
        this.f55279c = dVar;
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f55280a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f55281b;

        /* renamed from: c  reason: collision with root package name */
        final d f55282c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view, d dVar) {
            super(view);
            k.c(view, "itemView");
            k.c(dVar, "onWidgetClickListener");
            this.f55282c = dVar;
            this.f55280a = (TextView) view.findViewById(R.id.tnc);
            this.f55281b = (TextView) view.findViewById(R.id.permission_settings);
        }

        /* renamed from: net.one97.paytm.moneytransferv4.b.a.a.a.e.b$a$a  reason: collision with other inner class name */
        static final class C1010a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f55283a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f55284b;

            C1010a(a aVar, boolean z) {
                this.f55283a = aVar;
                this.f55284b = z;
            }

            public final void onClick(View view) {
                if (!this.f55284b) {
                    net.one97.paytm.contacts.c.a aVar = net.one97.paytm.contacts.c.a.f50123a;
                    net.one97.paytm.contacts.c.a.a();
                    this.f55283a.f55282c.e();
                    WalletSharedPrefs.setContactSyncConcentAsked();
                    return;
                }
                k.a((Object) view, "it");
                Context context = view.getContext();
                k.a((Object) context, "it.context");
                a.a(context);
            }
        }

        /* renamed from: net.one97.paytm.moneytransferv4.b.a.a.a.e.b$a$b  reason: collision with other inner class name */
        public static final class C1011b extends ClickableSpan {
            C1011b() {
            }

            public final void onClick(View view) {
                k.c(view, "widget");
                net.one97.paytm.wallet.utility.a.j(view.getContext());
                net.one97.paytm.moneytransfer.utils.f.a(view.getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_CONTACT_TNC_CLICKED, CJRGTMConstants.MT_V4_HOME_SCREEN_NAME, "", "");
            }
        }

        public static final class c extends ClickableSpan {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f55285a;

            c(a aVar) {
                this.f55285a = aVar;
            }

            public final void onClick(View view) {
                k.c(view, "widget");
                Context context = view.getContext();
                k.a((Object) context, "widget.context");
                a.a(context);
            }
        }

        public static final /* synthetic */ void a(Context context) {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            intent.addFlags(268435456);
            intent.addFlags(8388608);
            context.startActivity(intent);
        }
    }
}
