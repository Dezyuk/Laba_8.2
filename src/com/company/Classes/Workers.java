package com.company.Classes;

import java.io.Serializable;
import java.time.LocalDate;

public class Workers implements Serializable {
    private Worker[] workers;
    private int currentWorkerNumber;

    public Workers(final int workersNumber) {
        this.workers = new Worker[workersNumber];
        currentWorkerNumber = -1;
    }

    public String findWorkers() {
        String result = "The contract was signed less than a year ago: " + System.lineSeparator();

        for (final Worker worker : workers) {
            if ((LocalDate.now().getYear() - worker.getSigning_contract().getYear()) == 1) {
                if ((LocalDate.now().getMonthValue() - worker.getSigning_contract().getMonthValue()) == 0) {
                    if ((LocalDate.now().getDayOfMonth() - worker.getSigning_contract().getDayOfMonth()) < 0) {
                        result += worker + System.lineSeparator();
                    }
                } else if ((LocalDate.now().getMonthValue() - worker.getSigning_contract().getMonthValue()) < 0) {
                    result += worker + System.lineSeparator();
                }
            } else if ((LocalDate.now().getYear() - worker.getSigning_contract().getYear()) < 1) {
                result += worker + System.lineSeparator();
            }
        }
        return result;
    }

    public void addWorker(final Worker worker) {
        if (++currentWorkerNumber < workers.length) {
            workers[currentWorkerNumber] = worker;
        }
    }

    public String toString() {
        String result = "";
        if (currentWorkerNumber > -1) {
            result += "Workers: " + System.lineSeparator();

            for (final Worker worker : workers) {
                result += worker + System.lineSeparator();
            }
        }
        return result;
    }
}

