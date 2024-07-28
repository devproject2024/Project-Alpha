package net.one97.paytm.moneytransfer.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.database.a;

public final class j {
    public static void a(Context context, ArrayList<BeneficiaryEntity> arrayList) {
        Iterator<BeneficiaryEntity> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            BeneficiaryEntity next = it2.next();
            if (!b(context, next)) {
                a(context, next);
            }
        }
    }

    public static void a(Cursor cursor) {
        try {
            if ((true ^ cursor.isClosed()) && (cursor != null)) {
                cursor.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void a(Context context, BeneficiaryEntity beneficiaryEntity) {
        SQLiteDatabase sQLiteDatabase;
        a a2 = a.a(context);
        if (!a2.b()) {
            sQLiteDatabase = a2.a();
        } else {
            sQLiteDatabase = a2.f66667a;
        }
        sQLiteDatabase.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            if (beneficiaryEntity.instrumentPreferences.otherBank != null) {
                BeneficiaryEntity.OtherBank otherBank = beneficiaryEntity.instrumentPreferences.otherBank;
                contentValues.put("beneficiary_type", CJRPGTransactionRequestUtils.PAYER_BANK_NAME);
                contentValues.put("beneficiary_value", otherBank.accounts.get(0).accountDetail.accountNumber);
                contentValues.put(PayUtility.BANK_NAME, otherBank.accounts.get(0).accountDetail.bankName);
                contentValues.put("ifsc", otherBank.accounts.get(0).accountDetail.ifscCode);
                contentValues.put("beneficiary_name", otherBank.accounts.get(0).accountDetail.accountHolderName);
                contentValues.put("beneficiary_uuid", otherBank.accounts.get(0).uuid);
                contentValues.put("timestamp", String.valueOf(m.j(otherBank.accounts.get(0).creationTime)));
            } else if (beneficiaryEntity.instrumentPreferences.upi != null) {
                BeneficiaryEntity.UPI upi = beneficiaryEntity.instrumentPreferences.upi;
                contentValues.put("beneficiary_type", "vpa");
                contentValues.put("beneficiary_uuid", upi.accounts.get(0).uuid);
                contentValues.put("beneficiary_name", upi.accounts.get(0).accountDetail.accountHolderName);
                contentValues.put("beneficiary_value", upi.accounts.get(0).accountDetail.vpa);
                contentValues.put("timestamp", String.valueOf(m.j(upi.accounts.get(0).creationTime)));
            }
            contentValues.put("beneficiary_id", beneficiaryEntity.beneficiaryId);
            sQLiteDatabase.insert("mt_saved_beneficiaries", (String) null, contentValues);
        } catch (IllegalStateException unused) {
            if (!sQLiteDatabase.isOpen()) {
                sQLiteDatabase = a2.a();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            sQLiteDatabase.close();
            throw th;
        }
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.endTransaction();
        sQLiteDatabase.close();
    }

    public static ArrayList<BeneficiaryEntity> a(Context context) {
        SQLiteDatabase sQLiteDatabase;
        a a2 = a.a(context);
        if (!a2.b()) {
            sQLiteDatabase = a2.a();
        } else {
            sQLiteDatabase = a2.f66667a;
        }
        ArrayList<BeneficiaryEntity> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT * FROM mt_saved_beneficiaries ORDER BY timestamp DESC ", (String[]) null);
            if (cursor != null && cursor.moveToFirst()) {
                for (int i2 = 0; i2 < cursor.getCount(); i2++) {
                    cursor.moveToPosition(i2);
                    BeneficiaryEntity beneficiaryEntity = new BeneficiaryEntity();
                    BeneficiaryEntity.InstrumentPreferences instrumentPreferences = new BeneficiaryEntity.InstrumentPreferences();
                    String string = cursor.getString(cursor.getColumnIndex("beneficiary_type"));
                    beneficiaryEntity.beneficiaryId = cursor.getString(cursor.getColumnIndex("beneficiary_id"));
                    if (string.equalsIgnoreCase("vpa")) {
                        BeneficiaryEntity.UPI upi = new BeneficiaryEntity.UPI();
                        BeneficiaryEntity.UPIAccount uPIAccount = new BeneficiaryEntity.UPIAccount();
                        BeneficiaryEntity.UPIAccountDetail uPIAccountDetail = new BeneficiaryEntity.UPIAccountDetail();
                        uPIAccount.uuid = cursor.getString(cursor.getColumnIndex("beneficiary_uuid"));
                        uPIAccountDetail.accountHolderName = cursor.getString(cursor.getColumnIndex("beneficiary_name"));
                        uPIAccountDetail.vpa = cursor.getString(cursor.getColumnIndex("beneficiary_value"));
                        uPIAccount.accountDetail = uPIAccountDetail;
                        ArrayList<BeneficiaryEntity.UPIAccount> arrayList2 = new ArrayList<>();
                        arrayList2.add(uPIAccount);
                        upi.accounts = arrayList2;
                        instrumentPreferences.upi = upi;
                    } else if (string.equalsIgnoreCase(CJRPGTransactionRequestUtils.PAYER_BANK_NAME)) {
                        BeneficiaryEntity.OtherBank otherBank = new BeneficiaryEntity.OtherBank();
                        BeneficiaryEntity.OtherBankAccount otherBankAccount = new BeneficiaryEntity.OtherBankAccount();
                        BeneficiaryEntity.OtherBankAccountDetail otherBankAccountDetail = new BeneficiaryEntity.OtherBankAccountDetail();
                        otherBankAccount.uuid = cursor.getString(cursor.getColumnIndex("beneficiary_uuid"));
                        otherBankAccountDetail.accountHolderName = cursor.getString(cursor.getColumnIndex("beneficiary_name"));
                        otherBankAccountDetail.accountNumber = cursor.getString(cursor.getColumnIndex("beneficiary_value"));
                        otherBankAccountDetail.bankName = cursor.getString(cursor.getColumnIndex(PayUtility.BANK_NAME));
                        otherBankAccountDetail.ifscCode = cursor.getString(cursor.getColumnIndex("ifsc"));
                        otherBankAccount.accountDetail = otherBankAccountDetail;
                        ArrayList<BeneficiaryEntity.OtherBankAccount> arrayList3 = new ArrayList<>();
                        arrayList3.add(otherBankAccount);
                        otherBank.accounts = arrayList3;
                        instrumentPreferences.otherBank = otherBank;
                    }
                    beneficiaryEntity.instrumentPreferences = instrumentPreferences;
                    arrayList.add(beneficiaryEntity);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            a(cursor);
            sQLiteDatabase.close();
            throw th;
        }
        a(cursor);
        sQLiteDatabase.close();
        return arrayList;
    }

    private static boolean b(Context context, BeneficiaryEntity beneficiaryEntity) {
        SQLiteDatabase sQLiteDatabase;
        String str;
        a a2 = a.a(context);
        if (!a2.b()) {
            sQLiteDatabase = a2.a();
        } else {
            sQLiteDatabase = a2.f66667a;
        }
        boolean z = false;
        if (beneficiaryEntity.instrumentPreferences.otherBank != null) {
            str = beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail.accountNumber;
        } else {
            str = beneficiaryEntity.instrumentPreferences.upi != null ? beneficiaryEntity.instrumentPreferences.upi.accounts.get(0).accountDetail.vpa : "";
        }
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT * FROM mt_saved_beneficiaries WHERE beneficiary_value = '" + str + "'", (String[]) null);
            if (cursor.getCount() > 0) {
                z = true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            a((Cursor) null);
            sQLiteDatabase.close();
            throw th;
        }
        a(cursor);
        sQLiteDatabase.close();
        return z;
    }
}
