package ar.edu.unlp.info.oo1.ejercicio10;

public class JobStrategyFifo extends JobScheduler{
    public JobStrategyFifo() {
    }

    @Override
    public JobDescription next() {
        JobDescription nextJob = null;
        nextJob = this.jobs.get(0);
        this.unschedule(nextJob);
        return nextJob;
    }
}
