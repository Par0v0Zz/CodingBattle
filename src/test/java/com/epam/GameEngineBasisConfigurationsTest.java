package com.epam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameEngineBasisConfigurationsTest {

    private GameEngine gameEngine = new GameEngineImpl();

    @Test
    void standardAliveSectorTest2() {
        boolean[][] initialState = {
            {false, false, false, false, false},
            {false, true,  false, false, false},
            {false, false, false, true, false},
            {false, false, true,  false, false},
            {false, false, false, false, false}
        };
        int numberIterations = 1;

        boolean[][] result = gameEngine.compute(initialState, numberIterations);

        boolean[][] expectedState = {
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, true,  false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };

        assertEquals(expectedState, result);
    }

    @Test
    void testForAliveSector3() {
        boolean[][] initialState = {
                {false, false,  false, false, false},
                {false, true,   false, false, false},
                {false, true,   true,  true,  false},
                {false, false, true,  false, false},
                {false, false,  false, false, false}
        };
        int numberIterations = 2;

        boolean[][] result = gameEngine.compute(initialState, numberIterations);

        boolean[][] expectedState = {
                {false, false, false, false, false},
                {false, false,  false, false, false},
                {true,  true, false, true, false},
                {false, true, true,  true, false},
                {false, false, true, false, false}
        };

        assertEquals(expectedState, result);


    }

    @Test
    void testForAliveSector4Flex() {
        boolean[][] initialState = {
                {true, false, false, false, false, false, true},
                {false, false, false, false, false, false, true},
                {false, false, false, true, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, true, true, true, false, false}
        };
        int numberIterations = 1;

        boolean[][] result = gameEngine.compute(initialState, numberIterations);

        boolean[][] expectedState = {
                {true, false, false, true, false, false, true},
                {true, false, false, false, false, false, true},
                {false, false, false, false, false, false, false},
                {false, false, false, true, false, false, false},
                {false, false, true, true, true, false, false}
        };

        assertEquals(expectedState, result);
    }

    @Test
    void testForAliveSector5() {
        boolean[][] initialState = {
                {false, false, false, false, false, false, false},
                {false, true, true, false, false, false, false},
                {false, true, false, false, false, false, false},
                {false, false, false, false, true, false, false},
                {false, false, false, true, true, false, false},
                {false, false, false, false, false, false, false}
        };
        int numberIterations = 33;

        boolean[][] result = gameEngine.compute(initialState, numberIterations);

        boolean[][] expectedState = {
                {false, false, false, false, false, false, false},
                {false, true, true, false, false, false, false},
                {false, true, true, false, false, false, false},
                {false, false, false, true, true, false, false},
                {false, false, false, true, true, false, false},
                {false, false, false, false, false, false, false}
        };

        assertEquals(expectedState, result);

    }

    @Test
    void testForAliveSector6() {
        boolean[][] initialState = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        int numberIterations = 55;

        boolean[][] result = gameEngine.compute(initialState, numberIterations);

        boolean[][] expectState = {
                {false, false, false},
                {false, false, false},
                {false, false, false}
        };

        assertEquals(expectState, result);
    }
}