package be.leanderonline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BingoInterpreterTest {
    private BingoInterpreter bingoInterpreter;

    @BeforeEach
    void setUp() {
        bingoInterpreter = new BingoInterpreter();
    }

    @Test
    void createBingo_happyFlow() {
        //GIVEN
        List<String> input = new ArrayList<>();
        input.add("7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1");
        input.add("");
        input.add("22 13 17 11  0");
        input.add(" 8  2 23  4 24");
        input.add("21  9 14 16  7");
        input.add(" 6 10  3 18  5");
        input.add(" 1 12 20 15 19");
        input.add("");
        input.add(" 3 15  0  2 22");
        input.add(" 9 18 13 17  5");
        input.add("19  8  7 25 23");
        input.add("20 11 10 24  4");
        input.add("14 21 16 12  6");
        input.add("");
        input.add("14 21 17 24  4");
        input.add("10 16 15  9 19");
        input.add("18  8 23 26 20");
        input.add("22 11 13  6  5");
        input.add(" 2  0 12  3  7");

        //WHEN
        FirstBingoMaster bingo = bingoInterpreter.createBingo(input);

        //THEN
        assertThat(bingo.getDrawLine()).containsExactly(7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1);
        assertThat(bingo.getAmountOfBoards()).isEqualTo(3);

    }
}