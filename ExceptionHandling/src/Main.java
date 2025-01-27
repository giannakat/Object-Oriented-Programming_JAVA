

import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    /**
     * Gives a raise to the specified employee by the manager.
     *
     * @param persons  the list of persons
     * @param manager  the manager to give the salary raise
     * @param employee the employee to receive the raise
     * @param salary   the salary increase to be given
     * @throws ClassCastException       when manager or employee is not a manager or employee
     * @throws IllegalArgumentException when salary is invalid
     * @throws NoSuchElementException   when given manager or employee does not exist in the list of persons
     */
    public static void giveRaise(List<Person> persons, String manager, String employee, double salary) {
        Manager mgr = null;
        Employee emp = null;

        // Search for the manager and employee in the list
        for (Person person : persons) {
            if (person.getName().equals(manager)) {
                if (!(person instanceof Manager)) {
                    throw new ClassCastException(manager + " is not a manager");
                }
                mgr = (Manager) person;
            }
            if (person.getName().equals(employee)) {
                if (!(person instanceof Employee)) {
                    throw new ClassCastException(employee + " is not an employee");
                }
                emp = (Employee) person;
            }
        }

        // Check if manager or employee was found
        if (mgr == null) {
            throw new NoSuchElementException(manager + " does not exist");
        }
        if (emp == null) {
            throw new NoSuchElementException(employee + " does not exist");
        }


        // Proceed with giving the raise
        mgr.giveRaise(emp, salary);
    }

    /**
     * Assigns a project manager to a developer.
     *
     * @param persons   the list of persons
     * @param developer the developer to be assigned
     * @param manager   the manager assigned to the developer
     * @throws ClassCastException     when manager or developer is not a manager or developer
     * @throws NoSuchElementException when given manager or developer does not exist in the list of persons
     * @throws IllegalStateException  when developer already has a manager
     */
    public static void assignPM(List<Person> persons, String developer, String manager) {
        Manager mgr = null;
        Developer dev = null;

        // Search for the manager and developer in the list
        for (Person person : persons) {
            if (person.getName().equals(manager)) {
                if (!(person instanceof Manager)) {
                    throw new ClassCastException(manager + " is not a manager");
                }
                mgr = (Manager) person;
            }
            if (person.getName().equals(developer)) {
                if (!(person instanceof Developer)) {
                    throw new ClassCastException(developer + " is not a developer");
                }
                dev = (Developer) person;
            }
        }

        // Check if manager or developer was found
        if (mgr == null) {
            throw new NoSuchElementException(manager + " does not exist");
        }
        if (dev == null) {
            throw new NoSuchElementException(developer + " does not exist");
        }

        // Assign the project manager to the developer
        dev.setProjectManager(mgr);
    }

    /**
     * Facilitates a conversation between a customer and an employee.
     *
     * @param persons  the list of persons
     * @param customer the customer to speak to the employee
     * @param employee the employee to be spoken to
     * @return the dialogue of the customer to the employee
     * @throws ClassCastException     when given customer or employee is not what they are
     * @throws NoSuchElementException when given customer or employee is not in the list of persons
     */
    public static String customerSpeak(List<Person> persons, String customer, String employee) {
        Customer c = null;
        Employee emp = null;

        // Search for the customer and employee in the list
        for (Person person : persons) {
            if (person.getName().equals(customer)) {
                if (!(person instanceof Customer)) {
                    throw new ClassCastException(customer + " is not a customer");
                }
                c = (Customer) person;
            }
            if (person.getName().equals(employee)) {
                if (!(person instanceof Employee)) {
                    throw new ClassCastException(employee + " is not an employee");
                }
                emp = (Employee) person;
            }
        }

        // Check if customer or employee was found
        if (c == null) {
            throw new NoSuchElementException(customer + " does not exist");
        }
        if (emp == null) {
            throw new NoSuchElementException(employee + " does not exist");
        }

        // Return the customer's dialogue
        return c.speak(emp);
    }
}