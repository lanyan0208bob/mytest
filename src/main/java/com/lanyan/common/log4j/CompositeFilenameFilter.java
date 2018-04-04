package com.lanyan.common.log4j;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 用于通过指定preix 过滤文件的 过滤器 只要文件名中包含preix字符串就算匹配成功
 * 
 * @author  
 * 
 */
public class CompositeFilenameFilter implements FilenameFilter{
    // 需要查找文件中必须包含的文字
    private String preix= "";
    
    public CompositeFilenameFilter(String preix){
        this.preix= preix;
    }
    
//    @Override
    public boolean accept(File dir,String name){
        
        return name.indexOf(preix)> - 1 ? true : false;
    }
    
}
