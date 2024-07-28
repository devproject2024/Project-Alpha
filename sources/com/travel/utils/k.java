package com.travel.utils;

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
import com.travel.R;
import net.one97.paytm.i.g;

public class k extends g {

    /* renamed from: a  reason: collision with root package name */
    ImageView f28529a;

    /* renamed from: b  reason: collision with root package name */
    TextView f28530b;

    /* renamed from: c  reason: collision with root package name */
    Button f28531c;

    /* renamed from: d  reason: collision with root package name */
    Context f28532d;

    /* renamed from: e  reason: collision with root package name */
    boolean f28533e;

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
        View inflate = layoutInflater.inflate(R.layout.pre_td_no_internet_dialog, viewGroup, false);
        this.f28532d = getActivity();
        this.f28529a = (ImageView) inflate.findViewById(R.id.image_cross);
        this.f28530b = (TextView) inflate.findViewById(R.id.call_toll_free);
        this.f28531c = (Button) inflate.findViewById(R.id.ok_btn);
        this.f28529a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                k.this.a();
            }
        });
        this.f28531c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                k.this.a();
                if (k.this.f28533e && k.this.getActivity() != null) {
                    k.this.getActivity().onBackPressed();
                }
            }
        });
        this.f28530b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                k kVar = k.this;
                k.a(kVar, new Intent("android.intent.action.DIAL", Uri.parse(kVar.getActivity().getString(R.string.toll_free_number))));
            }
        });
        return inflate;
    }

    public final void a() {
        getDialog().dismiss();
    }

    static /* synthetic */ void a(k kVar, Intent intent) {
        try {
            intent.setData(Uri.parse("tel:" + kVar.f28532d.getString(R.string.toll_free_number_without_space)));
            intent.addFlags(524288);
            kVar.f28532d.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            AlertDialog.Builder builder = new AlertDialog.Builder(kVar.f28532d);
            builder.setTitle(R.string.app_name_core);
            builder.setMessage(R.string.msg_intent_failed);
            builder.setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) null);
            kVar.dismiss();
            builder.show();
        }
    }
}
