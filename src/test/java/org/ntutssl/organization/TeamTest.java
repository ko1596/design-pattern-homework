package org.ntutssl.organization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class TeamTest {
    @Test
    public void test_get_name(){
        LocalDate lc = LocalDate.of(2000, 2, 18);
        Workforce team = new Team("good teams", lc , true);
        assertEquals("good teams", team.getName());
    }
    @Test
    public void test_getStartDate(){
        LocalDate lc = LocalDate.of(2000, 2, 18);
        Workforce team = new Team("good teams", lc , true);
        assertEquals(lc, team.getStartDate());
    }
    @Test
    public void test_isInHouse(){
        LocalDate lc = LocalDate.of(2000, 2, 18);
        Workforce team = new Team("good teams", lc , true);
        assertTrue(team.isInHouse());
    }

    @Test
    public void test_toString(){
        LocalDate lc = LocalDate.of(2000, 2, 18);
        Workforce team = new Team("good teams", lc , true);
        assertEquals("    Type:\tTeam (in-house)\n    Name:\tgood teams\n    Start date:\t2000-02-18\n", team.toString(4));
    }

    @Test
    public void test_visitor(){
        ListVisitor lv = new ListVisitor();
        LocalDate lc = LocalDate.of(2000, 2, 18);
        Workforce team = new Team("good teams", lc , true);
        lv.visitTeam((Team) team);
        assertEquals("Type:\tTeam (in-house)\nName:\tgood teams\nStart date:\t2000-02-18\n", lv.getResult());
    }

 }