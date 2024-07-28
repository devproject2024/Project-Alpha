package net.one97.paytm.managebeneficiary;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.t;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.managebeneficiary.ManageWalletBeneficiaryActivity;

public final class i extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    Context f53308a;

    /* renamed from: b  reason: collision with root package name */
    Activity f53309b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<BeneficiaryEntity> f53310c;

    /* renamed from: d  reason: collision with root package name */
    ManageWalletBeneficiaryActivity.b f53311d;

    /* renamed from: e  reason: collision with root package name */
    int f53312e = -1;

    /* renamed from: f  reason: collision with root package name */
    private ManageWalletBeneficiaryActivity.a f53313f;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        a aVar = (a) vVar;
        if (this.f53310c.get(i2).instrumentPreferences.otherBank != null) {
            aVar.f53328d.setVisibility(0);
            BeneficiaryEntity.OtherBankAccountDetail otherBankAccountDetail = this.f53310c.get(i2).instrumentPreferences.otherBank.accounts.get(0).accountDetail;
            String str = otherBankAccountDetail.accountHolderName;
            String str2 = otherBankAccountDetail.accountNumber;
            String str3 = otherBankAccountDetail.ifscCode;
            aVar.f53327c.setText(str);
            TextView textView = aVar.f53329e;
            textView.setText(this.f53308a.getString(R.string.pb_mb_accnt_no) + ": " + str2);
            TextView textView2 = aVar.f53328d;
            textView2.setText(this.f53308a.getString(R.string.pb_mb_ifsc_code) + ": " + str3);
            this.f53313f.a(aVar.f53326b, str3);
        } else {
            String str4 = "";
            if (this.f53310c.get(i2).instrumentPreferences.wallet != null) {
                aVar.f53328d.setVisibility(8);
                aVar.f53326b.setImageResource(R.drawable.pb_mb_paytm_wallet);
                BeneficiaryEntity.Wallet wallet = this.f53310c.get(i2).instrumentPreferences.wallet;
                String str5 = !TextUtils.isEmpty(wallet.accounts.get(0).accountDetail.beneficiaryPhone) ? wallet.accounts.get(0).accountDetail.beneficiaryPhone : str4;
                if (!TextUtils.isEmpty(wallet.accounts.get(0).accountDetail.beneficiaryName)) {
                    str4 = wallet.accounts.get(0).accountDetail.beneficiaryName;
                }
                aVar.f53327c.setText(str4);
                aVar.f53329e.setText(str5);
            } else if (this.f53310c.get(i2).instrumentPreferences.upi != null) {
                aVar.f53328d.setVisibility(8);
                aVar.f53326b.setImageResource(R.drawable.pb_mb_ic_bhim);
                BeneficiaryEntity.UPI upi = this.f53310c.get(i2).instrumentPreferences.upi;
                String str6 = !TextUtils.isEmpty(upi.accounts.get(0).accountDetail.vpa) ? upi.accounts.get(0).accountDetail.vpa : str4;
                if (!TextUtils.isEmpty(upi.accounts.get(0).accountDetail.accountHolderName)) {
                    str4 = upi.accounts.get(0).accountDetail.accountHolderName;
                }
                aVar.f53327c.setText(str4);
                TextView textView3 = aVar.f53329e;
                textView3.setText(this.f53308a.getString(R.string.pb_mb_money_transfer_upi_string) + " " + str6);
            }
        }
        aVar.f53325a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                i iVar = i.this;
                int i2 = i2;
                t tVar = new t(iVar.f53308a, view);
                tVar.b().inflate(R.menu.popup_menu_wallet_beneficiary, tVar.f1796a);
                tVar.f1797b.a();
                tVar.f1796a.findItem(R.id.wallet_item_pay).setVisible(false);
                tVar.f1796a.findItem(R.id.wallet_item_edit).setVisible(false);
                if (iVar.f53310c.get(i2).instrumentPreferences.otherBank != null) {
                    tVar.f1796a.findItem(R.id.wallet_item_money_transfer).setVisible(true);
                } else {
                    tVar.f1796a.findItem(R.id.wallet_item_money_transfer).setVisible(false);
                }
                if (iVar.f53310c.get(i2).instrumentPreferences.upi != null) {
                    tVar.f1796a.findItem(R.id.wallet_item_money_transfer).setVisible(true);
                    tVar.f1796a.findItem(R.id.wallet_item_edit).setVisible(false);
                }
                if (f.a().showDeleteBeneficiaryButton()) {
                    tVar.f1796a.findItem(R.id.wallet_item_delete).setVisible(true);
                } else {
                    tVar.f1796a.findItem(R.id.wallet_item_delete).setVisible(false);
                }
                tVar.f1798c = new t.b(i2, tVar) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ int f53316a;

                    /* renamed from: b  reason: collision with root package name */
                    final /* synthetic */ t f53317b;

                    {
                        this.f53316a = r2;
                        this.f53317b = r3;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        e.a(i.this.f53308a, "beneficiary_wallet", "option_tab_clicked", "/beneficiary/wallet/manage");
                        int itemId = menuItem.getItemId();
                        if (itemId != R.id.wallet_item_pay) {
                            if (itemId == R.id.wallet_item_money_transfer) {
                                if (i.this.f53310c.get(this.f53316a).instrumentPreferences.otherBank != null) {
                                    BeneficiaryEntity.OtherBankAccountDetail otherBankAccountDetail = i.this.f53310c.get(this.f53316a).instrumentPreferences.otherBank.accounts.get(0).accountDetail;
                                    String str = otherBankAccountDetail.accountHolderName;
                                    String str2 = otherBankAccountDetail.accountNumber;
                                    String str3 = otherBankAccountDetail.ifscCode;
                                    String str4 = otherBankAccountDetail.bankName;
                                    String str5 = i.a() + "&account=" + str2 + "&pn=" + str + "&ifsc=" + str3;
                                    if (!TextUtils.isEmpty(str4)) {
                                        str5 = str5 + "&bank_name=" + str4;
                                    }
                                    f.a().checkDeepLinking(i.this.f53308a, str5);
                                } else if (i.this.f53310c.get(this.f53316a).instrumentPreferences.upi != null) {
                                    BeneficiaryEntity.UPI upi = i.this.f53310c.get(this.f53316a).instrumentPreferences.upi;
                                    String str6 = upi.accounts.get(0).accountDetail.accountHolderName;
                                    f.a().checkDeepLinking(i.this.f53308a, i.a() + "&pa=" + upi.accounts.get(0).accountDetail.vpa + "&pn=" + str6);
                                }
                            } else if (itemId == R.id.wallet_item_edit) {
                                e.a(i.this.f53308a, "beneficiary_wallet", "edit", "/beneficiary/wallet/manage");
                                i iVar = i.this;
                                int i2 = this.f53316a;
                                Intent intent = new Intent(iVar.f53308a, EditBeneficiaryV2Activity.class);
                                intent.putExtra("kyc_beneficiary", iVar.f53310c.get(i2));
                                ((Activity) iVar.f53308a).startActivityForResult(intent, 2012);
                            } else if (itemId == R.id.wallet_item_delete) {
                                i iVar2 = i.this;
                                iVar2.f53312e = this.f53316a;
                                e.a(iVar2.f53308a, "beneficiary_wallet", "delete", "/beneficiary/wallet/manage");
                                i iVar3 = i.this;
                                AlertDialog.Builder builder = new AlertDialog.Builder(iVar3.f53308a);
                                View inflate = ((Activity) iVar3.f53308a).getLayoutInflater().inflate(R.layout.layout_delete_beneficiary, (ViewGroup) null);
                                builder.setCancelable(true);
                                builder.setInverseBackgroundForced(true);
                                builder.setCancelable(false);
                                builder.setView(inflate);
                                AlertDialog show = builder.show();
                                ((TextView) inflate.findViewById(R.id.confirm_delete_benef)).setOnClickListener(new View.OnClickListener(show) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ AlertDialog f53319a;

                                    {
                                        this.f53319a = r2;
                                    }

                                    /* JADX WARNING: Removed duplicated region for block: B:13:0x009e  */
                                    /* JADX WARNING: Removed duplicated region for block: B:35:0x0196  */
                                    /* JADX WARNING: Removed duplicated region for block: B:36:0x019a  */
                                    /* JADX WARNING: Removed duplicated region for block: B:37:0x019e  */
                                    /* Code decompiled incorrectly, please refer to instructions dump. */
                                    public final void onClick(android.view.View r18) {
                                        /*
                                            r17 = this;
                                            r1 = r17
                                            net.one97.paytm.managebeneficiary.i r0 = net.one97.paytm.managebeneficiary.i.this
                                            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity> r2 = r0.f53310c
                                            int r3 = r0.f53312e
                                            java.lang.Object r2 = r2.get(r3)
                                            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity r2 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity) r2
                                            java.lang.String r6 = r2.beneficiaryId
                                            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity> r2 = r0.f53310c
                                            int r3 = r0.f53312e
                                            java.lang.Object r2 = r2.get(r3)
                                            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity r2 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity) r2
                                            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r2 = r2.instrumentPreferences
                                            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$Wallet r2 = r2.wallet
                                            r3 = 1
                                            r4 = 0
                                            if (r2 == 0) goto L_0x003c
                                            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity> r2 = r0.f53310c
                                            int r5 = r0.f53312e
                                            java.lang.Object r2 = r2.get(r5)
                                            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity r2 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity) r2
                                            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r2 = r2.instrumentPreferences
                                            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$Wallet r2 = r2.wallet
                                            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$WalletAccount> r2 = r2.accounts
                                            java.lang.Object r2 = r2.get(r4)
                                            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$WalletAccount r2 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.WalletAccount) r2
                                            java.lang.String r2 = r2.uuid
                                        L_0x003a:
                                            r5 = r2
                                            goto L_0x0096
                                        L_0x003c:
                                            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity> r2 = r0.f53310c
                                            int r5 = r0.f53312e
                                            java.lang.Object r2 = r2.get(r5)
                                            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity r2 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity) r2
                                            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r2 = r2.instrumentPreferences
                                            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBank r2 = r2.otherBank
                                            if (r2 == 0) goto L_0x0067
                                            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity> r2 = r0.f53310c
                                            int r3 = r0.f53312e
                                            java.lang.Object r2 = r2.get(r3)
                                            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity r2 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity) r2
                                            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r2 = r2.instrumentPreferences
                                            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBank r2 = r2.otherBank
                                            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount> r2 = r2.accounts
                                            java.lang.Object r2 = r2.get(r4)
                                            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$OtherBankAccount r2 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.OtherBankAccount) r2
                                            java.lang.String r2 = r2.uuid
                                            r5 = r2
                                            r3 = 0
                                            goto L_0x0096
                                        L_0x0067:
                                            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity> r2 = r0.f53310c
                                            int r5 = r0.f53312e
                                            java.lang.Object r2 = r2.get(r5)
                                            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity r2 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity) r2
                                            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r2 = r2.instrumentPreferences
                                            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPI r2 = r2.upi
                                            if (r2 == 0) goto L_0x0093
                                            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity> r2 = r0.f53310c
                                            int r5 = r0.f53312e
                                            java.lang.Object r2 = r2.get(r5)
                                            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity r2 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity) r2
                                            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$InstrumentPreferences r2 = r2.instrumentPreferences
                                            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPI r2 = r2.upi
                                            java.util.ArrayList<net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount> r2 = r2.accounts
                                            java.lang.Object r2 = r2.get(r4)
                                            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity$UPIAccount r2 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity.UPIAccount) r2
                                            java.lang.String r2 = r2.uuid
                                            r5 = r2
                                            r3 = 0
                                            r4 = 1
                                            goto L_0x0096
                                        L_0x0093:
                                            java.lang.String r2 = ""
                                            goto L_0x003a
                                        L_0x0096:
                                            android.content.Context r2 = r0.f53308a
                                            boolean r2 = com.paytm.utility.b.c((android.content.Context) r2)
                                            if (r2 == 0) goto L_0x019e
                                            android.content.Context r2 = r0.f53308a
                                            android.content.Context r7 = r0.f53308a
                                            android.content.res.Resources r7 = r7.getResources()
                                            int r8 = net.one97.paytm.managebeneficiary.R.string.pb_mb_please_wait
                                            java.lang.String r7 = r7.getString(r8)
                                            com.paytm.utility.b.k(r2, r7)
                                            android.content.Context r2 = r0.f53308a
                                            net.one97.paytm.managebeneficiary.i$5 r7 = new net.one97.paytm.managebeneficiary.i$5
                                            r7.<init>()
                                            net.one97.paytm.managebeneficiary.i$6 r8 = new net.one97.paytm.managebeneficiary.i$6
                                            r8.<init>()
                                            if (r2 == 0) goto L_0x01a1
                                            net.one97.paytm.managebeneficiary.g r0 = net.one97.paytm.managebeneficiary.f.a()
                                            java.lang.String r0 = r0.deleteBeneficiaryURL(r2)
                                            boolean r9 = android.webkit.URLUtil.isValidUrl(r0)
                                            if (r9 == 0) goto L_0x01a1
                                            java.lang.String r9 = com.paytm.utility.b.e((android.content.Context) r2, (java.lang.String) r0)
                                            java.util.HashMap r11 = new java.util.HashMap
                                            r11.<init>()
                                            net.one97.paytm.managebeneficiary.g r0 = net.one97.paytm.managebeneficiary.f.a()
                                            java.lang.String r0 = r0.getSSOToken(r2)
                                            java.lang.String r10 = "session_token"
                                            r11.put(r10, r0)
                                            java.lang.String r0 = "Content-Type"
                                            java.lang.String r10 = "application/json"
                                            r11.put(r0, r10)
                                            org.json.JSONArray r10 = new org.json.JSONArray
                                            r10.<init>()
                                            org.json.JSONObject r0 = new org.json.JSONObject
                                            r0.<init>()
                                            org.json.JSONObject r12 = new org.json.JSONObject
                                            r12.<init>()
                                            org.json.JSONObject r13 = new org.json.JSONObject
                                            r13.<init>()
                                            org.json.JSONArray r14 = new org.json.JSONArray
                                            r14.<init>()
                                            org.json.JSONObject r15 = new org.json.JSONObject
                                            r15.<init>()
                                            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0156 }
                                            r1.<init>()     // Catch:{ Exception -> 0x0156 }
                                            r18 = r11
                                            java.lang.String r11 = "status"
                                            r16 = r9
                                            java.lang.String r9 = "deleted"
                                            r1.put(r11, r9)     // Catch:{ Exception -> 0x0150 }
                                            java.lang.String r9 = "settings"
                                            r15.put(r9, r1)     // Catch:{ Exception -> 0x0150 }
                                            java.lang.String r1 = "uuid"
                                            r15.put(r1, r5)     // Catch:{ Exception -> 0x0150 }
                                            r14.put(r15)     // Catch:{ Exception -> 0x0150 }
                                            java.lang.String r1 = "accounts"
                                            r13.put(r1, r14)     // Catch:{ Exception -> 0x0150 }
                                            if (r3 == 0) goto L_0x0134
                                            java.lang.String r1 = "wallet"
                                            r12.put(r1, r13)     // Catch:{ Exception -> 0x0150 }
                                            goto L_0x0142
                                        L_0x0134:
                                            if (r4 != 0) goto L_0x013c
                                            java.lang.String r1 = "otherBank"
                                            r12.put(r1, r13)     // Catch:{ Exception -> 0x0150 }
                                            goto L_0x0142
                                        L_0x013c:
                                            java.lang.String r1 = "upi"
                                            r12.put(r1, r13)     // Catch:{ Exception -> 0x0150 }
                                        L_0x0142:
                                            java.lang.String r1 = "instrumentPreferences"
                                            r0.put(r1, r12)     // Catch:{ Exception -> 0x0150 }
                                            java.lang.String r1 = "beneficiaryId"
                                            r0.put(r1, r6)     // Catch:{ Exception -> 0x0150 }
                                            r10.put(r0)     // Catch:{ Exception -> 0x0150 }
                                            goto L_0x016e
                                        L_0x0150:
                                            r0 = move-exception
                                            goto L_0x015b
                                        L_0x0152:
                                            r0 = move-exception
                                            r16 = r9
                                            goto L_0x015b
                                        L_0x0156:
                                            r0 = move-exception
                                            r16 = r9
                                            r18 = r11
                                        L_0x015b:
                                            java.lang.StringBuilder r1 = new java.lang.StringBuilder
                                            r1.<init>()
                                            java.lang.String r0 = r0.getMessage()
                                            r1.append(r0)
                                            java.lang.String r0 = r1.toString()
                                            com.paytm.utility.q.b(r0)
                                        L_0x016e:
                                            net.one97.paytm.managebeneficiary.h$5 r0 = new net.one97.paytm.managebeneficiary.h$5
                                            r3 = r0
                                            r4 = r2
                                            r3.<init>(r4, r5, r6, r7, r8)
                                            com.paytm.network.a$a r12 = com.paytm.network.a.C0715a.POST
                                            java.lang.String r13 = r10.toString()
                                            net.one97.paytm.common.entity.beneficiaryModels.CJRAddBeneficiary r14 = new net.one97.paytm.common.entity.beneficiaryModels.CJRAddBeneficiary
                                            r14.<init>()
                                            com.paytm.network.a$c r15 = com.paytm.network.a.c.PAYMENTS
                                            com.paytm.network.a$b r1 = com.paytm.network.a.b.SILENT
                                            r8 = r2
                                            r9 = r16
                                            r10 = r0
                                            r11 = r18
                                            r16 = r1
                                            com.paytm.network.a r0 = net.one97.paytm.managebeneficiary.f.a(r8, r9, r10, r11, r12, r13, r14, r15, r16)
                                            boolean r1 = com.paytm.utility.b.c((android.content.Context) r2)
                                            if (r1 == 0) goto L_0x019a
                                            r0.a()
                                            goto L_0x01a1
                                        L_0x019a:
                                            net.one97.paytm.managebeneficiary.b.a.a(r0, r2)
                                            goto L_0x01a1
                                        L_0x019e:
                                            com.paytm.utility.b.p()
                                        L_0x01a1:
                                            r1 = r17
                                            android.app.AlertDialog r0 = r1.f53319a
                                            r0.dismiss()
                                            return
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.managebeneficiary.i.AnonymousClass3.onClick(android.view.View):void");
                                    }
                                });
                                ((TextView) inflate.findViewById(R.id.cancel_delete_benef)).setOnClickListener(new View.OnClickListener(show) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ AlertDialog f53321a;

                                    {
                                        this.f53321a = r2;
                                    }

                                    public final void onClick(View view) {
                                        this.f53321a.dismiss();
                                    }
                                });
                            }
                        }
                        this.f53317b.f1797b.d();
                        return true;
                    }
                };
            }
        });
    }

    public i(Context context, ArrayList<BeneficiaryEntity> arrayList, ManageWalletBeneficiaryActivity.a aVar, ManageWalletBeneficiaryActivity.b bVar) {
        this.f53308a = context;
        this.f53309b = (Activity) context;
        this.f53310c = arrayList;
        this.f53313f = aVar;
        this.f53311d = bVar;
    }

    public final int getItemCount() {
        ArrayList<BeneficiaryEntity> arrayList = this.f53310c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f53325a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f53326b;

        /* renamed from: c  reason: collision with root package name */
        TextView f53327c;

        /* renamed from: d  reason: collision with root package name */
        TextView f53328d;

        /* renamed from: e  reason: collision with root package name */
        TextView f53329e;

        public a(View view) {
            super(view);
            this.f53326b = (ImageView) view.findViewById(R.id.wallet_benef_image);
            this.f53325a = (ImageView) view.findViewById(R.id.wallet_benef_more);
            this.f53327c = (TextView) view.findViewById(R.id.wallet_benef_name);
            this.f53329e = (TextView) view.findViewById(R.id.wallet_benef_number);
            this.f53328d = (TextView) view.findViewById(R.id.wallet_benef_ifsc);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_beneficiary_list_item, viewGroup, false));
    }

    static /* synthetic */ String a() {
        return f.a().deeplinkSchemaName() + "cash_wallet?featuretype=money_transfer";
    }
}
