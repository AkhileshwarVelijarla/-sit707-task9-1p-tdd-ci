package ontrack;

/**
 * Simple model class that stores information about a student's OnTrack task submission.
 */
public class TaskSubmission {

    private final String studentId;
    private final String taskId;
    private final boolean submitted;
    private final boolean reviewed;
    private final boolean resubmissionRequired;
    private final boolean completed;

    public TaskSubmission(String studentId,
                          String taskId,
                          boolean submitted,
                          boolean reviewed,
                          boolean resubmissionRequired,
                          boolean completed) {
        this.studentId = studentId;
        this.taskId = taskId;
        this.submitted = submitted;
        this.reviewed = reviewed;
        this.resubmissionRequired = resubmissionRequired;
        this.completed = completed;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getTaskId() {
        return taskId;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public boolean isReviewed() {
        return reviewed;
    }

    public boolean isResubmissionRequired() {
        return resubmissionRequired;
    }

    public boolean isCompleted() {
        return completed;
    }
}
