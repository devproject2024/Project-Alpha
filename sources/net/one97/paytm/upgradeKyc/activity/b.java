package net.one97.paytm.upgradeKyc.activity;

public interface b {

    public enum c {
        House_Wife
    }

    public enum d {
        NO_NETWORK,
        LOW,
        AVERAGE,
        ACCEPTABLE,
        EXCEPTION
    }

    public enum e {
        PROFESSIONAL,
        GOVERNMENT_JOB,
        PRIVATE_SECTOR_JOB,
        PUBLIC_SECTOR_JOB,
        BUSINESS,
        STUDENT,
        HOUSE_WIFE,
        RETIRED,
        SELF_EMPLOYED,
        OTHERS
    }

    public enum f {
        Architect,
        Chartered_Accountant,
        Doctor,
        IT_Consultant,
        Lawyer,
        Real_Estate_Broking,
        Share_Broking
    }

    public enum g {
        Government_Job,
        NGO,
        Private_Sector_Job,
        Public_Sector_Job,
        Self_Employed
    }

    public enum h {
        GOVERNMENT_JOB,
        PRIVATE_SECTOR_JOB,
        PUBLIC_SECTOR_JOB,
        NGO
    }

    public enum i {
        Consultancy,
        Importer,
        Manufacturer,
        NGO,
        Personal,
        Retailer,
        Trader,
        Wholesaler
    }

    public enum j {
        College_Student,
        School_Student
    }

    public enum k {
        Unemployed
    }

    public enum l {
        SALARIED,
        SELF_EMPLOYED_OWN_BUSINESS,
        RETIRED,
        PROFESSIONAL_SELF_EMPLOYED,
        STUDENT,
        UNEMPLOYED,
        HOUSE_WIFE
    }

    public enum a {
        PROFESSIONAL("professional"),
        GOVERNMENT_JOB("government job"),
        PRIVATE_SECTOR_JOB("private sector job"),
        PUBLIC_SECTOR_JOB("public sector job"),
        BUSINESS("business"),
        STUDENT("student"),
        HOUSE_WIFE("house wife"),
        RETIRED("retired"),
        SELF_EMPLOYED("self employed"),
        OTHERS("others");
        
        private String profession;

        private a(String str) {
            this.profession = str;
        }

        public final String getName() {
            return this.profession;
        }

        public final String toString() {
            return this.profession;
        }
    }

    /* renamed from: net.one97.paytm.upgradeKyc.activity.b$b  reason: collision with other inner class name */
    public enum C1292b {
        lac1("0–2.5 lacs"),
        lac2("2.5–5 lacs"),
        lac3("5–10 lacs"),
        lac4("10–50 lacs"),
        lac5(">50 lacs");
        
        private String income;

        private C1292b(String str) {
            this.income = str;
        }

        public final String getName() {
            return this.income;
        }

        public final String toString() {
            return this.income;
        }
    }
}
