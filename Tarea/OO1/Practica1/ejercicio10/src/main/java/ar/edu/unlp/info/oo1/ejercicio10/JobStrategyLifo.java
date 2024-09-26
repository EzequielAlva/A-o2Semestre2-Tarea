package ar.edu.unlp.info.oo1.ejercicio10;

import java.util.List;

public class JobStrategyLifo extends JobScheduler{
    public JobStrategyLifo(List<JobDescription> jobs) {
        this.jobs = jobs;
    }

    @Override
    public JobDescription next() {
        JobDescription nextJob = null;
        nextJob = this.jobs.get(jobs.size()-1);
        this.unschedule(nextJob);
        return nextJob;
    }
}
