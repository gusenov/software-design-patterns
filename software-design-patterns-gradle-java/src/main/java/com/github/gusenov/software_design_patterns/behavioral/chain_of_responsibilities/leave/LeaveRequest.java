package com.github.gusenov.software_design_patterns.behavioral.chain_of_responsibilities.leave;

/**
 * {@link LeaveRequest} is the actual request object that will be created by client and passed to chain of responsibilities.
 *
 * @see <a href="http://www.thejavageek.com/2016/08/31/chain-responsibilities-pattern-implementation/">Chain Of Responsibilities Pattern Implementation - theJavaGeek</a>
 */
public class LeaveRequest {
    private int days;

    public LeaveRequest(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
