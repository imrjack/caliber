--------------------------------------------------------
-- Guts out all of the test data to prepare for next test
-- Author: Patrick Walsh
--------------------------------------------------------

DROP SEQUENCE IF EXISTS ASSESSMENT_ID_SEQUENCE;
DROP SEQUENCE IF EXISTS ADDRESS_ID_SEQUENCE;
DROP SEQUENCE IF EXISTS BATCH_ID_SEQUENCE;
DROP SEQUENCE IF EXISTS CATEGORY_ID_SEQUENCE;
DROP SEQUENCE IF EXISTS GRADE_ID_SEQUENCE;
DROP SEQUENCE IF EXISTS NOTE_ID_SEQUENCE;
DROP SEQUENCE IF EXISTS TRAINEE_ID_SEQUENCE;
DROP SEQUENCE IF EXISTS TRAINER_ID_SEQUENCE;

DELETE FROM CALIBER_GRADE;
DELETE FROM CALIBER_NOTE;
DELETE FROM CALIBER_ASSESSMENT;
DELETE FROM CALIBER_CATEGORY;
DELETE FROM CALIBER_TRAINEE;
DELETE FROM CALIBER_BATCH;
DELETE FROM CALIBER_TRAINER;
DELETE FROM CALIBER_ADDRESS;
COMMIT;
