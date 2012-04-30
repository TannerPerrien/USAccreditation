package com.postify.accreditation;

public class AccreditationRecord {

    private long institutionId;
    private String institutionName;
    private String institutionAddress;
    private String institutionCity;
    private String institutionState;
    private String institutionZip;
    private String institutionPhone;
    private String institutionOPEID;
    private String institutionIPEDSUnitID;
    private String institutionWebAddress;
    private long campusId;
    private String campusName;
    private String campusAddress;
    private String campusCity;
    private String campusState;
    private String campusZip;
    private String campusIPEDSUnitID;
    private String accreditationType;
    private String agencyName;
    private String agencyStatus;
    private String programName;
    private String accreditationStatus;
    private String accreditationDataType;
    private String periods;
    private String lastAction;

    public AccreditationRecord() {

    }

    public AccreditationRecord(final AccreditationRecord rec) {
        this.institutionId = rec.institutionId;
        this.institutionName = rec.institutionName;
        this.institutionAddress = rec.institutionAddress;
        this.institutionCity = rec.institutionCity;
        this.institutionState = rec.institutionState;
        this.institutionZip = rec.institutionZip;
        this.institutionPhone = rec.institutionPhone;
        this.institutionOPEID = rec.institutionOPEID;
        this.institutionIPEDSUnitID = rec.institutionIPEDSUnitID;
        this.institutionWebAddress = rec.institutionWebAddress;
        this.campusId = rec.campusId;
        this.campusName = rec.campusName;
        this.campusAddress = rec.campusAddress;
        this.campusCity = rec.campusCity;
        this.campusState = rec.campusState;
        this.campusZip = rec.campusZip;
        this.campusIPEDSUnitID = rec.campusIPEDSUnitID;
        this.accreditationType = rec.accreditationType;
        this.agencyName = rec.agencyName;
        this.programName = rec.programName;
        this.accreditationStatus = rec.accreditationStatus;
        this.accreditationDataType = rec.accreditationDataType;
        this.periods = rec.periods;
        this.lastAction = rec.lastAction;
    }

    public long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(final long institutionId) {
        this.institutionId = institutionId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(final String institutionName) {
        this.institutionName = institutionName;
    }

    public String getInstitutionAddress() {
        return institutionAddress;
    }

    public void setInstitutionAddress(final String institutionAddress) {
        this.institutionAddress = institutionAddress;
    }

    public String getInstitutionCity() {
        return institutionCity;
    }

    public void setInstitutionCity(final String institutionCity) {
        this.institutionCity = institutionCity;
    }

    public String getInstitutionState() {
        return institutionState;
    }

    public void setInstitutionState(final String institutionState) {
        this.institutionState = institutionState;
    }

    public String getInstitutionZip() {
        return institutionZip;
    }

    public void setInstitutionZip(final String institutionZip) {
        this.institutionZip = institutionZip;
    }

    public String getInstitutionPhone() {
        return institutionPhone;
    }

    public void setInstitutionPhone(final String institutionPhone) {
        this.institutionPhone = institutionPhone;
    }

    public String getInstitutionOPEID() {
        return institutionOPEID;
    }

    public void setInstitutionOPEID(final String institutionOPEID) {
        this.institutionOPEID = institutionOPEID;
    }

    public String getInstitutionIPEDSUnitID() {
        return institutionIPEDSUnitID;
    }

    public void setInstitutionIPEDSUnitID(final String institutionIPEDSUnitID) {
        this.institutionIPEDSUnitID = institutionIPEDSUnitID;
    }

    public String getInstitutionWebAddress() {
        return institutionWebAddress;
    }

    public void setInstitutionWebAddress(final String institutionWebAddress) {
        this.institutionWebAddress = institutionWebAddress;
    }

    public long getCampusId() {
        return campusId;
    }

    public void setCampusId(final long campusId) {
        this.campusId = campusId;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(final String campusName) {
        this.campusName = campusName;
    }

    public String getCampusAddress() {
        return campusAddress;
    }

    public void setCampusAddress(final String campusAddress) {
        this.campusAddress = campusAddress;
    }

    public String getCampusCity() {
        return campusCity;
    }

    public void setCampusCity(final String campusCity) {
        this.campusCity = campusCity;
    }

    public String getCampusState() {
        return campusState;
    }

    public void setCampusState(final String campusState) {
        this.campusState = campusState;
    }

    public String getCampusZip() {
        return campusZip;
    }

    public void setCampusZip(final String campusZip) {
        this.campusZip = campusZip;
    }

    public String getCampusIPEDSUnitID() {
        return campusIPEDSUnitID;
    }

    public void setCampusIPEDSUnitID(final String campusIPEDSUnitID) {
        this.campusIPEDSUnitID = campusIPEDSUnitID;
    }

    public String getAccreditationType() {
        return accreditationType;
    }

    public void setAccreditationType(final String accreditationType) {
        this.accreditationType = accreditationType;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(final String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyStatus() {
        return agencyStatus;
    }

    public void setAgencyStatus(final String agencyStatus) {
        this.agencyStatus = agencyStatus;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(final String programName) {
        this.programName = programName;
    }

    public String getAccreditationStatus() {
        return accreditationStatus;
    }

    public void setAccreditationStatus(final String accreditationStatus) {
        this.accreditationStatus = accreditationStatus;
    }

    public String getAccreditationDataType() {
        return accreditationDataType;
    }

    public void setAccreditationDataType(final String accreditationDataType) {
        this.accreditationDataType = accreditationDataType;
    }

    public String getPeriods() {
        return periods;
    }

    public void setPeriods(final String periods) {
        this.periods = periods;
    }

    public String getLastAction() {
        return lastAction;
    }

    public void setLastAction(final String lastAction) {
        this.lastAction = lastAction;
    }

    @Override
    public String toString() {
        return institutionId + " - " + institutionName;
    }

}
