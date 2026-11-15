package linked_list.class_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem 3: Round-Robin Lab Scheduler
 *
 * TASK:
 * One lab machine is shared by several jobs. Each job may run for at most one quantum at a time;
 * an unfinished job goes to the back of the line, and a finished job leaves.
 * Implement a LabScheduler that uses a queue of jobs, each storing its remaining time.
 * Print every time slice as Job(start-end) and then each job's finishing time in the order the jobs finish.
 */
public class LabScheduler {

    public static class Job {
        private String name;
        private int remainingTime;

        public Job(String name, int totalTime) {
            this.name = name;
            this.remainingTime = totalTime;
        }

        public String getName() {
            return name;
        }

        public int getRemainingTime() {
            return remainingTime;
        }

        public void reduceTime(int time) {
            this.remainingTime -= time;
        }
    }

    public static class FinishRecord {
        private String name;
        private int finishTime;

        public FinishRecord(String name, int finishTime) {
            this.name = name;
            this.finishTime = finishTime;
        }

        @Override
        public String toString() {
            return name + " " + finishTime;
        }
    }

    public static void runScheduler(int quantum, List<Job> initialJobs) {
        Queue<Job> queue = new LinkedList<>(initialJobs);
        List<String> slices = new ArrayList<>();
        List<FinishRecord> finishOrder = new ArrayList<>();

        int currentTime = 0;

        while (!queue.isEmpty()) {
            Job job = queue.poll();
            int runDuration = Math.min(quantum, job.getRemainingTime());
            int startTime = currentTime;
            currentTime += runDuration;
            int endTime = currentTime;

            slices.add(job.getName() + "(" + startTime + "-" + endTime + ")");
            job.reduceTime(runDuration);

            if (job.getRemainingTime() > 0) {
                queue.offer(job);
            } else {
                finishOrder.add(new FinishRecord(job.getName(), endTime));
            }
        }

        System.out.println(String.join(" ", slices));

        StringBuilder finishSb = new StringBuilder("finish ");
        for (int i = 0; i < finishOrder.size(); i++) {
            finishSb.append(finishOrder.get(i).toString());
            if (i < finishOrder.size() - 1) {
                finishSb.append(", ");
            }
        }
        System.out.println(finishSb.toString());
    }

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("P1", 5));
        jobs.add(new Job("P2", 3));
        jobs.add(new Job("P3", 7));

        runScheduler(3, jobs);
    }
}
