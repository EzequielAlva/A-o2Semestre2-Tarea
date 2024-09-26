package ar.edu.unlp.info.oo1.ejercicio10;

import java.util.ArrayList;
import java.util.List;

public class JobScheduler {
    protected List<JobDescription> jobs;
    protected String strategy;
    protected JobScheduler jobStrategy;

    public JobScheduler () {
        this.jobs = new ArrayList<>();
        this.strategy = "FIFO";
        this.jobStrategy = null;
    }

    public void schedule(JobDescription job) {
        this.jobs.add(job);
    }

    public void unschedule(JobDescription job) {
        if (job != null) {
            this.jobs.remove(job);
        }
    }

    public String getStrategy() {
        return this.strategy; 
    }

    public List<JobDescription> getJobs(){
        return jobs;
    }

    public void setStrategy(String aStrategy) {
        this.strategy = aStrategy;
    }

    public JobDescription next() {
        if(this.jobStrategy == null){
            switch (strategy) {
                case "FIFO":
                    this.jobStrategy = new JobStrategyFifo(this.jobs);
                    break;
                case "LIFO":
                    this.jobStrategy = new JobStrategyLifo(this.jobs);
                    break;
                case "HighestPriority":
                    this.jobStrategy = new JobStrategyHighestPriority(this.jobs);
                    break;
                case "MostEffort":
                    this.jobStrategy = new JobStrategyMostEffort(this.jobs);
                    break;
                default:
                    return null;
            }
        }
        return this.jobStrategy.next();
    }
}
