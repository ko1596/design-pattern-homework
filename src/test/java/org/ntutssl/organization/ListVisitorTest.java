package org.ntutssl.organization;

import java.time.LocalDate;

import org.junit.Test;

public class ListVisitorTest {
    @Test
    public void test_list_out_all_object(){
        ListVisitor lv = new ListVisitor();
        LocalDate lc = LocalDate.of(2000, 2, 18);
        Workforce team = new Team("good teams", lc , true);
        Workforce bteam = new Team("bad teams", lc , true);
        Workforce tom = new Individual("Tom", 30000, lc, true);
        Workforce jack = new Individual("jack", 30000, lc, false);
        Workforce luck = new Individual("luck", 30000, lc, true);
        Workforce apple = new Individual("apple", 30000, lc, true);
        Workforce ggtest = new Individual("ggtest", 28000, lc, true);
        bteam.add(ggtest);
        team.add(tom);
        team.add(jack);
        team.add(luck);
        team.add(apple);
        team.add(bteam);
        team.accept(lv);
        
        System.out.println(lv.getResult());
    }
 }