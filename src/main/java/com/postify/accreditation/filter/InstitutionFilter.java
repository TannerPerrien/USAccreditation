package com.postify.accreditation.filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.postify.accreditation.AccreditationRecord;

public class InstitutionFilter implements AccreditationFilter {

    public List<AccreditationRecord> filter(
            final List<AccreditationRecord> records) {
        List<AccreditationRecord> filteredRecords = new ArrayList<AccreditationRecord>();

        Collections.sort(records, new Comparator<AccreditationRecord>() {
            public int compare(final AccreditationRecord o1,
                    final AccreditationRecord o2) {
                return (int) (o1.getInstitutionId() - o2.getInstitutionId());
            }
        });

        long lastId = -1;
        for (AccreditationRecord record : records) {
            if (record.getInstitutionId() == lastId) {
                continue;
            }

            lastId = record.getInstitutionId();
            filteredRecords.add(record);
        }
        return filteredRecords;
    }

}
