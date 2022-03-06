package healthycoderapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DietPlannerTest {

    private DietPlanner dietPlaner;

    @BeforeEach
    void setup(){
        this.dietPlaner=new DietPlanner(20,30,50);
    }


    @Test
    void should_ReturnCorrectDietPlan_When_CorrectCoder() {
        //given
        Coder coder=new Coder(1.82,75.0,26,Gender.MALE);
        DietPlan expected= new DietPlan(2202,110,73,275);
        //when
        DietPlan calculated=dietPlaner.calculateDiet(coder);

        //then
        assertAll(
                () -> assertEquals(expected.getCalories(),calculated.getCalories()),
                () -> assertEquals(expected.getCarbohydrate(),calculated.getCarbohydrate()),
                () -> assertEquals(expected.getFat(),calculated.getFat()),
                () -> assertEquals(expected.getProtein(),calculated.getProtein())
        );
    }

}