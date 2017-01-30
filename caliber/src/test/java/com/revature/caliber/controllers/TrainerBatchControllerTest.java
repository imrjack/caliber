package com.revature.caliber.controllers;

import com.revature.caliber.beans.Batch;
import org.apache.http.client.utils.URIBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class TrainerBatchControllerTest {
    RestTemplate restTemplate;
    URIBuilder uriBuilder;
    @Before
    public void setUp() throws Exception {
        restTemplate = new RestTemplate();
        uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http")
                .setHost("localhost")
                .setPort(8080);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getAllBatches() throws Exception {
        uriBuilder.setPath("/caliber/trainer/batch/all");
        ResponseEntity<Batch[]> responseEntity
                = restTemplate.getForEntity(uriBuilder.build(),Batch[].class);
        List<Batch> batches = Arrays.asList(responseEntity.getBody());
        assertNotNull(batches);
    }

    @Test
    public void getCurrentBatch() throws Exception {
        uriBuilder.setPath("/caliber/trainer/batch/current");
        ResponseEntity<Batch[]> responseEntity
                = restTemplate.getForEntity(uriBuilder.build(),Batch[].class);
        List<Batch> batches = Arrays.asList(responseEntity.getBody());
        assertNotNull(batches);
    }

    @Test
    public void createNewWeek() throws Exception {

    }

    @Test
    public void createGrade() throws Exception {

    }

    @Test
    public void updateGrade() throws Exception {

    }

    @Test
    public void createAssessment() throws Exception {

    }

    @Test
    public void deleteAssessment() throws Exception {

    }

    @Test
    public void updateAssessment() throws Exception {

    }

    @Test
    public void updateAssessmentNote() throws Exception {

    }

}