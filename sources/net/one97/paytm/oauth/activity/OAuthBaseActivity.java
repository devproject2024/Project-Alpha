package net.one97.paytm.oauth.activity;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.CheckBox;
import android.widget.TextView;
import com.business.merchant_payments.utility.StringUtility;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.a;
import net.one97.paytm.oauth.utils.d;

public class OAuthBaseActivity extends PaytmActivity {
    public void attachBaseContext(Context context) {
        super.attachBaseContext(OauthModule.b().getLocalisedContext(context));
    }

    public final void a(TextView textView) {
        String str;
        if (textView != null) {
            String string = getString(R.string.tnc_txt_login_new);
            String string2 = getString(R.string.privacy_txt_login_new);
            a.a();
            if (a.a("oauthComsTermsConditions", true)) {
                str = getString(R.string.terms_and_conditions_contact_sdk_sync_version, new Object[]{string, string2});
            } else {
                str = getString(R.string.lbl_terms_and_conditions_new, new Object[]{string, string2});
            }
            String str2 = str;
            int indexOf = str2.indexOf(string);
            int indexOf2 = str2.indexOf(string2);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setHighlightColor(0);
            SpannableString spannableString = new SpannableString(str2);
            a(spannableString, string, true, indexOf, str2.length());
            a(spannableString, string2, false, indexOf2, str2.length());
            textView.setText(spannableString);
        }
    }

    private void a(Spannable spannable, String str, boolean z, int i2, int i3) {
        if (i2 > 0 && str.length() + i2 <= i3) {
            spannable.setSpan(str, i2, str.length() + i2, 33);
            spannable.setSpan(new d(str, z, this), i2, str.length() + i2, 33);
            spannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.paytm_blue)), i2, str.length() + i2, 33);
        }
    }

    public final void a(CheckBox checkBox) {
        String string = getString(R.string.check_box_log_out_heading);
        String string2 = getString(R.string.check_box_log_out_subheading);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + StringUtility.NEW_LINE + string2);
        StyleSpan styleSpan = new StyleSpan(1);
        StyleSpan styleSpan2 = new StyleSpan(0);
        spannableStringBuilder.setSpan(styleSpan, 0, string.length(), 18);
        spannableStringBuilder.setSpan(styleSpan2, string.length(), string.length() + string2.length(), 18);
        checkBox.setText(spannableStringBuilder);
    }

    public static void a(Boolean bool, CheckBox checkBox) {
        checkBox.setChecked(bool.booleanValue());
    }
}
