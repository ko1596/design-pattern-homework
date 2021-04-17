package org.ntutssl.organization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.Iterator;

import org.junit.Test;

public class NullIteratorTest {
    @Test
    public void test_has_next(){
        LocalDate lc = LocalDate.of(2000, 2, 18);
        Workforce team = new Team("good teams", lc , true);
        Workforce employee = new Individual("Tom", 30000, lc, true);
        team.add(employee);
        Iterator<Workforce> it = team.iterator();
        assertTrue(it.hasNext());
    }

    @Test
    public void test_next_element(){
        LocalDate lc = LocalDate.of(2000, 2, 18);
        Workforce team = new Team("good teams", lc , true);
        Workforce employee = new Individual("Tom", 30000, lc, true);
        team.add(employee);
        Iterator<Workforce> it = team.iterator();
        assertEquals(employee, it.next());
    }
 }
