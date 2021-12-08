package be.leanderonline;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class FileAccessorTest {
    private final FileAccessor fileAccessor = new FileAccessor();

    @Test
    void readAsDirectionTotals() {
        //GIVEN
        File file = new File("src/test/resources/input.txt");

        //WHEN
        Optional<List<String>> optionalStringList = fileAccessor.readAsStringList(file);

        //THEN
        assertThat(optionalStringList.isPresent()).isTrue();
        List<String> stringList = optionalStringList.get();
        assertThat(stringList.size()).isEqualTo(9);
    }
}