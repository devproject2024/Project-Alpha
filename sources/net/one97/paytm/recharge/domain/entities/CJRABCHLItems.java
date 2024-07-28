package net.one97.paytm.recharge.domain.entities;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class CJRABCHLItems implements IJRDataModel {
    @b(a = "id")
    private int id;
    @b(a = "image_url")
    private String imageUrl;
    @b(a = "layout")
    private CJRABCHLLabel layout;
    @b(a = "metadata")
    private CJRABCHLCategoryWeights metadata;
    @b(a = "name")
    private String name;
    @b(a = "seourl")
    private String seoUrl;
    @b(a = "source")
    private String source;
    @b(a = "url")
    private String url;
    @b(a = "url_info")
    private String urlInfo;
    @b(a = "url_type")
    private String urlType;

    public CJRABCHLItems() {
        this(0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (CJRABCHLCategoryWeights) null, (CJRABCHLLabel) null, 1023, (g) null);
    }

    public static /* synthetic */ CJRABCHLItems copy$default(CJRABCHLItems cJRABCHLItems, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, CJRABCHLCategoryWeights cJRABCHLCategoryWeights, CJRABCHLLabel cJRABCHLLabel, int i3, Object obj) {
        CJRABCHLItems cJRABCHLItems2 = cJRABCHLItems;
        int i4 = i3;
        return cJRABCHLItems.copy((i4 & 1) != 0 ? cJRABCHLItems2.id : i2, (i4 & 2) != 0 ? cJRABCHLItems2.name : str, (i4 & 4) != 0 ? cJRABCHLItems2.imageUrl : str2, (i4 & 8) != 0 ? cJRABCHLItems2.urlInfo : str3, (i4 & 16) != 0 ? cJRABCHLItems2.urlType : str4, (i4 & 32) != 0 ? cJRABCHLItems2.url : str5, (i4 & 64) != 0 ? cJRABCHLItems2.source : str6, (i4 & 128) != 0 ? cJRABCHLItems2.seoUrl : str7, (i4 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cJRABCHLItems2.metadata : cJRABCHLCategoryWeights, (i4 & 512) != 0 ? cJRABCHLItems2.layout : cJRABCHLLabel);
    }

    public final int component1$recharge_automatic_release() {
        return this.id;
    }

    public final CJRABCHLLabel component10$recharge_automatic_release() {
        return this.layout;
    }

    public final String component2$recharge_automatic_release() {
        return this.name;
    }

    public final String component3$recharge_automatic_release() {
        return this.imageUrl;
    }

    public final String component4$recharge_automatic_release() {
        return this.urlInfo;
    }

    public final String component5$recharge_automatic_release() {
        return this.urlType;
    }

    public final String component6$recharge_automatic_release() {
        return this.url;
    }

    public final String component7$recharge_automatic_release() {
        return this.source;
    }

    public final String component8$recharge_automatic_release() {
        return this.seoUrl;
    }

    public final CJRABCHLCategoryWeights component9$recharge_automatic_release() {
        return this.metadata;
    }

    public final CJRABCHLItems copy(int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, CJRABCHLCategoryWeights cJRABCHLCategoryWeights, CJRABCHLLabel cJRABCHLLabel) {
        return new CJRABCHLItems(i2, str, str2, str3, str4, str5, str6, str7, cJRABCHLCategoryWeights, cJRABCHLLabel);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CJRABCHLItems) {
                CJRABCHLItems cJRABCHLItems = (CJRABCHLItems) obj;
                if (!(this.id == cJRABCHLItems.id) || !k.a((Object) this.name, (Object) cJRABCHLItems.name) || !k.a((Object) this.imageUrl, (Object) cJRABCHLItems.imageUrl) || !k.a((Object) this.urlInfo, (Object) cJRABCHLItems.urlInfo) || !k.a((Object) this.urlType, (Object) cJRABCHLItems.urlType) || !k.a((Object) this.url, (Object) cJRABCHLItems.url) || !k.a((Object) this.source, (Object) cJRABCHLItems.source) || !k.a((Object) this.seoUrl, (Object) cJRABCHLItems.seoUrl) || !k.a((Object) this.metadata, (Object) cJRABCHLItems.metadata) || !k.a((Object) this.layout, (Object) cJRABCHLItems.layout)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = this.id * 31;
        String str = this.name;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.imageUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.urlInfo;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.urlType;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.url;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.source;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.seoUrl;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        CJRABCHLCategoryWeights cJRABCHLCategoryWeights = this.metadata;
        int hashCode8 = (hashCode7 + (cJRABCHLCategoryWeights != null ? cJRABCHLCategoryWeights.hashCode() : 0)) * 31;
        CJRABCHLLabel cJRABCHLLabel = this.layout;
        if (cJRABCHLLabel != null) {
            i3 = cJRABCHLLabel.hashCode();
        }
        return hashCode8 + i3;
    }

    public final String toString() {
        return "CJRABCHLItems(id=" + this.id + ", name=" + this.name + ", imageUrl=" + this.imageUrl + ", urlInfo=" + this.urlInfo + ", urlType=" + this.urlType + ", url=" + this.url + ", source=" + this.source + ", seoUrl=" + this.seoUrl + ", metadata=" + this.metadata + ", layout=" + this.layout + ")";
    }

    public CJRABCHLItems(int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, CJRABCHLCategoryWeights cJRABCHLCategoryWeights, CJRABCHLLabel cJRABCHLLabel) {
        this.id = i2;
        this.name = str;
        this.imageUrl = str2;
        this.urlInfo = str3;
        this.urlType = str4;
        this.url = str5;
        this.source = str6;
        this.seoUrl = str7;
        this.metadata = cJRABCHLCategoryWeights;
        this.layout = cJRABCHLLabel;
    }

    public final int getId$recharge_automatic_release() {
        return this.id;
    }

    public final void setId$recharge_automatic_release(int i2) {
        this.id = i2;
    }

    public final String getName$recharge_automatic_release() {
        return this.name;
    }

    public final void setName$recharge_automatic_release(String str) {
        this.name = str;
    }

    public final String getImageUrl$recharge_automatic_release() {
        return this.imageUrl;
    }

    public final void setImageUrl$recharge_automatic_release(String str) {
        this.imageUrl = str;
    }

    public final String getUrlInfo$recharge_automatic_release() {
        return this.urlInfo;
    }

    public final void setUrlInfo$recharge_automatic_release(String str) {
        this.urlInfo = str;
    }

    public final String getUrlType$recharge_automatic_release() {
        return this.urlType;
    }

    public final void setUrlType$recharge_automatic_release(String str) {
        this.urlType = str;
    }

    public final String getUrl$recharge_automatic_release() {
        return this.url;
    }

    public final void setUrl$recharge_automatic_release(String str) {
        this.url = str;
    }

    public final String getSource$recharge_automatic_release() {
        return this.source;
    }

    public final void setSource$recharge_automatic_release(String str) {
        this.source = str;
    }

    public final String getSeoUrl$recharge_automatic_release() {
        return this.seoUrl;
    }

    public final void setSeoUrl$recharge_automatic_release(String str) {
        this.seoUrl = str;
    }

    public final CJRABCHLCategoryWeights getMetadata$recharge_automatic_release() {
        return this.metadata;
    }

    public final void setMetadata$recharge_automatic_release(CJRABCHLCategoryWeights cJRABCHLCategoryWeights) {
        this.metadata = cJRABCHLCategoryWeights;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRABCHLItems(int r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, net.one97.paytm.recharge.domain.entities.CJRABCHLItems.CJRABCHLCategoryWeights r20, net.one97.paytm.recharge.domain.entities.CJRABCHLItems.CJRABCHLLabel r21, int r22, kotlin.g.b.g r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x0009
        L_0x0008:
            r1 = r12
        L_0x0009:
            r2 = r0 & 2
            r3 = 0
            if (r2 == 0) goto L_0x0010
            r2 = r3
            goto L_0x0011
        L_0x0010:
            r2 = r13
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r3
            goto L_0x0018
        L_0x0017:
            r4 = r14
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r3
            goto L_0x001f
        L_0x001e:
            r5 = r15
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r3
            goto L_0x0027
        L_0x0025:
            r6 = r16
        L_0x0027:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002d
            r7 = r3
            goto L_0x002f
        L_0x002d:
            r7 = r17
        L_0x002f:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0035
            r8 = r3
            goto L_0x0037
        L_0x0035:
            r8 = r18
        L_0x0037:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003d
            r9 = r3
            goto L_0x003f
        L_0x003d:
            r9 = r19
        L_0x003f:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0045
            r10 = r3
            goto L_0x0047
        L_0x0045:
            r10 = r20
        L_0x0047:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r3 = r21
        L_0x004e:
            r12 = r11
            r13 = r1
            r14 = r2
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r3
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.domain.entities.CJRABCHLItems.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.recharge.domain.entities.CJRABCHLItems$CJRABCHLCategoryWeights, net.one97.paytm.recharge.domain.entities.CJRABCHLItems$CJRABCHLLabel, int, kotlin.g.b.g):void");
    }

    public final CJRABCHLLabel getLayout$recharge_automatic_release() {
        return this.layout;
    }

    public final void setLayout$recharge_automatic_release(CJRABCHLLabel cJRABCHLLabel) {
        this.layout = cJRABCHLLabel;
    }

    public static final class CJRABCHLCategoryWeights implements IJRDataModel {
        @b(a = "category_weights")
        private ArrayList<CJRABCHLMetadata> categoryWeights;

        public CJRABCHLCategoryWeights() {
            this((ArrayList) null, 1, (g) null);
        }

        public static /* synthetic */ CJRABCHLCategoryWeights copy$default(CJRABCHLCategoryWeights cJRABCHLCategoryWeights, ArrayList<CJRABCHLMetadata> arrayList, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                arrayList = cJRABCHLCategoryWeights.categoryWeights;
            }
            return cJRABCHLCategoryWeights.copy(arrayList);
        }

        public final ArrayList<CJRABCHLMetadata> component1$recharge_automatic_release() {
            return this.categoryWeights;
        }

        public final CJRABCHLCategoryWeights copy(ArrayList<CJRABCHLMetadata> arrayList) {
            return new CJRABCHLCategoryWeights(arrayList);
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof CJRABCHLCategoryWeights) && k.a((Object) this.categoryWeights, (Object) ((CJRABCHLCategoryWeights) obj).categoryWeights);
            }
            return true;
        }

        public final int hashCode() {
            ArrayList<CJRABCHLMetadata> arrayList = this.categoryWeights;
            if (arrayList != null) {
                return arrayList.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "CJRABCHLCategoryWeights(categoryWeights=" + this.categoryWeights + ")";
        }

        public CJRABCHLCategoryWeights(ArrayList<CJRABCHLMetadata> arrayList) {
            this.categoryWeights = arrayList;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CJRABCHLCategoryWeights(ArrayList arrayList, int i2, g gVar) {
            this((i2 & 1) != 0 ? null : arrayList);
        }

        public final ArrayList<CJRABCHLMetadata> getCategoryWeights$recharge_automatic_release() {
            return this.categoryWeights;
        }

        public final void setCategoryWeights$recharge_automatic_release(ArrayList<CJRABCHLMetadata> arrayList) {
            this.categoryWeights = arrayList;
        }
    }

    public static final class CJRABCHLMetadata implements IJRDataModel {
        @b(a = "category_id")
        private String categoryId;
        @b(a = "weight")
        private Integer weight;

        public CJRABCHLMetadata() {
            this((Integer) null, (String) null, 3, (g) null);
        }

        public static /* synthetic */ CJRABCHLMetadata copy$default(CJRABCHLMetadata cJRABCHLMetadata, Integer num, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                num = cJRABCHLMetadata.weight;
            }
            if ((i2 & 2) != 0) {
                str = cJRABCHLMetadata.categoryId;
            }
            return cJRABCHLMetadata.copy(num, str);
        }

        public final Integer component1$recharge_automatic_release() {
            return this.weight;
        }

        public final String component2$recharge_automatic_release() {
            return this.categoryId;
        }

        public final CJRABCHLMetadata copy(Integer num, String str) {
            return new CJRABCHLMetadata(num, str);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CJRABCHLMetadata)) {
                return false;
            }
            CJRABCHLMetadata cJRABCHLMetadata = (CJRABCHLMetadata) obj;
            return k.a((Object) this.weight, (Object) cJRABCHLMetadata.weight) && k.a((Object) this.categoryId, (Object) cJRABCHLMetadata.categoryId);
        }

        public final int hashCode() {
            Integer num = this.weight;
            int i2 = 0;
            int hashCode = (num != null ? num.hashCode() : 0) * 31;
            String str = this.categoryId;
            if (str != null) {
                i2 = str.hashCode();
            }
            return hashCode + i2;
        }

        public final String toString() {
            return "CJRABCHLMetadata(weight=" + this.weight + ", categoryId=" + this.categoryId + ")";
        }

        public CJRABCHLMetadata(Integer num, String str) {
            this.weight = num;
            this.categoryId = str;
        }

        public final Integer getWeight$recharge_automatic_release() {
            return this.weight;
        }

        public final void setWeight$recharge_automatic_release(Integer num) {
            this.weight = num;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CJRABCHLMetadata(Integer num, String str, int i2, g gVar) {
            this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str);
        }

        public final String getCategoryId$recharge_automatic_release() {
            return this.categoryId;
        }

        public final void setCategoryId$recharge_automatic_release(String str) {
            this.categoryId = str;
        }
    }

    public static final class CJRABCHLLabel implements IJRDataModel {
        @b(a = "label")
        private String label;

        public CJRABCHLLabel() {
            this((String) null, 1, (g) null);
        }

        public static /* synthetic */ CJRABCHLLabel copy$default(CJRABCHLLabel cJRABCHLLabel, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = cJRABCHLLabel.label;
            }
            return cJRABCHLLabel.copy(str);
        }

        public final String component1$recharge_automatic_release() {
            return this.label;
        }

        public final CJRABCHLLabel copy(String str) {
            return new CJRABCHLLabel(str);
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof CJRABCHLLabel) && k.a((Object) this.label, (Object) ((CJRABCHLLabel) obj).label);
            }
            return true;
        }

        public final int hashCode() {
            String str = this.label;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "CJRABCHLLabel(label=" + this.label + ")";
        }

        public CJRABCHLLabel(String str) {
            this.label = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CJRABCHLLabel(String str, int i2, g gVar) {
            this((i2 & 1) != 0 ? null : str);
        }

        public final String getLabel$recharge_automatic_release() {
            return this.label;
        }

        public final void setLabel$recharge_automatic_release(String str) {
            this.label = str;
        }
    }
}
