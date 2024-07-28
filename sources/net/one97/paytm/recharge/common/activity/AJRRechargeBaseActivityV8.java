package net.one97.paytm.recharge.common.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ae;
import net.one97.paytm.recharge.common.utils.ap;
import net.one97.paytm.recharge.common.utils.as;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.bc;
import net.one97.paytm.recharge.common.utils.c;
import net.one97.paytm.recharge.common.utils.z;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.v4.CJRInstruct;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public abstract class AJRRechargeBaseActivityV8 extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f60775a;

    public View a(int i2) {
        if (this.f60775a == null) {
            this.f60775a = new HashMap();
        }
        View view = (View) this.f60775a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f60775a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void a(CJRInstruct cJRInstruct) {
    }

    public void c() {
    }

    public void attachBaseContext(Context context) {
        k.c(context, "newBase");
        super.attachBaseContext(CJRRechargeUtilities.INSTANCE.getRestringValue(context));
    }

    public void onCreate(Bundle bundle) {
        b.e((Activity) this);
        super.onCreate(bundle);
        int a2 = a();
        if (a2 != -1) {
            setTheme(a2);
        }
    }

    public int a() {
        return R.style.Recharge_NoTitle;
    }

    public void a(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.b(true);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Integer valueOf = menuItem != null ? Integer.valueOf(menuItem.getItemId()) : null;
        if (valueOf == null || valueOf.intValue() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void a(String str, NetworkCustomError networkCustomError, Object obj) {
        CJRRechargeErrorModel cJRRechargeErrorModel;
        ACTION_TYPE action_type;
        ERROR_TYPE error_type;
        CJRRechargeErrorModel cJRRechargeErrorModel2;
        ACTION_TYPE action_type2;
        CJRRechargeErrorModel cJRRechargeErrorModel3;
        ACTION_TYPE action_type3;
        c();
        String str2 = null;
        if (networkCustomError instanceof ap) {
            if (obj instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel4 = (CJRRechargeErrorModel) obj;
                cJRRechargeErrorModel4.setErrorType(ERROR_TYPE.INVALID_URL);
                CRUFlowModel flowName = cJRRechargeErrorModel4.getFlowName();
                if (flowName != null) {
                    flowName.setErrorType(ERROR_TYPE.INVALID_URL.name());
                }
                ACTION_TYPE.Companion companion = ACTION_TYPE.Companion;
                CRUFlowModel flowName2 = cJRRechargeErrorModel4.getFlowName();
                if (flowName2 != null) {
                    str2 = flowName2.getActionType();
                }
                cJRRechargeErrorModel3 = cJRRechargeErrorModel4;
                action_type3 = companion.getActionType(str2, ACTION_TYPE.UNDEFINED);
            } else {
                action_type3 = null;
                cJRRechargeErrorModel3 = null;
            }
            az azVar = az.f61525a;
            az.a((Context) this, ERROR_TYPE.INVALID_URL, action_type3, getString(R.string.error), getString(R.string.msg_invalid_url), false, cJRRechargeErrorModel3, false, 1504);
        } else if (networkCustomError instanceof as) {
            if (obj instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel5 = (CJRRechargeErrorModel) obj;
                cJRRechargeErrorModel5.setErrorType(ERROR_TYPE.NO_CONNECTION);
                CRUFlowModel flowName3 = cJRRechargeErrorModel5.getFlowName();
                if (flowName3 != null) {
                    flowName3.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
                }
                ACTION_TYPE.Companion companion2 = ACTION_TYPE.Companion;
                CRUFlowModel flowName4 = cJRRechargeErrorModel5.getFlowName();
                if (flowName4 != null) {
                    str2 = flowName4.getActionType();
                }
                cJRRechargeErrorModel2 = cJRRechargeErrorModel5;
                action_type2 = companion2.getActionType(str2, ACTION_TYPE.UNDEFINED);
            } else {
                action_type2 = null;
                cJRRechargeErrorModel2 = null;
            }
            az azVar2 = az.f61525a;
            az.a((Context) this, ERROR_TYPE.NO_CONNECTION, action_type2, getString(R.string.no_connection), getString(R.string.no_internet), false, cJRRechargeErrorModel2, false, 1504);
        } else if (networkCustomError instanceof bc) {
            CJRRechargeUtilities.INSTANCE.showSessionTimeoutAlert(this, (String) null, (Bundle) null, ((bc) networkCustomError).getError());
        } else if (networkCustomError instanceof c) {
            z.a((Activity) this);
        } else if (networkCustomError instanceof ae) {
            if (obj instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel6 = (CJRRechargeErrorModel) obj;
                ACTION_TYPE.Companion companion3 = ACTION_TYPE.Companion;
                CRUFlowModel flowName5 = cJRRechargeErrorModel6.getFlowName();
                if (flowName5 != null) {
                    str2 = flowName5.getActionType();
                }
                cJRRechargeErrorModel = cJRRechargeErrorModel6;
                action_type = companion3.getActionType(str2, ACTION_TYPE.UNDEFINED);
            } else {
                action_type = null;
                cJRRechargeErrorModel = null;
            }
            az azVar3 = az.f61525a;
            Context context = this;
            if (cJRRechargeErrorModel == null || (error_type = cJRRechargeErrorModel.getErrorType()) == null) {
                error_type = ERROR_TYPE.UNDEFINED;
            }
            ae aeVar = (ae) networkCustomError;
            az.a(context, error_type, action_type, aeVar.getTitle(), aeVar.getAlertMessageText(), false, cJRRechargeErrorModel, false, 1504);
        } else if (networkCustomError instanceof NetworkCustomError) {
            q.d(networkCustomError.getMessage());
            CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, str, this, (Fragment) null, networkCustomError, false, 0, obj, 52, (Object) null);
        }
    }

    public static void a(Bundle bundle) {
        if (bundle != null && bundle.containsKey("android:support:fragments")) {
            bundle.remove("android:support:fragments");
        }
    }
}
