package com.postify.accreditation.filter;

import java.util.List;

import com.postify.accreditation.AccreditationRecord;

public interface AccreditationFilter {

    List<AccreditationRecord> filter(List<AccreditationRecord> records);

}
