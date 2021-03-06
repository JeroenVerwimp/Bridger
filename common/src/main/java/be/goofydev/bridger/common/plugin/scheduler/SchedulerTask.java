package be.goofydev.bridger.common.plugin.scheduler;

/**
 * Represents a scheduled task
 */
public interface SchedulerTask {
    /**
     * Cancel the task.
     */
    void cancel();
}

