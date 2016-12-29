package com.armineasy.homepage.components.welcomepage;

import za.co.mmagon.jwebswing.components.fontawesome.FontAwesome;
import za.co.mmagon.jwebswing.components.fontawesome.FontAwesomeIcons;
import za.co.mmagon.jwebswing.components.bootstrap.BSRow;
import za.co.mmagon.jwebswing.components.bootstrap.panel.BSPanelThemes;
import za.co.mmagon.jwebswing.components.bootstrap.themes.sbadmin2.SB2LargeTile;

/**
 *
 * @author GedMarc
 * @since Oct 29, 2016
 * @version 1.0
 * 
 */
public class DashboardTileRow extends BSRow
{

    public DashboardTileRow ()
    {
        SB2LargeTile tile = new SB2LargeTile(FontAwesomeIcons.comments, "3", "New Frameworks", null);
        tile.getPanel().setTheme(BSPanelThemes.Yellow);
        tile.setFooterText("View All Frameworks");
        tile.setFooterGoIcon(FontAwesome.icon(FontAwesomeIcons.arrow_circle_o_right));

        SB2LargeTile tile2 = new SB2LargeTile(FontAwesomeIcons.tasks, "18", "New Tasks", null);
        tile2.getPanel().setTheme(BSPanelThemes.Green);
        tile2.setFooterText("View All Tasks");
        tile2.setFooterGoIcon(FontAwesome.icon(FontAwesomeIcons.arrow_circle_o_right));

        SB2LargeTile tile3 = new SB2LargeTile(FontAwesomeIcons.shopping_cart, "60", "Open Requests", null);
        tile3.getPanel().setTheme(BSPanelThemes.Primary);
        tile3.setFooterText("View All Requests");
        tile3.setFooterGoIcon(FontAwesome.icon(FontAwesomeIcons.arrow_circle_o_right));

        SB2LargeTile tile4 = new SB2LargeTile(FontAwesomeIcons.support, "80", "New Bugs Logged", null);
        tile4.getPanel().setTheme(BSPanelThemes.Red);
        tile4.setFooterText("View All Bugs");
        tile4.setFooterGoIcon(FontAwesome.icon(FontAwesomeIcons.arrow_circle_o_right));

        add(tile);
        add(tile2);
        add(tile3);
        add(tile4);
    }
}
