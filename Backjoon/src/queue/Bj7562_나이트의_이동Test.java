package queue;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class Bj7562_나이트의_이동Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeAll
    public void setupOutputStream() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void clearOutputStream() {
        System.out.flush();
    }

    @Test
    public void tc1() throws IOException {
        System.setIn(new ByteArrayInputStream(
            ("3\n"
                + "8\n"
                + "0 0\n"
                + "7 0\n"
                + "100\n"
                + "0 0\n"
                + "30 50\n"
                + "10\n"
                + "1 1\n"
                + "1 1\n").getBytes()
        ));
        Bj7562_나이트의_이동.main(new String[]{});
        assertEquals("5\n28\n0", outContent.toString().strip());
    }
}