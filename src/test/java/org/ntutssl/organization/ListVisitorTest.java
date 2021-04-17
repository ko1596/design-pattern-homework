package org.ntutssl.organization;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class ListVisitorTest {
    @Test
    public void test_visit_complex_composite(){
        ListVisitor lv = new ListVisitor();
        LocalDate lc = LocalDate.of(2000, 2, 18);
        Workforce team = new Team("good teams", lc , true);
        Workforce bteam = new Team("bad teams", lc , true);
        Workforce tom = new Individual("Tom", 30000, lc, true);
        Workforce ggtest = new Individual("ggtest", 28000, lc, true);
        bteam.add(ggtest);
        team.add(tom);
        team.add(bteam);
        team.accept(lv);
        
        assertEquals("Type:\tTeam (in-house)\nName:\tgood teams\nStart date:\t2000-02-18\n  Type:\tIndividual (in-house)\n  Name:\tTom\n  Salary:\t30000\n  Start date:\t2000-02-18\n  Type:\tTeam (in-house)\n  Name:\tbad teams\n  Start date:\t2000-02-18\n    Type:\tIndividual (in-house)\n    Name:\tggtest\n    Salary:\t28000\n    Start date:\t2000-02-18\n", lv.getResult());
    }
    @Test
    public void test_visit_individual(){
        ListVisitor lv = new ListVisitor();
        LocalDate lc = LocalDate.of(2000, 2, 18);
        Workforce team = new Team("good teams", lc , true);
        Workforce tom = new Individual("Tom", 30000, lc, true);
        team.add(tom);
        team.accept(lv);
        assertEquals("Type:\tTeam (in-house)\nName:\tgood teams\nStart date:\t2000-02-18\n  Type:\tIndividual (in-house)\n  Name:\tTom\n  Salary:\t30000\n  Start date:\t2000-02-18\n", lv.getResult());
    }
    @Test
    public void test_visit_team(){
        ListVisitor lv = new ListVisitor();
        LocalDate lc = LocalDate.of(2000, 2, 18);
        Workforce team = new Team("good teams", lc , true);
        team.accept(lv);
        assertEquals("Type:\tTeam (in-house)\nName:\tgood teams\nStart date:\t2000-02-18\n", lv.getResult());
    }
 }