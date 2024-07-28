package net.one97.paytm.upi.registration.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.c;
import androidx.constraintlayout.widget.Group;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.ai;
import androidx.lifecycle.aj;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage;
import com.squareup.picasso.ah;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.a.b;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.models.NetworkResponse;
import net.one97.paytm.upi.common.models.Preference;
import net.one97.paytm.upi.common.models.SmartTransferReponse;
import net.one97.paytm.upi.common.models.StatusInfo;
import net.one97.paytm.upi.common.models.UPIDeregister;
import net.one97.paytm.upi.common.models.UPIProfileMultipartResponse;
import net.one97.paytm.upi.common.models.UserPreference;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.e.ag;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.j;
import net.one97.paytm.upi.mandate.view.MandateListActivity;
import net.one97.paytm.upi.passbook.view.UpiPassbookActivity;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.profile.view.UpiQrCodeActivity;
import net.one97.paytm.upi.registration.c.e;
import net.one97.paytm.upi.registration.view.x;
import net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CircleTransform;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.CustomWalletLoaderDialog;
import net.one97.paytm.upi.util.IncorrectUpiPinBottomSheet;
import net.one97.paytm.upi.util.PaytmUpiPrefUtil;
import net.one97.paytm.upi.util.UPICheckBalanceHelper;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class UPISettingsActivity extends PaytmActivity implements View.OnClickListener, n.c {

    /* renamed from: d  reason: collision with root package name */
    public static final a f68712d = new a((byte) 0);
    /* access modifiers changed from: private */
    public static boolean v;

    /* renamed from: a  reason: collision with root package name */
    public ag f68713a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressDialog f68714b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public CustomWalletLoaderDialog f68715c;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.upi.registration.c.e f68716e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public net.one97.paytm.upi.i.b f68717f;

    /* renamed from: g  reason: collision with root package name */
    private final int f68718g = 10;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final int f68719h = 12;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final int f68720i = 13;
    /* access modifiers changed from: private */
    public final int j = 31;
    private final int k = 32;
    private final int l = 34;
    private final int m = 37;
    private final int n = 203;
    private final String o = CropImage.CROP_IMAGE_EXTRA_RESULT;
    private UPICheckBalanceHelper p;
    private int q = -1;
    private boolean r;
    private boolean s;
    /* access modifiers changed from: private */
    public final UpiProfileDefaultBank t = new UpiProfileDefaultBank();
    private boolean u;

    public final void onClick(View view) {
    }

    static final class aa<T> implements androidx.lifecycle.z<net.one97.paytm.upi.j<String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68721a;

        aa(UPISettingsActivity uPISettingsActivity) {
            this.f68721a = uPISettingsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upi.j jVar = (net.one97.paytm.upi.j) obj;
            if (this.f68721a.f68715c != null) {
                UPISettingsActivity.n(this.f68721a).dismissLoader();
            }
            if (t.f69063g[jVar.f67004a.ordinal()] == 1) {
                UPISettingsActivity uPISettingsActivity = this.f68721a;
                ResultType resulttype = jVar.f67005b;
                if (resulttype == null) {
                    kotlin.g.b.k.a();
                }
                String str = (String) resulttype;
                String string = this.f68721a.getString(R.string.invite_title);
                kotlin.g.b.k.c(str, "url");
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", str);
                intent.putExtra("android.intent.extra.SUBJECT", string);
                uPISettingsActivity.startActivity(Intent.createChooser(intent, "Share via"));
            }
        }
    }

    static final class e extends kotlin.g.b.l implements kotlin.g.a.b<View, kotlin.x> {
        final /* synthetic */ UPISettingsActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(UPISettingsActivity uPISettingsActivity) {
            super(1);
            this.this$0 = uPISettingsActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(View view) {
            kotlin.g.b.k.c(view, "it");
            this.this$0.startActivity(new Intent(this.this$0, MandateListActivity.class));
            CJRSendGTMTag.sendNewCustomGTMEvents(this.this$0, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_UPI_AUTOMATIC_CLICKED, "", "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
        }
    }

    static final class h extends kotlin.g.b.l implements kotlin.g.a.b<View, kotlin.x> {
        final /* synthetic */ UPISettingsActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(UPISettingsActivity uPISettingsActivity) {
            super(1);
            this.this$0 = uPISettingsActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(View view) {
            kotlin.g.b.k.c(view, "it");
            if (!UPISettingsActivity.b(this.this$0).h()) {
                kotlin.g.b.k.a((Object) net.one97.paytm.upi.i.a(), "PaytmUpiSdk.getInstance()");
                this.this$0.startActivity(new Intent(this.this$0, RequestMoneyV2Activity.class));
                CJRSendGTMTag.sendNewCustomGTMEvents(this.this$0, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_REQUEST_MONEY_CLICKED, "", "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
            }
        }
    }

    static final class i extends kotlin.g.b.l implements kotlin.g.a.b<View, kotlin.x> {
        final /* synthetic */ UPISettingsActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(UPISettingsActivity uPISettingsActivity) {
            super(1);
            this.this$0 = uPISettingsActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(View view) {
            kotlin.g.b.k.c(view, "it");
            if (!UPISettingsActivity.b(this.this$0).h()) {
                net.one97.paytm.upi.i a2 = net.one97.paytm.upi.i.a();
                kotlin.g.b.k.a((Object) a2, "PaytmUpiSdk.getInstance()");
                a2.c().c((Activity) this.this$0);
                CJRSendGTMTag.sendNewCustomGTMEvents(this.this$0, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_BENEFICIARY_DETAILS_CLICKED, "", "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
            }
        }
    }

    static final class j extends kotlin.g.b.l implements kotlin.g.a.b<View, kotlin.x> {
        final /* synthetic */ UPISettingsActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(UPISettingsActivity uPISettingsActivity) {
            super(1);
            this.this$0 = uPISettingsActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(View view) {
            kotlin.g.b.k.c(view, "it");
            if (!UPISettingsActivity.b(this.this$0).h()) {
                Intent intent = new Intent(this.this$0, UpiPassbookActivity.class);
                intent.putExtra(UpiConstants.KEY_UPI_ITEM_TYPE, UpiConstants.UpiItemType.PENDING_REQUESTS.ordinal());
                intent.putExtra(CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, true);
                this.this$0.startActivity(intent);
                CJRSendGTMTag.sendNewCustomGTMEvents(this.this$0, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_REQUEST_MONEY_CLICKED, "", "", "", CJRGTMConstants.MT_V4_PAYMENT_REQUEST_CLICKED, "upi");
            }
        }
    }

    static final class k extends kotlin.g.b.l implements kotlin.g.a.b<View, kotlin.x> {
        final /* synthetic */ UPISettingsActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(UPISettingsActivity uPISettingsActivity) {
            super(1);
            this.this$0 = uPISettingsActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(View view) {
            kotlin.g.b.k.c(view, "it");
            if (!UPISettingsActivity.b(this.this$0).h()) {
                net.one97.paytm.upi.i a2 = net.one97.paytm.upi.i.a();
                kotlin.g.b.k.a((Object) a2, "PaytmUpiSdk.getInstance()");
                a2.c().a((Activity) this.this$0, UpiConstants.CST_DEEPLINK);
                CJRSendGTMTag.sendNewCustomGTMEvents(this.this$0, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_REQUEST_MONEY_CLICKED, "", "", "", CJRGTMConstants.MT_V4_HELP_SUPPORT_CLICKED, "upi");
            }
        }
    }

    static final class t<T> implements androidx.lifecycle.z<net.one97.paytm.upi.j<UpiProfileModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68740a;

        t(UPISettingsActivity uPISettingsActivity) {
            this.f68740a = uPISettingsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upi.j jVar = (net.one97.paytm.upi.j) obj;
            int i2 = t.f69057a[jVar.f67004a.ordinal()];
            if (i2 == 1) {
                AnimationFactory.stopWalletLoader(this.f68740a.c().I);
                UPISettingsActivity.i(this.f68740a);
            } else if (i2 == 2) {
                AnimationFactory.stopWalletLoader(this.f68740a.c().I);
                UpiCustomVolleyError upiCustomVolleyError = jVar.f67006c;
                if (upiCustomVolleyError == null || (!UpiUtils.AUTHENTICATION_FAILURE_401.equals(upiCustomVolleyError.getMessage()) && !UpiUtils.AUTHENTICATION_FAILURE_401.equals(upiCustomVolleyError.getmErrorCode()) && !"410".equals(upiCustomVolleyError.getmErrorCode()))) {
                    Toast.makeText(this.f68740a, R.string.upi_some_went_wrong, 1).show();
                    return;
                }
                net.one97.paytm.upi.i a2 = net.one97.paytm.upi.i.a();
                kotlin.g.b.k.a((Object) a2, "PaytmUpiSdk.getInstance()");
                new UpiCustomVolleyError();
                UPISettingsActivity.class.getName();
                a2.b().e(this.f68740a);
            } else if (i2 == 3) {
                AnimationFactory.startWalletLoader(this.f68740a.c().I);
            }
        }
    }

    static final class u<T> implements androidx.lifecycle.z<net.one97.paytm.upi.j<UPIDeregister>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68741a;

        u(UPISettingsActivity uPISettingsActivity) {
            this.f68741a = uPISettingsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upi.j jVar = (net.one97.paytm.upi.j) obj;
            int i2 = t.f69058b[jVar.f67004a.ordinal()];
            if (i2 == 1) {
                UPISettingsActivity.j(this.f68741a);
                UPISettingsActivity.k(this.f68741a);
                UPISettingsActivity.b(this.f68741a);
                net.one97.paytm.upi.g.a(net.one97.paytm.upi.g.a((a.C1347a) null)).c(new e.b(), "", "UPISETTINGS");
            } else if (i2 == 2) {
                UPISettingsActivity.j(this.f68741a);
                UPISettingsActivity.a(this.f68741a, jVar.f67006c);
            } else if (i2 == 3) {
                UPISettingsActivity uPISettingsActivity = this.f68741a;
                String string = uPISettingsActivity.getString(R.string.upi_deleting_profile);
                kotlin.g.b.k.a((Object) string, "getString(R.string.upi_deleting_profile)");
                UPISettingsActivity.a(uPISettingsActivity, string);
            }
        }
    }

    static final class v<T> implements androidx.lifecycle.z<net.one97.paytm.upi.j<kotlin.o<? extends String, ? extends Integer>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68742a;

        v(UPISettingsActivity uPISettingsActivity) {
            this.f68742a = uPISettingsActivity;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.Integer} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r4) {
            /*
                r3 = this;
                net.one97.paytm.upi.j r4 = (net.one97.paytm.upi.j) r4
                net.one97.paytm.upi.registration.view.UPISettingsActivity r0 = r3.f68742a
                net.one97.paytm.upi.i.b r0 = r0.f68717f
                r1 = 1
                if (r0 == 0) goto L_0x000d
                r0 = 1
                goto L_0x000e
            L_0x000d:
                r0 = 0
            L_0x000e:
                if (r0 == 0) goto L_0x00a1
                net.one97.paytm.upi.l r0 = r4.f67004a
                int[] r2 = net.one97.paytm.upi.registration.view.t.f69059c
                int r0 = r0.ordinal()
                r0 = r2[r0]
                r2 = 0
                if (r0 == r1) goto L_0x006c
                r1 = 2
                if (r0 == r1) goto L_0x0045
                r1 = 3
                if (r0 == r1) goto L_0x0025
                goto L_0x00a1
            L_0x0025:
                net.one97.paytm.upi.registration.view.UPISettingsActivity r0 = r3.f68742a
                net.one97.paytm.upi.i.b r0 = net.one97.paytm.upi.registration.view.UPISettingsActivity.l(r0)
                ResultType r4 = r4.f67005b
                kotlin.o r4 = (kotlin.o) r4
                if (r4 == 0) goto L_0x0038
                java.lang.Object r4 = r4.getSecond()
                r2 = r4
                java.lang.Integer r2 = (java.lang.Integer) r2
            L_0x0038:
                if (r2 != 0) goto L_0x003d
                kotlin.g.b.k.a()
            L_0x003d:
                int r4 = r2.intValue()
                r0.a((int) r4)
                goto L_0x00a1
            L_0x0045:
                net.one97.paytm.upi.registration.view.UPISettingsActivity r0 = r3.f68742a
                net.one97.paytm.upi.i.b r0 = net.one97.paytm.upi.registration.view.UPISettingsActivity.l(r0)
                ResultType r1 = r4.f67005b
                kotlin.o r1 = (kotlin.o) r1
                if (r1 == 0) goto L_0x0058
                java.lang.Object r1 = r1.getSecond()
                r2 = r1
                java.lang.Integer r2 = (java.lang.Integer) r2
            L_0x0058:
                if (r2 != 0) goto L_0x005d
                kotlin.g.b.k.a()
            L_0x005d:
                int r1 = r2.intValue()
                r0.b(r1)
                net.one97.paytm.upi.registration.view.UPISettingsActivity r0 = r3.f68742a
                net.one97.paytm.upi.common.UpiCustomVolleyError r4 = r4.f67006c
                net.one97.paytm.upi.registration.view.UPISettingsActivity.b((net.one97.paytm.upi.registration.view.UPISettingsActivity) r0, (net.one97.paytm.upi.common.UpiCustomVolleyError) r4)
                return
            L_0x006c:
                net.one97.paytm.upi.registration.view.UPISettingsActivity r0 = r3.f68742a
                net.one97.paytm.upi.i.b r0 = net.one97.paytm.upi.registration.view.UPISettingsActivity.l(r0)
                ResultType r4 = r4.f67005b
                kotlin.o r4 = (kotlin.o) r4
                if (r4 == 0) goto L_0x007f
                java.lang.Object r4 = r4.getSecond()
                r2 = r4
                java.lang.Integer r2 = (java.lang.Integer) r2
            L_0x007f:
                if (r2 != 0) goto L_0x0084
                kotlin.g.b.k.a()
            L_0x0084:
                int r4 = r2.intValue()
                r0.b(r4)
                net.one97.paytm.upi.registration.view.UPISettingsActivity r4 = r3.f68742a
                net.one97.paytm.upi.registration.c.e r4 = net.one97.paytm.upi.registration.view.UPISettingsActivity.b((net.one97.paytm.upi.registration.view.UPISettingsActivity) r4)
                r4.f()
                net.one97.paytm.upi.registration.view.UPISettingsActivity r4 = r3.f68742a
                net.one97.paytm.upi.i.b r0 = net.one97.paytm.upi.registration.view.UPISettingsActivity.l(r4)
                int r0 = r0.getItemCount()
                r4.a((int) r0)
            L_0x00a1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.registration.view.UPISettingsActivity.v.onChanged(java.lang.Object):void");
        }
    }

    static final class w<T> implements androidx.lifecycle.z<net.one97.paytm.upi.j<kotlin.o<? extends BankAccountDetails.BankAccount, ? extends kotlin.o<? extends Integer, ? extends Integer>>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68743a;

        w(UPISettingsActivity uPISettingsActivity) {
            this.f68743a = uPISettingsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upi.j jVar = (net.one97.paytm.upi.j) obj;
            int i2 = t.f69060d[jVar.f67004a.ordinal()];
            if (i2 == 1) {
                if (this.f68743a.f68715c != null) {
                    UPISettingsActivity.n(this.f68743a).dismissLoader();
                }
                kotlin.o oVar = (kotlin.o) jVar.f67005b;
                BankAccountDetails.BankAccount bankAccount = oVar != null ? (BankAccountDetails.BankAccount) oVar.getFirst() : null;
                if (bankAccount != null) {
                    if (bankAccount.getBankName() != null) {
                        UPISettingsActivity uPISettingsActivity = this.f68743a;
                        Toast.makeText(uPISettingsActivity, uPISettingsActivity.getString(R.string.upi_default_account_success, new Object[]{bankAccount.getBankName()}), 1).show();
                    } else {
                        UPISettingsActivity uPISettingsActivity2 = this.f68743a;
                        Toast.makeText(uPISettingsActivity2, uPISettingsActivity2.getString(R.string.upi_default_bank_changed), 1).show();
                    }
                }
                CJRSendGTMTag.sendNewCustomGTMEvents(this.f68743a, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_PRIMARY_AC_CHANGED, "", "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
                UPISettingsActivity.b(this.f68743a).f();
                a aVar = UPISettingsActivity.f68712d;
                UPISettingsActivity.v = true;
            } else if (i2 == 2) {
                if (this.f68743a.f68715c != null) {
                    UPISettingsActivity.n(this.f68743a).dismissLoader();
                }
                net.one97.paytm.upi.registration.c.e b2 = UPISettingsActivity.b(this.f68743a);
                if (b2.f68572c != null) {
                    BankAccountDetails.BankAccount bankAccount2 = b2.f68572c;
                    if (bankAccount2 == null) {
                        kotlin.g.b.k.a("previousBank");
                    }
                    b2.f68573d = bankAccount2;
                }
                UPISettingsActivity.l(this.f68743a).notifyDataSetChanged();
                if (jVar.f67006c != null) {
                    UpiCustomVolleyError upiCustomVolleyError = jVar.f67006c;
                    if (upiCustomVolleyError == null) {
                        kotlin.g.b.k.a();
                    }
                    if (upiCustomVolleyError.getmErrorCode() != null) {
                        UpiCustomVolleyError upiCustomVolleyError2 = jVar.f67006c;
                        if (upiCustomVolleyError2 == null) {
                            kotlin.g.b.k.a();
                        }
                        if (UpiUtils.isAuthenticationFailure(upiCustomVolleyError2.getmErrorCode())) {
                            new UpiCustomVolleyError();
                            net.one97.paytm.upi.i.a().b().e(this.f68743a);
                            return;
                        }
                        UpiCustomVolleyError upiCustomVolleyError3 = jVar.f67006c;
                        if (upiCustomVolleyError3 == null) {
                            kotlin.g.b.k.a();
                        }
                        if (UpiConstants.NETWORK_ERROR_CODE.equals(upiCustomVolleyError3.getmErrorCode())) {
                            UPISettingsActivity uPISettingsActivity3 = this.f68743a;
                            CustomDialog.showAlert(uPISettingsActivity3, uPISettingsActivity3.getResources().getString(R.string.no_connection), this.f68743a.getResources().getString(R.string.no_internet));
                            return;
                        }
                        UpiCustomVolleyError upiCustomVolleyError4 = jVar.f67006c;
                        if (upiCustomVolleyError4 == null) {
                            kotlin.g.b.k.a();
                        }
                        if (!TextUtils.isEmpty(upiCustomVolleyError4.getAlertMessage())) {
                            Context context = this.f68743a;
                            UpiCustomVolleyError upiCustomVolleyError5 = jVar.f67006c;
                            if (upiCustomVolleyError5 == null) {
                                kotlin.g.b.k.a();
                            }
                            Toast.makeText(context, upiCustomVolleyError5.getAlertMessage(), 1).show();
                            return;
                        }
                        UPISettingsActivity uPISettingsActivity4 = this.f68743a;
                        Toast.makeText(uPISettingsActivity4, uPISettingsActivity4.getString(R.string.upi_default_bank_account_change_failed), 1).show();
                        return;
                    }
                }
                UPISettingsActivity uPISettingsActivity5 = this.f68743a;
                Toast.makeText(uPISettingsActivity5, uPISettingsActivity5.getString(R.string.upi_default_bank_account_change_failed), 1).show();
            } else if (i2 == 3) {
                UPISettingsActivity uPISettingsActivity6 = this.f68743a;
                uPISettingsActivity6.f68715c = new CustomWalletLoaderDialog(uPISettingsActivity6);
                CustomWalletLoaderDialog customWalletLoaderDialog = uPISettingsActivity6.f68715c;
                if (customWalletLoaderDialog == null) {
                    kotlin.g.b.k.a("walletDialog");
                }
                customWalletLoaderDialog.setTitle(uPISettingsActivity6.getString(R.string.processing_your_request));
                CustomWalletLoaderDialog customWalletLoaderDialog2 = uPISettingsActivity6.f68715c;
                if (customWalletLoaderDialog2 == null) {
                    kotlin.g.b.k.a("walletDialog");
                }
                customWalletLoaderDialog2.setSetCancelable(false);
                CustomWalletLoaderDialog customWalletLoaderDialog3 = uPISettingsActivity6.f68715c;
                if (customWalletLoaderDialog3 == null) {
                    kotlin.g.b.k.a("walletDialog");
                }
                customWalletLoaderDialog3.showLoader();
            }
        }
    }

    static final class x<T> implements androidx.lifecycle.z<kotlin.o<? extends UPIProfileMultipartResponse, ? extends NetworkCustomError>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68744a;

        x(UPISettingsActivity uPISettingsActivity) {
            this.f68744a = uPISettingsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            kotlin.o oVar = (kotlin.o) obj;
            if (oVar.getFirst() != null) {
                PaytmUpiPrefUtil.Companion companion = PaytmUpiPrefUtil.Companion;
                Context applicationContext = this.f68744a.getApplicationContext();
                kotlin.g.b.k.a((Object) applicationContext, "this.applicationContext");
                com.paytm.b.a.a pref = companion.getPref(applicationContext);
                Object first = oVar.getFirst();
                if (first == null) {
                    kotlin.g.b.k.a();
                }
                pref.a(UpiConstantServiceApi.KEY_PROFILE_PIC_URL, ((UPIProfileMultipartResponse) first).getUserPicture(), true);
                androidx.localbroadcastmanager.a.a.a((Context) this.f68744a).a(new Intent("action_update_flyout"));
                UPISettingsActivity uPISettingsActivity = this.f68744a;
                Object first2 = oVar.getFirst();
                if (first2 == null) {
                    kotlin.g.b.k.a();
                }
                String userPicture = ((UPIProfileMultipartResponse) first2).getUserPicture();
                kotlin.g.b.k.a((Object) userPicture, "it.first!!.userPicture");
                kotlin.g.b.k.c(userPicture, "imageUrl");
                com.squareup.picasso.aa a2 = com.squareup.picasso.w.a().a(userPicture).a((ah) new CircleTransform()).a(R.drawable.profile_logout);
                ag agVar = uPISettingsActivity.f68713a;
                if (agVar == null) {
                    kotlin.g.b.k.a("binding");
                }
                a2.a(agVar.X, (com.squareup.picasso.e) new q(uPISettingsActivity, userPicture));
            } else if (oVar.getSecond() != null) {
                net.one97.paytm.upi.i a3 = net.one97.paytm.upi.i.a();
                kotlin.g.b.k.a((Object) a3, "PaytmUpiSdk.getInstance()");
                a3.c().a((Activity) this.f68744a, (NetworkCustomError) oVar.getSecond(), this.f68744a.getClass().getName());
            }
        }
    }

    static final class y<T> implements androidx.lifecycle.z<net.one97.paytm.upi.j<kotlin.o<? extends UserPreference, ? extends UpiCustomVolleyError>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68745a;

        y(UPISettingsActivity uPISettingsActivity) {
            this.f68745a = uPISettingsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str;
            Context context;
            net.one97.paytm.upi.j jVar = (net.one97.paytm.upi.j) obj;
            int i2 = t.f69061e[jVar.f67004a.ordinal()];
            boolean z = true;
            if (i2 == 1) {
                try {
                    ResultType resulttype = jVar.f67005b;
                    if (resulttype == null) {
                        kotlin.g.b.k.a();
                    }
                    Object first = ((kotlin.o) resulttype).getFirst();
                    if (first == null) {
                        kotlin.g.b.k.a();
                    }
                    StatusInfo statusInfo = ((UserPreference) first).getStatusInfo();
                    if (statusInfo == null) {
                        kotlin.g.b.k.a();
                    }
                    if (kotlin.g.b.k.a((Object) statusInfo.getStatusCode(), (Object) "UPS_0001")) {
                        ResultType resulttype2 = jVar.f67005b;
                        if (resulttype2 == null) {
                            kotlin.g.b.k.a();
                        }
                        Object first2 = ((kotlin.o) resulttype2).getFirst();
                        if (first2 == null) {
                            kotlin.g.b.k.a();
                        }
                        NetworkResponse response = ((UserPreference) first2).getResponse();
                        if (response == null) {
                            kotlin.g.b.k.a();
                        }
                        List<Preference> preferences = response.getPreferences();
                        Collection collection = preferences;
                        if (collection != null) {
                            if (!collection.isEmpty()) {
                                z = false;
                            }
                        }
                        if (!z) {
                            CheckBox checkBox = this.f68745a.c().ab;
                            kotlin.g.b.k.a((Object) checkBox, "binding.walletMoneyTransfer");
                            checkBox.setChecked(Boolean.parseBoolean(preferences.get(0).getValue()));
                            return;
                        }
                        ResultType resulttype3 = jVar.f67005b;
                        if (resulttype3 == null) {
                            kotlin.g.b.k.a();
                        }
                        Object first3 = ((kotlin.o) resulttype3).getFirst();
                        if (first3 == null) {
                            kotlin.g.b.k.a();
                        }
                        NetworkResponse response2 = ((UserPreference) first3).getResponse();
                        if (response2 == null) {
                            kotlin.g.b.k.a();
                        }
                        if (response2.getPreference() != null) {
                            CheckBox checkBox2 = this.f68745a.c().ab;
                            kotlin.g.b.k.a((Object) checkBox2, "binding.walletMoneyTransfer");
                            ResultType resulttype4 = jVar.f67005b;
                            if (resulttype4 == null) {
                                kotlin.g.b.k.a();
                            }
                            Object first4 = ((kotlin.o) resulttype4).getFirst();
                            if (first4 == null) {
                                kotlin.g.b.k.a();
                            }
                            NetworkResponse response3 = ((UserPreference) first4).getResponse();
                            if (response3 == null) {
                                kotlin.g.b.k.a();
                            }
                            Preference preference = response3.getPreference();
                            if (preference == null) {
                                kotlin.g.b.k.a();
                            }
                            checkBox2.setChecked(Boolean.parseBoolean(preference.getValue()));
                            return;
                        }
                        return;
                    }
                    CheckBox checkBox3 = this.f68745a.c().ab;
                    kotlin.g.b.k.a((Object) checkBox3, "binding.walletMoneyTransfer");
                    CheckBox checkBox4 = this.f68745a.c().ab;
                    kotlin.g.b.k.a((Object) checkBox4, "binding.walletMoneyTransfer");
                    if (checkBox4.isChecked()) {
                        z = false;
                    }
                    checkBox3.setChecked(z);
                    Context context2 = this.f68745a;
                    ResultType resulttype5 = jVar.f67005b;
                    if (resulttype5 == null) {
                        kotlin.g.b.k.a();
                    }
                    Object first5 = ((kotlin.o) resulttype5).getFirst();
                    if (first5 == null) {
                        kotlin.g.b.k.a();
                    }
                    StatusInfo statusInfo2 = ((UserPreference) first5).getStatusInfo();
                    if (statusInfo2 == null) {
                        kotlin.g.b.k.a();
                    }
                    Toast.makeText(context2, statusInfo2.getStatusMessage(), 0).show();
                } catch (Exception unused) {
                    Context context3 = this.f68745a;
                    ResultType resulttype6 = jVar.f67005b;
                    if (resulttype6 == null) {
                        kotlin.g.b.k.a();
                    }
                    Object first6 = ((kotlin.o) resulttype6).getFirst();
                    if (first6 == null) {
                        kotlin.g.b.k.a();
                    }
                    StatusInfo statusInfo3 = ((UserPreference) first6).getStatusInfo();
                    if (statusInfo3 == null) {
                        kotlin.g.b.k.a();
                    }
                    Toast.makeText(context3, statusInfo3.getStatusMessage(), 0).show();
                }
            } else if (i2 == 2) {
                UpiCustomVolleyError upiCustomVolleyError = jVar.f67006c;
                String str2 = null;
                if (upiCustomVolleyError != null) {
                    str = upiCustomVolleyError.getmErrorCode();
                } else {
                    str = null;
                }
                if (kotlin.g.b.k.a((Object) str, (Object) UpiUtils.AUTHENTICATION_FAILURE_401)) {
                    UpiCustomVolleyError upiCustomVolleyError2 = jVar.f67006c;
                    if (upiCustomVolleyError2 == null) {
                        kotlin.g.b.k.a();
                    }
                    TextUtils.isEmpty(upiCustomVolleyError2.getValue());
                } else {
                    UpiCustomVolleyError upiCustomVolleyError3 = jVar.f67006c;
                    if (!TextUtils.isEmpty(upiCustomVolleyError3 != null ? upiCustomVolleyError3.getAlertMessage() : null)) {
                        UPISettingsActivity uPISettingsActivity = this.f68745a;
                        str2 = uPISettingsActivity.getString(R.string.error_msg);
                        context = uPISettingsActivity;
                    } else {
                        context = this.f68745a;
                        UpiCustomVolleyError upiCustomVolleyError4 = jVar.f67006c;
                        if (upiCustomVolleyError4 != null) {
                            str2 = upiCustomVolleyError4.getAlertMessage();
                        }
                    }
                    Toast.makeText(context, str2, 0).show();
                }
                UpiCustomVolleyError upiCustomVolleyError5 = jVar.f67006c;
                if (upiCustomVolleyError5 == null) {
                    kotlin.g.b.k.a();
                }
                if (!TextUtils.isEmpty(upiCustomVolleyError5.getValue())) {
                    CheckBox checkBox5 = this.f68745a.c().ab;
                    kotlin.g.b.k.a((Object) checkBox5, "binding.walletMoneyTransfer");
                    CheckBox checkBox6 = this.f68745a.c().ab;
                    kotlin.g.b.k.a((Object) checkBox6, "binding.walletMoneyTransfer");
                    checkBox5.setChecked(!checkBox6.isChecked());
                }
            }
        }
    }

    static final class z<T> implements androidx.lifecycle.z<net.one97.paytm.upi.j<kotlin.o<? extends SmartTransferReponse, ? extends UpiCustomVolleyError>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68746a;

        z(UPISettingsActivity uPISettingsActivity) {
            this.f68746a = uPISettingsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upi.j jVar = (net.one97.paytm.upi.j) obj;
            int i2 = t.f69062f[jVar.f67004a.ordinal()];
            String str = null;
            if (i2 == 1) {
                ResultType resulttype = jVar.f67005b;
                if (resulttype == null) {
                    kotlin.g.b.k.a();
                }
                SmartTransferReponse smartTransferReponse = (SmartTransferReponse) ((kotlin.o) resulttype).getFirst();
                if (kotlin.m.p.a(smartTransferReponse != null ? smartTransferReponse.getStatus() : null, "SUCCESS", true)) {
                    CheckBox checkBox = this.f68746a.c().N;
                    kotlin.g.b.k.a((Object) checkBox, "binding.smartTransfer");
                    if (smartTransferReponse != null) {
                        str = smartTransferReponse.getAction();
                    }
                    checkBox.setChecked(kotlin.m.p.a(str, UpiConstants.ENABLE, true));
                    return;
                }
                if (kotlin.m.p.a(smartTransferReponse != null ? smartTransferReponse.getStatus() : null, "FAILURE", true)) {
                    CheckBox checkBox2 = this.f68746a.c().N;
                    kotlin.g.b.k.a((Object) checkBox2, "binding.smartTransfer");
                    if (smartTransferReponse != null) {
                        str = smartTransferReponse.getAction();
                    }
                    checkBox2.setChecked(!kotlin.m.p.a(str, UpiConstants.ENABLE, true));
                    UPISettingsActivity uPISettingsActivity = this.f68746a;
                    Toast.makeText(uPISettingsActivity, uPISettingsActivity.getString(R.string.error_msg), 0).show();
                }
            } else if (i2 == 2) {
                UpiCustomVolleyError upiCustomVolleyError = jVar.f67006c;
                if (upiCustomVolleyError == null) {
                    kotlin.g.b.k.a();
                }
                if (kotlin.m.p.a(upiCustomVolleyError.getValue(), UpiConstants.ENABLE, true)) {
                    CheckBox checkBox3 = this.f68746a.c().N;
                    kotlin.g.b.k.a((Object) checkBox3, "binding.smartTransfer");
                    checkBox3.setChecked(false);
                } else {
                    UpiCustomVolleyError upiCustomVolleyError2 = jVar.f67006c;
                    if (upiCustomVolleyError2 == null) {
                        kotlin.g.b.k.a();
                    }
                    if (kotlin.m.p.a(upiCustomVolleyError2.getValue(), UpiConstants.DISABLE, true)) {
                        CheckBox checkBox4 = this.f68746a.c().N;
                        kotlin.g.b.k.a((Object) checkBox4, "binding.smartTransfer");
                        checkBox4.setChecked(true);
                    }
                }
                UpiCustomVolleyError upiCustomVolleyError3 = jVar.f67006c;
                if (upiCustomVolleyError3 == null) {
                    kotlin.g.b.k.a();
                }
                if (!TextUtils.isEmpty(upiCustomVolleyError3.getAlertMessage())) {
                    Context context = this.f68746a;
                    UpiCustomVolleyError upiCustomVolleyError4 = jVar.f67006c;
                    if (upiCustomVolleyError4 != null) {
                        str = upiCustomVolleyError4.getAlertMessage();
                    }
                    Toast.makeText(context, str, 0).show();
                    return;
                }
                UPISettingsActivity uPISettingsActivity2 = this.f68746a;
                Toast.makeText(uPISettingsActivity2, uPISettingsActivity2.getString(R.string.error_msg), 0).show();
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.upi.registration.c.e b(UPISettingsActivity uPISettingsActivity) {
        net.one97.paytm.upi.registration.c.e eVar = uPISettingsActivity.f68716e;
        if (eVar == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        return eVar;
    }

    public static final /* synthetic */ net.one97.paytm.upi.i.b l(UPISettingsActivity uPISettingsActivity) {
        net.one97.paytm.upi.i.b bVar = uPISettingsActivity.f68717f;
        if (bVar == null) {
            kotlin.g.b.k.a("bankAdapter");
        }
        return bVar;
    }

    public static final /* synthetic */ CustomWalletLoaderDialog n(UPISettingsActivity uPISettingsActivity) {
        CustomWalletLoaderDialog customWalletLoaderDialog = uPISettingsActivity.f68715c;
        if (customWalletLoaderDialog == null) {
            kotlin.g.b.k.a("walletDialog");
        }
        return customWalletLoaderDialog;
    }

    public static final /* synthetic */ UPICheckBalanceHelper t(UPISettingsActivity uPISettingsActivity) {
        UPICheckBalanceHelper uPICheckBalanceHelper = uPISettingsActivity.p;
        if (uPICheckBalanceHelper == null) {
            kotlin.g.b.k.a("helper");
        }
        return uPICheckBalanceHelper;
    }

    public final ag c() {
        ag agVar = this.f68713a;
        if (agVar == null) {
            kotlin.g.b.k.a("binding");
        }
        return agVar;
    }

    public final void attachBaseContext(Context context) {
        net.one97.paytm.upi.i a2 = net.one97.paytm.upi.i.a();
        kotlin.g.b.k.a((Object) a2, "PaytmUpiSdk.getInstance()");
        if (a2.c() == null) {
            super.attachBaseContext(context);
            return;
        }
        net.one97.paytm.upi.i a3 = net.one97.paytm.upi.i.a();
        kotlin.g.b.k.a((Object) a3, "PaytmUpiSdk.getInstance()");
        ContextWrapper d2 = a3.c().d(context);
        if (d2 != null) {
            super.attachBaseContext(d2);
        } else {
            super.attachBaseContext(context);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        net.one97.paytm.upi.profile.b.b a2 = net.one97.paytm.upi.g.a();
        kotlin.g.b.k.a((Object) a2, "Injection.provideUpiProfileRepository(this)");
        Context context = this;
        ai a3 = new al((ao) this, (al.b) new net.one97.paytm.upi.registration.c.a.b(a2, context)).a(net.one97.paytm.upi.registration.c.e.class);
        kotlin.g.b.k.a((Object) a3, "ViewModelProvider(\n     …ngsViewModel::class.java]");
        this.f68716e = (net.one97.paytm.upi.registration.c.e) a3;
        net.one97.paytm.upi.registration.c.e eVar = this.f68716e;
        if (eVar == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        eVar.f68570a = getIntent().getBooleanExtra(UpiConstants.INACTIVE_USER, false);
        this.q = getIntent().getIntExtra("redirect", -1);
        this.s = getIntent().getBooleanExtra("invokedFromPaytmHome", false);
        this.r = getIntent().getBooleanExtra(UpiConstants.EXTRA_KEY_IS_FROM_ON_BOARDING, false);
        net.one97.paytm.upi.registration.c.e eVar2 = this.f68716e;
        if (eVar2 == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        if (eVar2.f68570a) {
            androidx.fragment.app.q a4 = getSupportFragmentManager().a();
            x.a aVar = x.f69085a;
            a4.b(16908290, new x(), "upi_reactivate").a("upi_reactivate").c();
        } else if (UpiUtils.isInActiveProfileExist(context)) {
            androidx.fragment.app.q a5 = getSupportFragmentManager().a();
            x.a aVar2 = x.f69085a;
            a5.b(16908290, new x(), "upi_reactivate").a("upi_reactivate").c();
        } else {
            e();
        }
    }

    private final void e() {
        Activity activity = this;
        UpiUtils.setStatusBarColor(17170443, activity);
        ag a2 = ag.a(getLayoutInflater());
        kotlin.g.b.k.a((Object) a2, "UpiSettingsBinding.inflate(layoutInflater)");
        this.f68713a = a2;
        ag agVar = this.f68713a;
        if (agVar == null) {
            kotlin.g.b.k.a("binding");
        }
        CoordinatorLayout coordinatorLayout = agVar.M;
        kotlin.g.b.k.a((Object) coordinatorLayout, "binding.root");
        setContentView((View) coordinatorLayout);
        i();
        g();
        f();
        ag agVar2 = this.f68713a;
        if (agVar2 == null) {
            kotlin.g.b.k.a("binding");
        }
        Group group = agVar2.W;
        kotlin.g.b.k.a((Object) group, "binding.upimandateGroup");
        View view = group;
        if (this.f68716e == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        net.one97.paytm.upi.f.a(view, net.one97.paytm.upi.registration.c.e.j());
        ag agVar3 = this.f68713a;
        if (agVar3 == null) {
            kotlin.g.b.k.a("binding");
        }
        agVar3.z.f66772d.setOnClickListener(new b(this));
        ag agVar4 = this.f68713a;
        if (agVar4 == null) {
            kotlin.g.b.k.a("binding");
        }
        Group group2 = agVar4.J;
        kotlin.g.b.k.a((Object) group2, "binding.requestMoneyGroup");
        a(group2, (kotlin.g.a.b<? super View, kotlin.x>) new h(this));
        ag agVar5 = this.f68713a;
        if (agVar5 == null) {
            kotlin.g.b.k.a("binding");
        }
        Group group3 = agVar5.f66760a;
        kotlin.g.b.k.a((Object) group3, "binding.accountBeneficiaryGroup");
        a(group3, (kotlin.g.a.b<? super View, kotlin.x>) new i(this));
        ag agVar6 = this.f68713a;
        if (agVar6 == null) {
            kotlin.g.b.k.a("binding");
        }
        Group group4 = agVar6.F;
        kotlin.g.b.k.a((Object) group4, "binding.paymentRequestGroup");
        a(group4, (kotlin.g.a.b<? super View, kotlin.x>) new j(this));
        ag agVar7 = this.f68713a;
        if (agVar7 == null) {
            kotlin.g.b.k.a("binding");
        }
        Group group5 = agVar7.l;
        kotlin.g.b.k.a((Object) group5, "binding.helpGroup");
        a(group5, (kotlin.g.a.b<? super View, kotlin.x>) new k(this));
        ag agVar8 = this.f68713a;
        if (agVar8 == null) {
            kotlin.g.b.k.a("binding");
        }
        agVar8.N.setOnClickListener(new l(this));
        ag agVar9 = this.f68713a;
        if (agVar9 == null) {
            kotlin.g.b.k.a("binding");
        }
        agVar9.P.setOnClickListener(new m(this));
        ag agVar10 = this.f68713a;
        if (agVar10 == null) {
            kotlin.g.b.k.a("binding");
        }
        agVar10.X.setOnClickListener(new n(this));
        ag agVar11 = this.f68713a;
        if (agVar11 == null) {
            kotlin.g.b.k.a("binding");
        }
        agVar11.ae.setOnClickListener(new o(this));
        ag agVar12 = this.f68713a;
        if (agVar12 == null) {
            kotlin.g.b.k.a("binding");
        }
        agVar12.ad.setOnClickListener(new c(this));
        ag agVar13 = this.f68713a;
        if (agVar13 == null) {
            kotlin.g.b.k.a("binding");
        }
        agVar13.ab.setOnClickListener(new d(this));
        ag agVar14 = this.f68713a;
        if (agVar14 == null) {
            kotlin.g.b.k.a("binding");
        }
        Group group6 = agVar14.W;
        kotlin.g.b.k.a((Object) group6, "binding.upimandateGroup");
        a(group6, (kotlin.g.a.b<? super View, kotlin.x>) new e(this));
        ag agVar15 = this.f68713a;
        if (agVar15 == null) {
            kotlin.g.b.k.a("binding");
        }
        agVar15.f66763d.setOnClickListener(new f(this));
        this.p = new UPICheckBalanceHelper.UPICheckBalanceBuilder(this, this).setDeviceBindingRequestCode(112).setScreenName(getLocalClassName()).setTag(getLocalClassName()).setOnActivityResultRecieverAfterDeviceBinding(activity).build();
        if (this.r) {
            b.a aVar = net.one97.paytm.upi.a.b.f66500a;
            androidx.fragment.app.j supportFragmentManager = getSupportFragmentManager();
            kotlin.g.b.k.a((Object) supportFragmentManager, "supportFragmentManager");
            b.a.a(supportFragmentManager);
        }
        ag agVar16 = this.f68713a;
        if (agVar16 == null) {
            kotlin.g.b.k.a("binding");
        }
        agVar16.f66768i.setOnClickListener(new g(this));
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68726a;

        b(UPISettingsActivity uPISettingsActivity) {
            this.f68726a = uPISettingsActivity;
        }

        public final void onClick(View view) {
            UPISettingsActivity.a(this.f68726a);
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68731a;

        l(UPISettingsActivity uPISettingsActivity) {
            this.f68731a = uPISettingsActivity;
        }

        public final void onClick(View view) {
            UPISettingsActivity.c(this.f68731a);
            UPISettingsActivity.d(this.f68731a);
        }
    }

    static final class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68732a;

        m(UPISettingsActivity uPISettingsActivity) {
            this.f68732a = uPISettingsActivity;
        }

        public final void onClick(View view) {
            CheckBox checkBox = this.f68732a.c().N;
            kotlin.g.b.k.a((Object) checkBox, "binding.smartTransfer");
            CheckBox checkBox2 = this.f68732a.c().N;
            kotlin.g.b.k.a((Object) checkBox2, "binding.smartTransfer");
            checkBox.setChecked(!checkBox2.isChecked());
            UPISettingsActivity.c(this.f68732a);
            UPISettingsActivity.d(this.f68732a);
        }
    }

    static final class n implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68733a;

        n(UPISettingsActivity uPISettingsActivity) {
            this.f68733a = uPISettingsActivity;
        }

        public final void onClick(View view) {
            if (!com.paytm.utility.s.a() || com.paytm.utility.s.c((Activity) this.f68733a)) {
                net.one97.paytm.upi.i a2 = net.one97.paytm.upi.i.a();
                kotlin.g.b.k.a((Object) a2, "PaytmUpiSdk.getInstance()");
                a2.c().d((Activity) this.f68733a);
            } else {
                com.paytm.utility.s.b((Activity) this.f68733a);
            }
            if (TextUtils.isEmpty(com.paytm.utility.b.al(this.f68733a))) {
                CJRSendGTMTag.sendNewCustomGTMEvents(this.f68733a, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_PHOTO_CLICKED, "false", "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
            } else {
                CJRSendGTMTag.sendNewCustomGTMEvents(this.f68733a, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_PHOTO_CLICKED, "true", "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
            }
        }
    }

    static final class o implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68734a;

        o(UPISettingsActivity uPISettingsActivity) {
            this.f68734a = uPISettingsActivity;
        }

        public final void onClick(View view) {
            CheckBox checkBox = this.f68734a.c().ab;
            kotlin.g.b.k.a((Object) checkBox, "binding.walletMoneyTransfer");
            CheckBox checkBox2 = this.f68734a.c().ab;
            kotlin.g.b.k.a((Object) checkBox2, "binding.walletMoneyTransfer");
            checkBox.setChecked(!checkBox2.isChecked());
            UPISettingsActivity.e(this.f68734a);
            UPISettingsActivity.f(this.f68734a);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68727a;

        c(UPISettingsActivity uPISettingsActivity) {
            this.f68727a = uPISettingsActivity;
        }

        public final void onClick(View view) {
            CheckBox checkBox = this.f68727a.c().ab;
            kotlin.g.b.k.a((Object) checkBox, "binding.walletMoneyTransfer");
            CheckBox checkBox2 = this.f68727a.c().ab;
            kotlin.g.b.k.a((Object) checkBox2, "binding.walletMoneyTransfer");
            checkBox.setChecked(!checkBox2.isChecked());
            UPISettingsActivity.e(this.f68727a);
            UPISettingsActivity.f(this.f68727a);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68728a;

        d(UPISettingsActivity uPISettingsActivity) {
            this.f68728a = uPISettingsActivity;
        }

        public final void onClick(View view) {
            UPISettingsActivity.e(this.f68728a);
            UPISettingsActivity.f(this.f68728a);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68729a;

        f(UPISettingsActivity uPISettingsActivity) {
            this.f68729a = uPISettingsActivity;
        }

        public final void onClick(View view) {
            if (!UPISettingsActivity.b(this.f68729a).e()) {
                this.f68729a.h();
            } else if (!TextUtils.isEmpty(UPISettingsActivity.b(this.f68729a).f68577h)) {
                UPISettingsActivity uPISettingsActivity = this.f68729a;
                AccountProviderActivity.a((Activity) uPISettingsActivity, uPISettingsActivity.j);
            } else {
                UPISettingsActivity uPISettingsActivity2 = this.f68729a;
                Toast.makeText(uPISettingsActivity2, uPISettingsActivity2.getResources().getString(R.string.upi_vpa_missing_error_message), 1).show();
            }
            CJRSendGTMTag.sendNewCustomGTMEvents(this.f68729a, "mt_p2p_new_v1", CJRGTMConstants.MT_ADD_NEW_AC_CLICKED, "", "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68730a;

        g(UPISettingsActivity uPISettingsActivity) {
            this.f68730a = uPISettingsActivity;
        }

        public final void onClick(View view) {
            if (!kotlin.m.p.a(UPISettingsActivity.b(this.f68730a).f68577h)) {
                UPISettingsActivity uPISettingsActivity = this.f68730a;
                UpiUtils.copyTextToClipboard(uPISettingsActivity, "vpa", UPISettingsActivity.b(uPISettingsActivity).f68577h);
                net.one97.paytm.upi.f.a((Context) this.f68730a, R.string.upi_vpa_copied, 0);
            }
        }
    }

    private final void f() {
        Context context = this;
        String al = com.paytm.utility.b.al(context);
        boolean z2 = false;
        if (!TextUtils.isEmpty(al)) {
            com.bumptech.glide.e.a c2 = ((com.bumptech.glide.e.h) new com.bumptech.glide.e.h().a(R.drawable.profile_logout)).c(R.drawable.profile_logout);
            kotlin.g.b.k.a((Object) c2, "RequestOptions()\n       ….drawable.profile_logout)");
            com.bumptech.glide.h<Drawable> a2 = com.bumptech.glide.b.b(getApplicationContext()).a(al).b((com.bumptech.glide.e.a<?>) ((com.bumptech.glide.e.h) c2).j());
            ag agVar = this.f68713a;
            if (agVar == null) {
                kotlin.g.b.k.a("binding");
            }
            kotlin.g.b.k.a((Object) a2.a(agVar.X), "Glide.with(applicationCo… .into(binding.userImage)");
        } else {
            ag agVar2 = this.f68713a;
            if (agVar2 == null) {
                kotlin.g.b.k.a("binding");
            }
            agVar2.X.setImageResource(R.drawable.upi_settings_add_photo);
            ag agVar3 = this.f68713a;
            if (agVar3 == null) {
                kotlin.g.b.k.a("binding");
            }
            ImageView imageView = agVar3.X;
            kotlin.g.b.k.a((Object) imageView, "binding.userImage");
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ag agVar4 = this.f68713a;
            if (agVar4 == null) {
                kotlin.g.b.k.a("binding");
            }
            ImageView imageView2 = agVar4.X;
            kotlin.g.b.k.a((Object) imageView2, "binding.userImage");
            imageView2.setBackground(androidx.core.content.b.a(context, R.drawable.upi_settings_photo_bg));
            ag agVar5 = this.f68713a;
            if (agVar5 == null) {
                kotlin.g.b.k.a("binding");
            }
            ImageView imageView3 = agVar5.j;
            kotlin.g.b.k.a((Object) imageView3, "binding.editPhoto");
            imageView3.setVisibility(8);
            if (UpiAppUtils.shouldShowToolTip(context)) {
                ag agVar6 = this.f68713a;
                if (agVar6 == null) {
                    kotlin.g.b.k.a("binding");
                }
                TextView textView = agVar6.x;
                kotlin.g.b.k.a((Object) textView, "binding.imageUploadTooltip");
                textView.setVisibility(0);
                new Handler().postDelayed(new p(this), 5000);
            }
        }
        ag agVar7 = this.f68713a;
        if (agVar7 == null) {
            kotlin.g.b.k.a("binding");
        }
        TextView textView2 = agVar7.Y;
        kotlin.g.b.k.a((Object) textView2, "binding.userName");
        CharSequence text = textView2.getText();
        if (text == null || text.length() == 0) {
            z2 = true;
        }
        if (z2) {
            try {
                net.one97.paytm.upi.registration.c.e eVar = this.f68716e;
                if (eVar == null) {
                    kotlin.g.b.k.a("upiSettingsViewModel");
                }
                BankAccountDetails.BankAccount debitBank = eVar.a().getDebitBank();
                kotlin.g.b.k.a((Object) debitBank, "upiSettingsViewModel.primaryBank.debitBank");
                String customerName = debitBank.getCustomerName();
                net.one97.paytm.upi.registration.c.e eVar2 = this.f68716e;
                if (eVar2 == null) {
                    kotlin.g.b.k.a("upiSettingsViewModel");
                }
                BankAccountDetails.BankAccount debitBank2 = eVar2.a().getDebitBank();
                kotlin.g.b.k.a((Object) debitBank2, "upiSettingsViewModel.primaryBank.debitBank");
                if (!TextUtils.isEmpty(debitBank2.getCustomerName())) {
                    ag agVar8 = this.f68713a;
                    if (agVar8 == null) {
                        kotlin.g.b.k.a("binding");
                    }
                    TextView textView3 = agVar8.Y;
                    kotlin.g.b.k.a((Object) textView3, "binding.userName");
                    textView3.setText(net.one97.paytm.upi.f.a(customerName));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        UpiGTMLoader instance = UpiGTMLoader.getInstance();
        kotlin.g.b.k.a((Object) instance, "UpiGTMLoader.getInstance()");
        if (instance.getWalletPreferenceStatus()) {
            net.one97.paytm.upi.registration.c.e eVar3 = this.f68716e;
            if (eVar3 == null) {
                kotlin.g.b.k.a("upiSettingsViewModel");
            }
            if (!eVar3.i()) {
                ag agVar9 = this.f68713a;
                if (agVar9 == null) {
                    kotlin.g.b.k.a("binding");
                }
                Group group = agVar9.af;
                kotlin.g.b.k.a((Object) group, "binding.walletTransferGroup");
                net.one97.paytm.upi.f.a((View) group);
                ag agVar10 = this.f68713a;
                if (agVar10 == null) {
                    kotlin.g.b.k.a("binding");
                }
                TextView textView4 = agVar10.ac;
                kotlin.g.b.k.a((Object) textView4, "binding.walletMoneyTransferHeader");
                net.one97.paytm.upi.f.a((View) textView4);
                ag agVar11 = this.f68713a;
                if (agVar11 == null) {
                    kotlin.g.b.k.a("binding");
                }
                CheckBox checkBox = agVar11.ab;
                kotlin.g.b.k.a((Object) checkBox, "binding.walletMoneyTransfer");
                net.one97.paytm.upi.f.a((View) checkBox);
                ag agVar12 = this.f68713a;
                if (agVar12 == null) {
                    kotlin.g.b.k.a("binding");
                }
                TextView textView5 = agVar12.ad;
                kotlin.g.b.k.a((Object) textView5, "binding.walletMoneyTransferLbl");
                net.one97.paytm.upi.f.a((View) textView5);
                ag agVar13 = this.f68713a;
                if (agVar13 == null) {
                    kotlin.g.b.k.a("binding");
                }
                TextView textView6 = agVar13.ae;
                kotlin.g.b.k.a((Object) textView6, "binding.walletMoneyTransferLblInfo");
                net.one97.paytm.upi.f.a((View) textView6);
                ag agVar14 = this.f68713a;
                if (agVar14 == null) {
                    kotlin.g.b.k.a("binding");
                }
                FrameLayout frameLayout = agVar14.aa;
                kotlin.g.b.k.a((Object) frameLayout, "binding.walletLogo");
                net.one97.paytm.upi.f.a((View) frameLayout);
                ag agVar15 = this.f68713a;
                if (agVar15 == null) {
                    kotlin.g.b.k.a("binding");
                }
                View view = agVar15.f66767h;
                kotlin.g.b.k.a((Object) view, "binding.barrier3");
                net.one97.paytm.upi.f.a(view);
                return;
            }
            return;
        }
        ag agVar16 = this.f68713a;
        if (agVar16 == null) {
            kotlin.g.b.k.a("binding");
        }
        Group group2 = agVar16.af;
        kotlin.g.b.k.a((Object) group2, "binding.walletTransferGroup");
        net.one97.paytm.upi.f.a((View) group2);
        ag agVar17 = this.f68713a;
        if (agVar17 == null) {
            kotlin.g.b.k.a("binding");
        }
        TextView textView7 = agVar17.ac;
        kotlin.g.b.k.a((Object) textView7, "binding.walletMoneyTransferHeader");
        net.one97.paytm.upi.f.a((View) textView7);
        ag agVar18 = this.f68713a;
        if (agVar18 == null) {
            kotlin.g.b.k.a("binding");
        }
        CheckBox checkBox2 = agVar18.ab;
        kotlin.g.b.k.a((Object) checkBox2, "binding.walletMoneyTransfer");
        net.one97.paytm.upi.f.a((View) checkBox2);
        ag agVar19 = this.f68713a;
        if (agVar19 == null) {
            kotlin.g.b.k.a("binding");
        }
        TextView textView8 = agVar19.ad;
        kotlin.g.b.k.a((Object) textView8, "binding.walletMoneyTransferLbl");
        net.one97.paytm.upi.f.a((View) textView8);
        ag agVar20 = this.f68713a;
        if (agVar20 == null) {
            kotlin.g.b.k.a("binding");
        }
        TextView textView9 = agVar20.ae;
        kotlin.g.b.k.a((Object) textView9, "binding.walletMoneyTransferLblInfo");
        net.one97.paytm.upi.f.a((View) textView9);
        ag agVar21 = this.f68713a;
        if (agVar21 == null) {
            kotlin.g.b.k.a("binding");
        }
        FrameLayout frameLayout2 = agVar21.aa;
        kotlin.g.b.k.a((Object) frameLayout2, "binding.walletLogo");
        net.one97.paytm.upi.f.a((View) frameLayout2);
        ag agVar22 = this.f68713a;
        if (agVar22 == null) {
            kotlin.g.b.k.a("binding");
        }
        View view2 = agVar22.f66767h;
        kotlin.g.b.k.a((Object) view2, "binding.barrier3");
        net.one97.paytm.upi.f.a(view2);
    }

    static final class p implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68735a;

        p(UPISettingsActivity uPISettingsActivity) {
            this.f68735a = uPISettingsActivity;
        }

        public final void run() {
            TextView textView = this.f68735a.c().x;
            kotlin.g.b.k.a((Object) textView, "binding.imageUploadTooltip");
            textView.setVisibility(8);
        }
    }

    private final void g() {
        net.one97.paytm.upi.registration.c.e eVar = this.f68716e;
        if (eVar == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        eVar.f();
        net.one97.paytm.upi.registration.c.e eVar2 = this.f68716e;
        if (eVar2 == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        androidx.lifecycle.q qVar = this;
        eVar2.m.observe(qVar, new t(this));
        net.one97.paytm.upi.registration.c.e eVar3 = this.f68716e;
        if (eVar3 == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        eVar3.l.observe(qVar, new u(this));
        net.one97.paytm.upi.registration.c.e eVar4 = this.f68716e;
        if (eVar4 == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        eVar4.n.observe(qVar, new v(this));
        net.one97.paytm.upi.registration.c.e eVar5 = this.f68716e;
        if (eVar5 == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        eVar5.q.observe(qVar, new w(this));
        net.one97.paytm.upi.registration.c.e eVar6 = this.f68716e;
        if (eVar6 == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        eVar6.p.observe(qVar, new x(this));
        net.one97.paytm.upi.registration.c.e eVar7 = this.f68716e;
        if (eVar7 == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        eVar7.c(UpiConstants.UPI_SETTINGS_WALLET_USER_PREFERENCE).observe(qVar, new y(this));
        net.one97.paytm.upi.registration.c.e eVar8 = this.f68716e;
        if (eVar8 == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        eVar8.r.observe(qVar, new z(this));
        net.one97.paytm.upi.registration.c.e eVar9 = this.f68716e;
        if (eVar9 == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        eVar9.o.observe(qVar, new aa(this));
    }

    /* access modifiers changed from: private */
    public final void a(int i2) {
        if (i2 <= 1) {
            ag agVar = this.f68713a;
            if (agVar == null) {
                kotlin.g.b.k.a("binding");
            }
            Group group = agVar.O;
            kotlin.g.b.k.a((Object) group, "binding.smartTransferGroup");
            net.one97.paytm.upi.f.a((View) group);
            return;
        }
        ag agVar2 = this.f68713a;
        if (agVar2 == null) {
            kotlin.g.b.k.a("binding");
        }
        Group group2 = agVar2.O;
        kotlin.g.b.k.a((Object) group2, "binding.smartTransferGroup");
        net.one97.paytm.upi.f.b((View) group2);
    }

    public static final class r implements net.one97.paytm.upi.i.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68738a;

        r(UPISettingsActivity uPISettingsActivity) {
            this.f68738a = uPISettingsActivity;
        }

        public final void a(BankAccountDetails.BankAccount bankAccount, int i2) {
            kotlin.g.b.k.c(bankAccount, "bankAccount");
            if (!UPISettingsActivity.b(this.f68738a).h()) {
                net.one97.paytm.upi.registration.c.e b2 = UPISettingsActivity.b(this.f68738a);
                if (b2.f68573d != null) {
                    BankAccountDetails.BankAccount bankAccount2 = b2.f68573d;
                    if (bankAccount2 == null) {
                        kotlin.g.b.k.a("selectedBank");
                    }
                    b2.f68572c = bankAccount2;
                }
                UPISettingsActivity.b(this.f68738a).a(bankAccount);
                net.one97.paytm.upi.registration.c.e b3 = UPISettingsActivity.b(this.f68738a);
                androidx.lifecycle.y<net.one97.paytm.upi.j<kotlin.o<BankAccountDetails.BankAccount, kotlin.o<Integer, Integer>>>> yVar = b3.q;
                j.a aVar = net.one97.paytm.upi.j.f67003d;
                yVar.setValue(j.a.a());
                b3.u.a(UpiConstants.PROFILE_VPA_ACCOUNT_TYPE.DEBIT, b3.g(), new e.a(b3, i2), b3.f68575f, b3.f68578i);
            }
        }

        public final void b(BankAccountDetails.BankAccount bankAccount, int i2) {
            kotlin.g.b.k.c(bankAccount, "bankAccount");
            if (!UPISettingsActivity.b(this.f68738a).h()) {
                net.one97.paytm.upi.registration.c.e b2 = UPISettingsActivity.b(this.f68738a);
                kotlin.g.b.k.c(bankAccount, "bankAccount");
                List arrayList = new ArrayList();
                arrayList.add(bankAccount);
                UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, b2.f68577h).setBankAccountList(arrayList).setSelectedBankIdx(0).build();
                b2.n.setValue(new net.one97.paytm.upi.j(net.one97.paytm.upi.l.LOADING, new kotlin.o(null, Integer.valueOf(i2)), (UpiCustomVolleyError) null, 12));
                b2.u.a(build, (a.C1382a) new e.c(b2, i2), b2.f68575f, b2.f68578i);
                CJRSendGTMTag.sendNewCustomGTMEvents(this.f68738a, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_REMOVE_AC_CLICKED, "", "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
            }
        }

        public final void a(BankAccountDetails.BankAccount bankAccount) {
            kotlin.g.b.k.c(bankAccount, "bankAccount");
            UPISettingsActivity.b(this.f68738a).a(bankAccount);
            if (UPISettingsActivity.b(this.f68738a).e()) {
                this.f68738a.j();
            } else {
                UPISettingsActivity uPISettingsActivity = this.f68738a;
                uPISettingsActivity.b(uPISettingsActivity.f68719h);
            }
            CJRSendGTMTag.sendNewCustomGTMEvents(this.f68738a, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_CHANGE_PIN_CLICKED, "", "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
        }

        public final void b(BankAccountDetails.BankAccount bankAccount) {
            kotlin.g.b.k.c(bankAccount, "bankAccount");
            UPISettingsActivity.b(this.f68738a).a(bankAccount);
            if (UPISettingsActivity.b(this.f68738a).e()) {
                this.f68738a.j();
            } else {
                UPISettingsActivity uPISettingsActivity = this.f68738a;
                uPISettingsActivity.b(uPISettingsActivity.f68720i);
            }
            CJRSendGTMTag.sendNewCustomGTMEvents(this.f68738a, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_SET_UPI_PIN, "", "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
        }

        public final void a(Context context) {
            kotlin.g.b.k.c(context, "context");
            CustomDialog.showAlert(context, this.f68738a.getResources().getString(R.string.no_connection), this.f68738a.getResources().getString(R.string.no_internet));
        }

        public final void c(BankAccountDetails.BankAccount bankAccount, int i2) {
            kotlin.g.b.k.c(bankAccount, "bankAccount");
            if (!UpiAppUtils.isNetworkAvailable(this.f68738a)) {
                UPISettingsActivity uPISettingsActivity = this.f68738a;
                CustomDialog.showAlert(uPISettingsActivity, uPISettingsActivity.getResources().getString(R.string.no_connection), this.f68738a.getResources().getString(R.string.no_internet));
            } else if (!UPISettingsActivity.b(this.f68738a).f68571b) {
                UPISettingsActivity.b(this.f68738a).f68571b = true;
                UPISettingsActivity.b(this.f68738a).s = i2;
                this.f68738a.t.setDebitBank(bankAccount);
                UPISettingsActivity.b(this.f68738a).a(bankAccount);
                UPISettingsActivity.t(this.f68738a).getUpiAccountBalance(this.f68738a.t);
                CJRSendGTMTag.sendNewCustomGTMEvents(this.f68738a, "mt_p2p_new_v1", "check_balance_clicked", "", "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
            }
        }
    }

    /* access modifiers changed from: private */
    public final void h() {
        Intent intent = new Intent(this, UpiRegistrationActivity.class);
        intent.putExtra("redirect", 112);
        intent.setFlags(536870912);
        startActivityForResult(intent, 112);
    }

    /* access modifiers changed from: private */
    public final void b(int i2) {
        Intent intent = new Intent(this, UpiRegistrationActivity.class);
        intent.putExtra("redirect", i2);
        startActivityForResult(intent, i2);
    }

    private final void i() {
        ag agVar = this.f68713a;
        if (agVar == null) {
            kotlin.g.b.k.a("binding");
        }
        setSupportActionBar(agVar.Q);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.b(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.a(true);
        }
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 != null) {
            supportActionBar3.c(false);
        }
        ag agVar2 = this.f68713a;
        if (agVar2 == null) {
            kotlin.g.b.k.a("binding");
        }
        agVar2.Q.setNavigationOnClickListener(new s(this));
    }

    static final class s implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68739a;

        s(UPISettingsActivity uPISettingsActivity) {
            this.f68739a = uPISettingsActivity;
        }

        public final void onClick(View view) {
            this.f68739a.onBackPressed();
        }
    }

    public final boolean onPrepareOptionsMenu(Menu menu) {
        kotlin.g.b.k.c(menu, "menu");
        MenuItem findItem = menu.findItem(R.id.menu_edit_upi_id);
        findItem.setTitle(getString(R.string.edit_upi_id));
        MenuItem findItem2 = menu.findItem(R.id.menu_show_qr);
        findItem2.setTitle(getString(R.string.upi_my_qr_code));
        menu.findItem(R.id.menu_link_account).setTitle(getString(R.string.upi_link_account));
        menu.findItem(R.id.menu_spam_folder).setTitle(getString(R.string.upi_spam_requests_folder));
        menu.findItem(R.id.menu_deregister_upi).setTitle(getString(R.string.upi_disable_upi));
        kotlin.g.b.k.a((Object) findItem, "editVpaItem");
        UpiGTMLoader instance = UpiGTMLoader.getInstance();
        kotlin.g.b.k.a((Object) instance, "UpiGTMLoader.getInstance()");
        Boolean isEditVpaEnabled = instance.isEditVpaEnabled();
        kotlin.g.b.k.a((Object) isEditVpaEnabled, "UpiGTMLoader.getInstance().isEditVpaEnabled");
        findItem.setVisible(isEditVpaEnabled.booleanValue());
        kotlin.g.b.k.a((Object) findItem2, "myQrCode");
        findItem2.setVisible(this.u);
        return true;
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.upi_landing_menu, menu);
        return true;
    }

    public final boolean onMenuOpened(int i2, Menu menu) {
        if (menu != null) {
            CJRSendGTMTag.sendNewCustomGTMEvents(this, "mt_p2p_new_v1", "three_dots_icon_clicked", "", "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
        }
        return super.onMenuOpened(i2, menu);
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        Integer valueOf = menuItem != null ? Integer.valueOf(menuItem.getItemId()) : null;
        int i2 = R.id.menu_spam_folder;
        if (valueOf != null && valueOf.intValue() == i2) {
            Context context = this;
            Intent intent = new Intent(context, UpiPassbookActivity.class);
            intent.putExtra(UpiConstants.KEY_UPI_ITEM_TYPE, UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal());
            startActivityForResult(intent, 38);
            CJRSendGTMTag.sendNewCustomGTMEvents(context, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_ACTION_THREE_DOTS, "spam_requests_folder", "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
        } else {
            int i3 = R.id.menu_deregister_upi;
            if (valueOf != null && valueOf.intValue() == i3) {
                Context context2 = this;
                if (UpiAppUtils.isNetworkAvailable(context2)) {
                    c.a aVar = new c.a(context2);
                    aVar.a(true);
                    aVar.b(R.string.upi_deregister_msg);
                    aVar.a(R.string.upi_deregister_profile);
                    aVar.a(R.string.ok, (DialogInterface.OnClickListener) new ab(this));
                    aVar.b(R.string.cancel, (DialogInterface.OnClickListener) new ac(this));
                    aVar.b();
                } else {
                    CustomDialog.showAlert(context2, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet_new_message));
                }
                CJRSendGTMTag.sendNewCustomGTMEvents(context2, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_ACTION_THREE_DOTS, "deregister_upi_id", "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
            } else {
                int i4 = R.id.menu_edit_upi_id;
                if (valueOf != null && valueOf.intValue() == i4) {
                    Context context3 = this;
                    Intent intent2 = new Intent(context3, EditVpaActivity.class);
                    net.one97.paytm.upi.registration.c.e eVar = this.f68716e;
                    if (eVar == null) {
                        kotlin.g.b.k.a("upiSettingsViewModel");
                    }
                    intent2.putExtra("current vpa", eVar.f68577h);
                    startActivityForResult(intent2, this.m);
                    CJRSendGTMTag.sendNewCustomGTMEvents(context3, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_ACTION_THREE_DOTS, "edit_upi_id", "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
                } else {
                    int i5 = R.id.menu_link_account;
                    if (valueOf != null && valueOf.intValue() == i5) {
                        net.one97.paytm.upi.registration.c.e eVar2 = this.f68716e;
                        if (eVar2 == null) {
                            kotlin.g.b.k.a("upiSettingsViewModel");
                        }
                        if (eVar2.e()) {
                            AccountProviderActivity.a((Activity) this, this.j);
                        } else {
                            b(this.k);
                        }
                    } else {
                        int i6 = R.id.menu_show_qr;
                        if (valueOf != null && valueOf.intValue() == i6) {
                            Context context4 = this;
                            net.one97.paytm.upi.registration.c.e eVar3 = this.f68716e;
                            if (eVar3 == null) {
                                kotlin.g.b.k.a("upiSettingsViewModel");
                            }
                            UpiQrCodeActivity.a(context4, eVar3.a());
                        }
                    }
                }
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    static final class ab implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68722a;

        ab(UPISettingsActivity uPISettingsActivity) {
            this.f68722a = uPISettingsActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            UPISettingsActivity.b(this.f68722a).d();
            dialogInterface.dismiss();
            CJRSendGTMTag.sendNewCustomGTMEvents(this.f68722a, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_UPI_DEREGISTER, "true", "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
        }
    }

    static final class ac implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68723a;

        ac(UPISettingsActivity uPISettingsActivity) {
            this.f68723a = uPISettingsActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
            CJRSendGTMTag.sendNewCustomGTMEvents(this.f68723a, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_UPI_DEREGISTER, "false", "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
        }
    }

    private static void a(Group group, kotlin.g.a.b<? super View, kotlin.x> bVar) {
        kotlin.g.b.k.c(group, "$this$addOnClickListener");
        kotlin.g.b.k.c(bVar, "listener");
        int[] referencedIds = group.getReferencedIds();
        kotlin.g.b.k.a((Object) referencedIds, "referencedIds");
        for (int findViewById : referencedIds) {
            group.getRootView().findViewById(findViewById).setOnClickListener(new u(bVar));
        }
    }

    /* JADX WARNING: type inference failed for: r4v6, types: [java.io.Serializable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int r8, int r9, android.content.Intent r10) {
        /*
            r7 = this;
            super.onActivityResult(r8, r9, r10)
            int r0 = r7.m
            java.lang.String r1 = "upiSettingsViewModel"
            r2 = -1
            if (r8 != r0) goto L_0x0023
            if (r9 != r2) goto L_0x0023
            net.one97.paytm.upi.registration.c.e r8 = r7.f68716e
            if (r8 != 0) goto L_0x0013
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0013:
            net.one97.paytm.upi.profile.b.b r8 = r8.u
            r8.c()
            net.one97.paytm.upi.registration.c.e r8 = r7.f68716e
            if (r8 != 0) goto L_0x001f
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x001f:
            r8.f()
            return
        L_0x0023:
            r0 = 5001(0x1389, float:7.008E-42)
            if (r8 != r0) goto L_0x0034
            if (r9 != r2) goto L_0x0213
            net.one97.paytm.upi.registration.c.e r8 = r7.f68716e
            if (r8 != 0) goto L_0x0030
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0030:
            r8.d()
            return
        L_0x0034:
            int r0 = r7.j
            java.lang.String r3 = "account_provider"
            r4 = 0
            if (r8 != r0) goto L_0x0061
            if (r9 != r2) goto L_0x0213
            if (r10 == 0) goto L_0x0043
            java.io.Serializable r4 = r10.getSerializableExtra(r3)
        L_0x0043:
            if (r4 == 0) goto L_0x0059
            net.one97.paytm.upi.common.upi.AccountProviderBody$AccountProvider r4 = (net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider) r4
            r8 = r7
            android.app.Activity r8 = (android.app.Activity) r8
            net.one97.paytm.upi.registration.c.e r9 = r7.f68716e
            if (r9 != 0) goto L_0x0051
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0051:
            java.lang.String r9 = r9.f68577h
            int r10 = r7.l
            net.one97.paytm.upi.profile.view.BankVpaCreationActivity.a((android.app.Activity) r8, (net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider) r4, (java.lang.String) r9, (int) r10)
            return
        L_0x0059:
            kotlin.u r8 = new kotlin.u
            java.lang.String r9 = "null cannot be cast to non-null type net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider"
            r8.<init>(r9)
            throw r8
        L_0x0061:
            int r0 = r7.l
            if (r8 != r0) goto L_0x0075
            if (r9 != r2) goto L_0x0213
            net.one97.paytm.upi.registration.c.e r8 = r7.f68716e
            if (r8 != 0) goto L_0x006e
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x006e:
            r8.f()
            r7.setResult(r2)
            return
        L_0x0075:
            int r0 = r7.f68718g
            if (r8 != r0) goto L_0x0086
            if (r9 != r2) goto L_0x0086
            net.one97.paytm.upi.registration.c.e r8 = r7.f68716e
            if (r8 != 0) goto L_0x0082
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0082:
            r8.f()
            return
        L_0x0086:
            int r0 = r7.f68720i
            if (r8 != r0) goto L_0x0090
            if (r9 != r2) goto L_0x0090
            r7.j()
            return
        L_0x0090:
            int r0 = r7.j
            if (r8 != r0) goto L_0x00b7
            if (r9 != r2) goto L_0x0213
            if (r10 == 0) goto L_0x009d
            java.io.Serializable r8 = r10.getSerializableExtra(r3)
            goto L_0x009e
        L_0x009d:
            r8 = r4
        L_0x009e:
            boolean r9 = r8 instanceof net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider
            if (r9 != 0) goto L_0x00a3
            r8 = r4
        L_0x00a3:
            net.one97.paytm.upi.common.upi.AccountProviderBody$AccountProvider r8 = (net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider) r8
            r9 = r7
            android.app.Activity r9 = (android.app.Activity) r9
            net.one97.paytm.upi.registration.c.e r10 = r7.f68716e
            if (r10 != 0) goto L_0x00af
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00af:
            java.lang.String r10 = r10.f68577h
            int r0 = r7.l
            net.one97.paytm.upi.profile.view.BankVpaCreationActivity.a((android.app.Activity) r9, (net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider) r8, (java.lang.String) r10, (int) r0)
            return
        L_0x00b7:
            r0 = 36
            r3 = 0
            if (r8 != r0) goto L_0x00eb
            if (r9 != r2) goto L_0x0213
            net.one97.paytm.upi.registration.c.e r8 = r7.f68716e
            if (r8 != 0) goto L_0x00c5
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00c5:
            r8.f68570a = r3
            int r8 = r7.q
            if (r8 == r2) goto L_0x00d6
            android.content.Intent r8 = r7.getIntent()
            r7.setResult(r2, r8)
            r7.finish()
            return
        L_0x00d6:
            androidx.fragment.app.j r8 = r7.getSupportFragmentManager()
            java.lang.String r9 = "upi_reactivate"
            r8.a((java.lang.String) r9)
            boolean r8 = r7.s
            if (r8 == 0) goto L_0x00e7
            r7.e()
            return
        L_0x00e7:
            r7.finish()
            return
        L_0x00eb:
            int r0 = r7.n
            if (r8 != r0) goto L_0x0213
            if (r10 == 0) goto L_0x0213
            if (r9 != r2) goto L_0x0213
            android.os.Bundle r8 = r10.getExtras()
            if (r8 == 0) goto L_0x0100
            java.lang.String r9 = r7.o
            java.lang.Object r8 = r8.get(r9)
            goto L_0x0101
        L_0x0100:
            r8 = r4
        L_0x0101:
            r9 = 1
            if (r8 == 0) goto L_0x0201
            java.lang.String r8 = android.os.Environment.getExternalStorageState()
            java.lang.String r10 = "mounted"
            boolean r8 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r10)
            if (r8 == 0) goto L_0x01ee
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.io.File r10 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r10 = r10.toString()
            r8.append(r10)
            r10 = r7
            android.content.Context r10 = (android.content.Context) r10
            java.lang.String r0 = com.paytm.utility.b.am(r10)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            java.io.File r0 = new java.io.File
            r0.<init>(r8)
            boolean r8 = r0.exists()
            if (r8 == 0) goto L_0x0213
            java.io.File[] r8 = r0.listFiles()
            java.lang.String r0 = "directoryPath.listFiles()"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            int r0 = r8.length
        L_0x0143:
            if (r3 >= r0) goto L_0x015c
            r2 = r8[r3]
            java.lang.String r5 = "it"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            java.lang.String r5 = r2.getName()
            java.lang.String r6 = "picture.jpg"
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r6, (boolean) r9)
            if (r5 == 0) goto L_0x0159
            r4 = r2
        L_0x0159:
            int r3 = r3 + 1
            goto L_0x0143
        L_0x015c:
            if (r4 != 0) goto L_0x016e
            int r8 = net.one97.paytm.upi.R.string.something_went_wrong
            java.lang.String r8 = r7.getString(r8)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            android.widget.Toast r8 = android.widget.Toast.makeText(r10, r8, r9)
            r8.show()
            return
        L_0x016e:
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            if (r4 != 0) goto L_0x0175
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
        L_0x0175:
            java.lang.String r10 = r4.getAbsolutePath()     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            r8.<init>(r10)     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            android.net.Uri r8 = android.net.Uri.fromFile(r8)     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            if (r4 != 0) goto L_0x0185
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
        L_0x0185:
            java.lang.String r10 = r4.getAbsolutePath()     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            java.lang.String r10 = net.one97.paytm.upi.util.UpiAppUtils.compressImage(r10)     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            if (r10 == 0) goto L_0x01d1
            java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            r9.<init>(r10)     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            android.content.ContentResolver r10 = r7.getContentResolver()     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            android.graphics.Bitmap r8 = android.provider.MediaStore.Images.Media.getBitmap(r10, r8)     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            net.one97.paytm.upi.e.ag r10 = r7.f68713a     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            if (r10 != 0) goto L_0x01a5
            java.lang.String r0 = "binding"
            kotlin.g.b.k.a((java.lang.String) r0)     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
        L_0x01a5:
            android.widget.ImageView r10 = r10.X     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            net.one97.paytm.upi.util.CircleTransform r0 = new net.one97.paytm.upi.util.CircleTransform     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            r0.<init>()     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            java.lang.String r2 = "bitmap"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r2)     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            android.graphics.Bitmap r8 = r0.transform(r8)     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            r10.setImageBitmap(r8)     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            net.one97.paytm.upi.registration.c.e r8 = r7.f68716e     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            if (r8 != 0) goto L_0x01bf
            kotlin.g.b.k.a((java.lang.String) r1)     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
        L_0x01bf:
            java.lang.String r10 = "imageFile"
            kotlin.g.b.k.c(r9, r10)     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            net.one97.paytm.upi.profile.b.b r10 = r8.u     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            net.one97.paytm.upi.registration.c.e$j r0 = new net.one97.paytm.upi.registration.c.e$j     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            r0.<init>(r8)     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            net.one97.paytm.upi.profile.b.a$d r0 = (net.one97.paytm.upi.profile.b.a.d) r0     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            r10.a((net.one97.paytm.upi.profile.b.a.d) r0, (java.io.File) r9)     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            return
        L_0x01d1:
            r8 = r7
            android.content.Context r8 = (android.content.Context) r8     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            int r10 = net.one97.paytm.upi.R.string.something_went_wrong     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            java.lang.String r10 = r7.getString(r10)     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            android.widget.Toast r8 = android.widget.Toast.makeText(r8, r10, r9)     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            r8.show()     // Catch:{ Exception -> 0x01e9, Error -> 0x01e4 }
            return
        L_0x01e4:
            r8 = move-exception
            r8.printStackTrace()
            return
        L_0x01e9:
            r8 = move-exception
            r8.printStackTrace()
            return
        L_0x01ee:
            r8 = r7
            android.content.Context r8 = (android.content.Context) r8
            int r10 = net.one97.paytm.upi.R.string.something_went_wrong
            java.lang.String r10 = r7.getString(r10)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            android.widget.Toast r8 = android.widget.Toast.makeText(r8, r10, r9)
            r8.show()
            return
        L_0x0201:
            r8 = r7
            android.content.Context r8 = (android.content.Context) r8
            int r10 = net.one97.paytm.upi.R.string.something_went_wrong
            java.lang.String r10 = r7.getString(r10)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            android.widget.Toast r8 = android.widget.Toast.makeText(r8, r10, r9)
            r8.show()
        L_0x0213:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.registration.view.UPISettingsActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    static final class ae implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68725a;

        ae(UPISettingsActivity uPISettingsActivity) {
            this.f68725a = uPISettingsActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            this.f68725a.k();
            this.f68725a.finish();
        }
    }

    public final void a(n.b bVar) {
        kotlin.g.b.k.c(bVar, "errorUPI");
        if (!isFinishing() && !isDestroyed()) {
            net.one97.paytm.upi.registration.c.e eVar = this.f68716e;
            if (eVar == null) {
                kotlin.g.b.k.a("upiSettingsViewModel");
            }
            eVar.f68571b = false;
            net.one97.paytm.upi.i.b bVar2 = this.f68717f;
            if (bVar2 == null) {
                kotlin.g.b.k.a("bankAdapter");
            }
            net.one97.paytm.upi.registration.c.e eVar2 = this.f68716e;
            if (eVar2 == null) {
                kotlin.g.b.k.a("upiSettingsViewModel");
            }
            bVar2.b(eVar2.s);
            if (bVar == n.b.INCORRECT_MPIN) {
                b(false);
            } else if (bVar == n.b.INCORRECT_MPIN_TOO_MANY_TIMES) {
                b(true);
            } else if (bVar != n.b.ERROR_BACK_PRESSED) {
                net.one97.paytm.upi.registration.c.e eVar3 = this.f68716e;
                if (eVar3 == null) {
                    kotlin.g.b.k.a("upiSettingsViewModel");
                }
                eVar3.s = -1;
                UpiUtils.handleCheckBalanceError(this, bVar);
            }
            CJRSendGTMTag.sendNewCustomGTMEvents(this, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_CHECK_BALANCE_ERROR, bVar.name(), "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
        }
    }

    public final void a(String str, String str2, String str3) {
        kotlin.g.b.k.c(str3, "accountType");
        if (!isFinishing() && !isDestroyed()) {
            net.one97.paytm.upi.i.b bVar = this.f68717f;
            if (bVar == null) {
                kotlin.g.b.k.a("bankAdapter");
            }
            net.one97.paytm.upi.registration.c.e eVar = this.f68716e;
            if (eVar == null) {
                kotlin.g.b.k.a("upiSettingsViewModel");
            }
            bVar.b(eVar.s);
            net.one97.paytm.upi.registration.c.e eVar2 = this.f68716e;
            if (eVar2 == null) {
                kotlin.g.b.k.a("upiSettingsViewModel");
            }
            eVar2.f68571b = false;
            net.one97.paytm.upi.i.b bVar2 = this.f68717f;
            if (bVar2 == null) {
                kotlin.g.b.k.a("bankAdapter");
            }
            net.one97.paytm.upi.registration.c.e eVar3 = this.f68716e;
            if (eVar3 == null) {
                kotlin.g.b.k.a("upiSettingsViewModel");
            }
            int i2 = eVar3.s;
            kotlin.g.b.k.c(str3, "accountType");
            if (i2 >= 0) {
                bVar2.f66989a.get(i2).totalBalance = str;
                bVar2.f66989a.get(i2).availableBalance = str2;
                bVar2.f66989a.get(i2).balanceAccountType = str3;
                bVar2.f66989a.get(i2).formattedTimeStamp = DateFormat.format("hh:mm a, dd MMMM yyyy", new Date()).toString();
                bVar2.notifyItemChanged(i2);
            }
            net.one97.paytm.upi.registration.c.e eVar4 = this.f68716e;
            if (eVar4 == null) {
                kotlin.g.b.k.a("upiSettingsViewModel");
            }
            eVar4.s = -1;
            net.one97.paytm.upi.i.b bVar3 = this.f68717f;
            if (bVar3 == null) {
                kotlin.g.b.k.a("bankAdapter");
            }
            net.one97.paytm.upi.registration.c.e eVar5 = this.f68716e;
            if (eVar5 == null) {
                kotlin.g.b.k.a("upiSettingsViewModel");
            }
            bVar3.b(eVar5.s);
            CJRSendGTMTag.sendNewCustomGTMEvents(this, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_CHECK_BALANCE_COMPLETED, "", "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
        }
    }

    public final void b() {
        StringBuilder sb = new StringBuilder("Requst Ended :: ");
        net.one97.paytm.upi.registration.c.e eVar = this.f68716e;
        if (eVar == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        sb.append(eVar.s);
    }

    public final void Z_() {
        StringBuilder sb = new StringBuilder("Requst started :: ");
        net.one97.paytm.upi.registration.c.e eVar = this.f68716e;
        if (eVar == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        sb.append(eVar.s);
        net.one97.paytm.upi.i.b bVar = this.f68717f;
        if (bVar == null) {
            kotlin.g.b.k.a("bankAdapter");
        }
        net.one97.paytm.upi.registration.c.e eVar2 = this.f68716e;
        if (eVar2 == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        bVar.a(eVar2.s);
    }

    public static final class ad implements IncorrectUpiPinBottomSheet.OnItemClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68724a;

        ad(UPISettingsActivity uPISettingsActivity) {
            this.f68724a = uPISettingsActivity;
        }

        public final void onReEnterClicked() {
            UPISettingsActivity.t(this.f68724a).getUpiAccountBalance(this.f68724a.t);
            CJRSendGTMTag.sendNewCustomGTMEvents(this.f68724a, "mt_p2p_new_v1", "UPI_pin_reentered", "", "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
        }

        public final void onCreateNewPinClicked() {
            UPISettingsActivity.v(this.f68724a);
            CJRSendGTMTag.sendNewCustomGTMEvents(this.f68724a, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_RESET_UPI_PIN, "", "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
        }
    }

    private final void b(boolean z2) {
        try {
            androidx.fragment.app.j supportFragmentManager = getSupportFragmentManager();
            kotlin.g.b.k.a((Object) supportFragmentManager, "supportFragmentManager");
            IncorrectUpiPinBottomSheet.Companion.show(new ad(this), supportFragmentManager, z2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public final void j() {
        Context context = this;
        if (UpiAppUtils.isNetworkAvailable(context)) {
            net.one97.paytm.upi.registration.c.e eVar = this.f68716e;
            if (eVar == null) {
                kotlin.g.b.k.a("upiSettingsViewModel");
            }
            if (eVar.g().getBankAccountList() != null) {
                net.one97.paytm.upi.h c2 = net.one97.paytm.upi.i.a().c();
                StringBuilder sb = new StringBuilder();
                net.one97.paytm.upi.registration.c.e eVar2 = this.f68716e;
                if (eVar2 == null) {
                    kotlin.g.b.k.a("upiSettingsViewModel");
                }
                sb.append(String.valueOf(eVar2.g().getBankAccountList().size()));
                sb.append("_");
                net.one97.paytm.upi.registration.c.e eVar3 = this.f68716e;
                if (eVar3 == null) {
                    kotlin.g.b.k.a("upiSettingsViewModel");
                }
                sb.append(eVar3.g().getSelectedBankIdx());
                c2.a("UpiProfileAccountDetailActivity", sb.toString());
            } else {
                net.one97.paytm.upi.h c3 = net.one97.paytm.upi.i.a().c();
                StringBuilder sb2 = new StringBuilder("null_");
                net.one97.paytm.upi.registration.c.e eVar4 = this.f68716e;
                if (eVar4 == null) {
                    kotlin.g.b.k.a("upiSettingsViewModel");
                }
                sb2.append(eVar4.g().getSelectedBankIdx());
                c3.a("UpiProfileAccountDetailActivity", sb2.toString());
            }
            Activity activity = this;
            net.one97.paytm.upi.registration.c.e eVar5 = this.f68716e;
            if (eVar5 == null) {
                kotlin.g.b.k.a("upiSettingsViewModel");
            }
            SetMPINActivity.a(activity, eVar5.g(), this.f68718g, false);
            return;
        }
        CustomDialog.showAlert(context, getString(R.string.no_connection), getString(R.string.no_internet_new_message));
    }

    public final void onResume() {
        super.onResume();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Context context) {
            kotlin.g.b.k.c(context, "context");
            context.startActivity(new Intent(context, UPISettingsActivity.class));
        }
    }

    public static final class q implements com.squareup.picasso.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UPISettingsActivity f68736a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f68737b;

        q(UPISettingsActivity uPISettingsActivity, String str) {
            this.f68736a = uPISettingsActivity;
            this.f68737b = str;
        }

        public final void onSuccess() {
            com.paytm.utility.b.a((Context) this.f68736a, Boolean.TRUE);
            net.one97.paytm.upi.registration.c.e b2 = UPISettingsActivity.b(this.f68736a);
            String str = this.f68737b;
            kotlin.g.b.k.c(str, "imageUrl");
            Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(b2), Dispatchers.getIO(), (CoroutineStart) null, new e.g(b2, str, (kotlin.d.d) null), 2, (Object) null);
        }

        public final void onError(Exception exc) {
            this.f68736a.c().X.setImageResource(R.drawable.profile_logout);
        }
    }

    public final void onBackPressed() {
        super.onBackPressed();
        net.one97.paytm.upi.registration.c.e eVar = this.f68716e;
        if (eVar == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        if (eVar.k != null) {
            List<? extends BankAccountDetails.BankAccount> list = eVar.k;
            if (list == null) {
                kotlin.g.b.k.a("bankAccountList");
            }
            for (BankAccountDetails.BankAccount bankAccount : list) {
                bankAccount.setSelected(false);
                bankAccount.totalBalance = null;
                bankAccount.progress = false;
                bankAccount.availableBalance = null;
            }
        }
        k();
        finish();
        CJRSendGTMTag.sendNewCustomGTMEvents(this, "mt_p2p_new_v1", "back_button_clicked", "", "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
    }

    /* access modifiers changed from: private */
    public final void k() {
        net.one97.paytm.upi.registration.c.e eVar = this.f68716e;
        if (eVar == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        if (eVar.t) {
            setResult(-1, new Intent());
        }
    }

    public static final /* synthetic */ void a(UPISettingsActivity uPISettingsActivity) {
        UpiGTMLoader instance = UpiGTMLoader.getInstance();
        kotlin.g.b.k.a((Object) instance, "UpiGTMLoader.getInstance()");
        String referralDeeplink = instance.getReferralDeeplink();
        net.one97.paytm.upi.i a2 = net.one97.paytm.upi.i.a();
        kotlin.g.b.k.a((Object) a2, "PaytmUpiSdk.getInstance()");
        a2.c().a((Activity) uPISettingsActivity, referralDeeplink);
        CJRSendGTMTag.sendNewCustomGTMEvents(uPISettingsActivity, "mt_p2p_new_v1", "invite_now_clicked", "", "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
    }

    public static final /* synthetic */ void c(UPISettingsActivity uPISettingsActivity) {
        ag agVar = uPISettingsActivity.f68713a;
        if (agVar == null) {
            kotlin.g.b.k.a("binding");
        }
        CheckBox checkBox = agVar.N;
        kotlin.g.b.k.a((Object) checkBox, "binding.smartTransfer");
        if (checkBox.isChecked()) {
            net.one97.paytm.upi.registration.c.e eVar = uPISettingsActivity.f68716e;
            if (eVar == null) {
                kotlin.g.b.k.a("upiSettingsViewModel");
            }
            net.one97.paytm.upi.registration.c.e eVar2 = uPISettingsActivity.f68716e;
            if (eVar2 == null) {
                kotlin.g.b.k.a("upiSettingsViewModel");
            }
            eVar.a(eVar2.f68576g, UpiConstants.ENABLE);
            return;
        }
        net.one97.paytm.upi.registration.c.e eVar3 = uPISettingsActivity.f68716e;
        if (eVar3 == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        net.one97.paytm.upi.registration.c.e eVar4 = uPISettingsActivity.f68716e;
        if (eVar4 == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        eVar3.a(eVar4.f68576g, UpiConstants.DISABLE);
    }

    public static final /* synthetic */ void d(UPISettingsActivity uPISettingsActivity) {
        Context context = uPISettingsActivity;
        ag agVar = uPISettingsActivity.f68713a;
        if (agVar == null) {
            kotlin.g.b.k.a("binding");
        }
        CheckBox checkBox = agVar.N;
        kotlin.g.b.k.a((Object) checkBox, "binding.smartTransfer");
        CJRSendGTMTag.sendNewCustomGTMEvents(context, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_SMARTRANSFER, String.valueOf(checkBox.isChecked()), "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
    }

    public static final /* synthetic */ void e(UPISettingsActivity uPISettingsActivity) {
        net.one97.paytm.upi.registration.c.e eVar = uPISettingsActivity.f68716e;
        if (eVar == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        ag agVar = uPISettingsActivity.f68713a;
        if (agVar == null) {
            kotlin.g.b.k.a("binding");
        }
        CheckBox checkBox = agVar.ab;
        kotlin.g.b.k.a((Object) checkBox, "binding.walletMoneyTransfer");
        String valueOf = String.valueOf(checkBox.isChecked());
        kotlin.g.b.k.c(UpiConstants.UPI_SETTINGS_WALLET_USER_PREFERENCE, "prefereneKey");
        kotlin.g.b.k.c(valueOf, "value");
        eVar.u.a((a.c) new e.i(eVar), UpiConstants.UPI_SETTINGS_WALLET_USER_PREFERENCE, valueOf);
    }

    public static final /* synthetic */ void f(UPISettingsActivity uPISettingsActivity) {
        Context context = uPISettingsActivity;
        ag agVar = uPISettingsActivity.f68713a;
        if (agVar == null) {
            kotlin.g.b.k.a("binding");
        }
        CheckBox checkBox = agVar.ab;
        kotlin.g.b.k.a((Object) checkBox, "binding.walletMoneyTransfer");
        CJRSendGTMTag.sendNewCustomGTMEvents(context, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_WALLET_PREFERENCE, String.valueOf(checkBox.isChecked()), "", "", CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, "upi");
    }

    public static final /* synthetic */ void i(UPISettingsActivity uPISettingsActivity) {
        uPISettingsActivity.u = true;
        uPISettingsActivity.invalidateOptionsMenu();
        ag agVar = uPISettingsActivity.f68713a;
        if (agVar == null) {
            kotlin.g.b.k.a("binding");
        }
        TextView textView = agVar.Z;
        kotlin.g.b.k.a((Object) textView, "binding.vpa");
        kotlin.g.b.aa aaVar = kotlin.g.b.aa.f47921a;
        String string = uPISettingsActivity.getString(R.string.upi_address_value);
        kotlin.g.b.k.a((Object) string, "getString(R.string.upi_address_value)");
        Object[] objArr = new Object[1];
        net.one97.paytm.upi.registration.c.e eVar = uPISettingsActivity.f68716e;
        if (eVar == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        objArr[0] = eVar.f68577h;
        String format = String.format(string, Arrays.copyOf(objArr, 1));
        kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
        textView.setText(format);
        net.one97.paytm.upi.registration.c.e eVar2 = uPISettingsActivity.f68716e;
        if (eVar2 == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        UpiProfileModel.AccountDetails response = eVar2.b().getResponse();
        kotlin.g.b.k.a((Object) response, "upiSettingsViewModel.upiProfileModel.response");
        UpiProfileModel.ProfileDetails profileDetail = response.getProfileDetail();
        kotlin.g.b.k.a((Object) profileDetail, "upiSettingsViewModel.upi…el.response.profileDetail");
        ArrayList<String> userPreferences = profileDetail.getUserPreferences();
        if (userPreferences == null || userPreferences.size() <= 0) {
            ag agVar2 = uPISettingsActivity.f68713a;
            if (agVar2 == null) {
                kotlin.g.b.k.a("binding");
            }
            CheckBox checkBox = agVar2.N;
            kotlin.g.b.k.a((Object) checkBox, "binding.smartTransfer");
            checkBox.setChecked(false);
        } else {
            Iterator<String> it2 = userPreferences.iterator();
            while (it2.hasNext()) {
                if (kotlin.m.p.a(it2.next(), UpiConstants.UPI_SETTINGS_SMART_TRANSFER_PREFERENCE, true)) {
                    ag agVar3 = uPISettingsActivity.f68713a;
                    if (agVar3 == null) {
                        kotlin.g.b.k.a("binding");
                    }
                    CheckBox checkBox2 = agVar3.N;
                    kotlin.g.b.k.a((Object) checkBox2, "binding.smartTransfer");
                    checkBox2.setChecked(true);
                }
            }
        }
        UpiProfileDefaultBank upiProfileDefaultBank = uPISettingsActivity.t;
        net.one97.paytm.upi.registration.c.e eVar3 = uPISettingsActivity.f68716e;
        if (eVar3 == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        upiProfileDefaultBank.setVirtualAddress(eVar3.f68577h);
        if (!(uPISettingsActivity.f68717f != null)) {
            uPISettingsActivity.f68717f = new net.one97.paytm.upi.i.b(new r(uPISettingsActivity));
            ag agVar4 = uPISettingsActivity.f68713a;
            if (agVar4 == null) {
                kotlin.g.b.k.a("binding");
            }
            RecyclerView recyclerView = agVar4.f66764e;
            recyclerView.setLayoutManager(new LinearLayoutManager(uPISettingsActivity, 1, false));
            net.one97.paytm.upi.i.b bVar = uPISettingsActivity.f68717f;
            if (bVar == null) {
                kotlin.g.b.k.a("bankAdapter");
            }
            recyclerView.setAdapter(bVar);
            net.one97.paytm.upi.i.b bVar2 = uPISettingsActivity.f68717f;
            if (bVar2 == null) {
                kotlin.g.b.k.a("bankAdapter");
            }
            net.one97.paytm.upi.registration.c.e eVar4 = uPISettingsActivity.f68716e;
            if (eVar4 == null) {
                kotlin.g.b.k.a("upiSettingsViewModel");
            }
            List<BankAccountDetails.BankAccount> c2 = eVar4.c();
            if (c2 != null) {
                bVar2.a((ArrayList<BankAccountDetails.BankAccount>) (ArrayList) c2);
            } else {
                throw new kotlin.u("null cannot be cast to non-null type java.util.ArrayList<net.one97.paytm.upi.common.upi.BankAccountDetails.BankAccount>");
            }
        } else {
            net.one97.paytm.upi.i.b bVar3 = uPISettingsActivity.f68717f;
            if (bVar3 == null) {
                kotlin.g.b.k.a("bankAdapter");
            }
            net.one97.paytm.upi.registration.c.e eVar5 = uPISettingsActivity.f68716e;
            if (eVar5 == null) {
                kotlin.g.b.k.a("upiSettingsViewModel");
            }
            List<BankAccountDetails.BankAccount> c3 = eVar5.c();
            if (c3 != null) {
                bVar3.a((ArrayList<BankAccountDetails.BankAccount>) (ArrayList) c3);
            } else {
                throw new kotlin.u("null cannot be cast to non-null type java.util.ArrayList<net.one97.paytm.upi.common.upi.BankAccountDetails.BankAccount>");
            }
        }
        net.one97.paytm.upi.registration.c.e eVar6 = uPISettingsActivity.f68716e;
        if (eVar6 == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        uPISettingsActivity.a(eVar6.c().size());
        uPISettingsActivity.f();
    }

    public static final /* synthetic */ void j(UPISettingsActivity uPISettingsActivity) {
        if (uPISettingsActivity.f68714b != null) {
            ProgressDialog progressDialog = uPISettingsActivity.f68714b;
            if (progressDialog == null) {
                kotlin.g.b.k.a("progressDialog");
            }
            if (progressDialog.isShowing()) {
                ProgressDialog progressDialog2 = uPISettingsActivity.f68714b;
                if (progressDialog2 == null) {
                    kotlin.g.b.k.a("progressDialog");
                }
                progressDialog2.dismiss();
            }
        }
    }

    public static final /* synthetic */ void k(UPISettingsActivity uPISettingsActivity) {
        c.a aVar = new c.a(uPISettingsActivity);
        aVar.a(false);
        aVar.b(R.string.upi_post_deregister_msg);
        aVar.a(R.string.ok, (DialogInterface.OnClickListener) new ae(uPISettingsActivity));
        aVar.b();
    }

    public static final /* synthetic */ void a(UPISettingsActivity uPISettingsActivity, UpiCustomVolleyError upiCustomVolleyError) {
        if (upiCustomVolleyError == null) {
            Toast.makeText(uPISettingsActivity, R.string.upi_some_went_wrong, 1).show();
        } else if (UpiUtils.AUTHENTICATION_FAILURE_401.equals(upiCustomVolleyError.getmErrorCode()) || "410".equals(upiCustomVolleyError.getmErrorCode())) {
            net.one97.paytm.upi.i a2 = net.one97.paytm.upi.i.a();
            kotlin.g.b.k.a((Object) a2, "PaytmUpiSdk.getInstance()");
            new UpiCustomVolleyError();
            UPISettingsActivity.class.getName();
            a2.b().e(uPISettingsActivity);
        } else if (!TextUtils.isEmpty(upiCustomVolleyError.getmErrorCode()) && "1006".equals(upiCustomVolleyError.getmErrorCode())) {
            uPISettingsActivity.b(5001);
        } else if (TextUtils.isEmpty(upiCustomVolleyError.getAlertMessage())) {
            Toast.makeText(uPISettingsActivity, R.string.upi_some_went_wrong, 1).show();
        } else {
            Toast.makeText(uPISettingsActivity, upiCustomVolleyError.getAlertMessage(), 1).show();
        }
    }

    public static final /* synthetic */ void a(UPISettingsActivity uPISettingsActivity, String str) {
        uPISettingsActivity.f68714b = new ProgressDialog(uPISettingsActivity);
        ProgressDialog progressDialog = uPISettingsActivity.f68714b;
        if (progressDialog == null) {
            kotlin.g.b.k.a("progressDialog");
        }
        progressDialog.setMessage(str);
        ProgressDialog progressDialog2 = uPISettingsActivity.f68714b;
        if (progressDialog2 == null) {
            kotlin.g.b.k.a("progressDialog");
        }
        progressDialog2.setCancelable(false);
        ProgressDialog progressDialog3 = uPISettingsActivity.f68714b;
        if (progressDialog3 == null) {
            kotlin.g.b.k.a("progressDialog");
        }
        progressDialog3.show();
    }

    public static final /* synthetic */ void b(UPISettingsActivity uPISettingsActivity, UpiCustomVolleyError upiCustomVolleyError) {
        String str = upiCustomVolleyError != null ? upiCustomVolleyError.getmErrorCode() : null;
        if ("88".equals(str) || "80".equals(str)) {
            Toast.makeText(uPISettingsActivity, R.string.upi_delete_default_bank, 1).show();
        } else if ("1006".equals(str)) {
            uPISettingsActivity.h();
        } else if ("102".equals(str) || "INT-1199".equals(str)) {
            Toast.makeText(uPISettingsActivity, R.string.upi_delete_default_bank_vpa, 1).show();
        } else if ("INT-4051".equals(str)) {
            Toast.makeText(uPISettingsActivity, R.string.upi_delete_error_msg, 1).show();
        } else if (TextUtils.isEmpty(str) || !UpiConstants.NETWORK_ERROR_CODE.equals(str)) {
            Toast.makeText(uPISettingsActivity, R.string.upi_some_went_wrong, 1).show();
        } else {
            CustomDialog.showAlert(uPISettingsActivity, uPISettingsActivity.getResources().getString(R.string.no_connection), uPISettingsActivity.getResources().getString(R.string.no_internet));
        }
    }

    public static final /* synthetic */ void v(UPISettingsActivity uPISettingsActivity) {
        Intent intent = new Intent(uPISettingsActivity, SetMPINActivity.class);
        net.one97.paytm.upi.registration.c.e eVar = uPISettingsActivity.f68716e;
        if (eVar == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        intent.putExtra("user_upi_details", eVar.g());
        net.one97.paytm.upi.registration.c.e eVar2 = uPISettingsActivity.f68716e;
        if (eVar2 == null) {
            kotlin.g.b.k.a("upiSettingsViewModel");
        }
        if (eVar2.g().getBankAccountList() != null) {
            net.one97.paytm.upi.i a2 = net.one97.paytm.upi.i.a();
            kotlin.g.b.k.a((Object) a2, "PaytmUpiSdk.getInstance()");
            net.one97.paytm.upi.h c2 = a2.c();
            StringBuilder sb = new StringBuilder();
            net.one97.paytm.upi.registration.c.e eVar3 = uPISettingsActivity.f68716e;
            if (eVar3 == null) {
                kotlin.g.b.k.a("upiSettingsViewModel");
            }
            sb.append(String.valueOf(eVar3.g().getBankAccountList().size()));
            sb.append("_");
            net.one97.paytm.upi.registration.c.e eVar4 = uPISettingsActivity.f68716e;
            if (eVar4 == null) {
                kotlin.g.b.k.a("upiSettingsViewModel");
            }
            sb.append(eVar4.g().getSelectedBankIdx());
            c2.a("UpiLinkedAccountsFragment", sb.toString());
        } else {
            net.one97.paytm.upi.i a3 = net.one97.paytm.upi.i.a();
            kotlin.g.b.k.a((Object) a3, "PaytmUpiSdk.getInstance()");
            net.one97.paytm.upi.h c3 = a3.c();
            StringBuilder sb2 = new StringBuilder("null_");
            net.one97.paytm.upi.registration.c.e eVar5 = uPISettingsActivity.f68716e;
            if (eVar5 == null) {
                kotlin.g.b.k.a("upiSettingsViewModel");
            }
            sb2.append(eVar5.g().getSelectedBankIdx());
            c3.a("UpiLinkedAccountsFragment", sb2.toString());
        }
        intent.putExtra(UpiConstants.CAME_FROM_INCORRECT_PIN_DIALOG, true);
        uPISettingsActivity.startActivityForResult(intent, uPISettingsActivity.f68718g);
    }
}
