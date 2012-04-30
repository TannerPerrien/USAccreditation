package com.postify.accreditation;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class AccreditationParser {

    private static final String INSTITUTION_ID = "Institution_ID";
    private static final String INSTITUTION_NAME = "Institution_Name";
    private static final String INSTITUTION_ADDRESS = "Institution_Address";
    private static final String INSTITUTION_CITY = "Institution_City";
    private static final String INSTITUTION_STATE = "Institution_State";
    private static final String INSTITUTION_ZIP = "Institution_Zip";
    private static final String INSTITUTION_PHONE = "Institution_Phone";
    private static final String INSTITUTION_OPEID = "Institution_OPEID";
    private static final String INSTITUTION_IPEDS_UNIT_ID = "Institution_IPEDS_UnitID";
    private static final String INSTITUTION_WEB_ADDRESS = "Institution_Web_Address";
    private static final String CAMPUS_ID = "Campus_ID";
    private static final String CAMPUS_NAME = "Campus_Name";
    private static final String CAMPUS_ADDRESS = "Campus_Address";
    private static final String CAMPUS_CITY = "Campus_City";
    private static final String CAMPUS_STATE = "Campus_State";
    private static final String CAMPUS_ZIP = "Campus_Zip";
    private static final String CAMPUS_IPEDS_UNIT_ID = "Campus_IPEDS_UnitID";
    private static final String ACCREDITATION_TYPE = "Accreditation_Type";
    private static final String AGENCY_NAME = "Agency_Name";
    private static final String AGENCY_STATUS = "Agency_Status";
    private static final String PROGRAM_NAME = "Program_Name";
    private static final String ACCREDITATION_STATUS = "Accreditation_Status";
    private static final String ACCREDITATION_DATA_TYPE = "Accreditation_Date_Type";
    private static final String PERIODS = "Periods";
    private static final String LAST_ACTION = "Last Action";

    private String filePath;

    private List<AccreditationRecord> records;

    public AccreditationParser(final String filePath) {
        this.filePath = filePath;
    }

    public void parse() throws AccreditationException {
        records = new ArrayList<AccreditationRecord>();

        try {
            FileReader fr = new FileReader(filePath);
            CSVParser parser = new CSVParser(fr, CSVFormat.EXCEL.withHeader());
            for (CSVRecord row : parser.getRecords()) {
                AccreditationRecord rec = new AccreditationRecord();
                try {
                    rec.setInstitutionId(Long.valueOf(row.get(INSTITUTION_ID)));
                } catch (NumberFormatException e) {
                    System.out.println("ID Error");
                }
                rec.setInstitutionName(row.get(INSTITUTION_NAME));
                rec.setInstitutionAddress(row.get(INSTITUTION_ADDRESS));
                rec.setInstitutionCity(row.get(INSTITUTION_CITY));
                rec.setInstitutionState(row.get(INSTITUTION_STATE));
                rec.setInstitutionZip(row.get(INSTITUTION_ZIP));
                rec.setInstitutionPhone(row.get(INSTITUTION_PHONE));
                rec.setInstitutionOPEID(row.get(INSTITUTION_OPEID));
                rec.setInstitutionIPEDSUnitID(row
                        .get(INSTITUTION_IPEDS_UNIT_ID));
                rec.setInstitutionWebAddress(row.get(INSTITUTION_WEB_ADDRESS));
                try {
                    rec.setCampusId(Long.valueOf(row.get(CAMPUS_ID)));
                } catch (NumberFormatException e) {
                    // System.out.println("Warning: No Campus ID");
                }
                rec.setCampusName(row.get(CAMPUS_NAME));
                rec.setCampusAddress(row.get(CAMPUS_ADDRESS));
                rec.setCampusCity(row.get(CAMPUS_CITY));
                rec.setCampusState(row.get(CAMPUS_STATE));
                rec.setCampusZip(row.get(CAMPUS_ZIP));
                rec.setCampusIPEDSUnitID(row.get(CAMPUS_IPEDS_UNIT_ID));
                rec.setAccreditationType(row.get(ACCREDITATION_TYPE));
                rec.setAgencyName(row.get(AGENCY_NAME));
                rec.setAgencyStatus(row.get(AGENCY_STATUS));
                rec.setProgramName(row.get(PROGRAM_NAME));
                rec.setAccreditationStatus(row.get(ACCREDITATION_STATUS));
                rec.setAccreditationDataType(row.get(ACCREDITATION_DATA_TYPE));
                rec.setPeriods(row.get(PERIODS));
                rec.setLastAction(row.get(LAST_ACTION));
                records.add(rec);
            }
        } catch (final Exception e) {
            throw new AccreditationException(e);
        }
    }

    public List<AccreditationRecord> getRecords() {
        return records;
    }
}
