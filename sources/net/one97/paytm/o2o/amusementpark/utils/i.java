package net.one97.paytm.o2o.amusementpark.utils;

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
import net.one97.paytm.i.g;
import net.one97.paytm.o2o.amusementpark.R;

public class i extends g {

    /* renamed from: a  reason: collision with root package name */
    ImageView f73668a;

    /* renamed from: b  reason: collision with root package name */
    TextView f73669b;

    /* renamed from: c  reason: collision with root package name */
    Button f73670c;

    /* renamed from: d  reason: collision with root package name */
    Context f73671d;

    /* renamed from: e  reason: collision with root package name */
    boolean f73672e;

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
        View inflate = layoutInflater.inflate(R.layout.park_no_internet_dialog, viewGroup, false);
        this.f73671d = getActivity();
        this.f73668a = (ImageView) inflate.findViewById(R.id.image_cross);
        this.f73669b = (TextView) inflate.findViewById(R.id.call_toll_free);
        this.f73670c = (Button) inflate.findViewById(R.id.ok_btn);
        this.f73668a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                i.this.a();
            }
        });
        this.f73670c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                i.this.a();
                if (i.this.f73672e && i.this.getActivity() != null) {
                    i.this.getActivity().onBackPressed();
                }
            }
        });
        this.f73669b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                i iVar = i.this;
                i.a(iVar, new Intent("android.intent.action.DIAL", Uri.parse(iVar.getActivity().getString(R.string.toll_free_number))));
            }
        });
        return inflate;
    }

    public final void a() {
        getDialog().dismiss();
    }

    static /* synthetic */ void a(i iVar, Intent intent) {
        try {
            intent.setData(Uri.parse("tel:" + iVar.f73671d.getString(R.string.toll_free_number_without_space)));
            intent.addFlags(524288);
            iVar.f73671d.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            AlertDialog.Builder builder = new AlertDialog.Builder(iVar.f73671d);
            builder.setTitle(com.google.zxing.client.android.R.string.app_name);
            builder.setMessage(com.google.zxing.client.android.R.string.msg_intent_failed);
            builder.setPositiveButton(com.google.zxing.client.android.R.string.button_ok, (DialogInterface.OnClickListener) null);
            iVar.dismiss();
            builder.show();
        }
    }
}
