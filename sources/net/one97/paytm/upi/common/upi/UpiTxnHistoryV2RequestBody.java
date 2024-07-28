package net.one97.paytm.upi.common.upi;

import net.one97.paytm.upi.common.UpiBaseDataModel;

public class UpiTxnHistoryV2RequestBody implements UpiBaseDataModel {
    private FilterRequest filter;
    private int pageNo;
    private int pageSize;
    private SortRequest sort;

    public void setPageNo(int i2) {
        this.pageNo = i2;
    }

    public void setPageSize(int i2) {
        this.pageSize = i2;
    }

    public void setFilter(FilterRequest filterRequest) {
        this.filter = filterRequest;
    }

    public void setSort(SortRequest sortRequest) {
        this.sort = sortRequest;
    }

    public static class EntityInvolvedRequest {
        private String field;
        private String value;

        public void setField(String str) {
            this.field = str;
        }

        public void setValue(String str) {
            this.value = str;
        }
    }

    public static class FilterRequest {
        private Amount_Request amount;
        private Date_Request date;
        private EntityInvolvedRequest entityInvolved;
        private String status;
        private String transactionCategory;
        private String transactionId;
        private String transactionType;

        public void setTransactionType(String str) {
            this.transactionType = str;
        }

        public void setEntityInvolved(EntityInvolvedRequest entityInvolvedRequest) {
            this.entityInvolved = entityInvolvedRequest;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public void setTransactionCategory(String str) {
            this.transactionCategory = str;
        }

        public void setDate(Date_Request date_Request) {
            this.date = date_Request;
        }

        public void setAmount(Amount_Request amount_Request) {
            this.amount = amount_Request;
        }

        public void setTransactionId(String str) {
            this.transactionId = str;
        }
    }

    public static class SortRequest {
        private String order;
        private String param;

        public void setParam(String str) {
            this.param = str;
        }

        public void setOrder(String str) {
            this.order = str;
        }
    }

    public static class Amount_Request {
        private long gte;
        private long lte;

        public void setGte(long j) {
            this.gte = j;
        }

        public void setLte(long j) {
            this.lte = j;
        }
    }

    public static class Date_Request {
        private long gte;
        private long lte;

        public void setGte(long j) {
            this.gte = j;
        }

        public void setLte(long j) {
            this.lte = j;
        }
    }
}
