/*
 * The MIT License
 *
 * Copyright 2013 Oleg Nenashev <nenashev@synopsys.com>, Synopsys Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.synopsys.arc.jenkinsci.plugins.categorization.categories;

import hudson.DescriptorExtensionList;
import hudson.ExtensionPoint;
import hudson.model.Describable;
import hudson.model.Descriptor;
import hudson.model.Hudson;
import java.io.Serializable;
import jenkins.model.Jenkins;

/**
 * Class provides basic category extension.
 * Extension requirements:
 *    - Provide config.jelly, which allows to setup category
 * @author Oleg Nenashev <nenashev@synopsys.com>, Synopsys Inc.
 */
//TODO: Make describable
public abstract class CategoryType 
    implements Describable<CategoryType>, ICategoryType, ExtensionPoint, Serializable
{ 
    private String name;
    private String description;
    private boolean mandatory;

    public CategoryType(String name, String description, boolean mandatory) {
        this.name = name;
        this.description = description;
        this.mandatory = mandatory;
    }
    
    public final String getName() {
        return name;
    }

    public final String getDescription() {
        return description;
    }

    public final boolean isMandatory() {
        return mandatory;
    }
    
    /**
     * Get list of all registered {@link CategoryExtension}s.
     * @return List of {@link CategoryExtension}s.
     */
    public static DescriptorExtensionList<CategoryType, CategoryTypeDescriptor> all() {
        return Hudson.getInstance().getDescriptorList(CategoryType.class);
    }
    
    @Override
    public CategoryTypeDescriptor getDescriptor() {
        return (CategoryTypeDescriptor) Jenkins.getInstance().getDescriptor(getClass());
    }

    public static abstract class CategoryTypeDescriptor extends Descriptor<CategoryType> {
    }
}
