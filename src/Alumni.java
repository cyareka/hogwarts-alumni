import java.io.Serializable;

public class Alumni implements Serializable {

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
    public Alumni(String companyNow, String position, String dateHired) {
        getAlumniName();
        getYearGrad();
        getHonorsAwards();
        setCompanyNow(companyNow);
        setPosition(position);
        setDateHired(dateHired);
    }

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
        HonorsAwards = honorsAwards.toUpperCase();
    }
    public String getCompanyNow() {
        return CompanyNow;
    }
    public void setCompanyNow(String companyNow) {
        CompanyNow = companyNow.toUpperCase();
    }
    public String getPosition() {
        return Position;
    }
    public void setPosition(String position) {
        Position = position.toUpperCase();
    }
    public String getDateHired() {
        return DateHired;
    }
    public void setDateHired(String dateHired) {
        DateHired = dateHired;
    }

    @Override
    public String toString() {
        return "Name: " + AlumniName + "\n" +
        ("Year Graduated: " + YearGrad + "\n") +
        ("Current Company: " + CompanyNow + "\n") + 
        ("Position: " + Position + "\n") +
        ("Date Hired: " + DateHired + "\n");
    }
}