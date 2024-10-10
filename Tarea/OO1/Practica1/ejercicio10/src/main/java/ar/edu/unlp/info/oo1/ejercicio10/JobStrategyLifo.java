package ar.edu.unlp.info.oo1.ejercicio10;

public class JobStrategyLifo extends JobScheduler{
    public JobStrategyLifo() {

    }

    @Override
    public JobDescription next() {
        JobDescription nextJob = null;
        nextJob = this.jobs.get(jobs.size()-1);
        this.unschedule(nextJob);
        return nextJob;
    }
}
