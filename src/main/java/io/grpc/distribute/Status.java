package io.grpc.distribute;

/**
 * Created by gl49 on 2018/7/5.
 */
public class Status {
    private int runCount;
    private int callCount;

    public int getRunCount() {
        return runCount;
    }

    public void setRunCount(int runCount) {
        this.runCount = runCount;
    }

    public int getCallCount() {
        return callCount;
    }

    public void setCallCount(int callCount) {
        this.callCount = callCount;
    }

    @Override
    public String toString() {
        return "Status{" +
                "runCount=" + runCount +
                ", callCount=" + callCount +
                '}';
    }
}
