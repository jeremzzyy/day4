package test;

import main.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tester {
    @Test
    public void equalTest(){
        Condition c = new EqualCondition(Property.NAME,"Jerry");
        assertEquals("name=Jerry", c.getExpression());
    }

    @Test
    public void notEqualTest(){
        Condition c = new NotEqualCondition(Property.NAME,"Jerry");
        assertEquals("name!=Jerry", c.getExpression());
    }

    @Test
    public void containTest(){
        Condition c = new ContainCondition(Property.NAME,"Jerry");
        assertEquals("CONTAINS(name,Jerry)", c.getExpression());
    }

    @Test
    public void andTest(){
        Condition c = new EqualCondition(Property.NAME,"Jerry");
        Condition c1 = new NotEqualCondition(Property.COMPANYNAME,"HTSC");
        assertEquals("name=Jerry AND companyName!=HTSC", c.and(c1));
    }
    @Test
    public void andTest2() {
        Condition c = new EqualCondition(Property.NAME, "Jerry");
        Condition c1 = new ContainCondition(Property.COMPANYNAME, "HTSC");
        assertEquals("name=Jerry AND CONTAINS(companyName,HTSC)", c.and(c1));
    }

    @Test
    public void orTest(){
        Condition c = new EqualCondition(Property.NAME,"Jerry");
        Condition c1 = new ContainCondition(Property.COUNTRY,"China");
        assertEquals("name=Jerry OR CONTAINS(country,China)", c.or(c1));
    }
    @Test
    public void orTest2() {
        Condition c = new EqualCondition(Property.NAME, "Jerry");
        Condition c1 = new NotEqualCondition(Property.COMPANYNAME, "HTSC");
        assertEquals("name=Jerry OR companyName!=HTSC", c.or(c1));
    }
}
