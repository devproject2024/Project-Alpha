package net.one97.paytm.deeplink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.paytm.utility.q;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.dynamic.module.bank.DbtUtilsKt;
import net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.upi.util.UpiConstants;

public final class ae {

    /* renamed from: a  reason: collision with root package name */
    public static final ae f50307a = new ae();

    /* renamed from: b  reason: collision with root package name */
    private static a f50308b;

    /* renamed from: c  reason: collision with root package name */
    private static Bundle f50309c = new Bundle();

    /* renamed from: d  reason: collision with root package name */
    private static String[] f50310d = {"block_card", "retry_request_atm", "change_atm_pin", "manage_debit", "enter_passcode", "set_passcode", "open_acc_base", "add_money_bank", "savings_acc_info", "savings_acc", "acc_open", "bank_landing", "activate_pdc", "fgt_passcode", "alter_nominee", "forgot_atm_pin", "nach_mandate", "bank_acc_requeseted", "bank_acc_opened", "add_pan_card", "add_aadhar_card", "upgrade_kyc", "request_atm", "track_atm_order", "redeem_fd", "fd_projection", "fd_interest_certificate", "fd_tds_certificate", "fd_form_15", "fd_interest_table", "fd_passbook", "fd_benefits", "automatic_payments", "cheque_book", "savings_account_passbook_tab", "create_cif", "create_fd", "open_ica", "fixed_deposit", "fd_break", "withdraw_cash_nearby", "activate_dormant_acc", DbtUtilsKt.DBT_VERTICAL_NAME, "dc_payment_settings"};

    public interface a {
        void logoutBank();

        void setDeepLink(String str);

        void setFDId(String str);

        void setGoToScreen(String str);

        void setOrderId(String str);

        void setQrCodeId(String str);
    }

    private ae() {
    }

    public static a a() {
        return f50308b;
    }

    public static void a(Bundle bundle) {
        k.c(bundle, "<set-?>");
        f50309c = bundle;
    }

