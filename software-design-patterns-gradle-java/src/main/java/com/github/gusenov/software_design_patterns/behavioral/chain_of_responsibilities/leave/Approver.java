package com.github.gusenov.software_design_patterns.behavioral.chain_of_responsibilities.leave;

/**
 * Handler: An abstract class which defines request handling behaviour which handles request.
 *
 * {@link Approver} is an abstract class which has protected variable {@link Approver#nextApprover},
 * which will hold reference to next responsibility handler in the chain.
 *
 * @see <a href="http://www.thejavageek.com/2016/08/31/chain-responsibilities-pattern-implementation/">Chain Of Responsibilities Pattern Implementation - theJavaGeek</a>
 */
public abstract class Approver {

    /**
     * Base class Handler has reference to next handler which itself is of type Handler.
     */
    protected Approver nextApprover;

    public void approveRequest(LeaveRequest request) {
        // If the request is passed to a handler and it does not know how to handle it, then it is passed along the chain by some way.
        nextApprover.approveRequest(request);
    }

    public void setNext(Approver approver) {
        this.nextApprover = approver;
    }
}
