import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SILab2Test {

    private final SILab2 siLab2 = new SILab2();
    private List<Integer> result = new ArrayList<>();
    String seconds_invalid = "The seconds are not valid";
    String minutes_invalid = "The minutes are not valid";
    String hours_greater = "The hours are greater than the maximum";
    String hours_smaller = "The hours are smaller than the minimum";
    String time_greater = "The time is greater than the maximum";

    @Test
    public void MultipleCondition() {
        List<Time> list1 = new ArrayList<>();
        list1.add(new Time(-1, 45, 45));
        List<Time> list2 = new ArrayList<>();
        list2.add(new Time(25, 14, 14));
        List<Time> list3 = new ArrayList<>();
        list3.add(new Time(4, 5, 6));
        List<Time> list4 = new ArrayList<>();
        list4.add(new Time(22, -1, 15));
        List<Time> list5 = new ArrayList<>();
        list5.add(new Time(22, 61, 15));
        List<Time> list6 = new ArrayList<>();
        list6.add(new Time(22, 15, -1));
        List<Time> list7 = new ArrayList<>();
        list7.add(new Time(22, 15, 61));
        List<Time> list8 = new ArrayList<>();
        list8.add(new Time(24, 0, 0));
        List<Time> list9 = new ArrayList<>();
        list9.add(new Time(24, 0, 1));
        List<Time> list10 = new ArrayList<>();
        list10.add(new Time(24, 13, 13));

        RuntimeException exception = null;

        try {
            SILab2.function(list1);
        } catch (RuntimeException ex) {
            exception = ex;
        }
        assertEquals(hours_smaller, exception.getMessage());

        try {
            SILab2.function(list2);
        } catch (RuntimeException ex) {
            exception = ex;
        }
        assertEquals(hours_greater, exception.getMessage());

        result.add(14706);
        assertEquals(result, SILab2.function(list3));

        try {
            SILab2.function(list4);
        } catch (RuntimeException ex) {
            exception = ex;
        }
        assertEquals(minutes_invalid, exception.getMessage());

        try {
            SILab2.function(list5);
        } catch (RuntimeException ex) {
            exception = ex;
        }
        assertEquals(minutes_invalid, exception.getMessage());

        try {
            SILab2.function(list6);
        } catch (RuntimeException ex) {
            exception = ex;
        }
        assertEquals(seconds_invalid, exception.getMessage());

        try {
            SILab2.function(list7);
        } catch (RuntimeException ex) {
            exception = ex;
        }
        assertEquals(seconds_invalid, exception.getMessage());

        result.remove(0);
        result.add(86400);
        assertEquals(result, SILab2.function(list8));

        try {
            SILab2.function(list9);
        } catch (RuntimeException ex) {
            exception = ex;
        }
        assertEquals(time_greater, exception.getMessage());

        try {
            SILab2.function(list10);
        } catch (RuntimeException ex) {
            exception = ex;
        }
        assertEquals(time_greater, exception.getMessage());
    }
    @Test
    public void EveryBranch() {
        List<Time> list1 = new ArrayList<>();
        List<Time> list2 = new ArrayList<>();
        list2.add(new Time(-3,20,24));
        List<Time> list3 = new ArrayList<>();
        list3.add(new Time(25,21,28));
        List<Time> list4 = new ArrayList<>();
        list4.add(new Time(21,-4,29));
        List<Time> list5 = new ArrayList<>();
        list5.add(new Time(23,39,-1));
        List<Time> list6 = new ArrayList<>();
        list6.add(new Time(18,22,20));
        List<Time> list7 = new ArrayList<>();
        list7.add(new Time(24,0,0));
        List<Time> list8 = new ArrayList<>();
        list8.add(new Time(24,2,2));


        result = siLab2.function(list1);
        assertTrue(result.isEmpty());

        RuntimeException exception = null;

        try{
            siLab2.function(list2);
        }
        catch (RuntimeException ex){
            exception = ex;
        }
        assertEquals(hours_smaller, exception.getMessage());

        try{
            siLab2.function(list3);
        }
        catch (RuntimeException ex){
            exception = ex;
        }
        assertEquals(hours_greater, exception.getMessage());

        try{
            siLab2.function(list4);
        }
        catch (RuntimeException ex){
            exception = ex;
        }
        assertEquals(minutes_invalid, exception.getMessage());

        try{
            siLab2.function(list5);
        }
        catch (RuntimeException ex){
            exception = ex;
        }
        assertEquals(seconds_invalid, exception.getMessage());

        result.add(66140);
        assertEquals(result, siLab2.function(list6));

        result.remove(0);
        result.add(86400);
        assertEquals(result, siLab2.function(list7));

        try{
            siLab2.function(list8);
        }catch (RuntimeException ex){
            exception = ex;
        }
        assertEquals(time_greater, exception.getMessage());
    }

}