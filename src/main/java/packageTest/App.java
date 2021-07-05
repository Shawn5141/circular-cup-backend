package packageTest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class App
{
    public static void main( String[] args )
    {
        DeepThought ourSuperComputer = new DeepThought();
        int ans = ourSuperComputer.answer_to_the_ultimate_question_of_life_the_universe_and_everything();

        RedisJava cache = new RedisJava();
        System.out.println("===get Host"+cache.get_host());
        cache.cache_value("answer_to_the_ultimate_question_of_life_the_universe_and_everything",String.valueOf(ans));

        System.out.println("Cached value: " + cache.get_cached_value("answer_to_the_ultimate_question_of_life_the_universe_and_everything"));
    }
}