package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.m;

public class CJRFastForwardWidgetV8 extends ConstraintLayout implements View.OnTouchListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private m f61885a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f61886b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f61887c;

    public View a(int i2) {
        if (this.f61887c == null) {
            this.f61887c = new HashMap();
        }
        View view = (View) this.f61887c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f61887c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void a(Map<String, String> map) {
        k.c(map, "deepLinkParams");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRFastForwardWidgetV8(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(context).inflate(R.layout.v8_content_fast_forward, this, true);
        ((CheckBox) a(R.id.radio_fast_forward)).setOnCheckedChangeListener(this);
        ((CheckBox) a(R.id.radio_fast_forward)).setOnTouchListener(this);
        ((RoboTextView) a(R.id.fast_forward_text)).setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CJRFastForwardWidgetV8 f61888a;

            {
                this.f61888a = r1;
            }

            public final void onClick(View view) {
                this.f61888a.f61886b = true;
                CheckBox checkBox = (CheckBox) this.f61888a.a(R.id.radio_fast_forward);
                if (checkBox != null) {
                    checkBox.toggle();
                }
            }
        });
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRFastForwardWidgetV8(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    public final void setOnCheckChangedListener(m mVar) {
        k.c(mVar, "listener");
        this.f61885a = mVar;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        m mVar = this.f61885a;
        if (mVar != null) {
            mVar.a(z, this.f61886b);
        }
        this.f61886b = false;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f61886b = true;
        return false;
    }

    public final boolean a() {
        CheckBox checkBox = (CheckBox) a(R.id.radio_fast_forward);
        k.a((Object) checkBox, "radio_fast_forward");
        return checkBox.isChecked();
    }

    public final void setFastForwardText(String str) {
        RoboTextView roboTextView = (RoboTextView) a(R.id.fast_forward_text);
        k.a((Object) roboTextView, "fast_forward_text");
        if (str == null) {
            str = "";
        }
        roboTextView.setText(str);
    }

    public final void setFastForwardChecked(boolean z) {
        CheckBox checkBox = (CheckBox) a(R.id.radio_fast_forward);
        k.a((Object) checkBox, "radio_fast_forward");
        checkBox.setChecked(z);
    }

    public final void setFastForwardDescription(String str) {
        RoboTextView roboTextView = (RoboTextView) a(R.id.fast_forward_description);
        k.a((Object) roboTextView, "fast_forward_description");
        roboTextView.setText(str);
    }
}
