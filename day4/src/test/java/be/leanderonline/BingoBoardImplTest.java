package be.leanderonline;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BingoBoardImplTest {

    @Test
    public void sumOfUnmarkedNumbers_happyFlow() {
        //GIVEN
        BingoBoardImpl board = new BingoBoardImpl.BingoBoardBuilder(5)
                .withRow(0, 14, 21, 17, 24, 4)
                .withRow(1, 10, 16, 15, 9, 19)
                .withRow(2, 18, 8, 23, 26, 20)
                .withRow(3, 22, 11, 13, 6, 5)
                .withRow(4, 2, 0, 12, 3, 7)
                .build();
        for (int i = 0; i < 5; i++) {
            board.markCell(0, i);
        }
        board.markCell(1, 3);
        board.markCell(2, 2);
        board.markCell(3, 1);
        board.markCell(3, 4);
        board.markCell(4, 0);
        board.markCell(4, 1);
        board.markCell(4, 4);

        //WHEN
        int result = board.sumOfUnmarkedNumbers();

        //THEN
        assertThat(result).isEqualTo(188);
    }

    @Test
    public void hasWon_whenRowFullyMarked_shouldReturnTrue() {
        //GIVEN
        BingoBoardImpl board = new BingoBoardImpl.BingoBoardBuilder(5)
                .withRow(0, 14, 21, 17, 24, 4)
                .withRow(1, 10, 16, 15, 9, 19)
                .withRow(2, 18, 8, 23, 26, 20)
                .withRow(3, 22, 11, 13, 6, 5)
                .withRow(4, 2, 0, 12, 3, 7)
                .build();
        for (int i = 0; i < 5; i++) {
            board.markCell(0, i);
        }

        //WHEN
        boolean result = board.hasWon();

        //THEN
        assertThat(result).isTrue();
    }

    @Test
    public void hasWon_whenColumnFullyMarked_shouldReturnTrue() {
        //GIVEN
        BingoBoardImpl board = new BingoBoardImpl.BingoBoardBuilder(5)
                .withRow(0, 14, 21, 17, 24, 4)
                .withRow(1, 10, 16, 15, 9, 19)
                .withRow(2, 18, 8, 23, 26, 20)
                .withRow(3, 22, 11, 13, 6, 5)
                .withRow(4, 2, 0, 12, 3, 7)
                .build();
        for (int i = 0; i < 5; i++) {
            board.markCell(i, 0);
        }

        //WHEN
        boolean result = board.hasWon();

        //THEN
        assertThat(result).isTrue();
    }

    @Test
    public void hasWon_whenNoRowOrColumnFullyMarked_shouldReturnFalse() {
        //GIVEN
        BingoBoardImpl board = new BingoBoardImpl.BingoBoardBuilder(5)
                .withRow(0, 14, 21, 17, 24, 4)
                .withRow(1, 10, 16, 15, 9, 19)
                .withRow(2, 18, 8, 23, 26, 20)
                .withRow(3, 22, 11, 13, 6, 5)
                .withRow(4, 2, 0, 12, 3, 7)
                .build();
        board.markCell(1, 3);
        board.markCell(2, 2);
        board.markCell(3, 1);
        board.markCell(3, 4);
        board.markCell(4, 0);
        board.markCell(4, 1);
        board.markCell(4, 4);

        //WHEN
        boolean result = board.hasWon();

        //THEN
        assertThat(result).isFalse();
    }

}