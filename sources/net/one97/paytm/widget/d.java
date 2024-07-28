package net.one97.paytm.widget;

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
import androidx.fragment.app.b;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.utils.ao;

public class d extends b {

    /* renamed from: a  reason: collision with root package name */
    ImageView f72411a;

    /* renamed from: b  reason: collision with root package name */
    TextView f72412b;

    /* renamed from: c  reason: collision with root package name */
    Button f72413c;

    /* renamed from: d  reason: collision with root package name */
    Context f72414d;

    /* renamed from: e  reason: collision with root package name */
    boolean f72415e;

    public d() {
        ao.a(d.class, "Constructor");
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
        View inflate = layoutInflater.inflate(R.layout.no_internet_dialog, viewGroup, false);
        this.f72414d = getActivity();
        this.f72411a = (ImageView) inflate.findViewById(R.id.image_cross);
        this.f72412b = (TextView) inflate.findViewById(R.id.call_toll_free);
        this.f72413c = (Button) inflate.findViewById(R.id.ok_btn);
        this.f72411a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.a();
            }
        });
        this.f72413c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.a();
                if (d.this.f72415e && d.this.getActivity() != null) {
                    d.this.getActivity().onBackPressed();
                }
            }
        });
        this.f72412b.setOnClickListener(new View.OnClickListener() {
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
            intent.setData(Uri.parse("tel:" + dVar.f72414d.getString(R.string.toll_free_number_without_space)));
            intent.addFlags(524288);
            dVar.f72414d.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            AlertDialog.Builder builder = new AlertDialog.Builder(dVar.f72414d);
            builder.setTitle(com.google.zxing.client.android.R.string.app_name);
            builder.setMessage(com.google.zxing.client.android.R.string.msg_intent_failed);
            builder.setPositiveButton(com.google.zxing.client.android.R.string.button_ok, (DialogInterface.OnClickListener) null);
            dVar.dismiss();
            builder.show();
        }
    }
}
