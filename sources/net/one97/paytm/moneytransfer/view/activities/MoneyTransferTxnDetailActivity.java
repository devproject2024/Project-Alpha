package net.one97.paytm.moneytransfer.view.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.utility.s;
import com.squareup.picasso.ah;
import com.squareup.picasso.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel;
import net.one97.paytm.common.entity.PPBCurrentAccountModel;
import net.one97.paytm.common.entity.wallet.CJRIMPSInitiateExtraInfoDataModel;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.locale.storage.LocaleDBContract;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.moneytransfer.view.fragments.MoneyTransferInviteFragment;
import net.one97.paytm.moneytransfer.view.fragments.p;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CircleTransform;
import net.one97.paytm.upi.util.EnglishNumberToWords;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.IncorrectUpiPinBottomSheet;
import net.one97.paytm.upi.util.UPICheckBalanceHelper;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class MoneyTransferTxnDetailActivity extends MoneyTransferBaseActivity implements View.OnClickListener, n.c {

    /* renamed from: a  reason: collision with root package name */
    private UpiBaseDataModel f54337a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f54338b;

    /* renamed from: c  reason: collision with root package name */
    private String f54339c;

    /* renamed from: d  reason: collision with root package name */
    private String f54340d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f54341e;

    /* renamed from: f  reason: collision with root package name */
    private String f54342f;

    /* renamed from: g  reason: collision with root package name */
    private String f54343g;

    /* renamed from: h  reason: collision with root package name */
    private String f54344h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f54345i;
    /* access modifiers changed from: private */
    public boolean j;
    private MoneyTransferV3Activity.a k;
    private UpiProfileDefaultBank l;
    private UPICheckBalanceHelper m;
    /* access modifiers changed from: private */
    public String n;
    private PPBCurrentAccountModel o;
    private final int p = 10;
    /* access modifiers changed from: private */
    public String q;
    private String r;
    private String s = "";
    private HashMap t;

    public final View a(int i2) {
        if (this.t == null) {
            this.t = new HashMap();
        }
        View view = (View) this.t.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.t.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_money_transfer_txn_detail);
        Context context = this;
        net.one97.paytm.moneytransfer.utils.f.a(context, CJRGTMConstants.MT_V4_TXN_DETAIL_SCREEN_NAME);
        m.a(androidx.core.content.b.c(context, R.color.white), (Activity) this);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_bundle");
        if (!(serializableExtra instanceof UpiBaseDataModel)) {
            serializableExtra = null;
        }
        this.f54337a = (UpiBaseDataModel) serializableExtra;
        this.f54338b = getIntent().getStringExtra("key_amount");
        this.f54339c = getIntent().getStringExtra(LocaleDBContract.BaseTable.KEY);
        this.f54340d = getIntent().getStringExtra("key_comment");
        this.f54341e = getIntent().getStringExtra("key_account_number");
        this.f54342f = getIntent().getStringExtra("key_bank_name");
        this.f54343g = getIntent().getStringExtra("key_account_number_selected");
        this.f54344h = getIntent().getStringExtra("ifsc");
        Serializable serializableExtra2 = getIntent().getSerializableExtra("payee_acc_or_vpa");
        if (!(serializableExtra2 instanceof MoneyTransferV3Activity.a)) {
            serializableExtra2 = null;
        }
        this.k = (MoneyTransferV3Activity.a) serializableExtra2;
        this.f54345i = getIntent().getBooleanExtra("is_from_upi_deep_link", false);
        this.j = getIntent().getBooleanExtra(UpiConstants.EXTRA_IS_COLLECT_REQUEST, false);
        Serializable serializableExtra3 = getIntent().getSerializableExtra("PAYER");
        if (!(serializableExtra3 instanceof UpiProfileDefaultBank)) {
            serializableExtra3 = null;
        }
        this.l = (UpiProfileDefaultBank) serializableExtra3;
        Serializable serializableExtra4 = getIntent().getSerializableExtra("ppb_ica");
        if (!(serializableExtra4 instanceof PPBCurrentAccountModel)) {
            serializableExtra4 = null;
        }
        this.o = (PPBCurrentAccountModel) serializableExtra4;
        this.q = getIntent().getStringExtra("payee_account_number");
        this.r = getIntent().getStringExtra("payee_ifsc");
        String stringExtra = getIntent().getStringExtra("date_time");
        k.a((Object) stringExtra, "intent.getStringExtra(BundleConstants.DATE_TIME)");
        this.s = stringExtra;
        View findViewById = findViewById(R.id.back_to_home_bt);
        if (findViewById != null) {
            ((Button) findViewById).setOnClickListener(new a(this));
            TextView textView = (TextView) a(R.id.amount_tv);
            k.a((Object) textView, "amount_tv");
            textView.setText(getString(R.string.mt_rupees) + UpiAppUtils.priceToString(this.f54338b));
            TextView textView2 = (TextView) a(R.id.amount_in_words_tv);
            k.a((Object) textView2, "amount_in_words_tv");
            aa aaVar = aa.f47921a;
            String string = getString(R.string.mt_amount_in_words_placeholder);
            k.a((Object) string, "getString(R.string.mt_amount_in_words_placeholder)");
            String format = String.format(string, Arrays.copyOf(new Object[]{EnglishNumberToWords.convert(this.f54338b)}, 1));
            k.a((Object) format, "java.lang.String.format(format, *args)");
            textView2.setText(format);
            TextView textView3 = (TextView) a(R.id.name_tv);
            k.a((Object) textView3, "name_tv");
            textView3.setText(this.f54339c);
            TextView textView4 = (TextView) a(R.id.date_tv);
            k.a((Object) textView4, "date_tv");
            textView4.setText(e());
            ((TextView) a(R.id.repeat_payment_tv)).setOnClickListener(new b(this));
            ((TextView) a(R.id.mt_share_tv)).setOnClickListener(new c(this));
            ((ImageView) a(R.id.iv_back_button)).setOnClickListener(new d(this));
            LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.status_image_anim_view);
            k.a((Object) lottieAnimationView, "status_image_anim_view");
            lottieAnimationView.setVisibility(0);
            ((LottieAnimationView) a(R.id.status_image_anim_view)).setAnimation(R.raw.payment_success_white_bg);
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) a(R.id.status_image_anim_view);
            k.a((Object) lottieAnimationView2, "status_image_anim_view");
            lottieAnimationView2.setRepeatCount(-1);
            new Handler().postDelayed(new e(this), 500);
            if (this.f54345i || this.j) {
                TextView textView5 = (TextView) a(R.id.txn_status_tv);
                k.a((Object) textView5, "txn_status_tv");
                textView5.setText(getString(R.string.upi_paid_successfully));
            } else {
                TextView textView6 = (TextView) a(R.id.txn_status_tv);
                k.a((Object) textView6, "txn_status_tv");
                textView6.setText(getString(R.string.mt_money_transfer_successfully));
            }
            if (this.f54345i || this.j) {
                TextView textView7 = (TextView) a(R.id.repeat_payment_tv);
                k.a((Object) textView7, "repeat_payment_tv");
                textView7.setVisibility(8);
            } else {
                TextView textView8 = (TextView) a(R.id.repeat_payment_tv);
                k.a((Object) textView8, "repeat_payment_tv");
                textView8.setVisibility(0);
            }
            TextView textView9 = (TextView) a(R.id.mt_order_id_tv);
            if (textView9 != null) {
                textView9.setOnLongClickListener(new f(this));
            }
            j supportFragmentManager = getSupportFragmentManager();
            q a2 = supportFragmentManager != null ? supportFragmentManager.a() : null;
            k.a((Object) a2, "supportFragmentManager?.beginTransaction()");
            j supportFragmentManager2 = getSupportFragmentManager();
            q a3 = supportFragmentManager2 != null ? supportFragmentManager2.a() : null;
            k.a((Object) a3, "supportFragmentManager?.beginTransaction()");
            if (a2 != null) {
                int i2 = R.id.fragment_cta_actions;
                p.a aVar = p.f54593a;
                a2.a(i2, (Fragment) p.a.a(this.f54337a, this.f54344h, this.f54341e, this.f54345i, this.j, this.o)).c();
            }
            if (a3 != null) {
                int i3 = R.id.fragment_invite_now;
                MoneyTransferInviteFragment.a aVar2 = MoneyTransferInviteFragment.f54386a;
                a3.a(i3, (Fragment) MoneyTransferInviteFragment.a.a(false, false, "")).c();
            }
            UpiBaseDataModel upiBaseDataModel = this.f54337a;
            if (upiBaseDataModel instanceof BaseUpiResponse) {
                if (upiBaseDataModel != null) {
                    BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                    if (!TextUtils.isEmpty(baseUpiResponse.getBankRRN())) {
                        this.n = baseUpiResponse.getBankRRN();
                        TextView textView10 = (TextView) a(R.id.mt_order_id_tv);
                        k.a((Object) textView10, "mt_order_id_tv");
                        textView10.setText(getString(R.string.money_transfer_upi_ref_no) + " " + baseUpiResponse.getBankRRN());
                    }
                    if (UpiAppUtils.checkIsVpa(this.f54341e)) {
                        TextView textView11 = (TextView) a(R.id.bank_name_tv);
                        k.a((Object) textView11, "bank_name_tv");
                        aa aaVar2 = aa.f47921a;
                        String string2 = getString(R.string.money_transfer_upi_without_bold);
                        k.a((Object) string2, "getString(R.string.money…ransfer_upi_without_bold)");
                        String format2 = String.format(string2, Arrays.copyOf(new Object[]{this.f54341e}, 1));
                        k.a((Object) format2, "java.lang.String.format(format, *args)");
                        textView11.setText(format2);
                        if (!TextUtils.isEmpty(this.r)) {
                            TextView textView12 = (TextView) a(R.id.ifsc_tv);
                            k.a((Object) textView12, "ifsc_tv");
                            aa aaVar3 = aa.f47921a;
                            String string3 = getString(R.string.money_transfer_ifsc_with_placeholder_without_bold);
                            k.a((Object) string3, "getString(R.string.money…placeholder_without_bold)");
                            String format3 = String.format(string3, Arrays.copyOf(new Object[]{this.r}, 1));
                            k.a((Object) format3, "java.lang.String.format(format, *args)");
                            textView12.setText(format3);
                            m.a((ImageView) a(R.id.bank_icon_iv), this.r, context);
                        } else {
                            TextView textView13 = (TextView) a(R.id.ifsc_tv);
                            k.a((Object) textView13, "ifsc_tv");
                            textView13.setVisibility(8);
                            Intent intent = getIntent();
                            CharSequence stringExtra2 = intent != null ? intent.getStringExtra("picture") : null;
                            if (stringExtra2 == null || stringExtra2.length() == 0) {
                                m.a((ImageView) a(R.id.bank_icon_iv), "UPI", context);
                            } else {
                                ((ImageView) a(R.id.bank_icon_iv)).setPadding(0, 0, 0, 0);
                                w a4 = w.a();
                                Intent intent2 = getIntent();
                                a4.a(intent2 != null ? intent2.getStringExtra("picture") : null).a((ah) new CircleTransform()).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a((ImageView) a(R.id.bank_icon_iv));
                            }
                        }
                        if (!TextUtils.isEmpty(this.q)) {
                            TextView textView14 = (TextView) a(R.id.account_tv);
                            k.a((Object) textView14, "account_tv");
                            aa aaVar4 = aa.f47921a;
                            String string4 = getString(R.string.money_transfer_account_no);
                            k.a((Object) string4, "getString(R.string.money_transfer_account_no)");
                            String format4 = String.format(string4, Arrays.copyOf(new Object[]{UpiAppUtils.getAccountNoV4Format(this.q)}, 1));
                            k.a((Object) format4, "java.lang.String.format(format, *args)");
                            textView14.setText(format4);
                        } else {
                            TextView textView15 = (TextView) a(R.id.account_tv);
                            k.a((Object) textView15, "account_tv");
                            textView15.setVisibility(8);
                        }
                    } else {
                        if (!TextUtils.isEmpty(this.f54342f)) {
                            TextView textView16 = (TextView) a(R.id.bank_name_tv);
                            k.a((Object) textView16, "bank_name_tv");
                            textView16.setText(this.f54342f);
                        }
                        TextView textView17 = (TextView) a(R.id.ifsc_tv);
                        k.a((Object) textView17, "ifsc_tv");
                        aa aaVar5 = aa.f47921a;
                        String string5 = getString(R.string.money_transfer_ifsc_with_placeholder_without_bold);
                        k.a((Object) string5, "getString(R.string.money…placeholder_without_bold)");
                        String format5 = String.format(string5, Arrays.copyOf(new Object[]{this.f54344h}, 1));
                        k.a((Object) format5, "java.lang.String.format(format, *args)");
                        textView17.setText(format5);
                        TextView textView18 = (TextView) a(R.id.account_tv);
                        k.a((Object) textView18, "account_tv");
                        aa aaVar6 = aa.f47921a;
                        String string6 = getString(R.string.money_transfer_account_no);
                        k.a((Object) string6, "getString(R.string.money_transfer_account_no)");
                        String format6 = String.format(string6, Arrays.copyOf(new Object[]{UpiAppUtils.getAccountNoV4Format(this.f54341e)}, 1));
                        k.a((Object) format6, "java.lang.String.format(format, *args)");
                        textView18.setText(format6);
                        Intent intent3 = getIntent();
                        CharSequence stringExtra3 = intent3 != null ? intent3.getStringExtra("picture") : null;
                        if (stringExtra3 == null || stringExtra3.length() == 0) {
                            m.a((ImageView) a(R.id.bank_icon_iv), this.f54344h, context);
                        } else {
                            ((ImageView) a(R.id.bank_icon_iv)).setPadding(0, 0, 0, 0);
                            w a5 = w.a();
                            Intent intent4 = getIntent();
                            a5.a(intent4 != null ? intent4.getStringExtra("picture") : null).a((ah) new CircleTransform()).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a((ImageView) a(R.id.bank_icon_iv));
                        }
                    }
                    UpiProfileDefaultBank upiProfileDefaultBank = this.l;
                    BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank != null ? upiProfileDefaultBank.getDebitBank() : null;
                    if (debitBank != null) {
                        TextView textView19 = (TextView) a(R.id.bank_name);
                        k.a((Object) textView19, PayUtility.BANK_NAME);
                        textView19.setText(m.a(debitBank.getBankName(), debitBank.getAccount()));
                        m.a((ImageView) a(R.id.iv_bank), debitBank.getIfsc(), getApplicationContext());
                        ((TextView) a(R.id.check_balance_tv)).setOnClickListener(this);
                        View a6 = a(R.id.top_header);
                        k.a((Object) a6, "top_header");
                        a6.setVisibility(0);
                        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.mt_success_bank_card_parent);
                        k.a((Object) constraintLayout, "mt_success_bank_card_parent");
                        constraintLayout.setVisibility(0);
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.BaseUpiResponse");
                }
            } else if (upiBaseDataModel instanceof CJRMoneyTransferIMPSInitiateDataModel) {
                if (upiBaseDataModel != null) {
                    CJRMoneyTransferIMPSInitiateDataModel cJRMoneyTransferIMPSInitiateDataModel = (CJRMoneyTransferIMPSInitiateDataModel) upiBaseDataModel;
                    if (!TextUtils.isEmpty(cJRMoneyTransferIMPSInitiateDataModel.getRrn())) {
                        CJRIMPSInitiateExtraInfoDataModel extraInfoDataModel = cJRMoneyTransferIMPSInitiateDataModel.getExtraInfoDataModel();
                        k.a((Object) extraInfoDataModel, "cjrMoneyTransferIMPSInit…aModel.extraInfoDataModel");
                        if (kotlin.m.p.a(extraInfoDataModel.getTransferType(), "neft", true)) {
                            TextView textView20 = (TextView) a(R.id.mt_order_id_tv);
                            k.a((Object) textView20, "mt_order_id_tv");
                            textView20.setText(getString(R.string.mt_neft_ref_id) + " " + cJRMoneyTransferIMPSInitiateDataModel.getRrn());
                        } else {
                            TextView textView21 = (TextView) a(R.id.mt_order_id_tv);
                            k.a((Object) textView21, "mt_order_id_tv");
                            textView21.setText(getString(R.string.mt_imps_ref_id) + " " + cJRMoneyTransferIMPSInitiateDataModel.getRrn());
                        }
                        this.n = cJRMoneyTransferIMPSInitiateDataModel != null ? cJRMoneyTransferIMPSInitiateDataModel.getRrn() : null;
                    }
                    if (!TextUtils.isEmpty(this.f54342f)) {
                        TextView textView22 = (TextView) a(R.id.bank_name_tv);
                        k.a((Object) textView22, "bank_name_tv");
                        textView22.setText(this.f54342f);
                    }
                    TextView textView23 = (TextView) a(R.id.ifsc_tv);
                    k.a((Object) textView23, "ifsc_tv");
                    aa aaVar7 = aa.f47921a;
                    String string7 = getString(R.string.money_transfer_ifsc_with_placeholder_without_bold);
                    k.a((Object) string7, "getString(R.string.money…placeholder_without_bold)");
                    String format7 = String.format(string7, Arrays.copyOf(new Object[]{this.f54344h}, 1));
                    k.a((Object) format7, "java.lang.String.format(format, *args)");
                    textView23.setText(format7);
                    TextView textView24 = (TextView) a(R.id.account_tv);
                    k.a((Object) textView24, "account_tv");
                    aa aaVar8 = aa.f47921a;
                    String string8 = getString(R.string.money_transfer_account_no);
                    k.a((Object) string8, "getString(R.string.money_transfer_account_no)");
                    String format8 = String.format(string8, Arrays.copyOf(new Object[]{UpiAppUtils.getAccountNoV4Format(this.f54341e)}, 1));
                    k.a((Object) format8, "java.lang.String.format(format, *args)");
                    textView24.setText(format8);
                    Intent intent5 = getIntent();
                    CharSequence stringExtra4 = intent5 != null ? intent5.getStringExtra("picture") : null;
                    if (stringExtra4 == null || stringExtra4.length() == 0) {
                        m.a((ImageView) a(R.id.bank_icon_iv), this.f54344h, context);
                    } else {
                        ((ImageView) a(R.id.bank_icon_iv)).setPadding(0, 0, 0, 0);
                        w a7 = w.a();
                        Intent intent6 = getIntent();
                        a7.a(intent6 != null ? intent6.getStringExtra("picture") : null).a((ah) new CircleTransform()).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a((ImageView) a(R.id.bank_icon_iv));
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel");
                }
            }
            if (!TextUtils.isEmpty(this.f54340d) && !kotlin.m.p.a(this.f54340d, "NA", true)) {
                TextView textView25 = (TextView) a(R.id.comment_tv);
                k.a((Object) textView25, "comment_tv");
                textView25.setText("\" " + this.f54340d + " \"");
                ((TextView) a(R.id.comment_tv)).setVisibility(0);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.Button");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferTxnDetailActivity f54346a;

        a(MoneyTransferTxnDetailActivity moneyTransferTxnDetailActivity) {
            this.f54346a = moneyTransferTxnDetailActivity;
        }

        public final void onClick(View view) {
            this.f54346a.onBackPressed();
            if (this.f54346a.f54345i) {
                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(this.f54346a.getApplicationContext(), Events.Category.INTENT, Events.Action.BACK_TO_HOME_CLICKED, "success", "", "", this.f54346a.f54341e, this.f54346a.f54338b, Events.Screen.POST_TRANSACTION, "");
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferTxnDetailActivity f54347a;

        b(MoneyTransferTxnDetailActivity moneyTransferTxnDetailActivity) {
            this.f54347a = moneyTransferTxnDetailActivity;
        }

        public final void onClick(View view) {
            MoneyTransferTxnDetailActivity.d(this.f54347a);
            net.one97.paytm.moneytransfer.utils.f.a(this.f54347a.getApplicationContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_REPEAT_PAYMENT_CLICKED, CJRGTMConstants.MT_V4_TXN_DETAIL_SCREEN_NAME, "", "");
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferTxnDetailActivity f54348a;

        c(MoneyTransferTxnDetailActivity moneyTransferTxnDetailActivity) {
            this.f54348a = moneyTransferTxnDetailActivity;
        }

        public final void onClick(View view) {
            String str;
            String str2;
            if (this.f54348a.j) {
                MoneyTransferTxnDetailActivity moneyTransferTxnDetailActivity = this.f54348a;
                Context context = moneyTransferTxnDetailActivity;
                String f2 = moneyTransferTxnDetailActivity.q;
                if (f2 == null) {
                    str2 = "";
                } else {
                    str2 = f2;
                }
                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(context, Events.Category.COLLECT, "share_clicked", "", "", "", str2, "", Events.Screen.POST_TRANSACTION, "");
            }
            if (this.f54348a.f54345i) {
                MoneyTransferTxnDetailActivity moneyTransferTxnDetailActivity2 = this.f54348a;
                Context context2 = moneyTransferTxnDetailActivity2;
                String f3 = moneyTransferTxnDetailActivity2.q;
                if (f3 == null) {
                    str = "";
                } else {
                    str = f3;
                }
                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(context2, Events.Category.INTENT, "share_clicked", "", "", "", str, "", Events.Screen.POST_TRANSACTION, "");
            }
            this.f54348a.c();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferTxnDetailActivity f54349a;

        d(MoneyTransferTxnDetailActivity moneyTransferTxnDetailActivity) {
            this.f54349a = moneyTransferTxnDetailActivity;
        }

        public final void onClick(View view) {
            this.f54349a.finish();
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferTxnDetailActivity f54350a;

        e(MoneyTransferTxnDetailActivity moneyTransferTxnDetailActivity) {
            this.f54350a = moneyTransferTxnDetailActivity;
        }

        public final void run() {
            ImageView imageView = (ImageView) this.f54350a.a(R.id.status_image_iv);
            k.a((Object) imageView, "status_image_iv");
            imageView.setVisibility(8);
            ((LottieAnimationView) this.f54350a.a(R.id.status_image_anim_view)).playAnimation();
        }
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        if (i2 == 56 && s.a(iArr)) {
            c();
        }
    }

    public final void onClick(View view) {
        if (view != null && view.getId() == R.id.check_balance_tv) {
            d();
        }
    }

    /* access modifiers changed from: private */
    public final void d() {
        TextView textView = (TextView) a(R.id.check_balance_tv);
        k.a((Object) textView, "check_balance_tv");
        if (textView.getText().equals(getString(R.string.check_balance))) {
            if (this.m == null) {
                Context applicationContext = getApplicationContext();
                if (applicationContext == null) {
                    k.a();
                }
                this.m = new UPICheckBalanceHelper.UPICheckBalanceBuilder(applicationContext, this).setScreenName(getClass().getName()).setTag(getClass().getName()).build();
            }
            UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
            UpiProfileDefaultBank upiProfileDefaultBank2 = this.l;
            String str = null;
            upiProfileDefaultBank.setDebitBank(upiProfileDefaultBank2 != null ? upiProfileDefaultBank2.getDebitBank() : null);
            UpiProfileDefaultBank upiProfileDefaultBank3 = this.l;
            if (upiProfileDefaultBank3 != null) {
                str = upiProfileDefaultBank3.getVirtualAddress();
            }
            upiProfileDefaultBank.setVirtualAddress(str);
            UPICheckBalanceHelper uPICheckBalanceHelper = this.m;
            if (uPICheckBalanceHelper != null) {
                uPICheckBalanceHelper.getUpiAccountBalance(upiProfileDefaultBank);
            }
        }
    }

    public final void a(n.b bVar) {
        k.c(bVar, "errorUPI");
        if (bVar == n.b.INCORRECT_MPIN) {
            a(false);
        } else if (bVar == n.b.INCORRECT_MPIN_TOO_MANY_TIMES) {
            a(true);
        } else {
            UpiUtils.handleCheckBalanceError(this, bVar);
        }
    }

    public static final class g implements IncorrectUpiPinBottomSheet.OnItemClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferTxnDetailActivity f54352a;

        g(MoneyTransferTxnDetailActivity moneyTransferTxnDetailActivity) {
            this.f54352a = moneyTransferTxnDetailActivity;
        }

        public final void onReEnterClicked() {
            this.f54352a.d();
        }

        public final void onCreateNewPinClicked() {
            MoneyTransferTxnDetailActivity.h(this.f54352a);
        }
    }

    private final void a(boolean z) {
        j supportFragmentManager = getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "supportFragmentManager");
        IncorrectUpiPinBottomSheet.Companion.show(new g(this), supportFragmentManager, z);
    }

    public final void a(String str, String str2, String str3) {
        String str4;
        k.c(str3, "accountType");
        if (UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.UOD || UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.SOD) {
            str4 = getString(R.string.upi_balance_credit_limit, new Object[]{UpiAppUtils.priceToString(str), UpiAppUtils.priceToString(str2)});
            k.a((Object) str4, "getString(R.string.upi_b…String(availableBalance))");
        } else {
            str4 = getString(R.string.upi_new_balance, new Object[]{UpiAppUtils.priceToString(str2)});
            k.a((Object) str4, "getString(R.string.upi_n…String(availableBalance))");
        }
        TextView textView = (TextView) a(R.id.check_balance_tv);
        if (textView != null) {
            textView.setText(str4);
        }
        TextView textView2 = (TextView) a(R.id.check_balance_tv);
        if (textView2 != null) {
            textView2.setTextColor(androidx.core.content.b.c(getApplicationContext(), R.color.color_666666));
        }
        TextView textView3 = (TextView) a(R.id.check_balance_tv);
        k.a((Object) textView3, "check_balance_tv");
        textView3.setVisibility(0);
    }

    static final class f implements View.OnLongClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferTxnDetailActivity f54351a;

        f(MoneyTransferTxnDetailActivity moneyTransferTxnDetailActivity) {
            this.f54351a = moneyTransferTxnDetailActivity;
        }

        public final boolean onLongClick(View view) {
            if (TextUtils.isEmpty(this.f54351a.n)) {
                return true;
            }
            MoneyTransferTxnDetailActivity moneyTransferTxnDetailActivity = this.f54351a;
            m.a((Activity) moneyTransferTxnDetailActivity, "reference_id", moneyTransferTxnDetailActivity.n);
            MoneyTransferTxnDetailActivity moneyTransferTxnDetailActivity2 = this.f54351a;
            Toast.makeText(moneyTransferTxnDetailActivity2, moneyTransferTxnDetailActivity2.getString(R.string.ref_id_copy_msg), 0).show();
            return true;
        }
    }

    public final void c() {
        if (Build.VERSION.SDK_INT < 23 || !s.a() || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.mt_success_share_layout);
            k.a((Object) constraintLayout, "mt_success_share_layout");
            setShareImageData(constraintLayout);
            ConstraintLayout constraintLayout2 = (ConstraintLayout) a(R.id.mt_success_share_layout);
            k.a((Object) constraintLayout2, "mt_success_share_layout");
            net.one97.paytm.upi.f.b((View) constraintLayout2);
            ((ConstraintLayout) a(R.id.mt_success_share_layout)).invalidate();
            UpiUtils.shareSuccessfulTransaction(this, (ConstraintLayout) a(R.id.mt_success_share_layout), getString(R.string.post_payment_share_subject), m.a(), getString(R.string.post_payment_share_title), 8);
            net.one97.paytm.moneytransfer.utils.f.a(getApplicationContext(), "mt_p2p_new_v1", "share_clicked", CJRGTMConstants.MT_V4_TXN_DETAIL_SCREEN_NAME, "", "");
            return;
        }
        s.b((Activity) this);
        Toast.makeText(this, getString(R.string.mt_permission_not_granted), 0).show();
    }

    public final void setShareImageData(View view) {
        View findViewById;
        View findViewById2;
        View findViewById3;
        BankAccountDetails.BankAccount debitBank;
        BankAccountDetails.BankAccount debitBank2;
        BankAccountDetails.BankAccount debitBank3;
        View view2 = view;
        k.c(view2, "view");
        View findViewById4 = view2.findViewById(R.id.amount_tv);
        k.a((Object) findViewById4, "view.findViewById<TextView>(R.id.amount_tv)");
        ((TextView) findViewById4).setText(getString(R.string.mt_rupees) + UpiAppUtils.priceToString(this.f54338b));
        View findViewById5 = view2.findViewById(R.id.amount_in_words_tv);
        k.a((Object) findViewById5, "view.findViewById<TextVi…(R.id.amount_in_words_tv)");
        aa aaVar = aa.f47921a;
        String string = getString(R.string.mt_amount_in_words_placeholder);
        k.a((Object) string, "getString(R.string.mt_amount_in_words_placeholder)");
        String format = String.format(string, Arrays.copyOf(new Object[]{EnglishNumberToWords.convert(this.f54338b)}, 1));
        k.a((Object) format, "java.lang.String.format(format, *args)");
        ((TextView) findViewById5).setText(format);
        View findViewById6 = view2.findViewById(R.id.name_tv);
        k.a((Object) findViewById6, "view.findViewById<TextView>(R.id.name_tv)");
        ((TextView) findViewById6).setText(this.f54339c);
        View findViewById7 = view2.findViewById(R.id.date_tv);
        k.a((Object) findViewById7, "view.findViewById<TextView>(R.id.date_tv)");
        ((TextView) findViewById7).setText(e());
        UpiBaseDataModel upiBaseDataModel = this.f54337a;
        String str = null;
        if (upiBaseDataModel instanceof BaseUpiResponse) {
            if (upiBaseDataModel != null) {
                BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                if (!TextUtils.isEmpty(baseUpiResponse.getBankRRN())) {
                    View findViewById8 = view2.findViewById(R.id.mt_order_id_tv);
                    k.a((Object) findViewById8, "view.findViewById<TextView>(R.id.mt_order_id_tv)");
                    ((TextView) findViewById8).setText(getString(R.string.money_transfer_upi_ref_no) + " " + baseUpiResponse.getBankRRN());
                }
                if (UpiAppUtils.checkIsVpa(this.f54341e)) {
                    View findViewById9 = view2.findViewById(R.id.bank_name_tv);
                    k.a((Object) findViewById9, "view.findViewById<TextView>(R.id.bank_name_tv)");
                    aa aaVar2 = aa.f47921a;
                    String string2 = getString(R.string.money_transfer_upi_without_bold);
                    k.a((Object) string2, "getString(R.string.money…ransfer_upi_without_bold)");
                    String format2 = String.format(string2, Arrays.copyOf(new Object[]{this.f54341e}, 1));
                    k.a((Object) format2, "java.lang.String.format(format, *args)");
                    ((TextView) findViewById9).setText(format2);
                    View findViewById10 = view2.findViewById(R.id.ifsc_tv);
                    k.a((Object) findViewById10, "view.findViewById<TextView>(R.id.ifsc_tv)");
                    ((TextView) findViewById10).setVisibility(8);
                    View findViewById11 = view2.findViewById(R.id.account_tv);
                    k.a((Object) findViewById11, "view.findViewById<TextView>(R.id.account_tv)");
                    ((TextView) findViewById11).setVisibility(8);
                    Intent intent = getIntent();
                    CharSequence stringExtra = intent != null ? intent.getStringExtra("picture") : null;
                    if (stringExtra == null || stringExtra.length() == 0) {
                        m.a((ImageView) view2.findViewById(R.id.bank_icon_iv), "UPI", (Context) this);
                    } else {
                        ((ImageView) view2.findViewById(R.id.bank_icon_iv)).setPadding(0, 0, 0, 0);
                        w a2 = w.a();
                        Intent intent2 = getIntent();
                        a2.a(intent2 != null ? intent2.getStringExtra("picture") : null).a((ah) new CircleTransform()).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a((ImageView) view2.findViewById(R.id.bank_icon_iv));
                    }
                } else {
                    if (!TextUtils.isEmpty(this.f54342f)) {
                        View findViewById12 = view2.findViewById(R.id.bank_name_tv);
                        k.a((Object) findViewById12, "view.findViewById<TextView>(R.id.bank_name_tv)");
                        ((TextView) findViewById12).setText(this.f54342f);
                    } else {
                        View findViewById13 = view2.findViewById(R.id.bank_name_tv);
                        k.a((Object) findViewById13, "view.findViewById<TextView>(R.id.bank_name_tv)");
                        ((TextView) findViewById13).setVisibility(8);
                    }
                    View findViewById14 = view2.findViewById(R.id.ifsc_tv);
                    k.a((Object) findViewById14, "view.findViewById<TextView>(R.id.ifsc_tv)");
                    aa aaVar3 = aa.f47921a;
                    String string3 = getString(R.string.money_transfer_ifsc_with_placeholder_without_bold);
                    k.a((Object) string3, "getString(R.string.money…placeholder_without_bold)");
                    String format3 = String.format(string3, Arrays.copyOf(new Object[]{this.f54344h}, 1));
                    k.a((Object) format3, "java.lang.String.format(format, *args)");
                    ((TextView) findViewById14).setText(format3);
                    View findViewById15 = view2.findViewById(R.id.account_tv);
                    k.a((Object) findViewById15, "view.findViewById<TextView>(R.id.account_tv)");
                    aa aaVar4 = aa.f47921a;
                    String string4 = getString(R.string.money_transfer_account_no);
                    k.a((Object) string4, "getString(R.string.money_transfer_account_no)");
                    String format4 = String.format(string4, Arrays.copyOf(new Object[]{this.f54341e}, 1));
                    k.a((Object) format4, "java.lang.String.format(format, *args)");
                    ((TextView) findViewById15).setText(format4);
                    Intent intent3 = getIntent();
                    CharSequence stringExtra2 = intent3 != null ? intent3.getStringExtra("picture") : null;
                    if (stringExtra2 == null || stringExtra2.length() == 0) {
                        m.a((ImageView) view2.findViewById(R.id.bank_icon_iv), this.f54344h, (Context) this);
                    } else {
                        ((ImageView) view2.findViewById(R.id.bank_icon_iv)).setPadding(0, 0, 0, 0);
                        w a3 = w.a();
                        Intent intent4 = getIntent();
                        a3.a(intent4 != null ? intent4.getStringExtra("picture") : null).a((ah) new CircleTransform()).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a((ImageView) view2.findViewById(R.id.bank_icon_iv));
                    }
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.BaseUpiResponse");
            }
        } else if (upiBaseDataModel instanceof CJRMoneyTransferIMPSInitiateDataModel) {
            if (upiBaseDataModel != null) {
                CJRMoneyTransferIMPSInitiateDataModel cJRMoneyTransferIMPSInitiateDataModel = (CJRMoneyTransferIMPSInitiateDataModel) upiBaseDataModel;
                if (!TextUtils.isEmpty(cJRMoneyTransferIMPSInitiateDataModel.getRrn())) {
                    CJRIMPSInitiateExtraInfoDataModel extraInfoDataModel = cJRMoneyTransferIMPSInitiateDataModel.getExtraInfoDataModel();
                    k.a((Object) extraInfoDataModel, "cjrMoneyTransferIMPSInit…aModel.extraInfoDataModel");
                    if (kotlin.m.p.a(extraInfoDataModel.getTransferType(), "neft", true)) {
                        View findViewById16 = view2.findViewById(R.id.mt_order_id_tv);
                        k.a((Object) findViewById16, "view.findViewById<TextView>(R.id.mt_order_id_tv)");
                        ((TextView) findViewById16).setText(getString(R.string.mt_neft_ref_id) + " " + cJRMoneyTransferIMPSInitiateDataModel.getRrn());
                    } else {
                        View findViewById17 = view2.findViewById(R.id.mt_order_id_tv);
                        k.a((Object) findViewById17, "view.findViewById<TextView>(R.id.mt_order_id_tv)");
                        ((TextView) findViewById17).setText(getString(R.string.mt_imps_ref_id) + " " + cJRMoneyTransferIMPSInitiateDataModel.getRrn());
                    }
                }
                if (!TextUtils.isEmpty(this.f54342f)) {
                    View findViewById18 = view2.findViewById(R.id.bank_name_tv);
                    k.a((Object) findViewById18, "view.findViewById<TextView>(R.id.bank_name_tv)");
                    ((TextView) findViewById18).setText(this.f54342f);
                } else {
                    View findViewById19 = view2.findViewById(R.id.bank_name_tv);
                    k.a((Object) findViewById19, "view.findViewById<TextView>(R.id.bank_name_tv)");
                    ((TextView) findViewById19).setVisibility(8);
                }
                View findViewById20 = view2.findViewById(R.id.ifsc_tv);
                k.a((Object) findViewById20, "view.findViewById<TextView>(R.id.ifsc_tv)");
                aa aaVar5 = aa.f47921a;
                String string5 = getString(R.string.money_transfer_ifsc_with_placeholder_without_bold);
                k.a((Object) string5, "getString(R.string.money…placeholder_without_bold)");
                String format5 = String.format(string5, Arrays.copyOf(new Object[]{this.f54344h}, 1));
                k.a((Object) format5, "java.lang.String.format(format, *args)");
                ((TextView) findViewById20).setText(format5);
                View findViewById21 = view2.findViewById(R.id.account_tv);
                k.a((Object) findViewById21, "view.findViewById<TextView>(R.id.account_tv)");
                aa aaVar6 = aa.f47921a;
                String string6 = getString(R.string.money_transfer_account_no);
                k.a((Object) string6, "getString(R.string.money_transfer_account_no)");
                String format6 = String.format(string6, Arrays.copyOf(new Object[]{UpiUtils.maskAccNumberWithSpace(this.f54341e)}, 1));
                k.a((Object) format6, "java.lang.String.format(format, *args)");
                ((TextView) findViewById21).setText(format6);
                Intent intent5 = getIntent();
                CharSequence stringExtra3 = intent5 != null ? intent5.getStringExtra("picture") : null;
                if (stringExtra3 == null || stringExtra3.length() == 0) {
                    m.a((ImageView) view2.findViewById(R.id.bank_icon_iv), this.f54344h, (Context) this);
                } else {
                    ((ImageView) view2.findViewById(R.id.bank_icon_iv)).setPadding(0, 0, 0, 0);
                    w a4 = w.a();
                    Intent intent6 = getIntent();
                    a4.a(intent6 != null ? intent6.getStringExtra("picture") : null).a((ah) new CircleTransform()).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a((ImageView) view2.findViewById(R.id.bank_icon_iv));
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel");
            }
        }
        if (!TextUtils.isEmpty(this.f54340d) && !kotlin.m.p.a(this.f54340d, "NA", true)) {
            View findViewById22 = view2.findViewById(R.id.comment_tv);
            k.a((Object) findViewById22, "view.findViewById<TextView>(R.id.comment_tv)");
            ((TextView) findViewById22).setText("\" " + this.f54340d + " \"");
            ((TextView) view2.findViewById(R.id.comment_tv)).setVisibility(0);
        }
        TextView textView = view2 != null ? (TextView) view2.findViewById(R.id.payer_name_tv) : null;
        TextView textView2 = view2 != null ? (TextView) view2.findViewById(R.id.payer_bank_name_tv) : null;
        ImageView imageView = view2 != null ? (ImageView) view2.findViewById(R.id.payer_bank_icon_iv) : null;
        UpiProfileDefaultBank upiProfileDefaultBank = this.l;
        if (upiProfileDefaultBank != null) {
            if (textView != null) {
                textView.setText(net.one97.paytm.upi.f.a((upiProfileDefaultBank == null || (debitBank3 = upiProfileDefaultBank.getDebitBank()) == null) ? null : debitBank3.getCustomerName()));
            }
            if (textView2 != null) {
                UpiProfileDefaultBank upiProfileDefaultBank2 = this.l;
                textView2.setText((upiProfileDefaultBank2 == null || (debitBank2 = upiProfileDefaultBank2.getDebitBank()) == null) ? null : debitBank2.getBankName());
            }
            UpiProfileDefaultBank upiProfileDefaultBank3 = this.l;
            if (!(upiProfileDefaultBank3 == null || (debitBank = upiProfileDefaultBank3.getDebitBank()) == null)) {
                str = debitBank.getIfsc();
            }
            m.a(imageView, str, (Context) this);
        } else {
            if (textView != null) {
                Intent intent7 = getIntent();
                if (intent7 != null) {
                    str = intent7.getStringExtra(UpiConstants.EXTRA_PAYER_NAME);
                }
                textView.setText(net.one97.paytm.upi.f.a(str));
            }
            if (textView2 != null) {
                textView2.setText(getString(R.string.money_tranfer_balance_paytm_bank_string));
            }
            m.a(imageView, "PYTM0123456", (Context) this);
        }
        if (textView != null) {
            textView.setVisibility(0);
        }
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        if (!(view2 == null || (findViewById3 = view2.findViewById(R.id.payee_payer_divider)) == null)) {
            findViewById3.setVisibility(0);
        }
        if (!(view2 == null || (findViewById2 = view2.findViewById(R.id.bottomBlueLinesContainer)) == null)) {
            findViewById2.setVisibility(0);
        }
        if (view2 != null && (findViewById = view2.findViewById(R.id.paymentFromContainer)) != null) {
            findViewById.setVisibility(0);
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 10 && i3 == -1) {
            Toast.makeText(this, R.string.upi_reset_mpin_success, 0).show();
        }
    }

    private final String e() {
        if (TextUtils.isEmpty(this.s)) {
            String a2 = com.paytm.utility.b.a(Long.valueOf(System.currentTimeMillis()), "hh:mm a, dd MMM yyyy");
            k.a((Object) a2, "CJRAppCommonUtility.getD…TIME_FORMAT\n            )");
            this.s = a2;
        }
        return this.s;
    }

    public final void b() {
        AnimationFactory.stopWalletLoader((LottieAnimationView) a(R.id.check_balance_loader));
        TextView textView = (TextView) a(R.id.check_balance_tv);
        k.a((Object) textView, "check_balance_tv");
        textView.setVisibility(0);
    }

    public final void Z_() {
        AnimationFactory.startWalletLoader((LottieAnimationView) a(R.id.check_balance_loader));
        TextView textView = (TextView) a(R.id.check_balance_tv);
        k.a((Object) textView, "check_balance_tv");
        textView.setVisibility(8);
    }

    public static final /* synthetic */ void d(MoneyTransferTxnDetailActivity moneyTransferTxnDetailActivity) {
        String str;
        if (UpiAppUtils.checkIsVpa(moneyTransferTxnDetailActivity.f54341e)) {
            StringBuilder sb = new StringBuilder();
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            sb.append(net.one97.paytm.moneytransfer.d.d.b(d.a.a()).b());
            sb.append("&pa=");
            sb.append(moneyTransferTxnDetailActivity.f54341e);
            sb.append("&pn=");
            sb.append(moneyTransferTxnDetailActivity.f54339c);
            str = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            d.a aVar2 = net.one97.paytm.moneytransfer.d.d.f53996a;
            sb2.append(net.one97.paytm.moneytransfer.d.d.b(d.a.a()).b());
            sb2.append("&account=");
            sb2.append(moneyTransferTxnDetailActivity.f54341e);
            sb2.append("&pn=");
            sb2.append(moneyTransferTxnDetailActivity.f54339c);
            sb2.append("&ifsc=");
            sb2.append(moneyTransferTxnDetailActivity.f54344h);
            str = sb2.toString();
            if (!TextUtils.isEmpty(moneyTransferTxnDetailActivity.f54342f)) {
                str = str + "&bank_name=" + moneyTransferTxnDetailActivity.f54342f;
            }
        }
        d.a aVar3 = net.one97.paytm.moneytransfer.d.d.f53996a;
        net.one97.paytm.moneytransfer.d.d.b(d.a.a()).a((Context) moneyTransferTxnDetailActivity, str);
        moneyTransferTxnDetailActivity.setResult(-1);
        moneyTransferTxnDetailActivity.finish();
    }

    public static final /* synthetic */ void h(MoneyTransferTxnDetailActivity moneyTransferTxnDetailActivity) {
        UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
        UpiProfileDefaultBank upiProfileDefaultBank2 = moneyTransferTxnDetailActivity.l;
        upiProfileDefaultBank.setDebitBank(upiProfileDefaultBank2 != null ? upiProfileDefaultBank2.getDebitBank() : null);
        UpiProfileDefaultBank upiProfileDefaultBank3 = moneyTransferTxnDetailActivity.l;
        upiProfileDefaultBank.setVirtualAddress(upiProfileDefaultBank3 != null ? upiProfileDefaultBank3.getVirtualAddress() : null);
        Intent intent = new Intent(moneyTransferTxnDetailActivity, SetMPINActivity.class);
        ArrayList arrayList = new ArrayList();
        arrayList.add(upiProfileDefaultBank.getDebitBank());
        UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, upiProfileDefaultBank.getVirtualAddress()).setBankAccountList(arrayList).build();
        intent.putExtra("user_upi_details", build);
        k.a((Object) build, "userUpiDetails");
        if (build.getBankAccountList() != null) {
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
            b2.b("MoneyTransferTxnDetailActivity", String.valueOf(build.getBankAccountList().size()) + "_" + build.getSelectedBankIdx());
        } else {
            d.a aVar2 = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.a b3 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
            b3.b("MoneyTransferTxnDetailActivity", "null_" + build.getSelectedBankIdx());
        }
        intent.putExtra(UpiConstants.CAME_FROM_INCORRECT_PIN_DIALOG, true);
        moneyTransferTxnDetailActivity.startActivityForResult(intent, 10);
    }
}