    public static Bundle b() {
        return f50309c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:135:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r6, net.one97.paytm.deeplink.DeepLinkData r7) {
        /*
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r6, r0)
            java.lang.String r0 = "deepLinkData"
            kotlin.g.b.k.c(r7, r0)
            net.one97.paytm.dynamicModule.DynamicModuleManager r0 = net.one97.paytm.dynamicModule.DynamicModuleManager.getInstance()
            java.lang.String r1 = "ddbase"
            boolean r0 = r0.isInstalled(r1)
            r2 = 1
            if (r0 == 0) goto L_0x0350
            java.lang.String r0 = r7.f50288f
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            f50309c = r1
            java.lang.String r1 = r7.f50283a
            if (r1 == 0) goto L_0x0039
            net.one97.paytm.deeplink.ae$a r3 = f50308b
            if (r3 == 0) goto L_0x0030
            if (r3 == 0) goto L_0x0039
            r3.setDeepLink(r1)
            kotlin.x r1 = kotlin.x.f47997a
            goto L_0x0039
        L_0x0030:
            android.os.Bundle r3 = f50309c
            java.lang.String r4 = "deeplink"
            r3.putString(r4, r1)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x0039:
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r1 = r1 ^ r2
            java.lang.String r3 = "activate_dormant_acc"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x004d
            b(r6, r7)
            return
        L_0x004d:
            java.lang.String r3 = "set_passcode"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x005a
            b(r6, r7)
            return
        L_0x005a:
            java.lang.String r3 = "add_money_bank"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x0066
            b(r6, r7)
            return
        L_0x0066:
            java.lang.String r3 = "enter_passcode"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x0072
            b(r6, r7)
            return
        L_0x0072:
            java.lang.String r3 = "savings_acc_info"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x007e
            b(r6, r7)
            return
        L_0x007e:
            java.lang.String r3 = "savings_acc"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x008a
            b(r6, r7)
            return
        L_0x008a:
            java.lang.String r3 = "open_acc_base"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x0096
            b(r6, r7)
            return
        L_0x0096:
            java.lang.String r3 = "bank_landing"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x00c4
            android.net.Uri r0 = r7.f50289g
            if (r0 == 0) goto L_0x00c0
            android.net.Uri r0 = r7.f50289g
            if (r0 != 0) goto L_0x00a9
            kotlin.g.b.k.a()
        L_0x00a9:
            java.lang.String r1 = "open_screen"
            java.lang.String r0 = r0.getQueryParameter(r1)
            if (r0 == 0) goto L_0x00c0
            android.net.Uri r0 = r7.f50289g
            if (r0 != 0) goto L_0x00b8
            kotlin.g.b.k.a()
        L_0x00b8:
            java.lang.String r0 = r0.getQueryParameter(r1)
            a(r6, r0, r7)
            return
        L_0x00c0:
            b(r6, r7)
            return
        L_0x00c4:
            java.lang.String r3 = "cheque_book"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x00d0
            a(r6, r0, r7)
            return
        L_0x00d0:
            java.lang.String r3 = "fgt_passcode"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x00dc
            b(r6, r7)
            return
        L_0x00dc:
            java.lang.String r3 = "bank_acc_requeseted"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x00e8
            b(r6, r7)
            return
        L_0x00e8:
            java.lang.String r3 = "bank_acc_opened"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x00f4
            b(r6, r7)
            return
        L_0x00f4:
            java.lang.String r3 = "add_pan_card"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x0100
            b(r6, r7)
            return
        L_0x0100:
            java.lang.String r3 = "add_aadhar_card"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x010c
            b(r6, r7)
            return
        L_0x010c:
            java.lang.String r3 = "upgrade_kyc"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x0119
            b(r6, r7)
            return
        L_0x0119:
            java.lang.String r3 = "redeem_fd"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x0125
            b(r6, r7)
            return
        L_0x0125:
            java.lang.String r3 = "fd_break"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x0131
            b(r6, r7)
            return
        L_0x0131:
            java.lang.String r3 = "dbt"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x013d
            a(r6, r0, r7)
            return
        L_0x013d:
            java.lang.String r3 = "dc_payment_settings"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x0149
            a(r6, r0, r7)
            return
        L_0x0149:
            java.lang.String r3 = "alter_nominee"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x0155
            a(r6, r0, r7)
            return
        L_0x0155:
            java.lang.String r3 = "forgot_atm_pin"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x0161
            a(r6, r0, r7)
            return
        L_0x0161:
            java.lang.String r3 = "nach_mandate"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x016d
            a(r6, r0, r7)
            return
        L_0x016d:
            java.lang.String r3 = "manage_debit"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x0179
            a(r6, r0, r7)
            return
        L_0x0179:
            java.lang.String r3 = "request_atm"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x0185
            a(r6, r0, r7)
            return
        L_0x0185:
            java.lang.String r3 = "track_atm_order"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x01c9
            android.net.Uri r1 = r7.f50289g
            if (r1 == 0) goto L_0x01b2
            android.net.Uri r1 = r7.f50289g
            if (r1 != 0) goto L_0x0199
            kotlin.g.b.k.a()
        L_0x0199:
            java.lang.String r2 = "id"
            java.lang.String r1 = r1.getQueryParameter(r2)
            if (r1 == 0) goto L_0x01b2
            android.net.Uri r1 = r7.f50289g
            if (r1 != 0) goto L_0x01a8
            kotlin.g.b.k.a()
        L_0x01a8:
            java.lang.String r1 = r1.getQueryParameter(r2)
            if (r1 != 0) goto L_0x01b4
            kotlin.g.b.k.a()
            goto L_0x01b4
        L_0x01b2:
            java.lang.String r1 = ""
        L_0x01b4:
            net.one97.paytm.deeplink.ae$a r2 = f50308b
            if (r2 == 0) goto L_0x01be
            if (r2 == 0) goto L_0x01c5
            r2.setOrderId(r1)
            goto L_0x01c5
        L_0x01be:
            android.os.Bundle r2 = f50309c
            java.lang.String r3 = "orderId"
            r2.putString(r3, r1)
        L_0x01c5:
            a(r6, r0, r7)
            return
        L_0x01c9:
            java.lang.String r3 = "fd_projection"
            boolean r4 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            java.lang.String r5 = "goto"
            if (r1 != r4) goto L_0x0225
            android.net.Uri r0 = r7.f50289g
            if (r0 == 0) goto L_0x0372
            android.net.Uri r0 = r7.f50289g
            if (r0 != 0) goto L_0x01de
            kotlin.g.b.k.a()
        L_0x01de:
            java.lang.String r1 = "fd_id"
            java.lang.String r0 = r0.getQueryParameter(r1)
            if (r0 == 0) goto L_0x0372
            net.one97.paytm.deeplink.ae$a r0 = f50308b
            if (r0 == 0) goto L_0x020c
            if (r0 == 0) goto L_0x0204
            android.net.Uri r2 = r7.f50289g
            if (r2 != 0) goto L_0x01f3
            kotlin.g.b.k.a()
        L_0x01f3:
            java.lang.String r1 = r2.getQueryParameter(r1)
            if (r1 != 0) goto L_0x01fc
            kotlin.g.b.k.a()
        L_0x01fc:
            java.lang.String r2 = "deepLinkData.getDeepLink…QueryParameter(\"fd_id\")!!"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r0.setFDId(r1)
        L_0x0204:
            net.one97.paytm.deeplink.ae$a r0 = f50308b
            if (r0 == 0) goto L_0x0221
            r0.setGoToScreen(r3)
            goto L_0x0221
        L_0x020c:
            android.os.Bundle r0 = f50309c
            android.net.Uri r2 = r7.f50289g
            if (r2 != 0) goto L_0x0215
            kotlin.g.b.k.a()
        L_0x0215:
            java.lang.String r2 = r2.getQueryParameter(r1)
            r0.putString(r1, r2)
            android.os.Bundle r0 = f50309c
            r0.putString(r5, r3)
        L_0x0221:
            b(r6, r7)
            return
        L_0x0225:
            java.lang.String r3 = "fd_interest_certificate"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x0231
            a(r6, r0, r7)
            return
        L_0x0231:
            java.lang.String r3 = "fixed_deposit"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x023d
            a(r6, r0, r7)
            return
        L_0x023d:
            java.lang.String r3 = "fd_tds_certificate"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x0249
            a(r6, r0, r7)
            return
        L_0x0249:
            java.lang.String r3 = "fd_form_15"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x0255
            a(r6, r0, r7)
            return
        L_0x0255:
            java.lang.String r3 = "fd_interest_table"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x0261
            a(r6, r0, r7)
            return
        L_0x0261:
            java.lang.String r3 = "fd_passbook"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x026d
            a(r6, r0, r7)
            return
        L_0x026d:
            java.lang.String r3 = "fd_benefits"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x0279
            a(r6, r0, r7)
            return
        L_0x0279:
            java.lang.String r3 = "activate_pdc"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x02d9
            net.one97.paytm.deeplink.ae$a r0 = f50308b
            java.lang.String r1 = "verifyPassAndActivatePin"
            if (r0 == 0) goto L_0x028e
            if (r0 == 0) goto L_0x0293
            r0.setGoToScreen(r1)
            goto L_0x0293
        L_0x028e:
            android.os.Bundle r0 = f50309c
            r0.putString(r5, r1)
        L_0x0293:
            android.os.Bundle r0 = r7.f50290h
            if (r0 == 0) goto L_0x02d5
            android.os.Bundle r0 = r7.f50290h
            if (r0 != 0) goto L_0x029e
            kotlin.g.b.k.a()
        L_0x029e:
            java.lang.String r1 = "qrCodeId"
            java.lang.String r0 = r0.getString(r1)
            if (r0 == 0) goto L_0x02d5
            net.one97.paytm.deeplink.ae$a r0 = f50308b
            if (r0 == 0) goto L_0x02c5
            if (r0 == 0) goto L_0x02d5
            android.os.Bundle r2 = r7.f50290h
            if (r2 != 0) goto L_0x02b3
            kotlin.g.b.k.a()
        L_0x02b3:
            java.lang.String r1 = r2.getString(r1)
            if (r1 != 0) goto L_0x02bc
            kotlin.g.b.k.a()
        L_0x02bc:
            java.lang.String r2 = "deepLinkData.mBundle!!.getString(\"qrCodeId\")!!"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r0.setQrCodeId(r1)
            goto L_0x02d5
        L_0x02c5:
            android.os.Bundle r0 = f50309c
            android.os.Bundle r2 = r7.f50290h
            if (r2 != 0) goto L_0x02ce
            kotlin.g.b.k.a()
        L_0x02ce:
            java.lang.String r2 = r2.getString(r1)
            r0.putString(r1, r2)
        L_0x02d5:
            b(r6, r7)
            return
        L_0x02d9:
            java.lang.String r3 = "automatic_payments"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x02e5
            a(r6, r0, r7)
            return
        L_0x02e5:
            java.lang.String r3 = "block_card"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x02f1
            a(r6, r0, r7)
            return
        L_0x02f1:
            java.lang.String r3 = "retry_request_atm"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x02fd
            a(r6, r0, r7)
            return
        L_0x02fd:
            java.lang.String r3 = "change_atm_pin"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x0309
            a(r6, r0, r7)
            return
        L_0x0309:
            java.lang.String r3 = "savings_account_passbook_tab"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x0315
            a(r6, r0, r7)
            return
        L_0x0315:
            java.lang.String r3 = "create_fd"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x0321
            a(r6, r0, r7)
            return
        L_0x0321:
            java.lang.String r3 = "create_cif"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x032d
            a(r6, r0, r7)
            return
        L_0x032d:
            java.lang.String r3 = "open_ica"
            boolean r3 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r3) goto L_0x0343
            android.content.Intent r7 = new android.content.Intent
            r7.<init>()
            java.lang.String r0 = "open_ica_isa_opening"
            r7.setAction(r0)
            a((android.content.Context) r6, (android.content.Intent) r7)
            return
        L_0x0343:
            java.lang.String r3 = "withdraw_cash_nearby"
            boolean r2 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r2)
            if (r1 != r2) goto L_0x034f
            a(r6, r0, r7)
        L_0x034f:
            return
        L_0x0350:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity> r3 = net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity.class
            r0.<init>(r6, r3)
            android.os.Parcelable r7 = (android.os.Parcelable) r7
            java.lang.String r3 = "EXTRA_DEEP_LINK_DATA"
            r0.putExtra(r3, r7)
            java.lang.String r7 = "EXTRA_DEEP_LINK_FLAG"
            r0.putExtra(r7, r2)
            java.lang.String r7 = net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY
            java.lang.String r2 = "net.one97.paytm.dynamic.module.bank.BankInitActivity"
            r0.putExtra(r7, r2)
            java.lang.String r7 = net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity.EXTRA_INIT_MODULE
            r0.putExtra(r7, r1)
            a((android.content.Intent) r0, (android.content.Context) r6)
        L_0x0372:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.deeplink.ae.a(android.content.Context, net.one97.paytm.deeplink.DeepLinkData):void");
    }

    public static void a(Intent intent, Context context) {
        k.c(intent, "intent");
        k.c(context, "context");
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    private static void a(Context context, String str, DeepLinkData deepLinkData) {
        a aVar = f50308b;
        if (aVar == null) {
            Bundle bundle = f50309c;
            if (str == null) {
                k.a();
            }
            bundle.putString("goto", str);
        } else if (aVar != null) {
            if (str == null) {
                k.a();
            }
            aVar.setGoToScreen(str);
        }
        b(context, deepLinkData);
    }

    private static void b(Context context, DeepLinkData deepLinkData) {
        Intent intent = new Intent();
        if (DynamicModuleManager.getInstance().isInstalled("ddbase")) {
            intent.setClassName(context, "net.one97.paytm.dynamic.module.bank.BankInitActivity");
        } else {
            intent = new Intent(context, CommonDynamicLoaderActivity.class);
            intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.bank.BankInitActivity");
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "ddbase");
        }
        intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
        try {
            a(intent, context);
        } catch (Exception unused) {
        }
    }

    public static void a(Context context, Intent intent) {
        k.c(context, "context");
        k.c(intent, "intent");
        intent.setPackage("net.one97.paytm");
        if (DynamicModuleManager.getInstance().isInstalled("ddbase")) {
            q.d("module is installed");
            intent.setClassName(context, "net.one97.paytm.dynamic.module.bank.BankInitActivity");
        } else {
            intent.setClass(context, CommonDynamicLoaderActivity.class);
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.bank.BankInitActivity");
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "ddbase");
        }
        try {
            a(intent, context);
        } catch (Exception unused) {
        }
    }

    public static Intent a(Activity activity, Intent intent) {
        k.c(activity, "context");
        k.c(intent, "intent");
        intent.setPackage("net.one97.paytm");
        if (DynamicModuleManager.getInstance().isInstalled("ddbase")) {
            q.d("module is installed");
            intent.setClassName(activity, "net.one97.paytm.dynamic.module.bank.BankInitActivity");
        } else {
            intent.setClass(activity, CommonDynamicLoaderActivity.class);
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.bank.BankInitActivity");
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "ddbase");
        }
        return intent;
    }

    public static void a(a aVar) {
        k.c(aVar, "listener");
        f50308b = aVar;
    }

    public static boolean a(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        if (p.a(deepLinkData.f50284b, "payment_bank", false)) {
            String str = deepLinkData.f50288f;
            for (String a2 : f50310d) {
                if (p.a(a2, str, true)) {
                    return true;
                }
            }
        }
        if (!p.a(deepLinkData.f50284b, "paymentbank", false) || !p.a("dc_payment_settings", deepLinkData.f50288f, true)) {
            return false;
        }
        return true;
    }
}
