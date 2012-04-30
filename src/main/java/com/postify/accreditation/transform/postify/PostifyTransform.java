package com.postify.accreditation.transform.postify;

import java.util.ArrayList;
import java.util.List;

import com.postify.accreditation.transform.AccreditationTransformer;
import com.postify.accreditation.transform.geocode.AccreditationRecordGeo;

public class PostifyTransform implements
        AccreditationTransformer<PostifySchool, AccreditationRecordGeo> {

    public List<PostifySchool> transform(
            final List<AccreditationRecordGeo> records) {
        List<PostifySchool> transformedRecords = new ArrayList<PostifySchool>();

        for (AccreditationRecordGeo rec : records) {
            PostifySchool school = new PostifySchool();

            // Skip empty names
            if (isEmpty(rec.getInstitutionName())) {
                continue;
            }

            // Skip when there are no coordinates
            if (rec.getLat() == 0 || rec.getLng() == 0) {
                continue;
            }

            school.setName(rec.getInstitutionName());
            school.setAddress(rec.getInstitutionAddress());
            school.setCity(rec.getInstitutionCity());
            school.setState(rec.getInstitutionState());
            String zip = rec.getInstitutionZip();
            if (!isEmpty(zip)) {
                if (zip.charAt(0) == '"' && zip.length() > 1) {
                    zip = zip.substring(1);
                }
                if (zip.charAt(zip.length() - 1) == '"') {
                    zip = zip.substring(0, zip.length() - 1);
                }
            }
            school.setZip(zip);
            school.setPhone(rec.getInstitutionPhone());
            school.setUrl(rec.getInstitutionWebAddress());

            school.setLoc(new PostifySchool.Coordinates());
            school.getLoc().setLon(rec.getLng());
            school.getLoc().setLat(rec.getLat());

            transformedRecords.add(school);
        }

        return transformedRecords;
    }

    private boolean isEmpty(final String... vals) {
        for (String val : vals) {
            if (val == null || val.length() == 0) {
                return true;
            }
        }
        return false;
    }
}
