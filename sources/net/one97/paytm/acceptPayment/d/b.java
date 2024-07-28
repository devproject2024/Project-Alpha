package net.one97.paytm.acceptPayment.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.business.common_module.e.c;
import com.business.common_module.utilities.LogUtility;
import com.business.merchant_payments.PaymentsConfig;
import com.google.gson.f;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.acceptPayment.e.a.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    static final String f52052a;

    /* renamed from: b  reason: collision with root package name */
    public static final b f52053b = new b();

    /* renamed from: c  reason: collision with root package name */
    private static final Context f52054c;

    static {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        Context appContext = instance.getAppContext();
        k.b(appContext, "PaymentsConfig.getInstance().appContext");
        f52054c = appContext;
        String simpleName = b.class.getSimpleName();
        k.b(simpleName, "MerchantPermissionsUtility::class.java.simpleName");
        f52052a = simpleName;
    }

    private b() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0113, code lost:
        a("FREQUENCY_OPTIONS_PERMISSION", true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012c, code lost:
        a("NON_BW_DOWNLOAD_STATEMENT_PERMISSION", true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x013b, code lost:
        a("TXN_LIST_DEF_PERMISSION", true);
        a("WALLETREFUNDREPORT", true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x014f, code lost:
        a("TXN_INIT_REFUND_PERMISSION", true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x015e, code lost:
        a("PERMISSION_INSTANT_SETTLEMENT", true);
        com.business.common_module.utilities.LogUtility.i("ROLES", "INSTANT_SETTLEMENT PERMISSION: True");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01cc, code lost:
        a("SHOW_SETTLEMENT_PERMISSION", true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01db, code lost:
        a("TXN_LIST_REFUND_PERMISSION", true);
        a("has_refund_notification_permission", true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01fe, code lost:
        a("TXN_LIST_DOWNLOAD_PERMISSION", true);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.util.ArrayList<java.lang.String> r5) {
        /*
            java.lang.String r0 = "permissionList"
            kotlin.g.b.k.d(r5, r0)
            a()
            java.util.Iterator r5 = r5.iterator()
        L_0x000c:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0223
            java.lang.Object r0 = r5.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "PERMISSION: "
            java.lang.String r1 = r2.concat(r1)
            java.lang.String r2 = "roleperm"
            com.business.common_module.utilities.LogUtility.d(r2, r1)
            int r1 = r0.hashCode()
            java.lang.String r2 = "create_and_update_qr_code_role"
            java.lang.String r3 = "ROLES"
            r4 = 1
            switch(r1) {
                case -2091961653: goto L_0x0214;
                case -2070908288: goto L_0x0205;
                case -1874844062: goto L_0x01f6;
                case -1824896845: goto L_0x01e7;
                case -1629325822: goto L_0x01d3;
                case -1484792886: goto L_0x01c4;
                case -1449503646: goto L_0x01b5;
                case -1378211666: goto L_0x01a6;
                case -1340263281: goto L_0x0197;
                case -1333421274: goto L_0x0188;
                case -1094183520: goto L_0x0179;
                case -732067722: goto L_0x016a;
                case -722544456: goto L_0x0156;
                case -521058599: goto L_0x0147;
                case -492581623: goto L_0x0133;
                case -417646038: goto L_0x0124;
                case -385362007: goto L_0x011a;
                case -239668921: goto L_0x010b;
                case -203792156: goto L_0x0102;
                case -179450210: goto L_0x00f3;
                case -70618270: goto L_0x00e9;
                case -8678597: goto L_0x00da;
                case 279954363: goto L_0x00cb;
                case 283737298: goto L_0x00c1;
                case 312214274: goto L_0x00b7;
                case 336227651: goto L_0x00ad;
                case 685809721: goto L_0x009b;
                case 1131767013: goto L_0x0089;
                case 1397266972: goto L_0x007f;
                case 1498520219: goto L_0x0075;
                case 1519825116: goto L_0x0067;
                case 1531400547: goto L_0x005d;
                case 1683961079: goto L_0x004f;
                case 1803061435: goto L_0x0045;
                case 1970851459: goto L_0x0034;
                default: goto L_0x0033;
            }
        L_0x0033:
            goto L_0x000c
        L_0x0034:
            java.lang.String r1 = "ROLE_TXNWISE_SETTLEMENT"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            a((java.lang.String) r1, (boolean) r4)
            java.lang.String r0 = "INSTANT_SETTLEMENT ROLE: True"
            com.business.common_module.utilities.LogUtility.i(r3, r0)
            goto L_0x000c
        L_0x0045:
            java.lang.String r1 = "REFUNDREPORT_DOWNLOAD"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            goto L_0x01fe
        L_0x004f:
            java.lang.String r1 = "MERCHANTPROFILE_PRIMARYDETAIL_ADD"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "ADD_PRIMARY_DETAIL"
            a((java.lang.String) r0, (boolean) r4)
            goto L_0x000c
        L_0x005d:
            java.lang.String r1 = "WALLETSTLMENTREPORT_DOWNLOAD"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            goto L_0x012c
        L_0x0067:
            java.lang.String r1 = "BWWITHDRAW_BALANCE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "business_wallet_role"
            a((java.lang.String) r0, (boolean) r4)
            goto L_0x000c
        L_0x0075:
            java.lang.String r1 = "REFUNDREPORT_SEARCH"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            goto L_0x01db
        L_0x007f:
            java.lang.String r1 = "INSTANTSETTLE_UPDATE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            goto L_0x015e
        L_0x0089:
            java.lang.String r1 = "WALLETQRMERCHANT_SEARCH"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "SHOW_QR_LIST_PERMISSION"
            a((java.lang.String) r0, (boolean) r4)
            a((java.lang.String) r2, (boolean) r4)
            goto L_0x000c
        L_0x009b:
            java.lang.String r1 = "WALLETQRMERCHANT_CREATE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "CREATE_NEW_QR_PERMISSION"
            a((java.lang.String) r0, (boolean) r4)
            a((java.lang.String) r2, (boolean) r4)
            goto L_0x000c
        L_0x00ad:
            java.lang.String r1 = "WALLETSTLMENTREPORT_SEARCH"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            goto L_0x01cc
        L_0x00b7:
            java.lang.String r1 = "WALLETTXNREPORT_SEARCH"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            goto L_0x013b
        L_0x00c1:
            java.lang.String r1 = "WALLETTXNREPORT_REFUND"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            goto L_0x014f
        L_0x00cb:
            java.lang.String r1 = "LEDGER_VIEW"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "ledger_view_permission"
            a((java.lang.String) r0, (boolean) r4)
            goto L_0x000c
        L_0x00da:
            java.lang.String r1 = "PAYMENTLINK_CREATE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "PAYMENT_CREATE_PERMISSION"
            a((java.lang.String) r0, (boolean) r4)
            goto L_0x000c
        L_0x00e9:
            java.lang.String r1 = "WALLETTXNREPORT_DOWNLOAD"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            goto L_0x01fe
        L_0x00f3:
            java.lang.String r1 = "LEDGER_DOWNLOAD"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "ledger_download_permission"
            a((java.lang.String) r0, (boolean) r4)
            goto L_0x000c
        L_0x0102:
            java.lang.String r1 = "BWCONFIG_GETFUNDMOVE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            goto L_0x0113
        L_0x010b:
            java.lang.String r1 = "BWCONFIG_UPDATEFUNDMOVE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
        L_0x0113:
            java.lang.String r0 = "FREQUENCY_OPTIONS_PERMISSION"
            a((java.lang.String) r0, (boolean) r4)
            goto L_0x000c
        L_0x011a:
            java.lang.String r1 = "TXNREPORT_DOWNLOAD"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            goto L_0x01fe
        L_0x0124:
            java.lang.String r1 = "STLMENTREPORT_DOWNLOAD"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
        L_0x012c:
            java.lang.String r0 = "NON_BW_DOWNLOAD_STATEMENT_PERMISSION"
            a((java.lang.String) r0, (boolean) r4)
            goto L_0x000c
        L_0x0133:
            java.lang.String r1 = "TXNREPORT_SEARCH"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
        L_0x013b:
            java.lang.String r0 = "TXN_LIST_DEF_PERMISSION"
            a((java.lang.String) r0, (boolean) r4)
            java.lang.String r0 = "WALLETREFUNDREPORT"
            a((java.lang.String) r0, (boolean) r4)
            goto L_0x000c
        L_0x0147:
            java.lang.String r1 = "TXNREPORT_REFUND"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
        L_0x014f:
            java.lang.String r0 = "TXN_INIT_REFUND_PERMISSION"
            a((java.lang.String) r0, (boolean) r4)
            goto L_0x000c
        L_0x0156:
            java.lang.String r1 = "INSTANTSETTLE_VIEW"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
        L_0x015e:
            java.lang.String r0 = "PERMISSION_INSTANT_SETTLEMENT"
            a((java.lang.String) r0, (boolean) r4)
            java.lang.String r0 = "INSTANT_SETTLEMENT PERMISSION: True"
            com.business.common_module.utilities.LogUtility.i(r3, r0)
            goto L_0x000c
        L_0x016a:
            java.lang.String r1 = "MERCHANTPROFILE_SUBUSEREDITGSTIN"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "EDIT_GSTIN_PERMISSION"
            a((java.lang.String) r0, (boolean) r4)
            goto L_0x000c
        L_0x0179:
            java.lang.String r1 = "PAYMENTLINK_SHARE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "PAYMENT_LINK_SHARE_PERMISSION"
            a((java.lang.String) r0, (boolean) r4)
            goto L_0x000c
        L_0x0188:
            java.lang.String r1 = "PAYMENTLINK_FETCHALL"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "PAYMENT_LINK_PERMISSION"
            a((java.lang.String) r0, (boolean) r4)
            goto L_0x000c
        L_0x0197:
            java.lang.String r1 = "BWWITHDRAW_REQUEST"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "BW_TRANSFER_TO_BANK_PERMISSION"
            a((java.lang.String) r0, (boolean) r4)
            goto L_0x000c
        L_0x01a6:
            java.lang.String r1 = "BWORDER_SEARCH"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "BW_PASSBOOK_PERMISSION"
            a((java.lang.String) r0, (boolean) r4)
            goto L_0x000c
        L_0x01b5:
            java.lang.String r1 = "MERCHANTPROFILE_SUBUSEREDITNOTIFICATION"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "EDIT_SECONDARY_MOB_EMAIL_PERMISSION"
            a((java.lang.String) r0, (boolean) r4)
            goto L_0x000c
        L_0x01c4:
            java.lang.String r1 = "STLMENTREPORT_SEARCH"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
        L_0x01cc:
            java.lang.String r0 = "SHOW_SETTLEMENT_PERMISSION"
            a((java.lang.String) r0, (boolean) r4)
            goto L_0x000c
        L_0x01d3:
            java.lang.String r1 = "WALLETREFUNDREPORT_SEARCH"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
        L_0x01db:
            java.lang.String r0 = "TXN_LIST_REFUND_PERMISSION"
            a((java.lang.String) r0, (boolean) r4)
            java.lang.String r0 = "has_refund_notification_permission"
            a((java.lang.String) r0, (boolean) r4)
            goto L_0x000c
        L_0x01e7:
            java.lang.String r1 = "MERCHANTPROFILE_SUBUSEREDITBANK"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "EDIT_BANK_PERMISSION"
            a((java.lang.String) r0, (boolean) r4)
            goto L_0x000c
        L_0x01f6:
            java.lang.String r1 = "WALLETREFUNDREPORT_DOWNLOAD"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
        L_0x01fe:
            java.lang.String r0 = "TXN_LIST_DOWNLOAD_PERMISSION"
            a((java.lang.String) r0, (boolean) r4)
            goto L_0x000c
        L_0x0205:
            java.lang.String r1 = "EDC_VIEW"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "edc_merchant_role"
            a((java.lang.String) r0, (boolean) r4)
            goto L_0x000c
        L_0x0214:
            java.lang.String r1 = "MERCHANTPROFILE_SUBUSEREDITDISPLAY"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "EDIT_DISPLAY_NAME_PERMISSION"
            a((java.lang.String) r0, (boolean) r4)
            goto L_0x000c
        L_0x0223:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.acceptPayment.d.b.a(java.util.ArrayList):void");
    }

    private static void a(String str, boolean z) {
        a.f52055a.a(f52054c, str, z);
    }

    public static final void a() {
        a("TXN_LIST_DEF_PERMISSION", false);
        a("WALLETREFUNDREPORT", false);
        a("TXN_LIST_REFUND_PERMISSION", false);
        a("has_refund_notification_permission", false);
        a("TXN_LIST_DOWNLOAD_PERMISSION", false);
        a("TXN_INIT_REFUND_PERMISSION", false);
        a("SHOW_SETTLEMENT_PERMISSION", false);
        a("NON_BW_DOWNLOAD_STATEMENT_PERMISSION", false);
        a("BW_PASSBOOK_PERMISSION", false);
        a("BW_TRANSFER_TO_BANK_PERMISSION", false);
        a("FREQUENCY_OPTIONS_PERMISSION", false);
        a("PAYMENT_LINK_PERMISSION", false);
        a("PAYMENT_CREATE_PERMISSION", false);
        a("PAYMENT_LINK_SHARE_PERMISSION", false);
        a("SHOW_QR_LIST_PERMISSION", false);
        a("create_and_update_qr_code_role", false);
        a("CREATE_NEW_QR_PERMISSION", false);
        a("EDIT_DISPLAY_NAME_PERMISSION", false);
        a("EDIT_SECONDARY_MOB_EMAIL_PERMISSION", false);
        a("EDIT_BANK_PERMISSION", false);
        a("EDIT_GSTIN_PERMISSION", false);
        a("business_wallet_role", false);
        a("edc_merchant_role", false);
        a("ledger_download_permission", false);
        a("ledger_view_permission", false);
        a("ADD_PRIMARY_DETAIL", false);
        a("PERMISSION_INSTANT_SETTLEMENT", false);
        a("ROLE_TXNWISE_SETTLEMENT", false);
    }

    public static com.business.common_module.e.a d() {
        String b2 = a.f52055a.b(f52054c, "key_merchant_info", "");
        boolean z = false;
        if (b2 == null || b2.length() == 0) {
            return null;
        }
        try {
            return (com.business.common_module.e.a) new f().a(b2, com.business.common_module.e.a.class);
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
            try {
                com.business.common_module.c.a aVar = new com.business.common_module.c.a();
                aVar.b(e2.toString());
                aVar.d(e2.getStackTrace().toString());
                if (b2 == null || p.a(b2)) {
                    aVar.c("data is null/empty");
                } else {
                    aVar.c(e2.toString());
                }
                aVar.a("localError");
            } catch (Exception e3) {
                com.business.common_module.c.a aVar2 = new com.business.common_module.c.a();
                aVar2.b(e3.toString());
                if (b2 == null || p.a(b2)) {
                    z = true;
                }
                if (z) {
                    aVar2.c("data is null/empty");
                } else {
                    aVar2.c(e3.toString());
                }
                aVar2.a("localError");
            }
            return null;
        }
    }

    public static void a(com.business.common_module.e.a aVar) {
        com.business.common_module.e.b bVar;
        k.d(aVar, "merchantInfo");
        a.f52055a.a(f52054c, "key_merchant_info", new f().b(aVar));
        a.f52055a.a(f52054c, "key_merchant_info_exists", true);
        if (aVar.getMerchants() != null && aVar.getMerchants().size() > 0) {
            String b2 = a.f52055a.b(f52054c, "key_previous_mid", "");
            if (!TextUtils.isEmpty(b2)) {
                Iterator<com.business.common_module.e.b> it2 = aVar.getMerchants().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        bVar = null;
                        break;
                    }
                    bVar = it2.next();
                    k.b(bVar, "merchant");
                    if (p.a(bVar.getMid(), b2, true)) {
                        break;
                    }
                }
                if (bVar == null) {
                    a.f52055a.a(f52054c, "is_current_merchant", false);
                    bVar = aVar.getMerchants().get(0);
                } else {
                    a.f52055a.a(f52054c, "is_current_merchant", true);
                }
            } else {
                bVar = aVar.getMerchants().get(0);
            }
            ArrayList arrayList = new ArrayList();
            if (aVar.getEmail() != null) {
                arrayList.add(new Pair("key_merchant_email", aVar.getEmail()));
            }
            if (!TextUtils.isEmpty(aVar.getFirstName()) || !TextUtils.isEmpty(aVar.getLastName())) {
                if (aVar.getFirstName() != null) {
                    arrayList.add(new Pair("key_merchant_first_name", aVar.getFirstName()));
                }
                if (aVar.getLastName() != null) {
                    arrayList.add(new Pair("key_merchant_lastname", aVar.getLastName()));
                }
            } else {
                arrayList.add(new Pair("key_merchant_first_name", "User"));
            }
            a.f52055a.b(f52054c, arrayList);
            b(bVar);
        }
    }

    private static void b(com.business.common_module.e.b bVar) {
        if (bVar != null) {
            ArrayList arrayList = new ArrayList();
            if (bVar.getId() != null) {
                arrayList.add(new Pair("key_user_id", bVar.getId()));
            }
            if (bVar.getMid() != null) {
                arrayList.add(new Pair("merchant_id", bVar.getMid()));
            }
            if (bVar.getName() != null) {
                arrayList.add(new Pair("key_merchant_name", bVar.getName()));
            }
            if (bVar.getMobile() != null) {
                arrayList.add(new Pair("key_phone_number", bVar.getMobile()));
            }
            if (bVar.getMerchantType() != null) {
                arrayList.add(new Pair("key_merchant_type", bVar.getMerchantType()));
            }
            if (bVar.getEmail() != null) {
                arrayList.add(new Pair("key_merchant_email", bVar.getEmail()));
            }
            if (bVar.getCreatedOn() != null) {
                arrayList.add(new Pair("key_merchant_created_on", bVar.getCreatedOn()));
            }
            if (bVar.getGuid() != null) {
                arrayList.add(new Pair("merchant_guid", bVar.getGuid()));
            }
            if (bVar.getIsMerchant() != null) {
                arrayList.add(new Pair("key_merchant_admin", Boolean.valueOf(k.a((Object) bVar.getIsMerchant(), (Object) "1"))));
            }
            arrayList.add(new Pair("is_merchant_migrated", Boolean.valueOf(bVar.isMigrated())));
            arrayList.add(new Pair("is_merchant_active", Boolean.valueOf(bVar.isActive())));
            arrayList.add(new Pair("is_aggregator", Boolean.valueOf(bVar.isAggregator())));
            if (bVar.isChild()) {
                arrayList.add(new Pair("IS_PARENT_ACC", Boolean.FALSE));
            } else {
                arrayList.add(new Pair("IS_PARENT_ACC", Boolean.TRUE));
            }
            arrayList.add(new Pair("wallet_status", ""));
            if (bVar.getKybid() != null) {
                arrayList.add(new Pair("key_merchant_kybid", bVar.getKybid()));
            }
            ArrayList<c> roles = bVar.getRoles();
            k.b(roles, "roles");
            int size = roles.size();
            for (int i2 = 0; i2 < size; i2++) {
                StringBuilder sb = new StringBuilder("ROLE: ");
                c cVar = roles.get(i2);
                k.b(cVar, "roles[i]");
                sb.append(cVar.getRole());
                LogUtility.d("roleperm", sb.toString());
                c cVar2 = roles.get(i2);
                k.b(cVar2, "roles[i]");
                String role = cVar2.getRole();
                if (!TextUtils.isEmpty(role) && (p.a(role, "GOLD_ADMIN_USER", true) || p.a(role, "GOLD_MERCHANT_USER", true))) {
                    arrayList.add(new Pair("is_corporate_merchant", Boolean.TRUE));
                }
            }
            a.f52055a.b(f52054c, arrayList);
            e();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x003f A[EDGE_INSN: B:41:0x003f->B:37:0x003f ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.ArrayList<com.business.common_module.e.b> a(java.lang.String r9, java.util.ArrayList<com.business.common_module.e.b> r10) {
        /*
            java.lang.String r0 = "currentMerchantId"
            kotlin.g.b.k.d(r9, r0)
            java.lang.String r0 = "merchantsArrayList"
            kotlin.g.b.k.d(r10, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x0013:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto L_0x00b0
            java.lang.Object r1 = r10.next()
            com.business.common_module.e.b r1 = (com.business.common_module.e.b) r1
            java.lang.String r2 = "merchants"
            kotlin.g.b.k.b(r1, r2)
            java.util.ArrayList r2 = r1.getRoles()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0090
            java.util.ArrayList r2 = r1.getRoles()
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x0090
            java.util.ArrayList r2 = r1.getRoles()
            java.util.Iterator r2 = r2.iterator()
            r5 = 0
        L_0x003f:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x0091
            java.lang.Object r6 = r2.next()
            com.business.common_module.e.c r6 = (com.business.common_module.e.c) r6
            java.lang.String r7 = "roles"
            kotlin.g.b.k.b(r6, r7)
            java.lang.String r7 = r6.getRole()
            java.lang.String r8 = "OFFLINE_TRANSACTION_REPORT"
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 != 0) goto L_0x008e
            java.lang.String r7 = r6.getRole()
            java.lang.String r8 = "ONLINE_TRANSACTION_REPORT"
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 != 0) goto L_0x008e
            java.util.ArrayList r6 = r6.getPermissions()
            java.util.Iterator r6 = r6.iterator()
        L_0x0070:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x003f
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = "WALLETTXNREPORT_SEARCH"
            boolean r8 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r8, (boolean) r4)
            if (r8 != 0) goto L_0x008c
            java.lang.String r8 = "TXNREPORT_SEARCH"
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r8, (boolean) r4)
            if (r7 == 0) goto L_0x0070
        L_0x008c:
            r5 = 1
            goto L_0x003f
        L_0x008e:
            r5 = 1
            goto L_0x0091
        L_0x0090:
            r5 = 0
        L_0x0091:
            if (r5 == 0) goto L_0x0013
            boolean r2 = android.text.TextUtils.isEmpty(r9)
            if (r2 != 0) goto L_0x00ab
            java.lang.String r2 = r1.getId()
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r9, (boolean) r4)
            if (r2 == 0) goto L_0x00ab
            r1.setSelected(r4)
            r0.add(r3, r1)
            goto L_0x0013
        L_0x00ab:
            r0.add(r1)
            goto L_0x0013
        L_0x00b0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.acceptPayment.d.b.a(java.lang.String, java.util.ArrayList):java.util.ArrayList");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00d6, code lost:
        if (kotlin.m.p.a("REFUND", r7.getRole(), true) != false) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0127, code lost:
        if (kotlin.m.p.a("TRANSACTION_REFUND", r7.getRole(), true) == false) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0129, code lost:
        r0 = r7.getRole();
        kotlin.g.b.k.b(r0, "roles.role");
        r5 = java.util.Locale.getDefault();
        r19 = r8;
        kotlin.g.b.k.b(r5, "Locale.getDefault()");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x013d, code lost:
        if (r0 == null) goto L_0x023b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x013f, code lost:
        r0 = r0.toUpperCase(r5);
        kotlin.g.b.k.b(r0, "(this as java.lang.String).toUpperCase(locale)");
        r20 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0150, code lost:
        if (kotlin.m.p.a((java.lang.CharSequence) r0, (java.lang.CharSequence) "BUSINESSWALLET", false) == false) goto L_0x0165;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0152, code lost:
        r2.append("|BUSINESSWALLET");
        r0 = r17;
        r5 = r18;
        r8 = r19;
        r9 = r20;
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0165, code lost:
        r0 = r7.getRole();
        kotlin.g.b.k.b(r0, "roles.role");
        r9 = java.util.Locale.getDefault();
        kotlin.g.b.k.b(r9, "Locale.getDefault()");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0173, code lost:
        if (r0 == null) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0175, code lost:
        r0 = r0.toUpperCase(r9);
        kotlin.g.b.k.b(r0, "(this as java.lang.String).toUpperCase(locale)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0182, code lost:
        if (kotlin.m.p.a((java.lang.CharSequence) r0, (java.lang.CharSequence) "EDC", false) == false) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0184, code lost:
        r2.append("|EDC");
        r0 = r17;
        r5 = r18;
        r8 = r19;
        r9 = r20;
        r14 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01a2, code lost:
        if (kotlin.m.p.a("PAYMENT_LINK_PERMISSION", r7.getRole(), true) == false) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01a4, code lost:
        r0 = r17;
        r5 = r18;
        r8 = r19;
        r9 = r20;
        r13 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01bb, code lost:
        if (kotlin.m.p.a("ROLE_VOUCHER", r7.getRole(), true) == false) goto L_0x01ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01bd, code lost:
        r0 = r17;
        r5 = r18;
        r8 = r19;
        r9 = r20;
        r15 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01d4, code lost:
        if (kotlin.m.p.a("ROLE_TXNWISE_SETTLEMENT", r7.getRole(), true) == false) goto L_0x01e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01d6, code lost:
        r21 = r10;
        net.one97.paytm.acceptPayment.e.a.a.f52055a.a(f52054c, "ROLE_TXNWISE_SETTLEMENT", true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01e0, code lost:
        r21 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01e2, code lost:
        r0 = r7.getRole();
        kotlin.g.b.k.b(r0, "roles.role");
        r4 = java.util.Locale.ROOT;
        kotlin.g.b.k.b(r4, "Locale.ROOT");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01f0, code lost:
        if (r0 == null) goto L_0x022f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01f2, code lost:
        r0 = r0.toUpperCase(r4);
        kotlin.g.b.k.b(r0, "(this as java.lang.String).toUpperCase(locale)");
        r4 = r0.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0200, code lost:
        if (r4 == 300619844) goto L_0x0229;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0205, code lost:
        if (r4 == 1047156874) goto L_0x0223;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x020a, code lost:
        if (r4 != 1971986304) goto L_0x024b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0212, code lost:
        if (r0.equals("CREATE_AND_UPDATE_QR_CODE") == false) goto L_0x024b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0214, code lost:
        r0 = r17;
        r5 = r18;
        r8 = r19;
        r9 = r20;
        r10 = r21;
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0223, code lost:
        r0.equals("INVOICING");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0229, code lost:
        r0.equals("ROLE_INVOICE");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0234, code lost:
        throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.String");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x023a, code lost:
        throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.String");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0240, code lost:
        throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.String");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void e() {
        /*
            com.business.common_module.e.a r0 = d()
            if (r0 == 0) goto L_0x0330
            java.util.ArrayList r1 = r0.getMerchants()
            int r1 = r1.size()
            if (r1 == 0) goto L_0x0330
            java.util.ArrayList r0 = r0.getMerchants()
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0330
            java.lang.Object r1 = r0.next()
            com.business.common_module.e.b r1 = (com.business.common_module.e.b) r1
            net.one97.paytm.acceptPayment.e.a.a r2 = net.one97.paytm.acceptPayment.e.a.a.f52055a
            android.content.Context r3 = f52054c
            java.lang.String r4 = "merchant_id"
            java.lang.String r5 = ""
            java.lang.String r2 = r2.b((android.content.Context) r3, (java.lang.String) r4, (java.lang.String) r5)
            java.lang.String r3 = "merchants"
            kotlin.g.b.k.b(r1, r3)
            java.lang.String r3 = r1.getMid()
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0018
            net.one97.paytm.acceptPayment.e.a.a r0 = net.one97.paytm.acceptPayment.e.a.a.f52055a
            android.content.Context r2 = f52054c
            boolean r3 = r1.isWalletOnly()
            r4 = 1
            r3 = r3 ^ r4
            java.lang.String r5 = "tag_is_merchant_online"
            r0.a((android.content.Context) r2, (java.lang.String) r5, (boolean) r3)
            java.util.ArrayList r0 = r1.getRoles()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "null cannot be cast to non-null type java.lang.String"
            r7 = 0
            if (r0 == 0) goto L_0x0266
            int r8 = r0.size()
            if (r8 <= 0) goto L_0x0266
            net.one97.paytm.acceptPayment.e.a.a r8 = net.one97.paytm.acceptPayment.e.a.a.f52055a
            android.content.Context r9 = f52054c
            boolean r5 = r8.b((android.content.Context) r9, (java.lang.String) r5, (boolean) r7)
            java.util.Iterator r0 = r0.iterator()
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x007c:
            boolean r16 = r0.hasNext()
            if (r16 == 0) goto L_0x0259
            java.lang.Object r16 = r0.next()
            r7 = r16
            com.business.common_module.e.c r7 = (com.business.common_module.e.c) r7
            java.lang.String r4 = "roles"
            kotlin.g.b.k.b(r7, r4)
            java.lang.String r4 = r7.getRole()
            if (r4 == 0) goto L_0x0241
            java.lang.String r4 = r7.getRole()
            r3.append(r4)
            java.lang.String r4 = ","
            r3.append(r4)
            if (r5 == 0) goto L_0x00da
            java.lang.String r4 = r7.getRole()
            r17 = r0
            java.lang.String r0 = "ONLINE_REFUND_REPORT"
            r18 = r5
            r5 = 1
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r4, (boolean) r5)
            if (r0 != 0) goto L_0x00eb
            java.lang.String r0 = r7.getRole()
            java.lang.String r4 = "ONLINE_SETTLEMENT_REPORT"
            boolean r0 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r0, (boolean) r5)
            if (r0 != 0) goto L_0x00ff
            java.lang.String r0 = r7.getRole()
            java.lang.String r4 = "ONLINE_TRANSACTION_REPORT"
            boolean r0 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r0, (boolean) r5)
            if (r0 != 0) goto L_0x0114
            java.lang.String r0 = r7.getRole()
            java.lang.String r4 = "REFUND"
            boolean r0 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r0, (boolean) r5)
            if (r0 == 0) goto L_0x0129
            goto L_0x0245
        L_0x00da:
            r17 = r0
            r18 = r5
            r5 = 1
            java.lang.String r0 = r7.getRole()
            java.lang.String r4 = "OFFLINE_REFUND_REPORT"
            boolean r0 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r0, (boolean) r5)
            if (r0 == 0) goto L_0x00f3
        L_0x00eb:
            r0 = r17
            r5 = r18
            r4 = 1
            r7 = 0
            r9 = 1
            goto L_0x007c
        L_0x00f3:
            java.lang.String r0 = r7.getRole()
            java.lang.String r4 = "OFFLINE_SETTLEMENT_REPORT"
            boolean r0 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r0, (boolean) r5)
            if (r0 == 0) goto L_0x0108
        L_0x00ff:
            r0 = r17
            r5 = r18
            r4 = 1
            r7 = 0
            r10 = 1
            goto L_0x007c
        L_0x0108:
            java.lang.String r0 = r7.getRole()
            java.lang.String r4 = "OFFLINE_TRANSACTION_REPORT"
            boolean r0 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r0, (boolean) r5)
            if (r0 == 0) goto L_0x011d
        L_0x0114:
            r0 = r17
            r5 = r18
            r4 = 1
            r7 = 0
            r8 = 1
            goto L_0x007c
        L_0x011d:
            java.lang.String r0 = r7.getRole()
            java.lang.String r4 = "TRANSACTION_REFUND"
            boolean r0 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r0, (boolean) r5)
            if (r0 != 0) goto L_0x0245
        L_0x0129:
            java.lang.String r0 = r7.getRole()
            java.lang.String r4 = "roles.role"
            kotlin.g.b.k.b(r0, r4)
            java.util.Locale r5 = java.util.Locale.getDefault()
            r19 = r8
            java.lang.String r8 = "Locale.getDefault()"
            kotlin.g.b.k.b(r5, r8)
            if (r0 == 0) goto L_0x023b
            java.lang.String r0 = r0.toUpperCase(r5)
            java.lang.String r5 = "(this as java.lang.String).toUpperCase(locale)"
            kotlin.g.b.k.b(r0, r5)
            r20 = r9
            java.lang.String r9 = "BUSINESSWALLET"
            boolean r0 = kotlin.m.p.a((java.lang.CharSequence) r0, (java.lang.CharSequence) r9, false)
            if (r0 == 0) goto L_0x0165
            java.lang.String r0 = "|BUSINESSWALLET"
            r2.append(r0)
            r0 = r17
            r5 = r18
            r8 = r19
            r9 = r20
            r4 = 1
            r7 = 0
            r12 = 1
            goto L_0x007c
        L_0x0165:
            java.lang.String r0 = r7.getRole()
            kotlin.g.b.k.b(r0, r4)
            java.util.Locale r9 = java.util.Locale.getDefault()
            kotlin.g.b.k.b(r9, r8)
            if (r0 == 0) goto L_0x0235
            java.lang.String r0 = r0.toUpperCase(r9)
            kotlin.g.b.k.b(r0, r5)
            java.lang.String r8 = "EDC"
            boolean r0 = kotlin.m.p.a((java.lang.CharSequence) r0, (java.lang.CharSequence) r8, false)
            if (r0 == 0) goto L_0x0197
            java.lang.String r0 = "|EDC"
            r2.append(r0)
            r0 = r17
            r5 = r18
            r8 = r19
            r9 = r20
            r4 = 1
            r7 = 0
            r14 = 1
            goto L_0x007c
        L_0x0197:
            java.lang.String r0 = r7.getRole()
            java.lang.String r8 = "PAYMENT_LINK_PERMISSION"
            r9 = 1
            boolean r0 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r0, (boolean) r9)
            if (r0 == 0) goto L_0x01b1
            r0 = r17
            r5 = r18
            r8 = r19
            r9 = r20
            r4 = 1
            r7 = 0
            r13 = 1
            goto L_0x007c
        L_0x01b1:
            java.lang.String r0 = r7.getRole()
            java.lang.String r8 = "ROLE_VOUCHER"
            boolean r0 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r0, (boolean) r9)
            if (r0 == 0) goto L_0x01ca
            r0 = r17
            r5 = r18
            r8 = r19
            r9 = r20
            r4 = 1
            r7 = 0
            r15 = 1
            goto L_0x007c
        L_0x01ca:
            java.lang.String r0 = r7.getRole()
            java.lang.String r8 = "ROLE_TXNWISE_SETTLEMENT"
            boolean r0 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r0, (boolean) r9)
            if (r0 == 0) goto L_0x01e0
            net.one97.paytm.acceptPayment.e.a.a r0 = net.one97.paytm.acceptPayment.e.a.a.f52055a
            r21 = r10
            android.content.Context r10 = f52054c
            r0.a((android.content.Context) r10, (java.lang.String) r8, (boolean) r9)
            goto L_0x01e2
        L_0x01e0:
            r21 = r10
        L_0x01e2:
            java.lang.String r0 = r7.getRole()
            kotlin.g.b.k.b(r0, r4)
            java.util.Locale r4 = java.util.Locale.ROOT
            java.lang.String r7 = "Locale.ROOT"
            kotlin.g.b.k.b(r4, r7)
            if (r0 == 0) goto L_0x022f
            java.lang.String r0 = r0.toUpperCase(r4)
            kotlin.g.b.k.b(r0, r5)
            int r4 = r0.hashCode()
            r5 = 300619844(0x11eb1844, float:3.7091417E-28)
            if (r4 == r5) goto L_0x0229
            r5 = 1047156874(0x3e6a588a, float:0.22885337)
            if (r4 == r5) goto L_0x0223
            r5 = 1971986304(0x758a1f80, float:3.5018353E32)
            if (r4 != r5) goto L_0x024b
            java.lang.String r4 = "CREATE_AND_UPDATE_QR_CODE"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x024b
            r0 = r17
            r5 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            r4 = 1
            r7 = 0
            r11 = 1
            goto L_0x007c
        L_0x0223:
            java.lang.String r4 = "INVOICING"
            r0.equals(r4)
            goto L_0x024b
        L_0x0229:
            java.lang.String r4 = "ROLE_INVOICE"
            r0.equals(r4)
            goto L_0x024b
        L_0x022f:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r6)
            throw r0
        L_0x0235:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r6)
            throw r0
        L_0x023b:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r6)
            throw r0
        L_0x0241:
            r17 = r0
            r18 = r5
        L_0x0245:
            r19 = r8
            r20 = r9
            r21 = r10
        L_0x024b:
            r0 = r17
            r5 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            r4 = 1
            r7 = 0
            goto L_0x007c
        L_0x0259:
            r19 = r8
            r20 = r9
            r21 = r10
            r4 = r19
            r0 = r20
            r5 = r21
            goto L_0x026e
        L_0x0266:
            r0 = 0
            r4 = 0
            r5 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x026e:
            net.one97.paytm.acceptPayment.e.a.a r7 = net.one97.paytm.acceptPayment.e.a.a.f52055a
            android.content.Context r8 = f52054c
            java.lang.String r9 = "has_refund_notification_permission"
            r7.a((android.content.Context) r8, (java.lang.String) r9, (boolean) r0)
            net.one97.paytm.acceptPayment.e.a.a r0 = net.one97.paytm.acceptPayment.e.a.a.f52055a
            android.content.Context r7 = f52054c
            java.lang.String r8 = "WALLETREFUNDREPORT"
            r0.a((android.content.Context) r7, (java.lang.String) r8, (boolean) r4)
            net.one97.paytm.acceptPayment.e.a.a r0 = net.one97.paytm.acceptPayment.e.a.a.f52055a
            android.content.Context r4 = f52054c
            java.lang.String r7 = "STLMENTREPORT"
            r0.a((android.content.Context) r4, (java.lang.String) r7, (boolean) r5)
            net.one97.paytm.acceptPayment.e.a.a r0 = net.one97.paytm.acceptPayment.e.a.a.f52055a
            android.content.Context r4 = f52054c
            java.lang.String r5 = "create_and_update_qr_code_role"
            r0.a((android.content.Context) r4, (java.lang.String) r5, (boolean) r11)
            net.one97.paytm.acceptPayment.e.a.a r0 = net.one97.paytm.acceptPayment.e.a.a.f52055a
            android.content.Context r4 = f52054c
            java.lang.String r5 = "key_payment_link_role"
            r0.a((android.content.Context) r4, (java.lang.String) r5, (boolean) r13)
            net.one97.paytm.acceptPayment.e.a.a r0 = net.one97.paytm.acceptPayment.e.a.a.f52055a
            android.content.Context r4 = f52054c
            java.lang.String r5 = "business_wallet_role"
            r0.a((android.content.Context) r4, (java.lang.String) r5, (boolean) r12)
            net.one97.paytm.acceptPayment.e.a.a r0 = net.one97.paytm.acceptPayment.e.a.a.f52055a
            android.content.Context r4 = f52054c
            java.lang.String r5 = "edc_merchant_role"
            r0.a((android.content.Context) r4, (java.lang.String) r5, (boolean) r14)
            net.one97.paytm.acceptPayment.e.a.a r0 = net.one97.paytm.acceptPayment.e.a.a.f52055a
            android.content.Context r4 = f52054c
            java.lang.String r5 = "gv_role"
            r0.a((android.content.Context) r4, (java.lang.String) r5, (boolean) r15)
            net.one97.paytm.acceptPayment.e.a.a r0 = net.one97.paytm.acceptPayment.e.a.a.f52055a
            android.content.Context r4 = f52054c
            java.lang.String r2 = r2.toString()
            java.lang.String r5 = "key_merchant_role"
            r0.a((android.content.Context) r4, (java.lang.String) r5, (java.lang.String) r2)
            net.one97.paytm.acceptPayment.e.a.a r0 = net.one97.paytm.acceptPayment.e.a.a.f52055a
            android.content.Context r2 = f52054c
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "merchantAllRoles.toString()"
            kotlin.g.b.k.b(r3, r4)
            int r4 = r3.length()
            if (r4 <= 0) goto L_0x02d8
            r4 = 1
            goto L_0x02d9
        L_0x02d8:
            r4 = 0
        L_0x02d9:
            if (r4 == 0) goto L_0x0301
            int r4 = r3.length()
            r5 = 1
            int r4 = r4 - r5
            char r4 = r3.charAt(r4)
            r7 = 44
            if (r4 != r7) goto L_0x0301
            int r4 = r3.length()
            int r4 = r4 - r5
            if (r3 == 0) goto L_0x02fb
            r5 = 0
            java.lang.String r3 = r3.substring(r5, r4)
            java.lang.String r4 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.g.b.k.b(r3, r4)
            goto L_0x0301
        L_0x02fb:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r6)
            throw r0
        L_0x0301:
            java.lang.String r4 = "CURRENT_MERCHANT_ALL_ROLES"
            r0.a((android.content.Context) r2, (java.lang.String) r4, (java.lang.String) r3)
            java.util.ArrayList r0 = r1.getRoles()
            java.lang.String r2 = "merchants.roles"
            kotlin.g.b.k.b(r0, r2)
            java.util.ArrayList r0 = b((java.util.ArrayList<com.business.common_module.e.c>) r0)
            a((java.util.ArrayList<java.lang.String>) r0)
            net.one97.paytm.acceptPayment.e.a.a r0 = net.one97.paytm.acceptPayment.e.a.a.f52055a
            android.content.Context r2 = f52054c
            boolean r3 = r1.getAggregator()
            java.lang.String r4 = "is_aggregator"
            r0.a((android.content.Context) r2, (java.lang.String) r4, (boolean) r3)
            net.one97.paytm.acceptPayment.e.a.a r0 = net.one97.paytm.acceptPayment.e.a.a.f52055a
            android.content.Context r2 = f52054c
            boolean r1 = r1.isBetaAccess()
            java.lang.String r3 = "is_beta_access"
            r0.a((android.content.Context) r2, (java.lang.String) r3, (boolean) r1)
        L_0x0330:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.acceptPayment.d.b.e():void");
    }

    private static ArrayList<String> b(ArrayList<c> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<c> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            c next = it2.next();
            k.b(next, StringSet.role);
            arrayList2.addAll(next.getPermissions());
        }
        return arrayList2;
    }

    static void b() {
        a.f52055a.a(f52054c, "key_user_id", (String) null);
        a.f52055a.a(f52054c, "user_pic_url", (String) null);
        a.f52055a.a(f52054c, "user_token", (String) null);
        a.f52055a.a(f52054c, "key_merchant_info", (String) null);
        a.f52055a.a(f52054c, "key_merchant_info_exists", false);
    }

    public static void a(com.business.common_module.e.b bVar) {
        k.d(bVar, "merchant");
        c();
        a();
        b(bVar);
    }

    static void c() {
        a.f52055a.a(f52054c, "merchant_id", (String) null);
        a.f52055a.a(f52054c, "key_merchant_first_name", (String) null);
        a.f52055a.a(f52054c, "key_merchant_lastname", (String) null);
        a.f52055a.a(f52054c, "key_merchant_email", (String) null);
        a.f52055a.a(f52054c, "key_merchant_name", (String) null);
        a.f52055a.a(f52054c, "key_merchant_type", (String) null);
        a.f52055a.a(f52054c, "key_merchant_role", (String) null);
        a.f52055a.a(f52054c, "key_merchant_kybid", (String) null);
    }
}
