package com.bravedroid.businessLogic;

import com.bravedroid.model.PizzaPartyVM;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PizzaPartyCalculatorTest {
    //given
    private PizzaPartyCalculator SUT;

    @Before
    public void setUp() {
        SUT = new PizzaPartyCalculator();
    }

    @Test
    public void calculateAllPizzaSlices_correctInput_returnAllPizzaSlices() {
        //when
        PizzaPartyVM vm = SUT.calculatePartitions(22, 8);

        //then
        PizzaPartyVM expectedVM = new PizzaPartyVM();
        expectedVM.setLeftoverPieces(0);
        expectedVM.setPiecesOfPizzaPerPerson(22);
        assertEquals(expectedVM, vm);
    }
}
