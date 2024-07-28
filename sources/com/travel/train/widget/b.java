package com.travel.train.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
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
import com.travel.train.R;
import net.one97.paytm.i.g;

public class b extends g {

    /* renamed from: a  reason: collision with root package name */
    ImageView f28367a;

    /* renamed from: b  reason: collision with root package name */
    TextView f28368b;

    /* renamed from: c  reason: collision with root package name */
    Button f28369c;

    /* renamed from: d  reason: collision with root package name */
    Context f28370d;

    /* renamed from: e  reason: collision with root package name */
    boolean f28371e;

    public b() {
    }

    private b(byte b2) {
        this.f28371e = false;
    }

    public static b a() {
        return new b((byte) 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        super.onCreateDialog(bundle);
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return onCreateDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pre_t_no_internet_dialog, viewGroup, false);
        this.f28370d = getActivity();
        this.f28367a = (ImageView) inflate.findViewById(R.id.image_cross);
        this.f28368b = (TextView) inflate.findViewById(R.id.call_toll_free);
        this.f28369c = (Button) inflate.findViewById(R.id.ok_btn);
        this.f28367a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.b();
            }
        });
        this.f28369c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.b();
                if (b.this.f28371e && b.this.getActivity() != null) {
                    b.this.getActivity().onBackPressed();
                }
            }
        });
        this.f28368b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b bVar = b.this;
                b.a(bVar, new Intent("android.intent.action.DIAL", Uri.parse(bVar.getActivity().getString(R.string.toll_free_number))));
            }
        });
        return inflate;
    }

    public final void b() {
        getDialog().dismiss();
    }

    static /* synthetic */ void a(b bVar, Intent intent) {
        try {
            intent.setData(Uri.parse("tel:" + bVar.f28370d.getString(R.string.toll_free_number_without_space)));
            intent.addFlags(524288);
            bVar.f28370d.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            AlertDialog.Builder builder = new AlertDialog.Builder(bVar.f28370d);
            builder.setTitle(com.google.zxing.client.android.R.string.app_name);
            builder.setMessage(com.google.zxing.client.android.R.string.msg_intent_failed);
            builder.setPositiveButton(com.google.zxing.client.android.R.string.button_ok, (DialogInterface.OnClickListener) null);
            bVar.dismiss();
            builder.show();
        }
    }
}
