import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class HugeIntegerTest {

    @Test
    public  void  test_to_add(){
    HugeInteger integer1 = new HugeInteger();
    HugeInteger integer2 = new HugeInteger();
    integer1.parse("12345678");
    integer2.parse("112345678");
    String result = integer1.add(integer2);
    assertEquals("124691356",result);

    }
    @Test
    public  void  test_to_add1(){
    HugeInteger integer1 = new HugeInteger();
    HugeInteger integer2 = new HugeInteger();
    integer1.parse("12345678");
    integer2.parse("12344678");
    String result = integer1.add(integer2);
//    System.out.println(Arrays.toString(answer));
    assertEquals("24690356",result);

}
    @Test
        public  void  test_toString(){
            HugeInteger integer = new HugeInteger();
            integer.parse("12345678");
            String expectedString= "12345678";
            assertEquals(expectedString,integer.toString());
    }
    @Test
    public void  test_toSubtract(){
        HugeInteger integer1 = new HugeInteger();
        HugeInteger integer2 = new HugeInteger();
        integer1.parse("345678");
        integer2.parse("5679");
        String result = integer1.subtract(integer2);
        assertEquals("339999",result);

    }
    @Test
    public void test_subtract2(){
        HugeInteger integer1 = new HugeInteger();
        HugeInteger integer2 = new HugeInteger();
        integer2.parse("345678");
        integer1.parse("5679");
        String result = integer1.subtract(integer2);
        assertEquals("-339999",result);
    }
    @Test
    public void test_subtract3(){
        HugeInteger integer1 = new HugeInteger();
        HugeInteger integer2 = new HugeInteger();
        integer2.parse("345678");
        integer1.parse("567965");
        String result = integer1.subtract(integer2);
        assertEquals("222287",result);
    }
    @Test
    public void test_subtract4(){
        HugeInteger integer1 = new HugeInteger();
        HugeInteger integer2 = new HugeInteger();
        integer1.parse("345678");
        integer2.parse("567965");
        String result = integer1.subtract(integer2);
        assertEquals("-222287",result);
    }
    @Test
    public void test_subtract5(){
        HugeInteger integer1 = new HugeInteger();
        HugeInteger integer2 = new HugeInteger();
        integer1.parse("345678");
        integer2.parse("367965");
        String result = integer1.subtract(integer2);
        assertEquals("-22287",result);
    }
    @Test
    public void test_subtract6(){
        HugeInteger integer1 = new HugeInteger();
        HugeInteger integer2 = new HugeInteger();
        integer2.parse("345678");
        integer1.parse("367965");
        String result = integer1.subtract(integer2);
        assertEquals("22287",result);
    }
    @Test
    public void test_subtract7(){
        HugeInteger integer1 = new HugeInteger();
        HugeInteger integer2 = new HugeInteger();
        integer2.parse("365678");
        integer1.parse("367965");
        String result = integer1.subtract(integer2);
        assertEquals("2287",result);
    }
    @Test
    public void test_subtract8(){
        HugeInteger integer1 = new HugeInteger();
        HugeInteger integer2 = new HugeInteger();
        integer1.parse("365678");
        integer2.parse("367965");
        String result = integer1.subtract(integer2);
        assertEquals("-2287",result);
    }
    @Test
    public void test_subtract9(){
        HugeInteger integer1 = new HugeInteger();
        HugeInteger integer2 = new HugeInteger();
        integer1.parse("365665");
        integer2.parse("365665");
        String result = integer1.subtract(integer2);
        assertEquals("0",result);
    }
    @Test
    public void test_number_validity(){
        HugeInteger integer2 = new HugeInteger();
        assertThrows(IllegalArgumentException.class,()->integer2.parse("365678AS"));
    }
    @Test
    public void test_validity3(){
        HugeInteger integer  = new HugeInteger();
        integer.parse("-1234567890123456789012345678901234567890");

        assertThrows(IllegalArgumentException.class,()->integer.parse("-12345678901234567890123456789012345678901"));

    }
    @Test
    public void test_number_validity2(){
        HugeInteger integer2 = new HugeInteger();
        assertThrows(IllegalArgumentException.class,()->integer2.parse("365678123456789012456789012345678901234567890"));
    }
    @Test
    public void test_number_validity3(){
        HugeInteger integer2 = new HugeInteger();
        assertThrows(IllegalArgumentException.class,()->integer2.parse(""));
    }

    @Test
    public void test_equal(){
        HugeInteger integer1 = new HugeInteger();
        HugeInteger integer2 = new HugeInteger();
        integer1.parse("365678");
        integer2.parse("365678");
        boolean result =integer1.isEquals(integer2);
        assertTrue(result);
    }
    @Test
    public void test_not_equal(){
        HugeInteger integer1 = new HugeInteger();
        HugeInteger integer2 = new HugeInteger();
        integer1.parse("365678");
        integer2.parse("365679");
        boolean result =integer1.isNotEquals(integer2);
        assertTrue(result);
    }
    @Test
    public void test_greater_than(){
        HugeInteger integer1 = new HugeInteger();
        HugeInteger integer2 = new HugeInteger();
        integer1.parse("365778");
        integer2.parse("365678");
        boolean result =integer1.isGreaterThan(integer2);
        assertTrue(result);
    }
    @Test
    public void test_lesser_than(){
        HugeInteger integer1 = new HugeInteger();
        HugeInteger integer2 = new HugeInteger();
        integer1.parse("365578");
        integer2.parse("365678");
        boolean result =integer1.isLesserThan(integer2);
        assertTrue(result);
    }
    @Test
    public void test_lesser_than_or_equal_to(){
        HugeInteger integer1 = new HugeInteger();
        HugeInteger integer2 = new HugeInteger();
        integer1.parse("365578");
        integer2.parse("365678");
        boolean result =integer1.isLesserThanOrEqualTo(integer2);
        assertTrue(result);

        integer1.parse("365678");
        integer2.parse("365678");
        boolean result1 =integer1.isLesserThanOrEqualTo(integer2);
        assertTrue(result1);
    }
    @Test
    public void test_greater_than_or_equal_to(){
        HugeInteger integer1 = new HugeInteger();
        HugeInteger integer2 = new HugeInteger();
        integer1.parse("365778");
        integer2.parse("365678");
        boolean result =integer1.isGreaterThanOrEqualTo(integer2);
        assertTrue(result);

        integer1.parse("365778");
        integer2.parse("365778");
        boolean result1 =integer1.isGreaterThanOrEqualTo(integer2);
        assertTrue(result1);
    }
    @Test
    public void test_add(){
        HugeInteger integer1 = new HugeInteger();
        HugeInteger integer2 = new HugeInteger();
        integer1.parse("365778");
        integer2.parse("-465678");
        String result = integer1.add(integer2);
        assertEquals("-99900",result);
    }

    @Test
    public void test_add1(){
        HugeInteger integer1 = new HugeInteger();
        HugeInteger integer2 = new HugeInteger();
        integer2.parse("365778");
        integer1.parse("-465678");
        String result = integer1.add(integer2);
        assertEquals("-99900",result);
    }
    @Test
    public void test_add2(){
        HugeInteger integer1 = new HugeInteger();
        HugeInteger integer2 = new HugeInteger();
        integer1.parse("-36577800");
        integer2.parse("-46567800");
        String result = integer1.add(integer2);
        assertEquals("-83145600",result);
    }
    @Test
    public void test_subtract(){
        HugeInteger integer1 = new HugeInteger();
        HugeInteger integer2 = new HugeInteger();
        integer1.parse("-365778");
        integer2.parse("-465678");
        String result = integer1.subtract(integer2);
        assertEquals("99900",result);
    }
    @Test
    public void test_subtract1(){
        HugeInteger integer1 = new HugeInteger();
        HugeInteger integer2 = new HugeInteger();
        integer1.parse("365778");
        integer2.parse("-465678");
        String result = integer1.subtract(integer2);
        assertEquals("831456",result);
    }
    @Test
    public void test_subtract10(){
        HugeInteger integer1 = new HugeInteger();
        HugeInteger integer2 = new HugeInteger();
        integer1.parse("-365778");
        integer2.parse("465678");
        String result = integer1.subtract(integer2);
        assertEquals("-831456",result);
    }
    @Test
    public void test_subtract11(){
        HugeInteger integer1 = new HugeInteger();
        HugeInteger integer2 = new HugeInteger();
        integer1.parse("-465678");
        integer2.parse("-465678");
        String result = integer1.subtract(integer2);
        assertEquals("0",result);
    }



}