package net.one97.paytm.wifi.ui.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.b;
import com.paytm.utility.RoboTextView;
import net.one97.paytm.common.widgets.RoboButton;
import net.one97.paytm.wifi.R;

public class a extends b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private RoboTextView f21273a;

    /* renamed from: b  reason: collision with root package name */
    private RoboTextView f21274b;

    /* renamed from: c  reason: collision with root package name */
    private RoboTextView f21275c;

    /* renamed from: d  reason: collision with root package name */
    private RoboButton f21276d;

    /* renamed from: e  reason: collision with root package name */
    private String f21277e;

    /* renamed from: f  reason: collision with root package name */
    private String f21278f;

    /* renamed from: g  reason: collision with root package name */
    private String f21279g;

    /* renamed from: h  reason: collision with root package name */
    private String f21280h;

    /* renamed from: i  reason: collision with root package name */
    private C0419a f21281i;

    /* renamed from: net.one97.paytm.wifi.ui.b.a$a  reason: collision with other inner class name */
    public interface C0419a {
        void a();

        void b();
    }

    public a(String str, String str2, String str3, String str4) {
        this.f21277e = str;
        this.f21278f = str2;
        this.f21279g = str3;
        this.f21280h = str4;
    }

    public a() {
    }

    public final C0419a a(C0419a aVar) {
        this.f21281i = aVar;
        return this.f21281i;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_wifi, viewGroup, false);
        this.f21273a = (RoboTextView) inflate.findViewById(R.id.tv_title);
        this.f21274b = (RoboTextView) inflate.findViewById(R.id.tv_sub_title);
        this.f21276d = (RoboButton) inflate.findViewById(R.id.btn_positive);
        this.f21275c = (RoboTextView) inflate.findViewById(R.id.btn_negative);
        this.f21273a.setText(this.f21277e);
        this.f21274b.setText(this.f21278f);
        this.f21276d.setText(this.f21279g);
        this.f21275c.setText(this.f21280h);
        this.f21275c.setOnClickListener(this);
        this.f21276d.setOnClickListener(this);
        return inflate;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_positive) {
            dismiss();
            this.f21281i.a();
        } else if (id == R.id.btn_negative) {
            dismiss();
            this.f21281i.b();
        }
    }
}
