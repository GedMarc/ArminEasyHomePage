package com.armineasy.homepage.base;

import com.armineasy.homepage.HomePage;
import com.armineasy.homepage.components.DisplayScreens;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.events.click.ClickAdapter;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.Paragraph;
import za.co.mmagon.jwebswing.components.jqmetro.metro.JQMetroTiles;
import za.co.mmagon.jwebswing.components.jqmetro.metro.enumerations.TileAccentThemes;
import za.co.mmagon.jwebswing.components.jqmetro.metro.enumerations.TileCount;
import za.co.mmagon.jwebswing.components.jqmetro.metro.tiles.FlipTile;
import za.co.mmagon.jwebswing.components.jqmetro.metro.tiles.FlipTileAttributes;
import za.co.mmagon.jwebswing.components.jqmetro.metro.tiles.Tile;
import za.co.mmagon.jwebswing.htmlbuilder.css.displays.Overflows;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSSImpl;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementPercentages;

/**
 *
 * @author GedMarc
 * @since Aug 28, 2016
 * @version 1.0
 *
 */
public class WestBar extends Div
{

    private static final long serialVersionUID = 1L;

    private HomePage homePage;

    public WestBar()
    {
        setID("WestBar");
        getCss().getPadding().setPaddingLeft(new MeasurementCSSImpl(13));
        getCss().getPadding().setPaddingTop(new MeasurementCSSImpl(13));
        getCss().getDisplay().setOverflowY(Overflows.Auto);
        getCss().getDimensions().setWidth(MeasurementPercentages.hundredPercent);
        getCss().getDimensions().setHeight(MeasurementPercentages.hundredPercent);

        AddAllTiles();
    }

    public HomePage getHomePage()
    {
        return homePage;
    }

    public void setHomePage(HomePage homePage)
    {
        this.homePage = homePage;
    }

    private void AddAllTiles()
    {
        JQMetroTiles metroTileSet = new JQMetroTiles(TileAccentThemes.Teal, TileCount.two);
        metroTileSet.add(buildTile("Home", "Introduction to Armin Easy Software", "Learn about what we do", "link", TileAccentThemes.Blue, 100, DisplayScreens.WelcomeScreen));
        metroTileSet.add(buildTile("Projects", "All of our current undertakings", "Redefining the web development experience", "link", TileAccentThemes.Blue, 250, DisplayScreens.WelcomeScreen));
        //metroTileSet.add(buildTile("Builds", "View current builds of our projects", "TeamCity guest access to our current builds", "link", TileAccentThemes.Blue,300,DisplayScreens.WelcomeScreen));

        add(metroTileSet);

        JQMetroTiles metroTileSet2 = new JQMetroTiles(TileAccentThemes.Cobalt, TileCount.two);
        metroTileSet2.add(buildTile("JWebSwing", "Learn about the JWebSwing Framework. Redefine your web design", "Our primary package, open source and free ", "link", TileAccentThemes.Cobalt, 400, DisplayScreens.WelcomeScreen));
        metroTileSet2.add(buildTile("Changing Web Design", "We are changing web design - forever. See how", "Experience true single language development, done right.", "link", TileAccentThemes.Cobalt, 480, DisplayScreens.WelcomeScreen));
        metroTileSet2.add(buildTile("Integrated Frameworks", "All the current integrated frameworks so far", "Extensability to its finest. Any component can be easily integrated", "link", TileAccentThemes.Cobalt, 180, DisplayScreens.WelcomeScreen));
        metroTileSet2.add(buildTile("Interactive Demo", "Jump right into the framework and take a peek", "A fully loaded demo on all the components", "link", TileAccentThemes.Cobalt, 220, DisplayScreens.WelcomeScreen));

        add("<br>");
        add(metroTileSet2);

        JQMetroTiles metroTileSet3 = new JQMetroTiles(TileAccentThemes.Cobalt, TileCount.two);
        metroTileSet3.add(buildTile("Time Lord", "Enterprise Time Manager", "What time and project management should be", "link", TileAccentThemes.Teal, 600, DisplayScreens.WelcomeScreen));
        metroTileSet3.add(buildTile("The Postman", "Enterprise Distribution Manager", "Finally any platform, any format, any device delivery", "link", TileAccentThemes.Teal, 560, DisplayScreens.WelcomeScreen));
        metroTileSet3.add(buildTile("Captains Log", "Enterprise Project Manager", "Face 2", "link", TileAccentThemes.Teal, 500, DisplayScreens.WelcomeScreen));
        metroTileSet3.add(buildTile("Activity Master", "Enterprise Event Management", "Data provided thhrough any means. Integrate into and from anything", "link", TileAccentThemes.Teal, 360, DisplayScreens.WelcomeScreen));

        add("<br>");
        add(metroTileSet3);
    }

    private Tile buildTile(String tileTitle, String paragraphFace1, String paragraphFace2, String url, TileAccentThemes colourName, int speed, DisplayScreens screen)
    {
        FlipTile tile = new FlipTile();
        tile.addAttribute(FlipTileAttributes.speed, speed);
        tile.asTile().setTheme(colourName);
        tile.setID(tileTitle.replace(' ', '_'));

        Div tileFace1 = new Div();
        tileFace1.add(paragraphFace1);

        Div tileFace2 = new Div();
        tileFace2.add(paragraphFace2);

        tile.addFace(tileFace1, new Paragraph(tileTitle));
        tile.addFace(tileFace2, new Paragraph(tileTitle));

        tile.addEvent(new NaviClick(tile, screen));
        return tile;
    }

    public class NaviClick extends ClickAdapter
    {

        private static final long serialVersionUID = 1L;
        private final DisplayScreens screen;

        public NaviClick(ComponentHierarchyBase component, final DisplayScreens displayScreen)
        {
            super(component);
            this.screen = displayScreen;
//            registerReturnVariableName("loginStatus");
            //          registerReturnVariableName("Modernizr");
        }

        @Override
        public void onClick(AjaxCall call, AjaxResponse response)
        {
            getHomePage().changeScreen(screen, response);
        }
    }
}
