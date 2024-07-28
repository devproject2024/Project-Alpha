package net.one97.paytm.recharge.common.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.paytm.network.a;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ap;
import net.one97.paytm.recharge.common.utils.as;
import net.one97.paytm.recharge.common.utils.av;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.bc;
import net.one97.paytm.recharge.common.utils.bd;
import net.one97.paytm.recharge.common.utils.t;
import net.one97.paytm.recharge.common.utils.z;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRInstruct;
import net.one97.paytm.recharge.model.v4.CJRRechargeAlertItemMapper;
import net.one97.paytm.recharge.model.v4.ErrorAction;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.upi.util.UpiConstants;

public abstract class FJRRechargeUtilBaseFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    protected net.one97.paytm.recharge.common.h.b f61109a;

    /* renamed from: b  reason: collision with root package name */
    protected t f61110b;

    /* renamed from: c  reason: collision with root package name */
    String f61111c = "";

    /* renamed from: d  reason: collision with root package name */
    boolean f61112d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f61113e;

    /* renamed from: f  reason: collision with root package name */
    private String f61114f = "";

    /* renamed from: g  reason: collision with root package name */
    private boolean f61115g;

    /* renamed from: h  reason: collision with root package name */
    private a f61116h = new a(-1, -1, (Intent) null);

    /* renamed from: i  reason: collision with root package name */
    private HashMap f61117i;

    public abstract void a(ErrorAction errorAction);

    public boolean a(int i2, int i3, Intent intent) {
        return false;
    }

    public View b(int i2) {
        if (this.f61117i == null) {
            this.f61117i = new HashMap();
        }
        View view = (View) this.f61117i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f61117i.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public abstract void l();

    public abstract String m();

    public abstract String n();

    public boolean o() {
        return false;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        u();
    }

    public abstract String p();

    public abstract Map<String, Object> q();

    public abstract String r();

    public abstract String s();

    public void t() {
    }

    public void u() {
        HashMap hashMap = this.f61117i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(net.one97.paytm.recharge.common.h.b bVar) {
        k.c(bVar, "<set-?>");
        this.f61109a = bVar;
    }

    /* access modifiers changed from: protected */
    public final net.one97.paytm.recharge.common.h.b i() {
        net.one97.paytm.recharge.common.h.b bVar = this.f61109a;
        if (bVar == null) {
            k.a("baseViewModel");
        }
        return bVar;
    }

    public void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            k.a((Object) activity, "this");
            this.f61110b = new t(activity);
        }
    }

    public final void j() {
        t tVar;
        if (!isDetached() && (tVar = this.f61110b) != null) {
            tVar.a();
        }
    }

    public final void k() {
        StringBuilder sb;
        String str;
        net.one97.paytm.recharge.common.h.b bVar = this.f61109a;
        if (bVar == null) {
            k.a("baseViewModel");
        }
        CJRItem cJRItem = bVar.r;
        String name = cJRItem.getName();
        if (name != null && (!p.a(name))) {
            String name2 = cJRItem.getName();
            if (name2 == null) {
                name2 = "";
            }
            this.f61111c = name2;
            String name3 = cJRItem.getName();
            if (name3 == null || !p.a((CharSequence) name3, (CharSequence) "Landline", false)) {
                sb = new StringBuilder("utilities_");
                String name4 = cJRItem.getName();
                if (name4 == null) {
                    str = null;
                } else if (name4 != null) {
                    str = name4.toLowerCase();
                    k.a((Object) str, "(this as java.lang.String).toLowerCase()");
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                StringBuilder sb2 = new StringBuilder("utilities_");
                String lowerCase = "Landline".toLowerCase();
                k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                String str2 = lowerCase;
                sb = sb2;
                str = str2;
            }
            sb.append(str);
            this.f61114f = sb.toString();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.f61116h = new a(i3, i2, intent);
        this.f61115g = true;
    }

    public void onResume() {
        super.onResume();
        if (this.f61115g) {
            this.f61115g = false;
            a(this.f61116h.f61120b, this.f61116h.f61119a, this.f61116h.f61121c);
        }
    }

    public void a(String str, TextView textView, TextView textView2) {
        k.c(textView, "readMoreView");
        k.c(textView2, "descriptionView");
        net.one97.paytm.recharge.common.h.b bVar = this.f61109a;
        if (bVar == null) {
            k.a("baseViewModel");
        }
        if (!bVar.f61411d) {
            CharSequence charSequence = str;
            boolean z = true;
            if (!(charSequence == null || p.a(charSequence))) {
                textView2.setText(charSequence);
                CharSequence obj = textView2.getText().toString();
                if (p.a(obj, (CharSequence) "g.co/playtermsin", false)) {
                    int a2 = p.a(obj, "g.co/playtermsin", 0, false, 6);
                    textView2.setMovementMethod(LinkMovementMethod.getInstance());
                    CharSequence text = textView2.getText();
                    if (text != null) {
                        Spannable spannable = (Spannable) text;
                        int i2 = 16 + a2;
                        spannable.setSpan(new ExpandedURLSpanNoUnderline(this, "g.co/playtermsin"), a2, i2, 33);
                        Context context = getContext();
                        if (context == null) {
                            k.a();
                        }
                        spannable.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context, R.color.paytm_blue)), a2, i2, 33);
                    } else {
                        throw new u("null cannot be cast to non-null type android.text.Spannable");
                    }
                }
                textView2.setMaxLines(2);
                textView2.setVisibility(0);
                textView2.postDelayed(new d(textView2, textView), 300);
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
                net.one97.paytm.recharge.common.h.b bVar2 = this.f61109a;
                if (bVar2 == null) {
                    k.a("baseViewModel");
                }
                CJRCategoryData categoryData = bVar2.f61409b.getCategoryData();
                String str2 = null;
                CharSequence disclaimerHtml = categoryData != null ? categoryData.getDisclaimerHtml() : null;
                if (disclaimerHtml != null && !p.a(disclaimerHtml)) {
                    z = false;
                }
                if (z) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    if (categoryData != null) {
                        str2 = categoryData.getDisclaimerHtml();
                    }
                    textView2.setText(Html.fromHtml(str2, 0));
                    return;
                }
                if (categoryData != null) {
                    str2 = categoryData.getDisclaimerHtml();
                }
                textView2.setText(Html.fromHtml(str2));
                return;
            }
            textView2.setVisibility(8);
            textView.setVisibility(8);
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f61124a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextView f61125b;

        d(TextView textView, TextView textView2) {
            this.f61124a = textView;
            this.f61125b = textView2;
        }

        public final void run() {
            if (this.f61124a.getLineCount() > 2) {
                this.f61125b.setVisibility(0);
                this.f61125b.setOnClickListener(new View.OnClickListener(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ d f61126a;

                    {
                        this.f61126a = r1;
                    }

                    public final void onClick(View view) {
                        this.f61126a.f61124a.setMaxLines(Integer.MAX_VALUE);
                        this.f61126a.f61125b.setVisibility(8);
                    }
                });
                TextView textView = this.f61125b;
                textView.setPaintFlags(8 | textView.getPaintFlags());
                return;
            }
            this.f61125b.setVisibility(8);
        }
    }

    public void a(String str, CJRRechargeCart cJRRechargeCart, String str2, Boolean bool, String str3, String str4) {
        if (getActivity() != null) {
            net.one97.paytm.recharge.common.utils.a aVar = net.one97.paytm.recharge.common.utils.a.f61493a;
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            Activity activity2 = activity;
            String str5 = str == null ? "" : str;
            String str6 = this.f61111c;
            net.one97.paytm.recharge.common.h.b bVar = this.f61109a;
            if (bVar == null) {
                k.a("baseViewModel");
            }
            CJRCategoryData categoryData = bVar.f61409b.getCategoryData();
            net.one97.paytm.recharge.common.utils.a.a(activity2, str5, cJRRechargeCart, (Class) null, bool, str2, str6, categoryData != null ? categoryData.getGAEventCategory() : null, p(), m(), n(), (String) null, (Boolean) null, Boolean.valueOf(o()), 28744);
        }
    }

    public void a(String str, CJRRechargeCart cJRRechargeCart, CJRRechargePayment cJRRechargePayment, Object obj) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            net.one97.paytm.recharge.common.utils.a aVar = net.one97.paytm.recharge.common.utils.a.f61493a;
            k.a((Object) activity, "it");
            Activity activity2 = activity;
            if (str == null) {
                str = "";
            }
            net.one97.paytm.recharge.common.utils.a.a(activity2, str, cJRRechargeCart, cJRRechargePayment, q(), (Class<?>) null, obj, false);
        }
    }

    public void a(CJRRechargePayment cJRRechargePayment, CJRRechargeCart cJRRechargeCart, Object obj) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            net.one97.paytm.recharge.common.utils.a aVar = net.one97.paytm.recharge.common.utils.a.f61493a;
            k.a((Object) activity, "it");
            net.one97.paytm.recharge.common.utils.a.a((Activity) activity, cJRRechargePayment, cJRRechargeCart, (Map<String, ? extends Object>) q(), obj);
        }
    }

    public void a(CJRInstruct cJRInstruct) {
        if (cJRInstruct instanceof CJRInstruct.showAlertDialog) {
            CJRInstruct.showAlertDialog showalertdialog = (CJRInstruct.showAlertDialog) cJRInstruct;
            String title = showalertdialog.getTitle();
            String message = showalertdialog.getMessage();
            String actionButtonLabel = showalertdialog.getActionButtonLabel();
            ErrorAction action = showalertdialog.getAction();
            Boolean errorInfoDialog = showalertdialog.getErrorInfoDialog();
            a(title, message, actionButtonLabel, action, errorInfoDialog != null ? errorInfoDialog.booleanValue() : false, showalertdialog.getHawkEyeEvent());
        } else if (cJRInstruct instanceof CJRInstruct.openPostOrderSummaryActivity) {
            CJRInstruct.openPostOrderSummaryActivity openpostordersummaryactivity = (CJRInstruct.openPostOrderSummaryActivity) cJRInstruct;
            a(openpostordersummaryactivity.getRechargePayment(), openpostordersummaryactivity.getRechargeCart(), openpostordersummaryactivity.getHawkEyeEvent());
        } else if (cJRInstruct instanceof CJRInstruct.openCouponsActivity) {
            CJRInstruct.openCouponsActivity opencouponsactivity = (CJRInstruct.openCouponsActivity) cJRInstruct;
            a(opencouponsactivity.getCategoryName(), opencouponsactivity.getRechargeCart(), opencouponsactivity.getProtectionUrl(), opencouponsactivity.getDealsFastForward(), opencouponsactivity.getGroupFieldValues(), opencouponsactivity.getDealsMessage());
        } else if (cJRInstruct instanceof CJRInstruct.openRechargePaymentActivity) {
            t();
            CJRInstruct.openRechargePaymentActivity openrechargepaymentactivity = (CJRInstruct.openRechargePaymentActivity) cJRInstruct;
            a(openrechargepaymentactivity.getCategoryName(), openrechargepaymentactivity.getRechargeCart(), openrechargepaymentactivity.getRechargePayment(), openrechargepaymentactivity.getHawkEyeEvent());
        } else if (cJRInstruct instanceof CJRInstruct.openUpdateAppVersionScreen) {
            String appMinVersion = ((CJRInstruct.openUpdateAppVersionScreen) cJRInstruct).getAppMinVersion();
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            StringBuilder sb = new StringBuilder("Show Upgrade with: [min-version-");
            sb.append(appMinVersion == null ? "" : appMinVersion);
            sb.append(']');
            cJRRechargeUtilities.debugLog(sb.toString());
            if (ba.b(appMinVersion, getContext())) {
                Context context = getContext();
                net.one97.paytm.recharge.di.helper.a aVar = net.one97.paytm.recharge.di.helper.a.f62650a;
                Intent intent = new Intent(context, net.one97.paytm.recharge.di.helper.a.d());
                net.one97.paytm.recharge.common.h.b bVar = this.f61109a;
                if (bVar == null) {
                    k.a("baseViewModel");
                }
                intent.putExtra("url_type", bVar.r.getURLType());
                startActivity(intent);
            }
        } else if (cJRInstruct instanceof CJRInstruct.onContainsError) {
            if (getActivity() != null && isAdded()) {
                l();
            }
        } else if (cJRInstruct instanceof CJRInstruct.openSetupAutomaticSelectDurationActivity) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            if (az.c(activity)) {
                FragmentActivity activity2 = getActivity();
                if (activity2 == null) {
                    k.a();
                }
                k.a((Object) activity2, "activity!!");
                String rechargeNumber = ((CJRInstruct.openSetupAutomaticSelectDurationActivity) cJRInstruct).getRecent().getRechargeNumber();
                k.a((Object) rechargeNumber, "cjrInstruct.recent.rechargeNumber");
                az.g(activity2, rechargeNumber);
                return;
            }
            net.one97.paytm.recharge.common.utils.a aVar2 = net.one97.paytm.recharge.common.utils.a.f61493a;
            CJRInstruct.openSetupAutomaticSelectDurationActivity opensetupautomaticselectdurationactivity = (CJRInstruct.openSetupAutomaticSelectDurationActivity) cJRInstruct;
            net.one97.paytm.recharge.common.utils.a.a(opensetupautomaticselectdurationactivity.getFragment(), opensetupautomaticselectdurationactivity.getActivity(), opensetupautomaticselectdurationactivity.getRecent(), opensetupautomaticselectdurationactivity.getExtras());
        } else if (cJRInstruct instanceof CJRInstruct.openManageAutomaticActivity) {
            FragmentActivity activity3 = getActivity();
            if (activity3 == null) {
                k.a();
            }
            if (az.c(activity3)) {
                FragmentActivity activity4 = getActivity();
                if (activity4 == null) {
                    k.a();
                }
                k.a((Object) activity4, "activity!!");
                az.a((Context) activity4, ((CJRInstruct.openManageAutomaticActivity) cJRInstruct).getSubscriptionModel().getSubscriptionId());
                return;
            }
            net.one97.paytm.recharge.common.utils.a aVar3 = net.one97.paytm.recharge.common.utils.a.f61493a;
            CJRInstruct.openManageAutomaticActivity openmanageautomaticactivity = (CJRInstruct.openManageAutomaticActivity) cJRInstruct;
            net.one97.paytm.recharge.common.utils.a.a(openmanageautomaticactivity.getFragment(), openmanageautomaticactivity.getActivity(), openmanageautomaticactivity.getRecent(), openmanageautomaticactivity.getSubscriptionModel(), openmanageautomaticactivity.getExtras());
        }
    }

    public void a(String str, NetworkCustomError networkCustomError, Object obj) {
        StringBuilder journeyStackTrace;
        CRUFlowModel flowName;
        StringBuilder journeyStackTrace2;
        CJRRechargeErrorModel cJRRechargeErrorModel;
        ACTION_TYPE action_type;
        CJRRechargeErrorModel cJRRechargeErrorModel2;
        ACTION_TYPE action_type2;
        NetworkCustomError networkCustomError2 = networkCustomError;
        Object obj2 = obj;
        if (getActivity() != null && isAdded()) {
            l();
            String str2 = null;
            if (networkCustomError2 instanceof ap) {
                if (obj2 instanceof CJRRechargeErrorModel) {
                    CJRRechargeErrorModel cJRRechargeErrorModel3 = (CJRRechargeErrorModel) obj2;
                    cJRRechargeErrorModel3.setErrorType(ERROR_TYPE.INVALID_URL);
                    CRUFlowModel flowName2 = cJRRechargeErrorModel3.getFlowName();
                    if (flowName2 != null) {
                        flowName2.setErrorType(ERROR_TYPE.INVALID_URL.name());
                    }
                    ACTION_TYPE.Companion companion = ACTION_TYPE.Companion;
                    CRUFlowModel flowName3 = cJRRechargeErrorModel3.getFlowName();
                    cJRRechargeErrorModel2 = cJRRechargeErrorModel3;
                    action_type2 = companion.getActionType(flowName3 != null ? flowName3.getActionType() : null, ACTION_TYPE.UNDEFINED);
                } else {
                    action_type2 = null;
                    cJRRechargeErrorModel2 = null;
                }
                az azVar = az.f61525a;
                Context context = getContext();
                ERROR_TYPE error_type = ERROR_TYPE.INVALID_URL;
                Context context2 = getContext();
                String string = context2 != null ? context2.getString(R.string.error) : null;
                Context context3 = getContext();
                if (context3 != null) {
                    str2 = context3.getString(R.string.msg_invalid_url);
                }
                az.a(context, error_type, action_type2, string, str2, false, cJRRechargeErrorModel2, false, 1504);
            } else if (networkCustomError2 instanceof as) {
                if (obj2 instanceof CJRRechargeErrorModel) {
                    CJRRechargeErrorModel cJRRechargeErrorModel4 = (CJRRechargeErrorModel) obj2;
                    cJRRechargeErrorModel4.setErrorType(ERROR_TYPE.NO_CONNECTION);
                    CRUFlowModel flowName4 = cJRRechargeErrorModel4.getFlowName();
                    if (flowName4 != null) {
                        flowName4.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
                    }
                    ACTION_TYPE.Companion companion2 = ACTION_TYPE.Companion;
                    CRUFlowModel flowName5 = cJRRechargeErrorModel4.getFlowName();
                    cJRRechargeErrorModel = cJRRechargeErrorModel4;
                    action_type = companion2.getActionType(flowName5 != null ? flowName5.getActionType() : null, ACTION_TYPE.UNDEFINED);
                } else {
                    action_type = null;
                    cJRRechargeErrorModel = null;
                }
                if (!this.f61112d) {
                    az azVar2 = az.f61525a;
                    Context context4 = getContext();
                    ERROR_TYPE error_type2 = ERROR_TYPE.NO_CONNECTION;
                    Context context5 = getContext();
                    String string2 = context5 != null ? context5.getString(R.string.no_connection) : null;
                    Context context6 = getContext();
                    if (context6 != null) {
                        str2 = context6.getString(R.string.no_internet);
                    }
                    az.a(context4, error_type2, action_type, string2, str2, false, cJRRechargeErrorModel, ((as) networkCustomError2).isFrontEndError(), (int) SDKConstants.ERROR_CODE_480);
                    return;
                }
                az azVar3 = az.f61525a;
                Context context7 = getContext();
                ERROR_TYPE error_type3 = ERROR_TYPE.NO_CONNECTION;
                Context context8 = getContext();
                String string3 = context8 != null ? context8.getString(R.string.no_connection) : null;
                Context context9 = getContext();
                if (context9 != null) {
                    str2 = context9.getString(R.string.no_internet);
                }
                az.a(context7, error_type3, action_type, string3, str2, true, cJRRechargeErrorModel, ((as) networkCustomError2).isFrontEndError(), 448);
            } else if (networkCustomError2 instanceof bc) {
                if (obj2 instanceof CJRRechargeErrorModel) {
                    CJRRechargeErrorModel cJRRechargeErrorModel5 = (CJRRechargeErrorModel) obj2;
                    cJRRechargeErrorModel5.setErrorType(ERROR_TYPE.AUTH);
                    CRUFlowModel flowName6 = cJRRechargeErrorModel5.getFlowName();
                    if (flowName6 != null) {
                        flowName6.setErrorType(ERROR_TYPE.AUTH.name());
                    }
                    CRUFlowModel flowName7 = cJRRechargeErrorModel5.getFlowName();
                    if (flowName7 != null) {
                        flowName7.setAlertType("");
                    }
                    if (!((networkCustomError2 instanceof bd) || (flowName = cJRRechargeErrorModel5.getFlowName()) == null || (journeyStackTrace2 = flowName.getJourneyStackTrace()) == null)) {
                        p.a(journeyStackTrace2);
                    }
                    az azVar4 = az.f61525a;
                    az.a(cJRRechargeErrorModel5);
                }
                CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                Context context10 = getContext();
                if (context10 != null) {
                    cJRRechargeUtilities.showSessionTimeoutAlert((Activity) context10, (String) null, (Bundle) null, ((bc) networkCustomError2).getError());
                    return;
                }
                throw new u("null cannot be cast to non-null type android.app.Activity");
            } else if (networkCustomError2 instanceof net.one97.paytm.recharge.common.utils.c) {
                if (obj2 instanceof CJRRechargeErrorModel) {
                    CJRRechargeErrorModel cJRRechargeErrorModel6 = (CJRRechargeErrorModel) obj2;
                    cJRRechargeErrorModel6.setErrorType(ERROR_TYPE.AUTH);
                    CRUFlowModel flowName8 = cJRRechargeErrorModel6.getFlowName();
                    if (flowName8 != null) {
                        flowName8.setErrorType(ERROR_TYPE.AUTH.name());
                    }
                    CRUFlowModel flowName9 = cJRRechargeErrorModel6.getFlowName();
                    if (flowName9 != null) {
                        flowName9.setAlertType("");
                    }
                    CRUFlowModel flowName10 = cJRRechargeErrorModel6.getFlowName();
                    if (!(flowName10 == null || (journeyStackTrace = flowName10.getJourneyStackTrace()) == null)) {
                        p.a(journeyStackTrace);
                    }
                    if (!(networkCustomError2 instanceof av) || !((av) networkCustomError2).isFrontEndError()) {
                        az azVar5 = az.f61525a;
                        az.a(cJRRechargeErrorModel6);
                    }
                }
                if (networkCustomError2 instanceof av) {
                    z.a((Activity) getActivity(), (Fragment) this, 800);
                } else {
                    z.a((Activity) getActivity(), (Fragment) this, 7);
                }
            } else if (networkCustomError2 instanceof NetworkCustomError) {
                q.d(networkCustomError.getMessage());
                CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, str, getActivity(), this, networkCustomError, false, networkCustomError2 instanceof av ? 800 : 7, obj, 16, (Object) null);
            } else if (obj2 instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel7 = (CJRRechargeErrorModel) obj2;
                cJRRechargeErrorModel7.setErrorType(ERROR_TYPE.UNDEFINED);
                CRUFlowModel flowName11 = cJRRechargeErrorModel7.getFlowName();
                if (flowName11 != null) {
                    flowName11.setErrorType(ERROR_TYPE.UNDEFINED.name());
                }
                CRUFlowModel flowName12 = cJRRechargeErrorModel7.getFlowName();
                if (flowName12 != null) {
                    ACTION_TYPE.Companion companion3 = ACTION_TYPE.Companion;
                    CRUFlowModel flowName13 = cJRRechargeErrorModel7.getFlowName();
                    if (flowName13 != null) {
                        str2 = flowName13.getActionType();
                    }
                    flowName12.setActionType(companion3.getActionType(str2, ACTION_TYPE.UNDEFINED).name());
                }
                CRUFlowModel flowName14 = cJRRechargeErrorModel7.getFlowName();
                if (flowName14 != null) {
                    String str3 = str;
                    flowName14.setTag(str);
                }
                cJRRechargeErrorModel7.setUserFacing(a.b.SILENT);
                az azVar6 = az.f61525a;
                az.a(cJRRechargeErrorModel7);
            }
        }
    }

    public final class ExpandedURLSpanNoUnderline extends URLSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FJRRechargeUtilBaseFragment f61118a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ExpandedURLSpanNoUnderline(FJRRechargeUtilBaseFragment fJRRechargeUtilBaseFragment, String str) {
            super(str);
            k.c(str, "url");
            this.f61118a = fJRRechargeUtilBaseFragment;
        }

        public final void updateDrawState(TextPaint textPaint) {
            k.c(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }

        public final void onClick(View view) {
            k.c(view, "widget");
            FJRRechargeUtilBaseFragment fJRRechargeUtilBaseFragment = this.f61118a;
            net.one97.paytm.recharge.di.helper.a aVar = net.one97.paytm.recharge.di.helper.a.f62650a;
            Intent intent = new Intent(fJRRechargeUtilBaseFragment.getActivity(), net.one97.paytm.recharge.di.helper.a.c());
            intent.putExtra("url", "https://play.google.com/intl/ALL_in/about/card-terms.html");
            intent.putExtra("title", "Google Play");
            intent.putExtra(UpiConstants.FROM, "Auth");
            intent.putExtra("Close", true);
            intent.setFlags(603979776);
            fJRRechargeUtilBaseFragment.startActivity(intent);
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f61119a;

        /* renamed from: b  reason: collision with root package name */
        public final int f61120b;

        /* renamed from: c  reason: collision with root package name */
        final Intent f61121c;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (this.f61119a == aVar.f61119a) {
                        if (!(this.f61120b == aVar.f61120b) || !k.a((Object) this.f61121c, (Object) aVar.f61121c)) {
                            return false;
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            int i2 = ((this.f61119a * 31) + this.f61120b) * 31;
            Intent intent = this.f61121c;
            return i2 + (intent != null ? intent.hashCode() : 0);
        }

        public final String toString() {
            return "TempActivityResult(resultCode=" + this.f61119a + ", requestCode=" + this.f61120b + ", data=" + this.f61121c + ")";
        }

        public a(int i2, int i3, Intent intent) {
            this.f61119a = i2;
            this.f61120b = i3;
            this.f61121c = intent;
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str, String str2, String str3, ErrorAction errorAction, boolean z, Object obj) {
        if (k.a((Object) getString(R.string.unable_to_proceed), (Object) str) && !TextUtils.isEmpty(str2)) {
            str = "utility_hide_title";
        }
        String str4 = str;
        if (getContext() != null && getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            if (!activity.isFinishing()) {
                String s = s();
                if (s == null || s.hashCode() != 927392554 || !s.equals("Bottom Sheet")) {
                    b(str4, str2, str3, errorAction, z, obj);
                } else if (!TextUtils.isEmpty(str2)) {
                    CJRRechargeAlertItemMapper cJRRechargeAlertItemMapper = new CJRRechargeAlertItemMapper();
                    if (str2 == null) {
                        k.a();
                    }
                    new c(cJRRechargeAlertItemMapper.mapFromLPGItem(str2, r()), false, getString(R.string.ok_message), new b(), 2).show(getChildFragmentManager(), "sdc");
                } else {
                    b(str4, str2, str3, errorAction, z, obj);
                }
            }
        }
    }

    public static final class b implements u {
        b() {
        }
    }

    public static final class c implements net.one97.paytm.recharge.legacy.catalog.a.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FJRRechargeUtilBaseFragment f61122a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ErrorAction f61123b;

        c(FJRRechargeUtilBaseFragment fJRRechargeUtilBaseFragment, ErrorAction errorAction) {
            this.f61122a = fJRRechargeUtilBaseFragment;
            this.f61123b = errorAction;
        }

        public final void a() {
            ErrorAction errorAction = this.f61123b;
            if (errorAction != null) {
                this.f61122a.a(errorAction);
            }
            ErrorAction errorAction2 = this.f61123b;
            if ("Action_ProceedOnValidationBlock".equals(errorAction2 != null ? errorAction2.name() : null)) {
                this.f61122a.f61113e = true;
            } else {
                this.f61122a.f61113e = false;
            }
        }
    }

    private void b(String str, String str2, String str3, ErrorAction errorAction, boolean z, Object obj) {
        CJRRechargeErrorModel cJRRechargeErrorModel;
        ACTION_TYPE action_type;
        ERROR_TYPE error_type;
        if (z) {
            ba.a(getContext(), str, str2, str3, (net.one97.paytm.recharge.legacy.catalog.a.a) new c(this, errorAction));
            return;
        }
        String str4 = null;
        if (obj instanceof CJRRechargeErrorModel) {
            CJRRechargeErrorModel cJRRechargeErrorModel2 = (CJRRechargeErrorModel) obj;
            ACTION_TYPE.Companion companion = ACTION_TYPE.Companion;
            CRUFlowModel flowName = cJRRechargeErrorModel2.getFlowName();
            if (flowName != null) {
                str4 = flowName.getActionType();
            }
            cJRRechargeErrorModel = cJRRechargeErrorModel2;
            action_type = companion.getActionType(str4, ACTION_TYPE.UNDEFINED);
        } else {
            action_type = null;
            cJRRechargeErrorModel = null;
        }
        az azVar = az.f61525a;
        Context context = getContext();
        if (cJRRechargeErrorModel == null || (error_type = cJRRechargeErrorModel.getErrorType()) == null) {
            error_type = ERROR_TYPE.UNDEFINED;
        }
        az.a(context, error_type, action_type, str, str2, false, cJRRechargeErrorModel, false, 1504);
    }
}
