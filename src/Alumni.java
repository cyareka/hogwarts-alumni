public class Alumni {

    private String AlumniName;
    private int YearGrad;
    private String HonorsAwards;
    private String CompanyNow, Position;
    private String DateHired;

    // DEFAULT & CUSTOM CONSTRUCTORS
    public Alumni() {
        AlumniName = "";
        YearGrad = 0;
        HonorsAwards = "";
        CompanyNow = "";
        Position = "";
        DateHired = "";        
    }
    public Alumni(String alumniName, int yearGrad, String honorsAwards, String companyNow, String position, String dateHired) {
        setAlumniName(alumniName);
        setYearGrad(yearGrad);
        setHonorsAwards(honorsAwards);
        setCompanyNow(companyNow);
        setPosition(position);
        setDateHired(dateHired);
    }

    // ACTIONS


    // GETTERS AND SETTERS
    public String getAlumniName() {
        return AlumniName;
    }
    public void setAlumniName(String alumniName) {
        AlumniName = alumniName.toUpperCase();
    }
    public int getYearGrad() {
        return YearGrad;
    }
    public void setYearGrad(int yearGrad) {
        if (yearGrad < 1900 || yearGrad > 2022) {
            throw new IllegalArgumentException();
        }
        YearGrad = yearGrad;
    }
    public String getHonorsAwards() {
        return HonorsAwards;
    }
    public void setHonorsAwards(String honorsAwards) {  
        HonorsAwards = honorsAwards;
    }
    public String getCompanyNow() {
        return CompanyNow;
    }
    public void setCompanyNow(String companyNow) {
        CompanyNow = companyNow;
    }
    public String getPosition() {
        return Position;
    }
    public void setPosition(String position) {
        Position = position;
    }
    public String getDateHired() {
        return DateHired;
    }
    public void setDateHired(String dateHired) {
        DateHired = dateHired;
    }
    
}