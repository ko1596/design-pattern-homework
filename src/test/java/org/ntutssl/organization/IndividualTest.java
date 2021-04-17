package org.ntutssl.organization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;
public class IndividualTest {
    @Test
    public void test_get_name(){
        LocalDate lc = LocalDate.of(2000, 2, 18);
        Workforce individual = new Individual("Tom", 30000, lc, true);
        assertEquals("Tom", individual.getName());
    }
    @Test
    public void test_getStartDate(){
        LocalDate lc = LocalDate.of(2000, 2, 18);
        Workforce individual = new Individual("Tom", 30000, lc, true);
        assertEquals(lc, individual.getStartDate());
    }
    @Test
    public void test_isInHouse(){
        LocalDate lc = LocalDate.of(2000, 2, 18);
        Workforce individual = new Individual("Tom", 30000, lc, true);
        assertTrue(individual.isInHouse());
    }
    @Test
    public void test_toString(){
        LocalDate lc = LocalDate.of(2000, 2, 18);
        Workforce individual = new Individual("Tom", 30000, lc, true);
        assertEquals("Type:\tIndividual (in-house)\nName:\tTom\nSalary:\t30000\nStart date:\t2000-02-18\n", individual.toString(0));
    }
    @Test
    public void test_visitor(){
        ListVisitor lv = new ListVisitor();
        LocalDate lc = LocalDate.of(2000, 2, 18);
        Workforce individual = new Individual("Tom", 30000, lc, true);
        lv.visitIndividual((Individual) individual);
        assertEquals("Type:\tIndividual (in-house)\nName:\tTom\nSalary:\t30000\nStart date:\t2000-02-18\n", lv.getResult());
    }

    @Test(expected = OrganizationException.class)
    public void test_add_should_throw_exception(){
        LocalDate lc = LocalDate.of(2000, 2, 18);
        Workforce individual = new Individual("Tom", 30000, lc, true);
        Workforce individual2 = new Individual("Tom", 30000, lc, true);
        individual.add(individual2);
    }

    @Test(expected = OrganizationException.class)
    public void test_getSize_should_throw_exception(){
        LocalDate lc = LocalDate.of(2000, 2, 18);
        Workforce individual = new Individual("Tom", 30000, lc, true);
        individual.getSize();
    }

    @Test(expected = NoSuchElementException.class)
    public void test_Iterator_should_throw_exception(){
        LocalDate lc = LocalDate.of(2000, 2, 18);
        Workforce individual = new Individual("Tom", 30000, lc, true);
        Iterator<Workforce> it = individual.iterator();
        it.hasNext();
    }

    @Test(expected = OrganizationException.class)
    public void test_salary_too_low_should_throw_exception(){
        LocalDate lc = LocalDate.of(2000, 2, 18);
        Workforce individual = new Individual("Tom", 5, lc, true);
    }

    @Test(expected = OrganizationException.class)
    public void test_name_is_empty_should_throw_exception(){
        LocalDate lc = LocalDate.of(2000, 2, 18);
        Workforce individual = new Individual("", 30000, lc, true);
    }
 }