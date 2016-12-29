package com.armineasy.homepage.components.welcomepage;

import com.armineasy.homepage.GeneralComponentFactory;
import za.co.mmagon.jwebswing.base.html.H2;
import za.co.mmagon.jwebswing.base.html.ListItem;
import za.co.mmagon.jwebswing.base.html.Span;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.components.bootstrap.panel.BSPanelDefault;
import za.co.mmagon.jwebswing.components.fontawesome.FontAwesome;
import za.co.mmagon.jwebswing.components.fontawesome.FontAwesomeIcons;
import za.co.mmagon.jwebswing.components.fontawesome.FontAwesomeProperties;
import za.co.mmagon.jwebswing.components.verticaltimeline.VerticalTimeline;
import za.co.mmagon.jwebswing.components.verticaltimeline.VerticalTimelineBlock;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourCSSImpl;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourNames;
import za.co.mmagon.jwebswing.utilities.StringConstants;

/**
 *
 * @author GedMarc
 * @since Oct 30, 2016
 * @version 1.0
 *
 */
public class Timeline extends BSPanelDefault
{

    public Timeline()
    {
        super(FontAwesomeIcons.clock_o, "Timeline <i class=\"hidden-sm hidden-xs\"><small>(Vertical Timeline)</small></i>");
        addAttribute(GlobalAttributes.Style, "background:#e9f0f5");
        getCss().getBackground().setBackgroundColor(new ColourCSSImpl("#e9f0f5"));
        VerticalTimeline vt = new VerticalTimeline();
        VerticalTimelineBlock vtb = new VerticalTimelineBlock();
        vtb.getImageContainer().setID("vtbImageID");
        vtb.getImageContainer().add(FontAwesome.icon(FontAwesomeIcons.cog, FontAwesomeProperties.$2x));
        /* vtb.getImageContainer().addAttribute(GlobalAttributes.Style, "align-content: center;width: 60px;height: 60px;"
                + "text-align: center;line-height: 70px;"
                + "background:darkgreen;color:white;");*/
        vtb.getImageContainer().addAttribute(GlobalAttributes.Style, "background:#e9f0f5");
        vtb.getImageContainer().getCss().getBackground().setBackgroundColor$(ColourNames.DarkGreen);
        vtb.getContent().setID("content");
        vtb.getContent().setHeader(new H2("header text"));
        vtb.getContent().setText(StringConstants.mediumLatin);
        vtb.getContent().setSpanText(new Span("span text"));
        vtb.getContent().getReadMoreLink().setText("Read More");

        vt.add(vtb);

        getPanelBody().add(vt);

        ListItem d = new ListItem();
        d.add("Hope this works");
        addDropDownToHeaderButtonBar(FontAwesome.icon(FontAwesomeIcons.cog), d);
    }

    @Override
    public void init()
    {
        if (!isInitialized())
        {
            getPanelHeaderButtonBar().add(GeneralComponentFactory.getSmallSourceCodeButton(Timeline.class));
        }
        super.init();
    }
}
