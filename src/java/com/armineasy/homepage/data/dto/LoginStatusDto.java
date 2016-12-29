/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.armineasy.homepage.data.dto;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * Flag to show logged in or not
 * @author GedMarc
 * @since Oct 23, 2016
 * @version 1.0
 * 
 */
public class LoginStatusDto extends JavaScriptPart<LoginStatusDto>
{

    private static final long serialVersionUID = 1L;
    
    private boolean isLoggedIn;
    public LoginStatusDto ()
    {
        
    } 

    public boolean isIsLoggedIn()
    {
        return isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn)
    {
        this.isLoggedIn = isLoggedIn;
    }
    
}
