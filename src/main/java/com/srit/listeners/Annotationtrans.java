package com.srit.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Annotationtrans implements IAnnotationTransformer {


    public void Transform(ITestAnnotation annotation, Class testClass, Constructor constructor, Method testmethod)
    {
        annotation.setDataProvider("logintestdata");
        annotation.setRetryAnalyzer(RetryFailedTests.class);
    }
}
