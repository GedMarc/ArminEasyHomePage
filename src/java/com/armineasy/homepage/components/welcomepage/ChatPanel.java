package com.armineasy.homepage.components.welcomepage;

import com.armineasy.homepage.GeneralComponentFactory;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.components.fontawesome.FontAwesome;
import za.co.mmagon.jwebswing.components.fontawesome.FontAwesomeIcons;
import za.co.mmagon.jwebswing.components.bootstrap.themes.sbadmin2.chat.SB2ChatLeftMessage;
import za.co.mmagon.jwebswing.components.bootstrap.themes.sbadmin2.chat.SB2ChatPanel;
import za.co.mmagon.jwebswing.components.bootstrap.themes.sbadmin2.chat.SB2ChatRightMessage;

/**
 *
 * @author GedMarc
 * @since Oct 29, 2016
 * @version 1.0
 * 
 */
public class ChatPanel extends SB2ChatPanel
{

    public ChatPanel ()
    {
        super(FontAwesomeIcons.comments, "Chat Panel <i class=\"hidden-sm hidden-xs\"><small>(SB2 Chat Panel)</small></i>");
        getChatList().add(new SB2ChatLeftMessage());
        getChatList().add(new SB2ChatRightMessage());
        getChatList().add(new SB2ChatLeftMessage());
        getChatList().add(new SB2ChatRightMessage());
        
        //getPanelHeaderButtonBar().add(this);

        Div d = new Div();
        d.add("Hope this works");
        addDropDownToHeaderButtonBar(FontAwesome.icon(FontAwesomeIcons.cog), d);
    }
    
    //Home page variable must be referenced after the enum constructor
    @Override
    public void init()
    {
        if (!isInitialized())
        {
            getPanelHeaderButtonBar().add(GeneralComponentFactory.getSmallSourceCodeButton(ChatPanel.class));
        }
        super.init();
    }
    
}
