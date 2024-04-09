package com.example.jobsearch;

public class CompanyRequirements {
    private int workingDaysPerWeek;
    private int workingHoursPerDay;
    private String salaryRange;
    private String perksProvided;
    private String holidaysPolicy;
    private String leavesPolicy;

    public CompanyRequirements() {
        // Default constructor
    }

    public CompanyRequirements(int workingDaysPerWeek, int workingHoursPerDay, String salaryRange,
                               String perksProvided, String holidaysPolicy, String leavesPolicy) {
        this.workingDaysPerWeek = workingDaysPerWeek;
        this.workingHoursPerDay = workingHoursPerDay;
        this.salaryRange = salaryRange;
        this.perksProvided = perksProvided;
        this.holidaysPolicy = holidaysPolicy;
        this.leavesPolicy = leavesPolicy;
    }

    public int getWorkingDaysPerWeek() {
        return workingDaysPerWeek;
    }

    public void setWorkingDaysPerWeek(int workingDaysPerWeek) {
        this.workingDaysPerWeek = workingDaysPerWeek;
    }

    public int getWorkingHoursPerDay() {
        return workingHoursPerDay;
    }

    public void setWorkingHoursPerDay(int workingHoursPerDay) {
        this.workingHoursPerDay = workingHoursPerDay;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public String getPerksProvided() {
        return perksProvided;
    }

    public void setPerksProvided(String perksProvided) {
        this.perksProvided = perksProvided;
    }

    public String getHolidaysPolicy() {
        return holidaysPolicy;
    }

    public void setHolidaysPolicy(String holidaysPolicy) {
        this.holidaysPolicy = holidaysPolicy;
    }

    public String getLeavesPolicy() {
        return leavesPolicy;
    }

    public void setLeavesPolicy(String leavesPolicy) {
        this.leavesPolicy = leavesPolicy;
    }
}
