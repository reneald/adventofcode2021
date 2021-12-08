package be.leanderonline;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FileAccessorTest {
    private final FileAccessor fileAccessor = new FileAccessor();

    @Test
    void readAsDirectionTotals() {
        //GIVEN
        File file = new File("src/test/resources/input.txt");

        //WHEN
        Map<Direction, Integer> result = fileAccessor.readAsDirectionTotals(file);

        //THEN
        assertThat(result).isNotEmpty();
        assertThat(result).containsKeys(Direction.FORWARD, Direction.DOWN, Direction.UP);
        assertThat(result.get(Direction.FORWARD)).isEqualTo(31);
        assertThat(result.get(Direction.DOWN)).isEqualTo(21);
        assertThat(result.get(Direction.UP)).isEqualTo(3);
    }
}