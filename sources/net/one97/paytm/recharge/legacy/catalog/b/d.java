package net.one97.paytm.recharge.legacy.catalog.b;

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
import net.one97.paytm.recharge.R;

@Deprecated
public class d extends g {

    /* renamed from: a  reason: collision with root package name */
    ImageView f62808a;

    /* renamed from: b  reason: collision with root package name */
    TextView f62809b;

    /* renamed from: c  reason: collision with root package name */
    Button f62810c;

    /* renamed from: d  reason: collision with root package name */
    Context f62811d;

    /* renamed from: e  reason: collision with root package name */
    boolean f62812e;

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
        View inflate = layoutInflater.inflate(R.layout.no_internet_dialog_re, viewGroup, false);
        this.f62811d = getActivity();
        this.f62808a = (ImageView) inflate.findViewById(R.id.image_cross);
        this.f62809b = (TextView) inflate.findViewById(R.id.call_toll_free);
        this.f62810c = (Button) inflate.findViewById(R.id.ok_btn);
        this.f62808a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.a();
            }
        });
        this.f62810c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.a();
                if (d.this.f62812e && d.this.getActivity() != null) {
                    d.this.getActivity().onBackPressed();
                }
            }
        });
        this.f62809b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d dVar = d.this;
                d.a(dVar, new Intent("android.intent.action.DIAL", Uri.parse(dVar.getActivity().getString(R.string.toll_free_number))));
            }
        });
        return inflate;
    }

    public final void a() {
        getDialog().dismiss();
    }

    static /* synthetic */ void a(d dVar, Intent intent) {
        try {
            intent.setData(Uri.parse("tel:" + dVar.f62811d.getString(R.string.toll_free_number_without_space)));
            intent.addFlags(524288);
            dVar.f62811d.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            AlertDialog.Builder builder = new AlertDialog.Builder(dVar.f62811d);
            builder.setTitle(com.google.zxing.client.android.R.string.app_name);
            builder.setMessage(com.google.zxing.client.android.R.string.msg_intent_failed);
            builder.setPositiveButton(com.google.zxing.client.android.R.string.button_ok, (DialogInterface.OnClickListener) null);
            dVar.dismiss();
            builder.show();
        }
    }
}
