package com.github.gusenov.software_design_patterns.behavioral.chain_of_responsibilities.leave;

import org.junit.Test;

/**
 * Chain of responsibilities implementation maintains a chain of all objects which are capable of handling requests.
 * This chain is created an maintained by client.
 *
 * Client: Instantiates all concrete handlers and chains them dynamically.
 *
 * {@link LeaveSystem} is actual client which instantiates all responsibilities
 * and create a chain by setting next approver for each responsibility.
 *
 * @see <a href="http://www.thejavageek.com/2016/08/31/chain-responsibilities-pattern-implementation/">Chain Of Responsibilities Pattern Implementation - theJavaGeek</a>
 */
public class LeaveSystem {
    @Test
    public void test() {

        // SuperVisor, Manager and AccountHead are concrete subclasses of Approver,
        // which provide their own specific behaviour based on our conditions for leave approval.
        Approver supervisor = new Supervisor();
        Approver manager = new Manager();
        Approver accountHead = new AccountHead();

        // If they can’t handle LeaveRequest, they simply call super.approveRequest(request),
        // which in turn calls method from nextApprover.
        supervisor.setNext(manager);
        manager.setNext(accountHead);

        // The client creates a request and leaves to the chain. Any one concrete handler handles it.
        supervisor.approveRequest(new LeaveRequest(4));
        supervisor.approveRequest(new LeaveRequest(40));
        supervisor.approveRequest(new LeaveRequest(12));
    }
}
