/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.armineasy.homepage.components.welcomepage;

import com.armineasy.homepage.GeneralComponentFactory;
import com.armineasy.homepage.data.JsonLocator;
import com.armineasy.homepage.data.dto.FrameworkListItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.Italic;
import za.co.mmagon.jwebswing.base.html.Link;
import za.co.mmagon.jwebswing.base.html.Span;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.components.fontawesome.FontAwesome;
import za.co.mmagon.jwebswing.components.fontawesome.FontAwesomeIcons;
import za.co.mmagon.jwebswing.components.bootstrap.BootstrapClasses;
import za.co.mmagon.jwebswing.components.bootstrap.panel.BSPanelDefault;
import za.co.mmagon.jwebswing.components.moment.Moment;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author GedMarc
 * @since Oct 29, 2016
 * @version 1.0
 * 
 */
public class FrameworksListPanel extends BSPanelDefault
{
    private static final long serialVersionUID = 1L;

    public FrameworksListPanel ()
    {
        super(FontAwesomeIcons.gears, "Framework Updates <i class=\"hidden-sm hidden-xs\"><small>(SB2 List Group)</small></i>");
        Div listGroup = new Div();
        listGroup.addClass("list-group");

        ArrayList frameworks = null;
        try
        {
            frameworks = JavaScriptPart.FromToList(JsonLocator.class.getResource("frameworks.json"), FrameworkListItem[].class);
        }
        catch (IOException ex)
        {
            Logger.getLogger(WelcomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (frameworks != null)
        {
            for (Iterator<FrameworkListItem> it = frameworks.iterator(); it.hasNext();)
            {
                FrameworkListItem framework = it.next();
                getPanelBody().add(buildFrameworkListItem(FontAwesomeIcons.cog, framework.getName(), framework.getUrl(), framework.getDate()));
            }
        }
        
        Div d = new Div();
        d.add("Hope this works");
        addDropDownToHeaderButtonBar(FontAwesome.icon(FontAwesomeIcons.cog), d);
    }
    
    private Link buildFrameworkListItem(FontAwesomeIcons icon, String title, String url, Date dated)
    {
        Link link = new Link(url == null ? "#" : url);
        link.addClass("list-group-item");
        Italic i = new Italic()
        {
            private static final long serialVersionUID = 1L;

            @Override
            protected StringBuilder renderAfterTag()
            {
                StringBuilder sb = new StringBuilder();
                sb.append(" ").append(title); //just shows how you can render anything really.. no point to this at all
                return sb;
            }
        };
        i.addClass(icon.toString());
        Div topSection = new Div();
        Span span = new Span();
        span.addClass("pull-right"); //way one
        span.addClass("text-muted");

        topSection.add(i);
        Moment date = new Moment(dated, ComponentTypes.Span);
        date.addClass(BootstrapClasses.Pull_Right); //way two
        date.addClass(BootstrapClasses.Text_Muted);

        topSection.add(date);
        topSection.add(span);

        link.add(topSection);

        return link;
    }
    
    @Override
    public void init()
    {
        if (!isInitialized())
        {
            getPanelHeaderButtonBar().add(GeneralComponentFactory.getSmallSourceCodeButton(FrameworksListPanel.class));
        }
        super.init();
    }
}
