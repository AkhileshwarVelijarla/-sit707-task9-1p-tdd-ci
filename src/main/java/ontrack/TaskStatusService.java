package ontrack;

/**
 * Service class that checks the current status of a simplified OnTrack task submission.
 */
public class TaskStatusService {

    /**
     * Checks the status of a student's task submission.
     *
     * @param submission task submission details
     * @return the current status of the task
     */
    public TaskStatus checkStatus(TaskSubmission submission) {

        validateSubmission(submission);

        if (!submission.isSubmitted()) {
            return TaskStatus.NOT_SUBMITTED;
        }

        if (submission.isCompleted()) {
            return TaskStatus.COMPLETED;
        }

        if (submission.isResubmissionRequired()) {
            return TaskStatus.NEEDS_RESUBMISSION;
        }

        if (submission.isReviewed()) {
            return TaskStatus.UNDER_REVIEW;
        }

        return TaskStatus.SUBMITTED;
    }

    private void validateSubmission(TaskSubmission submission) {
        if (submission == null) {
            throw new IllegalArgumentException("Task submission cannot be null");
        }

        if (isBlank(submission.getStudentId())) {
            throw new IllegalArgumentException("Student ID is required");
        }

        if (isBlank(submission.getTaskId())) {
            throw new IllegalArgumentException("Task ID is required");
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
