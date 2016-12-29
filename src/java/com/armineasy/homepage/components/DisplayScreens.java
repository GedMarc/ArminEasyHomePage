package com.armineasy.homepage.components;

import com.armineasy.homepage.components.welcomepage.WelcomePage;
import za.co.mmagon.jwebswing.Component;

/**
 *
 * @author ged_m
 * @since 21 May 2016
 */
public enum DisplayScreens 
{
    WelcomeScreen(new WelcomePage());
    

    private Component component;

    private DisplayScreens(Component component) {
        this.component = component;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

}
