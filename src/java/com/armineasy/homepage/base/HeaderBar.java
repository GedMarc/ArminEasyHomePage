package com.armineasy.homepage.base;

import com.armineasy.homepage.HomePage;
import com.armineasy.homepage.data.JsonLocator;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.co.mmagon.jwebswing.base.html.Bold;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.Link;
import za.co.mmagon.jwebswing.base.html.List;
import za.co.mmagon.jwebswing.base.html.ListItem;
import za.co.mmagon.jwebswing.base.html.Span;
import za.co.mmagon.jwebswing.components.bootstrap.themes.sbadmin2.SB2DropDown;
import za.co.mmagon.jwebswing.components.bootstrap.themes.sbadmin2.SB2DropDownAlerts;
import za.co.mmagon.jwebswing.components.bootstrap.themes.sbadmin2.SB2DropDownMessages;
import za.co.mmagon.jwebswing.components.bootstrap.themes.sbadmin2.SB2DropDownTasks;
import za.co.mmagon.jwebswing.components.bootstrap.themes.sbadmin2.SB2NavbarTop;
import za.co.mmagon.jwebswing.components.bootstrap.themes.sbadmin2.SB2ThemeClasses;
import za.co.mmagon.jwebswing.components.fontawesome.FontAwesome;
import za.co.mmagon.jwebswing.components.fontawesome.FontAwesomeIcons;
import za.co.mmagon.jwebswing.components.fontawesome.FontAwesomeProperties;
import za.co.mmagon.jwebswing.htmlbuilder.css.displays.Displays;

/**
 * The header bar for the home page
 *
 * @author GedMarc
 * @since 21 May 2016
 */
//@CSS(Overflow = Overflows.Hidden, Display = Displays.Inline_flex)
public class HeaderBar extends SB2NavbarTop
{

    private Div leftSide;
    private List rightSide;

    private FontAwesome logoIcon = FontAwesome.icon(FontAwesomeIcons.braille);

    private FontAwesome messageCaretIcon = FontAwesome.icon(FontAwesomeIcons.caret_down);
    private FontAwesome messageToggleIcon = FontAwesome.icon(FontAwesomeIcons.envelope);
    private FontAwesome tasksToggleIcon = new FontAwesome(FontAwesomeIcons.tasks);
    private FontAwesome alertsToggleIcon = FontAwesome.icon(FontAwesomeIcons.bell);
    private FontAwesome userToggleIcon = FontAwesome.icon(FontAwesomeIcons.user);

    private FontAwesome menuButton = FontAwesome.icon(FontAwesomeIcons.list, FontAwesomeProperties.$2x); // responsive button
    private HomePage homePage;

    public HeaderBar()
    {
        super();
        setID("HeaderBar");
        leftSide = new Div();
        leftSide.getCss().getDisplay().setDisplay(Displays.Inline_flex);
        rightSide = new List(false);

        Bold header = new Bold("Armin Easy Software");
        header.addClass(SB2ThemeClasses.Navbar_Brand);
        //logoIcon.addClass(SB2ThemeClasses.Navbar_Brand);
        logoIcon.addClass("fa-5x");
        //leftSide.add(logoIcon);

        //leftSide.add(FontAwesome.icon(FontAwesomeIcons.list, FontAwesomeProperties.$2x,FontAwesomeProperties.fw));
        Link p = new Link("#");
        menuButton = FontAwesome.icon(FontAwesomeIcons.list, FontAwesomeProperties.$2x);
        //menuButton.setText("&nbsp;&nbsp;Armin Easy Homepage");

        menuButton.addClass(SB2ThemeClasses.Navbar_Brand);
        menuButton.addClass("btn-primary");
        menuButton.addClass("hidden-md hidden-lg hidden-sm");
        //p.add(header);

        //leftSide.add(header);
        p.add(menuButton);
        p.add(header);
        leftSide.add(p);
        //leftSide.add(header);

        SB2DropDown messages = getMessagesDropDown();
        rightSide.add(messages);
        rightSide.add(getTasksDropDown());
        rightSide.add(getAlertsDropDown());
        rightSide.add(getUserDropDown());

        setLeftHeader(leftSide);
        setRightHeader(rightSide);
    }

    public HomePage getHomePage()
    {
        return homePage;
    }

