package com.example.mymavenplugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.*;
import java.util.Properties;

/**
 * @author liuyasen
 * @since 20241022
 * defaultPhase 制定默认调用的生命周期，调用方不配置默认为这个属性
 */
@Mojo(name = "annoationPlugin", defaultPhase = LifecyclePhase.COMPILE)
public class AnnotationMojo extends AbstractMojo {
    @Parameter(defaultValue = "${project}")
    private MavenProject project;
    @Parameter(property = "filePath")
    private String filePath;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println(filePath);
        File file = new File(project.getBasedir(), filePath);
        System.out.println("file:" + file);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                getLog().info(line);
            }
        } catch (IOException e) {
            System.out.println("异常了");
        }


    }
}
