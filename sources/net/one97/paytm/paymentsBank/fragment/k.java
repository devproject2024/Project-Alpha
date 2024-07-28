package net.one97.paytm.paymentsBank.fragment;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import net.one97.paytm.i.g;
import net.one97.paytm.paymentsBank.R;

public final class k extends g {

    /* renamed from: a  reason: collision with root package name */
    ImageView f18522a;

    /* renamed from: b  reason: collision with root package name */
    TextView f18523b;

    /* renamed from: c  reason: collision with root package name */
    Button f18524c;

    /* renamed from: d  reason: collision with root package name */
    Context f18525d;

    /* renamed from: e  reason: collision with root package name */
    boolean f18526e = false;

    private k() {
    }

    public static k a() {
        return new k();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        super.onCreateDialog(bundle);
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return onCreateDialog;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_no_internet_dialog, viewGroup, false);
        this.f18525d = getActivity();
        this.f18522a = (ImageView) inflate.findViewById(R.id.image_cross);
        this.f18523b = (TextView) inflate.findViewById(R.id.call_toll_free);
        this.f18524c = (Button) inflate.findViewById(R.id.ok_btn);
        this.f18522a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                k.this.c(view);
            }
        });
        this.f18524c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                k.this.b(view);
            }
        });
        this.f18523b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                k.this.a(view);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(getActivity().getString(R.string.pb_toll_free_number)));
        try {
            intent.setData(Uri.parse("tel:" + this.f18525d.getString(R.string.pb_toll_free_number_without_space)));
            intent.addFlags(524288);
            this.f18525d.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        getDialog().dismiss();
        if (this.f18526e && getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        getDialog().dismiss();
    }
}
