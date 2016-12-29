package com.armineasy.homepage.components.welcomepage;

import com.armineasy.homepage.DefaultPage;
import za.co.mmagon.jwebswing.components.bootstrap.BSColumn;
import za.co.mmagon.jwebswing.components.bootstrap.BSRow;
import za.co.mmagon.jwebswing.components.bootstrap.columnlayout.BSColumnWidths;
import za.co.mmagon.jwebswing.components.bootstrap.columnlayout.BSContainer;
import za.co.mmagon.jwebswing.components.bootstrap.columnlayout.BSContainerType;
import za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds.BackgroundCSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourNames;

@BackgroundCSS(BackgroundColor$ = ColourNames.White)
public class WelcomePage extends DefaultPage
{

    private static final long serialVersionUID = 1L;
    private BSColumn col1;
    private LatestSlider slider;

    public WelcomePage()
    {
        BSContainer container = BSContainer.newInstance(BSContainerType.Container_Fluid);
        BSRow row = new BSRow();

        container.add(new DashboardTileRow());

        col1 = BSColumn.newInstance(BSColumnWidths.col_xs_7);
        BSColumn col2 = BSColumn.newInstance(BSColumnWidths.col_xs_5);

        row.add(col1);
        row.add(col2);

        col1.add(slider = new LatestSlider());
        col1.add(new Timeline());

        col2.add(new FrameworksListPanel());
        col2.add(new ChatPanel());

        container.add(row);
        add(container);
    }

    public LatestSlider getSlider()
    {
        return slider;
    }

    public void setSlider(LatestSlider slider)
    {
        this.slider = slider;
    }

}
