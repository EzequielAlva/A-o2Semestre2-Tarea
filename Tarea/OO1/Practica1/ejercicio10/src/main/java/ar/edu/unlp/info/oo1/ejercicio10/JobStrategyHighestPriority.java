package ar.edu.unlp.info.oo1.ejercicio10;

import java.util.List;

public class JobStrategyHighestPriority extends JobScheduler{

    public JobStrategyHighestPriority(List<JobDescription> jobs) {
        this.jobs = jobs;
    }

    @Override
    public JobDescription next() {
        JobDescription nextJob = null;
        nextJob = this.jobs.stream()
                .max((j1,j2) -> Double.compare(j1.getPriority(), j2.getPriority()))
                .orElse(null);
        this.unschedule(nextJob);
        return nextJob;
    }
}
