package com.postify.accreditation.transform.geocode;

import geo.google.GeoAddressStandardizer;
import geo.google.GeoException;
import geo.google.datamodel.GeoUsAddress;

import java.util.ArrayList;
import java.util.List;

import com.postify.accreditation.AccreditationRecord;
import com.postify.accreditation.transform.AccreditationTransformer;

public class GeoCodeTransform implements
        AccreditationTransformer<AccreditationRecordGeo, AccreditationRecord> {

    public List<AccreditationRecordGeo> transform(
            final List<AccreditationRecord> records) {
        List<AccreditationRecordGeo> transformedRecords = new ArrayList<AccreditationRecordGeo>();

        GeoAddressStandardizer geo = new GeoAddressStandardizer(
                "AIzaSyC-w0AxF91sGdycXdRz-iVrFnGfHvOQZ98", 3500);
        // Speed limit = 86,400 / 25,000 = 3.456

        for (AccreditationRecord oldRecord : records) {
            AccreditationRecordGeo record = new AccreditationRecordGeo(
                    oldRecord);
            String address = record.getInstitutionAddress();
            String city = record.getInstitutionCity();
            String state = record.getInstitutionState();
            String zip = record.getInstitutionZip();

            StringBuilder formattedAddress = new StringBuilder();
            if (address != null) {
                formattedAddress.append(address);
                if (city != null && city.length() > 0 && state != null
                        && state.length() > 0) {
                    formattedAddress.append(" ").append(city).append(", ")
                            .append(state);
                }

                if (zip != null && zip.length() > 0) {
                    formattedAddress.append(" ").append(zip);
                }

                try {
                    List<GeoUsAddress> addresses = geo
                            .standardizeToGeoUsAddresses(formattedAddress
                                    .toString());
                    if (addresses != null && addresses.size() > 0) {
                        GeoUsAddress geoAddress = addresses.get(0);
                        record.setLat(geoAddress.getCoordinate().getLatitude());
                        record.setLng(geoAddress.getCoordinate().getLongitude());
                    }

                    transformedRecords.add(record);
                } catch (GeoException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Did not have address for: " + oldRecord);
            }
        }

        return transformedRecords;
    }

}
