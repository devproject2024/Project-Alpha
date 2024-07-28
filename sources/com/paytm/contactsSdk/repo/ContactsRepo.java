package com.paytm.contactsSdk.repo;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.paytm.contactsSdk.api.p002enum.LocalContactSyncType;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.contactsSdk.manager.DatabaseManager;
import com.paytm.contactsSdk.models.Contact;
import com.paytm.contactsSdk.models.ContactPhone;
import com.paytm.contactsSdk.models.ContactProviderData;
import com.paytm.contactsSdk.models.ContactWithPhones;
import com.paytm.contactsSdk.models.Schema;
import com.paytm.contactsSdk.models.network.DeleteContactRequest;
import com.paytm.contactsSdk.network.NetworkRequestHelper;
import com.paytm.contactsSdk.utils.ContactUtil;
import com.paytm.utility.q;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.aa;
import kotlin.a.f;
import kotlin.a.j;
import kotlin.a.w;
import kotlin.a.z;
import kotlin.d.d;
import kotlin.g.a.b;
import kotlin.g.b.ab;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

public final class ContactsRepo {

    public enum DBOperation {
        ADD,
        UPDATE_CONTACTPHONE_TABLE,
        UPDATE_CONTACT_TABLE
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DBOperation.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[DBOperation.ADD.ordinal()] = 1;
            $EnumSwitchMapping$0[DBOperation.UPDATE_CONTACT_TABLE.ordinal()] = 2;
            $EnumSwitchMapping$0[DBOperation.UPDATE_CONTACTPHONE_TABLE.ordinal()] = 3;
            int[] iArr2 = new int[DBOperation.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[DBOperation.UPDATE_CONTACTPHONE_TABLE.ordinal()] = 1;
            $EnumSwitchMapping$1[DBOperation.UPDATE_CONTACT_TABLE.ordinal()] = 2;
        }
    }

    public final Cursor getAllContactsList() {
        return DatabaseManager.INSTANCE.getDatabase().contactsPhonesDao().getAllContactWithPhone();
    }

    public final void copyContactsFromContactsProviderToLocalDb(Context context) {
        k.c(context, "context");
        long currentTimeMillis = System.currentTimeMillis();
        ContactProviderData contactsFromContactsProvider = getContactsFromContactsProvider(context);
        insertAndUpdateDeltaContactsToDB(getDeltaInsertAndUpdateContactToDB(contactsFromContactsProvider.getContactsIDAndDataMap()));
        updateDeletedContactFromProvider(context, contactsFromContactsProvider.getDeletedContactIdList());
        new StringBuilder("Total Time in milli seconds - ").append(System.currentTimeMillis() - currentTimeMillis);
    }

    public final Cursor getContactsByName(String str) {
        k.c(str, "searchKey");
        return DatabaseManager.INSTANCE.getDatabase().contactsPhonesDao().getContactsWithPhoneByName(str);
    }

    public final Cursor getContactsByPagination(int i2, int i3) {
        return DatabaseManager.INSTANCE.getDatabase().contactsPhonesDao().getAllContactWithPhone(i2, i3 * i2);
    }

    private final void insertAndUpdateDeltaContactsToDB(HashMap<DBOperation, HashMap<Integer, ContactWithPhones>> hashMap) {
        for (Map.Entry entry : hashMap.entrySet()) {
            q.b(((DBOperation) entry.getKey()).name() + "  " + ((HashMap) entry.getValue()).values());
            int i2 = WhenMappings.$EnumSwitchMapping$0[((DBOperation) entry.getKey()).ordinal()];
            if (i2 == 1) {
                DatabaseManager.INSTANCE.getDatabase().contactsDao().insertContactsWithPhone(new ArrayList(((HashMap) entry.getValue()).values()));
            } else if (i2 == 2) {
                updateContactsTable(new ArrayList(((HashMap) entry.getValue()).values()));
                q.b(((HashMap) entry.getValue()).values().toString());
            } else if (i2 == 3) {
                updateContactPhonesTable((HashMap) entry.getValue());
                updateContactsTable(new ArrayList(((HashMap) entry.getValue()).values()));
                q.b(((HashMap) entry.getValue()).values().toString());
            }
        }
    }

    public final void updateContactsTable(List<ContactWithPhones> list) {
        k.c(list, "contactWithPhonesList");
        DatabaseManager.INSTANCE.getDatabase().contactsDao().updateContacts(ContactUtil.INSTANCE.getContactsFromContactPhoneWithSync$contacts_sdk_release(list, LocalContactSyncType.SYNC_ADD_UPDATE));
    }

