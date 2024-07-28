package net.one97.paytm.bankCommon.d;

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
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.i.g;

public class a extends g {

    /* renamed from: a  reason: collision with root package name */
    ImageView f16224a;

    /* renamed from: b  reason: collision with root package name */
    TextView f16225b;

    /* renamed from: c  reason: collision with root package name */
    Button f16226c;

    /* renamed from: d  reason: collision with root package name */
    Context f16227d;

    /* renamed from: e  reason: collision with root package name */
    boolean f16228e;

    public static a a() {
        return new a();
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
        View inflate = layoutInflater.inflate(R.layout.pb_no_internet_dialog, viewGroup, false);
        this.f16227d = getActivity();
        this.f16224a = (ImageView) inflate.findViewById(R.id.image_cross);
        this.f16225b = (TextView) inflate.findViewById(R.id.call_toll_free);
        this.f16226c = (Button) inflate.findViewById(R.id.ok_btn);
        this.f16224a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.b();
            }
        });
        this.f16226c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.b();
                if (a.this.f16228e && a.this.getActivity() != null) {
                    a.this.getActivity().onBackPressed();
                }
            }
        });
        this.f16225b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a aVar = a.this;
                a.a(aVar, new Intent("android.intent.action.DIAL", Uri.parse(aVar.getActivity().getString(R.string.pb_toll_free_number))));
            }
        });
        return inflate;
    }

    public final void b() {
        getDialog().dismiss();
    }

    static /* synthetic */ void a(a aVar, Intent intent) {
        try {
            intent.setData(Uri.parse("tel:" + aVar.f16227d.getString(R.string.pb_toll_free_number_without_space)));
            intent.addFlags(524288);
            aVar.f16227d.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
        }
    }
}
