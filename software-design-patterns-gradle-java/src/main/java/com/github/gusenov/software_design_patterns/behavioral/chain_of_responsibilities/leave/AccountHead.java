package com.github.gusenov.software_design_patterns.behavioral.chain_of_responsibilities.leave;

/**
 * ConcreteHandlers: Define more specific behaviour for handling request,
 * if they can’t handle it, they will simply call superclass handle method.
 *
 * @see <a href="http://www.thejavageek.com/2016/08/31/chain-responsibilities-pattern-implementation/">Chain Of Responsibilities Pattern Implementation - theJavaGeek</a>
 */
public class AccountHead extends Approver {
    /**
     * Each concrete handler implements its own behaviour of handling request.
     * @param request
     */
    @Override
    public void approveRequest(LeaveRequest request) {
        if (request.getDays() > 15) {  // If more than 15 days, then it is approved by account head.
            System.out.println("Leave request approved for " + request.getDays() + " days by AccountHead");
        } else {
            // If request needs to be passed down the chain, concrete handler calls base class behaviour.
            super.approveRequest(request);
        }
    }
}
