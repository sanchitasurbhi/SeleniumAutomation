package Intro;

import org.testng.annotations.Test;

public class Day2 {

    @Test
    public void Demo1()
    {

        System.out.println("surbhi");
    }

    @Test(groups={"Smoke"})
    public void Weblogin()
    {
        //appium
        System.out.println("web");
    }
    @Test
    public void Mobilelogin()
    {
        //mobile
        System.out.println("mobile");
    }



}
