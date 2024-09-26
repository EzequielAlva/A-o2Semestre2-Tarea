package ar.edu.unlp.info.oo1.ejercicio10;

import java.util.List;

public class JobStrategyFifo extends JobScheduler{
    public JobStrategyFifo(List<JobDescription> jobs) {
        this.jobs = jobs;
    }

    @Override
    public JobDescription next() {
        JobDescription nextJob = null;
        nextJob = this.jobs.get(0);
        this.unschedule(nextJob);
        return nextJob;
    }
}
