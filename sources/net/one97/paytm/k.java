package net.one97.paytm;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import net.one97.paytm.common.widgets.RoundedImageView;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.ai;

public final class k extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private Button f52419a;

    /* renamed from: b  reason: collision with root package name */
    private RoboTextView f52420b;

    /* renamed from: c  reason: collision with root package name */
    private RoboTextView f52421c;

    /* renamed from: d  reason: collision with root package name */
    private RoboTextView f52422d;

    /* renamed from: e  reason: collision with root package name */
    private RoboTextView f52423e;

    /* renamed from: f  reason: collision with root package name */
    private RoboTextView f52424f;

    /* renamed from: g  reason: collision with root package name */
    private RoundedImageView f52425g;

    /* renamed from: h  reason: collision with root package name */
    private String f52426h;

    /* renamed from: i  reason: collision with root package name */
    private Context f52427i;
    private View.OnClickListener j;
    private Boolean k = Boolean.FALSE;
    private Boolean l = Boolean.FALSE;
    private String m;

    public k(Context context, String str, View.OnClickListener onClickListener) {
        super(context);
        this.f52427i = context;
        this.f52426h = str;
        this.j = onClickListener;
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.delink_merchant_dialog);
        this.f52419a = (Button) findViewById(R.id.btn_confirm_delink);
        this.f52420b = (RoboTextView) findViewById(R.id.delink_merchant_dia_title);
        this.f52421c = (RoboTextView) findViewById(R.id.delink_merchant_dia_text);
        this.f52422d = (RoboTextView) findViewById(R.id.btn_cancel_delink);
        this.f52425g = (RoundedImageView) findViewById(R.id.delink_subscript_logo);
        this.f52423e = (RoboTextView) findViewById(R.id.delink_linked_merchant_logo);
        this.f52424f = (RoboTextView) findViewById(R.id.delink_linked_merchant_logo);
        this.f52420b.setText(this.f52427i.getResources().getString(R.string.delink_linked_mercchant_dialog_title, new Object[]{this.f52426h}));
        if (this.l.booleanValue()) {
            this.f52421c.setText(this.f52427i.getResources().getString(R.string.subscription_cancel_text, new Object[]{this.f52426h}));
            this.f52419a.setText(this.f52427i.getResources().getString(R.string.subscription_confirm_text));
            if (this.k.booleanValue()) {
                this.f52425g.setVisibility(0);
                this.f52423e.setVisibility(8);
                this.f52425g.setImageUrl(this.m, ai.INSTANCE.getImageLoader());
            } else {
                this.f52425g.setVisibility(8);
                this.f52423e.setVisibility(0);
                this.f52423e.setText(String.valueOf(this.f52426h.charAt(0)));
            }
        } else {
            this.f52421c.setText(this.f52427i.getResources().getString(R.string.delink_linked_merchant_dialog_txt, new Object[]{this.f52426h}));
            this.f52424f.setText(String.valueOf(this.f52426h.charAt(0)));
        }
        this.f52419a.setOnClickListener(this.j);
        this.f52422d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                k.this.a(view);
            }
        });
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f52426h);
        a("delink_popup_loaded", arrayList);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f52426h);
        a("no_clicked", arrayList);
        dismiss();
    }

    private void a(String str, ArrayList<String> arrayList) {
        OauthModule.b().sendGAMultipleLabelEvent(getContext(), "apps_linked_with_paytm", str, arrayList, (String) null, "/apps_linked_with_paytm", p.f56796a);
    }

    public final void dismiss() {
        super.dismiss();
        a("delink_popup_discarded", new ArrayList());
    }
}
