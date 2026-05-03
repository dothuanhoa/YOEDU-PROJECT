package yoot.week1.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean // thay gì phải kế thừa rồi ghi đè lên
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setMatchingStrategy(MatchingStrategies.STRICT) //strict yêu cầu các field phải giống entity, standard cho khác hoa thường, loose thì giống chữ đầu là được
                .setAmbiguityIgnored(false);
        return modelMapper;
    }
}
