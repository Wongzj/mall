package com.pet.mall;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Code to produce MBG
 * Created by pet on 2018/4/26.
 */
public class Generator {
    public static void main(String[] args) throws Exception {
        //MBG warning information during execution
        List<String> warnings = new ArrayList<String>();
        //When generated code is duplicated, override the original code
        boolean overwrite = true;
        //Read the MBG configuration file
        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        //Create MBG
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        //Execute to generate code
        myBatisGenerator.generate(null);
        //Output Waring Messages
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
