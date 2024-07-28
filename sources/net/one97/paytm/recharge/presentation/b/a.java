package net.one97.paytm.recharge.presentation.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.y;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.g;
import com.paytmmall.clpartifact.view.viewmodel.SharedHomeVM;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionProductModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionSavedCardsModel;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;

public final class a extends net.one97.paytm.i.f implements net.one97.paytm.recharge.widgets.b.a {

    /* renamed from: a  reason: collision with root package name */
    public static final b f64720a = new b((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static C1275a f64721h;

    /* renamed from: b  reason: collision with root package name */
    private CJRAutomaticSubscriptionItemModel f64722b;

    /* renamed from: c  reason: collision with root package name */
    private AutomaticSubscriptionSavedCard f64723c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public net.one97.paytm.recharge.presentation.g.a f64724d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public net.one97.paytm.recharge.automatic.b.a.b f64725e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Integer f64726f;

    /* renamed from: g  reason: collision with root package name */
    private String f64727g;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f64728i;

    /* renamed from: net.one97.paytm.recharge.presentation.b.a$a  reason: collision with other inner class name */
    public interface C1275a {
        void a(int i2, int i3);
    }

    public final View a(int i2) {
        if (this.f64728i == null) {
            this.f64728i = new HashMap();
        }
        View view = (View) this.f64728i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64728i.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class c extends l implements kotlin.g.a.b<net.one97.paytm.recharge.presentation.g.b<CJRAutomaticSubscriptionSavedCardsModel>, x> {
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar) {
            super(1);
            this.this$0 = aVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((net.one97.paytm.recharge.presentation.g.b<CJRAutomaticSubscriptionSavedCardsModel>) (net.one97.paytm.recharge.presentation.g.b) obj);
            return x.f47997a;
        }

        public final void invoke(net.one97.paytm.recharge.presentation.g.b<CJRAutomaticSubscriptionSavedCardsModel> bVar) {
            net.one97.paytm.recharge.presentation.g.c cVar;
            NetworkCustomError networkCustomError;
            CJRAutomaticSubscriptionSavedCardsModel cJRAutomaticSubscriptionSavedCardsModel;
            if (bVar != null) {
                cVar = bVar.f64955c;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                int[] iArr = b.f64733a;
                cVar.ordinal();
            }
            if (!(bVar == null || (cJRAutomaticSubscriptionSavedCardsModel = (CJRAutomaticSubscriptionSavedCardsModel) bVar.f64954b) == null)) {
                new StringBuilder("response ").append(cJRAutomaticSubscriptionSavedCardsModel);
                a.a(this.this$0, (ArrayList) cJRAutomaticSubscriptionSavedCardsModel.getData());
            }
            if (bVar != null && (networkCustomError = bVar.f64953a) != null) {
                net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                net.one97.paytm.recharge.automatic.c.a.a.a(this.this$0.getActivity(), this.this$0, networkCustomError, 1014);
            }
        }
    }

    static final class d extends l implements kotlin.g.a.b<net.one97.paytm.recharge.presentation.g.b<CJRAutomaticSubscriptionCheckModel>, x> {
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a aVar) {
            super(1);
            this.this$0 = aVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((net.one97.paytm.recharge.presentation.g.b<CJRAutomaticSubscriptionCheckModel>) (net.one97.paytm.recharge.presentation.g.b) obj);
            return x.f47997a;
        }

        public final void invoke(net.one97.paytm.recharge.presentation.g.b<CJRAutomaticSubscriptionCheckModel> bVar) {
            net.one97.paytm.recharge.presentation.g.c cVar;
            NetworkCustomError networkCustomError;
            CJRProceedWidgetV8 cJRProceedWidgetV8;
            if (bVar != null) {
                cVar = bVar.f64955c;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                int i2 = b.f64734b[cVar.ordinal()];
                if (i2 == 1) {
                    CJRProceedWidgetV8 cJRProceedWidgetV82 = (CJRProceedWidgetV8) this.this$0.a(R.id.btn_activate);
                    if (cJRProceedWidgetV82 != null) {
                        cJRProceedWidgetV82.b();
                    }
                } else if (i2 == 2 && (cJRProceedWidgetV8 = (CJRProceedWidgetV8) this.this$0.a(R.id.btn_activate)) != null) {
                    cJRProceedWidgetV8.b();
                }
            }
            if (!(bVar == null || ((CJRAutomaticSubscriptionCheckModel) bVar.f64954b) == null)) {
                CJRProceedWidgetV8 cJRProceedWidgetV83 = (CJRProceedWidgetV8) this.this$0.a(R.id.btn_activate);
                if (cJRProceedWidgetV83 != null) {
                    cJRProceedWidgetV83.b();
                }
                int i3 = -1;
                if (this.this$0.f64725e == net.one97.paytm.recharge.automatic.b.a.b.DISABLED || this.this$0.f64725e == net.one97.paytm.recharge.automatic.b.a.b.ENABLED) {
                    CJRProceedWidgetV8 cJRProceedWidgetV84 = (CJRProceedWidgetV8) this.this$0.a(R.id.btn_activate);
                    if (cJRProceedWidgetV84 != null) {
                        cJRProceedWidgetV84.setEnabled(false);
                    }
                    a.b(this.this$0);
                    b bVar2 = a.f64720a;
                    C1275a a2 = a.f64721h;
                    if (a2 != null) {
                        Integer c2 = this.this$0.f64726f;
                        if (c2 == null) {
                            k.a();
                        }
                        int intValue = c2.intValue();
                        Bundle arguments = this.this$0.getArguments();
                        if (arguments != null) {
                            i3 = arguments.getInt("key_position");
                        }
                        a2.a(intValue, i3);
                    }
                } else if (this.this$0.f64725e == net.one97.paytm.recharge.automatic.b.a.b.DELETE) {
                    b bVar3 = a.f64720a;
                    C1275a a3 = a.f64721h;
                    if (a3 != null) {
                        Bundle arguments2 = this.this$0.getArguments();
                        a3.a(-1, arguments2 != null ? arguments2.getInt("key_position") : -1);
                    }
                    this.this$0.dismissAllowingStateLoss();
                }
            }
            if (bVar != null && (networkCustomError = bVar.f64953a) != null) {
                if (networkCustomError.getStatusCode() == 409) {
                    com.paytm.utility.g.a((g.a) new net.one97.paytm.recharge.widgets.a.a("tag.alert.finish.on.click", this.this$0));
                    com.paytm.utility.g.b(this.this$0.getContext(), this.this$0.getString(R.string.title_400), this.this$0.getString(R.string.message_400));
                    return;
                }
                net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                net.one97.paytm.recharge.automatic.c.a.a.a(this.this$0.getActivity(), this.this$0, networkCustomError, SharedHomeVM.UPDATE_NOTIFICATION_ICON);
            }
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        public static a a(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel, int i2, AutomaticSubscriptionSavedCard automaticSubscriptionSavedCard, int i3, String str, C1275a aVar) {
            k.c(aVar, "automaticEnableDisableListener");
            a.f64721h = aVar;
            a aVar2 = new a();
            Bundle bundle = new Bundle();
            bundle.putSerializable("subscription_item_model", cJRAutomaticSubscriptionItemModel);
            bundle.putSerializable("saved_card", automaticSubscriptionSavedCard);
            bundle.putSerializable("key_current_status", Integer.valueOf(i2));
            bundle.putInt("key_position", i3);
            bundle.putString("service_paytype", str);
            aVar2.setArguments(bundle);
            return aVar2;
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 != 0) {
            if (i2 == 1014) {
                b();
            } else if (i2 == 1017) {
                d();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c3, code lost:
        if (kotlin.m.p.a(net.one97.paytm.nativesdk.Constants.SDKConstants.AI_KEY_PPBL, r4 != null ? r4.getPaymentBank() : null, true) == false) goto L_0x00c5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r4) {
        /*
            r3 = this;
            super.onCreate(r4)
            int r4 = net.one97.paytm.recharge.automatic.R.style.CustomImpsBottomSheetDialogTheme
            r0 = 0
            r3.setStyle(r0, r4)
            android.os.Bundle r4 = r3.getArguments()
            r0 = 0
            if (r4 == 0) goto L_0x0017
            java.lang.String r1 = "subscription_item_model"
            java.io.Serializable r4 = r4.getSerializable(r1)
            goto L_0x0018
        L_0x0017:
            r4 = r0
        L_0x0018:
            boolean r1 = r4 instanceof net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel
            if (r1 != 0) goto L_0x001d
            r4 = r0
        L_0x001d:
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r4 = (net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel) r4
            r3.f64722b = r4
            android.os.Bundle r4 = r3.getArguments()
            if (r4 == 0) goto L_0x002e
            java.lang.String r1 = "saved_card"
            java.io.Serializable r4 = r4.getSerializable(r1)
            goto L_0x002f
        L_0x002e:
            r4 = r0
        L_0x002f:
            boolean r1 = r4 instanceof net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard
            if (r1 != 0) goto L_0x0034
            r4 = r0
        L_0x0034:
            net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard r4 = (net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard) r4
            r3.f64723c = r4
            android.os.Bundle r4 = r3.getArguments()
            if (r4 == 0) goto L_0x0049
            java.lang.String r1 = "key_current_status"
            int r4 = r4.getInt(r1)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x004a
        L_0x0049:
            r4 = r0
        L_0x004a:
            r3.f64726f = r4
            android.os.Bundle r4 = r3.getArguments()
            if (r4 == 0) goto L_0x0059
            java.lang.String r1 = "service_paytype"
            java.lang.String r4 = r4.getString(r1)
            goto L_0x005a
        L_0x0059:
            r4 = r0
        L_0x005a:
            r3.f64727g = r4
            android.content.Context r4 = r3.getContext()
            boolean r4 = r4 instanceof androidx.fragment.app.FragmentActivity
            if (r4 == 0) goto L_0x008a
            android.content.Context r4 = r3.getContext()
            if (r4 == 0) goto L_0x0082
            androidx.fragment.app.FragmentActivity r4 = (androidx.fragment.app.FragmentActivity) r4
            net.one97.paytm.recharge.presentation.e.a r1 = new net.one97.paytm.recharge.presentation.e.a
            r1.<init>()
            androidx.lifecycle.al$b r1 = (androidx.lifecycle.al.b) r1
            androidx.lifecycle.al r4 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r4, (androidx.lifecycle.al.b) r1)
            java.lang.Class<net.one97.paytm.recharge.presentation.g.a> r1 = net.one97.paytm.recharge.presentation.g.a.class
            androidx.lifecycle.ai r4 = r4.a(r1)
            net.one97.paytm.recharge.presentation.g.a r4 = (net.one97.paytm.recharge.presentation.g.a) r4
            r3.f64724d = r4
            goto L_0x008a
        L_0x0082:
            kotlin.u r4 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity"
            r4.<init>(r0)
            throw r4
        L_0x008a:
            net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard r4 = r3.f64723c
            if (r4 != 0) goto L_0x00c9
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r4 = r3.f64722b
            if (r4 == 0) goto L_0x0097
            java.lang.String r4 = r4.getPaymentBank()
            goto L_0x0098
        L_0x0097:
            r4 = r0
        L_0x0098:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x00c5
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r4 = r3.f64722b
            if (r4 == 0) goto L_0x00a9
            java.lang.String r4 = r4.getPaymentBank()
            goto L_0x00aa
        L_0x00a9:
            r4 = r0
        L_0x00aa:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x00c9
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r4 = r3.f64722b
            if (r4 == 0) goto L_0x00bb
            java.lang.String r4 = r4.getPaymentBank()
            goto L_0x00bc
        L_0x00bb:
            r4 = r0
        L_0x00bc:
            r1 = 1
            java.lang.String r2 = "PPBL"
            boolean r4 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r4, (boolean) r1)
            if (r4 != 0) goto L_0x00c9
        L_0x00c5:
            r3.b()
            goto L_0x00de
        L_0x00c9:
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r4 = r3.f64722b
            if (r4 == 0) goto L_0x00d2
            java.lang.String r4 = r4.getPaymentBank()
            goto L_0x00d3
        L_0x00d2:
            r4 = r0
        L_0x00d3:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x00de
            r3.c()
        L_0x00de:
            net.one97.paytm.recharge.presentation.g.a r4 = r3.f64724d
            if (r4 == 0) goto L_0x00e5
            androidx.lifecycle.y<net.one97.paytm.recharge.presentation.g.b<net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionSavedCardsModel>> r4 = r4.k
            goto L_0x00e6
        L_0x00e5:
            r4 = r0
        L_0x00e6:
            androidx.lifecycle.LiveData r4 = (androidx.lifecycle.LiveData) r4
            net.one97.paytm.recharge.presentation.b.a$c r1 = new net.one97.paytm.recharge.presentation.b.a$c
            r1.<init>(r3)
            kotlin.g.a.b r1 = (kotlin.g.a.b) r1
            net.one97.paytm.recharge.automatic.b.a.d.a(r3, r4, r1)
            net.one97.paytm.recharge.presentation.g.a r4 = r3.f64724d
            if (r4 == 0) goto L_0x00f8
            androidx.lifecycle.y<net.one97.paytm.recharge.presentation.g.b<net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel>> r0 = r4.f64931h
        L_0x00f8:
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            net.one97.paytm.recharge.presentation.b.a$d r4 = new net.one97.paytm.recharge.presentation.b.a$d
            r4.<init>(r3)
            kotlin.g.a.b r4 = (kotlin.g.a.b) r4
            net.one97.paytm.recharge.automatic.b.a.d.a(r3, r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.b.a.onCreate(android.os.Bundle):void");
    }

    public final void a(String str, Bundle bundle) {
        CJRProceedWidgetV8 cJRProceedWidgetV8;
        if (str != null && str.hashCode() == -1657806898 && str.equals("tag.alert.finish.on.click") && (cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.btn_activate)) != null) {
            cJRProceedWidgetV8.postDelayed(new e(this), 200);
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f64729a;

        e(a aVar) {
            this.f64729a = aVar;
        }

        public final void run() {
            y<net.one97.paytm.recharge.presentation.g.b<CJRAutomaticSubscriptionCheckModel>> yVar;
            net.one97.paytm.recharge.presentation.g.a d2 = this.f64729a.f64724d;
            if (!(d2 == null || (yVar = d2.f64931h) == null)) {
                yVar.postValue(new net.one97.paytm.recharge.presentation.g.b((NetworkCustomError) null, null, net.one97.paytm.recharge.presentation.g.c.ERROR, ""));
            }
            this.f64729a.dismissAllowingStateLoss();
        }
    }

    private final void b() {
        net.one97.paytm.recharge.presentation.g.a aVar;
        if (getContext() != null && com.paytm.utility.b.c(getContext()) && (aVar = this.f64724d) != null) {
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            aVar.b(context);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.revamp_automatic_bs_recharge_details, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        String str;
        Group group;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Integer num = this.f64726f;
        if (num != null && num.intValue() == 0) {
            str = getString(R.string.label_pause_automatic);
        } else if (num != null && num.intValue() == 1) {
            str = getString(R.string.label_resume_automatic);
        } else {
            str = (num != null && num.intValue() == -1) ? getString(R.string.label_delete_automatic) : "";
        }
        k.a((Object) str, "when(mStatusToBeChanged)…     else -> \"\"\n        }");
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.btn_activate);
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.setEnabled(true);
        }
        CJRProceedWidgetV8 cJRProceedWidgetV82 = (CJRProceedWidgetV8) a(R.id.btn_activate);
        if (cJRProceedWidgetV82 != null) {
            cJRProceedWidgetV82.setProceedBtnText(str);
        }
        TextView textView = (TextView) a(R.id.tv_activate);
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = (TextView) a(R.id.txt_edit_name_link);
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel = this.f64722b;
        if (cJRAutomaticSubscriptionItemModel != null) {
            String payType = cJRAutomaticSubscriptionItemModel.getPayType();
            if (payType != null) {
                if (payType != null) {
                    String lowerCase = payType.toLowerCase();
                    k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                    if (k.a((Object) "prepaid", (Object) lowerCase) && (group = (Group) a(R.id.prepaid_group)) != null) {
                        group.setVisibility(0);
                    }
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            TextView textView3 = (TextView) a(R.id.txt_name);
            if (textView3 != null) {
                textView3.setText(TextUtils.isEmpty(cJRAutomaticSubscriptionItemModel.getNickname()) ? cJRAutomaticSubscriptionItemModel.getRechargeNumber() : cJRAutomaticSubscriptionItemModel.getNickname());
            }
            if (TextUtils.isEmpty(cJRAutomaticSubscriptionItemModel.getNickname())) {
                TextView textView4 = (TextView) a(R.id.txt_operator_number);
                if (textView4 != null) {
                    textView4.setVisibility(8);
                }
            } else {
                TextView textView5 = (TextView) a(R.id.txt_operator_number);
                if (textView5 != null) {
                    textView5.setText(cJRAutomaticSubscriptionItemModel.getRechargeNumber());
                }
            }
            TextView textView6 = (TextView) a(R.id.txt_name_with_operator_number);
            if (textView6 != null) {
                textView6.setText(cJRAutomaticSubscriptionItemModel.getOperatorNameWithCircle());
            }
            TextView textView7 = (TextView) a(R.id.txt_last_bill_paid_msg);
            if (textView7 != null) {
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                textView7.setText(cJRAutomaticSubscriptionItemModel.getAutomaticPaymentStatusMessage(context));
            }
            w a2 = w.a();
            CJRAutomaticSubscriptionProductModel product = cJRAutomaticSubscriptionItemModel.getProduct();
            a2.a(product != null ? product.getThumbnail() : null).a((ImageView) a(R.id.ic_operator_icon));
        }
        c();
        ((ImageView) a(R.id.ic_close)).setOnClickListener(new f(this));
        CJRProceedWidgetV8 cJRProceedWidgetV83 = (CJRProceedWidgetV8) a(R.id.btn_activate);
        if (cJRProceedWidgetV83 != null) {
            cJRProceedWidgetV83.setOnClickListener(new g(this));
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f64730a;

        f(a aVar) {
            this.f64730a = aVar;
        }

        public final void onClick(View view) {
            this.f64730a.dismissAllowingStateLoss();
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f64731a;

        g(a aVar) {
            this.f64731a = aVar;
        }

        public final void onClick(View view) {
            a.e(this.f64731a);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        if (kotlin.m.p.a(net.one97.paytm.nativesdk.Constants.SDKConstants.AI_KEY_PPBL, r0 != null ? r0.getPaymentBank() : null, true) == false) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x02c1, code lost:
        if (r1 == null) goto L_0x02d2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void c() {
        /*
            r10 = this;
            net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard r0 = r10.f64723c
            java.lang.String r1 = "BANK_MANDATE"
            java.lang.String r2 = "PPBL"
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x004f
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r0 = r10.f64722b
            if (r0 == 0) goto L_0x0013
            java.lang.String r0 = r0.getPaymentBank()
            goto L_0x0014
        L_0x0013:
            r0 = r4
        L_0x0014:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x002c
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r0 = r10.f64722b
            if (r0 == 0) goto L_0x0025
            java.lang.String r0 = r0.getPaymentBank()
            goto L_0x0026
        L_0x0025:
            r0 = r4
        L_0x0026:
            boolean r0 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r0, (boolean) r3)
            if (r0 != 0) goto L_0x004f
        L_0x002c:
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r0 = r10.f64722b
            if (r0 == 0) goto L_0x0035
            java.lang.String r0 = r0.getPaymentMode()
            goto L_0x0036
        L_0x0035:
            r0 = r4
        L_0x0036:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x004e
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r0 = r10.f64722b
            if (r0 == 0) goto L_0x0047
            java.lang.String r0 = r0.getPaymentMode()
            goto L_0x0048
        L_0x0047:
            r0 = r4
        L_0x0048:
            boolean r0 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r0, (boolean) r3)
            if (r0 != 0) goto L_0x004f
        L_0x004e:
            return
        L_0x004f:
            int r0 = net.one97.paytm.recharge.automatic.R.id.bank_group
            android.view.View r0 = r10.a((int) r0)
            androidx.constraintlayout.widget.Group r0 = (androidx.constraintlayout.widget.Group) r0
            r5 = 0
            if (r0 == 0) goto L_0x005d
            r0.setVisibility(r5)
        L_0x005d:
            int r0 = net.one97.paytm.recharge.automatic.R.id.ic_forward_arrow_2
            android.view.View r0 = r10.a((int) r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r6 = 8
            if (r0 == 0) goto L_0x006c
            r0.setVisibility(r6)
        L_0x006c:
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r0 = r10.f64722b
            if (r0 == 0) goto L_0x0075
            java.lang.String r0 = r0.getPaymentBank()
            goto L_0x0076
        L_0x0075:
            r0 = r4
        L_0x0076:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r7 = "ic_bank_logo"
            java.lang.String r8 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            java.lang.String r9 = "null cannot be cast to non-null type java.lang.String"
            if (r0 != 0) goto L_0x0139
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r0 = r10.f64722b
            if (r0 == 0) goto L_0x008d
            java.lang.String r0 = r0.getPaymentBank()
            goto L_0x008e
        L_0x008d:
            r0 = r4
        L_0x008e:
            boolean r0 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r0, (boolean) r3)
            if (r0 == 0) goto L_0x0139
            int r0 = net.one97.paytm.recharge.automatic.R.id.txt_bank_name
            android.view.View r0 = r10.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x00a9
            int r1 = net.one97.paytm.recharge.automatic.R.string.paytm_payment_bank
            java.lang.String r1 = r10.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x00a9:
            android.content.Context r0 = r10.getContext()
            java.lang.String r0 = com.paytm.utility.b.l((android.content.Context) r0)
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0109
            java.lang.String r1 = "userMobileNumber"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            int r1 = r0.length()
            int r1 = r1 + -4
            int r2 = r0.length()
            if (r0 == 0) goto L_0x0103
            java.lang.String r0 = r0.substring(r1, r2)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00f5
            int r1 = net.one97.paytm.recharge.automatic.R.id.txt_card_number
            android.view.View r1 = r10.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0116
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "XX "
            java.lang.String r0 = r2.concat(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            goto L_0x0116
        L_0x00f5:
            int r0 = net.one97.paytm.recharge.automatic.R.id.txt_card_number
            android.view.View r0 = r10.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0116
            r0.setVisibility(r6)
            goto L_0x0116
        L_0x0103:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r9)
            throw r0
        L_0x0109:
            int r0 = net.one97.paytm.recharge.automatic.R.id.txt_card_number
            android.view.View r0 = r10.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0116
            r0.setVisibility(r6)
        L_0x0116:
            int r0 = net.one97.paytm.recharge.automatic.R.id.ic_bank_logo
            android.view.View r0 = r10.a((int) r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x0138
            int r1 = net.one97.paytm.recharge.automatic.R.id.ic_bank_logo
            android.view.View r1 = r10.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            android.content.Context r1 = r1.getContext()
            int r2 = net.one97.paytm.recharge.automatic.R.drawable.ic_recharge_paytm_logo
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r2)
            r0.setImageDrawable(r1)
        L_0x0138:
            return
        L_0x0139:
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r0 = r10.f64722b
            if (r0 == 0) goto L_0x0142
            java.lang.String r0 = r0.getPaymentMode()
            goto L_0x0143
        L_0x0142:
            r0 = r4
        L_0x0143:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0283
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r0 = r10.f64722b
            if (r0 == 0) goto L_0x0154
            java.lang.String r0 = r0.getPaymentMode()
            goto L_0x0155
        L_0x0154:
            r0 = r4
        L_0x0155:
            boolean r0 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r0, (boolean) r3)
            if (r0 == 0) goto L_0x0283
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r0 = r10.f64722b
            if (r0 == 0) goto L_0x0164
            java.lang.String r0 = r0.getPaymentBank()
            goto L_0x0165
        L_0x0164:
            r0 = r4
        L_0x0165:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01a1
            int r0 = net.one97.paytm.recharge.automatic.R.id.txt_bank_name
            android.view.View r0 = r10.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x01ba
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r2 = r10.f64722b
            if (r2 == 0) goto L_0x0185
            java.lang.String r2 = r2.getPaymentBank()
            goto L_0x0186
        L_0x0185:
            r2 = r4
        L_0x0186:
            r1.append(r2)
            r2 = 32
            r1.append(r2)
            int r2 = net.one97.paytm.recharge.automatic.R.string.paytm_bank_emandate
            java.lang.String r2 = r10.getString(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            goto L_0x01ba
        L_0x01a1:
            int r0 = net.one97.paytm.recharge.automatic.R.id.txt_bank_name
            android.view.View r0 = r10.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x01ba
            int r1 = net.one97.paytm.recharge.automatic.R.string.paytm_bank_emandate
            java.lang.String r1 = r10.getString(r1)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x01ba:
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r0 = r10.f64722b
            if (r0 == 0) goto L_0x01c9
            net.one97.paytm.recharge.domain.entities.AutomaticProductInfo r0 = r0.getPaymentInfo()
            if (r0 == 0) goto L_0x01c9
            java.lang.String r0 = r0.getMaskedAccountNumber()
            goto L_0x01ca
        L_0x01c9:
            r0 = r4
        L_0x01ca:
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0221
            if (r0 == 0) goto L_0x01ef
            int r1 = r0.length()
            int r1 = r1 + -4
            int r2 = r0.length()
            if (r0 == 0) goto L_0x01e9
            java.lang.String r0 = r0.substring(r1, r2)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)
            goto L_0x01f0
        L_0x01e9:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r9)
            throw r0
        L_0x01ef:
            r0 = r4
        L_0x01f0:
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0213
            int r1 = net.one97.paytm.recharge.automatic.R.id.txt_card_number
            android.view.View r1 = r10.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x022e
            int r2 = net.one97.paytm.recharge.automatic.R.string.label_account_number
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r5] = r0
            java.lang.String r0 = r10.getString(r2, r3)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            goto L_0x022e
        L_0x0213:
            int r0 = net.one97.paytm.recharge.automatic.R.id.txt_card_number
            android.view.View r0 = r10.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x022e
            r0.setVisibility(r6)
            goto L_0x022e
        L_0x0221:
            int r0 = net.one97.paytm.recharge.automatic.R.id.txt_card_number
            android.view.View r0 = r10.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x022e
            r0.setVisibility(r6)
        L_0x022e:
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r0 = r10.f64722b
            if (r0 == 0) goto L_0x023d
            net.one97.paytm.recharge.domain.entities.AutomaticProductInfo r0 = r0.getPaymentInfo()
            if (r0 == 0) goto L_0x023d
            java.lang.String r0 = r0.getBankLogo()
            goto L_0x023e
        L_0x023d:
            r0 = r4
        L_0x023e:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0275
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r1 = r10.f64722b
            if (r1 == 0) goto L_0x0258
            net.one97.paytm.recharge.domain.entities.AutomaticProductInfo r1 = r1.getPaymentInfo()
            if (r1 == 0) goto L_0x0258
            java.lang.String r4 = r1.getBankLogo()
        L_0x0258:
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r4)
            int r1 = net.one97.paytm.recharge.automatic.R.id.ic_bank_logo
            android.view.View r1 = r10.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r0.a((android.widget.ImageView) r1)
            int r0 = net.one97.paytm.recharge.automatic.R.id.ic_bank_logo
            android.view.View r0 = r10.a((int) r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x0274
            r0.setVisibility(r5)
        L_0x0274:
            return
        L_0x0275:
            int r0 = net.one97.paytm.recharge.automatic.R.id.ic_bank_logo
            android.view.View r0 = r10.a((int) r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x0282
            r0.setVisibility(r6)
        L_0x0282:
            return
        L_0x0283:
            net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard r0 = r10.f64723c
            if (r0 == 0) goto L_0x028c
            java.lang.String r0 = r0.getIssuerDisplayName()
            goto L_0x028d
        L_0x028c:
            r0 = r4
        L_0x028d:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x032c
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.util.HashMap r0 = net.one97.paytm.recharge.widgets.c.d.a()
            net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard r1 = r10.f64723c
            if (r1 != 0) goto L_0x02a2
            kotlin.g.b.k.a()
        L_0x02a2:
            java.lang.String r1 = r1.getCardType()
            if (r1 == 0) goto L_0x02d2
            if (r1 == 0) goto L_0x02ca
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r1 = kotlin.m.p.b(r1)
            java.lang.String r1 = r1.toString()
            if (r1 == 0) goto L_0x02d2
            if (r1 == 0) goto L_0x02c4
            java.lang.String r1 = r1.toLowerCase()
            java.lang.String r2 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            if (r1 != 0) goto L_0x02d4
            goto L_0x02d2
        L_0x02c4:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r9)
            throw r0
        L_0x02ca:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.CharSequence"
            r0.<init>(r1)
            throw r0
        L_0x02d2:
            java.lang.String r1 = ""
        L_0x02d4:
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0312
            int r1 = net.one97.paytm.recharge.automatic.R.id.txt_bank_name
            android.view.View r1 = r10.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x032c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard r3 = r10.f64723c
            if (r3 != 0) goto L_0x02f9
            kotlin.g.b.k.a()
        L_0x02f9:
            java.lang.String r3 = r3.getIssuerDisplayName()
            r2.append(r3)
            java.lang.String r3 = " - "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            goto L_0x032c
        L_0x0312:
            int r0 = net.one97.paytm.recharge.automatic.R.id.txt_bank_name
            android.view.View r0 = r10.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x032c
            net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard r1 = r10.f64723c
            if (r1 != 0) goto L_0x0323
            kotlin.g.b.k.a()
        L_0x0323:
            java.lang.String r1 = r1.getIssuerDisplayName()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x032c:
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r0 = r10.f64722b
            if (r0 == 0) goto L_0x035d
            net.one97.paytm.recharge.domain.entities.AutomaticProductInfo r0 = r0.getPaymentInfo()
            if (r0 == 0) goto L_0x035d
            int r1 = net.one97.paytm.recharge.automatic.R.id.txt_card_number
            android.view.View r1 = r10.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0350
            net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard r2 = r10.f64723c
            if (r2 != 0) goto L_0x0347
            kotlin.g.b.k.a()
        L_0x0347:
            java.lang.String r0 = r0.getMaskedCardNumber((net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard) r2)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
        L_0x0350:
            int r0 = net.one97.paytm.recharge.automatic.R.id.txt_card_number
            android.view.View r0 = r10.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x035d
            r0.setVisibility(r5)
        L_0x035d:
            int r0 = net.one97.paytm.recharge.automatic.R.id.ic_bank_logo
            android.view.View r0 = r10.a((int) r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x039a
            int r1 = net.one97.paytm.recharge.automatic.R.id.ic_bank_logo
            android.view.View r1 = r10.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            android.content.Context r1 = r1.getContext()
            net.one97.paytm.recharge.automatic.b.a.h$a r2 = net.one97.paytm.recharge.automatic.b.a.h.f60252a
            net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard r2 = r10.f64723c
            if (r2 == 0) goto L_0x0380
            java.lang.String r4 = r2.getCardScheme()
        L_0x0380:
            if (r4 != 0) goto L_0x0385
            kotlin.g.b.k.a()
        L_0x0385:
            java.lang.Integer r2 = net.one97.paytm.recharge.automatic.b.a.h.a.g(r4)
            if (r2 == 0) goto L_0x0390
            int r2 = r2.intValue()
            goto L_0x0393
        L_0x0390:
            r2 = 17170445(0x106000d, float:2.461195E-38)
        L_0x0393:
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r2)
            r0.setImageDrawable(r1)
        L_0x039a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.b.a.c():void");
    }

    private final void d() {
        net.one97.paytm.recharge.automatic.b.a.b bVar;
        Integer num = this.f64726f;
        int status = net.one97.paytm.recharge.automatic.b.a.b.DISABLED.getStatus();
        if (num != null && num.intValue() == status) {
            bVar = net.one97.paytm.recharge.automatic.b.a.b.DISABLED;
        } else {
            Integer num2 = this.f64726f;
            bVar = (num2 != null && num2.intValue() == net.one97.paytm.recharge.automatic.b.a.b.ENABLED.getStatus()) ? net.one97.paytm.recharge.automatic.b.a.b.ENABLED : net.one97.paytm.recharge.automatic.b.a.b.DELETE;
        }
        a(bVar);
    }

    private final void a(net.one97.paytm.recharge.automatic.b.a.b bVar) {
        this.f64725e = bVar;
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.btn_activate);
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.a();
        }
        net.one97.paytm.recharge.presentation.g.a aVar = this.f64724d;
        if (aVar != null) {
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel = this.f64722b;
            aVar.a(context, cJRAutomaticSubscriptionItemModel != null ? Long.valueOf(cJRAutomaticSubscriptionItemModel.getParentOrderId()) : null, Integer.valueOf(bVar.getStatus()));
        }
    }

    static final class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f64732a;

        h(a aVar) {
            this.f64732a = aVar;
        }

        public final void run() {
            CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) this.f64732a.a(R.id.btn_activate);
            if (cJRProceedWidgetV8 != null) {
                cJRProceedWidgetV8.setEnabled(true);
            }
            this.f64732a.dismissAllowingStateLoss();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        r0 = r0.getPaymentInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.recharge.presentation.b.a r7, java.util.ArrayList r8) {
        /*
            if (r8 == 0) goto L_0x008b
            boolean r0 = r8.isEmpty()
            if (r0 == 0) goto L_0x000a
            goto L_0x008b
        L_0x000a:
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r0 = r7.f64722b
            r1 = 0
            if (r0 == 0) goto L_0x001a
            net.one97.paytm.recharge.domain.entities.AutomaticProductInfo r0 = r0.getPaymentInfo()
            if (r0 == 0) goto L_0x001a
            java.lang.String r0 = r0.getSavedCardId()
            goto L_0x001b
        L_0x001a:
            r0 = r1
        L_0x001b:
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r8 = r8.iterator()
        L_0x0028:
            boolean r3 = r8.hasNext()
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x004a
            java.lang.Object r3 = r8.next()
            r6 = r3
            net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard r6 = (net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard) r6
            java.lang.String r6 = r6.getSavedCardId()
            if (r6 == 0) goto L_0x0044
            boolean r6 = r6.equals(r0)
            if (r6 != r5) goto L_0x0044
            r4 = 1
        L_0x0044:
            if (r4 == 0) goto L_0x0028
            r2.add(r3)
            goto L_0x0028
        L_0x004a:
            java.util.List r2 = (java.util.List) r2
            r8 = r2
            java.util.Collection r8 = (java.util.Collection) r8
            boolean r8 = r8.isEmpty()
            r8 = r8 ^ r5
            if (r8 == 0) goto L_0x0062
            java.lang.Object r8 = r2.get(r4)
            net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard r8 = (net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard) r8
            r7.f64723c = r8
            r7.c()
            return
        L_0x0062:
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r8 = r7.f64722b
            if (r8 == 0) goto L_0x006b
            java.lang.String r8 = r8.getPaymentBank()
            goto L_0x006c
        L_0x006b:
            r8 = r1
        L_0x006c:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x008b
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r8 = r7.f64722b
            if (r8 == 0) goto L_0x007d
            java.lang.String r8 = r8.getPaymentBank()
            goto L_0x007e
        L_0x007d:
            r8 = r1
        L_0x007e:
            java.lang.String r0 = "PPBL"
            boolean r8 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r8, (boolean) r5)
            if (r8 == 0) goto L_0x008b
            r7.f64723c = r1
            r7.c()
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.b.a.a(net.one97.paytm.recharge.presentation.b.a, java.util.ArrayList):void");
    }

    public static final /* synthetic */ void b(a aVar) {
        TextView textView;
        if (aVar.f64725e == net.one97.paytm.recharge.automatic.b.a.b.ENABLED) {
            TextView textView2 = (TextView) aVar.a(R.id.tv_subheader);
            if (textView2 != null) {
                textView2.setText(aVar.getString(R.string.at_enable_paytm_automatic));
            }
        } else if (aVar.f64725e == net.one97.paytm.recharge.automatic.b.a.b.DISABLED && (textView = (TextView) aVar.a(R.id.tv_subheader)) != null) {
            textView.setText(aVar.getString(R.string.at_disable_paytm_automatic));
        }
        TextView textView3 = (TextView) aVar.a(R.id.tv_subheader);
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        TextView textView4 = (TextView) aVar.a(R.id.tv_subheader);
        if (textView4 != null) {
            textView4.postDelayed(new h(aVar), 3000);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a A[Catch:{ all -> 0x0068 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005e A[Catch:{ all -> 0x0068 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0060 A[Catch:{ all -> 0x0068 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void e(net.one97.paytm.recharge.presentation.b.a r11) {
        /*
            android.content.Context r0 = r11.getContext()     // Catch:{ all -> 0x0068 }
            if (r0 == 0) goto L_0x0068
            java.lang.Integer r0 = r11.f64726f     // Catch:{ all -> 0x0068 }
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x000d
            goto L_0x0016
        L_0x000d:
            int r2 = r0.intValue()     // Catch:{ all -> 0x0068 }
            if (r2 != 0) goto L_0x0016
            java.lang.String r0 = "pause"
            goto L_0x0031
        L_0x0016:
            if (r0 != 0) goto L_0x0019
            goto L_0x0023
        L_0x0019:
            int r2 = r0.intValue()     // Catch:{ all -> 0x0068 }
            r3 = 1
            if (r2 != r3) goto L_0x0023
            java.lang.String r0 = "resume"
            goto L_0x0031
        L_0x0023:
            if (r0 != 0) goto L_0x0026
            goto L_0x0030
        L_0x0026:
            int r0 = r0.intValue()     // Catch:{ all -> 0x0068 }
            r2 = -1
            if (r0 != r2) goto L_0x0030
            java.lang.String r0 = "delete"
            goto L_0x0031
        L_0x0030:
            r0 = r1
        L_0x0031:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
            r2.<init>()     // Catch:{ all -> 0x0068 }
            r2.append(r0)     // Catch:{ all -> 0x0068 }
            java.lang.String r0 = "_confirm_clicked"
            r2.append(r0)     // Catch:{ all -> 0x0068 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0068 }
            net.one97.paytm.recharge.automatic.c.a.a r0 = net.one97.paytm.recharge.automatic.c.a.a.f60256a     // Catch:{ all -> 0x0068 }
            android.content.Context r3 = r11.getContext()     // Catch:{ all -> 0x0068 }
            if (r3 != 0) goto L_0x004d
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0068 }
        L_0x004d:
            java.lang.String r0 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)     // Catch:{ all -> 0x0068 }
            net.one97.paytm.recharge.automatic.b.a.a$a r0 = net.one97.paytm.recharge.automatic.b.a.a.f60239a     // Catch:{ all -> 0x0068 }
            java.lang.String r4 = net.one97.paytm.recharge.automatic.b.a.a.f60240b     // Catch:{ all -> 0x0068 }
            java.lang.String r6 = ""
            java.lang.String r0 = r11.f64727g     // Catch:{ all -> 0x0068 }
            if (r0 != 0) goto L_0x0060
            r7 = r1
            goto L_0x0061
        L_0x0060:
            r7 = r0
        L_0x0061:
            r8 = 0
            r9 = 0
            r10 = 96
            net.one97.paytm.recharge.automatic.c.a.a.a(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0068 }
        L_0x0068:
            r11.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.b.a.e(net.one97.paytm.recharge.presentation.b.a):void");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f64728i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
