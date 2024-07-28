package com.paytmmall.artifact.d;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.paytmmall.artifact.R;
import net.one97.paytm.i.g;

public class x extends g {

    /* renamed from: a  reason: collision with root package name */
    Button f15751a;

    /* renamed from: b  reason: collision with root package name */
    Context f15752b;

    /* renamed from: c  reason: collision with root package name */
    boolean f15753c;

    public x() {
    }

    private x(byte b2) {
        this.f15753c = true;
    }

    public static x a() {
        return new x((byte) 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        super.onCreateDialog(bundle);
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setCanceledOnTouchOutside(false);
        onCreateDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return onCreateDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.mall_no_internet_customdialog, viewGroup, false);
        this.f15752b = getActivity();
        this.f15751a = (Button) inflate.findViewById(R.id.ok_btn);
        setCancelable(false);
        this.f15751a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                x.this.a(view);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        getDialog().dismiss();
        if (this.f15753c && getActivity() != null) {
            getActivity().finish();
        }
    }
}
