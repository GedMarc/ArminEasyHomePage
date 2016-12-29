package com.armineasy.homepage.components;

import com.armineasy.homepage.base.HeaderBar;
import com.armineasy.homepage.base.WestBar;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;

/**
 *
 * @author GedMarc
 * @since Oct 3, 2016
 * 
 */
public enum LayoutScreens 
{
    WestBar(new WestBar()),
    HeaderBar(new HeaderBar())
    ;
    
    private ComponentHierarchyBase comp;
    ;
    private LayoutScreens(ComponentHierarchyBase comp)
    {
        this.comp = comp;
    }
    
      public ComponentHierarchyBase getComponent() {
        return comp;
    }

    public void setComponent(ComponentHierarchyBase component) {
        this.comp = component;
    }
    
}
