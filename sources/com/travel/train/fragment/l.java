package com.travel.train.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.travel.cdn.ResourceUtils;
import com.travel.train.R;
import com.travel.train.widget.e;
import com.travel.utils.n;
import net.one97.paytm.i.g;

public class l extends g {

    /* renamed from: a  reason: collision with root package name */
    private View f27047a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f27048b;

    public interface a {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public l(a aVar) {
        this.f27048b = aVar;
    }

    public l() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.FullScreenDialogStyle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f27047a = layoutInflater.inflate(R.layout.pre_t_train_animation_progress, viewGroup, false);
        View view = this.f27047a;
        new e(getActivity(), (RelativeLayout) view.findViewById(R.id.train_animation_container)).a();
        ((TextView) view.findViewById(R.id.cancel_action)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                l.this.getDialog().dismiss();
                if (l.this.f27048b != null) {
                    a unused = l.this.f27048b;
                }
            }
        });
        ResourceUtils.loadTrainImagesFromCDN((ImageView) view.findViewById(R.id.animation_train_image), "train_image.png", false, false, n.a.V1);
        ResourceUtils.loadTrainImagesFromCDN((ImageView) view.findViewById(R.id.wheel_image), "wheel_image.png", false, false, n.a.V1);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
            public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                return l.this.a(dialogInterface, i2, keyEvent);
            }
        });
        return this.f27047a;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return false;
        }
        if (this.f27048b == null) {
            return true;
        }
        getDialog().dismiss();
        return true;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void show(j jVar, String str) {
        q a2 = jVar.a();
        a2.a((Fragment) this, str);
        a2.c();
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(-1, -1);
        }
    }

    public void onDestroyView() {
        this.f27047a = null;
        this.f27048b = null;
        super.onDestroyView();
    }
}
