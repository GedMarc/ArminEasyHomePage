/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.armineasy.homepage;

import za.co.mmagon.jwebswing.base.html.Button;
import za.co.mmagon.jwebswing.components.fontawesome.FontAwesome;
import za.co.mmagon.jwebswing.components.fontawesome.FontAwesomeIcons;

/**
 *
 * @author GedMarc
 * @since Nov 11, 2016
 * @version 1.0
 *
 */
public class GeneralComponentFactory
{

    public static HomePage homePage;

    public GeneralComponentFactory()
    {

    }

    public static Button getSmallSourceCodeButton(Class sourceClass)
    {
        Button sourceButton = new Button();
        sourceButton.addClass("btn btn-xs btn-default bold");
        sourceButton.add(FontAwesome.icon(FontAwesomeIcons.code));
        
        homePage.getSourceViewer().addSourceChanger(sourceButton, sourceClass);
        homePage.getSourceCodeModal().asMe().addOpenButton(sourceButton);
        
        return sourceButton;
    }

    public static HomePage getHomePage()
    {
        return homePage;
    }

    public static void setHomePage(HomePage homePage)
    {
        GeneralComponentFactory.homePage = homePage;
    }

}
