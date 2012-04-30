package com.postify.accreditation.filter;

import java.util.ArrayList;
import java.util.List;

import com.postify.accreditation.AccreditationRecord;

public class InternshipFilter implements AccreditationFilter {

    public List<AccreditationRecord> filter(
            final List<AccreditationRecord> records) {
        List<AccreditationRecord> filteredRecords = new ArrayList<AccreditationRecord>();

        for (AccreditationRecord record : records) {
            String name = record.getInstitutionName();
            if (name != null
                    && (name.endsWith("Internship") || name
                            .endsWith("internship"))) {
                continue;
            }

            filteredRecords.add(record);
        }

        return filteredRecords;
    }
}
