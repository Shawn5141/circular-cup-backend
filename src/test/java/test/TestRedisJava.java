package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import packageTest.DeepThought;
import packageTest.RedisJava;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRedisJava {
    public TestRedisJava(){

    }

    @Test
    @DisplayName("Test Redis cache")
    void testRedisCache(){
        DeepThought ourSuperComputer = new DeepThought();
        int ans = ourSuperComputer.answer_to_the_ultimate_question_of_life_the_universe_and_everything();

        RedisJava cache = new RedisJava();
        cache.cache_value("answer_to_the_ultimate_question_of_life_the_universe_and_everything",String.valueOf(ans));

        assertEquals("1000", cache.get_cached_value("answer_to_the_ultimate_question_of_life_the_universe_and_everything"));
    }

}
