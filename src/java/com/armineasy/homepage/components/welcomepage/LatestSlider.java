package com.armineasy.homepage.components.welcomepage;

import com.armineasy.homepage.GeneralComponentFactory;
import com.armineasy.homepage.HomePage;
import za.co.mmagon.jwebswing.base.html.ListItem;
import za.co.mmagon.jwebswing.components.fontawesome.FontAwesome;
import za.co.mmagon.jwebswing.components.fontawesome.FontAwesomeIcons;
import za.co.mmagon.jwebswing.components.bootstrap.panel.BSPanelDefault;
import za.co.mmagon.jwebswing.components.radialsvgslider.RadialSVGSlider;
import za.co.mmagon.jwebswing.components.radialsvgslider.RadialSVGSliderListItem;

public class LatestSlider extends BSPanelDefault
{

    private HomePage homePage;

    private String face1Header = "MDP";
    private String face1Text = "Multi-Dimensional Programming"
            + "<br/>The dynamic construction of two or more languages"
            + "</br>for delivery to multiple devices and clients"
            + "<br/>from within a single platform"
            + "<br/>";

    private String face2Header = "Advantages of MDP";
    private String face2Text = "Single Class Implementations"
            + "<br/>Reduce Boiler-Plate"
            + "<br/>Component Designs"
            + "<br/>Write Once Use Everywhere"
            + "<br/>Keep it Simple Stupid";

    private String face3Header = "Runs On";
    private String face3Text = "Web <small><i>(Opera/Safari/Mozilla/IE)</i></small>"
            + "<br/>Mobile <small><i>(Android/Apple/Microsoft/Symbian)</i></small>"
            + "<br/>Desktop <small><i>(Windows/Linux/Apple)</i></small>"
            + "<br/><small><i>Uses Cordova/PhoneGap for certain features</i></small>"
            + "<br/><hr/>Completely Customizable In Every Way";
    
    private String face4Header = "JWebSwing";
    private String face4Text = "You will never need another web framework"
            + "<br/>Always Up-To-Date"
            + "<br/>Always Adding New Components"
            + "<br/>Always Enterprise Ready";

    public LatestSlider()
    {
        super(FontAwesomeIcons.newspaper_o, "Latest News <i class=\"hidden-sm hidden-xs\"><small>(Radial SVG Slider)</small></i>");

        RadialSVGSlider newSlider = new RadialSVGSlider();

        RadialSVGSliderListItem face1 = newSlider.addFace(RadialSVGSliderListItem.createDefaultSlide(face1Header, face1Text, "#", "Learn More"));
        face1.setFaceBackgroundImageUrl("bower_components/radial-svg-slider-jwebswing/img/img-1.jpg");
        RadialSVGSliderListItem face2 = newSlider.addFace(RadialSVGSliderListItem.createDefaultSlide(face2Header, face2Text, "#", "Learn More"));
        face2.setFaceBackgroundImageUrl("bower_components/radial-svg-slider-jwebswing/img/img-2.jpg");
        RadialSVGSliderListItem face3 = newSlider.addFace(RadialSVGSliderListItem.createDefaultSlide(face3Header, face3Text, "#", "Learn More"));
        face3.setFaceBackgroundImageUrl("bower_components/radial-svg-slider-jwebswing/img/img-3.jpg");
        RadialSVGSliderListItem face4 = newSlider.addFace(RadialSVGSliderListItem.createDefaultSlide(face4Header, face4Text, "#", "Learn More"));
        face4.setFaceBackgroundImageUrl("bower_components/radial-svg-slider-jwebswing/img/img-1.jpg");

        getPanelBody().add(newSlider);

        ListItem d = new ListItem();
        d.setText("Hope this works");

        addDropDownToHeaderButtonBar(FontAwesome.icon(FontAwesomeIcons.cog), d);
    }

    //Home page variable must be referenced after the enum constructor
    @Override
    public void init()
    {
        if (!isInitialized())
        {
            getPanelHeaderButtonBar().add(GeneralComponentFactory.getSmallSourceCodeButton(LatestSlider.class));
        }
        super.init();
    }

    public HomePage getHomePage()
    {
        return homePage;
    }

    public void setHomePage(HomePage homePage)
    {
        this.homePage = homePage;
    }
}
