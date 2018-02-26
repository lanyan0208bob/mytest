package com.lanyan.test;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
public class CreateTable {

	public static void main(String[] args) throws InvalidConfigurationException, IOException, XMLParserException, URISyntaxException {
		List<String> warnings = new ArrayList<String>();
		   boolean overwrite = true;
		  System.out.println(123);
		   File configFile = new File(  CreateTable.class.getResource( "/generatorConfig.xml" ).toURI() );
		   ConfigurationParser cp = new ConfigurationParser(warnings);
		   Configuration config = cp.parseConfiguration(configFile);
		   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		   MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		   System.out.println(123);
		   try {
			myBatisGenerator.generate(null);
			System.out.println(123);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(122223);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println(122222223);
		}
	}
}
