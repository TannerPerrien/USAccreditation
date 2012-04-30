package com.postify.accreditation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.postify.accreditation.filter.AccreditationFilter;
import com.postify.accreditation.filter.InstitutionFilter;
import com.postify.accreditation.filter.InternshipFilter;
import com.postify.accreditation.transform.geocode.AccreditationRecordGeo;
import com.postify.accreditation.transform.geocode.GeoCodeTransform;
import com.postify.accreditation.transform.postify.PostifySchool;
import com.postify.accreditation.transform.postify.PostifyTransform;

public class Application {

    /**
     * Entry point for the app.
     * 
     * @param args
     */
    public static void main(final String[] args) {
        AccreditationParser parser = new AccreditationParser(
                "/tcl/USAccreditation/data/Accreditation_2012_03.csv");
        GsonBuilder gsonBuilder = new GsonBuilder().disableHtmlEscaping();
        Gson gson = gsonBuilder.create();

        try {
            // Parse
            parser.parse();
            List<AccreditationRecord> rawRecords = parser.getRecords();

            // Filter
            List<AccreditationFilter> filters = new ArrayList<AccreditationFilter>();
            filters.add(new InstitutionFilter());
            filters.add(new InternshipFilter());

            List<AccreditationRecord> filteredRecords = new ArrayList<AccreditationRecord>(
                    rawRecords);
            for (AccreditationFilter filter : filters) {
                filteredRecords = filter.filter(filteredRecords);
            }

            // Transform
            // Geo
            GeoCodeTransform geoTransformer = new GeoCodeTransform();
            List<AccreditationRecordGeo> geoResults = geoTransformer
                    .transform(filteredRecords);
            // Save geo
            saveJson("AccreditationRecordsGeo.json", geoResults, gson);

            // Positfy
            PostifyTransform postifyTransformer = new PostifyTransform();
            List<PostifySchool> postifySchools = postifyTransformer
                    .transform(geoResults);
            // Save postify
            saveJson("PostifySchools.json", postifySchools, gson);

            // Print out
            // for (PostifySchool record : postifySchools) {
            // System.out.println(record);
            // }

            System.out.println("Raw record count: " + rawRecords.size());
            System.out.println("Filtered Record count: "
                    + filteredRecords.size());
            System.out.println("Transformed GeoRecord count: "
                    + geoResults.size());
            System.out.println("Transformed Postify School count: "
                    + postifySchools.size());
        } catch (AccreditationException e) {
            e.printStackTrace();
        }
    }

    private static void saveJson(final String filename, final Object obj,
            final Gson gson) {
        File file = new File(filename);
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            gson.toJson(obj, writer);
        } catch (IOException e) {
            System.out.println("Error writing JSON file: "
                    + file.getAbsolutePath());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    // Ignore
                }
            }
        }
    }
}
