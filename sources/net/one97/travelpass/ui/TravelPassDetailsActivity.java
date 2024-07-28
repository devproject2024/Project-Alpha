package net.one97.travelpass.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.f;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.lifecycle.am;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.travelpass.R;
import net.one97.travelpass.b.w;
import net.one97.travelpass.e.b;
import net.one97.travelpass.ui.fragment.i;

public final class TravelPassDetailsActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private w f30565a;

    /* renamed from: b  reason: collision with root package name */
    private String f30566b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f30567c = 0;

    /* renamed from: d  reason: collision with root package name */
    private String f30568d = "";

    /* renamed from: e  reason: collision with root package name */
    private final String f30569e = "pass_details";

    /* renamed from: f  reason: collision with root package name */
    private net.one97.travelpass.g.a f30570f;

    /* renamed from: g  reason: collision with root package name */
    private i f30571g;

    public final void onCreate(Bundle bundle) {
        ImageView imageView;
        super.onCreate(bundle);
        this.f30565a = (w) f.a(this, R.layout.tp_detail_activity_view);
        w wVar = this.f30565a;
        if (!(wVar == null || (imageView = wVar.f30297a) == null)) {
            imageView.setOnClickListener(new a(this));
        }
        this.f30570f = (net.one97.travelpass.g.a) am.a((FragmentActivity) this).a(net.one97.travelpass.g.a.class);
        if (getIntent() != null) {
            String str = null;
            if (getIntent().hasExtra("verticalType")) {
                Intent intent = getIntent();
                this.f30566b = intent != null ? intent.getStringExtra("verticalType") : null;
            }
            if (getIntent().hasExtra("passId")) {
                Intent intent2 = getIntent();
                if (intent2 != null) {
                    str = intent2.getStringExtra("passId");
                }
                this.f30568d = str;
            }
        }
        this.f30571g = new i();
        Bundle bundle2 = new Bundle();
        CharSequence charSequence = this.f30566b;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            bundle2.putString("verticalType", this.f30566b);
        }
        CharSequence charSequence2 = this.f30568d;
        if (charSequence2 == null || charSequence2.length() == 0) {
            z = true;
        }
        if (!z) {
            bundle2.putString("passId", this.f30568d);
        }
        i iVar = this.f30571g;
        if (iVar == null) {
            k.a();
        }
        iVar.setArguments(bundle2);
        j supportFragmentManager = getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "supportFragmentManager");
        q a2 = supportFragmentManager.a();
        k.a((Object) a2, "fragmentManager.beginTransaction()");
        int i2 = R.id.fragment_container;
        i iVar2 = this.f30571g;
        if (iVar2 == null) {
            k.a();
        }
        a2.a(i2, iVar2, this.f30569e);
        a2.b();
        b.a aVar = b.f30322a;
        Context context = this;
        k.c(context, "context");
        b.a.a(context, b.j, b.z, (String) null, (String) null, (String) null, (String) null, b.f30326e, (String) null, 376);
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TravelPassDetailsActivity f30572a;

        a(TravelPassDetailsActivity travelPassDetailsActivity) {
            this.f30572a = travelPassDetailsActivity;
        }

        public final void onClick(View view) {
            this.f30572a.onBackPressed();
        }
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        com.travel.utils.q.a(context);
        super.attachBaseContext(context);
        Context context2 = this;
        com.google.android.play.core.splitcompat.a.a(context2);
        com.google.android.play.core.splitcompat.a.b(context2);
    }

    public final void onResume() {
        super.onResume();
        Context context = this;
        com.google.android.play.core.splitcompat.a.a(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public final void onBackPressed() {
        i iVar = this.f30571g;
        if (iVar != null && iVar.f30736e) {
            Intent intent = new Intent();
            intent.putExtra("travelPass", iVar.f30733b);
            FragmentActivity activity = iVar.getActivity();
            if (activity != null) {
                activity.setResult(-1, intent);
            }
        }
        super.onBackPressed();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        i iVar;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            return;
        }
        if ((i2 == 1101 || i2 == 1102 || i2 == 3) && (iVar = this.f30571g) != null) {
            iVar.onActivityResult(i2, i3, intent);
        }
    }
}
