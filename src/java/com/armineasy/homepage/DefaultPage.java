package com.armineasy.homepage;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSSImpl;

/**
 *
 * @author GedMarc
 * @since Oct 3, 2016
 * @version 1.0
 *
 */
public class DefaultPage extends Div
{

    private static final long serialVersionUID = 1L;

    public DefaultPage()
    {
        getCss().getPadding().setPaddingLeft(new MeasurementCSSImpl(15));
        getCss().getPadding().setPaddingTop(new MeasurementCSSImpl(15));
        getCss().getPadding().setPaddingRight(new MeasurementCSSImpl(15));
    }
}
