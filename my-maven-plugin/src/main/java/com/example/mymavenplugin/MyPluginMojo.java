package com.example.mymavenplugin;


import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * @goal myPlugin
 * @author liuyasen
 * @since 2024-10-22
 * 每一个mojo类都是maven plugin 的执行目标 goal
 */

public class MyPluginMojo extends AbstractMojo {
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("my-maven-plugin插件执行了goal的execute方法");
    }
}
