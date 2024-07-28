package net.one97.paytm.recharge.creditcard.v4.c;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.al;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.utility.s;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.g.b.ab;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8;
import net.one97.paytm.recharge.creditcard.v4.a;
import net.one97.paytm.recharge.creditcard.v4.a.a;
import net.one97.paytm.recharge.creditcard.v4.b.a;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper;
import net.one97.paytm.recharge.model.v4.Data;
import net.one97.paytm.recharge.ordersummary.c.e;
import net.one97.paytm.recharge.presentation.b.d;
import net.one97.paytm.recharge.widgets.model.CJRTaggedObservable;
import net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView;

public final class c extends Fragment implements PopupMenu.OnMenuItemClickListener, z<CJRTaggedObservable<?>>, a.f, a.b, d.b, net.one97.paytm.recharge.widgets.b.b, net.one97.paytm.smssdk.b.b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f62603a = new a((byte) 0);
    private static final String v;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.recharge.creditcard.c.a f62604b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public net.one97.paytm.recharge.creditcard.v4.a.a f62605c;

    /* renamed from: d  reason: collision with root package name */
    private b f62606d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView.LayoutManager f62607e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f62608f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f62609g;

    /* renamed from: h  reason: collision with root package name */
    private final String f62610h = "credit_card";

    /* renamed from: i  reason: collision with root package name */
    private CJRCreditCardModelV8 f62611i;
    private boolean j;
    private boolean k;
    private final String l = "tag.add.name";
    private final String m = "tag.delete.card";
    private final String n = "tag.stop.bill.reminder";
    private boolean o;
    private boolean p;
    private net.one97.paytm.recharge.creditcard.v4.b.c q;
    private net.one97.paytm.recharge.ordersummary.c.e r;
    private net.one97.paytm.recharge.ordersummary.c.e s;
    private List<CJRCreditCardModelV8> t;
    private CJRCreditCardModelV8 u;
    private HashMap w;

    public final /* synthetic */ void onChanged(Object obj) {
        TextView textView;
        CJRTaggedObservable cJRTaggedObservable = (CJRTaggedObservable) obj;
        Object obj2 = null;
        String tag = cJRTaggedObservable != null ? cJRTaggedObservable.getTag() : null;
        if (tag != null) {
            int hashCode = tag.hashCode();
            if (hashCode != 298132283) {
                if (hashCode != 368755767 || !tag.equals("delete_saved_card_api")) {
                    return;
                }
            } else if (!tag.equals("delete_recent_card_api")) {
                return;
            }
            Object data = cJRTaggedObservable.getData();
            if (!(data instanceof Data)) {
                data = null;
            }
            Data data2 = (Data) data;
            if ((data2 != null ? data2.getDataState() : null) != null) {
                int i2 = d.f62623a[data2.getDataState().ordinal()];
                if (i2 == 1) {
                    this.k = true;
                    net.one97.paytm.recharge.ordersummary.c.e eVar = this.r;
                    if (eVar != null) {
                        Context context = eVar.getContext();
                        if (!(context == null || (textView = (TextView) eVar.a(R.id.positiveBtnTV)) == null)) {
                            textView.setTextColor(androidx.core.content.b.c(context, R.color.white));
                        }
                        net.one97.paytm.recharge.ordersummary.c.e.a((LottieAnimationView) (CJRRechargeLottieAnimationView) eVar.a(R.id.loading_three_dots_lav));
                    }
                } else if (i2 == 2) {
                    net.one97.paytm.recharge.ordersummary.c.e eVar2 = this.r;
                    if (eVar2 != null) {
                        eVar2.a();
                    }
                    net.one97.paytm.recharge.ordersummary.c.e eVar3 = this.r;
                    if (eVar3 != null) {
                        eVar3.dismiss();
                    }
                    RecyclerView recyclerView = this.f62608f;
                    if (recyclerView != null) {
                        recyclerView.postDelayed(new d(this), 200);
                    }
                    net.one97.paytm.recharge.ordersummary.c.e eVar4 = this.r;
                    if (eVar4 != null) {
                        TextView textView2 = (TextView) eVar4.a(R.id.errorMessageTV);
                        if (textView2 != null) {
                            textView2.clearAnimation();
                        }
                        TextView textView3 = (TextView) eVar4.a(R.id.errorMessageTV);
                        if (textView3 != null) {
                            ai.b(textView3);
                        }
                    }
                } else if (i2 == 3) {
                    this.k = false;
                    net.one97.paytm.recharge.ordersummary.c.e eVar5 = this.r;
                    if (eVar5 != null) {
                        String message = data2.getMessage();
                        if (message == null) {
                            message = getString(R.string.some_went_wrong);
                            k.a((Object) message, "getString(R.string.some_went_wrong)");
                        }
                        k.c(message, "errorMsg");
                        eVar5.a();
                        TextView textView4 = (TextView) eVar5.a(R.id.errorMessageTV);
                        if (textView4 != null) {
                            textView4.setText(message);
                            textView4.clearAnimation();
                            TextView textView5 = (TextView) eVar5.a(R.id.errorMessageTV);
                            if (textView5 != null) {
                                ai.a(textView5);
                            }
                            net.one97.paytm.recharge.ordersummary.c.e.a((View) textView4);
                        }
                    }
                }
            }
            if (data2 != null) {
                obj2 = data2.getData();
            }
            if (obj2 != null) {
                this.u = (CJRCreditCardModelV8) data2.getData();
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [androidx.recyclerview.widget.RecyclerView$v] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r6, boolean r7) {
        /*
            r5 = this;
            net.one97.paytm.recharge.creditcard.c.a r0 = r5.f62604b
            java.lang.String r1 = "mViewModel"
            if (r0 != 0) goto L_0x0009
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            int r0 = r0.X
            if (r0 < 0) goto L_0x00bc
            r5.k = r6
            androidx.recyclerview.widget.RecyclerView r0 = r5.f62608f
            if (r0 == 0) goto L_0x0021
            net.one97.paytm.recharge.creditcard.c.a r2 = r5.f62604b
            if (r2 != 0) goto L_0x001a
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x001a:
            int r1 = r2.X
            androidx.recyclerview.widget.RecyclerView$v r0 = r0.findViewHolderForLayoutPosition(r1)
            goto L_0x0022
        L_0x0021:
            r0 = 0
        L_0x0022:
            boolean r1 = r0 instanceof net.one97.paytm.recharge.creditcard.v4.a.a.h
            if (r1 == 0) goto L_0x00bc
            r1 = 0
            r2 = 8
            java.lang.String r3 = "payMoreTV"
            if (r6 == 0) goto L_0x004e
            r6 = r0
            net.one97.paytm.recharge.creditcard.v4.a.a$h r6 = (net.one97.paytm.recharge.creditcard.v4.a.a.h) r6
            android.widget.TextView r4 = r6.f62511d
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            r4.setVisibility(r2)
            net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView r6 = r6.f62510c
            com.airbnb.lottie.LottieAnimationView r6 = (com.airbnb.lottie.LottieAnimationView) r6
            if (r6 == 0) goto L_0x0065
            r6.setVisibility(r1)
            java.lang.String r1 = "Payments-Loader.json"
            r6.setAnimation((java.lang.String) r1)
            r1 = -1
            r6.setRepeatCount(r1)
            r6.playAnimation()
            goto L_0x0065
        L_0x004e:
            r6 = r0
            net.one97.paytm.recharge.creditcard.v4.a.a$h r6 = (net.one97.paytm.recharge.creditcard.v4.a.a.h) r6
            net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView r4 = r6.f62510c
            com.airbnb.lottie.LottieAnimationView r4 = (com.airbnb.lottie.LottieAnimationView) r4
            if (r4 == 0) goto L_0x005d
            r4.cancelAnimation()
            r4.setVisibility(r2)
        L_0x005d:
            android.widget.TextView r6 = r6.f62511d
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
            r6.setVisibility(r1)
        L_0x0065:
            if (r7 == 0) goto L_0x00bc
            net.one97.paytm.recharge.creditcard.v4.a.a$h r0 = (net.one97.paytm.recharge.creditcard.v4.a.a.h) r0
            androidx.constraintlayout.widget.ConstraintLayout r6 = r0.f62512e     // Catch:{ Exception -> 0x00aa }
            android.view.ViewPropertyAnimator r6 = r6.animate()     // Catch:{ Exception -> 0x00aa }
            if (r6 == 0) goto L_0x00a9
            androidx.constraintlayout.widget.ConstraintLayout r7 = r0.f62512e     // Catch:{ Exception -> 0x00aa }
            java.lang.String r1 = "cardDetailsCL"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)     // Catch:{ Exception -> 0x00aa }
            int r7 = r7.getHeight()     // Catch:{ Exception -> 0x00aa }
            float r7 = (float) r7     // Catch:{ Exception -> 0x00aa }
            float r7 = -r7
            android.view.ViewPropertyAnimator r6 = r6.translationY(r7)     // Catch:{ Exception -> 0x00aa }
            if (r6 == 0) goto L_0x00a9
            r1 = 300(0x12c, double:1.48E-321)
            android.view.ViewPropertyAnimator r6 = r6.setDuration(r1)     // Catch:{ Exception -> 0x00aa }
            if (r6 == 0) goto L_0x00a9
            net.one97.paytm.recharge.creditcard.v4.a.a$h$d r7 = new net.one97.paytm.recharge.creditcard.v4.a.a$h$d     // Catch:{ Exception -> 0x00aa }
            r7.<init>(r0)     // Catch:{ Exception -> 0x00aa }
            android.animation.Animator$AnimatorListener r7 = (android.animation.Animator.AnimatorListener) r7     // Catch:{ Exception -> 0x00aa }
            android.view.ViewPropertyAnimator r6 = r6.setListener(r7)     // Catch:{ Exception -> 0x00aa }
            if (r6 == 0) goto L_0x00a9
            android.view.animation.LinearInterpolator r7 = new android.view.animation.LinearInterpolator     // Catch:{ Exception -> 0x00aa }
            r7.<init>()     // Catch:{ Exception -> 0x00aa }
            android.animation.TimeInterpolator r7 = (android.animation.TimeInterpolator) r7     // Catch:{ Exception -> 0x00aa }
            android.view.ViewPropertyAnimator r6 = r6.setInterpolator(r7)     // Catch:{ Exception -> 0x00aa }
            if (r6 == 0) goto L_0x00a9
            r6.start()     // Catch:{ Exception -> 0x00aa }
        L_0x00a9:
            return
        L_0x00aa:
            androidx.constraintlayout.widget.ConstraintLayout r6 = r0.f62512e
            r6.clearAnimation()
            androidx.constraintlayout.widget.ConstraintLayout r6 = r0.f62508a
            r6.clearAnimation()
            net.one97.paytm.recharge.creditcard.v4.a.a$f r6 = r0.f62515h
            if (r6 == 0) goto L_0x00bc
            r6.b()
        L_0x00bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.v4.c.c.a(boolean, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00f3, code lost:
        r12 = r12.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r11, android.content.DialogInterface r12, int r13) {
        /*
            r10 = this;
            java.lang.String r0 = "tag"
            kotlin.g.b.k.c(r11, r0)
            java.lang.String r0 = r10.l
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r0)
            r1 = -1
            r2 = -2
            if (r0 == 0) goto L_0x001f
            if (r13 != r2) goto L_0x0017
            if (r12 == 0) goto L_0x0016
            r12.dismiss()
        L_0x0016:
            return
        L_0x0017:
            if (r13 != r1) goto L_0x001e
            if (r12 == 0) goto L_0x001e
            r12.dismiss()
        L_0x001e:
            return
        L_0x001f:
            java.lang.String r0 = r10.m
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0117
            if (r13 != r2) goto L_0x002f
            if (r12 == 0) goto L_0x002e
            r12.dismiss()
        L_0x002e:
            return
        L_0x002f:
            if (r13 != r1) goto L_0x0116
            android.content.Context r11 = r10.getContext()
            boolean r11 = com.paytm.utility.b.c((android.content.Context) r11)
            if (r11 == 0) goto L_0x00dd
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r11 = r10.f62611i
            if (r11 == 0) goto L_0x0116
            if (r11 != 0) goto L_0x0044
            kotlin.g.b.k.a()
        L_0x0044:
            int r11 = r11.getCardTypeId()
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r12 = r10.f62611i
            if (r12 != 0) goto L_0x004f
            kotlin.g.b.k.a()
        L_0x004f:
            int r12 = r12.getSavedCardId()
            java.lang.String r13 = "context!!"
            java.lang.String r0 = "mViewModel"
            if (r11 != r12) goto L_0x00a0
            net.one97.paytm.recharge.creditcard.c.a r11 = r10.f62604b
            if (r11 != 0) goto L_0x0060
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0060:
            if (r11 == 0) goto L_0x0076
            net.one97.paytm.recharge.ordersummary.h.d r1 = r11.v
            if (r1 == 0) goto L_0x0076
            java.lang.String r2 = r10.f62610h
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 112(0x70, float:1.57E-43)
            java.lang.String r3 = "saved_card_delete_clicked"
            java.lang.String r4 = ""
            java.lang.String r5 = ""
            net.one97.paytm.recharge.ordersummary.h.d.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x0076:
            net.one97.paytm.recharge.creditcard.c.a r11 = r10.f62604b
            if (r11 != 0) goto L_0x007d
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x007d:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r12 = r10.f62611i
            if (r12 != 0) goto L_0x0084
            kotlin.g.b.k.a()
        L_0x0084:
            android.content.Context r0 = r10.getContext()
            if (r0 != 0) goto L_0x008d
            kotlin.g.b.k.a()
        L_0x008d:
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r13)
            net.one97.paytm.recharge.widgets.c.d r13 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r13 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.DELETE_RECENT
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r13 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r13, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r1)
            java.lang.String r1 = "delete_saved_card_api"
            r11.a((java.lang.String) r1, (net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8) r12, (android.content.Context) r0, (java.lang.Object) r13)
            return
        L_0x00a0:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r11 = r10.f62611i
            if (r11 != 0) goto L_0x00a7
            kotlin.g.b.k.a()
        L_0x00a7:
            int r11 = r11.getCardTypeId()
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r12 = r10.f62611i
            if (r12 != 0) goto L_0x00b2
            kotlin.g.b.k.a()
        L_0x00b2:
            int r12 = r12.getRecentCardId()
            if (r11 != r12) goto L_0x00dc
            net.one97.paytm.recharge.creditcard.c.a r11 = r10.f62604b
            if (r11 != 0) goto L_0x00bf
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x00bf:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r12 = r10.f62611i
            android.content.Context r0 = r10.getContext()
            if (r0 != 0) goto L_0x00ca
            kotlin.g.b.k.a()
        L_0x00ca:
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r13)
            net.one97.paytm.recharge.widgets.c.d r13 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r13 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.DELETE_RECENT
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r13 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r13, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r1)
            java.lang.String r1 = "delete_recent_card_api"
            r11.a((java.lang.String) r1, (net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8) r12, (android.content.Context) r0, (java.lang.Object) r13)
        L_0x00dc:
            return
        L_0x00dd:
            net.one97.paytm.recharge.common.utils.as r11 = new net.one97.paytm.recharge.common.utils.as
            r12 = 0
            r13 = 1
            r0 = 0
            r11.<init>(r12, r13, r0)
            com.paytm.network.model.NetworkCustomError$ErrorType r12 = com.paytm.network.model.NetworkCustomError.ErrorType.NoConnectionError
            r11.mErrorType = r12
            android.content.Context r11 = r10.getContext()
            android.content.Context r12 = r10.getContext()
            if (r12 == 0) goto L_0x0100
            android.content.res.Resources r12 = r12.getResources()
            if (r12 == 0) goto L_0x0100
            int r13 = net.one97.paytm.recharge.R.string.no_connection
            java.lang.String r12 = r12.getString(r13)
            goto L_0x0101
        L_0x0100:
            r12 = r0
        L_0x0101:
            android.content.Context r13 = r10.getContext()
            if (r13 == 0) goto L_0x0113
            android.content.res.Resources r13 = r13.getResources()
            if (r13 == 0) goto L_0x0113
            int r0 = net.one97.paytm.recharge.R.string.no_internet
            java.lang.String r0 = r13.getString(r0)
        L_0x0113:
            com.paytm.utility.g.c(r11, r12, r0)
        L_0x0116:
            return
        L_0x0117:
            java.lang.String r0 = r10.n
            boolean r11 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r0)
            if (r11 == 0) goto L_0x0126
            if (r13 != r2) goto L_0x0126
            if (r12 == 0) goto L_0x0126
            r12.dismiss()
        L_0x0126:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.v4.c.c.a(java.lang.String, android.content.DialogInterface, int):void");
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        net.one97.paytm.recharge.ordersummary.h.d dVar2;
        Integer num = null;
        Integer valueOf = menuItem != null ? Integer.valueOf(menuItem.getItemId()) : null;
        int i2 = R.id.add_card_holder_name;
        if (valueOf == null || valueOf.intValue() != i2) {
            int i3 = R.id.delete;
            if (valueOf == null || valueOf.intValue() != i3) {
                int i4 = R.id.stop_bill_reminders;
                if (valueOf == null || valueOf.intValue() != i4) {
                    return true;
                }
                net.one97.paytm.recharge.creditcard.c.a aVar = this.f62604b;
                if (aVar == null) {
                    k.a("mViewModel");
                }
                if (!(aVar == null || (dVar = aVar.v) == null)) {
                    net.one97.paytm.recharge.ordersummary.h.d.a(dVar, "onus_credit_card", "stop_bill_reminder_clicked", "", "", (Object) null, (Object) null, (Object) null, 112);
                }
                if (getActivity() == null || !com.paytm.utility.b.c((Context) getActivity())) {
                    f();
                    return true;
                }
                b(false);
                return true;
            } else if (net.one97.paytm.recharge.widgets.c.e.INSTANCE.validateIsAlreadyClicked(menuItem, net.one97.paytm.recharge.widgets.c.e.INSTANCE.getDELAY_1000_MILLI())) {
                return true;
            } else {
                net.one97.paytm.recharge.creditcard.c.a aVar2 = this.f62604b;
                if (aVar2 == null) {
                    k.a("mViewModel");
                }
                if (!(aVar2 == null || (dVar2 = aVar2.v) == null)) {
                    net.one97.paytm.recharge.ordersummary.h.d.a(dVar2, "onus_credit_card", "delete_card_clicked", "", "", (Object) null, (Object) null, (Object) null, 112);
                }
                if (this.r == null) {
                    e.b bVar = net.one97.paytm.recharge.ordersummary.c.e.f64048b;
                    String string = getString(R.string.visa_delete_card);
                    k.a((Object) string, "getString(R.string.visa_delete_card)");
                    String string2 = getString(R.string.yes);
                    k.a((Object) string2, "getString(R.string.yes)");
                    String string3 = getString(R.string.no);
                    String string4 = getString(R.string.stop_bill_reminder_message1_desc);
                    k.a((Object) string4, "getString(R.string.stop_…l_reminder_message1_desc)");
                    String string5 = getString(R.string.stop_bill_reminder_message2_desc);
                    k.a((Object) string5, "getString(R.string.stop_…l_reminder_message2_desc)");
                    String string6 = getString(R.string.stop_bill_reminder_confirmation_msg);
                    k.a((Object) string6, "getString(R.string.stop_…eminder_confirmation_msg)");
                    this.r = e.b.a(string, string2, string3, string4, string5, string6, e.a.DELETE_ACTION);
                }
                net.one97.paytm.recharge.ordersummary.c.e eVar = this.r;
                if (eVar != null) {
                    eVar.f64054a = new net.one97.paytm.recharge.widgets.a.b(this.m, this);
                }
                net.one97.paytm.recharge.ordersummary.c.e eVar2 = this.r;
                if (eVar2 == null) {
                    return true;
                }
                eVar2.show(getChildFragmentManager(), net.one97.paytm.recharge.ordersummary.c.e.class.getSimpleName());
                return true;
            }
        } else if (net.one97.paytm.recharge.widgets.c.e.INSTANCE.validateIsAlreadyClicked(menuItem, net.one97.paytm.recharge.widgets.c.e.INSTANCE.getDELAY_1000_MILLI())) {
            return true;
        } else {
            CJRCreditCardModelV8 cJRCreditCardModelV8 = this.f62611i;
            Integer valueOf2 = cJRCreditCardModelV8 != null ? Integer.valueOf(cJRCreditCardModelV8.getCardTypeId()) : null;
            CJRCreditCardModelV8 cJRCreditCardModelV82 = this.f62611i;
            if (cJRCreditCardModelV82 != null) {
                num = Integer.valueOf(cJRCreditCardModelV82.getSavedCardId());
            }
            if (k.a((Object) valueOf2, (Object) num)) {
                if (this.s == null) {
                    e.b bVar2 = net.one97.paytm.recharge.ordersummary.c.e.f64048b;
                    String string7 = getString(R.string.not_able_to_add_name_title);
                    k.a((Object) string7, "getString(R.string.not_able_to_add_name_title)");
                    String string8 = getString(R.string.btn_txt);
                    k.a((Object) string8, "getString(R.string.btn_txt)");
                    String string9 = getString(R.string.add_card_holder_message);
                    k.a((Object) string9, "getString(R.string.add_card_holder_message)");
                    this.s = e.b.a(string7, string8, (String) null, string9, "", "", e.a.NOT_ABLE_TO_ADD_NAME);
                    net.one97.paytm.recharge.ordersummary.c.e eVar3 = this.s;
                    if (eVar3 != null) {
                        eVar3.f64054a = new net.one97.paytm.recharge.widgets.a.b(this.l, this);
                    }
                }
                net.one97.paytm.recharge.ordersummary.c.e eVar4 = this.s;
                if (eVar4 == null) {
                    return true;
                }
                eVar4.show(getChildFragmentManager(), net.one97.paytm.recharge.ordersummary.c.e.class.getSimpleName());
                return true;
            }
            d.a aVar3 = net.one97.paytm.recharge.presentation.b.d.f64748a;
            net.one97.paytm.recharge.presentation.b.d a2 = d.a.a("", 0L, "", this, d.c.FROM_CREDIT_CARD_REVAMP.ordinal());
            if (a2.isVisible()) {
                return true;
            }
            a2.show(getChildFragmentManager(), net.one97.paytm.recharge.presentation.b.d.class.getSimpleName());
            return true;
        }
    }

    public final void a(View view, CJRCreditCardModelV8 cJRCreditCardModelV8, int i2) {
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        k.c(view, "view");
        k.c(cJRCreditCardModelV8, BaseViewModel.PaymentType.CARD);
        if (getContext() != null && !net.one97.paytm.recharge.widgets.c.e.INSTANCE.validateIsAlreadyClicked(view, net.one97.paytm.recharge.widgets.c.e.INSTANCE.getDELAY_1000_MILLI())) {
            net.one97.paytm.recharge.creditcard.c.a aVar = this.f62604b;
            if (aVar == null) {
                k.a("mViewModel");
            }
            aVar.X = i2;
            this.f62611i = cJRCreditCardModelV8;
            net.one97.paytm.recharge.creditcard.c.a aVar2 = this.f62604b;
            if (aVar2 == null) {
                k.a("mViewModel");
            }
            if (!(aVar2 == null || (dVar = aVar2.v) == null)) {
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, "onus_credit_card", "three_dot_menu_clicked", "", "", (Object) null, (Object) null, (Object) null, 112);
            }
            PopupMenu popupMenu = new PopupMenu(new ContextThemeWrapper(view.getContext(), R.style.recentPopUpMenuAppStyleV4), view);
            if (Build.VERSION.SDK_INT >= 28) {
                popupMenu.getMenu().setGroupDividerEnabled(true);
            }
            popupMenu.getMenuInflater().inflate(R.menu.v3_credit_card_option_menu, popupMenu.getMenu());
            if (Build.VERSION.SDK_INT >= 23) {
                popupMenu.setGravity(8388613);
            }
            popupMenu.getMenu().removeItem(R.id.add_card_holder_name);
            if (this.j || !az.e(getActivity())) {
                popupMenu.getMenu().removeItem(R.id.stop_bill_reminders);
            }
            MenuItem findItem = popupMenu.getMenu().findItem(R.id.delete);
            findItem.setTitle(getString(R.string.visa_delete_card));
            k.a((Object) findItem, "deleteItem");
            net.one97.paytm.recharge.common.utils.g.a(findItem, androidx.core.content.b.c(view.getContext(), R.color.color_ff585d));
            if (!this.k) {
                popupMenu.setOnMenuItemClickListener(this);
            }
            popupMenu.show();
            a(true);
            popupMenu.setOnDismissListener(new h(this));
        }
    }

    static final class h implements PopupMenu.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f62622a;

        h(c cVar) {
            this.f62622a = cVar;
        }

        public final void onDismiss(PopupMenu popupMenu) {
            this.f62622a.a(false);
        }
    }

    /* access modifiers changed from: private */
    public final void a(boolean z) {
        if (getActivity() instanceof AJRRechargeUtilityActivity) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((AJRRechargeUtilityActivity) activity).a(z, true);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity");
        }
    }

    public final void a(boolean z, int i2, String str) {
        if (!z) {
            com.paytm.utility.g.b(getContext(), "", getString(R.string.some_went_wrong));
        } else if (this.o) {
            if (getContext() != null) {
                if (this.q == null) {
                    j childFragmentManager = getChildFragmentManager();
                    k.a((Object) childFragmentManager, "childFragmentManager");
                    androidx.fragment.app.f u2 = childFragmentManager.u();
                    Context context = getContext();
                    if (context == null) {
                        k.a();
                    }
                    k.a((Object) context, "context!!");
                    Fragment c2 = u2.c(context.getClassLoader(), net.one97.paytm.recharge.creditcard.v4.b.c.class.getName());
                    if (!(c2 instanceof net.one97.paytm.recharge.creditcard.v4.b.c)) {
                        c2 = null;
                    }
                    this.q = (net.one97.paytm.recharge.creditcard.v4.b.c) c2;
                }
                net.one97.paytm.recharge.creditcard.v4.b.c cVar = this.q;
                if (cVar != null) {
                    j childFragmentManager2 = getChildFragmentManager();
                    k.a((Object) childFragmentManager2, "childFragmentManager");
                    cVar.show(childFragmentManager2, net.one97.paytm.recharge.creditcard.v4.b.c.class.getSimpleName());
                }
            }
            this.j = !z;
            if (z) {
                Looper mainLooper = Looper.getMainLooper();
                k.a((Object) mainLooper, "Looper.getMainLooper()");
                if (k.a((Object) mainLooper.getThread(), (Object) Thread.currentThread())) {
                    net.one97.paytm.recharge.creditcard.v4.a.a aVar = this.f62605c;
                    if (aVar != null) {
                        aVar.a((CJRCreditCardModelV8) null);
                        return;
                    }
                    return;
                }
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.runOnUiThread(new g(this));
                }
            }
        } else {
            this.j = true;
            Looper mainLooper2 = Looper.getMainLooper();
            k.a((Object) mainLooper2, "Looper.getMainLooper()");
            if (k.a((Object) mainLooper2.getThread(), (Object) Thread.currentThread())) {
                net.one97.paytm.recharge.creditcard.v4.a.a aVar2 = this.f62605c;
                if (aVar2 != null) {
                    aVar2.a();
                }
                RecyclerView recyclerView = this.f62608f;
                if (recyclerView != null) {
                    recyclerView.smoothScrollToPosition(0);
                }
            } else {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    activity2.runOnUiThread(new e(this));
                }
            }
            try {
                net.one97.paytm.recharge.creditcard.c.a aVar3 = this.f62604b;
                if (aVar3 == null) {
                    k.a("mViewModel");
                }
                net.one97.paytm.recharge.ordersummary.h.d.a(aVar3.v, "onus_credit_card", "sms_consent_widget_shown", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            } catch (Throwable unused) {
            }
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f62619a;

        e(c cVar) {
            this.f62619a = cVar;
        }

        public final void run() {
            net.one97.paytm.recharge.creditcard.v4.a.a b2 = this.f62619a.f62605c;
            if (b2 != null) {
                b2.a();
            }
            RecyclerView c2 = this.f62619a.f62608f;
            if (c2 != null) {
                c2.smoothScrollToPosition(0);
            }
        }
    }

    public final void a(Map<String, Boolean> map, int i2, String str) {
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        if (map != null && map.containsKey("ocl.permission.creditcard.sms_read_consent")) {
            Boolean bool = map.get("ocl.permission.creditcard.sms_read_consent");
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            this.j = !booleanValue;
            if (this.j && this.f62605c != null) {
                try {
                    net.one97.paytm.recharge.creditcard.c.a aVar = this.f62604b;
                    if (aVar == null) {
                        k.a("mViewModel");
                    }
                    if (!(aVar == null || (dVar = aVar.v) == null)) {
                        net.one97.paytm.recharge.ordersummary.h.d.a(dVar, "onus_credit_card", "sms_consent_widget_shown", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
                    }
                } catch (Throwable unused) {
                }
                Looper mainLooper = Looper.getMainLooper();
                k.a((Object) mainLooper, "Looper.getMainLooper()");
                if (k.a((Object) mainLooper.getThread(), (Object) Thread.currentThread())) {
                    net.one97.paytm.recharge.creditcard.v4.a.a aVar2 = this.f62605c;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                    RecyclerView recyclerView = this.f62608f;
                    if (recyclerView != null) {
                        recyclerView.smoothScrollToPosition(0);
                        return;
                    }
                    return;
                }
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.runOnUiThread(new f(this));
                }
            } else if (booleanValue && s.a() && !s.d((Context) getActivity())) {
                this.p = true;
                requestPermissions(new String[]{"android.permission.READ_SMS"}, 55);
            }
        }
    }

    static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f62620a;

        f(c cVar) {
            this.f62620a = cVar;
        }

        public final void run() {
            net.one97.paytm.recharge.creditcard.v4.a.a b2 = this.f62620a.f62605c;
            if (b2 != null) {
                b2.a();
            }
            RecyclerView c2 = this.f62620a.f62608f;
            if (c2 != null) {
                c2.smoothScrollToPosition(0);
            }
        }
    }

    public final void a() {
        try {
            net.one97.paytm.recharge.creditcard.c.a aVar = this.f62604b;
            if (aVar == null) {
                k.a("mViewModel");
            }
            net.one97.paytm.recharge.ordersummary.h.d.a(aVar.v, "onus_credit_card", "get_my_bill_details_selected", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
        } catch (Throwable unused) {
        }
        if (!s.a() || s.d((Context) getActivity())) {
            c();
        } else {
            requestPermissions(new String[]{"android.permission.READ_SMS"}, 55);
        }
    }

    private final void c() {
        if (com.paytm.utility.b.c(getContext())) {
            b(true);
        } else {
            f();
        }
    }

    private final void b(boolean z) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.o = z;
            if (!z) {
                net.one97.paytm.smssdk.b bVar = net.one97.paytm.smssdk.b.f65064b;
                FragmentActivity activity2 = getActivity();
                if (activity2 == null) {
                    k.a();
                }
                k.a((Object) activity2, "activity!!");
                net.one97.paytm.smssdk.b.a(activity2, "ocl.permission.creditcard.sms_read_consent", false, this);
                return;
            }
            net.one97.paytm.smssdk.b bVar2 = net.one97.paytm.smssdk.b.f65064b;
            k.a((Object) activity, "it");
            net.one97.paytm.smssdk.b.a(activity, "ocl.permission.creditcard.sms_read_consent", true, this);
        }
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        String str;
        Context context;
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        if (i2 == 55) {
            if (!s.a(iArr)) {
                if (s.a(strArr, iArr, "android.permission.READ_SMS", getActivity()) == 0 && (context = getContext()) != null) {
                    az azVar = az.f61525a;
                    k.a((Object) context, "it");
                    az.h(context);
                }
                str = "Deny";
            } else if (this.p) {
                this.p = false;
                return;
            } else {
                c();
                str = "Allow";
            }
            String str2 = str;
            try {
                net.one97.paytm.recharge.creditcard.c.a aVar = this.f62604b;
                if (aVar == null) {
                    k.a("mViewModel");
                }
                net.one97.paytm.recharge.ordersummary.h.d.a(aVar.v, "onus_credit_card", "permission_selected", "", str2, (Object) null, (Object) null, (Object) null, 112);
            } catch (Throwable unused) {
            }
        } else {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        String name = c.class.getName();
        k.a((Object) name, "FJRSavedCardsFragmentV4::class.java.name");
        v = name;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            Locale locale = Locale.ENGLISH;
            k.a((Object) locale, "Locale.ENGLISH");
            String lowerCase = "/onus_credit_card/recents".toLowerCase(locale);
            k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            net.one97.paytm.recharge.di.helper.b.a((Context) getActivity(), lowerCase);
        } catch (Throwable unused) {
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable("saved_cards_list");
            if (serializable != null) {
                this.t = ab.c(serializable);
                this.f62609g = arguments.getBoolean("is_recharge_tabs_flow", false);
            } else {
                throw new u("null cannot be cast to non-null type kotlin.collections.MutableList<net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8>");
            }
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        androidx.lifecycle.ai a2 = new al(activity).a(net.one97.paytm.recharge.creditcard.c.a.class);
        k.a((Object) a2, "ViewModelProvider(activi…dViewModelV2::class.java)");
        this.f62604b = (net.one97.paytm.recharge.creditcard.c.a) a2;
        net.one97.paytm.recharge.creditcard.c.a aVar = this.f62604b;
        if (aVar == null) {
            k.a("mViewModel");
        }
        aVar.P.observe(this, this);
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f62618a;

        d(c cVar) {
            this.f62618a = cVar;
        }

        public final void run() {
            this.f62618a.a(false, true);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.lyt_fragment_savedcardsv4, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        FragmentActivity activity;
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        net.one97.paytm.recharge.ordersummary.h.d dVar2;
        net.one97.paytm.recharge.ordersummary.h.d dVar3;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        this.f62608f = (RecyclerView) view.findViewById(R.id.savedcard_listView);
        RecyclerView recyclerView = this.f62608f;
        if (recyclerView == null) {
            k.a();
        }
        recyclerView.setNestedScrollingEnabled(false);
        RecyclerView recyclerView2 = this.f62608f;
        if (recyclerView2 != null) {
            recyclerView2.setHasFixedSize(true);
        }
        this.f62607e = new LinearLayoutManager(getActivity());
        RecyclerView recyclerView3 = this.f62608f;
        if (recyclerView3 == null) {
            k.a();
        }
        recyclerView3.setLayoutManager(this.f62607e);
        RecyclerView recyclerView4 = this.f62608f;
        if (recyclerView4 != null) {
            recyclerView4.addItemDecoration(new net.one97.paytm.recharge.automatic.b.a(false, 22));
        }
        try {
            List<CJRCreditCardModelV8> list = this.t;
            if (list == null) {
                k.a("mSavedCardList");
            }
            Collection arrayList = new ArrayList();
            for (Object next : list) {
                CJRCreditCardModelV8 cJRCreditCardModelV8 = (CJRCreditCardModelV8) next;
                if (cJRCreditCardModelV8.getCardTypeId() == cJRCreditCardModelV8.getRecentCardId()) {
                    arrayList.add(next);
                }
            }
            List list2 = (List) arrayList;
            List<CJRCreditCardModelV8> list3 = this.t;
            if (list3 == null) {
                k.a("mSavedCardList");
            }
            Collection arrayList2 = new ArrayList();
            for (Object next2 : list3) {
                CJRCreditCardModelV8 cJRCreditCardModelV82 = (CJRCreditCardModelV8) next2;
                if (cJRCreditCardModelV82.getCardTypeId() == cJRCreditCardModelV82.getSavedCardId()) {
                    arrayList2.add(next2);
                }
            }
            List list4 = (List) arrayList2;
            net.one97.paytm.recharge.creditcard.c.a aVar = this.f62604b;
            if (aVar == null) {
                k.a("mViewModel");
            }
            if (!(aVar == null || (dVar3 = aVar.v) == null)) {
                StringBuilder sb = new StringBuilder();
                sb.append(list2.size());
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar3, "onus_credit_card", "recent_card_shown", "", sb.toString(), (Object) null, (Object) null, (Object) null, 112);
            }
            net.one97.paytm.recharge.creditcard.c.a aVar2 = this.f62604b;
            if (aVar2 == null) {
                k.a("mViewModel");
            }
            if (!(aVar2 == null || (dVar2 = aVar2.v) == null)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(list4.size());
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar2, "onus_credit_card", "pg_only_saved_card_shown", "", sb2.toString(), (Object) null, (Object) null, (Object) null, 112);
            }
            net.one97.paytm.recharge.creditcard.c.a aVar3 = this.f62604b;
            if (aVar3 == null) {
                k.a("mViewModel");
            }
            if (!(aVar3 == null || (dVar = aVar3.v) == null)) {
                StringBuilder sb3 = new StringBuilder();
                List<CJRCreditCardModelV8> list5 = this.t;
                if (list5 == null) {
                    k.a("mSavedCardList");
                }
                sb3.append(list5.size());
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, "onus_credit_card", "recent_and_pg_saved_card_shown", "", sb3.toString(), (Object) null, (Object) null, (Object) null, 112);
            }
        } catch (Throwable unused) {
        }
        d();
        if (az.e(getContext()) && (activity = getActivity()) != null) {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add("ocl.permission.creditcard.sms_read_consent");
            net.one97.paytm.smssdk.b bVar = net.one97.paytm.smssdk.b.f65064b;
            k.a((Object) activity, "it");
            net.one97.paytm.smssdk.b.a(activity, arrayList3, this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        if (r0.m.containsKey("cardId") != false) goto L_0x0037;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void d() {
        /*
            r12 = this;
            net.one97.paytm.recharge.creditcard.c.a r0 = r12.f62604b
            java.lang.String r1 = "mViewModel"
            if (r0 != 0) goto L_0x0009
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r0.m
            java.util.Map r0 = (java.util.Map) r0
            boolean r0 = r0.isEmpty()
            r2 = 1
            r0 = r0 ^ r2
            if (r0 == 0) goto L_0x01c6
            net.one97.paytm.recharge.creditcard.c.a r0 = r12.f62604b
            if (r0 != 0) goto L_0x001c
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x001c:
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r0.m
            java.lang.String r3 = "recharge_number"
            boolean r0 = r0.containsKey(r3)
            java.lang.String r4 = "cardId"
            if (r0 != 0) goto L_0x0037
            net.one97.paytm.recharge.creditcard.c.a r0 = r12.f62604b
            if (r0 != 0) goto L_0x002f
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x002f:
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r0.m
            boolean r0 = r0.containsKey(r4)
            if (r0 == 0) goto L_0x01c6
        L_0x0037:
            net.one97.paytm.recharge.creditcard.c.a r0 = r12.f62604b
            if (r0 != 0) goto L_0x003e
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x003e:
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r0.m
            java.lang.Object r0 = r0.get(r3)
            java.lang.String r0 = (java.lang.String) r0
            net.one97.paytm.recharge.creditcard.c.a r3 = r12.f62604b
            if (r3 != 0) goto L_0x004d
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x004d:
            java.util.HashMap<java.lang.String, java.lang.String> r3 = r3.m
            java.lang.Object r3 = r3.get(r4)
            java.lang.String r3 = (java.lang.String) r3
            r4 = 0
            java.lang.String r5 = ""
            r6 = 0
            if (r0 == 0) goto L_0x0062
            java.lang.String r7 = " "
            java.lang.String r0 = kotlin.m.p.a(r0, r7, r5, r4)
            goto L_0x0063
        L_0x0062:
            r0 = r6
        L_0x0063:
            r7 = r0
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 != 0) goto L_0x0094
            if (r0 != 0) goto L_0x0071
            kotlin.g.b.k.a()
        L_0x0071:
            int r8 = r0.length()
            r9 = 5
            if (r8 <= r9) goto L_0x0094
            r8 = 6
            java.lang.CharSequence r8 = r0.subSequence(r4, r8)
            java.lang.String r8 = r8.toString()
            int r9 = r0.length()
            int r9 = r9 + -4
            int r10 = r0.length()
            java.lang.CharSequence r0 = r0.subSequence(r9, r10)
            java.lang.String r0 = r0.toString()
            goto L_0x0096
        L_0x0094:
            r0 = r5
            r8 = r0
        L_0x0096:
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x00aa
            r7 = r3
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x00a6
            goto L_0x00aa
        L_0x00a6:
            r12.e()
            return
        L_0x00aa:
            java.util.List<net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8> r7 = r12.t
            if (r7 != 0) goto L_0x00b3
            java.lang.String r9 = "mSavedCardList"
            kotlin.g.b.k.a((java.lang.String) r9)
        L_0x00b3:
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x00b9:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00f8
            java.lang.Object r9 = r7.next()
            r10 = r9
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r10 = (net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8) r10
            java.lang.String r11 = r10.getFirstSixDigits()
            boolean r11 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r11, (boolean) r2)
            if (r11 == 0) goto L_0x00da
            java.lang.String r11 = r10.getLastFourDigits()
            boolean r11 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r11, (boolean) r2)
            if (r11 != 0) goto L_0x00f2
        L_0x00da:
            if (r3 == 0) goto L_0x00e6
            java.lang.String r11 = r10.getCardId()
            boolean r11 = r3.equals(r11)
            if (r11 == r2) goto L_0x00f2
        L_0x00e6:
            if (r3 == 0) goto L_0x00f4
            java.lang.String r10 = r10.getCardId2()
            boolean r10 = r3.equals(r10)
            if (r10 != r2) goto L_0x00f4
        L_0x00f2:
            r10 = 1
            goto L_0x00f5
        L_0x00f4:
            r10 = 0
        L_0x00f5:
            if (r10 == 0) goto L_0x00b9
            goto L_0x00f9
        L_0x00f8:
            r9 = r6
        L_0x00f9:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r9 = (net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8) r9
            if (r9 == 0) goto L_0x01c2
            net.one97.paytm.recharge.creditcard.c.a r0 = r12.f62604b
            if (r0 != 0) goto L_0x0104
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0104:
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r0.m
            java.lang.String r2 = "price"
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x0121
            net.one97.paytm.recharge.creditcard.c.a r0 = r12.f62604b
            if (r0 != 0) goto L_0x0115
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0115:
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r0.m
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            r9.setDeeplinkAmount(r0)
            goto L_0x0124
        L_0x0121:
            r9.setDeeplinkAmount(r5)
        L_0x0124:
            net.one97.paytm.common.entity.recharge.CJRBillDetails r0 = r9.getBillsDetails()
            if (r0 == 0) goto L_0x0133
            double r2 = r0.getMinDueAmount()
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            goto L_0x0134
        L_0x0133:
            r0 = r6
        L_0x0134:
            r2 = 0
            if (r0 == 0) goto L_0x016a
            net.one97.paytm.common.entity.recharge.CJRBillDetails r0 = r9.getBillsDetails()
            if (r0 == 0) goto L_0x0147
            double r7 = r0.getMinDueAmount()
            java.lang.Double r0 = java.lang.Double.valueOf(r7)
            goto L_0x0148
        L_0x0147:
            r0 = r6
        L_0x0148:
            if (r0 != 0) goto L_0x014d
            kotlin.g.b.k.a()
        L_0x014d:
            double r7 = r0.doubleValue()
            int r0 = java.lang.Double.compare(r7, r2)
            if (r0 <= 0) goto L_0x016a
            net.one97.paytm.common.entity.recharge.CJRBillDetails r0 = r9.getBillsDetails()
            if (r0 == 0) goto L_0x0166
            double r7 = r0.getMinDueAmount()
            java.lang.Double r0 = java.lang.Double.valueOf(r7)
            goto L_0x0167
        L_0x0166:
            r0 = r6
        L_0x0167:
            r9.setMinDue(r0)
        L_0x016a:
            net.one97.paytm.common.entity.recharge.CJRBillDetails r0 = r9.getBillsDetails()
            if (r0 == 0) goto L_0x0175
            java.lang.Double r0 = r0.getAmount()
            goto L_0x0176
        L_0x0175:
            r0 = r6
        L_0x0176:
            if (r0 == 0) goto L_0x01a2
            net.one97.paytm.common.entity.recharge.CJRBillDetails r0 = r9.getBillsDetails()
            if (r0 == 0) goto L_0x0183
            java.lang.Double r0 = r0.getAmount()
            goto L_0x0184
        L_0x0183:
            r0 = r6
        L_0x0184:
            if (r0 != 0) goto L_0x0189
            kotlin.g.b.k.a()
        L_0x0189:
            double r7 = r0.doubleValue()
            int r0 = java.lang.Double.compare(r7, r2)
            if (r0 <= 0) goto L_0x01a2
            net.one97.paytm.common.entity.recharge.CJRBillDetails r0 = r9.getBillsDetails()
            if (r0 == 0) goto L_0x019e
            java.lang.Double r0 = r0.getAmount()
            goto L_0x019f
        L_0x019e:
            r0 = r6
        L_0x019f:
            r9.setTotalDue(r0)
        L_0x01a2:
            r12.b(r6, r9, r4, r6)
            androidx.recyclerview.widget.RecyclerView r0 = r12.f62608f
            if (r0 == 0) goto L_0x01b5
            net.one97.paytm.recharge.creditcard.v4.c.c$c r2 = new net.one97.paytm.recharge.creditcard.v4.c.c$c
            r2.<init>(r12)
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r3 = 300(0x12c, double:1.48E-321)
            r0.postDelayed(r2, r3)
        L_0x01b5:
            net.one97.paytm.recharge.creditcard.c.a r0 = r12.f62604b
            if (r0 != 0) goto L_0x01bc
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01bc:
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r0.m
            r0.clear()
            return
        L_0x01c2:
            r12.e()
            return
        L_0x01c6:
            r12.e()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.v4.c.c.d():void");
    }

    /* renamed from: net.one97.paytm.recharge.creditcard.v4.c.c$c  reason: collision with other inner class name */
    static final class C1211c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f62617a;

        C1211c(c cVar) {
            this.f62617a = cVar;
        }

        public final void run() {
            this.f62617a.e();
        }
    }

    /* access modifiers changed from: private */
    public final void e() {
        String str;
        CJRCategoryDataHelper cJRCategoryDataHelper;
        CJRCategoryData categoryData;
        if (getContext() == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        List<CJRCreditCardModelV8> list = this.t;
        if (list == null) {
            k.a("mSavedCardList");
        }
        net.one97.paytm.recharge.creditcard.c.a aVar = this.f62604b;
        if (aVar == null) {
            k.a("mViewModel");
        }
        String str2 = aVar.A;
        boolean z = this.j;
        boolean z2 = this.f62609g;
        net.one97.paytm.recharge.creditcard.c.a aVar2 = this.f62604b;
        if (aVar2 == null) {
            k.a("mViewModel");
        }
        if (aVar2 == null || (cJRCategoryDataHelper = aVar2.f61409b) == null || (categoryData = cJRCategoryDataHelper.getCategoryData()) == null || (str = categoryData.getCategoryHeader()) == null) {
            str = "";
        }
        this.f62605c = new net.one97.paytm.recharge.creditcard.v4.a.a(context, list, "onus_credit_card", str2, z, false, z2, str);
        net.one97.paytm.recharge.creditcard.v4.a.a aVar3 = this.f62605c;
        if (aVar3 != null) {
            aVar3.a((a.f) this);
        }
        RecyclerView recyclerView = this.f62608f;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.f62605c);
        }
    }

    public final void a(RecyclerView.v vVar, CJRCreditCardModelV8 cJRCreditCardModelV8, boolean z, HashMap<String, View> hashMap) {
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        k.c(cJRCreditCardModelV8, "cardModel");
        if (z) {
            try {
                net.one97.paytm.recharge.creditcard.c.a aVar = this.f62604b;
                if (aVar == null) {
                    k.a("mViewModel");
                }
                if (!(aVar == null || (dVar = aVar.v) == null)) {
                    net.one97.paytm.recharge.ordersummary.h.d.a(dVar, "onus_credit_card", "pay_bill_for_new_cc_clicked", "", "", (Object) null, (Object) null, (Object) null, 112);
                }
            } catch (Throwable unused) {
            }
        }
        b(vVar, cJRCreditCardModelV8, z, hashMap);
    }

    public final void b(RecyclerView.v vVar, CJRCreditCardModelV8 cJRCreditCardModelV8, boolean z, HashMap<String, View> hashMap) {
        int i2;
        k.c(cJRCreditCardModelV8, "cardModel");
        RecyclerView recyclerView = this.f62608f;
        if (!(recyclerView == null || this.f62606d == null)) {
            if (recyclerView == null) {
                k.a();
            }
            b bVar = this.f62606d;
            if (bVar == null) {
                k.a();
            }
            recyclerView.removeOnScrollListener(bVar);
        }
        if (cJRCreditCardModelV8.getCardTypeId() == cJRCreditCardModelV8.getRecentCardId() || cJRCreditCardModelV8.getCardTypeId() == cJRCreditCardModelV8.getSavedCardId()) {
            cJRCreditCardModelV8.setEditable(false);
        }
        if ((getParentFragment() instanceof net.one97.paytm.recharge.creditcard.b.a) && !this.k) {
            List<CJRCreditCardModelV8> list = this.t;
            if (list == null) {
                k.a("mSavedCardList");
            }
            if (!list.isEmpty()) {
                List<CJRCreditCardModelV8> list2 = this.t;
                if (list2 == null) {
                    k.a("mSavedCardList");
                }
                if (list2.contains(cJRCreditCardModelV8) && !z) {
                    net.one97.paytm.recharge.creditcard.c.a aVar = this.f62604b;
                    if (aVar == null) {
                        k.a("mViewModel");
                    }
                    if (vVar != null) {
                        i2 = vVar.getLayoutPosition();
                    } else {
                        List<CJRCreditCardModelV8> list3 = this.t;
                        if (list3 == null) {
                            k.a("mSavedCardList");
                        }
                        i2 = list3.indexOf(cJRCreditCardModelV8);
                    }
                    aVar.X = i2;
                }
            }
            this.k = false;
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                a.C1204a.a((net.one97.paytm.recharge.creditcard.b.a) parentFragment, cJRCreditCardModelV8, z, hashMap, false, false, 24);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.creditcard.fragment.FJRCreditCardLandingFragment");
        }
    }

    public final class b extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f62612a;

        /* renamed from: b  reason: collision with root package name */
        private RecyclerView.v f62613b;

        /* renamed from: c  reason: collision with root package name */
        private CJRCreditCardModelV8 f62614c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f62615d;

        /* renamed from: e  reason: collision with root package name */
        private HashMap<String, View> f62616e;

        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            k.c(recyclerView, "recyclerView");
            if (i2 == 0) {
                CJRRechargeUtilities.INSTANCE.debugLog("Saved Card Recycler scroll state idle");
                this.f62612a.b(this.f62613b, this.f62614c, this.f62615d, this.f62616e);
            }
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        RecyclerView recyclerView = this.f62608f;
        if (recyclerView != null) {
            if (recyclerView == null) {
                k.a();
            }
            recyclerView.setAdapter((RecyclerView.a) null);
            this.f62608f = null;
        }
        this.k = false;
        HashMap hashMap = this.w;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final void a(Bundle bundle, a.h hVar, CJRCreditCardModelV8 cJRCreditCardModelV8) {
        k.c(bundle, "bundle");
        k.c(hVar, "viewHolder");
        k.c(cJRCreditCardModelV8, "cardSelected");
        a.C1207a aVar = net.one97.paytm.recharge.creditcard.v4.b.a.f62558d;
        k.c(bundle, "bundle");
        net.one97.paytm.recharge.creditcard.v4.b.a aVar2 = new net.one97.paytm.recharge.creditcard.v4.b.a();
        aVar2.setArguments(bundle);
        a.b bVar = this;
        k.c(bVar, "listener");
        k.c(hVar, "viewHolder");
        k.c(cJRCreditCardModelV8, "cardSelected");
        aVar2.f62559a = bVar;
        aVar2.f62560b = hVar;
        aVar2.f62561c = cJRCreditCardModelV8;
        getChildFragmentManager().a().a((Fragment) aVar2, net.one97.paytm.recharge.creditcard.v4.b.a.class.getSimpleName()).c();
    }

    public final void b() {
        CJRCreditCardModelV8 cJRCreditCardModelV8 = this.u;
        if (cJRCreditCardModelV8 != null) {
            net.one97.paytm.recharge.creditcard.v4.a.a aVar = this.f62605c;
            if (aVar != null) {
                aVar.a(cJRCreditCardModelV8);
            }
            CJRCreditCardModelV8 cJRCreditCardModelV82 = this.u;
            if (cJRCreditCardModelV82 == null) {
                k.a();
            }
            int cardTypeId = cJRCreditCardModelV82.getCardTypeId();
            CJRCreditCardModelV8 cJRCreditCardModelV83 = this.u;
            if (cJRCreditCardModelV83 == null) {
                k.a();
            }
            if (cardTypeId == cJRCreditCardModelV83.getRecentCardId()) {
                if ((getContext() instanceof AJRRechargeUtilityActivity) && (getParentFragment() instanceof net.one97.paytm.recharge.creditcard.b.a)) {
                    Fragment parentFragment = getParentFragment();
                    if (!(parentFragment instanceof net.one97.paytm.recharge.creditcard.b.a)) {
                        parentFragment = null;
                    }
                    net.one97.paytm.recharge.creditcard.b.a aVar2 = (net.one97.paytm.recharge.creditcard.b.a) parentFragment;
                    if (aVar2 != null) {
                        aVar2.c();
                    }
                }
                this.u = null;
            }
            List<CJRCreditCardModelV8> list = this.t;
            if (list == null) {
                k.a("mSavedCardList");
            }
            if (list.isEmpty() && (getParentFragment() instanceof net.one97.paytm.recharge.creditcard.b.a)) {
                Fragment parentFragment2 = getParentFragment();
                if (!(parentFragment2 instanceof net.one97.paytm.recharge.creditcard.b.a)) {
                    parentFragment2 = null;
                }
                net.one97.paytm.recharge.creditcard.b.a aVar3 = (net.one97.paytm.recharge.creditcard.b.a) parentFragment2;
                if (aVar3 != null) {
                    aVar3.a();
                }
            }
        }
    }

    public final void a(a.h hVar, CJRCreditCardModelV8 cJRCreditCardModelV8) {
        k.c(hVar, "viewHolder");
        k.c(cJRCreditCardModelV8, "cardSelected");
        b(hVar, cJRCreditCardModelV8, false, (HashMap<String, View>) null);
    }

    public final void a(String str) {
        RecyclerView.v vVar;
        k.c(str, "billName");
        net.one97.paytm.recharge.creditcard.c.a aVar = this.f62604b;
        if (aVar == null) {
            k.a("mViewModel");
        }
        if (aVar.X >= 0) {
            RecyclerView recyclerView = this.f62608f;
            if (recyclerView != null) {
                net.one97.paytm.recharge.creditcard.c.a aVar2 = this.f62604b;
                if (aVar2 == null) {
                    k.a("mViewModel");
                }
                vVar = recyclerView.findViewHolderForLayoutPosition(aVar2.X);
            } else {
                vVar = null;
            }
            List<CJRCreditCardModelV8> list = this.t;
            if (list == null) {
                k.a("mSavedCardList");
            }
            net.one97.paytm.recharge.creditcard.c.a aVar3 = this.f62604b;
            if (aVar3 == null) {
                k.a("mViewModel");
            }
            list.get(aVar3.X).setNameOnCard(str);
            if (vVar instanceof a.h) {
                a.h hVar = (a.h) vVar;
                List<CJRCreditCardModelV8> list2 = this.t;
                if (list2 == null) {
                    k.a("mSavedCardList");
                }
                net.one97.paytm.recharge.creditcard.c.a aVar4 = this.f62604b;
                if (aVar4 == null) {
                    k.a("mViewModel");
                }
                CJRCreditCardModelV8 cJRCreditCardModelV8 = list2.get(aVar4.X);
                if (this.f62604b == null) {
                    k.a("mViewModel");
                }
                hVar.a(cJRCreditCardModelV8);
            }
        }
    }

    static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f62621a;

        g(c cVar) {
            this.f62621a = cVar;
        }

        public final void run() {
            net.one97.paytm.recharge.creditcard.v4.a.a b2 = this.f62621a.f62605c;
            if (b2 != null) {
                b2.a((CJRCreditCardModelV8) null);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r3 = r3.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void f() {
        /*
            r6 = this;
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            android.content.Context r0 = r6.getContext()
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.NO_CONNECTION
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r2 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.UNDEFINED
            android.content.Context r3 = r6.getContext()
            r4 = 0
            if (r3 == 0) goto L_0x001e
            android.content.res.Resources r3 = r3.getResources()
            if (r3 == 0) goto L_0x001e
            int r5 = net.one97.paytm.recharge.R.string.no_connection
            java.lang.String r3 = r3.getString(r5)
            goto L_0x001f
        L_0x001e:
            r3 = r4
        L_0x001f:
            android.content.Context r5 = r6.getContext()
            if (r5 == 0) goto L_0x0031
            android.content.res.Resources r5 = r5.getResources()
            if (r5 == 0) goto L_0x0031
            int r4 = net.one97.paytm.recharge.R.string.no_internet
            java.lang.String r4 = r5.getString(r4)
        L_0x0031:
            net.one97.paytm.recharge.common.utils.az.a(r0, r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.v4.c.c.f():void");
    }
}
