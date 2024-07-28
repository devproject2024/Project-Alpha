package com.travel.train.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.appsflyer.internal.referrer.Payload;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.travel.train.R;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.widgets.RoboButton;
import net.one97.paytm.i.f;

public final class v extends f {

    /* renamed from: c  reason: collision with root package name */
    public static final a f27181c = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    int f27182a = -1;

    /* renamed from: b  reason: collision with root package name */
    int f27183b = -1;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f27184d;

    public final View a(int i2) {
        if (this.f27184d == null) {
            this.f27184d = new HashMap();
        }
        View view = (View) this.f27184d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f27184d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public final void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pre_t_train_nps_rating_lyt, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        int i2 = 0;
        while (i2 <= 10) {
            View inflate = getLayoutInflater().inflate(R.layout.pre_t_train_nps_rating_points, (ViewGroup) null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            View findViewById = inflate.findViewById(R.id.nps_review_point);
            if (findViewById != null) {
                TextView textView = (TextView) findViewById;
                TypedArray obtainTypedArray = getResources().obtainTypedArray(R.array.nps_rating);
                k.a((Object) obtainTypedArray, "resources.obtainTypedArray(R.array.nps_rating)");
                Drawable background = textView.getBackground();
                if (background != null) {
                    ((GradientDrawable) background).setColorFilter(obtainTypedArray.getColor(11, 0), PorterDuff.Mode.OVERLAY);
                    textView.setText(String.valueOf(i2));
                    k.a((Object) inflate, "child");
                    inflate.setLayoutParams(layoutParams);
                    LinearLayout linearLayout = (LinearLayout) a(R.id.nps_seekbar_review_layout);
                    if (linearLayout != null) {
                        linearLayout.addView(inflate);
                    }
                    i2++;
                } else {
                    throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                }
            } else {
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
        }
        SeekBar seekBar = (SeekBar) a(R.id.nps_seekbar_review);
        if (seekBar != null) {
            seekBar.setOnSeekBarChangeListener(new e(this));
        }
        ImageView imageView = (ImageView) a(R.id.nps_close);
        if (imageView != null) {
            imageView.setOnClickListener(new c(this));
        }
        RoboButton roboButton = (RoboButton) a(R.id.continue_btn);
        if (roboButton != null) {
            roboButton.setOnClickListener(new d(this));
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f27186a;

        c(v vVar) {
            this.f27186a = vVar;
        }

        public final void onClick(View view) {
            this.f27186a.dismiss();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f27187a;

        d(v vVar) {
            this.f27187a = vVar;
        }

        public final void onClick(View view) {
            v vVar = this.f27187a;
            v.a(vVar, vVar.f27182a);
        }
    }

    public static final class e implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ v f27188a;

        e(v vVar) {
            this.f27188a = vVar;
        }

        public final void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Drawable thumb;
            Rect bounds;
            v vVar = this.f27188a;
            vVar.f27182a = i2;
            LinearLayout linearLayout = (LinearLayout) vVar.a(R.id.nps_emoji);
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            TypedArray obtainTypedArray = this.f27188a.getResources().obtainTypedArray(R.array.emoji_icon);
            k.a((Object) obtainTypedArray, "resources.obtainTypedArray(R.array.emoji_icon)");
            AppCompatImageView appCompatImageView = (AppCompatImageView) this.f27188a.a(R.id.nps_review_image);
            if (appCompatImageView != null) {
                appCompatImageView.setImageResource(obtainTypedArray.getResourceId(i2, 0));
            }
            TypedArray obtainTypedArray2 = this.f27188a.getResources().obtainTypedArray(R.array.emoji_title);
            k.a((Object) obtainTypedArray2, "resources.obtainTypedArray(R.array.emoji_title)");
            TextView textView = (TextView) this.f27188a.a(R.id.nps_review_text);
            if (textView != null) {
                textView.setText(obtainTypedArray2.getResourceId(i2, 0));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f27188a.f27183b >= 0) {
                    v vVar2 = this.f27188a;
                    v.a(vVar2, vVar2.f27183b, false);
                }
                v.a(this.f27188a, i2, true);
            }
            if (Build.VERSION.SDK_INT >= 16 && seekBar != null && (thumb = seekBar.getThumb()) != null && (bounds = thumb.getBounds()) != null) {
                float f2 = (float) bounds.left;
                LinearLayout linearLayout2 = (LinearLayout) this.f27188a.a(R.id.nps_emoji);
                if (linearLayout2 != null) {
                    linearLayout2.setTranslationX(f2);
                }
            }
        }

        public final void onStartTrackingTouch(SeekBar seekBar) {
            RoboButton roboButton = (RoboButton) this.f27188a.a(R.id.continue_btn);
            k.a((Object) roboButton, "continue_btn");
            roboButton.setVisibility(0);
            if (this.f27188a.f27183b == -1 && seekBar != null && seekBar.getProgress() == 0) {
                LinearLayout linearLayout = (LinearLayout) this.f27188a.a(R.id.nps_emoji);
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                v.a(this.f27188a, 0, true);
            }
        }

        public final void onStopTrackingTouch(SeekBar seekBar) {
            LinearLayout linearLayout;
            LinearLayout linearLayout2;
            if (seekBar != null && seekBar.getProgress() == 0 && (linearLayout = (LinearLayout) this.f27188a.a(R.id.nps_emoji)) != null && linearLayout.getVisibility() == 8 && (linearLayout2 = (LinearLayout) this.f27188a.a(R.id.nps_emoji)) != null) {
                linearLayout2.setVisibility(0);
            }
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(b.f27185a);
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class b implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final b f27185a = new b();

        b() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (frameLayout == null) {
                    k.a();
                }
                BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                k.a((Object) from, "BottomSheetBehavior.from(bottomSheet!!)");
                from.setState(3);
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final void show(j jVar, String str) {
        k.c(jVar, "manager");
        try {
            Fragment c2 = jVar.c(str);
            if (c2 == null || !c2.isAdded()) {
                q a2 = jVar.a();
                a2.a((Fragment) this, str);
                a2.c();
            }
        } catch (IllegalStateException unused) {
        }
    }

    public static final /* synthetic */ void a(v vVar, int i2) {
        FragmentActivity activity = vVar.getActivity();
        Intent intent = activity != null ? activity.getIntent() : null;
        if (intent != null) {
            intent.putExtra(Payload.RESPONSE, i2);
        }
        Fragment targetFragment = vVar.getTargetFragment();
        if (targetFragment != null) {
            targetFragment.onActivityResult(vVar.getTargetRequestCode(), -1, intent);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0019, code lost:
        r1 = r1.getChildAt(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(com.travel.train.fragment.v r4, int r5, boolean r6) {
        /*
            android.content.res.Resources r0 = r4.getResources()
            int r1 = com.travel.train.R.array.nps_rating
            android.content.res.TypedArray r0 = r0.obtainTypedArray(r1)
            java.lang.String r1 = "resources.obtainTypedArray(R.array.nps_rating)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            int r1 = com.travel.train.R.id.nps_seekbar_review_layout
            android.view.View r1 = r4.a((int) r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            if (r1 == 0) goto L_0x0028
            android.view.View r1 = r1.getChildAt(r5)
            if (r1 == 0) goto L_0x0028
            int r2 = com.travel.train.R.id.nps_review_point
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x0029
        L_0x0028:
            r1 = 0
        L_0x0029:
            if (r1 == 0) goto L_0x0067
            r1.setSelected(r6)
            java.lang.String r2 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
            r3 = 0
            if (r6 == 0) goto L_0x004b
            android.graphics.drawable.Drawable r6 = r1.getBackground()
            if (r6 == 0) goto L_0x0045
            android.graphics.drawable.GradientDrawable r6 = (android.graphics.drawable.GradientDrawable) r6
            int r0 = r0.getColor(r5, r3)
            android.graphics.PorterDuff$Mode r1 = android.graphics.PorterDuff.Mode.SRC_OVER
            r6.setColorFilter(r0, r1)
            goto L_0x005e
        L_0x0045:
            kotlin.u r4 = new kotlin.u
            r4.<init>(r2)
            throw r4
        L_0x004b:
            android.graphics.drawable.Drawable r6 = r1.getBackground()
            if (r6 == 0) goto L_0x0061
            android.graphics.drawable.GradientDrawable r6 = (android.graphics.drawable.GradientDrawable) r6
            r1 = 11
            int r0 = r0.getColor(r1, r3)
            android.graphics.PorterDuff$Mode r1 = android.graphics.PorterDuff.Mode.OVERLAY
            r6.setColorFilter(r0, r1)
        L_0x005e:
            r4.f27183b = r5
            return
        L_0x0061:
            kotlin.u r4 = new kotlin.u
            r4.<init>(r2)
            throw r4
        L_0x0067:
            kotlin.u r4 = new kotlin.u
            java.lang.String r5 = "null cannot be cast to non-null type android.widget.TextView"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.v.a(com.travel.train.fragment.v, int, boolean):void");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f27184d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static final v a(Bundle bundle) {
        k.c(bundle, "bundle");
        v vVar = new v();
        vVar.setArguments(bundle);
        return vVar;
    }
}
