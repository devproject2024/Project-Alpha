package com.paytm.contactsSdk.api.query;

import androidx.sqlite.db.a;
import com.paytm.contactsSdk.api.ContactsProvider;
import com.paytm.contactsSdk.models.MappingInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class EnrichmentQuery {
    private final String TAG;
    private final ArrayList<Long> andArray;
    private final boolean isConditionalQuery;
    private final ArrayList<Long> notArray;
    private int offSet;
    private final ArrayList<Long> orArray;
    private int pageSize;

    private EnrichmentQuery(Builder builder) {
        String simpleName = EnrichmentQuery.class.getSimpleName();
        k.a((Object) simpleName, "EnrichmentQuery::class.java.simpleName");
        this.TAG = simpleName;
        this.pageSize = 2;
        this.andArray = builder.getAndArray$contacts_sdk_release();
        this.orArray = builder.getOrArray$contacts_sdk_release();
        this.notArray = builder.getNotArray$contacts_sdk_release();
        this.offSet = builder.getOffset$contacts_sdk_release();
        this.pageSize = builder.getPageSize$contacts_sdk_release();
        this.isConditionalQuery = builder.isConditionalQuery$contacts_sdk_release();
        new StringBuilder("andArray =").append(this.andArray.toString());
        new StringBuilder("orArray =").append(this.orArray.toString());
        new StringBuilder("notArray =").append(this.notArray.toString());
    }

    public /* synthetic */ EnrichmentQuery(Builder builder, g gVar) {
        this(builder);
    }

    public final ArrayList<Long> getAndArray$contacts_sdk_release() {
        return this.andArray;
    }

    public final ArrayList<Long> getOrArray$contacts_sdk_release() {
        return this.orArray;
    }

    public final ArrayList<Long> getNotArray$contacts_sdk_release() {
        return this.notArray;
    }

    public final int getOffSet$contacts_sdk_release() {
        return this.offSet;
    }

    public final void setOffSet$contacts_sdk_release(int i2) {
        this.offSet = i2;
    }

    public final int getPageSize$contacts_sdk_release() {
        return this.pageSize;
    }

    public final void setPageSize$contacts_sdk_release(int i2) {
        this.pageSize = i2;
    }

    public final void setPageNumber(int i2) {
        this.offSet = i2 * this.pageSize;
    }

    public final void setPageSize(int i2) {
        this.pageSize = i2;
    }

    public final a getEnrichmentDataQuery() {
        ArrayList arrayList = new ArrayList();
        String str = "SELECT * FROM enrichment_data";
        if (this.isConditionalQuery) {
            str = (str + " WHERE ") + notQuery(arrayList) + " AND ( " + andQuery(arrayList) + " OR " + orQuery(arrayList) + " )";
        }
        a aVar = new a(str, arrayList.toArray());
        new StringBuilder("getEnrichmentDataQuery=").append(aVar.f4539a);
        return aVar;
    }

    public final a getEnrichedContactsQuery() {
        ArrayList arrayList = new ArrayList();
        String str = "SELECT contacts.name,contacts_phones.phone,enrichment_data.featureJson FROM contacts INNER JOIN contacts_phones ON contacts_phones.contact_id = contacts.id INNER JOIN enrichment_data ON enrichment_data.phoneNumber = contacts_phones.phone";
        if (this.isConditionalQuery) {
            str = (str + " WHERE ") + notQuery(arrayList) + " AND ( " + andQuery(arrayList) + " OR " + orQuery(arrayList) + " )";
        }
        a aVar = new a(str, arrayList.toArray());
        new StringBuilder("getEnrichedContactsQuery=").append(aVar.f4539a);
        return aVar;
    }

    public final a getEnrichedContactsPaginatedQuery() {
        ArrayList arrayList = new ArrayList();
        String str = "SELECT contacts.name,contacts_phones.phone,enrichment_data.featureJson FROM contacts INNER JOIN contacts_phones ON contacts_phones.contact_id = contacts.id INNER JOIN enrichment_data ON enrichment_data.phoneNumber = contacts_phones.phone";
        if (this.isConditionalQuery) {
            str = (str + " WHERE ") + notQuery(arrayList) + " AND ( " + andQuery(arrayList) + " OR " + orQuery(arrayList) + " )";
        }
        arrayList.add(Integer.valueOf(this.offSet));
        arrayList.add(Integer.valueOf(this.pageSize));
        a aVar = new a(str + " LIMIT ?,?", arrayList.toArray());
        new StringBuilder("getEnrichedContactsPaginatedQuery=").append(aVar.f4539a);
        return aVar;
    }

    private final String notQuery(ArrayList<Object> arrayList) {
        String str = "";
        for (int i2 = 0; i2 <= 3; i2++) {
            if (str.length() > 0) {
                str = str + " AND ";
            }
            str = str + "enrichmentBitCodeCol_" + i2 + " & ? = 0";
            arrayList.add(this.notArray.get(i2));
        }
        return "(" + str + ')';
    }

    private final String andQuery(ArrayList<Object> arrayList) {
        String str = "";
        for (int i2 = 0; i2 <= 3; i2++) {
            if (str.length() > 0) {
                str = str + " AND ";
            }
            str = str + "enrichmentBitCodeCol_" + i2 + " & ? = ?";
            arrayList.add(this.andArray.get(i2));
            arrayList.add(this.andArray.get(i2));
        }
        return "(" + str + ')';
    }

    private final String orQuery(ArrayList<Object> arrayList) {
        String str = "";
        for (int i2 = 0; i2 <= 3; i2++) {
            if (str.length() > 0) {
                str = str + " OR ";
            }
            str = str + "enrichmentBitCodeCol_" + i2 + " & ? != 0";
            arrayList.add(this.orArray.get(i2));
        }
        return "(" + str + ')';
    }

    public static final class Builder {
        private final ArrayList<Long> andArray = kotlin.a.k.d(0L, 0L, 0L, 0L);
        private final HashMap<String, MappingInfo> dynamicMapping = ContactsProvider.INSTANCE.getDynamicMapping$contacts_sdk_release();
        private boolean isConditionalQuery;
        private final ArrayList<Long> notArray = kotlin.a.k.d(0L, 0L, 0L, 0L);
        private int offset;
        private final ArrayList<Long> orArray = kotlin.a.k.d(0L, 0L, 0L, 0L);
        private int pageSize = 2;

        public final ArrayList<Long> getAndArray$contacts_sdk_release() {
            return this.andArray;
        }

        public final ArrayList<Long> getOrArray$contacts_sdk_release() {
            return this.orArray;
        }

        public final ArrayList<Long> getNotArray$contacts_sdk_release() {
            return this.notArray;
        }

        public final boolean isConditionalQuery$contacts_sdk_release() {
            return this.isConditionalQuery;
        }

        public final void setConditionalQuery$contacts_sdk_release(boolean z) {
            this.isConditionalQuery = z;
        }

        public final int getPageSize$contacts_sdk_release() {
            return this.pageSize;
        }

        public final void setPageSize$contacts_sdk_release(int i2) {
            this.pageSize = i2;
        }

        public final int getOffset$contacts_sdk_release() {
            return this.offset;
        }

        public final void setOffset$contacts_sdk_release(int i2) {
            this.offset = i2;
        }

        public final HashMap<String, MappingInfo> getDynamicMapping$contacts_sdk_release() {
            return this.dynamicMapping;
        }

        public final Builder and(String str) {
            k.c(str, "feature");
            this.isConditionalQuery = true;
            if (this.dynamicMapping.containsKey(str)) {
                MappingInfo mappingInfo = this.dynamicMapping.get(str);
                if (mappingInfo == null) {
                    k.a();
                }
                MappingInfo mappingInfo2 = mappingInfo;
                this.andArray.set(mappingInfo2.getColumnNumber(), Long.valueOf(this.andArray.get(mappingInfo2.getColumnNumber()).longValue() | mappingInfo2.getBitCode()));
            }
            return this;
        }

        public final Builder or(String str) {
            k.c(str, "feature");
            this.isConditionalQuery = true;
            if (this.dynamicMapping.containsKey(str)) {
                MappingInfo mappingInfo = this.dynamicMapping.get(str);
                if (mappingInfo == null) {
                    k.a();
                }
                MappingInfo mappingInfo2 = mappingInfo;
                this.orArray.set(mappingInfo2.getColumnNumber(), Long.valueOf(this.orArray.get(mappingInfo2.getColumnNumber()).longValue() | mappingInfo2.getBitCode()));
            }
            return this;
        }

        public final Builder not(String str) {
            k.c(str, "feature");
            this.isConditionalQuery = true;
            if (this.dynamicMapping.containsKey(str)) {
                MappingInfo mappingInfo = this.dynamicMapping.get(str);
                if (mappingInfo == null) {
                    k.a();
                }
                MappingInfo mappingInfo2 = mappingInfo;
                this.notArray.set(mappingInfo2.getColumnNumber(), Long.valueOf(this.notArray.get(mappingInfo2.getColumnNumber()).longValue() | mappingInfo2.getBitCode()));
            }
            return this;
        }

        public final Builder not(ArrayList<String> arrayList) {
            k.c(arrayList, "features");
            Iterator<String> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                k.a((Object) next, "feature");
                not(next);
            }
            return this;
        }

        public final Builder and(ArrayList<String> arrayList) {
            k.c(arrayList, "features");
            Iterator<String> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                k.a((Object) next, "feature");
                and(next);
            }
            return this;
        }

        public final Builder or(ArrayList<String> arrayList) {
            k.c(arrayList, "features");
            Iterator<String> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                k.a((Object) next, "feature");
                or(next);
            }
            return this;
        }

        public final void setPageSize(int i2) {
            this.pageSize = i2;
        }

        public final void setPageNumber(int i2) {
            this.offset = i2 * this.pageSize;
        }

        public final EnrichmentQuery build() {
            return new EnrichmentQuery(this, (g) null);
        }
    }
}
