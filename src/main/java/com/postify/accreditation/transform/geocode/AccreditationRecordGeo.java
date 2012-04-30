package com.postify.accreditation.transform.geocode;

import com.postify.accreditation.AccreditationRecord;

public class AccreditationRecordGeo extends AccreditationRecord {

    private double lat;

    private double lng;

    public AccreditationRecordGeo(final AccreditationRecord rec) {
        super(rec);
    }

    public double getLat() {
        return lat;
    }

    public void setLat(final double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(final double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return super.toString() + " [" + lat + ", " + lng + "]";
    }

}
