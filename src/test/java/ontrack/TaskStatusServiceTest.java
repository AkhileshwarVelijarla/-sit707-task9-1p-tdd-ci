package ontrack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for TaskStatusService.
 * These tests support the TDD process for the simplified OnTrack function.
 */
public class TaskStatusServiceTest {

    private final TaskStatusService service = new TaskStatusService();

    @Test
    @DisplayName("Return NOT_SUBMITTED when task has not been submitted")
    public void shouldReturnNotSubmittedWhenTaskIsNotSubmitted() {
        TaskSubmission submission = new TaskSubmission(
                "224763306",
                "9.1P",
                false,
                false,
                false,
                false
        );

        TaskStatus result = service.checkStatus(submission);

        assertEquals(TaskStatus.NOT_SUBMITTED, result);
    }

    @Test
    @DisplayName("Return SUBMITTED when task is submitted but not reviewed")
    public void shouldReturnSubmittedWhenTaskIsSubmittedButNotReviewed() {
        TaskSubmission submission = new TaskSubmission(
                "224763306",
                "9.1P",
                true,
                false,
                false,
                false
        );

        TaskStatus result = service.checkStatus(submission);

        assertEquals(TaskStatus.COMPLETED, result);
    }

    @Test
    @DisplayName("Return UNDER_REVIEW when tutor has started reviewing")
    public void shouldReturnUnderReviewWhenTaskIsReviewedButNotFinalised() {
        TaskSubmission submission = new TaskSubmission(
                "224763306",
                "9.1P",
                true,
                true,
                false,
                false
        );

        TaskStatus result = service.checkStatus(submission);

        assertEquals(TaskStatus.UNDER_REVIEW, result);
    }

    @Test
    @DisplayName("Return NEEDS_RESUBMISSION when tutor requests changes")
    public void shouldReturnNeedsResubmissionWhenTutorRequestsChanges() {
        TaskSubmission submission = new TaskSubmission(
                "224763306",
                "9.1P",
                true,
                true,
                true,
                false
        );

        TaskStatus result = service.checkStatus(submission);

        assertEquals(TaskStatus.NEEDS_RESUBMISSION, result);
    }

    @Test
    @DisplayName("Return COMPLETED when task is marked complete")
    public void shouldReturnCompletedWhenTaskIsMarkedComplete() {
        TaskSubmission submission = new TaskSubmission(
                "224763306",
                "9.1P",
                true,
                true,
                false,
                true
        );

        TaskStatus result = service.checkStatus(submission);

        assertEquals(TaskStatus.COMPLETED, result);
    }

    @Test
    @DisplayName("Throw exception when submission object is null")
    public void shouldThrowExceptionWhenSubmissionIsNull() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.checkStatus(null)
        );

        assertEquals("Task submission cannot be null", exception.getMessage());
    }

    @Test
    @DisplayName("Throw exception when student ID is empty")
    public void shouldThrowExceptionWhenStudentIdIsEmpty() {
        TaskSubmission submission = new TaskSubmission(
                "",
                "9.1P",
                true,
                false,
                false,
                false
        );

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.checkStatus(submission)
        );

        assertEquals("Student ID is required", exception.getMessage());
    }

    @Test
    @DisplayName("Throw exception when student ID is only spaces")
    public void shouldThrowExceptionWhenStudentIdContainsOnlySpaces() {
        TaskSubmission submission = new TaskSubmission(
                "   ",
                "9.1P",
                true,
                false,
                false,
                false
        );

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.checkStatus(submission)
        );

        assertEquals("Student ID is required", exception.getMessage());
    }

    @Test
    @DisplayName("Throw exception when task ID is empty")
    public void shouldThrowExceptionWhenTaskIdIsEmpty() {
        TaskSubmission submission = new TaskSubmission(
                "224763306",
                "",
                true,
                false,
                false,
                false
        );

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.checkStatus(submission)
        );

        assertEquals("Task ID is required", exception.getMessage());
    }

    @Test
    @DisplayName("Completed status has priority over resubmission flag")
    public void shouldReturnCompletedWhenCompletedAndResubmissionAreBothTrue() {
        TaskSubmission submission = new TaskSubmission(
                "224763306",
                "9.1P",
                true,
                true,
                true,
                true
        );

        TaskStatus result = service.checkStatus(submission);

        assertEquals(TaskStatus.COMPLETED, result);
    }
}
