package packageTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
@EnableCaching
public class RedisJava {

    @Value("${spring.redis.host:localhost}")
    private String redisHost;

    @Value("${spring.redis.port:6379}")
    private int redisPort;

    Jedis jedis;
    DeepThought super_computer;
    public RedisJava(){
        if(redisHost==null){
            redisHost = "redis";
        }
        if(redisPort==0){
            redisPort = 6379;
        }
        System.out.println("===redisHost"+ redisHost.toString()+" port :"+ redisPort);
        this.jedis = new Jedis(redisHost, redisPort);
    }

    public void cache_value(String key, String value){
        this.jedis.set(key, value);
    }

    public String get_cached_value(String key){
        return this.jedis.get(key);
    }

    public String get_host() {
        return this.redisHost;
    }

}