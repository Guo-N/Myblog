package life.daguo.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@MapperScan(value = "life.daguo.boot.Dao")
@SpringBootApplication
public class MainApplication {
    public static  void main(String []args){
        SpringApplication.run(MainApplication.class,args);
    }
}
