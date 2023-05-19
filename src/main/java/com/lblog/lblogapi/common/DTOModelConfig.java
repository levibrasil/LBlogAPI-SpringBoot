package com.lblog.lblogapi.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DTOModelConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
