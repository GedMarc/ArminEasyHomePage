/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.armineasy.homepage.data.dto;

import java.util.Date;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author GedMarc
 * @since Oct 18, 2016
 * 
 */
public class FrameworkListItem extends JavaScriptPart<FrameworkListItem>
{

    private static final long serialVersionUID = 1L;
    
    private String name;
    private String userIcon;
    private String message;
    private String url;
    private Double progress;
    private String taskId;
    private String icon;
    private Date date;
    
    public FrameworkListItem()
    {
        
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getUserIcon()
    {
        return userIcon;
    }

    public void setUserIcon(String userIcon)
    {
        this.userIcon = userIcon;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public double getProgress()
    {
        return progress;
    }

    public void setProgress(double progress)
    {
        this.progress = progress;
    }

    public String getTaskId()
    {
        return taskId;
    }

    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }

    public String getIcon()
    {
        return icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }
    
    
    
}
