package net.one97.paytm.upi.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;
import net.one97.paytm.upi.database.a;

public class UpiDBManager {
    private static a getPaytmDBManager(Context context) {
        return a.a(context);
    }

    public void addOrUpdate(Context context, UpiDBTransactionModel upiDBTransactionModel) {
        if (!isRecordExists(context, upiDBTransactionModel)) {
            if (getRecentTransactions(context, upiDBTransactionModel.getTxn_type()).size() < 10) {
                addRow(context, upiDBTransactionModel);
            } else {
                deleteRow(context, upiDBTransactionModel);
            }
        }
    }

    private boolean isRecordExists(Context context, UpiDBTransactionModel upiDBTransactionModel) {
        SQLiteDatabase sQLiteDatabase;
        a paytmDBManager = getPaytmDBManager(context);
        if (!paytmDBManager.b()) {
            sQLiteDatabase = paytmDBManager.a();
        } else {
            sQLiteDatabase = paytmDBManager.f66667a;
        }
        Cursor cursor = null;
        boolean z = false;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT * FROM upi_recent_txns WHERE txn_mode = '" + upiDBTransactionModel.getTxn_mode() + "' AND txn_type = '" + upiDBTransactionModel.getTxn_type() + "'", (String[]) null);
            if (cursor.getCount() > 0) {
                z = true;
            }
            if (z && cursor.moveToFirst()) {
                do {
                    if (cursor.getString(cursor.getColumnIndex("txn_type")).equalsIgnoreCase(upiDBTransactionModel.getTxn_type())) {
                        updateRecord(context, cursor.getInt(cursor.getColumnIndex("id")), upiDBTransactionModel);
                    }
                } while (cursor.moveToNext());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            closeCursor((Cursor) null);
            sQLiteDatabase.close();
            throw th;
        }
        closeCursor(cursor);
        sQLiteDatabase.close();
        return z;
    }

