package dfs_bfs.Bj2606_바이러스;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Bj2606Test {
    @Test
    void tc1() throws IOException {
        System.setIn(new ByteArrayInputStream(("7\n" +
                "6\n" +
                "1 2\n" +
                "2 3\n" +
                "1 5\n" +
                "5 2\n" +
                "5 6\n" +
                "4 7\n").getBytes()));

        Assertions.assertEquals(4, new Bj2606().solution());
    }
}