    public void setHomePage(HomePage homePage)
    {
        this.homePage = homePage;
        if (this.homePage != null)
        {
            this.homePage.getLayout().getWest().addPin(menuButton);
        }
    }

    private SB2DropDown getMessagesDropDown()
    {
        SB2DropDownMessages messages = null;
        try
        {
            messages = SB2DropDownMessages.fromUrl(JsonLocator.class.getResource("messages.json"));

        }
        catch (IOException ex)
        {
            Logger.getLogger(HeaderBar.class.getName()).log(Level.SEVERE, null, ex);
        }

        messages.addDivider();

        ListItem readAll = new ListItem();
        Link readAllLink = new Link("#");
        readAllLink.addClass("text-center");
        readAllLink.add(new Bold("Read All Messages"));
        readAllLink.add(FontAwesome.icon(FontAwesomeIcons.angle_right));

        readAll.add(readAllLink);
        messages.getDropDownContents().add(readAll);

        Link messagesLink = new Link("#");
        messageToggleIcon.addClass("fa-fw");
        messagesLink.add(messageToggleIcon);
        messagesLink.add(messageCaretIcon);
        messages.setDropDownComponent(messagesLink);

        return messages;
    }

    private SB2DropDown getTasksDropDown()
    {
        SB2DropDownTasks messages = null;
        try
        {
            messages = SB2DropDownTasks.fromUrl(JsonLocator.class.getResource("tasks.json"));

        }
        catch (IOException ex)
        {
            Logger.getLogger(HeaderBar.class.getName()).log(Level.SEVERE, null, ex);
        }

        ListItem readAll = new ListItem();
        Link readAllLink = new Link("#");
        readAllLink.addClass("text-center");
        readAllLink.add(new Bold("View All Tasks"));
        readAllLink.add(new FontAwesome(FontAwesomeIcons.angle_right));

        readAll.add(readAllLink);
        messages.getDropDownContents().add(readAll);

        Link messagesLink = new Link("#");
        messageToggleIcon.addClass("fa-fw");
        messagesLink.add(tasksToggleIcon);
        messagesLink.add(messageCaretIcon);
        messages.setDropDownComponent(messagesLink);

        return messages;
    }

    private SB2DropDown getAlertsDropDown()
    {
        SB2DropDownAlerts messages = null;
        try
        {
            messages = SB2DropDownAlerts.fromUrl(JsonLocator.class.getResource("alerts.json"));

        }
        catch (IOException ex)
        {
            Logger.getLogger(HeaderBar.class.getName()).log(Level.SEVERE, null, ex);
        }

        ListItem readAll = new ListItem();
        Link readAllLink = new Link("#");
        readAllLink.addClass("text-center");
        readAllLink.add(new Bold("View All Alerts"));
        readAllLink.add(FontAwesome.icon(FontAwesomeIcons.angle_right));

        readAll.add(readAllLink);
        messages.getDropDownContents().add(readAll);

        Link messagesLink = new Link("#");
        messageToggleIcon.addClass("fa-fw");
        messagesLink.add(alertsToggleIcon);
        messagesLink.add(messageCaretIcon);
        messages.setDropDownComponent(messagesLink);

        return messages;
    }

    private SB2DropDown getUserDropDown()
    {
        SB2DropDown messages = new SB2DropDown();
        Link messagesLink = new Link("#");

        messageToggleIcon.addClass("fa-fw");
        messagesLink.add(userToggleIcon);
        messagesLink.add(messageCaretIcon);
        messages.setDropDownComponent(messagesLink);

        List allMessages = new List(false);

        ListItem userProfile = new ListItem();
        FontAwesome ico1;
        //userProfile.add(ico1 = FontAwesome.icon(FontAwesomeIcons.user));
        userProfile.add("User Profile");

        ListItem userProfile2 = new ListItem();
        FontAwesome ico2;
        //userProfile.add(ico2 = FontAwesome.icon(FontAwesomeIcons.user));
        userProfile2.add("Logout");

        ListItem userProfile3 = new ListItem();

        Span sp = new Span();
        sp.setText("Login");
        FontAwesome ico3;
        userProfile.add(ico3 = FontAwesome.icon(FontAwesomeIcons.user));

        userProfile2.add(sp);

        allMessages.add(userProfile);
        allMessages.add(userProfile2);
        messages.setDropDownContents(allMessages);

        //messages.addDivider();
        allMessages.add(userProfile3);

        return messages;
    }
}
