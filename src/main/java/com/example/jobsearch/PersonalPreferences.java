package com.example.jobsearch;

import android.os.Parcel;
import android.os.Parcelable;

class PersonalPreferences implements Parcelable {
    private String workEnvironment;
    private String workStyle;
    private String adaptability;
    private String companyValues;
    private String feedbackStyle;
    private String workSchedule;
    private String communicationStyle;
    private String conflictResolution;
    private String leadershipStyle;
    private String managementPreference;

    public PersonalPreferences() {
        // Default constructor required for Parcelable
    }

    protected PersonalPreferences(Parcel in) {
        workEnvironment = in.readString();
        workStyle = in.readString();
        adaptability = in.readString();
        companyValues = in.readString();
        feedbackStyle = in.readString();
        workSchedule = in.readString();
        communicationStyle = in.readString();
        conflictResolution = in.readString();
        leadershipStyle = in.readString();
        managementPreference = in.readString();
    }

    public static final Creator<PersonalPreferences> CREATOR = new Creator<PersonalPreferences>() {
        @Override
        public PersonalPreferences createFromParcel(Parcel in) {
            return new PersonalPreferences(in);
        }

        @Override
        public PersonalPreferences[] newArray(int size) {
            return new PersonalPreferences[size];
        }
    };

    public String getWorkEnvironment() {
        return workEnvironment;
    }

    public void setWorkEnvironment(String workEnvironment) {
        this.workEnvironment = workEnvironment;
    }

    public String getWorkStyle() {
        return workStyle;
    }

    public void setWorkStyle(String workStyle) {
        this.workStyle = workStyle;
    }

    public String getAdaptability() {
        return adaptability;
    }

    public void setAdaptability(String adaptability) {
        this.adaptability = adaptability;
    }

    public String getCompanyValues() {
        return companyValues;
    }

    public void setCompanyValues(String companyValues) {
        this.companyValues = companyValues;
    }

    public String getFeedbackStyle() {
        return feedbackStyle;
    }

    public void setFeedbackStyle(String feedbackStyle) {
        this.feedbackStyle = feedbackStyle;
    }

    public String getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(String workSchedule) {
        this.workSchedule = workSchedule;
    }

    public String getCommunicationStyle() {
        return communicationStyle;
    }

    public void setCommunicationStyle(String communicationStyle) {
        this.communicationStyle = communicationStyle;
    }

    public String getConflictResolution() {
        return conflictResolution;
    }

    public void setConflictResolution(String conflictResolution) {
        this.conflictResolution = conflictResolution;
    }

    public String getLeadershipStyle() {
        return leadershipStyle;
    }

    public void setLeadershipStyle(String leadershipStyle) {
        this.leadershipStyle = leadershipStyle;
    }

    public String getManagementPreference() {
        return managementPreference;
    }

    public void setManagementPreference(String managementPreference) {
        this.managementPreference = managementPreference;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(workEnvironment);
        dest.writeString(workStyle);
        dest.writeString(adaptability);
        dest.writeString(companyValues);
        dest.writeString(feedbackStyle);
        dest.writeString(workSchedule);
        dest.writeString(communicationStyle);
        dest.writeString(conflictResolution);
        dest.writeString(leadershipStyle);
        dest.writeString(managementPreference);
    }
}

