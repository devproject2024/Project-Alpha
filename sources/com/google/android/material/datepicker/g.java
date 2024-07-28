package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.a.a.a;
import androidx.core.h.u;
import androidx.fragment.app.b;
import androidx.fragment.app.q;
import com.google.android.material.R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.k.h;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class g<S> extends b {

    /* renamed from: a  reason: collision with root package name */
    static final Object f36228a = "CONFIRM_BUTTON_TAG";

    /* renamed from: b  reason: collision with root package name */
    static final Object f36229b = "CANCEL_BUTTON_TAG";

    /* renamed from: c  reason: collision with root package name */
    static final Object f36230c = "TOGGLE_BUTTON_TAG";
    /* access modifiers changed from: package-private */

    /* renamed from: d  reason: collision with root package name */
    public DateSelector<S> f36231d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final LinkedHashSet<Object<? super S>> f36232e = new LinkedHashSet<>();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final LinkedHashSet<View.OnClickListener> f36233f = new LinkedHashSet<>();

    /* renamed from: g  reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnCancelListener> f36234g = new LinkedHashSet<>();

    /* renamed from: h  reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnDismissListener> f36235h = new LinkedHashSet<>();

    /* renamed from: i  reason: collision with root package name */
    private int f36236i;
    private l<S> j;
    private CalendarConstraints k;
    private f<S> l;
    private int m;
    private CharSequence n;
    private boolean o;
    private int p;
    private TextView q;
    /* access modifiers changed from: private */
    public CheckableImageButton r;
    private h s;
    /* access modifiers changed from: private */
    public Button t;

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f36236i);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f36231d);
        CalendarConstraints.a aVar = new CalendarConstraints.a(this.k);
        if (this.l.f36207g != null) {
            aVar.f36147e = Long.valueOf(this.l.f36207g.f36160g);
        }
        if (aVar.f36147e == null) {
            long j2 = Month.a().f36160g;
            if (aVar.f36145c > j2 || j2 > aVar.f36146d) {
                j2 = aVar.f36145c;
            }
            aVar.f36147e = Long.valueOf(j2);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", aVar.f36148f);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new CalendarConstraints(Month.a(aVar.f36145c), Month.a(aVar.f36146d), Month.a(aVar.f36147e.longValue()), (CalendarConstraints.DateValidator) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY"), (byte) 0));
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.m);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.n);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f36236i = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f36231d = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.k = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.m = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.n = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.p = bundle.getInt("INPUT_MODE_KEY");
    }

    private int b(Context context) {
        int i2 = this.f36236i;
        if (i2 != 0) {
            return i2;
        }
        return this.f36231d.b(context);
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), b(requireContext()));
        Context context = dialog.getContext();
        this.o = a(context);
        int a2 = com.google.android.material.h.b.a(context, R.attr.colorSurface, g.class.getCanonicalName());
        this.s = new h(context, (AttributeSet) null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        this.s.a(context);
        this.s.g(ColorStateList.valueOf(a2));
        this.s.r(u.v(dialog.getWindow().getDecorView()));
        return dialog;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(this.o ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        if (this.o) {
            inflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(c(context), -2));
        } else {
            View findViewById = inflate.findViewById(R.id.mtrl_calendar_main_pane);
            View findViewById2 = inflate.findViewById(R.id.mtrl_calendar_frame);
            findViewById.setLayoutParams(new LinearLayout.LayoutParams(c(context), -1));
            Resources resources = requireContext().getResources();
            findViewById2.setMinimumHeight(resources.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height) + (i.f36244a * resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height)) + ((i.f36244a - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding));
        }
        this.q = (TextView) inflate.findViewById(R.id.mtrl_picker_header_selection_text);
        u.l(this.q);
        this.r = (CheckableImageButton) inflate.findViewById(R.id.mtrl_picker_header_toggle);
        TextView textView = (TextView) inflate.findViewById(R.id.mtrl_picker_title_text);
        CharSequence charSequence = this.n;
        if (charSequence != null) {
            textView.setText(charSequence);
        } else {
            textView.setText(this.m);
        }
        this.r.setTag(f36230c);
        CheckableImageButton checkableImageButton = this.r;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, a.b(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], a.b(context, R.drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.r.setChecked(this.p != 0);
        u.a((View) this.r, (androidx.core.h.a) null);
        a(this.r);
        this.r.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                g.this.t.setEnabled(g.this.f36231d.b());
                g.this.r.toggle();
                g gVar = g.this;
                gVar.a(gVar.r);
                g.this.b();
            }
        });
        this.t = (Button) inflate.findViewById(R.id.confirm_button);
        if (this.f36231d.b()) {
            this.t.setEnabled(true);
        } else {
            this.t.setEnabled(false);
        }
        this.t.setTag(f36228a);
        this.t.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Iterator it2 = g.this.f36232e.iterator();
                while (it2.hasNext()) {
                    it2.next();
                    g.this.f36231d.a();
                }
                g.this.dismiss();
            }
        });
        Button button = (Button) inflate.findViewById(R.id.cancel_button);
        button.setTag(f36229b);
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Iterator it2 = g.this.f36233f.iterator();
                while (it2.hasNext()) {
                    ((View.OnClickListener) it2.next()).onClick(view);
                }
                g.this.dismiss();
            }
        });
        return inflate;
    }

    public final void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.o) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.s);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable(this.s, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new com.google.android.material.c.a(requireDialog(), rect));
        }
        b();
    }

    public final void onStop() {
        this.j.b();
        super.onStop();
    }

    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it2 = this.f36234g.iterator();
        while (it2.hasNext()) {
            ((DialogInterface.OnCancelListener) it2.next()).onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it2 = this.f36235h.iterator();
        while (it2.hasNext()) {
            ((DialogInterface.OnDismissListener) it2.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    /* access modifiers changed from: private */
    public void b() {
        this.l = f.a(this.f36231d, b(requireContext()), this.k);
        this.j = this.r.isChecked() ? h.a(this.f36231d, this.k) : this.l;
        a();
        q a2 = getChildFragmentManager().a();
        a2.b(R.id.mtrl_calendar_frame, this.j, (String) null);
        a2.d();
        this.j.a(new k<S>() {
            public final void a(S s) {
                g.this.a();
                g.this.t.setEnabled(g.this.f36231d.b());
            }

            /* access modifiers changed from: package-private */
            public final void a() {
                g.this.t.setEnabled(false);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(CheckableImageButton checkableImageButton) {
        String str;
        if (this.r.isChecked()) {
            str = checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode);
        } else {
            str = checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode);
        }
        this.r.setContentDescription(str);
    }

    static boolean a(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(com.google.android.material.h.b.a(context, R.attr.materialCalendarStyle, f.class.getCanonicalName()), new int[]{16843277});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    private static int c(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        int i2 = Month.a().f36158e;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * i2) + ((i2 - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding));
    }

    /* access modifiers changed from: private */
    public void a() {
        String a2 = this.f36231d.a(getContext());
        this.q.setContentDescription(String.format(getString(R.string.mtrl_picker_announce_current_selection), new Object[]{a2}));
        this.q.setText(a2);
    }
}
