package test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Objects;

public class TestJunit {
    public TestJunit(){
    }

    @Test
    @DisplayName("Test the answer to everyone")
    void testAnswerToAll() {
        TestJunit testJunit = new TestJunit();
        assertTrue(testJunit instanceof Object);
    }

}
