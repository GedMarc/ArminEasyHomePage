package com.armineasy.homepage;

import com.armineasy.homepage.base.WestBar;
import com.armineasy.homepage.components.DisplayScreens;
import com.armineasy.homepage.components.LayoutScreens;
import com.armineasy.homepage.components.welcomepage.WelcomePage;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponseReaction;
import za.co.mmagon.jwebswing.base.html.Body;
import za.co.mmagon.jwebswing.base.html.Button;
import za.co.mmagon.jwebswing.base.html.H4;
import za.co.mmagon.jwebswing.base.html.Span;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.components.bootstrap.BootstrapSize;
import za.co.mmagon.jwebswing.components.bootstrap.modal.BSModal;
import za.co.mmagon.jwebswing.components.bootstrap.themes.SB2Theme;
import za.co.mmagon.jwebswing.components.dynamicsourcecode.DynamicSourceCode;
import za.co.mmagon.jwebswing.components.fontawesome.FontAwesome;
import za.co.mmagon.jwebswing.components.fontawesome.FontAwesomeIcons;
import za.co.mmagon.jwebswing.components.google.sourceprettify.SourceCodePrettifyThemes;
import za.co.mmagon.jwebswing.components.jquerylayout.layout.JQLayout;
import za.co.mmagon.jwebswing.components.pace.PaceThemeColour;
import za.co.mmagon.jwebswing.htmlbuilder.css.displays.Overflows;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementPercentages;
import za.co.mmagon.jwebswing.htmlbuilder.css.text.TextAlignments;
import za.co.mmagon.jwebswing.utilities.StringConstants;

public class HomePage extends Page
{

    private static final long serialVersionUID = 1L;
    private final Body homeBody;
    private final DisplayScreens defaultScreen = DisplayScreens.WelcomeScreen;
    private final DynamicSourceCode sourceViewer = new DynamicSourceCode();
    private final HomePage me = this;

    public HomePage()
    {
        GeneralComponentFactory.setHomePage(this);
        getPageFields().setTitle("Armin Easy Software brought to you by Marc Magon");
        getPageFields().setAuthor("Marc Magon");
        getPageFields().setDescription("The Landing Page for Armin Easy Soft");
        getPageFields().setKeywords("JWebSwing,Java,Web,Development");
        getOptions().setModernizrEnabled(true);
        getOptions().setAngularEnabled(true);
        getOptions().setPaceEnabled(true);

        this.homeBody = getBody();
        getBody().getPace().getTheme().setThemeColour(PaceThemeColour.Blue);
        homeBody.addTheme(new SB2Theme());

        WestBar.class.cast(LayoutScreens.WestBar.getComponent()).setHomePage(this);
        WelcomePage.class.cast(DisplayScreens.WelcomeScreen.getComponent()).getSlider().setHomePage(this);

        configureBody();
        configureNorth();
        configureSouth();
        configureWest();
        configureCenter();

        //TODO find out why not auto placing
        //getAngular().getModules().add(new MomentAngularModule(me));
        
        getBody().add(getSourceCodeModal());
    }

    private JQLayout layout;

    private void configureBody()
    {
        layout = new JQLayout(homeBody);
        layout.getOptions().getDefaults().setResizable(false);
        layout.getOptions().getDefaults().setSlidable(false);
        layout.getOptions().getDefaults().setClosable(false);
        layout.getOptions().getDefaults().setTogglerLength_open(0);
        layout.getOptions().getDefaults().setTogglerLength_closed(0);
        layout.getOptions().getDefaults().setSpacing_closed(5);
        layout.getOptions().getDefaults().setSpacing_open(5);
    }

    private void configureNorth()
    {
        layout.getNorth().getContentDiv().add(LayoutScreens.HeaderBar.getComponent());
        layout.getNorth().getOptions().setSize(50);
    }

    private void configureWest()
    {
        layout.getWest().getContentDiv().add(LayoutScreens.WestBar.getComponent());
        layout.getOptions().getWest().setResponsive(true);
        layout.getOptions().getWest().setResponsiveWhen(BootstrapSize.Large);
        layout.getWest().getOptions().setSize(350);
    }

    private String footerText = ""
            + "<a href=\"#\">Source Code</a>"
            + " &#8226; <a href=\"#\">Download JWebSwing</a>"
            + " &#8226; <a href=\"#\">View JWebSwing API</a> ";

    private void configureSouth()
    {
        layout.getSouth().getContentDiv().getCss().getDimensions().setWidth(MeasurementPercentages.hundredPercent);
        H4 footerLeft = new H4("<a href=\"https://blackrockdigital.github.io/startbootstrap-sb-admin-2/pages/index.html\" target=\"_blank\">Based on the SB2 Admin Theme</a>");
        footerLeft.addClass("col-md-3");
        H4 footer = new H4(footerText);
        footer.addClass("col-md-6");
        footer.getCss().getText().setTextAlign(TextAlignments.Center);

        layout.getSouth().getContentDiv().add(footerLeft);
        layout.getSouth().getContentDiv().add(footer);

        H4 footerRight = new H4("<a href=\"#\">Donate!</a>");
        footerRight.getCss().getText().setTextAlign(TextAlignments.Right);
        footerRight.addClass("col-md-3");

        layout.getSouth().getContentDiv().add(footerRight);
    }

    private void configureCenter()
    {
        changeScreen(defaultScreen, null);
    }

    public void changeScreen(DisplayScreens newScreen, AjaxResponse ajaxResponse)
    {
        newScreen.getComponent().setID("updateDiv");
        newScreen.getComponent().addAttribute(GlobalAttributes.Style, ";width:100%;height:100%;");
        newScreen.getComponent().getCss().getDisplay().setOverflow(Overflows.Auto);
        layout.getCenter().getContentDiv().getChildren().clear();
        if (layout.getCenter().getContentDiv().getChildren().isEmpty())
        {
            layout.getCenter().getContentDiv().add(defaultScreen.getComponent());
        }
        if (ajaxResponse != null)
        {
            ajaxResponse.addComponent(newScreen.getComponent());
            ajaxResponse.addReaction(new AjaxResponseReaction("Yay", "done"));
        }
    }

    public final BSModal getSourceCodeModal()
    {
        BSModal mod = new BSModal();
        mod.addClass("col-md-offset-1 col-md-10");
        mod.getModalHeader().add(FontAwesome.icon(FontAwesomeIcons.ambulance));

        Span sp = new Span("Source Code Viewer");
        mod.getModalHeader().add(sp);
        //sp.addClass("class-md-3");
        mod.setID("sourceModal");

        Span themeSwitcherDiv = new Span();
        //themeSwitcherDiv.addClass("col-md-6");
        for (SourceCodePrettifyThemes theme : SourceCodePrettifyThemes.values())
        {
            Button b = new Button(theme.name());
            b.addClass("btn btn-md btn-default");
            sourceViewer.addThemeChanger(b, theme);;
            themeSwitcherDiv.add(b);
        }
        //    mod.getModalHeader().add(themeSwitcherDiv);

        Button closeButton = new Button(StringConstants.times);
        mod.getModalHeader().add(closeButton);
        sourceViewer.getCss().getDimensions().setMaxHeight(600);
        mod.getModalBody().add(sourceViewer);
        mod.addDismissButton(closeButton);

        return mod;
    }

    public JQLayout getLayout()
    {
        return layout;
    }

    public void setLayout(JQLayout layout)
    {
        this.layout = layout;
    }

    public DynamicSourceCode getSourceViewer()
    {
        return sourceViewer;
    }

}
