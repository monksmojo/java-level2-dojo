package healthycoderapp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {

    @Test //  for public static boolean isDietRecommended(double weight, double height);
    void should_ReturnTrue_When_DietRecommended() {
        //given
        double weight=89.0;
        double height=1.72;
        //when
        boolean recommended=BMICalculator.isDietRecommended(weight,height);
        //then
        assertTrue(recommended);
    }

    @Test //  for public static boolean isDietRecommended(double weight, double height);
    void should_ReturnFalse_When_DietRecommended() {
        //given
        double weight=50.0;
        double height=1.92;
        //when
        boolean recommended=BMICalculator.isDietRecommended(weight,height);
        //then
        assertFalse(recommended);
    }

    @Test //  for public static boolean isDietRecommended(double weight, double height);
    void should_ThrowException_When_HeightZero(){
        //give
        double weight=50.0;
        double height=0.0;
        //when
        Executable executable = () -> BMICalculator.isDietRecommended(weight,height);
        //then
        assertThrows(ArithmeticException.class,executable);
    }

    @Test // for public static Coder findCoderWithWorstBMI(List<Coder> coders)
    void should_ReturnCoderWithWorstBmiCoder_When_CoderListNotEmpty(){
        //given
        List<Coder> coders=new ArrayList<Coder>();
        coders.add(new Coder(1.80,60.0));
        coders.add(new Coder(1.82,98.0));
        coders.add(new Coder(1.82,64.7));

        //when
        Coder worstBmiCoder=BMICalculator.findCoderWithWorstBMI(coders);

        //then
        assertAll(
                ()->assertEquals(1.82,worstBmiCoder.getHeight()),
                ()->assertEquals(98.0,worstBmiCoder.getWeight())
        );
    }

    @Test // for public static Coder findCoderWithWorstBMI(List<Coder> coders)
    void should_ThrowException_When_HeightZero_InCoderList(){
        //given
        List<Coder> coders=new ArrayList<Coder>();
        coders.add(new Coder(1.80,60.0));
        coders.add(new Coder(0,98.0));
        coders.add(new Coder(1.82,64.7));

        //when
        Executable executable = () -> BMICalculator.findCoderWithWorstBMI(coders);

        //then
        assertThrows(ArithmeticException.class,executable);
    }

    @Test // for public static Coder findCoderWithWorstBMI(List<Coder> coders)
    void should_ReturnNullWorstBmiCoder_When_inCoderWithWorstBMI(){
        //given
        List<Coder> coders=new ArrayList<>();
        //when
        Coder worstBmiCoder= BMICalculator.findCoderWithWorstBMI(coders);
        //then
        assertNull(worstBmiCoder);
    }

    @Test // for public static double[] getBMIScores(List<Coder> coders)
    void should_ReturnCorrectBmiScore_When_CoderList(){
        //given
        List<Coder> coders=new ArrayList<>();
        coders.add(new Coder(1.80,60.0));
        coders.add(new Coder(1.82,98.0));
        coders.add(new Coder(1.82,64.7));
        double[] expectedScores={18.52,29.59,19.53};

        //when
        double[] bmiScores=BMICalculator.getBMIScores(coders);

        //then
        assertArrayEquals(bmiScores,expectedScores);
    }

    @Test // for public static double[] getBMIScores(List<Coder> coders)
    void should_ThrowException_When_HeightZero_InBmiScore(){
        //given
        List<Coder> coders=new ArrayList<>();
        coders.add(new Coder(1.80,60.0));
        coders.add(new Coder(0,98.0));
        coders.add(new Coder(1.82,64.7));

        //when
        Executable executable = () -> BMICalculator.getBMIScores(coders);

        //then
        assertThrows(ArithmeticException.class,executable);
    }
}