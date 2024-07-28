package net.one97.paytm.oauth.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import androidx.core.content.b;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.h;
import net.one97.paytm.oauth.utils.u;

public final class PasswordStrengthLayout extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f56842a;

    public PasswordStrengthLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public PasswordStrengthLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    private View a(int i2) {
        if (this.f56842a == null) {
            this.f56842a = new HashMap();
        }
        View view = (View) this.f56842a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f56842a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PasswordStrengthLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        View a2 = h.a(this, R.layout.layout_password_strength);
        a2.setId(View.generateViewId());
        c cVar = new c();
        addView(a2);
        cVar.b((ConstraintLayout) this);
        h.a(cVar, a2, this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PasswordStrengthLayout(Context context, AttributeSet attributeSet, int i2, int i3, g gVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final void a(String str) {
        RoboTextView roboTextView;
        k.c(str, "password");
        if (str.length() == 0) {
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.txtPwdStrength);
            if (roboTextView2 != null) {
                roboTextView2.setText("--");
            }
            RoboTextView roboTextView3 = (RoboTextView) a(R.id.txtPwdStrength);
            if (roboTextView3 != null) {
                roboTextView3.setTextColor(b.c(getContext(), net.one97.paytm.common.assets.R.color.color_999999));
            }
            a();
            return;
        }
        u.a aVar = u.Companion;
        u a2 = u.a.a(str);
        int i2 = c.f56854a[a2.ordinal()];
        if (i2 == 1) {
            RoboTextView roboTextView4 = (RoboTextView) a(R.id.txtPwdStrength);
            if (roboTextView4 != null) {
                roboTextView4.setText(getContext().getString(R.string.lbl_strength_weak));
            }
        } else if (i2 == 2) {
            RoboTextView roboTextView5 = (RoboTextView) a(R.id.txtPwdStrength);
            if (roboTextView5 != null) {
                roboTextView5.setText(getContext().getString(R.string.lbl_strength_average));
            }
        } else if (i2 == 3 && (roboTextView = (RoboTextView) a(R.id.txtPwdStrength)) != null) {
            roboTextView.setText(getContext().getString(R.string.lbl_strength_strong));
        }
        RoboTextView roboTextView6 = (RoboTextView) a(R.id.txtPwdStrength);
        if (roboTextView6 != null) {
            roboTextView6.setTextColor(a2.getColor());
        }
        if (str.length() >= 5) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imgCharacters);
            if (appCompatImageView != null) {
                appCompatImageView.setBackgroundResource(R.drawable.pwd_strength_active_bg);
            }
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) a(R.id.imgCharacters);
            if (appCompatImageView2 != null) {
                appCompatImageView2.setImageResource(R.drawable.ic_vector_check_green);
            }
        } else {
            AppCompatImageView appCompatImageView3 = (AppCompatImageView) a(R.id.imgCharacters);
            if (appCompatImageView3 != null) {
                appCompatImageView3.setBackgroundResource(R.drawable.pwd_strength_inactive_bg);
            }
            AppCompatImageView appCompatImageView4 = (AppCompatImageView) a(R.id.imgCharacters);
            if (appCompatImageView4 != null) {
                appCompatImageView4.setImageResource(R.drawable.ic_vector_check_grey);
            }
        }
        u.a aVar2 = u.Companion;
        if (u.containsSpecial) {
            AppCompatImageView appCompatImageView5 = (AppCompatImageView) a(R.id.imgSplCharacters);
            if (appCompatImageView5 != null) {
                appCompatImageView5.setBackgroundResource(R.drawable.pwd_strength_active_bg);
            }
            AppCompatImageView appCompatImageView6 = (AppCompatImageView) a(R.id.imgSplCharacters);
            if (appCompatImageView6 != null) {
                appCompatImageView6.setImageResource(R.drawable.ic_vector_check_green);
            }
        } else {
            AppCompatImageView appCompatImageView7 = (AppCompatImageView) a(R.id.imgSplCharacters);
            if (appCompatImageView7 != null) {
                appCompatImageView7.setBackgroundResource(R.drawable.pwd_strength_inactive_bg);
            }
            AppCompatImageView appCompatImageView8 = (AppCompatImageView) a(R.id.imgSplCharacters);
            if (appCompatImageView8 != null) {
                appCompatImageView8.setImageResource(R.drawable.ic_vector_check_grey);
            }
        }
        u.a aVar3 = u.Companion;
        if (u.containsAlphabet) {
            AppCompatImageView appCompatImageView9 = (AppCompatImageView) a(R.id.imgAlphabet);
            if (appCompatImageView9 != null) {
                appCompatImageView9.setBackgroundResource(R.drawable.pwd_strength_active_bg);
            }
            AppCompatImageView appCompatImageView10 = (AppCompatImageView) a(R.id.imgAlphabet);
            if (appCompatImageView10 != null) {
                appCompatImageView10.setImageResource(R.drawable.ic_vector_check_green);
            }
        } else {
            AppCompatImageView appCompatImageView11 = (AppCompatImageView) a(R.id.imgAlphabet);
            if (appCompatImageView11 != null) {
                appCompatImageView11.setBackgroundResource(R.drawable.pwd_strength_inactive_bg);
            }
            AppCompatImageView appCompatImageView12 = (AppCompatImageView) a(R.id.imgAlphabet);
            if (appCompatImageView12 != null) {
                appCompatImageView12.setImageResource(R.drawable.ic_vector_check_grey);
            }
        }
        u.a aVar4 = u.Companion;
        if (u.containsDigit) {
            AppCompatImageView appCompatImageView13 = (AppCompatImageView) a(R.id.imgNumeric);
            if (appCompatImageView13 != null) {
                appCompatImageView13.setBackgroundResource(R.drawable.pwd_strength_active_bg);
            }
            AppCompatImageView appCompatImageView14 = (AppCompatImageView) a(R.id.imgNumeric);
            if (appCompatImageView14 != null) {
                appCompatImageView14.setImageResource(R.drawable.ic_vector_check_green);
                return;
            }
            return;
        }
        AppCompatImageView appCompatImageView15 = (AppCompatImageView) a(R.id.imgNumeric);
        if (appCompatImageView15 != null) {
            appCompatImageView15.setBackgroundResource(R.drawable.pwd_strength_inactive_bg);
        }
        AppCompatImageView appCompatImageView16 = (AppCompatImageView) a(R.id.imgNumeric);
        if (appCompatImageView16 != null) {
            appCompatImageView16.setImageResource(R.drawable.ic_vector_check_grey);
        }
    }

    private final void a() {
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imgCharacters);
        if (appCompatImageView != null) {
            appCompatImageView.setBackgroundResource(R.drawable.pwd_strength_inactive_bg);
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) a(R.id.imgCharacters);
        if (appCompatImageView2 != null) {
            appCompatImageView2.setImageResource(R.drawable.ic_vector_check_grey);
        }
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) a(R.id.imgSplCharacters);
        if (appCompatImageView3 != null) {
            appCompatImageView3.setBackgroundResource(R.drawable.pwd_strength_inactive_bg);
        }
        AppCompatImageView appCompatImageView4 = (AppCompatImageView) a(R.id.imgSplCharacters);
        if (appCompatImageView4 != null) {
            appCompatImageView4.setImageResource(R.drawable.ic_vector_check_grey);
        }
        AppCompatImageView appCompatImageView5 = (AppCompatImageView) a(R.id.imgAlphabet);
        if (appCompatImageView5 != null) {
            appCompatImageView5.setBackgroundResource(R.drawable.pwd_strength_inactive_bg);
        }
        AppCompatImageView appCompatImageView6 = (AppCompatImageView) a(R.id.imgAlphabet);
        if (appCompatImageView6 != null) {
            appCompatImageView6.setImageResource(R.drawable.ic_vector_check_grey);
        }
        AppCompatImageView appCompatImageView7 = (AppCompatImageView) a(R.id.imgNumeric);
        if (appCompatImageView7 != null) {
            appCompatImageView7.setBackgroundResource(R.drawable.pwd_strength_inactive_bg);
        }
        AppCompatImageView appCompatImageView8 = (AppCompatImageView) a(R.id.imgNumeric);
        if (appCompatImageView8 != null) {
            appCompatImageView8.setImageResource(R.drawable.ic_vector_check_grey);
        }
    }

    public final String getPasswordStrengthText() {
        RoboTextView roboTextView = (RoboTextView) a(R.id.txtPwdStrength);
        return String.valueOf(roboTextView != null ? roboTextView.getText() : null);
    }
}
