package com.armineasy.homepage;

import com.google.inject.Provides;
import com.google.inject.Singleton;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.servlets.JWebSwingServlet;

/**
 * This is the home page for http://armineasy.com/
 *
 * @author GedMarc
 * @since 28 Dec 2015
 */
@Singleton
public class ArminEasyHomePage extends JWebSwingServlet
{

    private HomePage homePage;
    private static final long serialVersionUID = 1L;

    public ArminEasyHomePage()
    {
    }

    @Override
    @Provides
    public Page getPage()
    {
        if (homePage == null)
        {
            homePage = new HomePage();
        }
        return homePage;
    }

    @Provides
    public HomePage getHomePage()
    {
        return homePage;
    }

    @Override
    public String getUrl()
    {
        return "/";
    }
}