    private final void updateContactPhonesTable(HashMap<Integer, ContactWithPhones> hashMap) {
        ArrayList arrayList = new ArrayList();
        Set<Integer> keySet = hashMap.keySet();
        k.a((Object) keySet, "contactIDDataMap.keys");
        for (List deleteDeletedContacts : kotlin.a.k.i(keySet)) {
            DatabaseManager.INSTANCE.getDatabase().contactsPhonesDao().deleteDeletedContacts(deleteDeletedContacts);
        }
        Iterator it2 = new ArrayList(hashMap.values()).iterator();
        while (it2.hasNext()) {
            for (ContactPhone add : ((ContactWithPhones) it2.next()).getPhones()) {
                arrayList.add(add);
            }
        }
        if (!arrayList.isEmpty()) {
            DatabaseManager.INSTANCE.getDatabase().contactsPhonesDao().insertAll(arrayList);
        }
    }

    private final HashMap<DBOperation, HashMap<Integer, ContactWithPhones>> getDeltaInsertAndUpdateContactToDB(LinkedHashMap<Integer, ContactWithPhones> linkedHashMap) {
        HashMap<DBOperation, HashMap<Integer, ContactWithPhones>> hashMap = new HashMap<>();
        List<ContactWithPhones> contactsWithPhones = DatabaseManager.INSTANCE.getDatabase().contactsDao().getContactsWithPhones();
        if (contactsWithPhones != null) {
            ArrayList arrayList = (ArrayList) contactsWithPhones;
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                ((Number) entry.getKey()).intValue();
                ContactWithPhones contactWithPhones = (ContactWithPhones) entry.getValue();
                ContactWithPhones contact = getContact(contactWithPhones.getContact().getId(), arrayList);
                if (contact == null) {
                    if (hashMap.get(DBOperation.ADD) == null) {
                        hashMap.put(DBOperation.ADD, new HashMap());
                    }
                    HashMap<Integer, ContactWithPhones> hashMap2 = hashMap.get(DBOperation.ADD);
                    if (hashMap2 == null) {
                        k.a();
                    }
                    k.a((Object) hashMap2, "insertUpdateContacts[DBOperation.ADD]!!");
                    hashMap2.put(Integer.valueOf(contactWithPhones.getContact().getId()), contactWithPhones);
                } else {
                    addUpdatedContactToMap(contact, contactWithPhones, hashMap);
                }
                Collection collection = arrayList;
                if (collection != null) {
                    ab.b(collection).remove(contact);
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                }
            }
            return hashMap;
        }
        throw new u("null cannot be cast to non-null type java.util.ArrayList<com.paytm.contactsSdk.models.ContactWithPhones>");
    }

    private final void addUpdatedContactToMap(ContactWithPhones contactWithPhones, ContactWithPhones contactWithPhones2, HashMap<DBOperation, HashMap<Integer, ContactWithPhones>> hashMap) {
        DBOperation dBOperation = k.a((Object) contactWithPhones.getContact().getName(), (Object) contactWithPhones2.getContact().getName()) ^ true ? DBOperation.UPDATE_CONTACT_TABLE : null;
        if (contactWithPhones.getPhones().size() != contactWithPhones2.getPhones().size()) {
            dBOperation = DBOperation.UPDATE_CONTACTPHONE_TABLE;
        } else if (!getOnlyPhoneData(contactWithPhones2.getPhones()).equals(getOnlyPhoneData(contactWithPhones.getPhones()))) {
            dBOperation = DBOperation.UPDATE_CONTACTPHONE_TABLE;
        }
        if (dBOperation != null) {
            int i2 = WhenMappings.$EnumSwitchMapping$1[dBOperation.ordinal()];
            if (i2 == 1) {
                if (hashMap.get(DBOperation.UPDATE_CONTACTPHONE_TABLE) == null) {
                    hashMap.put(DBOperation.UPDATE_CONTACTPHONE_TABLE, new HashMap());
                }
                HashMap<Integer, ContactWithPhones> hashMap2 = hashMap.get(DBOperation.UPDATE_CONTACTPHONE_TABLE);
                if (hashMap2 == null) {
                    k.a();
                }
                k.a((Object) hashMap2, "insertUpdateContacts[DBO…ATE_CONTACTPHONE_TABLE]!!");
                hashMap2.put(Integer.valueOf(contactWithPhones2.getContact().getId()), contactWithPhones2);
            } else if (i2 == 2) {
                if (hashMap.get(DBOperation.UPDATE_CONTACT_TABLE) == null) {
                    hashMap.put(DBOperation.UPDATE_CONTACT_TABLE, new HashMap());
                }
                HashMap<Integer, ContactWithPhones> hashMap3 = hashMap.get(DBOperation.UPDATE_CONTACT_TABLE);
                if (hashMap3 == null) {
                    k.a();
                }
                k.a((Object) hashMap3, "insertUpdateContacts[DBO…n.UPDATE_CONTACT_TABLE]!!");
                hashMap3.put(Integer.valueOf(contactWithPhones2.getContact().getId()), contactWithPhones2);
            }
        }
    }

    private final List<String> getOnlyPhoneData(List<ContactPhone> list) {
        ArrayList arrayList = new ArrayList();
        for (ContactPhone contactPhoneData : list) {
            arrayList.add(contactPhoneData.getContactPhoneData());
        }
        return arrayList;
    }

    private final ContactWithPhones getContact(int i2, ArrayList<ContactWithPhones> arrayList) {
        Iterator<ContactWithPhones> it2 = arrayList.iterator();
        ContactWithPhones contactWithPhones = null;
        while (it2.hasNext()) {
            ContactWithPhones next = it2.next();
            if (next.getContact().getId() == i2) {
                contactWithPhones = next;
            }
        }
        return contactWithPhones;
    }

    public final Object getUnSyncedContacts(Context context, d<? super HashMap<String, List<ContactWithPhones>>> dVar) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ContactsRepo$getUnSyncedContacts$2((d) null), dVar);
    }

    public final Object getUnSyncedContacts1(Context context, d<? super List<ContactWithPhones>> dVar) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ContactsRepo$getUnSyncedContacts1$2((d) null), dVar);
    }

    public final Object getRowsByContactIds(Context context, ArrayList<String> arrayList, d<? super ArrayList<Object>> dVar) {
        String str;
        String str2;
        ArrayList arrayList2 = new ArrayList();
        if (!arrayList.isEmpty()) {
            Iterable iterable = arrayList;
            kotlin.a.k.a(iterable, (CharSequence) AppConstants.COMMA, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (b) null, 62);
            getSchemaMap(context);
            int size = arrayList.size();
            String[] strArr = new String[size];
            int i2 = 0;
            while (true) {
                str = "";
                if (i2 >= size) {
                    break;
                }
                Integer.valueOf(i2).intValue();
                strArr[i2] = str;
                i2++;
            }
            for (z zVar : kotlin.a.k.g(iterable)) {
                if (zVar.f47893a == arrayList.size() - 1) {
                    str2 = str + '?';
                } else {
                    str2 = str + "?,";
                }
                str = str2;
                strArr[zVar.f47893a] = (String) zVar.f47894b;
            }
            Cursor query = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, (String[]) null, "_id IN(" + str + ')', strArr, (String) null);
            if (query != null && query.getCount() > 0) {
                getDataUriRowsFromCursor(query);
            }
        }
        return arrayList2;
    }

    private final ArrayList<Object> getDataUriRowsFromCursor(Cursor cursor) {
        ArrayList<Object> arrayList = new ArrayList<>();
        if (cursor.getCount() > 0) {
            String[] columnNames = cursor.getColumnNames();
            k.a((Object) columnNames, "columnNames");
            CharSequence charSequence = AppConstants.COMMA;
            CharSequence charSequence2 = "";
            CharSequence charSequence3 = "";
            CharSequence charSequence4 = AppConstants.DOTS;
            k.d(columnNames, "$this$joinToString");
            k.d(charSequence, "separator");
            k.d(charSequence2, "prefix");
            k.d(charSequence3, "postfix");
            k.d(charSequence4, "truncated");
            String sb = ((StringBuilder) f.a(columnNames, new StringBuilder(), charSequence, charSequence2, charSequence3, charSequence4)).toString();
            k.b(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
            arrayList.add(sb);
            int length = columnNames.length;
            Integer[] numArr = new Integer[length];
            for (int i2 = 0; i2 < length; i2++) {
                numArr[i2] = 0;
            }
            k.d(columnNames, "$this$withIndex");
            int i3 = 0;
            for (z zVar : new aa(new j.a(columnNames))) {
                numArr[zVar.f47893a] = Integer.valueOf(cursor.getColumnIndex((String) zVar.f47894b));
                i3 = cursor.getColumnIndex("phonetic_name");
                System.out.println(i3);
            }
            while (cursor.moveToNext()) {
                String string = cursor.getString(numArr[0].intValue());
                cursor.getString(i3);
                cursor.getString(cursor.getColumnIndex("phonetic_name"));
                String string2 = cursor.getString(numArr[1].intValue());
                String string3 = cursor.getString(numArr[2].intValue());
                String string4 = cursor.getString(numArr[3].intValue());
                arrayList.add(string + ", " + string2 + ", " + string3 + ", " + string4);
            }
        }
        return arrayList;
    }

    public final Object getContactsFromContactsUriByIds(d<? super x> dVar) {
        Uri uri = ContactsContract.DeletedContacts.CONTENT_URI;
        return x.f47997a;
    }

    public final List<Integer> getDeletedContacts(Context context, long j) {
        k.c(context, "context");
        List<Integer> arrayList = new ArrayList<>();
        Cursor query = context.getContentResolver().query(ContactsContract.DeletedContacts.CONTENT_URI, (String[]) null, "contact_deleted_timestamp > ?", new String[]{String.valueOf(j)}, "contact_deleted_timestamp DESC");
        if (query != null && query.getCount() > 0) {
            int columnIndex = query.getColumnIndex(ContactColumn.CONTACT_ID);
            while (query.moveToNext()) {
                arrayList.add(Integer.valueOf(query.getInt(columnIndex)));
            }
        }
        return arrayList;
    }

    public final Object getFirst50ContactsAsDummy(Context context, d<? super List<String>> dVar) {
        List arrayList = new ArrayList();
        Cursor query = context.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, (String[]) null, (String) null, (String[]) null, (String) null);
        if (query != null && query.getCount() > 0) {
            int i2 = 0;
            while (query.moveToNext()) {
                int i3 = i2 + 1;
                if (i2 >= 10) {
                    break;
                }
                String string = query.getString(query.getColumnIndex("_id"));
                k.a((Object) string, "id");
                arrayList.add(string);
                i2 = i3;
            }
        }
        return arrayList;
    }

    private final HashSet<String> getDeletedContactsFromRawContacts(Context context) {
        HashSet<String> hashSet = new HashSet<>();
        Cursor query = context.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, (String[]) null, "deleted =?", new String[]{"1"}, (String) null);
        if (query != null && query.getCount() > 0) {
            int columnIndex = query.getColumnIndex(StringSet.deleted);
            while (query.moveToNext()) {
                hashSet.add(query.getString(columnIndex));
            }
        }
        return hashSet;
    }

    public final void getAllContacts(Context context) {
        k.c(context, "context");
        Cursor query = context.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, (String[]) null, (String) null, (String[]) null, (String) null);
        long currentTimeMillis = System.currentTimeMillis();
        if (query != null) {
            System.out.println("contacts ".concat(String.valueOf(query.getCount())));
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex("_id"));
                k.a((Object) string, "cursor.getString(\n      …ts._ID)\n                )");
                String string2 = query.getString(query.getColumnIndex("display_name"));
                if (string2 == null) {
                    string2 = "";
                }
                System.out.println("id " + string + " name " + string2);
            }
        }
        System.out.println("time taken ".concat(String.valueOf(System.currentTimeMillis() - currentTimeMillis)));
    }

    public final void getAllData(Context context) {
        k.c(context, "context");
        Cursor query = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, (String[]) null, (String) null, (String[]) null, (String) null);
        long currentTimeMillis = System.currentTimeMillis();
        if (query != null) {
            int count = query.getCount();
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex("raw_contact_id"));
                k.a((Object) string, "cursor.getString(\n      …ACT_ID)\n                )");
                String string2 = query.getString(query.getColumnIndex("display_name"));
                if (string2 == null) {
                    string2 = "";
                }
                System.out.println("id " + string + " name " + string2);
            }
            System.out.println("contacts ".concat(String.valueOf(count)));
        }
        System.out.println("getAllData");
        System.out.println("time taken ".concat(String.valueOf(System.currentTimeMillis() - currentTimeMillis)));
    }

    public final Object getSchemaList(Context context, d<? super ArrayList<Schema>> dVar) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ContactsRepo$getSchemaList$2(this, context, (d) null), dVar);
    }

    /* access modifiers changed from: private */
    public final HashMap<String, List<String>> getSchemaMap(Context context) {
        List list;
        List list2;
        List list3;
        List list4;
        String[] columnNames;
        String[] columnNames2;
        String[] columnNames3;
        String[] columnNames4;
        HashMap<String, List<String>> hashMap = new HashMap<>();
        ContentResolver contentResolver = context.getContentResolver();
        Cursor query = contentResolver.query(ContactsContract.Data.CONTENT_URI, (String[]) null, (String) null, (String[]) null, (String) null);
        if (query == null || (columnNames4 = query.getColumnNames()) == null || (list = f.b(columnNames4)) == null) {
            list = w.INSTANCE;
        }
        Map map = hashMap;
        String simpleName = ContactsContract.Data.class.getSimpleName();
        k.a((Object) simpleName, "ContactsContract.Data::class.java.simpleName");
        map.put(simpleName, list);
        Cursor query2 = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, (String[]) null, (String) null, (String[]) null, (String) null);
        if (query2 == null || (columnNames3 = query2.getColumnNames()) == null || (list2 = f.b(columnNames3)) == null) {
            list2 = w.INSTANCE;
        }
        String simpleName2 = ContactsContract.Contacts.class.getSimpleName();
        k.a((Object) simpleName2, "ContactsContract.Contacts::class.java.simpleName");
        map.put(simpleName2, list2);
        Cursor query3 = contentResolver.query(ContactsContract.RawContacts.CONTENT_URI, (String[]) null, (String) null, (String[]) null, (String) null);
        if (query3 == null || (columnNames2 = query3.getColumnNames()) == null || (list3 = f.b(columnNames2)) == null) {
            list3 = w.INSTANCE;
        }
        String simpleName3 = ContactsContract.RawContacts.class.getSimpleName();
        k.a((Object) simpleName3, "ContactsContract.RawCont…ts::class.java.simpleName");
        map.put(simpleName3, list3);
        Cursor query4 = contentResolver.query(ContactsContract.DeletedContacts.CONTENT_URI, (String[]) null, (String) null, (String[]) null, (String) null);
        if (query4 == null || (columnNames = query4.getColumnNames()) == null || (list4 = f.b(columnNames)) == null) {
            list4 = w.INSTANCE;
        }
        String simpleName4 = ContactsContract.DeletedContacts.class.getSimpleName();
        k.a((Object) simpleName4, "ContactsContract.Deleted…ts::class.java.simpleName");
        map.put(simpleName4, list4);
        return hashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v13, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r26v14 */
    /* JADX WARNING: type inference failed for: r26v16 */
    /* JADX WARNING: type inference failed for: r26v18 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00fc A[Catch:{ Exception -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0150 A[Catch:{ Exception -> 0x0189 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.paytm.contactsSdk.models.ContactProviderData getContactsFromContactsProvider(android.content.Context r33) {
        /*
            r32 = this;
            r1 = r33
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            android.content.ContentResolver r3 = r33.getContentResolver()
            android.net.Uri r4 = android.provider.ContactsContract.Data.CONTENT_URI
            java.lang.String r5 = "contact_id"
            java.lang.String r6 = "display_name"
            java.lang.String r7 = "mimetype"
            java.lang.String r8 = "data1"
            java.lang.String r9 = "is_primary"
            java.lang.String r10 = "contact_last_updated_timestamp"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7, r8, r9, r10}
            com.paytm.contactsSdk.utils.ContactUtil r0 = com.paytm.contactsSdk.utils.ContactUtil.INSTANCE
            long r9 = r0.getLastLocalContactSyncedTime$contacts_sdk_release(r1)
            java.lang.String r0 = java.lang.String.valueOf(r9)
            com.paytm.utility.q.b(r0)
            r0 = 2
            java.lang.String[] r7 = new java.lang.String[r0]
            r11 = 0
            java.lang.String r0 = "vnd.android.cursor.item/phone_v2"
            r7[r11] = r0
            java.lang.String r0 = java.lang.String.valueOf(r9)
            r12 = 1
            r7[r12] = r0
            java.lang.String r6 = "mimetype IN(?) AND contact_last_updated_timestamp   > ? "
            java.lang.String r8 = "display_name ASC"
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8)
            long r4 = java.lang.System.currentTimeMillis()
            if (r3 == 0) goto L_0x01d3
            int r0 = r3.getCount()
            if (r0 <= 0) goto L_0x01cc
            int r6 = r3.getCount()
            java.lang.String r0 = "contact_id"
            int r7 = r3.getColumnIndex(r0)
            java.lang.String r0 = "display_name"
            int r8 = r3.getColumnIndex(r0)
            java.lang.String r0 = "mimetype"
            int r13 = r3.getColumnIndex(r0)
            java.lang.String r0 = "data1"
            int r14 = r3.getColumnIndex(r0)
            java.lang.String r0 = "is_primary"
            int r15 = r3.getColumnIndex(r0)
            java.lang.String r0 = "contact_last_updated_timestamp"
            int r11 = r3.getColumnIndex(r0)
            r16 = r9
        L_0x0078:
            boolean r0 = r3.moveToNext()
            if (r0 == 0) goto L_0x01bc
            int r0 = r3.getInt(r7)     // Catch:{ Exception -> 0x018f }
            java.lang.String r18 = r3.getString(r14)     // Catch:{ Exception -> 0x018f }
            java.lang.String r19 = ""
            if (r18 != 0) goto L_0x008d
            r25 = r19
            goto L_0x008f
        L_0x008d:
            r25 = r18
        L_0x008f:
            java.lang.String r18 = r3.getString(r8)     // Catch:{ Exception -> 0x018f }
            if (r18 != 0) goto L_0x0098
            r26 = r25
            goto L_0x009a
        L_0x0098:
            r26 = r18
        L_0x009a:
            java.lang.String r18 = r3.getString(r13)     // Catch:{ Exception -> 0x018f }
            if (r18 != 0) goto L_0x00a3
            r27 = r19
            goto L_0x00a5
        L_0x00a3:
            r27 = r18
        L_0x00a5:
            int r12 = r3.getInt(r15)     // Catch:{ Exception -> 0x018f }
            long r18 = r3.getLong(r11)     // Catch:{ Exception -> 0x018f }
            int r20 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            r28 = r3
            if (r20 <= 0) goto L_0x00b5
            r16 = r18
        L_0x00b5:
            r3 = r2
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ Exception -> 0x018d }
            r29 = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x018b }
            boolean r3 = r3.containsKey(r7)     // Catch:{ Exception -> 0x018b }
            if (r3 == 0) goto L_0x00e8
            r19 = r2
            java.util.HashMap r19 = (java.util.HashMap) r19     // Catch:{ Exception -> 0x018b }
            r3 = 1
            if (r12 != r3) goto L_0x00ce
            r23 = 1
            goto L_0x00d0
        L_0x00ce:
            r23 = 0
        L_0x00d0:
            r18 = r32
            r20 = r0
            r21 = r27
            r22 = r25
            r18.mergeRawContact(r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x018b }
            r30 = r11
            r31 = r14
            r3 = r25
            r11 = r26
            r14 = 1
            r25 = r8
            goto L_0x0159
        L_0x00e8:
            r3 = r25
            r25 = r3
            java.lang.CharSequence r25 = (java.lang.CharSequence) r25     // Catch:{ Exception -> 0x018b }
            if (r25 == 0) goto L_0x00f9
            int r7 = r25.length()     // Catch:{ Exception -> 0x018b }
            if (r7 != 0) goto L_0x00f7
            goto L_0x00f9
        L_0x00f7:
            r7 = 0
            goto L_0x00fa
        L_0x00f9:
            r7 = 1
        L_0x00fa:
            if (r7 != 0) goto L_0x0150
            com.paytm.contactsSdk.models.Contact r7 = new com.paytm.contactsSdk.models.Contact     // Catch:{ Exception -> 0x018b }
            com.paytm.contactsSdk.api.enum.LocalContactSyncType r18 = com.paytm.contactsSdk.api.p002enum.LocalContactSyncType.SYNC_ADD_UPDATE     // Catch:{ Exception -> 0x018b }
            r25 = r8
            int r8 = r18.ordinal()     // Catch:{ Exception -> 0x014e }
            r30 = r11
            r11 = r26
            r7.<init>(r0, r11, r8)     // Catch:{ Exception -> 0x014c }
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ Exception -> 0x014c }
            r8.<init>()     // Catch:{ Exception -> 0x014c }
            r26 = r13
            com.paytm.contactsSdk.models.ContactPhone r13 = new com.paytm.contactsSdk.models.ContactPhone     // Catch:{ Exception -> 0x014a }
            r19 = 0
            r31 = r14
            com.paytm.contactsSdk.utils.ContactUtil r14 = com.paytm.contactsSdk.utils.ContactUtil.INSTANCE     // Catch:{ Exception -> 0x0148 }
            java.lang.String r21 = r14.getNormalizedPhoneNumber$contacts_sdk_release(r3)     // Catch:{ Exception -> 0x0148 }
            r14 = 1
            if (r12 != r14) goto L_0x0126
            r22 = 1
            goto L_0x0128
        L_0x0126:
            r22 = 0
        L_0x0128:
            r23 = 1
            r24 = 0
            r18 = r13
            r20 = r0
            r18.<init>(r19, r20, r21, r22, r23, r24)     // Catch:{ Exception -> 0x0189 }
            r8.add(r13)     // Catch:{ Exception -> 0x0189 }
            com.paytm.contactsSdk.models.ContactWithPhones r12 = new com.paytm.contactsSdk.models.ContactWithPhones     // Catch:{ Exception -> 0x0189 }
            java.util.List r8 = (java.util.List) r8     // Catch:{ Exception -> 0x0189 }
            r12.<init>(r7, r8)     // Catch:{ Exception -> 0x0189 }
            r7 = r2
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ Exception -> 0x0189 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0189 }
            r7.put(r8, r12)     // Catch:{ Exception -> 0x0189 }
            goto L_0x015b
        L_0x0148:
            r0 = move-exception
            goto L_0x019c
        L_0x014a:
            r0 = move-exception
            goto L_0x019a
        L_0x014c:
            r0 = move-exception
            goto L_0x0198
        L_0x014e:
            r0 = move-exception
            goto L_0x0196
        L_0x0150:
            r25 = r8
            r30 = r11
            r31 = r14
            r11 = r26
            r14 = 1
        L_0x0159:
            r26 = r13
        L_0x015b:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0189 }
            java.lang.String r8 = "contactId "
            r7.<init>(r8)     // Catch:{ Exception -> 0x0189 }
            r7.append(r0)     // Catch:{ Exception -> 0x0189 }
            java.lang.String r0 = " displayName "
            r7.append(r0)     // Catch:{ Exception -> 0x0189 }
            r7.append(r11)     // Catch:{ Exception -> 0x0189 }
            java.lang.String r0 = " data1 "
            r7.append(r0)     // Catch:{ Exception -> 0x0189 }
            r7.append(r3)     // Catch:{ Exception -> 0x0189 }
            java.lang.String r0 = " mimeType:"
            r7.append(r0)     // Catch:{ Exception -> 0x0189 }
            r0 = r27
            r7.append(r0)     // Catch:{ Exception -> 0x0189 }
            java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x0189 }
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ Exception -> 0x0189 }
            r3.println(r0)     // Catch:{ Exception -> 0x0189 }
            goto L_0x01ad
        L_0x0189:
            r0 = move-exception
            goto L_0x019d
        L_0x018b:
            r0 = move-exception
            goto L_0x0194
        L_0x018d:
            r0 = move-exception
            goto L_0x0192
        L_0x018f:
            r0 = move-exception
            r28 = r3
        L_0x0192:
            r29 = r7
        L_0x0194:
            r25 = r8
        L_0x0196:
            r30 = r11
        L_0x0198:
            r26 = r13
        L_0x019a:
            r31 = r14
        L_0x019c:
            r14 = 1
        L_0x019d:
            java.lang.String r3 = r0.getMessage()
            com.paytm.utility.q.b(r3)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            com.google.firebase.crashlytics.c r3 = com.google.firebase.crashlytics.c.a()
            r3.a((java.lang.Throwable) r0)
        L_0x01ad:
            r8 = r25
            r13 = r26
            r3 = r28
            r7 = r29
            r11 = r30
            r14 = r31
            r12 = 1
            goto L_0x0078
        L_0x01bc:
            java.lang.String r0 = java.lang.String.valueOf(r6)
            java.lang.String r3 = "contacts "
            java.lang.String r0 = r3.concat(r0)
            java.io.PrintStream r3 = java.lang.System.out
            r3.println(r0)
            goto L_0x01ce
        L_0x01cc:
            r16 = r9
        L_0x01ce:
            r3 = r32
            r6 = r16
            goto L_0x01d6
        L_0x01d3:
            r3 = r32
            r6 = r9
        L_0x01d6:
            java.util.List r0 = r3.getDeletedContacts(r1, r9)
            com.paytm.contactsSdk.models.ContactProviderData r8 = new com.paytm.contactsSdk.models.ContactProviderData
            r8.<init>(r2, r0)
            com.paytm.contactsSdk.utils.ContactUtil r0 = com.paytm.contactsSdk.utils.ContactUtil.INSTANCE
            r0.saveLastLocalContactSyncedTime$contacts_sdk_release(r1, r6)
            java.lang.String r0 = java.lang.String.valueOf(r6)
            com.paytm.utility.q.b(r0)
            long r0 = java.lang.System.currentTimeMillis()
            long r0 = r0 - r4
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "time taken millisecs "
            java.lang.String r0 = r1.concat(r0)
            java.io.PrintStream r1 = java.lang.System.out
            r1.println(r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.contactsSdk.repo.ContactsRepo.getContactsFromContactsProvider(android.content.Context):com.paytm.contactsSdk.models.ContactProviderData");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044 A[LOOP:0: B:14:0x0044->B:17:0x005c, LOOP_START, PHI: r0 
      PHI: (r0v2 boolean) = (r0v1 boolean), (r0v4 boolean) binds: [B:13:0x003e, B:17:0x005c] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void mergeRawContact(java.util.HashMap<java.lang.Integer, com.paytm.contactsSdk.models.ContactWithPhones> r9, int r10, java.lang.String r11, java.lang.String r12, boolean r13) {
        /*
            r8 = this;
            java.lang.String r0 = "vnd.android.cursor.item/phone_v2"
            boolean r11 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r0)
            if (r11 == 0) goto L_0x006c
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)
            java.lang.Object r9 = r9.get(r11)
            com.paytm.contactsSdk.models.ContactWithPhones r9 = (com.paytm.contactsSdk.models.ContactWithPhones) r9
            if (r9 == 0) goto L_0x006c
            r11 = r12
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r0 = 0
            if (r11 == 0) goto L_0x0024
            int r11 = r11.length()
            if (r11 != 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r11 = 0
            goto L_0x0025
        L_0x0024:
            r11 = 1
        L_0x0025:
            if (r11 != 0) goto L_0x006c
            com.paytm.contactsSdk.models.ContactPhone r11 = new com.paytm.contactsSdk.models.ContactPhone
            r2 = 0
            com.paytm.contactsSdk.utils.ContactUtil r1 = com.paytm.contactsSdk.utils.ContactUtil.INSTANCE
            java.lang.String r4 = r1.getNormalizedPhoneNumber$contacts_sdk_release(r12)
            r6 = 1
            r7 = 0
            r1 = r11
            r3 = r10
            r5 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7)
            java.util.List r9 = r9.getPhones()
            if (r9 == 0) goto L_0x0064
            java.util.ArrayList r9 = (java.util.ArrayList) r9
            java.util.Iterator r10 = r9.iterator()
        L_0x0044:
            boolean r12 = r10.hasNext()
            if (r12 == 0) goto L_0x005e
            java.lang.Object r12 = r10.next()
            com.paytm.contactsSdk.models.ContactPhone r12 = (com.paytm.contactsSdk.models.ContactPhone) r12
            java.lang.String r12 = r12.getPhone()
            java.lang.String r13 = r11.getPhone()
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.Object) r13)
            if (r0 == 0) goto L_0x0044
        L_0x005e:
            if (r0 != 0) goto L_0x006c
            r9.add(r11)
            goto L_0x006c
        L_0x0064:
            kotlin.u r9 = new kotlin.u
            java.lang.String r10 = "null cannot be cast to non-null type java.util.ArrayList<com.paytm.contactsSdk.models.ContactPhone>"
            r9.<init>(r10)
            throw r9
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.contactsSdk.repo.ContactsRepo.mergeRawContact(java.util.HashMap, int, java.lang.String, java.lang.String, boolean):void");
    }

    private final void updatePhoneNumberData(Context context, String str, ContactWithPhones contactWithPhones) {
        Cursor query = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, (String[]) null, "contact_id = ?", new String[]{str}, (String) null);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            Boolean valueOf = query != null ? Boolean.valueOf(query.moveToNext()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (valueOf.booleanValue()) {
                String string = query.getString(query.getColumnIndex("data1"));
                if (string != null) {
                    String normalizedPhoneNumber = normalizedPhoneNumber(string);
                    if (linkedHashSet.add(normalizedPhoneNumber)) {
                        ContactPhone contactPhone = new ContactPhone(kotlin.a.k.b(linkedHashSet, normalizedPhoneNumber), contactWithPhones.getContact().getId(), normalizedPhoneNumber, false, 8, (g) null);
                        List<ContactPhone> phones = contactWithPhones.getPhones();
                        if (phones != null) {
                            ((ArrayList) phones).add(contactPhone);
                        } else {
                            throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<com.paytm.contactsSdk.models.ContactPhone> /* = java.util.ArrayList<com.paytm.contactsSdk.models.ContactPhone> */");
                        }
                    } else {
                        continue;
                    }
                }
            } else {
                query.close();
                return;
            }
        }
    }

    public final void getAllPhones(Context context) {
        k.c(context, "context");
        Cursor query = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, (String[]) null, (String) null, (String[]) null, (String) null);
        long currentTimeMillis = System.currentTimeMillis();
        if (query != null) {
            int count = query.getCount();
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex("_id"));
                k.a((Object) string, "cursor.getString(\n      …ts._ID)\n                )");
                String string2 = query.getString(query.getColumnIndex("display_name"));
                if (string2 == null) {
                    string2 = "";
                }
                System.out.println("id " + string + " name " + string2);
            }
            System.out.println("contacts ".concat(String.valueOf(count)));
        }
        System.out.println("time taken ".concat(String.valueOf(System.currentTimeMillis() - currentTimeMillis)));
    }

    public final void deleteDeletedContactsAfterServerSync(List<Integer> list) {
        k.c(list, "deletedContacts");
        for (List list2 : kotlin.a.k.i(list)) {
            DatabaseManager.INSTANCE.getDatabase().contactsPhonesDao().deleteDeletedContacts(list2);
            DatabaseManager.INSTANCE.getDatabase().contactsDao().deleteContacts(list2);
        }
    }

    public final void syncDeletedContactsToServer(Context context, DeleteContactRequest deleteContactRequest, com.paytm.network.listener.b bVar) {
        k.c(context, "context");
        k.c(deleteContactRequest, "deleteContactRequest");
        k.c(bVar, "responseHandler");
        NetworkRequestHelper.INSTANCE.deleteContactsNetworkCall(context, deleteContactRequest, bVar);
    }

    public final List<Contact> getContactsFromDb() {
        return DatabaseManager.INSTANCE.getDatabase().contactsDao().getContacts();
    }

    public final List<Integer> getDeleteContactFromLocalWithLimit(int i2) {
        return DatabaseManager.INSTANCE.getDatabase().contactsDao().getContactIds(LocalContactSyncType.SYNC_DELETE.ordinal(), i2);
    }

    public final void deleteDeletedContacts(List<Integer> list) {
        k.c(list, "ids");
        for (List deleteContacts : kotlin.a.k.i(list)) {
            DatabaseManager.INSTANCE.getDatabase().contactsDao().deleteContacts(deleteContacts);
        }
    }

    public final void deleteAllDataFormAllTables() {
        DatabaseManager.INSTANCE.getDatabase().contactsPhonesDao().deleteAllPhone();
        DatabaseManager.INSTANCE.getDatabase().contactsDao().deleteContactsTable();
        DatabaseManager.INSTANCE.getDatabase().dynamicMappingDao().deletedAllData();
        DatabaseManager.INSTANCE.getDatabase().enrichmentDao().deletedAllData();
    }

    private final void updateDeletedContactFromProvider(Context context, List<Integer> list) {
        for (List updateContactSyncType : kotlin.a.k.i(list)) {
            DatabaseManager.INSTANCE.getDatabase().contactsDao().updateContactSyncType(updateContactSyncType, LocalContactSyncType.SYNC_DELETE.ordinal());
        }
    }

    public final long getLocalContactsSyncCount() {
        return DatabaseManager.INSTANCE.getDatabase().contactsDao().getContactsCount();
    }

    public final int getRemoteContactsSyncCount() {
        return (int) (getLocalContactsSyncCount() - DatabaseManager.INSTANCE.getDatabase().contactsDao().getContactsCount(LocalContactSyncType.SYNC_NONE.ordinal()));
    }

    private final String normalizedPhoneNumber(String str) {
        return p.a(p.a(str, " ", "", false), "-", "", false);
    }
}