    private void updateRecord(Context context, int i2, UpiDBTransactionModel upiDBTransactionModel) {
        SQLiteDatabase sQLiteDatabase;
        a paytmDBManager = getPaytmDBManager(context);
        if (!paytmDBManager.b()) {
            sQLiteDatabase = paytmDBManager.a();
        } else {
            sQLiteDatabase = paytmDBManager.f66667a;
        }
        sQLiteDatabase.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("txn_type", upiDBTransactionModel.getTxn_type());
            contentValues.put("txn_mode", upiDBTransactionModel.getTxn_mode());
            contentValues.put(PayUtility.BANK_NAME, upiDBTransactionModel.getBank_name());
            contentValues.put("ifsc", upiDBTransactionModel.getIfsc());
            contentValues.put("beneficiary_name", upiDBTransactionModel.getBeneficiary_name());
            contentValues.put("timestamp", upiDBTransactionModel.getTimestamp());
            contentValues.put("txn_amount", upiDBTransactionModel.getTxn_amount());
            sQLiteDatabase.update("upi_recent_txns", contentValues, "id = ".concat(String.valueOf(i2)), (String[]) null);
        } catch (IllegalStateException unused) {
            if (!sQLiteDatabase.isOpen()) {
                sQLiteDatabase = paytmDBManager.a();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.endTransaction();
    }

    private void addRow(Context context, UpiDBTransactionModel upiDBTransactionModel) {
        SQLiteDatabase sQLiteDatabase;
        a paytmDBManager = getPaytmDBManager(context);
        if (!paytmDBManager.b()) {
            sQLiteDatabase = paytmDBManager.a();
        } else {
            sQLiteDatabase = paytmDBManager.f66667a;
        }
        sQLiteDatabase.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("txn_type", upiDBTransactionModel.getTxn_type());
            contentValues.put("txn_mode", upiDBTransactionModel.getTxn_mode());
            contentValues.put(PayUtility.BANK_NAME, upiDBTransactionModel.getBank_name());
            contentValues.put("ifsc", upiDBTransactionModel.getIfsc());
            contentValues.put("beneficiary_name", upiDBTransactionModel.getBeneficiary_name());
            contentValues.put("timestamp", upiDBTransactionModel.getTimestamp());
            contentValues.put("txn_amount", upiDBTransactionModel.getTxn_amount());
            sQLiteDatabase.insert("upi_recent_txns", (String) null, contentValues);
        } catch (IllegalStateException unused) {
            if (!sQLiteDatabase.isOpen()) {
                sQLiteDatabase = paytmDBManager.a();
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

    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x007e */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0084 A[Catch:{ all -> 0x0072 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void deleteMultipleRows(android.content.Context r8, java.util.ArrayList<net.one97.paytm.upi.common.upi.UpiDBTransactionModel> r9) {
        /*
            r7 = this;
            net.one97.paytm.upi.database.a r8 = getPaytmDBManager(r8)
            boolean r0 = r8.b()
            if (r0 != 0) goto L_0x000f
            android.database.sqlite.SQLiteDatabase r0 = r8.a()
            goto L_0x0011
        L_0x000f:
            android.database.sqlite.SQLiteDatabase r0 = r8.f66667a
        L_0x0011:
            java.util.Iterator r9 = r9.iterator()
        L_0x0015:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L_0x0099
            java.lang.Object r1 = r9.next()
            net.one97.paytm.upi.common.upi.UpiDBTransactionModel r1 = (net.one97.paytm.upi.common.upi.UpiDBTransactionModel) r1
            r0.beginTransaction()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "SELECT * FROM upi_recent_txns WHERE txn_mode = '"
            r2.<init>(r3)
            java.lang.String r3 = r1.getTxn_mode()
            r2.append(r3)
            java.lang.String r3 = "' AND txn_type = '"
            r2.append(r3)
            java.lang.String r1 = r1.getTxn_type()
            r2.append(r1)
            java.lang.String r1 = "'"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r2 = 0
            android.database.Cursor r1 = r0.rawQuery(r1, r2)     // Catch:{ IllegalStateException -> 0x007e, Exception -> 0x0075 }
            boolean r3 = r1.moveToFirst()     // Catch:{ IllegalStateException -> 0x0070, Exception -> 0x006e }
            if (r3 == 0) goto L_0x007c
            java.lang.String r3 = "id"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ IllegalStateException -> 0x0070, Exception -> 0x006e }
            int r3 = r1.getInt(r3)     // Catch:{ IllegalStateException -> 0x0070, Exception -> 0x006e }
            java.lang.String r4 = "upi_recent_txns"
            java.lang.String r5 = "id = "
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ IllegalStateException -> 0x0070, Exception -> 0x006e }
            java.lang.String r3 = r5.concat(r3)     // Catch:{ IllegalStateException -> 0x0070, Exception -> 0x006e }
            r0.delete(r4, r3, r2)     // Catch:{ IllegalStateException -> 0x0070, Exception -> 0x006e }
            goto L_0x007c
        L_0x006c:
            r8 = move-exception
            goto L_0x0092
        L_0x006e:
            r2 = move-exception
            goto L_0x0079
        L_0x0070:
            r2 = r1
            goto L_0x007e
        L_0x0072:
            r8 = move-exception
            r1 = r2
            goto L_0x0092
        L_0x0075:
            r1 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
        L_0x0079:
            r2.printStackTrace()     // Catch:{ all -> 0x006c }
        L_0x007c:
            r2 = r1
            goto L_0x0088
        L_0x007e:
            boolean r1 = r0.isOpen()     // Catch:{ all -> 0x0072 }
            if (r1 != 0) goto L_0x0088
            android.database.sqlite.SQLiteDatabase r0 = r8.a()     // Catch:{ all -> 0x0072 }
        L_0x0088:
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x0072 }
            r0.endTransaction()
            r7.closeCursor(r2)
            goto L_0x0015
        L_0x0092:
            r0.endTransaction()
            r7.closeCursor(r1)
            throw r8
        L_0x0099:
            r0.close()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.util.UpiDBManager.deleteMultipleRows(android.content.Context, java.util.ArrayList):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0069 A[Catch:{ all -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void deleteRow(android.content.Context r9, net.one97.paytm.upi.common.upi.UpiDBTransactionModel r10) {
        /*
            r8 = this;
            net.one97.paytm.upi.database.a r0 = getPaytmDBManager(r9)
            boolean r1 = r0.b()
            if (r1 != 0) goto L_0x000f
            android.database.sqlite.SQLiteDatabase r1 = r0.a()
            goto L_0x0011
        L_0x000f:
            android.database.sqlite.SQLiteDatabase r1 = r0.f66667a
        L_0x0011:
            r1.beginTransaction()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "SELECT * FROM upi_recent_txns WHERE txn_type = '"
            r2.<init>(r3)
            java.lang.String r3 = r10.getTxn_type()
            r2.append(r3)
            java.lang.String r3 = "' ORDER BY timestamp ASC"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r3 = 0
            r4 = 0
            android.database.Cursor r2 = r1.rawQuery(r2, r4)     // Catch:{ IllegalStateException -> 0x0063, Exception -> 0x005e }
            boolean r5 = r2.moveToFirst()     // Catch:{ IllegalStateException -> 0x0059, Exception -> 0x0056, all -> 0x0054 }
            if (r5 == 0) goto L_0x0052
            java.lang.String r5 = "id"
            int r5 = r2.getColumnIndex(r5)     // Catch:{ IllegalStateException -> 0x0059, Exception -> 0x0056, all -> 0x0054 }
            int r5 = r2.getInt(r5)     // Catch:{ IllegalStateException -> 0x0059, Exception -> 0x0056, all -> 0x0054 }
            java.lang.String r6 = "upi_recent_txns"
            java.lang.String r7 = "id = "
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ IllegalStateException -> 0x0059, Exception -> 0x0056, all -> 0x0054 }
            java.lang.String r5 = r7.concat(r5)     // Catch:{ IllegalStateException -> 0x0059, Exception -> 0x0056, all -> 0x0054 }
            int r0 = r1.delete(r6, r5, r4)     // Catch:{ IllegalStateException -> 0x0059, Exception -> 0x0056, all -> 0x0054 }
            r3 = r0
        L_0x0052:
            r4 = r2
            goto L_0x006d
        L_0x0054:
            r9 = move-exception
            goto L_0x007f
        L_0x0056:
            r0 = move-exception
            r4 = r2
            goto L_0x005f
        L_0x0059:
            r4 = r2
            goto L_0x0063
        L_0x005b:
            r9 = move-exception
            r2 = r4
            goto L_0x007f
        L_0x005e:
            r0 = move-exception
        L_0x005f:
            r0.printStackTrace()     // Catch:{ all -> 0x005b }
            goto L_0x006d
        L_0x0063:
            boolean r2 = r1.isOpen()     // Catch:{ all -> 0x005b }
            if (r2 != 0) goto L_0x006d
            android.database.sqlite.SQLiteDatabase r1 = r0.a()     // Catch:{ all -> 0x005b }
        L_0x006d:
            r1.setTransactionSuccessful()     // Catch:{ all -> 0x005b }
            r1.endTransaction()
            r8.closeCursor(r4)
            r1.close()
            if (r3 <= 0) goto L_0x007e
            r8.addRow(r9, r10)
        L_0x007e:
            return
        L_0x007f:
            r1.endTransaction()
            r8.closeCursor(r2)
            r1.close()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.util.UpiDBManager.deleteRow(android.content.Context, net.one97.paytm.upi.common.upi.UpiDBTransactionModel):void");
    }

    public ArrayList<UpiDBTransactionModel> getRecentTransactions(Context context, String str) {
        SQLiteDatabase sQLiteDatabase;
        a paytmDBManager = getPaytmDBManager(context);
        if (!paytmDBManager.b()) {
            sQLiteDatabase = paytmDBManager.a();
        } else {
            sQLiteDatabase = paytmDBManager.f66667a;
        }
        ArrayList<UpiDBTransactionModel> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT * FROM upi_recent_txns WHERE txn_type = '" + str + "' ORDER BY timestamp DESC", (String[]) null);
            if (cursor != null && cursor.moveToFirst()) {
                for (int i2 = 0; i2 < cursor.getCount(); i2++) {
                    cursor.moveToPosition(i2);
                    UpiDBTransactionModel upiDBTransactionModel = new UpiDBTransactionModel();
                    upiDBTransactionModel.setTxn_mode(cursor.getString(cursor.getColumnIndex("txn_mode")));
                    upiDBTransactionModel.setTxn_type(cursor.getString(cursor.getColumnIndex("txn_type")));
                    upiDBTransactionModel.setTxn_amount(cursor.getString(cursor.getColumnIndex("txn_amount")));
                    upiDBTransactionModel.setBeneficiary_name(cursor.getString(cursor.getColumnIndex("beneficiary_name")));
                    upiDBTransactionModel.setBank_name(cursor.getString(cursor.getColumnIndex(PayUtility.BANK_NAME)));
                    upiDBTransactionModel.setIfsc(cursor.getString(cursor.getColumnIndex("ifsc")));
                    upiDBTransactionModel.setTimestamp(cursor.getString(cursor.getColumnIndex("timestamp")));
                    arrayList.add(upiDBTransactionModel);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            closeCursor((Cursor) null);
            sQLiteDatabase.close();
            throw th;
        }
        closeCursor(cursor);
        sQLiteDatabase.close();
        return arrayList;
    }

    private void closeCursor(Cursor cursor) {
        try {
            if ((true ^ cursor.isClosed()) && (cursor != null)) {
                cursor.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
