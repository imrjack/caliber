package com.revature.caliber.test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.caliber.CaliberTest;
import com.revature.caliber.beans.Note;
import com.revature.caliber.data.NoteDAO;
import com.revature.caliber.beans.QCStatus;

public class NoteDAOTest extends CaliberTest {
	
	@Autowired
	NoteDAO noteDAO;
	
	private static final Logger log = Logger.getLogger(NoteDAOTest.class);
	private static final int TEST_BATCH_ID = 2201;
	private static final int TEST_WEEK=7;
	private static final int TEST_TRAINEE_ID=5524;
	
	@Autowired
	private NoteDAO noteDao;
	
	@Test
	public void testFindTraineeNote(){
		log.trace("Testing findTraineeNote");
		final int traineeID = 5350;
		final int weekNum = 2;
		final String content = "Superstar. Impeccable project, very strong technically.";
		
		Note actual = noteDao.findTraineeNote(traineeID, weekNum);

		assertFalse(actual.isQcFeedback());
		assertEquals(content, actual.getContent());
		assertEquals(weekNum, actual.getWeek());
		assertEquals(traineeID, actual.getTrainee().getTraineeId());
	}
	
	@Test
	public void testFindQCTraineeNote(){
		log.trace("Testing findQCTraineeNote");
		final int traineeID = 5532;
		final int weekNum = 3;
		final QCStatus status = QCStatus.Good;
		
		Note actual = noteDao.findQCTraineeNote(traineeID, weekNum);

		assertTrue(actual.isQcFeedback());
		assertEquals(status, actual.getQcStatus());
		assertEquals(weekNum, actual.getWeek());
		assertEquals(traineeID, actual.getTrainee().getTraineeId());
	}
	
	@Test
	public void testFindQCBatchNotes(){
		log.trace("Testing findQCBatchNotes");
		final int batchId = 2201;
		final int week = 5;
		
		Note actual = noteDao.findQCBatchNotes(batchId, week);
		
		assertEquals(batchId, actual.getBatch().getBatchId());
		assertEquals(week, actual.getWeek());
	}
	
	@Test
	public void testFindAllBatchQcNotes(){
		log.trace("Testing findAllBatchQcNotes");
		final int batchId = 2201;
		final int batchSize = 7;
		
		List<Note> actual = noteDao.findAllBatchQcNotes(batchId);
		
		assertEquals(batchSize, actual.size());
	}
	
	@Test	
	public void findAllQCBatchNotes(){
		log.trace("GETTING ALL QC BATCH NOTES");
		List<Note> notes = noteDAO.findAllQCBatchNotes(TEST_BATCH_ID);
		
		int[] expected = {6369,6390,6391,6420,6438,6457,6470};
		assertTrue(notes.size()>0);
		for(int j = 0; j<expected.length; j++){
		assertEquals(expected[j], notes.get(j).getNoteId());
		}
	}
	
	@Test	
	public void findAllQCTraineeNotes(){
		log.trace("GETTING ALL QC TRAINEE NOTES");
		List<Note> notes = noteDAO.findAllQCTraineeNotes(TEST_BATCH_ID, TEST_WEEK);
		assertTrue(notes.size()>0);
		int[] expected = {6459,6460,6461,6462,6463,6464,6465,6466,6467,6468,6469,6471,6472,6473,6474,6475};
		for(int j = 0; j<expected.length; j++){
			assertEquals(expected[j], notes.get(j).getNoteId());
		}
	}
	
	
	@Test	
	public void findAllQCTraineeOverallNotes(){
		log.trace("GETTING ALL QC TRAINEE OVERALL NOTES");
		List<Note> notes = noteDAO.findAllQCTraineeOverallNotes(TEST_TRAINEE_ID);
		assertTrue(notes.size()>0);
		int[] expected = {6355,6381,6394,6439,6423,6453,6463};
		for(int j = 0; j<expected.length; j++){
			assertEquals(expected[j], notes.get(j).getNoteId());
		}
	}
	
}
