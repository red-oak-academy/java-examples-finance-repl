package academy.redoak.financerepl.model;

public class CompanyProfile {
    private String symbol;
    private Profile profile;

    public static class Profile {
        private double price;
        private String changesPercentage;
        private String companyName;

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getChangesPercentage() {
            return changesPercentage;
        }

        public void setChangesPercentage(String changesPercentage) {
            this.changesPercentage = changesPercentage;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
