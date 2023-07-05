package dfs_bfs.Bj7576_토마토;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Bj7576_토마토Test {
    @Test
    void tc1() throws IOException {
        System.setIn(new ByteArrayInputStream(("6 4\n" +
                "0 0 0 0 0 0\n" +
                "0 0 0 0 0 0\n" +
                "0 0 0 0 0 0\n" +
                "0 0 0 0 0 1\n").getBytes()));

        assertEquals(8, new Bj7576_토마토().solution());
    }

    @Test
    void tc2() throws IOException {
        System.setIn(new ByteArrayInputStream(("6 4\n" +
                "0 -1 0 0 0 0\n" +
                "-1 0 0 0 0 0\n" +
                "0 0 0 0 0 0\n" +
                "0 0 0 0 0 1\n").getBytes()));

        assertEquals(-1, new Bj7576_토마토().solution());
    }

    @Test
    void tc3() throws IOException {
        System.setIn(new ByteArrayInputStream(("6 4\n" +
                "1 -1 0 0 0 0\n" +
                "0 -1 0 0 0 0\n" +
                "0 0 0 0 -1 0\n" +
                "0 0 0 0 -1 1\n").getBytes()));

        assertEquals(6, new Bj7576_토마토().solution());
    }

    @Test
    void tc4() throws IOException {
        System.setIn(new ByteArrayInputStream(("5 5\n" +
                "-1 1 0 0 0\n" +
                "0 -1 -1 -1 0\n" +
                "0 -1 -1 -1 0\n" +
                "0 -1 -1 -1 0\n" +
                "0 0 0 0 0\n").getBytes()));

        assertEquals(14, new Bj7576_토마토().solution());
    }

    @Test
    void tc5() throws IOException {
        System.setIn(new ByteArrayInputStream(("2 2\n" +
                "1 -1\n" +
                "-1 1\n").getBytes()));

        assertEquals(0, new Bj7576_토마토().solution());
    }
}