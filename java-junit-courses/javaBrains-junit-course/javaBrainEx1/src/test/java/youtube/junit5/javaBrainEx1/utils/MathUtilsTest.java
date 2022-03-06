package youtube.junit5.javaBrainEx1.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@EnabledOnOs(OS.LINUX)
@EnabledOnJre(JRE.JAVA_11)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class MathUtilsTest {

    private MathUtils mathUtils;

    @BeforeAll
    static void globalInit(){
        log.info("will be run once before all test method execution" +
                "even before creating the instance of the test class" +
                "that is why it is static in nature");
    }

    @BeforeEach
    void createMathUtilInstance(){
        mathUtils=new MathUtils();
    }

    @AfterEach
    void someCleanup(){
      log.info("some cleanup code");
    }

    @AfterAll
    static void globalCleanUp(){
        log.info("global clean up code will run after all the test method has run" +
                "it is also static in nature");
    }

    @Test
    @DisplayName(value = "mathSum() method test")
    public void mathSumTest(){
        int expectedResult=2;
        int actualResult=mathUtils.mathSum(1,1);
        assertEquals(expectedResult,actualResult,"the method should add 2 numbers");
    }

    @Test
    @DisplayName(value = "mathDivideTest() method test")
    public void mathDivideTest(){
        assertThrows(ArithmeticException.class,()->mathUtils.mathDivision(1f,0f));
        // so the assertThrows runs the executable(2nd parameter lambda function)
        // in try catch block because you know it will throw  exception for the given input.
        // so it matches the expected exception with actual exception
        // and passes the test if exception matches
    }

    @Test
    @DisplayName(value = "mathCircle() method test")
    public void mathCircleArea(){
        double expectedResult=153.93804002589985;
        double actualResult=mathUtils.mathCircleArea(7);
        assertEquals(expectedResult,actualResult,"the method should return area in double");
    }


    @Test
    @Disabled
    @DisplayName(value = "a disabled test")
    public void alwaysFail(){
        fail("this test will always run on fail hence disabled");
    }


}
