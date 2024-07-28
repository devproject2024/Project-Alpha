package net.one97.paytm.passbook.statementDownload;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.Calendar;
import net.one97.paytm.i.f;

public class h extends f {

    /* renamed from: a  reason: collision with root package name */
    a f58704a;

    /* renamed from: b  reason: collision with root package name */
    private RadioGroup f58705b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f58706c;

    /* renamed from: d  reason: collision with root package name */
    private int f58707d;

    /* renamed from: e  reason: collision with root package name */
    private RadioButton f58708e;

    /* renamed from: f  reason: collision with root package name */
    private RadioButton f58709f;

    /* renamed from: g  reason: collision with root package name */
    private RadioButton f58710g;

    /* renamed from: h  reason: collision with root package name */
    private RadioButton f58711h;

    /* renamed from: i  reason: collision with root package name */
    private BottomSheetBehavior.a f58712i = new BottomSheetBehavior.a() {
        public final void onSlide(View view, float f2) {
        }

        public final void onStateChanged(View view, int i2) {
            if (i2 == 5) {
                h.this.dismiss();
            }
        }
    };

    public interface a {
        void a(int i2);
    }

    public h(int i2) {
        this.f58707d = i2;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public h() {
    }

    public Dialog onCreateDialog(Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                BottomSheetBehavior.from((FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet)).setState(3);
            }
        });
        return aVar;
    }

    public void setupDialog(Dialog dialog, int i2) {
        RadioButton radioButton;
        super.setupDialog(dialog, i2);
        View inflate = View.inflate(getContext(), net.one97.paytm.passbook.R.layout.pass_time_selector_dialog, (ViewGroup) null);
        dialog.setContentView(inflate);
        this.f58706c = (ImageView) dialog.findViewById(net.one97.paytm.passbook.R.id.iv_close);
        this.f58705b = (RadioGroup) dialog.findViewById(net.one97.paytm.passbook.R.id.radioGropFilter);
        this.f58708e = (RadioButton) inflate.findViewById(net.one97.paytm.passbook.R.id.last30DaysRbtn);
        this.f58709f = (RadioButton) inflate.findViewById(net.one97.paytm.passbook.R.id.last60DaysRbtn);
        this.f58710g = (RadioButton) inflate.findViewById(net.one97.paytm.passbook.R.id.last90DaysRbtn);
        this.f58711h = (RadioButton) inflate.findViewById(net.one97.paytm.passbook.R.id.lastFYRbtn);
        if (Calendar.getInstance().get(2) > 2) {
            int i3 = Calendar.getInstance().get(1);
            RadioButton radioButton2 = this.f58711h;
            radioButton2.setText("FY " + (Calendar.getInstance().get(1) - 1) + " - " + i3);
        } else {
            int i4 = Calendar.getInstance().get(1) - 1;
            RadioButton radioButton3 = this.f58711h;
            StringBuilder sb = new StringBuilder("FY ");
            sb.append(i4 - 1);
            sb.append(" - ");
            sb.append(i4);
            radioButton3.setText(sb.toString());
        }
        this.f58706c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                h.this.dismiss();
            }
        });
        try {
            ((View) inflate.getParent()).setBackgroundColor(getResources().getColor(17170445));
        } catch (Exception unused) {
        }
        this.f58705b.clearCheck();
        int i5 = this.f58707d;
        if (i5 != -1) {
            if (i5 == 0) {
                radioButton = this.f58708e;
            } else if (i5 == 1) {
                radioButton = this.f58709f;
            } else if (i5 == 2) {
                radioButton = this.f58710g;
            } else {
                radioButton = i5 == 3 ? this.f58711h : null;
            }
            if (radioButton != null) {
                radioButton.setChecked(true);
                radioButton.setTypeface((Typeface) null, 1);
            }
        }
        this.f58705b.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                if (i2 == net.one97.paytm.passbook.R.id.last30DaysRbtn) {
                    h.a(h.this, 0);
                } else if (i2 == net.one97.paytm.passbook.R.id.last60DaysRbtn) {
                    h.a(h.this, 1);
                } else if (i2 == net.one97.paytm.passbook.R.id.last90DaysRbtn) {
                    h.a(h.this, 2);
                } else if (i2 == net.one97.paytm.passbook.R.id.lastFYRbtn) {
                    h.a(h.this, 3);
                } else if (i2 == net.one97.paytm.passbook.R.id.customRbtn) {
                    h.a(h.this, 4);
                }
            }
        });
    }

    static /* synthetic */ void a(h hVar, int i2) {
        hVar.f58704a.a(i2);
        hVar.dismiss();
    }
}
